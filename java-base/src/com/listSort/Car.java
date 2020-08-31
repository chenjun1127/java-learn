package com.listSort;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Car implements Comparable<Car> {
	public String id;
	public String name;
	public Set<Series> series;

	public Car(String id, String name) {
		this.id = id;
		this.name = name;
		this.series = new HashSet<Series>();
	}

	public void printCarSeries() {
		Iterator<Series> it = this.series.iterator();
		while (it.hasNext()) {
			System.out.print(it.next().name + "," + "\t");
		}
	}

	@Override
	public int compareTo(Car o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.id);
	}
}
