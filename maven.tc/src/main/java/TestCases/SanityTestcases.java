package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SanityTestcases extends BaseTestClass {
	@Test(priority = 1)
	public void verifyHeading() {
		classtest = report.createTest("Checking Heading");
		Assert.assertTrue(landingpage.isTitleMatched());
		test = classtest.createNode("Heading");

	}

	@Test(priority = 2)
	public void verifyAccomodationLabel() {
		classtest = report.createTest("Verify Accomodation Label ");
		test = classtest.createNode("Accomodation");
		Assert.assertTrue(landingpage.isAccomodation());

	}

	@Test(priority = 3)
	public void CheckLabels() {
		classtest = report.createTest("Check Labels For Hotel and Room Category");
		test = classtest.createNode("labels for hotel and rooms");
		Assert.assertTrue(landingpage.verifyHotelLabel());
		test = classtest.createNode("Room label");
		Assert.assertTrue(landingpage.verifyRoomLabel());
	}

	@Test(priority = 3)
	public void verifyHotelDropdown() {
		classtest = report.createTest("Check Hotel values");
		test = classtest.createNode("Hotel Dropdown");
		Assert.assertTrue(landingpage.isDefault());
		landingpage.HotelValues();
	}

	@Test(priority = 4)
	public void matchRoomnos() throws InterruptedException {
		classtest = report.createTest("Check no. of oprions for Rooms- should be 4");
		test = classtest.createNode("Room choices available");
		Assert.assertTrue(landingpage.Roomno());
	}

	@Test(priority = 5)
	public void matchRoomDropdown() throws InterruptedException {
		classtest = report.createTest("Matching Room Dropdown values");
		test = classtest.createNode("Room Dropdown");
		landingpage.RoomValues();
	}

	@Test(priority = 6)
	public void checkbox() {
		classtest = report.createTest("Verify Checkbox for Additional Charges");
		test = classtest.createNode("Additional Charges Checkbox");
		Assert.assertTrue(landingpage.isSelectable());
		Assert.assertTrue(landingpage.isLabelCorrect());
	}

	@Test(priority = 7)
	public void checkTotalLabel() {
		classtest = report.createTest("Verify Label for Total Amount");
		test = classtest.createNode("Total Price $: label");
		Assert.assertTrue(landingpage.istotalLabelPresent());
	}

}
