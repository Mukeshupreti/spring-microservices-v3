package example;

public class Student {
 
        // these are the compulsory parameters we have to specify
	private final String name;
	private final String university;
        // optional parameter
	private final int age;
	
	public Student(Builder builder){
		this.name = builder.name;
		this.university = builder.university;
		this.age = builder.age;
	}
	
	public static class Builder {
		
		private final String name;
		private final String university;
		private int age;
		
		public Builder(String name, String university){
			this.name = name;
			this.university = university;
		}
		
		public Builder setAge(int age){
			this.age = age;
			return this;
		}
		
		public Student build(){
			return new Student(this);
		}
	}
	
	@Override
	public String toString() {
		return this.name+"-"+this.university+"-"+this.age;
	}
}