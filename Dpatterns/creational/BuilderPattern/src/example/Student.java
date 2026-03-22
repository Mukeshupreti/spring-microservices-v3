package example;

public class Student {
 
        // these are the compulsory parameters we have to specify
	private final String name;
	private final String university;
        // optional parameter
	private final int age;
    // It's common to prevent direct instantiation: so make construtur private.
    private Student(Builder builder) {
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
        //Rename setAge → age Builder methods usually avoid “set”, because it's fluent, not a setter:
		public Builder age(int age){
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

    public static void main() {
        // here Builder is staic inner class and you are creating instance of Builder class from Student
        Student student=new Student.Builder("name","university").age(19)
                .build();
        System.out.println(student);
    }
}