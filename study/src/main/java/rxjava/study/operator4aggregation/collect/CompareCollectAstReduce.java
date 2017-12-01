package rxjava.study.operator4aggregation.collect;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

public class CompareCollectAstReduce {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 把一个数字序列放到一个ArrayList中，用reduce实现
		Observable<List<Integer>> all = Observable.range(10, 20).reduce(new ArrayList<>(), (list, item) -> {
			list.add(item);
			return list;
		});
		
		all.subscribe(System.out::println);

		// 把一个数字序列放到一个ArrayList中，用collect操作符实现
		// collect和reduce的区别是
		// works almost exactly like reduce() but assumes that we use the same mutable
		// accumulator for every event as opposed to returning a new immut‐ able
		// accumulator every time
		Observable<List<Integer>> all1 = Observable.range(10, 20).collect(ArrayList::new, List::add);
		all1.subscribe(System.out::println);

		Thread.sleep(10000);
	}

}
