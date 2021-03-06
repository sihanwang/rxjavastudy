package rxjava.study.operator.fromjust;

import rx.Observable;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hellofrom("Ben", "George");
		hellojust("Ben", "George");
	}

	
	public static void hellofrom(String... names) {
		
		System.out.println("hello function started:"+Thread.currentThread().getName());
		
		//from operator runs observer method thread in current thread
	    Observable.from(names).subscribe(s -> {
	    	System.out.println("Hello:"+s+" with thread: "+Thread.currentThread().getName());
	    	try {
				Thread.currentThread().sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	    });
	    
	    
	    System.out.println("hello function ended:"+Thread.currentThread().getName());
	}
	
	
	
	//如果传递给just方法一个ArrayList对象，它不会读取对象内部list中的元素，而是将ArrayList整个发送。
	public static void hellojust(String... names) {
		
		System.out.println("hello function started:"+Thread.currentThread().getName());
		
		//from operator runs observer method thread in current thread
	    Observable.just(names).subscribe(s -> {
	    	System.out.println("Hello:"+s+" with thread: "+Thread.currentThread().getName());
	    	try {
				Thread.currentThread().sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	    });
	    
	    
	    System.out.println("hello function ended:"+Thread.currentThread().getName());
	}
}
