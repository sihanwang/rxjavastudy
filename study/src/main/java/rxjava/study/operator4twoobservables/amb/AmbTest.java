package rxjava.study.operator4twoobservables.amb;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static rx.Observable.interval;
import rx.Observable;

public class AmbTest {

	// TODO Auto-generated method stub
	 static Observable<String> stream (int initialDelay, int interval, String name) { 

		return Observable
	         .interval(initialDelay, interval, MILLISECONDS)
	        .map(x -> name + x)
	        .doOnSubscribe(() ->
	            System.out.println("Subscribe to " + name))
	        .doOnUnsubscribe(() ->
	        System.out.println("Unsubscribe from " + name));
	}

	
	public static void main(String[] args)  throws Exception
	{

		Observable.amb(
		        stream(100, 17, "S"), //only get all events from this stream, because its first event comes first
		        stream(200, 10, "F")
		).subscribe(System.out::println);
		
		Thread.sleep(100000);
	}

}
