package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FunctionalTest extends BaseTest {

	@Test(priority = 1)
	public void whenNoHotel() throws InterruptedException {
		classtest = report.createTest("Verify When Only Room is selected");
		test = classtest.createNode("only room");
		otherfunction.onlyRoom();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void DifferentHotelPrice() {
		classtest = report.createTest("Check room tariff should be different");
		test = classtest.createNode("price");
		otherfunction.roomTarrif();
	}

	@Test(priority = 3)
	public void AdditionalChargeInclude() {
		classtest = report.createTest("With and Without Additional Charges");
		test = classtest.createNode("With Additonal Charges");
		otherfunction.additionalcharge();
	}

	@Test(priority = 4)
	public void onlyAdditionalCharges() throws InterruptedException {
		classtest = report.createTest("Only Additional charges are applies");
		test = classtest.createNode("With Additonal Charges");
		otherfunction.onlyCheckbox();
	}

	@Test(priority = 5)
	public void removeHotelSelection() throws InterruptedException {
		classtest = report.createTest("Remove Hotel Selection should remove all selections");
		test = classtest.createNode("Remove Hotel Selection");
		otherfunction.removeHotel();

	}

}
