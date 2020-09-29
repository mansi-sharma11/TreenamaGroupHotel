package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageOR {
	
	public LandingPageOR(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1")
	protected WebElement pageHeading;
	
	@FindBy(xpath = "//h3")
	protected WebElement secondHeading;
	
	@FindBy(xpath = "//label[text()=\"Select Hotel\"]")
	protected WebElement hotelLabel; 
	
	@FindBy(xpath = "//label[text()=\"Room Category\"]")
	protected WebElement roomLabel; 
	
	@FindBy(xpath = "//select [@name='one']")
	protected WebElement hotelDropdown;
	
	@FindBy(xpath = "//select/option [@value= 0]")
	protected WebElement defaultValue;
	
	@FindBy(xpath= "//select[@name='one']")
	protected WebElement dropdownvalues;
	
	@FindBy(xpath = "//select [@name='two']")
	protected WebElement roomDropdown;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	protected WebElement additionalCharge;
	
	@FindBy(xpath="//label")
	protected WebElement checkboxLabel;
	
	@FindBy(xpath = "//div[@id='total']")
	protected WebElement total;
	
	@FindBy(xpath = "//label[text()=\"total : $ \"]")
	protected WebElement totalLabel; 
	
	@FindBy(xpath="//select/option[text()='Nirvana']")
	protected WebElement choice1;
	

}
