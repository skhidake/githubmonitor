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

	
*****************************************************************************************


## Web Page created for displaying in html format

	http://localhost:8080/view/<owner>/<repo>/events

	e.g. : http://localhost:8080/view/skhidake/githubmonitor/events

## Sample output
	Github owner: skhidake!
	
	Github Repository: githubmonitor!
	
	Id			Type		Created At				Actor Id	Actor Name
	12588795215	PushEvent	2020-06-10T08:33:15Z	20010350	skhidake
	12588748370	PushEvent	2020-06-10T08:28:36Z	20010350	skhidake
	12588642785	PushEvent	2020-06-10T08:17:52Z	20010350	skhidake
	12587583490	CreateEvent	2020-06-10T06:11:59Z	20010350	skhidake
	12587583239	CreateEvent	2020-06-10T06:11:57Z	20010350	skhidake

## Pending Items
	Pagination
	Sorting

## Error Handling
	Generic exception handling added only for GithubController.java , could be enable at class level as well as application level
	
	
	