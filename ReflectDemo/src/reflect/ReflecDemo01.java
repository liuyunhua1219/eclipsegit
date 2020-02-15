package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*反射：
 * 反射機制是在【運行狀態】中：
 * 			對於任意一個類，都能夠知道這個類的所有屬性和方法
 * 			對於任意一個對象，都能夠調用它的任意一個方法和屬性
 * 反射提供的功能：
 * 			在運行時判斷任意一個對象所屬的類
 * 			在運行時構造任意一個類的對象
 * 			在運行時判斷任意一個類所具有的成員變量和方法
 * 			在運行時調用任意一個對象的方法
 * 			生成動態代理
 * 獲取反射入口的三種方法：1.Class.forName(); 2.XX.class ; 3.對象.getClass()
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
		//2.類名.class
		Class<?> perClazz2 =Person.class;
		System.out.println(perClazz2);
		//3.對象.getClass()
		Person per = new Person();
		Class<?> perClass3 = per.getClass();
		System.out.println(perClass3);
	}
	//獲取方法	
	public static void demo02() {
		try {
			Class<?> perClazz = Class.forName("reflect.Person");
			//獲取所有的公共的方法
			Method[] methods = perClazz.getMethods();
			for(Method method:methods) {
				System.out.println(method);
			}
			System.out.println("============");
			//獲取所有自己的方法
			Method[] declaredMethods = perClazz.getDeclaredMethods();
			for(Method declaredMethod:declaredMethods) {
				System.out.println(declaredMethod);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//獲取接口	
	public static void demo03() {
		try {
			Class<?> perClazz = Class.forName("reflect.Person");
			//獲取所有的公共的方法
			Class<?>[] interfaces = perClazz.getInterfaces();
			for(Class<?> inter:interfaces) {
				System.out.println(inter);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//獲取所有的父類	
	public static void demo04() {
		try {
			Class<?> perClazz = Class.forName("reflect.Person");
			Class<?> superclass = perClazz.getSuperclass();
			System.out.println(superclass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//獲取所有的屬性
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
	
	//獲取當前反射所代表類（接口）的對象（實例）
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
	
	//获取当前反射多代表类（接口）的对象（实例）
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
