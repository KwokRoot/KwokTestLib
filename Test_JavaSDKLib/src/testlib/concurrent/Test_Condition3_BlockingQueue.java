package testlib.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用锁机制实现阻塞队列
 * @author: Kwok
 * @date: 2025/4/11
 */
public class Test_Condition3_BlockingQueue {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> bq = new BlockingQueue<String>(10);
        bq.put("1");
        bq.put("2");
        bq.put("3");

        bq.take();
        bq.take();
        System.out.println(bq.take());
        System.out.println(bq.take());

    }

    // 阻塞队列
    public static class BlockingQueue<T> {
        private final T[] queue;
        private final int capacity;
        private int size = 0;
        private int putIndex = 0;
        private int takeIndex = 0;

        private final ReentrantLock lock = new ReentrantLock();
        private final Condition notFull = lock.newCondition();
        private final Condition notEmpty = lock.newCondition();

        public BlockingQueue(int capacity) {
            this.capacity = capacity;
            this.queue = (T[]) new Object[capacity];
        }

        // 阻塞式入队
        public void put(T item) throws InterruptedException {
            lock.lock();
            try {
                while (size == capacity) {
                    notFull.await(); // 队列满时等待
                }
                queue[putIndex] = item;
                if (++putIndex == capacity) putIndex = 0;
                size++;
                notEmpty.signal(); // 唤醒等待的消费者
            } finally {
                lock.unlock();
            }
        }

        // 阻塞式出队
        public T take() throws InterruptedException {
            lock.lock();
            try {
                while (size == 0) {
                    notEmpty.await(); // 队列空时等待
                }
                T item = queue[takeIndex];
                queue[takeIndex] = null; // 帮助 GC
                if (++takeIndex == capacity) takeIndex = 0;
                size--;
                notFull.signal(); // 唤醒等待的生产者
                return item;
            } finally {
                lock.unlock();
            }
        }
    }

}
