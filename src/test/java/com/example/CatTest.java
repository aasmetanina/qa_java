package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class CatTest {

    Feline feline = Mockito.mock(Feline.class);
    Cat cat = new Cat(feline);

    @Test
    public void getSound() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFood() throws Exception {
        List<String> expected = List.of("meat");
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        Assert.assertEquals(expected, cat.getFood());
    }
}