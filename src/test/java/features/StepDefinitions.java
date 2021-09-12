package features;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import revolut.PaymentService;
import revolut.Person;

import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {

    private double topUpAmount;
    //private String topUpMethod;
    PaymentService topUpMethod;
    Person danny;

    @Before//Before hooks run before the first step in each scenario
    public void setUp(){
        //We can use this to setup test data for each scenario
        danny = new Person("Danny");
    }
    @Given("Danny has {double} euro in his euro Revolut account")
    public void dannyHasEuroInHisEuroRevolutAccount(double startingBalance) {
        //System.out.println("Danny has starting account balance of: " + String.valueOf(startingBalance));
        danny.setAccountBalance(startingBalance);
        //double newAccountBalance = danny.getAccountBalance("EUR");
        //System.out.println("Danny's new account balance if: " + String.valueOf(newAccountBalance));
    }

    @Given("Danny selects {double} euro as the topUp amount")
    public void danny_selects_euro_as_the_top_up_amount(double topUpAmount) {
        // Write code here that turns the phrase above into concrete actions
        this.topUpAmount = topUpAmount;
        //throw new io.cucumber.java.PendingException();
    }

    //@Given("Danny selects his {word} as his topUp method")
//    @Given("Danny selects his {paymentService} as his topUp method")
//    //public void danny_selects_his_debit_card_as_his_top_up_method(String topUpSource) {
//    public void danny_selects_his_debit_card_as_his_top_up_method(PaymentService topUpSource) {
//        // Write code here that turns the phrase above into concrete actions
//        System.out.println("The selected payment service type was " + topUpSource.getType());
//        topUpMethod = topUpSource;
//    }

    @When("Danny tops up")
    public void danny_tops_up() {
        // Write code here that turns the phrase above into concrete actions
        danny.getAccount("EUR").addFunds(topUpAmount);
        //throw new io.cucumber.java.PendingException();
    }

    @Then("The new balance of his euro account should now be {double}")
    public void the_new_balance_of_his_euro_account_should_now_be(double newBalance) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        //Arrange
        double expectedResult = newBalance;
        //Act
        double actualResult = danny.getAccount("EUR").getBalance();
        //Assert
        Assert.assertEquals(expectedResult, actualResult,0);
        System.out.println("The new final balance is: " + actualResult);
    }

    @Given("Danny has {int} euro in his euro Revolut account now")
    public void dannyHasEuroInHisEuroRevolutAccountNow(int currentBalance) {
        danny.setAccountBalance(currentBalance);
    }

    @And("Danny buys {int} euro worth of crypto")
    public void dannyBuysEuroWorthOfCrypto(int purchaseAmount) { danny.getAccount("EUR").takeFunds(purchaseAmount);}

    @And("Danny uses his {paymentService} as his topUp Method")
    public void dannyUsesHiDebitCardAsHisTopUpMethod(PaymentService revolut) {
        topUpMethod = revolut;
    }

    @When("Danny makes the purchase") public void dannyMakesThePurchase() {System.out.println("Danny Purchased Crypto"); }

    @Then("The new balance of his euro account should be {int}")
    public void theNewBalanceOfHisEuroAccountShouldBe(int newBalance) {
        double expectedResult = newBalance;
        //Act
        double actualResult = danny.getAccount("EUR").getBalance();
        //Assert
        Assert.assertEquals(expectedResult, actualResult,0);
    }


//
    @Given("Danny has a starting balance of {double}")
    public void dannyHasAStartingBalanceOfStartBalance(double d) {


        danny.setAccountBalance(d);

    }
    @And("Danny selects his {paymentService} as his topUp method")
    public void dannySelectsHisDebitCardAsHisTopUp(PaymentService debitCard){


      topUpMethod = debitCard;
    }

    @When("Danny now tops up by {double}")
    public void dannyNowTopsUpByTopUpAmount(double d) {

        double currentBalance = danny.getAccount("EUR").getBalance();
        danny.setAccountBalance(d + currentBalance);
    }


    @Then("The balance in his euro account should be {double}")
    public void theBalanceInHisEuroAccountShouldBeNewBalance(double d) {

        double expectedResult = d;
        //Act
        double actualResult = danny.getAccount("EUR").getBalance();
        //Assert
        Assert.assertEquals(expectedResult, actualResult,0);
        System.out.println("The new final balance is: " + actualResult);
    }


}
