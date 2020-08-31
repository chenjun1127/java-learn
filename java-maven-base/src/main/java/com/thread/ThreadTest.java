package com.thread;

public class ThreadTest {
	public static void main(String[] args) {
		ThreadInit t1 = new ThreadInit("thread-1");
		t1.start();
		ThreadInit t2 = new ThreadInit("thread-2");
		t2.start();
	}
}

/**
 * @author chenjun 2020��6��22�� ����10:38:17 ͨ���̳� Thread �౾���������̣߳�
 */
class ThreadInit extends Thread {
	private Thread t;
	private String threadName;

	ThreadInit(String name) {
		this.threadName = name;
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
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}