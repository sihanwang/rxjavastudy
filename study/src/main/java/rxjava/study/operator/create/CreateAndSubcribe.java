package rxjava.study.operator.create;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.Observer;


public class CreateAndSubcribe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Observable<Integer> observableString = Observable.create(new
				Observable.OnSubscribe<Integer>() {
			
			@Override
			public void call(Subscriber<? super Integer> observer) {
				for (int i = 0; i < 5; i++) {
					observer.onNext(i);
				}
				observer.onCompleted();
			}
		});


		
		Subscription subscriptionPrint =
				observableString.subscribe(new Observer<Integer>() {

					@Override
					public void onError(Throwable e) {
						System.out.println("Oh no! Something wrong happened!");
					}
					@Override
					public void onNext(Integer item) {
						System.out.println("Item is " + item);
					}

					@Override
					public void onCompleted() {
					System.out.println("Observable completed");
					}
				});



	}

}
