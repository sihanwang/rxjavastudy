package rxjava.study.operator4aggregation.groupby;

import rx.observables.GroupedObservable;
import rx.Observable;

public class GroupByTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Observable<String> StrList = Observable.just("Wang", "Jing", "shi", "hao", "ren", "bu", "shi", "mao");

		Observable<GroupedObservable<Object, String>> grouped = StrList.groupBy(a -> a.substring(0, 1));

		grouped.flatMap(GroupedByTheFirstLetter ->

		{
			Object key = GroupedByTheFirstLetter.getKey();
			GroupedByTheFirstLetter.subscribe(v -> {
				System.out.println(Thread.currentThread().getName() + "--->key:" + key.toString() + " value:" + v);
			});
			return Observable.empty();
		}).subscribe();

		Thread.sleep(10000);

		// grouped.subscribe(GroupedByTheFirstLetter ->
		//
		// {
		// Object key = GroupedByTheFirstLetter.getKey();
		// GroupedByTheFirstLetter.subscribe(v -> {
		// System.out.println(Thread.currentThread().getName() + "--->key:" +
		// key.toString() + " value:" + v);
		// });
		// });
	}

}
