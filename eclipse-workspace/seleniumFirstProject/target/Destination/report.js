$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MyTest.feature");
formatter.feature({
  "line": 1,
  "name": "Reset functionality on login page of Application",
  "description": "",
  "id": "reset-functionality-on-login-page-of-application",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Verification of Reset button",
  "description": "",
  "id": "reset-functionality-on-login-page-of-application;verification-of-reset-button",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Open the Firefox and launch the application",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Enter the Username and Password",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Reset the credential",
  "keyword": "Then "
});
formatter.match({
  "location": "SeleniumFirstTest.launchBrowser()"
});
formatter.result({
  "duration": 45417948024,
  "error_message": "java.lang.AssertionError: expected:\u003c0\u003e but was:\u003c22\u003e\n\tat org.junit.Assert.fail(Assert.java:88)\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\n\tat org.junit.Assert.assertEquals(Assert.java:645)\n\tat org.junit.Assert.assertEquals(Assert.java:631)\n\tat seleniumFirstProject.SeleniumFirstTest.launchBrowser(SeleniumFirstTest.java:154)\n\tat ✽.Given Open the Firefox and launch the application(MyTest.feature:7)\n",
  "status": "failed"
});
formatter.match({
  "location": "SeleniumFirstTest.enter_the_Username_and_Password()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SeleniumFirstTest.Reset_the_credential()"
});
formatter.result({
  "status": "skipped"
});
});