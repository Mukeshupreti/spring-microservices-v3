package com.in28minutes.rest.webservices.restfulwebservices.versioning;
/*  four type of versioning
	URI Versioning
	Request Param Versioning (params)
	Header Versioning (headers)
	Content Negotiation Versioning
*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	// URI versioning

	// it contains only name string
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob");
	}
  /// in version 2 it contains Name object (firstName and lastName)
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	////Request Param Versioning

  /// http://localhost:8080/person?version=1
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstVersionOfPersonRequestParameter() {
		return new PersonV1("Bob ");
	}
 /// http://localhost:8080/person?version=2
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParameter() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}


	///Header Versioning

// pass header X-API-VERSION="application/vnd.company.app-v1+json"
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeader() {
		return new PersonV1("Bob");
	}
// pass header X-API-VERSION="application/vnd.company.app-v2+json"
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

////	Content Negotiation Versioning
  // pass header Accept="application/vnd.company.app-v1+json"
	// Media type
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonAcceptHeader() {
		return new PersonV1("Bob");
	}
  // pass header Accept="application/vnd.company.app-v2+json"
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

}
