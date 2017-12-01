package rxjava.study.operation4assertion.all_exists_contains;

import rx.Observable;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Observable<Integer> numbers = Observable.range(1, 5);
	    numbers.all(x -> x != 4).subscribe(System.out::println); // [false] 
	    numbers.exists(x -> x == 4).subscribe(System.out::println); // [true] 
	    numbers.contains(4).subscribe(System.out::println); // [true]
	}

}
