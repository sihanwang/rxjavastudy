package rxjava.study.operator.do_on_next;

import rx.Observable;

public class DoOnNextTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable
		.just(8, 9, 10)
		.doOnNext(i -> System.out.println("A: " + i))
		.filter(i -> i % 3 > 0)
		.doOnNext(i -> System.out.println("B: " + i))
		.map(i -> "#" + i * 10)
		.doOnNext(s -> System.out.println("C: " + s))
		.filter(s -> s.length() < 4)
		.subscribe(s -> System.out.println("D: " + s));
	}

}
