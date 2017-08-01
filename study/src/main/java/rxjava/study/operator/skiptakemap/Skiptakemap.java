package rxjava.study.operator.skiptakemap;

import rx.Observable;

public class Skiptakemap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello function started:"+Thread.currentThread().getName());
		
		customObservableNonBlocking()
		.skip(10)
		.take(5)
		.map(str -> {
			System.out.println("Map with thread:"+Thread.currentThread().getName());
			return str+"_xform";
			})
		.subscribe(str ->  {System.out.println("Subscrib with thread:"+Thread.currentThread().getName());});
		
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
