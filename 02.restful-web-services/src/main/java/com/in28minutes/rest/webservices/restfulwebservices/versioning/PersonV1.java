package com.in28minutes.rest.webservices.restfulwebservices.versioning;


/*  four type of versioning
	URI Versioning
	Request Param Versioning
	Header Versioning
	Content Negotiation Versioning
*/


public class PersonV1 {
	private String name;

	public PersonV1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}

}
