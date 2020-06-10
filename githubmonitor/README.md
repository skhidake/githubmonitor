## GetHub Monitoring API using Spring Boot 

	Run com.ssk.git.monitor.controller.GithubController as a Java Application.
	
	Runs on default port of Spring Boot - 8080

## REST API endpoint : 
	http://localhost:8080/<owner>/<repo>/events
	
	e.g.: http://localhost:8080/skhidake/githubmonitor/events

Used spring RestTemplate API to invoke Github rest endpoint
	
	https://api.github.com/repos/{owner}/{repo}/events


## Can be run as a Jar 

	`mvn clean install` generate a jar which could run on server or local server

