package reflect;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

/*
 * 反射：
 * 	  反射机制是在【运行状态】中；
 * 		对于任意一个类，都能够知道这个类的所有属性和方法；
 * 		对于任意一个对象，都能够调用它的任意一个方法和属性；
 * 	 反射提供的功能：
 * 		在运行时判断任意一个对象所属的类
 * 		在运行时构造任意一个类的对象
 * 		在运行时判断任意一个类多具有的成员变量和方法
 * 		在运行时调用任意一个对象的方法
 * 		生成动态代理	
 * 	 获取反射入口的三种方法：1.Class.forName("全类名")；2.类名.class();3.对象.getClass();
 * 		
 */
//通过反射获取对象实例并进行操作
//获取属性
public class ReflectDemo02 {
	public static void demo01() throws InstantiationException, IllegalAccessException {
		Class<?> perClazz1 = null;
		try {
			perClazz1 = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object instance = perClazz1.newInstance();
		Person per = (Person)instance;
		per.setAge(23);
		per.setName("zs");
		System.out.println(per.getName()+"----"+per.getAge());
	}
	//操作属性	
	public static void demo02() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		Class<?> perClazz1 = null;
		try {
			perClazz1 = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object instance = perClazz1.newInstance();
		Person per= (Person)instance;
		Field field = perClazz1.getDeclaredField("name");
		field.setAccessible(true);
		field.set(per, "ls");
		System.out.println(per.getName());
		//访问的是private修饰的id,但是private是私有的
		//修改属性的访问权限  使用反射时，如果因为访问修饰符限制造成异常，可以通过field.setAccessible(true)设置
		System.out.println("===========");
		Method method = perClazz1.getDeclaredMethod("myName");
		Object instance2 = perClazz1.newInstance();
		Person per2 = (Person)instance2;
		
		method.setAccessible(true);
		method.invoke(per2);
		
	}
	//操作构造函数
	public static void demo03() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		Class<?> perClazz1 = null;
		try {
			perClazz1 = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   Constructor<?>[] constructors = perClazz1.getConstructors();
			for (Constructor constructor:constructors) {
				System.out.println(constructor);
			}
			System.out.println("===============");
			Constructor<?> constructor = perClazz1.getDeclaredConstructor();
			System.out.println(constructor);
			
			System.out.println("-----------------");
			Constructor<?> constructor2 = perClazz1.getConstructor(int.class);
			System.out.println(constructor2);
		
	}
	
	//动态加载类名和方法
	public static void demo04() throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Properties prop = new Properties();
		FileReader fileReader = new FileReader("class.txt");
		prop.load(fileReader);
		String classname = prop.getProperty("classname");
		String methodname = prop.getProperty("methodname");  
		Class<?> perClazz1 = null;
		try {
			perClazz1 = Class.forName(classname);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object instance = perClazz1.newInstance();
		Method method = perClazz1.getMethod(methodname);
		method.invoke(instance);
		
	}
	
	//反射可以越过泛型约束检查
	public static void demo05() throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		ArrayList<Integer> list = new ArrayList();
		list.add(123);
		list.add(3);
		Class<?> class1 = list.getClass();
		Method method = class1.getMethod("add",Object.class);
		method.invoke(list, "zs");
		System.out.println(list);
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, IOException {
//		demo01();
//		demo02();
//		demo03();
//		demo04();
		demo05();
	}
}
