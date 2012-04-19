My Wicket in Action
==================

Me coding along to Wicket in Action.


Prerequisites
-------------

* Java 1.6 or 1.7
* Maven (2.2.1 or 3.0.3)
# (not needed yet) * PostgreSQL 9.1 (earlier or later versions may also work)


Installation
------------

To clone the repo:

    git clone git@github.com:frankoid/my-wicket-in-action.git

# (not needed yet) To create the PostgreSQL user and database (Mac OS X, postgresql91-server MacPort installed and loaded):

    psql91 -U postgres -c "CREATE ROLE my_wicket_in_action PASSWORD 'password' CREATEDB LOGIN"
    psql91 -U my_wicket_in_action -d postgres -c "CREATE DATABASE my_wicket_in_action"
    mvn compile hibernate3:hbm2ddl

# (not needed yet) To create the PostgreSQL user and database (Debian Squeeze X, postgresql84-server package installed, */etc/postgresql/8.4/main/pg_hba.conf edited to allow md5 authentication instead of ident* (see http://www.stuartellis.eu/articles/postgresql-setup/) and /etc/init.d/postgres started):

    psql -U postgres -c "CREATE ROLE my_wicket_in_action ENCRYPTED PASSWORD 'password' CREATEDB LOGIN"
    psql -U my_wicket_in_action -d postgres -c "CREATE DATABASE my_wicket_in_action"
    mvn compile hibernate3:hbm2ddl

To run the project:

    mvn jetty:run

To run the unit tests:

	mvn test

To run the integration tests:

    mvn verify
