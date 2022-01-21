USE [master]
GO

/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [java]    Script Date: 15.01.2022 22:05:32 ******/
CREATE LOGIN [java] WITH PASSWORD='java', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO

ALTER LOGIN [java] DISABLE
GO

ALTER SERVER ROLE [sysadmin] ADD MEMBER [java]
GO
