package rxjava.study.operator.flatmap;

import rx.Observable;

public class CartesianProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<Integer> oneToEight = Observable.range(1, 8);
		Observable<String> ranks = oneToEight.map(Object::toString);
		Observable<String> files = oneToEight.map(x -> 'a' + x - 1).map(ascii -> (char) ascii.intValue())
				.map(ch -> Character.toString(ch));
		Observable<String> squares = files.flatMap(file -> ranks.map(rank -> file + rank));
		
		squares.subscribe(System.out::println);
	}

}
