package rxjava.study.operator.timestamp;

import java.util.concurrent.TimeUnit;

import rx.Observable;

public class TimestampTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Observable<Long> red = Observable.interval(1, TimeUnit.SECONDS);
		Observable<Long> green = Observable.interval(1, TimeUnit.SECONDS);
		Observable.zip(red.timestamp(), green.timestamp(), (r, g) -> r.getTimestampMillis() - g.getTimestampMillis())
				.subscribe(System.out::println);
		
		TimeUnit.SECONDS.sleep(15);
		
	}

}
