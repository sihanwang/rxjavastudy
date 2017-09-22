package rxjava.study.operator.interval;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class IntervalTest {

	//以固定时间间隔返回正整数序列
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main starts at "+System.currentTimeMillis()+" with "+ Thread.currentThread().getName());
		Observable
		.interval(2, TimeUnit.SECONDS, Schedulers.immediate())
		.subscribe(
				zero -> System.out.println("Interval returns:"+zero+" with thread:"+ Thread.currentThread().getName()),
				error -> error.printStackTrace(),
				() -> System.out.println("Observable completes with thread:"+ Thread.currentThread().getName()));
		System.out.println("Main ends at "+System.currentTimeMillis()+" with "+ Thread.currentThread().getName());
	}

}
