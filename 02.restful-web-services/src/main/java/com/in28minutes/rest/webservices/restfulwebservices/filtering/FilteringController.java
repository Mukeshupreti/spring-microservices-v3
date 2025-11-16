package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
// Step 0: Register the bean to filter here (somebean) with the name @JsonFilter(""SomeBeanFilter1")
//Step 1 : create filter using SimpleBeanPropertyFilter  and  in Filter provider (("SomeBeanFilter1")
//step 2 :  MappingJacksonValue : set Filterprovider and object to be filter
//Step 3: return MappingJacksonValue (will be filterd record)

//-- set bean to filter as value and set filter
//public class MappingJacksonValue {
//    private Object value;
//    @Nullable
//    private Class<?> serializationView;
//    @Nullable
//    private FilterProvider filters;


@RestController
public class FilteringController {
	// output:
/*	{
		"field1": "value1",
			"field3": "value3"
	}*/
	@GetMapping("/filtering") //field2
	public MappingJacksonValue filtering() {
		
		SomeBean someBean = new SomeBean("value1","value2", "value3");
        // put bean to filter
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		// define filter using SimpleBeanPropertyFilter.filterOutAllExcept
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3"); // filter out field2

		// add filter in filter provider this id SomeBeanFilter1
        // register the bean(id: SomeBeanFilter1) with @JsonFilter("SomeBeanFilter1")
		// this is linking between filter and your somebean
		FilterProvider filters = 
				new SimpleFilterProvider().addFilter("SomeBeanFilter1", filter );
		// provide filter to mappingJacsonValue
		mappingJacksonValue.setFilters(filters );
		
		
		return mappingJacksonValue;

	}
 //output

/*[
	{
		"field2": "value2",
			"field3": "value3"
	},
	{
		"field2": "value5",
			"field3": "value6"
	}
]*/
	@GetMapping("/filtering-list") //field2, field3
	public MappingJacksonValue filteringList() {

		List<SomeBean1> list = Arrays.asList(new SomeBean1("value1","value2", "value3"),
				new SomeBean1("value4","value5", "value6"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3"); // filter out filed2
		
		FilterProvider filters = 
				new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		
		mappingJacksonValue.setFilters(filters );
		return mappingJacksonValue;
	}

}
