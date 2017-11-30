package rxjava.study.operator.startwith;

import static java.util.concurrent.TimeUnit.SECONDS;
import static rx.Observable.interval;
import rx.Observable;

public class StartWithTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    Observable<String> fast = interval(10, SECONDS)
	            .map(x -> "F" + x)
	            .startWith("FX");
	    
	    fast.subscribe(System.out::println);
	    
	    Thread.sleep(50000);
	    
	}

}
