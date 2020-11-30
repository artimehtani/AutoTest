PetClinic

package com.company;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PetClinicTest {
   static WebDriver driver=new ChromeDriver();
   WebElement findOwnersButton = driver.findElement(By.linkText("Find owners"));
    @BeforeClass
       public static void setup(){
        System.out.println("Before class--- set up");
       driver.get("http://127.0.0.1:9966/petclinic");

}
    @Before
    public  void goHome(){
        System.out.println("Before--go home");
    //click Home Button
}
    @Test
    public  void userStory1(){
        System.out.println("Test user story 1");
        findOwnersButton.click();

        driver.findElement(By.name("lastName")).sendKeys("Black");

        driver.findElement(By.xpath("//button[contains(text(),'Find Owner')]")).click();
        String city=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[3]/td[1]")).getText();
        Assert.assertEquals("Monona",city);
    }
    @Test
    public void userStory2(){
        System.out.println("Test user story 2 ");
        findOwnersButton.click();
       driver.findElement(By.linkText("Add Owner")).click();
       String info=driver.findElement(By.xpath("//h2[contains(text(),'Owner')]")).getText();
       Assert.assertEquals("New Owner",info);
       driver.findElement(By.name("firstName")).sendKeys("Anna");
       driver.findElement(By.name("lastName")).sendKeys("Sofie");
       driver.findElement(By.name("address")).sendKeys("åstaängen 13");
       driver.findElement(By.name("city")).sendKeys("Stockholm");
       driver.findElement(By.id("telephone")).sendKeys("0999999999");
       driver.findElement(By.xpath("/html[1]/body[1]/div[1]/form[1]/div[6]/button[1]")).click();
       String namn=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/b[1]")).getText();
       Assert.assertEquals("Anna Sofie",namn);
    }
    @Test
    public void userStory3(){
        System.out.println("Test user story 3");
        driver.findElement(By.linkText("Veterinarians")).click();
        String data=driver.findElement(By.xpath("//th[@class='sorting']")).getText();
        Assert.assertEquals("Specialties",data);
        driver.findElement(By.cssSelector("th.sorting_asc")).click();
        driver.findElement(By.cssSelector("th.sorting")).click();

    }
    @Test
    public void userStory4(){
        System.out.println("Test user story 4");
        driver.findElement(By.linkText("Veterinarians")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Search:')]//input")).sendKeys("Jam");
        String veteName=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")).getText();
        Assert.assertEquals("James Carter",veteName);
    }
    @Test
    public void userStory5(){
        System.out.println("Test user story 5");
        findOwnersButton.click();
        driver.findElement(By.name("lastName")).sendKeys("Franklin");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/form[1]/fieldset[1]/div[2]/button[1]")).click();
        String nameOwner=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/b[1]")).getText();
        Assert.assertEquals("George Franklin",nameOwner);
        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
        driver.findElement(By.name("name")).sendKeys("Timmi");
        driver.findElement(By.name("birthDate")).sendKeys("2018/02/23");
        driver.findElement(By.name("type")).findElement(By.xpath("//option[contains(text(),'cat')]")).click();
        driver.findElement(By.cssSelector("body:nth-child(2) div.container:nth-child(2) form.form-horizontal:nth-child(4)" +
                " div.form-actions:nth-child(6) > button:nth-child(1)")).click();

    }

@AfterClass
    public static void close(){
    System.out.println("After Class--Close");
    driver.quit();
}
}
