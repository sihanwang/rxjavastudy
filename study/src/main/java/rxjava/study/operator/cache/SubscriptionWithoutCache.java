package rxjava.study.operator.cache;

import rx.Observable;

public class SubscriptionWithoutCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<Integer> ints = Observable.create(subscriber -> {
			System.out.println("Create");
			subscriber.onNext(42);
			subscriber.onCompleted();
		});
		
		System.out.println("Starting");
		ints.subscribe(i -> System.out.println("Element A: " + i));
		ints.subscribe(i -> System.out.println("Element B: " + i));
		System.out.println("Exit");
	}

}
