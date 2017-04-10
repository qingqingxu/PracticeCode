package java.basic.annotation.project;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {
		Filter f1 = new Filter();
		f1.setId(10);
		
		Filter f2 = new Filter();
		f2.setUserName("Lucy");
		f2.setCity("ZH");
		
		Filter f3 = new Filter();
		f3.setEmail("liu@sina.com,zh@163.com,777777@qq.com");
		
		String sql1 = query(f1);
		String sql2 = query(f2);
		String sql3 = query(f3);
		
		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql3);
		
		Filter2 address = new Filter2();
		address.setId(3);
		address.setAddress("MY");
		System.out.println(query(address));
		
	}
	
	private static String query(Object f){
		Class c = f.getClass();
		StringBuffer sb = new StringBuffer();
		boolean isExist = c.isAnnotationPresent(Table.class);
		if (isExist) {
			Table table = (Table) c.getAnnotation(Table.class);
			sb.append("select * from ").append(table.value()).append(" where 1=1");
			Field[] fields = c.getDeclaredFields();
			for (Field field : fields) {
				boolean isFExist = field.isAnnotationPresent(Column.class);
				if (!isFExist) {
					continue;
				}
				Column column = field.getAnnotation(Column.class);
				String columnName = column.value();
				String filedName = field.getName();
				String getMethodName = "get" + filedName.substring(0, 1).toUpperCase()+filedName.substring(1);
				try {
					Method method = c.getMethod(getMethodName);
					Object fieldValue = method.invoke(f);
					if (fieldValue==null||(fieldValue instanceof Integer && (Integer)fieldValue==0)) {
						continue;
					}
					sb.append(" and ").append(columnName);
					if (fieldValue instanceof String) {
						String new_name = (String) fieldValue;
						if (new_name.contains(",")) {
							String[] strs = new_name.split(",");
							sb.append(" in(");
							for (String string : strs) {
								sb.append("'").append(string).append("'").append(",");
							}
							sb.deleteCharAt(sb.length()-1);
							sb.append(")");
						} else {
							sb.append("=").append("'").append(fieldValue).append("'");
						}
					}else if (fieldValue instanceof Integer) {
						sb.append("=").append(fieldValue);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
		return sb.toString();
	}

}
