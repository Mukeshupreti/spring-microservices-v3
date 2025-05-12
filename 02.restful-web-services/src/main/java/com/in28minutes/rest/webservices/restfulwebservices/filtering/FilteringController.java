package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
// MappingJacksonValue.setFilter(FilterProvider)
// MappingJacksonValue(Object to be filter filer)
//
@RestController
public class FilteringController {
	
	@GetMapping("/filtering") //field2
	public MappingJacksonValue filtering() {
		
		SomeBean someBean = new SomeBean("value1","value2", "value3");
        // put bean to filter
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		// define filter using SimpleBeanPropertyFilter.filterOutAllExcept
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");

		// add filter in filter provider
		FilterProvider filters = 
				new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		// provide filter to mappingJacsonValue
		mappingJacksonValue.setFilters(filters );
		
		
		return mappingJacksonValue;
		// output:

		//  "field3": "value3"
		//}
	}

	@GetMapping("/filtering-list") //field2, field3
	public MappingJacksonValue filteringList() {

		List<SomeBean1> list = Arrays.asList(new SomeBean1("value1","value2", "value3"),
				new SomeBean1("value4","value5", "value6"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		
		FilterProvider filters = 
				new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		
		mappingJacksonValue.setFilters(filters );
		return mappingJacksonValue;
	}

}
