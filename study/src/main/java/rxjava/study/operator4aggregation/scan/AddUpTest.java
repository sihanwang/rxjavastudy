package rxjava.study.operator4aggregation.scan;

import rx.Observable;
public class AddUpTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Observable<Long> progress = Observable.just(1L,2L,3L,4L,5L,6L,7L);
		Observable<Long> totalProgress = progress
		        .scan(5L, (total, chunk) -> total + chunk);//5L 是指定的初始值
		totalProgress.subscribe(System.out::println);
		Thread.sleep(10000);
	}

}
