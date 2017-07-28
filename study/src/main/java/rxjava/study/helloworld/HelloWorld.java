package rxjava.study.helloworld;

import io.reactivex.*;

public class HelloWorld {
    public static void main(String[] args) {
    	
    	System.out.println("Main function started:"+Thread.currentThread().getName());
    	
    	//just operator runs observer method thread in current thread
        Flowable.just("Hello world").subscribe(s -> {
        	
        	System.out.println(s+" with thread: "+Thread.currentThread().getName());        	
        	Thread.currentThread().sleep(5);
        });        
        
        System.out.println("Main function ended:"+Thread.currentThread().getName());
        
        
    }
}