package lab0;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lab0.Variant5;
public class Variant5Test {

    // тест 1
    @Test(dataProvider = "iftask")
    public void iftask(int input_1, int input_2, int input_3, int [] expected) {
        assertEquals(new Variant5().iftask(input_1,input_2,input_3),expected);
    }
    @DataProvider
    public Object[][] iftask() {
        return new Object[][] { {1,2,3,3,0},{-1,-2,1,1,2},{-12,-3,-13,0,3}};
    }

    // тест 2
    @Test(dataProvider = "whiletask")
    public void iftask(int input,int  expected) {
        assertEquals(new Variant5().whiletask(input),expected);
    }
    @DataProvider
    public Object[][] whiletask() {
        return new Object[][] { {16,4}, {8,3},{36,5},{128,7},{1024,10}};
    }

    // тест 3
    @Test(dataProvider = "matrixtask")
    public void matrixtask(int [] input_1, int input_2, int input_3, int input_4, int [][] expected) {
        assertEquals(new Variant5().matrixtask(input_1,input_2,input_3,input_4),expected);
    }
    @DataProvider
    public Object[][] matrixtask() {
        return new Object[][] {{new int[]{1,2}, 2,2,12 ,new int[][]{{1,13},{2,14}}}};
    }

    // тест 4
    @Test(dataProvider = "inttask")
    public void inttask(int input_1, int input_2, int expected) {
        assertEquals(new Variant5().inttask(input_1,input_2),expected);
    }
    @DataProvider
    public Object[][] inttask() {
        return new Object[][] {{12,2,0},{12,4,0},{12,5,2},{51,23,5}};
    }

    // тест 5
//    @Test(dataProvider = "fortask")
//    public void fortask(double input, double[] expected) {
//        assertEquals(new Variant5().fortask(input),expected);
//    }
//    @DataProvider
//    public Object[][] fortask() {
//        return new Object[][] {{100,new double[]{10.000000, 20.000000, 30.000002, 40.000000, 50.000000, 60.000004, 70.000008, 80.000008, 90.000008, 100.000015}}};
//    }

    // тест 6
    @Test(dataProvider = "casetask")
    public void casetask(int input_1, int input_2,int input_3, double expected) {
        assertEquals(new Variant5().casetask(input_1,input_2,input_3),expected);
    }
    @DataProvider
    public Object[][] casetask() {
        return new Object[][] {{1,1,5,6.0},{4,2,11,0.18181818181818182},{3,2,11,22.0}};
    }

    // тест 7
    @Test(dataProvider = "booltask")
    public void booltask(int input_1, int input_2, boolean expected) {
        assertEquals(new Variant5().booltask(input_1,input_2),expected);
    }
    @DataProvider
    public Object[][] booltask() {
        return new Object[][] {{2,5,false},{1,-5,true}};
    }

    // тест 8
    @Test(dataProvider = "arraytask")
    public void arraytask(int input, int [] expected) {
        assertEquals(new Variant5().arraytask(input),expected);
    }
    @DataProvider
    public Object[][] arraytask() {
        return new Object[][] {{5,new int[]{1, 1, 2, 3, 5}}, {8,new int[] {1, 1, 2, 3, 5, 8, 13, 21}}, {15,new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610}}};
    }

}