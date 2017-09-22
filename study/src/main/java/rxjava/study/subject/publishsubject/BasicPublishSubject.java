package rxjava.study.subject.publishsubject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.subjects.PublishSubject;
import rx.Observer;


public class BasicPublishSubject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PublishSubject<String> stringPublishSubject = PublishSubject.create();
		
		Subscription subscriptionPrint =
				stringPublishSubject.subscribe(new Observer<String>() {
					@Override
					public void onCompleted() {
						System.out.println("Observable completed");
					}
					@Override
					public void onError(Throwable e) {
						System.out.println("Oh no! Something wrong happened!");		
					}
					@Override
					public void onNext(String message) {
						System.out.println(message);
					}
				});
		
		stringPublishSubject.onNext("Hello World");
		stringPublishSubject.onNext("Hello World2");
		stringPublishSubject.onCompleted();

	}

}
