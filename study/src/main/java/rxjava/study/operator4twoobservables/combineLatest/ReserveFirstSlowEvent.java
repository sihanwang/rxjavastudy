package rxjava.study.operator4twoobservables.combineLatest;


import static java.util.concurrent.TimeUnit.SECONDS; 
import static rx.Observable.interval;

import rx.Observable;

public class ReserveFirstSlowEvent {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Observable<String> fast = interval(10, SECONDS)
	            .map(x -> "F" + x)
	            .delay(100, SECONDS)
	            .startWith("FX");  //fast的第一个事件以“FX”立即开始，这样第一个slowevent就会出现在组合的结果序列之中
	    Observable<String> slow = interval(17, SECONDS).map(x -> "S" + x);
	    slow
	            .withLatestFrom(fast, (s, f) -> s + ":" + f)
	            .forEach(System.out::println);
		
		Thread.sleep(50000);
	}

}
