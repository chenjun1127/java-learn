package com.object;
 

/**
 * @author chenjun
 * 2020��6��18�� ����3:09:23
 */
public class TestInterFace {

	public static void main(String[] args) {
		Who jack = new Who("jack", 2);
        jack.run();
        jack.say();
	}
}


interface Man {
    void run();

    String getName();
}

interface GirlFriend {
    void say();

    int getCount();
}

class Who implements Man, GirlFriend {
    private String name;
    private int count = 30;

    public Who(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println(this.name + "���˶���");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void say() {
        System.out.println(this.name + "��" + this.count + "��Ů���ѣ�");

    }

    @Override
    public int getCount() {
        return this.count;
    }
}