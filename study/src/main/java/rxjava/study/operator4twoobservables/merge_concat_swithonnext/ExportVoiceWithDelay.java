package rxjava.study.operator4twoobservables.merge_concat_swithonnext;

import rx.Observable;
import org.apache.commons.lang3.tuple.Pair;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static rx.Observable.just;

public class ExportVoiceWithDelay {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// speak("Jing Wang is very very smart",100).subscribe(System.out::println);

		Observable<String> alice = speak("To be, or not to be: that is the question", 110);
		Observable<String> bob = speak("Though this be madness, yet there is method in't", 90);
		Observable<String> jane = speak(
				"There are more things in Heaven and Earth, " + "Horatio, than are dreamt of in your philosophy", 100);

		//if they speak at the same time
		Observable.merge(alice.map(w -> "Alice: " + w), bob.map(w -> "Bob: " + w), jane.map(w -> "Jane: " + w))
				.subscribe(System.out::println);
		Thread.sleep(30000);
		//按先来后到的顺序读
		Observable.concat(alice.map(w -> "Alice: " + w), bob.map(w -> "Bob: " + w), jane.map(w -> "Jane: " + w))
		.subscribe(System.out::println);
		
		
		
		
		Thread.sleep(1000000);

	}

	static Observable<String> speak(String quote, long millisPerChar) {
		String[] tokens = quote.replaceAll("[:,]", "").split(" ");
		Observable<String> words = Observable.from(tokens);
		Observable<Long> absoluteDelay = words.map(String::length).map(len -> len * millisPerChar)
				.scan((total, current) -> total + current);
		return words.zipWith(absoluteDelay.startWith(0L), Pair::of)
				.flatMap(pair -> just(pair.getLeft() + ":" + String.valueOf(pair.getRight())).delay(pair.getRight(),
						MILLISECONDS));
	}

}
