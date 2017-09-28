package rxjava.study.operator.flatmap;

import static java.util.concurrent.TimeUnit.SECONDS;
import static rx.Observable.timer;

import java.util.concurrent.TimeUnit;

import rx.Observable;

public class ConcurrencyControlTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Observable
		.just("Lorem", "ipsum", "dolor", "sit", "amet",
		"consectetur", "adipiscing", "elit")
		.flatMap(word ->timer(word.length(), SECONDS).map(x -> word),1) //等同于concatmap
		.subscribe(System.out::println);		
		
		TimeUnit.SECONDS.sleep(15);
		
	}


}
