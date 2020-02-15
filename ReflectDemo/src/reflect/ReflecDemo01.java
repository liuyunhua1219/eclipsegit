package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*���䣺
 * ����C�����ڡ��\�Р�B���У�
 * 			�������һ������܉�֪���@������Ќ��Ժͷ���
 * 			�������һ�����󣬶��܉��{����������һ�������͌���
 * �����ṩ�Ĺ��ܣ�
 * 			���\�Еr�Д�����һ���������ٵ��
 * 			���\�Еr��������һ��Č���
 * 			���\�Еr�Д�����һ��������еĳɆT׃���ͷ���
 * 			���\�Еr�{������һ������ķ���
 * 			���ɄӑB����
 * �@ȡ������ڵ����N������1.Class.forName(); 2.XX.class ; 3.����.getClass()
*/
public class ReflecDemo01 {
	public static void demo01() {

		//1.Class.forName
		try {
			Class<?> perClazz = Class.forName("reflect.Person");
			System.out.println(perClazz);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.���.class
		Class<?> perClazz2 =Person.class;
		System.out.println(perClazz2);
		//3.����.getClass()
		Person per = new Person();
		Class<?> perClass3 = per.getClass();
		System.out.println(perClass3);
	}
	//�@ȡ����	
	public static void demo02() {
		try {
			Class<?> perClazz = Class.forName("reflect.Person");
			//�@ȡ���еĹ����ķ���
			Method[] methods = perClazz.getMethods();
			for(Method method:methods) {
				System.out.println(method);
			}
			System.out.println("============");
			//�@ȡ�����Լ��ķ���
			Method[] declaredMethods = perClazz.getDeclaredMethods();
			for(Method declaredMethod:declaredMethods) {
				System.out.println(declaredMethod);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//�@ȡ�ӿ�	
	public static void demo03() {
		try {
			Class<?> perClazz = Class.forName("reflect.Person");
			//�@ȡ���еĹ����ķ���
			Class<?>[] interfaces = perClazz.getInterfaces();
			for(Class<?> inter:interfaces) {
				System.out.println(inter);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//�@ȡ���еĸ��	
	public static void demo04() {
		try {
			Class<?> perClazz = Class.forName("reflect.Person");
			Class<?> superclass = perClazz.getSuperclass();
			System.out.println(superclass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//�@ȡ���еČ���
	public static void demo05() {
		try {
			Class<?> perClazz = Class.forName("reflect.Person");
			//Field[] fields = perClazz.getFields();
			Field[] fields = perClazz.getDeclaredFields();
			for(Field field:fields) {
				System.out.println(field);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//�@ȡ��ǰ������������ӿڣ��Č��󣨌�����
	public static void demo06() throws InstantiationException, IllegalAccessException {
		Class<?> perClazz = null;
		try {
			 perClazz = Class.forName("reflect.Person");
			Field[] fields = perClazz.getDeclaredFields();
			for(Field field:fields) {
				System.out.println(field);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Object instance = perClazz.newInstance();
		System.out.println(instance);
	}
	
	//��ȡ��ǰ���������ࣨ�ӿڣ��Ķ���ʵ����
	public static void demo07() throws InstantiationException, IllegalAccessException {
		Class<?> perClazz = null;
		try {
			perClazz = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object instance = perClazz.newInstance();
		Person per = (Person)instance;
		per.myMethod2();
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//		demo01();
//		demo02();
//		demo03();
//		demo04();
//		demo05();
//		demo06();
		demo07();
	}

}
