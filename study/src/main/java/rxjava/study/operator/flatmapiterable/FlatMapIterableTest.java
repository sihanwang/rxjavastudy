package rxjava.study.operator.flatmapiterable;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Observer;


public class FlatMapIterableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<Integer> NameIDs=Observable.just(1, 2, 3, 4, 5, 6);
		NameIDs.flatMapIterable(FlatMapIterableTest::getListOfString)
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
		});

	}
	
	public static List<String>  getListOfString(int NameID)
	{
		ArrayList<String> allString= new ArrayList<String>();
		allString.add("张三"+String.valueOf(NameID));
		allString.add("李四"+String.valueOf(NameID));
		allString.add("王五"+String.valueOf(NameID));
		allString.add("赵六"+String.valueOf(NameID));
		allString.add("陈二麻子"+String.valueOf(NameID));
		
		return allString;
	}

}
