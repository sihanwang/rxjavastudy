package rxjava.study.single.merge;

import rx.Observable;
import rx.Single;
import rx.schedulers.Schedulers;

public class AmergeB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<String> a_merge_b = getDataA().mergeWith(getDataB());
		
		a_merge_b.subscribe(s -> {System.out.println(s);});
		
	}

	public static Single<String> getDataA() {
		return Single.<String>create(o -> {
			o.onSuccess("DataA");
		}).subscribeOn(Schedulers.io());
	}

	public static Single<String> getDataB() {
		return Single.just("DataB").subscribeOn(Schedulers.io());
	}

}
