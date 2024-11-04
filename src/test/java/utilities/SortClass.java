package utilities;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortClass {
    public static List<WebElement> ascendingOrder(List<WebElement> list){

        List originalList = new ArrayList();
        for (WebElement eachElement :  list){
            originalList.add(eachElement.getText());
        }
        List tempList = new ArrayList();
        tempList = originalList;

        Collections.sort(tempList);
        if(originalList==tempList){
            System.err.println("Sorted");
            System.err.println("Original list Sorted "+originalList);
            System.err.println("Temp list Sorted "+tempList);
        }else {
            System.out.println("not sorted");
        }
        Assert.assertEquals(tempList,originalList);
        Assert.assertFalse(tempList.isEmpty());
        Assert.assertFalse(originalList.isEmpty());
        return originalList;
    }
    public static List<WebElement> descendingOrder(List<WebElement> list){
        list.stream().sorted();
        List originalList = new ArrayList();
        for (WebElement eachElement :  list){
            originalList.add(eachElement.getText());
        }
        System.out.println("original                "+originalList.toString());
        List tempList = new ArrayList();
        tempList = originalList;
        System.err.println(tempList);

        Collections.reverse(tempList);
        System.out.println(tempList);
        if(originalList==tempList){
            System.err.println("Descending Sorted");
            System.err.println("Original list Sorted "+originalList);
            System.err.println("Temp list Sorted     "+tempList);
        }else {
            System.out.println("not sorted");
        }
        Assert.assertEquals(tempList,originalList);
        return tempList;
    }
}