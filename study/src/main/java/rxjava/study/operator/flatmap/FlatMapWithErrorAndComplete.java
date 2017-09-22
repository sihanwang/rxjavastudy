package rxjava.study.operator.flatmap;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class FlatMapWithErrorAndComplete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CreateObservable().flatMap(
				number -> Observable.empty(),
				e -> Observable.error(e), 
				() -> CreateComplete()) //把complete信号转换成一个正常信号。flatmap调用的三个函数必须返回相同的类型的observable<R>
				.subscribe(new Observer<String>() {

					@Override
					public void onError(Throwable e) {
						System.out.println("Oh no! Something wrong happened!");
					}

					@Override
					public void onNext(String item) {
						System.out.println("Item is " + item);
					}

					@Override
					public void onCompleted() {
						System.out.println("Observable completed");
					}
				}

		);

	}

	public static Observable<Integer> CreateObservable() {

		return Observable.create(new Observable.OnSubscribe<Integer>() {

			@Override
			public void call(Subscriber<? super Integer> observer) {
				for (int i = 0; i < 100; i++) {
					observer.onNext(i);
				}
				observer.onCompleted();
			}
		});

	}

	public static Observable<String> CreateComplete() {
		return Observable.just("Complete");
	}

}
