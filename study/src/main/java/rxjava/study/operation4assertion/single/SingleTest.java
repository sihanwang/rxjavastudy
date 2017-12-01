package rxjava.study.operation4assertion.single;

import java.math.BigDecimal;
import static rx.Observable.just;

import rx.Observable;
import rx.Single;

public class SingleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			// TODO Auto-generated method stub
			Observable<Long> progress = Observable.just(1L,2L,3L,4L,5L,6L,7L);
			Observable<BigDecimal> total=progress.reduce(BigDecimal.ZERO, (a,b) -> a.add(BigDecimal.valueOf(b))); //第一个参数ZERO是初始值

			Observable<BigDecimal> onlyone=total.flatMap(c -> just(BigDecimal.ONE ,c)).single();//如果多余一个事件，则会抛出异常Sequence contains too many elements
			//Observable<BigDecimal> onlyone=total.single(); 
			onlyone.subscribe(System.out::println);
	

	}

}
