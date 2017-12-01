package rxjava.study.operator4aggregation.distinctuntilchanged;

import rx.Observable;

public class DistinctUntilChangedTest {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Observable<String> StrList=Observable.just("Wang", "Jing", "shi", "hao", "ren", "bu", "shi", "mao");
		
		Observable<String> distinctlength=StrList.distinctUntilChanged(a -> a.length()); //发生变化才输出
		distinctlength.subscribe(System.out::println);
	}
}
