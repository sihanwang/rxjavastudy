package rxjava.study.operator.zip;

import rx.Observable;

public class zip {

	public static void main(String[] args)
	{
		Observable<String> names=Observable.just("zhangsan","lisi","wangwu","liumazi");
		
		Observable<Integer> ages= Observable.just(25,36,47);
			
		Observable<Person> Persons=names.zipWith(ages, (a,b) -> new zip().new Person(a,b));
		
		Persons.subscribe( a -> System.out.println(a.toString()));
		
	}
	
	
	class Person
	{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return Name+" "+Age.toString();
		}

		String Name;
		Integer Age;
		
		public Person(String name, int age)
		{
			this.Name=name;
			this.Age=age;
		}
	}
	
}
