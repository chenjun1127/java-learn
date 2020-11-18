package com.list.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/6/18 9:51
 */
public class TestCollections {
    public List<Car> carList;

    public TestCollections() {
        this.carList = new ArrayList<Car>();
    }

    public static void main(String[] args) {
        Car benz = new Car("1", "奔驰");
        Series[] benzSeries = {new Series("1", "GLA", 22.98F), new Series("2", "GLC", 45.38F),
                new Series("3", "GLB", 33.28F)};
        benz.series.addAll(Arrays.asList(benzSeries));
        Car bmw = new Car("0", "宝马");
        Series[] bmwSeries = {new Series("1", "X1", 32.98F), new Series("2", "X3", 42.38F),
                new Series("3", "X6", 78.98F)};
        bmw.series.addAll(Arrays.asList(bmwSeries));
        Car audi = new Car("003", "奥迪");
        Series[] audiSeries = {new Series("1", "A4L", 32.38F), new Series("2", "A6L", 39.08F),
                new Series("3", "A8L", 98.00F)};
        audi.series.addAll(Arrays.asList(audiSeries));

        TestCollections tc = new TestCollections();
        tc.carList.add(benz);
        tc.carList.add(bmw);
        tc.carList.add(audi);
        tc.sortById();
        tc.sortByName();
    }

    /**
     * 根据id来排序
     */
    public void sortById() {
        Collections.sort(this.carList);
        System.out.println("根据id排序后");
        for (Car car : carList) {
            System.out.println(car.name + "：" + car.series.toString());
        }
    }

    /*
     * 根据name来排序
     */
    public void sortByName() {
        Collections.sort(this.carList, new CarComparator());
        System.out.println("根据name排序后");
        for (Car car : carList) {
            System.out.println(car.name + "：" + car.series.toString());
        }
    }

}
