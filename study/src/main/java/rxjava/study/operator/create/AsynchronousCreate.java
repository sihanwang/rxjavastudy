package rxjava.study.operator.create;

import rx.Observable;

public class AsynchronousCreate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello function started:"+Thread.currentThread().getName());
		customObservableNonBlocking().subscribe(System.out::println);
		System.out.println("hello function ended:"+Thread.currentThread().getName());
	}


	static Observable customObservableNonBlocking()
	{
		return Observable.create(subscriber -> {

			new Thread(new Runnable(){

				@Override
				public void run() {
					
					System.out.println("Observables being generated with thread: "+Thread.currentThread().getName());
					// TODO Auto-generated method stub
					for (int i=0;i<75;i++)
					{
						if (subscriber.isUnsubscribed())
						{
							return;
						}
						
						subscriber.onNext("value_"+i);
					}
					
					if (!subscriber.isUnsubscribed())
					{
						subscriber.onCompleted();
					}
				}

			}).start();

		});

	}



}
