package rxjava.study.operator4aggregation.distinct;

import rx.Observable;

public class DistinctWithFunctionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<String> StrList=Observable.just("Wang", "Jing", "shi", "hao", "ren", "bu", "shi", "mao");
		
		Observable<String> distinctlength=StrList.distinct(a -> a.length());
		distinctlength.subscribe(System.out::println);
	}

}
