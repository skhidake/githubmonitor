# GetHub Monitoring API using Spring Boot 

# Run com.ssk.git.monitor.controller.GithubController as a Java Application.

# Runs on default port of Spring Boot 
	8080

# Rest endpoint : 
	http://localhost:8080/<owner>/<repo>/events

	e.g.: http://localhost:8080/skhidake/githubmonitor/events

Application internally invokes below REST API using spring RestTemplate API
	
		https://api.github.com/repos/{owner}/{repo}/events


## Can be run as a Jar or a WAR

`mvn clean install` generate a jar which could run on server or local server

