package rxjava.study.operator.delay;

import static rx.Observable.timer;

import java.util.concurrent.TimeUnit;

import rx.Observable;

import static java.util.concurrent.TimeUnit.SECONDS;

public class DelayTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Observable.just("Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit")
				.doOnNext(i -> System.out.println("A: " + i))
				.delay(word -> timer(word.length(), SECONDS)) //delay后会改变observable的顺序
				.doOnNext(i -> System.out.println("B: " + i))
				.map(c ->c)
				.subscribe(System.out::println);
		TimeUnit.SECONDS.sleep(15);
	}

}
