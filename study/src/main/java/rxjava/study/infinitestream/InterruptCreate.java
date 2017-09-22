package rxjava.study.infinitestream;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class InterruptCreate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subscription c=delayed("test").subscribe(x -> System.out.println(x));
		c.unsubscribe();
		System.out.println("Subscribe returned");
	}

	static void sleep(int timeout, TimeUnit unit) {
		try {
			unit.sleep(timeout);
		} catch (InterruptedException ignored) {
			// intentionally ignored
		}
	}

	static <String> Observable<String> delayed(String x) {
		return Observable.create(subscriber -> {
			Runnable r = () -> {
				sleep(10, TimeUnit.SECONDS);
				if (!subscriber.isUnsubscribed()) {
					subscriber.onNext(x);
					subscriber.onCompleted();
				}
			};
			Thread t=new Thread(r);
			t.start();
			//we ask the subscriber to let us know by invoking a callback if it	unsubscribes and is registered via Subscriber.add()
			subscriber.add(Subscriptions.create(() -> {t.interrupt();}));
		});
	}

}
