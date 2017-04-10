package java.basic.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnoTest {

	public static void main(String[] args) {
		//1.使用类加载器加载类
		try {
			Class c = Class.forName("com.ann.Child");
			//2.找到类上面的注解
			boolean isExist = c.isAnnotationPresent(Description.class);
			if (isExist) {
				//3.注解实例
				Description d = (Description) c.getAnnotation(Description.class);
				System.out.println(d.value());
			}
			
			//4.找到方法上的注解
			Method[] ms = c.getMethods();
			for (Method method : ms) {
				boolean isMExist = method.isAnnotationPresent(Description.class);
				if (isMExist) {
					Description d = method.getAnnotation(Description.class);
					System.out.println(d.value());
				}
			}
			
			//另外一种解析
			for (Method method : ms) {
				Annotation[] as = method.getAnnotations();
				for (Annotation annotation : as) {
					Description d = (Description) annotation;
					System.out.println(d.value());
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
