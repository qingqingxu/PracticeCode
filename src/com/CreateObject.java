package com;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CreateObject {

	public static void main(String[] args) {
		Temp temp = new Temp();
		System.out.println(temp.getClass().getName());
		
		//实例化Class类对象
		try {
			Class<?> class1 = Class.forName("com.Temp");
			Class<?> class2 = temp.getClass();
			Class<?> class3 = Temp.class;
			System.out.println(class1.getName());
			System.out.println(class2.getName());
			System.out.println(class3.getName());
			
			Class<?> parentClass = class1.getSuperclass();
			System.out.println(parentClass.getName());
			
			Class<?> interfaces[] = class1.getInterfaces();
			for (Class<?> class4 : interfaces) {
				System.out.println(class4.getName());
			}
			
			Constructor<?> cons[] = class1.getConstructors();
			for (Constructor<?> constructor : cons) {
				Class<?> parameterType[] = constructor.getParameterTypes();
				System.out.println(parameterType.length);
				for (Class<?> class4 : parameterType) {
					System.out.println(class4.getName());
				}
			}
			
			//返回所有声明的属性
			Field[] fields = class2.getDeclaredFields();
			System.out.println(fields.length);
			for (Field field : fields) {
				System.out.println(field.getName());
			}
			
			//返回声明的方法
			Method[] methods = class1.getMethods();
			for (Method method : methods) {
				System.out.println(method.getName());
			}
			
			//通过反射机制调用某个类的方法
			try {
				Method method = class1.getMethod("pp", null);
				try {
					method.invoke(class1.newInstance(), null);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//通过反射机制操作某个类的属性
			Object obj;
			try {
				obj = class1.newInstance();
				Field field;
				try {
					field = class1.getDeclaredField("i");
					field.setAccessible(true);
					field.set(obj, 1);
					System.out.println(field.get(obj));
				} catch (NoSuchFieldException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//动态代理
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

interface Inter{
	public void pp();
}

class Temp implements Inter{
	private int i;

	private int x;
	
	int y;
	
	public Temp(int i) {
		this.i = i;
	}

	public Temp() {
		// TODO Auto-generated constructor stub
	}

	public void print(){
		System.out.println("Temp");
	}
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public void pp() {
		// TODO Auto-generated method stub
		System.out.println("pp");
	}
	
}
