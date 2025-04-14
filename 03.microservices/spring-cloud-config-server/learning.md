### how call qa profile from config server
## {configservercontext}//{propertyfile}//profile
# eg: http://localhost:8888/limits-service/qa

# limits-service application name and property name propertyfile should be same.
# spring.application.name= limits-service
#{propertyfile}= limits-service
#config server should always read property from git repository (git-localconfig-repo)

if you want different name of property to be read. you can set below property
#spring.cloud.config.name=


in spring boot 3 
spring ribbion is replaced by netfllix spring loadbalancer. 
and part of eureka netflix cllient.

common conern - monitoring , matrix and resilency security. limit, logging , filtering can be implemented on api gateway.

zuul (api gatway) is replaced by api gateway in spring boot 3 (based on reactive approch spring flux)