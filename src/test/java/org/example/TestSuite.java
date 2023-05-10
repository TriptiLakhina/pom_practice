package org.example;

import org.testng.annotations.Test;

public class TestSuite extends BaseTest {
    // Creating class objects to call methods from respective classes.
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    ProductAppleMacBookPro13InchPage productAppleMacBookPro13InchPage = new ProductAppleMacBookPro13InchPage();
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage();
    CompareProductsPage compareProductsPage = new CompareProductsPage();
    ElectronicsPage electronicsPage = new ElectronicsPage();
    CameraPhotoPage cameraPhotoPage = new CameraPhotoPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    LogInPage logInPage = new LogInPage();
    NewReleasePage newReleasePage = new NewReleasePage();
    FacebookPage facebookPage = new FacebookPage();
    SwitchMainWindow switchMainWindow = new SwitchMainWindow();
    BuildYourOwnComputerProductPage buildYourOwnComputerProductPage = new BuildYourOwnComputerProductPage();
    ProductPage productPage = new ProductPage();
    Login_CheckoutPage loginCheckoutPage = new Login_CheckoutPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @Test
    public void verifyUserShouldBeAbleToRegisterSuccessfully()
    {
        // click on register link
        homePage.clickOnRegisterLink();
        // Fill in the registration details
        registrationPage.fillInRegistrationDetails_FirstTimeRegistration();
        // Verify the display message
        registrationResultPage.verifyUserRegisteredSuccessfully();
    }

    @Test
    public void verifyNonRegisteredUserShouldNotBeAbleToVoteSuccessfully()
    {
        // click on Good radio button
        homePage.clickOnGoodButton();
        // Click on Vote button
        homePage.clickOnVoteButton();
        // Verify the error message
        homePage.verifyUserCanNotVoteSuccessfully();
    }

    @Test
    public void verifyNonRegisteredUserShouldNotBeAbleToEmailAFriendSuccessfully()
    {
        // Click on add to cart button of Apple MacBook Pro 13-inch
       homePage.addToCartButton_AppleMacBookPro13Inch();
        // Click on Email a friend button
       productPage.clickOnEmailAFriendButton();
 //      productAppleMacBookPro13InchPage.emailAFriend();
       // Fill in the 'Email a friend' details
       emailAFriendPage.fillInEmailAFriendDetails();
       // Verify Non registered user should not be able to use the feature and should see the error message
       emailAFriendPage.captureActualEmailAFriendErrorMessage();
    }

    @Test
    public void verifyUserShouldBeAbleToCompareTwoProductsAndClearTheProductComparisonListSuccessfully()
    {
        // Click on add to compare for Product 1 - HTC One M8 Android L 5.0 Lollipop
        homePage.addToCompare_HTCOneM8AndroidL5Lollipop();
        // Close the Green coloured success notification bar
        homePage.closeSuccessNotificationBar();
        // Click on add to compare for product 2 - $25 Virtual Gift Card - from homepage (featured products)
        homePage.addToCompare_$25VirtualGiftCard();
        // Click on Green colour success notification bar to open the Product comparison list
        homePage.openProductComparisonFromSuccessNotificationBar();
        // Verify the name of product 1 in product comparison
        compareProductsPage.captureProductName_HTCOneM8AndroidL5Lollipop();
        // Verify the name of product 2 in product comparison
        compareProductsPage.captureProductName_$25VirtualGiftCard();
        // Click on clear list
        compareProductsPage.clickOnClearListButton();
        // Verify the display message for empty product comparison
        compareProductsPage.captureActualNoItemsToCompareMessage();
    }

    @Test
    public void verifyUserCanSeeTheCorrectProductInShoppingCart()
    {
        // Click on Electronics menu
        homePage.clickOnElectronicsCategoryMenu();
        // Click on Camera & Photo
        electronicsPage.clickOnCameraPhoto();
        // Capture & print the name of product Leica T Mirrorless Digital Camera
        cameraPhotoPage.captureProductName_LeicaTMirrorlessDigitalCamera();
        // Click on Add to cart button
        cameraPhotoPage.clickOnAddToCartButton_LeicaTMirrorlessDigitalCamera();
        // Open the shopping cart from notification bar
        cameraPhotoPage.clickOnShoppingCartLinkFromSuccessNotificationBar();
        // Capture & print the name of product in the shopping cart
        shoppingCartPage.captureproductname_LeicaTMirrorlessDigitalCamera();
    }

    @Test
    public void verifyRegisteredUserShouldBeAbleToReferAProductSuccessfullyToAFriend()
    {
        //Click on register link
        homePage.clickOnRegisterLink();
        // Fill in the registration details
        registrationPage.fillInRegistrationDetails_ForRegisteredUser();
        // Click on login link on homepage
        homePage.clickOnLoginLink();
        // Fill in login details
        logInPage.fillInLoginDetails();
        // Click on add to cart - Apple MacBook Pro 13-inch
        homePage.addToCartButton_AppleMacBookPro13Inch();
        // Click on email a friend
        productPage.clickOnEmailAFriendButton();
        // Fill in 'Email a friend' details
        emailAFriendPage.fillInEmailAFriendDetails_RegisteredUser();
        // Verify the message displayed
        emailAFriendPage.captureActualEmailAFriendMessage();
    }

    @Test
    public void verifyRegisteredUserShouldBeAbleToVoteSuccessfully()
    {
        // Click on register link
        homePage.clickOnRegisterLink();
        // Fill in registration details
        registrationPage.fillInRegistrationDetails_ForRegisteredUser();
        // click on login link on homepage
        homePage.clickOnLoginLink();
        // Fill in login details
        logInPage.fillInLoginDetails();
        // Click on Good radio button
        homePage.clickOnGoodButton();
        // Click on Vote button
        homePage.clickOnVoteButton();
        // Capturing & Verifying the text on Vote poll for registered customers
        homePage.captureActualVoteMessage_RegisteredUser();
    }

    @Test
    public void printProductTitles(){
        homePage.printoutProductTitles();
    }

    @Test
    public void verifySearchAlertMessage(){
        homePage.verifySearchAlertMessage();
    }

    @Test
    public void verifyUserShouldBeAbleToSelectTheCurrency(){
        homePage.verifyUserCanSelectTheCurrencyUSD();
        homePage.verifyUserCanSelectTheCurrencyEuro();
    }


    @Test
    public void verifyUserShouldSeeAddedCommentLast_NewRelease(){
        homePage.clickOnNewRelease();
        newReleasePage.verifyUserCanAddAComment();
        newReleasePage.verifyCommentAddedSuccessMessage();
        newReleasePage.verifyLastAddedCommentIsAtTheEndOfList();

    }
    @Test
    public void verifyUserShouldBeAbleToSeeCommunityPollAlertMessage(){
        homePage.verifyCommunityPollAlertMessage();
    }


    @Test
    public void verifyGuestUserShouldBeAbleToOrderSuccessfully(){
        homePage.openProduct_BuildYourOwnComputer();
        buildYourOwnComputerProductPage.fillInTheRequiredProductSpecifications();
        productPage.clickOnAddToCartButton();
        productPage.clickOnShoppingCartButton_Header();
        shoppingCartPage.verifyProductSpecifications();
        shoppingCartPage.verifyUserCanCheckoutSuccessfully();
        loginCheckoutPage.clickOnCheckoutAsGuestButton();
        checkoutPage.fillInCheckoutDetailsAsGuestUser();
        checkoutCompletePage.verifyUserCanSeeOrderNumber();


    }

    @Test
    public void verifyUserShouldBeAbleToSearchProducts(){
        homePage.verifyUserSeeCorrectProductsInSearch();
    }

    @Test
    public void verifyUserShouldBeAbleToAccessFacebookPageSuccessfully(){
        homePage.clickOnFacebookIconLink();
        facebookPage.verifyFacebookPageUrlAndHeaderElements();
        facebookPage.switchToMainWindow();
 //       homePage.switchToMainWindow();
        homePage.verifyHomePageWelcomeMessage();
        facebookPage.closeChildWindow();




    }


}
