### static filtering
## class level
@JsonIgnoreProperties({"field1","field2"}) 

## fieled level
@JsonIgnore // this static filtering

@JsonProperty("user_name")
private String name;


## Dynamic filtering

### Step 0:
Register the bean to filter here (somebean) with the name @JsonFilter(""SomeBeanFilter1")
### Step 1 :
create filter using SimpleBeanPropertyFilter  and  in Filter provider (("SomeBeanFilter1")
### step 2 :
MappingJacksonValue : set Filterprovider and object to be filter
### Step 3:
return MappingJacksonValue (will be filterd record)

//-- set bean to filter as value and set filter
//public class MappingJacksonValue {
//    private Object value;
//    @Nullable
//    private Class<?> serializationView;
//    @Nullable
//    private FilterProvider filters;
	