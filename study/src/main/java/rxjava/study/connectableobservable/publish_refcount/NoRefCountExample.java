package rxjava.study.connectableobservable.publish_refcount;

import rx.Observable;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class NoRefCountExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Observable<String> observable = Observable.create(
				subscriber -> {
					System.out.println("Establishing connection");

					subscriber.add(Subscriptions.create(() -> {
						System.out.println("Disconnecting connection");
					}));
					System.out.println("Established connection");
				}
				);

		Subscription sub1 = observable.subscribe();
		System.out.println("Subscribed 1");
		Subscription sub2 = observable.subscribe();
		System.out.println("Subscribed 2");
		sub1.unsubscribe();
		System.out.println("Unsubscribed 1");
		sub2.unsubscribe();
		System.out.println("Unsubscribed 2");
	}

}
