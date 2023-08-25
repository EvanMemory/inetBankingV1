package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

    WebDriver driver;

    public AddCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
    @CacheLookup
    WebElement linkAddNewCustomer;

    @FindBy(how = How.NAME, using = "name")
    @CacheLookup
    WebElement txtCustomerName;

    @FindBy(how = How.NAME, using = "rad1")
    @CacheLookup
    WebElement rdGender;

    @FindBy(how = How.ID_OR_NAME, using = "dob")
    @CacheLookup
    WebElement txtDob;

    @FindBy(how = How.NAME, using = "addr")
    @CacheLookup
    WebElement txtAddress;

    @FindBy(how = How.NAME, using = "city")
    @CacheLookup
    WebElement txtCity;

    @FindBy(how = How.NAME, using = "state")
    @CacheLookup
    WebElement txtState;

    @FindBy(how = How.NAME, using = "pinno")
    @CacheLookup
    WebElement txtPinNo;

    @FindBy(how = How.NAME, using = "telephoneno")
    @CacheLookup
    WebElement txtTelePhoneNo;

    @FindBy(how = How.NAME, using = "emailid")
    @CacheLookup
    WebElement txtEmailId;

    @FindBy(how = How.NAME, using = "password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(how = How.NAME, using = "sub")
    @CacheLookup
    WebElement btnSubmit;

    public void clickAddNewCustomer() {
        linkAddNewCustomer.click();
    }

    public void custName(String cname) {
        txtCustomerName.sendKeys(cname);
    }

    public void custGender(String cgender) {
        rdGender.click();
    }

    public void custDob(String mm, String dd, String yy) {
        txtDob.sendKeys(mm);
        txtDob.sendKeys(dd);
        txtDob.sendKeys(yy);
    }

    public void custAddress(String caddress) {
        txtAddress.sendKeys(caddress);
    }

    public void custCity(String ccity) {
        txtCity.sendKeys(ccity);
    }

    public void custState(String cstate) {
        txtState.sendKeys(cstate);
    }

    public void custpinno(String cpinno) {
        txtPinNo.sendKeys(String.valueOf(cpinno));
    }

    public void custTelephoneNo(String ctelephoneno) {
        txtTelePhoneNo.sendKeys(ctelephoneno);
    }

    public void custEmailId(String cemailid) {
        txtEmailId.sendKeys(cemailid);
    }

    public void custPassword(String cpassword) {
        txtPassword.sendKeys(cpassword);
    }

    public void custSubmit() {
        btnSubmit.click();
    }
}
