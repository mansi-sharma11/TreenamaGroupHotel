package PageFunctions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import CommonFunctions.DriverFun;
import ObjectRepository.LandingPageOR;

public class OtherFunctions extends LandingPageOR {
	WebDriver driver = null;
	DriverFun driverFunc;

	public OtherFunctions(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean onlyRoom() throws InterruptedException {

		String label = checkboxLabel.getText();
		System.out.println("label : =  "+label);
		Select se = new Select(roomDropdown);

		List<WebElement> l = se.getOptions();
		int nofoptions = l.size();
		System.out.println("size= " + nofoptions);
		if (nofoptions == 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean roomTarrif() {
		Select select1 = new Select(dropdownvalues);
		select1.selectByValue("3000");

		Select se = new Select(roomDropdown);
		se.selectByValue("0");

		String Amt1 = total.getText();
		System.out.println("First Amt = " + Amt1);
		int i = Integer.parseInt(Amt1);

		se.selectByIndex(2);
		String Amt2 = total.getText();
		System.out.println("Second Amt = " + Amt2);
		int i2 = Integer.parseInt(Amt2);
		if (i < i2) {
			return true;
		} else {
			return false;
		}

	}

	public boolean additionalcharge() {
		Select select1 = new Select(dropdownvalues);
		select1.selectByValue("3000");

		Select se = new Select(roomDropdown);
		se.selectByValue("0");

		additionalCharge.click();

		String Amt1 = total.getText();
		System.out.println("First Amt = " + Amt1);
		int i = Integer.parseInt(Amt1);

		additionalCharge.click();
		String Amt2 = total.getText();
		System.out.println("Second Amt = " + Amt2);
		int i2 = Integer.parseInt(Amt2);
		additionalCharge.click();
		int diff = i - i2;
		if (diff == 50) {
			return true;
		} else {
			//additionalCharge.click();
			return false;
		}
	
	}
	
	//only additional charges 
	public boolean onlyCheckbox() throws InterruptedException {
		driver.get(driver.getCurrentUrl());
		Thread.sleep(2000);
		/*Select select = new Select(dropdownvalues);
		select.selectByIndex(0);*/
		additionalCharge.click();
		String Amt = total.getText();
		System.out.println("Additional Checkbox checked = " + Amt);
		//checkbox unselected
		additionalCharge.click();
		String newAmt = total.getText();
		System.out.println("Additional Checkbox uncheck = " + newAmt);
		
		if(Amt =="50" && newAmt=="0") {
			return true; 
		}
		else {
			return false;
		}
	}
	
	//remove hotel
	public boolean removeHotel() throws InterruptedException {
		Select select1 = new Select(dropdownvalues);
		select1.selectByValue("3000");

		Select se = new Select(roomDropdown);
		se.selectByValue("0");
		
		select1.selectByIndex(0);
		
		List<WebElement> l = se.getOptions();
		int options = l.size();
		System.out.println(" Size is : "+options);
		Thread.sleep(1000);
		String totalAmt = total.getText();
		System.out.println("Removed all selections, new Amt= " + totalAmt);
		if(options == 1 && totalAmt== "0") {
			return true;
		}
		else{
			return false;
		}
		
	}

}
