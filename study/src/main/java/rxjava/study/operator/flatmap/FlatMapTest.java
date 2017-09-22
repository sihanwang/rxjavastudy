package rxjava.study.operator.flatmap;
import static rx.Observable.empty;
import static rx.Observable.just;
import rx.Observable;

public class FlatMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Observable<Integer> numbers=Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		//equivalent
		numbers
		.doOnNext(i -> System.out.println("A: " + i))
		.flatMap(x -> just(x * 2))
		.doOnNext(i -> System.out.println("b: " + i))
		.flatMap(x -> (x != 10) ? just(x) : empty())
		.subscribe(s -> System.out.println("c: " + s));
		
		
	}

}
