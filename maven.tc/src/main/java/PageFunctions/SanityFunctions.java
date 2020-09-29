package PageFunctions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import CommonFunctions.DriverFun;
import ObjectRepository.LandingPageOR;

public class SanityFunctions extends LandingPageOR {

	WebDriver driver = null;
	DriverFun driverFunc;

	public SanityFunctions(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// verify heading
	public boolean isTitleMatched() {
		if (pageHeading.getAttribute("innerHTML").equalsIgnoreCase("Treenama Hotel Groups")) {
			return true;
		}
		return false;
	}

	// verify accommodation title

	public boolean isAccomodation() {
		if (secondHeading.getAttribute("innerHTML").equalsIgnoreCase("Accomodation")) {
			return true;
		}
		return false;
	}
	
	public boolean verifyHotelLabel() {
		boolean check = hotelLabel.isDisplayed();
		if(check==true) {
			System.out.print("Hotel label is: "+ hotelLabel.getText());
			return true;
		}
		else {
			return false;
		}    
	}
	// verify values for hotel

	public boolean isDefault() {
		if (defaultValue.getAttribute("innerHTML").equalsIgnoreCase("Select Hotel")) {
			return true;
		}
		return false;
	}

	public void HotelValues() {

		Select select = new Select(hotelDropdown);
		java.util.List<WebElement> options = select.getOptions();
		for (WebElement item : options) {
			System.out.println("Dropdown values are: " + item.getText());
		}
		Select select1 = new Select (dropdownvalues);
		 select1.selectByValue("3000");
	}
	
	public boolean verifyRoomLabel() {
		boolean check = roomLabel.isDisplayed();
		if(check==true) {
			System.out.print("Room label is: "+ roomLabel.getText());
			return true;
		}
		else {
			return false;
		}    
	}

	// Room values
	public void RoomValues() throws InterruptedException {
		
		 String[] exp = {"Economy", "Executive", "Business", "Luxury"};
		 Select select = new Select(roomDropdown);  

		 List<WebElement> options = select.getOptions();  
		 for(WebElement we:options)  
		 {  
		  boolean match = false;
		  for (int i=0; i<exp.length; i++){
		      if (we.getText().equals(exp[i])){
		        match = true;
		      }
		      Assert.assertTrue(match, "Not matched= " +we.getText());
		    }
		 
		 }  
	}
	
	public boolean Roomno() {
		int rooms =4;
		Select select1 = new Select (dropdownvalues);
		 select1.selectByValue("3000");
		 Select select = new Select(roomDropdown);  
		 List<WebElement> options = select.getOptions(); 
		 int i = options.size();
		 System.out.println("room nos is  "+ i);	
		 if(i!=rooms) {
			 return false;
		 }
		 else {
			 return true;
		 }
	}

	// Additional Charges label and checkbox
	public boolean isSelectable() {

		additionalCharge.click();
		boolean selected = additionalCharge.isSelected();
		if (selected == true) {
			return true;
		}
		return false;
	}

	public boolean isLabelCorrect() {
		if (checkboxLabel.getAttribute("innerHTML").equalsIgnoreCase("Additional charges")) {
			return true;
		}
		return false;
	}
	
	//Total Price label
	public boolean istotalLabelPresent() {
		boolean check = totalLabel.isDisplayed();
		if(check==true) {
			return true;
		}
		else {
			return false;
		}   
	}
	

}
