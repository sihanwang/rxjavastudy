package rxjava.study.operator4twoobservables.zip;

import java.util.concurrent.TimeUnit;

import rx.Observable;

public class ZipStreamsAtSamePace {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Observable<Long> red = Observable.interval(10, TimeUnit.MILLISECONDS);
		Observable<Long> green = Observable.interval(10, TimeUnit.MILLISECONDS);
		Observable.zip(red.timestamp(), green.timestamp(), (r, g) -> r.getTimestampMillis() - g.getTimestampMillis())
				.forEach(System.out::println);

		Thread.sleep(50000);
	}

}
