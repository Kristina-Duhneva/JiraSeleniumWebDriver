package jira;

public class Constant {

    public static final String BUG_DESCRIPTION = "Action\n" +
            "\n" +
            "Navigate to the main page - drehi.com\n" +
            "\n" +
            "Steps to reproduce:\n" +
            "\n" +
            " Choose a product-FURLA bag.\n" +
            "\n" +
            " Press the -add button.\n" +
            "\n" +
            " Navigate to the basket.\n" +
            "\n" +
            " Confirm the order.\n" +
            "\n" +
            "Expected result:\n" +
            "\n" +
            "Display Error Message - User does not exist. Please login with correct details.\n" +
            "\n" +
            "Actual result:\n" +
            "\n" +
            "The order has been placed successfully.";
    public static final String BUG_SUMMARY = "Create an order from a non-existent user";
    public static final String STORY_DESCRIPTION = "Filling existing valid data.\n" +
            "Selecting an item with the button - add.\n" +
            "Add item to cart.\n" +
            "Create an order.";
    public static final String STORY_SUMMARY = "Create an order from an existing user";
}
