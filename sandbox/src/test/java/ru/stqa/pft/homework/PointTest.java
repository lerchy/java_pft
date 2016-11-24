package ru.stqa.pft.homework;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by vgagarin on 24.11.2016.
 */
public class PointTest {

    @Test
    public void testDistance(){
        Point p1 = new Point(2.0, 1.0);
        Point p2 = new Point(6.0, 4.0);
        Assert.assertEquals(p1.distance(p2), 5.0);
    }
}
