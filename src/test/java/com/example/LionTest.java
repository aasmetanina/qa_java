package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class LionTest {
    Feline feline = Mockito.mock(Feline.class);
    Lion lion;

    public LionTest() throws Exception {
        lion = new Lion(feline, "Самка");
    }

    @Test
    public void wrongSex() {
        Assert.assertThrows("Используйте допустимые значения пола животного - самей или самка", Exception.class, () -> new Lion(feline, "карбыш"));
    }

    @Test
    public void getKittens() {
        Mockito.when(feline.getKittens()).thenReturn(5);
        Assert.assertEquals(5, lion.getKittens());
    }

    @Test
    public void doesHaveMane() {
        Assert.assertFalse(lion.doesHaveMane());
    }

    @Test
    public void getFood() throws Exception {
        List<String> expected = List.of("meat");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        Assert.assertEquals(expected, lion.getFood());
    }
}