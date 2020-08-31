package com.thread;

/**
 * @author chenjun
 * 2020��6��22�� ����10:36:33 ͨ��ʵ�� Runnable �ӿ��������߳�
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
			System.out.println("�̣߳�" + threadName + "," + i);
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