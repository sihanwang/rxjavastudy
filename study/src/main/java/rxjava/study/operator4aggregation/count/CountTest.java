package rxjava.study.operator4aggregation.count;

import rx.Observable;

public class CountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<String> StrList = Observable.just("Wang", "Jing", "shi", "hao", "ren", "bu", "shi", "mao");
		StrList.count().subscribe(System.out::println);

		// reduce可以实现同样的功能
		// Observable<Integer> size = Observable
		// .just('A', 'B', 'C', 'D')
		// .reduce(0, (sizeSoFar, ch) -> sizeSoFar + 1);
	}

}
