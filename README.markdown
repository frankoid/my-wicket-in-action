Wicket Experiments
==================

Sandbox for trying things out with Apache Wicket.


Prerequisites
-------------

* Java 1.6 or 1.7
* Maven (2.2.1 or 3.0.3)
* PostgreSQL 9.1 (earlier or later versions may also work)


Installation
------------

To clone the repo:

    git clone git@github.com:brightinteractive/wicket-experiments.git

To create the PostgreSQL user and database (Mac OS X, postgresql91-server MacPort installed and loaded):

    psql91 -U postgres -c "CREATE ROLE wicket_experiments PASSWORD 'password' CREATEDB LOGIN"
    psql91 -U wicket_experiments -d postgres -c "CREATE DATABASE wicket_experiments"
    mvn compile hibernate3:hbm2ddl

To create the PostgreSQL user and database (Debian Squeeze X, postgresql84-server package installed, */etc/postgresql/8.4/main/pg_hba.conf edited to allow md5 authentication instead of ident* (see http://www.stuartellis.eu/articles/postgresql-setup/) and /etc/init.d/postgres started):

    psql -U postgres -c "CREATE ROLE wicket_experiments ENCRYPTED PASSWORD 'password' CREATEDB LOGIN"
    psql -U wicket_experiments -d postgres -c "CREATE DATABASE wicket_experiments"
    mvn compile hibernate3:hbm2ddl

To run the project:

    mvn jetty:run

To run the unit tests:

	mvn test

To run the integration tests:

    mvn verify

Continuous Integration
----------------------

http://jenkins.bright-interactive.com/job/Asset%20Bank%20Addon%20Example/
