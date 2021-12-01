package com.example.bkd06k11;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    Calculator calculator;

    @Before
    public void setUp() throws Exception {
        System.out.println("before");
        calculator = new Calculator();
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("beforeClass");
    }

    @Test
    public void addition_isCorrect() {
        System.out.println("test");
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    public void sub_isCorrect() {
        System.out.println("test");
        assertEquals(2, calculator.sub(4, 2));
    }

    @Test
    public void equalArr() {
        assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3});
    }

    @Test
    public void equalException() {
        assertThrows(Exception.class, () -> {
            Integer.parseInt("1");
        });
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("afterClass");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after");
    }
}