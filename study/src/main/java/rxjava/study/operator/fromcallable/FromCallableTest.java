package rxjava.study.operator.fromcallable;

import rx.Observable;

public class FromCallableTest {
	
	public static void main(String[] args)
	{
	
		Observable<String> a=Observable.<String>fromCallable(() -> {return "String";});
		a.subscribe(System.out::println);
	}
}
