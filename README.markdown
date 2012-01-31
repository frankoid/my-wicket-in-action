Asset Bank Addon Example
========================

This is an example of / starting point for Java webapps that integrate with
Asset Bank. It's currently a work in progress. When it's finished it will
demonstrate SSO (so that users can use their Asset Bank account in the addon
app) and building using Maven.

Wiki page: http://wiki.bright-interactive.com/display/knowhow/Asset+Bank+Addon+Apps


Prerequisites
-------------

* Java 1.6 or 1.7
* Maven (2.2.1 or 3.0.3)
* PostgreSQL 9.1 (earlier or later versions may also work)


Installation
------------

To clone the repo:

    git clone git@github.com:brightinteractive/assetcloud.git

To create the PostgreSQL user and database:

    psql91 -U postgres -c "CREATE ROLE asset_bank_addon_example PASSWORD 'password' CREATEDB LOGIN"
    psql91 -U asset_bank_addon_example -d postgres -c "CREATE DATABASE asset_bank_addon_example"
    mvn hibernate3:hbm2ddl

To run the project:

    mvn jetty:run

To run the unit tests:

	mvn test

To run the integration tests:

    mvn verify

Continuous Integration
----------------------

http://jenkins.bright-interactive.com/job/Asset%20Bank%20Addon%20Example/
