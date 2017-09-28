package rxjava.study.operator.concatmap;

import java.time.DayOfWeek;

import rx.Observable;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class CompareWithFlatMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompareWithFlatMap CWFM=new CompareWithFlatMap();
		//输出顺序是不一样的，因为flatmap和concatmap在并发控制上的不同
		CWFM.TestOrderWithFlatMap();
		CWFM.TestOrderWithConcatMap();
		

	}

	Observable<String> loadRecordsFor(DayOfWeek dow) {
		switch (dow) {
		case SUNDAY:
			return Observable.interval(90, MILLISECONDS).take(5).map(i -> "Sun-" + i);
		case MONDAY:
			return Observable.interval(65, MILLISECONDS).take(5).map(i -> "Mon-" + i);
		default:
			return null;
		}
	}
	
	
	public void TestOrderWithFlatMap()
	{
		Observable
		.just(DayOfWeek.SUNDAY, DayOfWeek.MONDAY)
		.flatMap(this::loadRecordsFor)
		.subscribe(System.out::println);
	}
	
	public void TestOrderWithConcatMap()
	{
		Observable
		.just(DayOfWeek.SUNDAY, DayOfWeek.MONDAY)
		.concatMap(this::loadRecordsFor)
		.subscribe(System.out::println);
	}

}
