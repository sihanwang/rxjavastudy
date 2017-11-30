package rxjava.study.operator4twoobservables.withLatestFrom;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static rx.Observable.interval;

import rx.Observable;

public class WithLatestFromTest {

	public static void main(String[] args) throws Exception {
		Observable<String> fast = interval(10, MILLISECONDS).map(x -> "F" + x);
		Observable<String> slow = interval(17, MILLISECONDS).map(x -> "S" + x);
		slow.withLatestFrom(fast, (s, f) -> s + ":" + f).forEach(System.out::println);
		
		Thread.sleep(100000);

	}

}
