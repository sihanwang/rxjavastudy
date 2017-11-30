package rxjava.study.operator4twoobservables.combineLatest;

import static java.util.concurrent.TimeUnit.MILLISECONDS; 
import static rx.Observable.interval;

import rx.Observable;

public class CombineLatestTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Observable.combineLatest(
				interval(17, MILLISECONDS).map(x -> "S" + x), interval(10, MILLISECONDS).map(x -> "F" + x), (s,f)->f+":"+s
				    ).forEach(System.out::println); //forEach后面调用的就是subscribe方法，两个方法一回事
		
		Thread.sleep(50000);
		
	}

}
