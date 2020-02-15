package reflect;

public class Person implements MyInterface,MyInterface2{
	
	private int id;
	private String name;
	private int age;
	
	public Person() {
	
    }
	
	private void PerMethod() {
		
	}
	public Person(String name) {
		this.name = name;
    }
	public Person(int id) {
		this.id = id;
	}
	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public void myName() {
			System.out.println("myName方法已经被执行了。。。。。。。。");
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public void myMethod() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myMethod2() {
		System.out.println("mymethod2....");
	}

}
