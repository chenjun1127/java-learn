package com.thread;

/**
 * @author chenjun
 * 2020年6月22日 上午10:36:33 通过实现 Runnable 接口来创建线程
 */
public class RunnableTest {
	public static void main(String[] args) {
		RunnableInit r1 = new RunnableInit("thread-1");
		r1.start();
		RunnableInit r2 = new RunnableInit("thread-2");
		r2.start();
	}
}

class RunnableInit implements Runnable {
	private Thread t;
	private String threadName;

	RunnableInit(String name) {
		this.threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		for (int i = 4; i > 0; i--) {
			System.out.println("线程：" + threadName + "," + i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Thread " +  threadName + " exiting.");
	}

	public void start() {
		if (t == null) {
			t = new Thread(this, this.threadName);
			t.start();
		}
	}
}