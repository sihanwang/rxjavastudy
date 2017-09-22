package rxjava.study.operator.delay;

import static rx.Observable.timer;

import java.util.concurrent.TimeUnit;

import rx.Observable;

import static java.util.concurrent.TimeUnit.SECONDS;

public class OrderTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Observable
		.just("Lorem", "ipsum", "dolor", "sit", "amet",
		"consectetur", "adipiscing", "elit")
		.flatMap(word ->timer(word.length(), SECONDS).map(x -> word))
		.subscribe(System.out::println);		
		
		TimeUnit.SECONDS.sleep(15);
		
	}

}
