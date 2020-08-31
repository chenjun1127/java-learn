package com.listSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCollectioins {
	public List<Car> carList;

	public TestCollectioins() {
		this.carList = new ArrayList<Car>();
	}

	public static void main(String[] args) {
		Car Benz = new Car("1", "����");
		Series[] BenzSeries = { new Series("1", "GLA", 22.98F), new Series("2", "GLC", 45.38F),
				new Series("3", "GLB", 33.28F) };
		Benz.series.addAll(Arrays.asList(BenzSeries));
		Car BMW = new Car("0", "����");
		Series[] BMWSeries = { new Series("1", "X1", 32.98F), new Series("2", "X3", 42.38F),
				new Series("3", "X6", 78.98F) };
		BMW.series.addAll(Arrays.asList(BMWSeries));
		Car Audi = new Car("003", "�µ�");
		Series[] AudiSeries = { new Series("1", "A4L", 32.38F), new Series("2", "A6L", 39.08F),
				new Series("3", "A8L", 98.00F) };
		Audi.series.addAll(Arrays.asList(AudiSeries));
	 
		TestCollectioins tc = new TestCollectioins();
		tc.carList.add(Benz);
		tc.carList.add(BMW);
		tc.carList.add(Audi);
		tc.sortById();
		tc.sortByName();
	}

	/**
	 * 	����id������
	 */
	public void sortById() {
		Collections.sort(this.carList);
		System.out.println("����id�����");
		for (Car car : carList) {
			System.out.println(car.name+"��"+car.series.toString());
		}		
	}
	
	/*
	 * 	����name������
	 */
	public void sortByName() {
		Collections.sort(this.carList,new CarComparator());
		System.out.println("����name�����");
		for (Car car : carList) {
			System.out.println(car.name+"��"+car.series.toString());
		}
	}

}
