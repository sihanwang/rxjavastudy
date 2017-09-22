package rxjava.study.subject.publishsubject;

import rx.Subscription;
import rx.functions.Action0;
import rx.subjects.PublishSubject;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class PublishSubjectCareOnlyComplete {

	public static void main(String[] args)
	{

		final PublishSubject<Boolean> subject = PublishSubject.create();
		subject.subscribe(new Observer<Boolean>() {
			@Override
			public void onCompleted() {
			}		

			@Override
			public void onError(Throwable e) {
			}
			@Override
			public void onNext(Boolean completed) {
				System.out.println("Observable completed!");
			}
		});


		Observable.create(new Observable.OnSubscribe<Integer>() {
			@Override
			public void call(Subscriber<? super Integer> subscriber) {
				for (int i = 0; i < 5; i++) {
					subscriber.onNext(i);
				}
				subscriber.onCompleted();
			}
		}).doOnCompleted(new Action0() {
			@Override
			public void call() {
				subject.onNext(true);
			}
		}).subscribe(); //不会触发任何observer的action，只是使observable开始发数据。


	}

}
