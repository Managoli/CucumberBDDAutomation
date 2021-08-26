package Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class commanMethods {
	
	WebDriver driver;
	
	public int getElementSize(String accessType, String accessName){
        int i=driver.findElements(By.xpath(accessName)).size();
        System.out.println(i);
        return i;
    }
	
    public String getTexts(String accessType, String accessName){
        String temp="";
          List<WebElement> elements = driver.findElements(By.xpath(accessName));
            for (int i=0; i<elements.size();i++){
                temp=temp+elements.get(i).getText()+";";
            }
            return temp;
    }

}
