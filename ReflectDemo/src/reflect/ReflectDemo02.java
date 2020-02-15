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
 * ���䣺
 * 	  ����������ڡ�����״̬���У�
 * 		��������һ���࣬���ܹ�֪���������������Ժͷ�����
 * 		��������һ�����󣬶��ܹ�������������һ�����������ԣ�
 * 	 �����ṩ�Ĺ��ܣ�
 * 		������ʱ�ж�����һ��������������
 * 		������ʱ��������һ����Ķ���
 * 		������ʱ�ж�����һ�������еĳ�Ա�����ͷ���
 * 		������ʱ��������һ������ķ���
 * 		���ɶ�̬����	
 * 	 ��ȡ������ڵ����ַ�����1.Class.forName("ȫ����")��2.����.class();3.����.getClass();
 * 		
 */
//ͨ�������ȡ����ʵ�������в���
//��ȡ����
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
	//��������	
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
		//���ʵ���private���ε�id,����private��˽�е�
		//�޸����Եķ���Ȩ��  ʹ�÷���ʱ�������Ϊ�������η���������쳣������ͨ��field.setAccessible(true)����
		System.out.println("===========");
		Method method = perClazz1.getDeclaredMethod("myName");
		Object instance2 = perClazz1.newInstance();
		Person per2 = (Person)instance2;
		
		method.setAccessible(true);
		method.invoke(per2);
		
	}
	//�������캯��
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
	
	//��̬���������ͷ���
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
	
	//�������Խ������Լ�����
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
