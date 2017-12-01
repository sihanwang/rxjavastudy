package rxjava.study.operator4aggregation.reduce;

import java.math.BigDecimal;

import rx.Observable;

public class ReduceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<Long> progress = Observable.just(1L,2L,3L,4L,5L,6L,7L);
		Observable<BigDecimal> total=progress.reduce(BigDecimal.ZERO, (a,b) -> a.add(BigDecimal.valueOf(b))); //第一个参数ZERO是初始值
		total.subscribe(System.out::println);
	}

}
