package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class NewReleasePage extends Utils{

    private By _title = By.cssSelector("input.enter-comment-title");
    private By _commentFieldBox = By.cssSelector("textarea#AddNewComment_CommentText") ;
    private By _newCommentButton = By.xpath("//button[contains(@name,'add-comment')]") ;
    private By _commentAddedSuccessMessage = By.cssSelector("div.result");
    private By _comments = By.cssSelector("strong.comment-text");

    public void verifyUserCanAddAComment() {
        // Type title
        typeText(_title,"Apple MacBook Pro 13 inch");
        //Type comment
        typeText(_commentFieldBox,"Highly recommend this product");
        // click on New Comment button
        clickOnElement(_newCommentButton);

    }

    public void verifyCommentAddedSuccessMessage() {
        Assert.assertEquals(getTextFromElement(_commentAddedSuccessMessage),"News comment is successfully added.", "Success message is not same");
    }

    public void verifyLastAddedCommentIsAtTheEndOfList(){
        List<WebElement> actual = getTextFromElements(_comments);
 //       Assert.assertEquals(actual,);

        ArrayList<String> commentslist = new ArrayList<>();
        for (WebElement comment : driver.findElements(_comments)){
            commentslist.add(comment.getText());
        }
        String lastComment = commentslist.get(commentslist.size() - 1);
        if (lastComment.equalsIgnoreCase("Apple MacBook Pro 13 inch")){
            System.out.println("New comment added at the end of the list.");
        } else {
            System.out.println("New comment did not appear at the end of the list.");
        }
        }
  //      WebElement commentslist = driver.findElement()

    }

