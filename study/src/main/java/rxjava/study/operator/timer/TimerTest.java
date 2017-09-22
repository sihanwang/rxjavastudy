package rxjava.study.operator.timer;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;

public class TimerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//都是在main thread中执行
		System.out.println("Main starts at "+System.currentTimeMillis()+" with "+ Thread.currentThread().getName());
		Observable
		.timer(2, TimeUnit.SECONDS, Schedulers.immediate())
		.subscribe(
				zero -> System.out.println("Timer returns:"+zero+" with thread:"+ Thread.currentThread().getName()),
				error -> error.printStackTrace(),
				() -> System.out.println("Observable completes with thread:"+ Thread.currentThread().getName()));
		System.out.println("Main ends at "+System.currentTimeMillis()+" with "+ Thread.currentThread().getName());
	}

}
