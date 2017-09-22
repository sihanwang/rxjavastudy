package rxjava.study.infinitestream;

import java.math.*;

import rx.Observable;

public class BrokenStream {

	//其实是可以正常运行的，但是Subscribe没法退出
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<BigInteger> naturalNumbers = Observable.create(subscriber -> {
			BigInteger i = BigInteger.ZERO;
			while (true) { // don't do this!
				subscriber.onNext(i);
				i = i.add(BigInteger.ONE);
			}
		});
		
		naturalNumbers.subscribe(x -> System.out.println(x));
	}

}
