package rxjava.study.operator.cache;

import rx.Observable;

public class SubscriptionWithCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<Integer> ints = Observable.<Integer>create(subscriber -> {
			System.out.println("Create");
			subscriber.onNext(42);
			subscriber.onCompleted();
		}).cache();
		
		System.out.println("Starting");
		ints.subscribe(i -> System.out.println("Element A: " + i));
		ints.subscribe(i -> System.out.println("Element B: " + i));
		System.out.println("Exit");
	}

}
