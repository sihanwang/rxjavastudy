package rxjava.study.subscriber.conditionalunsubscribe;

import rx.Observable;
import rx.Subscriber;

public class ConditionalUnscribe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Subscriber<String> subscriber = new Subscriber<String>() {
			@Override
			public void onNext(String tweet) {
				System.out.println(tweet);
				
				if (tweet.contains("30")) {
					unsubscribe();
				}
			}

			@Override
			public void onCompleted() {
			}

			@Override
			public void onError(Throwable e) {
				e.printStackTrace();
			}
		};
		
		 customObservableNonBlocking().subscribe(subscriber);

	}

	static Observable<String> customObservableNonBlocking() {
		return Observable.create(subscriber -> {

			System.out.println("Observables being generated with thread: " + Thread.currentThread().getName());
			// TODO Auto-generated method stub
			for (int i = 0; i < 75; i++) {
				if (subscriber.isUnsubscribed())
				{
					return;
				}
				
				subscriber.onNext("value_" + i);
			}
			
			if (!subscriber.isUnsubscribed())
			{
				subscriber.onCompleted();
			}

		});

	}

}
