package rxjava.study.operator.flatmap;

import rx.Observable;

import static java.util.concurrent.TimeUnit.SECONDS;
import static rx.Observable.timer;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FlapMapWithMaxConCurrent {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Observable.just(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
		.delay(x -> timer(x, SECONDS))
		.flatMap(FlapMapWithMaxConCurrent::getStrings) // 没有设置最大线程数
		.subscribe(System.out::println);
		
		TimeUnit.SECONDS.sleep(20);
		
		Observable.just(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
		.delay(x -> timer(x, SECONDS))
		.flatMap(FlapMapWithMaxConCurrent::getStrings,2) // 设置最大线程数2
		.subscribe(System.out::println);
		
		TimeUnit.SECONDS.sleep(200);
		
		
		
	}
	
	public static Observable<String> getStrings(int number)
	{
		ArrayList<String> result = new ArrayList<String>();
		
		for (int i=0;i<number;i++ )
		{
			result.add(String.valueOf(number));
		}
		
		return Observable.from(result) ;
	}

}
