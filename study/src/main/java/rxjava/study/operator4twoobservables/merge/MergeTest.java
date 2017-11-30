package rxjava.study.operator4twoobservables.merge;

import rx.Observable;

public class MergeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<String> a = Observable.create(s -> {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			s.onNext("one");
			s.onNext("two");
			s.onCompleted();

		});

		Observable<String> b = Observable.create(s -> {
			try {
				Thread.currentThread().sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			s.onNext("three");
			s.onNext("four");
			s.onCompleted();

		});
		// this subscribes to a and b concurrently,
		// and merges into a third sequential stream
		Observable<String> c = Observable.merge(a, b);

		// 总是先执行obervable a 然后才执行b
		c.subscribe(s -> {
			System.out.println(s);
		}, e -> {
			e.printStackTrace();
		});

	}

}
