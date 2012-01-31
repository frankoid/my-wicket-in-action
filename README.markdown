Asset Bank Addon Example
========================

This is an example of / starting point for Java webapps that integrate with
Asset Bank. It's currently a work in progress. When it's finished it will
demonstrate SSO (so that users can use their Asset Bank account in the addon
app) and building using Maven.

Wiki page: http://wiki.bright-interactive.com/display/knowhow/Asset+Bank+Addon+Apps


Prerequisites
-------------

* Java 1.6
* Maven (2.2.1 or 3.0.3)


Installation
------------

To clone the repo:

    git clone git@github.com:brightinteractive/assetcloud.git

To run the project:

    mvn jetty:run

To run the tests:

	mvn test

Continuous Integration
----------------------

http://jenkins.bright-interactive.com/job/Asset%20Bank%20Addon%20Example/
