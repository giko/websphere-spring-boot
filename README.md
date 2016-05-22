# websphere-spring-boot
Launch your websphere server to space with spring boot.

This project demonstrates the possibility of launching spring boot + data jpa + hibernate apps in WAS 8.5.5.9 (lower versions aren't possible)

Main magic happens in HikariCPConfig && HibernatePersistenceProviderResolver. Basically it uses tips from http://stackoverflow.com/a/34487223

In some cases you'll also need to set your classloader setting to parent last.
