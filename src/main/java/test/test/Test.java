package test.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		startSchedulerChecker();
//	}
//
//	ScheduledExecutorService scheduler;
//
//	private void startSchedulerChecker() {
//	
//			
//			System.out.println("startSchedulerChecker");
//			if (this.scheduler != null) {
//				this.scheduler.shutdown();
//				this.scheduler = null;
//			}
//			this.scheduler = Executors.newSingleThreadScheduledExecutor();
//			this.scheduler.scheduleAtFixedRate(new Runnable() {
//	
//				@Override
//				public void run() {
//	
//					try {
//					System.out.println("Let's START");
//					} catch (Exception e) {
//						System.out.println("Exception"+ e);
//					}
//				}
//			}, 0, 10, TimeUnit.SECONDS);
//	}
}
