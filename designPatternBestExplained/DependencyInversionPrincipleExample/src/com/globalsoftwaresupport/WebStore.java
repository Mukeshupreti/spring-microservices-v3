package com.globalsoftwaresupport;

// this is a high level module
public class WebStore {

	private PaymentController controller;
	
	public WebStore() {
		controller = new PaymentController();
		controller.setPaymentMethod(new Payoneer());
	}
	
	public void purchaseItem() {
		this.controller.pay();
	}
}
