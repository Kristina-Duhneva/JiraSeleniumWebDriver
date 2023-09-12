package jira;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JiraTest extends BaseJira {
    @Test
    public void createStory() {

        WebElement storyButton = driver.findElement(By.xpath("//*[@id=\"type-picker-uid8\"]"));
        storyButton.sendKeys("Story");
        storyButton.sendKeys(Keys.ENTER);

        WebElement summaryField = driver.findElement(By.xpath("//input[@id='summary-field']"));
        summaryField.sendKeys(Constant.STORY_SUMMARY);

        WebElement descriptionField = driver.findElement(By.xpath("//*[@id=\"ak-editor-textarea\"]"));
        descriptionField.sendKeys(Constant.STORY_DESCRIPTION);
        WebElement priorityField = driver.findElement(By.xpath("//*[@id=\"priority-field\"]"));
        priorityField.sendKeys("High");
        priorityField.sendKeys(Keys.ENTER);

        driver.findElement( By.xpath("//button[@type='submit']")).click();

    }

    @Test
    public void createBug() {

        WebElement bugButton = driver.findElement(By.xpath("//*[@id=\"type-picker-uid8\"]"));
        bugButton.sendKeys("Bug");
        bugButton.sendKeys(Keys.ENTER);

        WebElement summaryField = driver.findElement(By.xpath("//input[@id='summary-field']"));
        summaryField.sendKeys(Constant.BUG_SUMMARY);

        WebElement descriptionField = driver.findElement(By.xpath("//*[@id=\"ak-editor-textarea\"]"));
        descriptionField.sendKeys(Constant.BUG_DESCRIPTION);

        WebElement priorityField = driver.findElement(By.xpath("//*[@id=\"priority-field\"]"));
        priorityField.sendKeys("Highest");
        priorityField.sendKeys(Keys.ENTER);

        driver.findElement( By.xpath("//button[@type='submit']")).click();


        String descriptionValue = descriptionField.getText();
        assertEquals(Constant.BUG_DESCRIPTION, descriptionValue, "Description field value should match expected value.");

    }
}
