package com.juaracoding.pageobject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.AddToChart;
import com.juaracoding.pageobject.pages.Checkout;
import com.juaracoding.pageobject.pages.SearchProduct;
import com.juaracoding.pageobject.utils.Constants;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestCheckout {
	public static WebDriver driver;
	private SearchProduct searchProduct;
	private AddToChart addToChart;
	private Checkout checkout;

	@Before
	public void setUp() {
		DriverSingleton.getInstance(Constants.CHROME);
		searchProduct = new SearchProduct();
		addToChart = new AddToChart();
		checkout = new Checkout();
	}

	@After
	public void closeBrowser() {
		delay(2);
		DriverSingleton.closeObjectInstance();
	}

	@Given("User go to web shop")
	public void user_go_to_web_shop() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
	}

	@When("User click button search")
	public void user_click_button_search() {
		searchProduct.clickBtnSrach();
	}

	@And("User enter product")
	public void user_enter_product() {
		scroll(700);
		searchProduct.inputSearch();
	}

//	Product One

	@When("User click product one")
	public void user_click_product_one() {
		delay(3);
		addToChart.productOne();
	}

	@And("User select color")
	public void user_select_color() {
		scroll(700);
		addToChart.selectColor();
	}

	@And("User select size")
	public void user_select_size() {
		addToChart.selectSize();
	}

	@And("User click button add to chart")
	public void user_click_button_add_to_chart() {
		addToChart.clickButtonAddToChart();
	}

	@Then("User success add product one")
	public void User_success_add_product_one() {
		assertEquals(addToChart.getTxtProductOne(), "WHITE BANDAGE CUT OUT BODYCON MINI DRESS");
		System.out.println("Success Add Prodct One");
	}

	@And("User click view chart")
	public void user_click_view_chart() {
		addToChart.clickButtonVViewChart();
	}

	@And("User click button continue shopping")
	public void user_click_button_continue_shopping() {
		addToChart.clickButtonContinueShopping();
	}

//	Product Two

	@When("User click product two")
	public void user_click_product_twoe() {
		scroll(300);
		delay(3);
		addToChart.producTwo();
	}

	@And("User select color two")
	public void user_select_color_two() {
		scroll(700);
		addToChart.selectColorTwo();
	}

	@And("User select size two")
	public void user_select_size_two() {
		addToChart.selectSizeTwo();
	}

	@And("User click button add to chart two")
	public void user_click_button_add_to_chart_two() {
		addToChart.clickButtonAddToChartTwo();
	}

	@Then("User success add product two")
	public void User_success_add_product_two() {
		assertEquals(addToChart.getTxtProductTwo(), "BLACK LUX GRAPHIC T-SHIRT");
		System.out.println("Success Add Prodct two");
	}

	@And("User click view chart two")
	public void user_click_view_chart_two() {
		addToChart.clickButtonVViewChart();
	}

//	Checkout & Place Order

	@When("User click button checkout")
	public void user_click_button_checkout() {
		scroll(500);
		checkout.clickBtnCheckout();
	}

	@And("User enter first name")
	public void user_enter_first_name() {
		delay(1);
		checkout.inputFirstName();
	}

	@And("User enter last name")
	public void user_enter_last_name() {
		delay(1);
		checkout.inputLastName();
	}

	@And("User select region")
	public void user_select_region() {
		delay(1);
		checkout.selectRegion();
	}

	@And("User input address")
	public void user_input_address() {
		delay(1);
		checkout.inputStreetAddress();
	}
	
	@And("User select city")
	public void user_select_city() {
		delay(1);
		checkout.inputCity();
	}
	
	@And("User select province")
	public void user_select_province() {
		delay(1);
		checkout.selectProvince();
	}
	
	@And("User input postcode")
	public void user_input_postcode() {
		delay(1);
		checkout.inputPostcode();
	}
	
	@And("User input phone")
	public void user_input_phone() {
		delay(1);
		checkout.inputPhone();
	}
	
	@And("User input email")
	public void user_input_email() {
		delay(1);
		checkout.inputEmailAdress();
		
		scroll(-200);
	}
	
	@And("User ceklist term condition")
	public void user_ceklist_term_condition() {
		delay(1);
		checkout.ceklist();
	}
	
	@And("User click button place order")
	public void user_click_button_place_order() {
		delay(1);
		checkout.clickBtnPlaceOrder();
	}
	
	@Then("User success checkout")
	public void user_success_checkout() {
		delay(3);
		checkout.getTxtSuccesCheckou();
		assertEquals(checkout.getTxtSuccesCheckou(), "CHECKOUT");
		System.out.println("Checkout Succsess");
	}
	

	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void scroll(int vertical) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + vertical + ")");
	}

}
