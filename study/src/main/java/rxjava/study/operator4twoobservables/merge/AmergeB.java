package rxjava.study.operator4twoobservables.merge;

import rx.Observable;
import rx.Single;
import rx.schedulers.Schedulers;

public class AmergeB {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		
		//getDataA().subscribe(System.out::println);
		//getDataB().subscribe(System.out::println);
		
		Observable<String> a_merge_b = getDataA().mergeWith(getDataB());
		
		a_merge_b.subscribe(s -> {
			
			System.out.println(s);
			});
		
		Thread.sleep(5000);
		
	}

	public static Single<String> getDataA() {
		return Single.<String>create(o -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			o.onSuccess("DataA");
		}).subscribeOn(Schedulers.io());
	}

	public static Single<String> getDataB() {
		return Single.just("DataB").subscribeOn(Schedulers.io());
	}

}
