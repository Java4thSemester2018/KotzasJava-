# JAVA DATABASE PART 2

## Για την ασκηση 1

Εγκαταστήστε και παραμετροποιήστε τον Tomcat application server (εάν
 μπορείτε να χρησιμοποιήσετε άλλον αντίστοιχο) και το Σύστημα
Διαχείρισης Βάσης Δεδομένων (mysql ή postgress). Η εγκατάσταση του application
server να συνδεθεί με το περιβάλλον IDE που χρησιμοποιείτε (π.χ. Eclipse).


1. βαλτε Tomcat στο pc
2. κατεβαστε το τελευταιο https://jdbc.postgresql.org/
3. και πεταχτε το μεσα στο lib του TOMCAT
4. πατηστε το start στο bin του TOMCAT
5. και τωρα τρεχει ο Τομκατ 
6. μετα στο terminal:
```
psql -U postgres
```

   an den doulevei tote

	```
	
	$ cd /etc/postgresql/9.6/main
	$ sudo nano pg_hba.conf 
	
	#Database administrative login by Unix domain socket
	local   all             postgres                              trust
	apo peer to vazete trust

	```
```
CREATE USER kotz101 WITH PASSWORD 'qwerty';
```
7. και τωρα λογικα στο JavaBasics Project το αρχειο DatabaseLinker.java θα λειτουργει κομπλε
# ΣΕ ΠΕΡΙΠΤΩΣΗ ΠΟΥ ΚΑΝΕΤΕ OVERWRITE ΤΟ JAVA PROJECT EΞΟΛΟΚΛΗΡΟΥ
Θα πρεπει τουλαχιστον στο .classpath arxeio na adikatastisete tin grami
```
		<classpathentry kind="lib" path="/home/neetshonen/Programs/apache-tomcat-8.5.30/lib/postgresql-42.2.2.jar"/>

```
me to diko sas path
