# Analytic Workbench - Infrastructure

| Version  |      Travis   | 
|----------|:-------------:|
| Master   | [![Build Status](https://travis-ci.org/ScipionyxIO/analytic-workbench-product-infrastructure.svg?branch=master)](https://travis-ci.org/ScipionyxIO/analytic-workbench-product-infrastructure) | 
| 0.0.1 	   | [![Build Status](https://travis-ci.org/ScipionyxIO/analytic-workbench-product-infrastructure.svg?branch=0.0.1)](https://travis-ci.org/ScipionyxIO/analytic-workbench-product-infrastructure) |


## Motivation
This project will house all infrastructure project that will support all microservices.
## Projects
- Docker
- Elastic
- Gateway
## Docker
The following configuration should be provided under Maven's settings.xml

	<servers>
		<server>
			<id>hub.docker.com</id>
			<username><USE></username>
			<password><PASSWORD></password>
		</server>
	</servers>
	
## Gateway
### Provides
This component provides the following services:
- Zuul Gateway
- Authorization Server


### Authorization Server ()
End points for the Authorization Server:
* /oauth/authorize 
* /oauth/authorize,	methods=[POST],		params=[user_oauth_approval]
* /oauth/token,		methods=[GET]
* /oauth/token,		methods=[POST]
* /oauth/check_token
* /oauth/confirm_access
* /oauth/error 

### References
- http://www.swisspush.org/security/2016/10/17/oauth2-in-depth-introduction-for-enterprises
- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-security.html
- https://stackoverflow.com/questions/45579623/what-the-configuration-of-spring-security-oauth2-authorizedgranttypes-means-in-p	
