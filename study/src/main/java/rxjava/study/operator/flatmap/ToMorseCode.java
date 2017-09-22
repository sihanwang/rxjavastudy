package rxjava.study.operator.flatmap;
import static rx.Observable.empty;
import static rx.Observable.just;
import rx.Observable;

public class ToMorseCode {
	
	enum Sound { DI, DAH };

	public static void main(String[] args) {
				
		// TODO Auto-generated method stub
		new ToMorseCode().converttomorsecode().subscribe();
	}

	
	public Observable<Sound> converttomorsecode()
	{
		return just('S', 'p', 'a', 'r', 't', 'a')
		.map(Character::toLowerCase)
		.flatMap(this::toMorseCode);
		
		
	}
	
	
	

	public Observable<Sound> toMorseCode(char ch) {
		switch(ch) {
		case 'a': return just(Sound.DI, Sound.DAH);
		case 'b': return just(Sound.DAH, Sound.DI, Sound.DI, Sound.DI);
		case 'c': return just(Sound.DAH, Sound.DI, Sound.DAH, Sound.DI);
		//...
		case 'p': return just(Sound.DI, Sound.DAH, Sound.DAH, Sound.DI);
		case 'r': return just(Sound.DI, Sound.DAH, Sound.DI);
		case 's': return just(Sound.DI, Sound.DI, Sound.DI);
		case 't': return just(Sound.DAH);
		//...
		default:
		return empty();
		}
		}
	
	
	
}
