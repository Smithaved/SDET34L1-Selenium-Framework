package com.vitiger.contacts.tcases;

import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.vtiger.ElementRepository.ContactPage;

public class ViewContactsDropdownTc16Test extends BaseClass{
	@Test
	public  void viewContactsDropdownTc16Test() {
		ContactPage contactPage=new ContactPage(driver);
		homepage.clickContact();
		contactPage.clickViewContact();
	}

}
