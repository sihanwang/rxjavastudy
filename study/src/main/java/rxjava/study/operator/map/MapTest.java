package rxjava.study.operator.map;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Observable<Integer> observableInteger1 = Observable.create(new
				Observable.OnSubscribe<Integer>() {
			
			@Override
			public void call(Subscriber<? super Integer> observer) {
				
				System.out.println("Initialization");
				
				for (int i = 0; i < 10; i++) {
					observer.onNext(i);
				}
				
				observer.onCompleted();
			}
			
		});
		
		Observable<Integer> observableInteger2= observableInteger1.map(new Func1<Integer, Integer>() {
			@Override
			public Integer call(Integer event) {
			return event+1;
			}
			});
		
		observableInteger2.subscribe(new Observer<Integer>() {

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
