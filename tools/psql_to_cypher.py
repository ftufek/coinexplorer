#!/usr/bin/python
import psycopg2
import sys
from optparse import OptionsParser #will be useful for cmd line arg parsing

#The goal of this script is to transform data generated from bitcoin-abe
#and stored in the PostgreSQL DB into a cypher query file which can then
#be executed from neo4j-shell to import data in the neo4j DB

def main():
    conn_string = "host='localhost' dbname='abe' user='user'"
    print "Connecting to database\n ->%s" % (conn_string)
    conn = psycopg2.connect(conn_string)
    cursor = conn.cursor()
    print "Connected!\n"

def migrations():
    return """
        CREATE CONSTRAINT ON (a:Address) ASSERT a.address IS UNIQUE;
        MERGE (coinbase:Address{address:0});
    """

if __name__ == "__main__":
    main()
