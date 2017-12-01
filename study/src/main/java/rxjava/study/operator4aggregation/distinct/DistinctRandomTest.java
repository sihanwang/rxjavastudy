package rxjava.study.operator4aggregation.distinct;

import java.util.Random;

import rx.Observable;

public class DistinctRandomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Observable<Integer> randomInts = Observable.create(subscriber -> {
			Random random = new Random();
			while (!subscriber.isUnsubscribed()) {
				subscriber.onNext(random.nextInt(15));
			}
		});

		Observable<Integer> uniqueRandomInts = randomInts.distinct().take(10); //distinct操作符会调用对象的equals()和hashcode()方法来比较是否是相同的对象
		uniqueRandomInts.subscribe(System.out::println);

	}

}
