package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionSexTest {

    final String sex;
    final Boolean hasMane;
    Feline feline = Mockito.mock(Feline.class);
    Lion lion;

    public LionSexTest(String sex, Boolean hasMane) throws Exception {
        this.sex = sex;
        this.hasMane = hasMane;
        lion = new Lion(feline, sex);
    }

    @Parameterized.Parameters
    public static Object[][] getSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }


    @Test
    public void doesHaveMane() {
        Assert.assertEquals(hasMane, lion.doesHaveMane());
    }
}