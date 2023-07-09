package testlib.concurrent.classicexample;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * 多线程模拟卖票
 * @author Kwok
 * 2023-07-09
 */
public class MultiThreadSellTicket extends Thread {
    
	private static int ticket = 10000;
	private static AtomicInteger realTicket= new AtomicInteger(0);
	
    @Override
    public void run() {
        while (true) {
        	synchronized (MultiThreadSellTicket.class) {
        		if (ticket > 0) {
                    System.out.println(realTicket.incrementAndGet() + ":" + Thread.currentThread().getName() + "卖出了第" + ticket-- + "张票");
                } else {
                    System.out.println(Thread.currentThread().getName() + "余票不足，停止售票!");
                    break;
                }
			}
        }
    }

	public static void main(String[] args) {
		
		MultiThreadSellTicket ticketWindow1 = new MultiThreadSellTicket();
		MultiThreadSellTicket ticketWindow2 = new MultiThreadSellTicket();
		MultiThreadSellTicket ticketWindow3 = new MultiThreadSellTicket();
		
		ticketWindow1.setName("窗口1");
		ticketWindow2.setName("窗口2");
		ticketWindow3.setName("窗口3");

		ticketWindow1.start();
		ticketWindow2.start();
		ticketWindow3.start();
		
	}

}
