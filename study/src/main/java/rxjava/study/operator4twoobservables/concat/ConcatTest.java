package rxjava.study.operator4twoobservables.concat;

import rx.Observable;

public class ConcatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<Integer> IntegerList=Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Observable<Integer> first2_last3=Observable.concat(
				IntegerList.take(2),
				IntegerList.takeLast(3));

		first2_last3.subscribe(System.out::print);
	}

}
