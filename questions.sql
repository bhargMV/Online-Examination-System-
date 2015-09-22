-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 21, 2012 at 08:16 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `onlineexam`
--

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE IF NOT EXISTS `questions` (
  `QNo` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `Question` varchar(350) NOT NULL,
  `Option1` varchar(200) NOT NULL,
  `Option2` varchar(200) NOT NULL,
  `Option3` varchar(200) NOT NULL,
  `Option4` varchar(200) NOT NULL,
  `Answer` varchar(20) NOT NULL,
  PRIMARY KEY (`QNo`),
  UNIQUE KEY `Question` (`Question`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`QNo`, `Question`, `Option1`, `Option2`, `Option3`, `Option4`, `Answer`) VALUES
(1, 'What''s the difference between servlets and applets? <br/> 1.Servlets executes on Servers, where as Applets executes on Browser <br/>2.Servlets have no GUI, where as an Applet has GUI <br/> 3.Servlets creates static web pages, where as Applets creates dynamic web pages <br/>4.Servlets can handle only a single request, where as Applet can handle mult', '1,2,3 are correct', '1,2 are correct', '1,3 are correct', '1,2,3,4 are correct ', '2'),
(2, 'The major difference between servlet and CGI is', 'Servlets are thread based and CGI is process based', 'Servlets executes slower compared to CGI', 'Servlet has no platform specific API, where as CGI has', 'All of the above', '3'),
(3, ' What is the limit of data to be passed from HTML when doGet() method is used?', '4K', '8K', '2K', '1K ', '3'),
(4, 'Which method is used to specify before any lines that uses the PintWriter?', 'setPageType()', 'setContextType()', 'setContentType()', 'setResponseType() ', '3'),
(5, 'Which of the following are the session tracking techniques?', 'URL rewriting, using session object, using response object, using hidden fields', 'URL rewriting, using session object, using cookies, using hidden fields', 'URL rewriting, using servlet object, using response object, using cookies', 'URL rewriting, using request object, using response object, using session object ', '2'),
(6, 'RequestDispatcher object is used', 'to include other resources', 'to include an image', 'to include xml object', 'to include e-mailing response ', '1'),
(7, 'To get the servlet environment information', 'ServletConfig object is used', 'ServletException object is used', 'ServletContext object is used', 'ServletContainer object is used', '3'),
(8, 'The getSession() method with ‘true’ as its parameter [ getSession(true) ] it will return the appropriate session object when', 'the session is completed', 'the session object is passed to another method', 'the session does not exists', 'the session is existing', '4'),
(9, 'A deployment descriptor describes', 'web component response settings', 'web component settings', 'web component request objects', 'All of the above ', '2'),
(10, 'The values of <servlet-name> and <servlet-class> in web.xml file', 'must be same', 'must not be same', 'may be same', 'None of the above ', '3'),
(11, 'The method forward(request,response) will', 'return back to the same method from where the forward was invoked', 'not return back to the same method from where the forward was invoked and the web pages navigation continues', 'Both A and B are correct', 'None of the above', '1'),
(12, 'A servlet maintain session in', 'Servlet container', 'Servlet context', 'Servlet request heap', 'Servlet response heap', '2'),
(13, 'Servlet mapping defines', 'an association between a URL pattern and a servlet', 'an association between a URL pattern and a request page', 'an association between a URL pattern and a response page', 'All of the above', '1'),
(14, 'The life cycle of a servlet is managed by', 'servlet context', 'servlet container', 'the supporting protocol (such as http or https)', 'All of the above', '2'),
(15, 'The init parameter name and value pairs that are defined in web.xml file are handled by', 'ServletConfig object', 'ServletContext object', 'ServletRequest object', 'ServletResponse objet', '1'),
(16, 'How many ServletContext objects are available for an entire web application?', 'One each per servlet', 'One each per request', 'One each per response', 'Only one', '4'),
(17, 'What are the mechanisms available in ServletContextListener interface?', 'contextInit(), contextService(), contextDestroyed()', 'contextInitialized((),contextDestroyed()', 'contextInitialized(), contextService(), contextDestroyed()', 'None of the above', '2'),
(18, 'The include() method of RequestDispatcher', 'sends a request to another resource like servlet, jsp or html', 'includes resource of file like servlet, jsp or html', 'appends the request and response objects to the current servlet', 'None of the above', '2'),
(19, ' Dynamic interception of requests and responses to transform the information is done by', 'servlet container', 'servlet config', 'servlet context', 'servlet filter', '4'),
(20, 'The tasks – authentication-blocking of requests, data compression, logging and auditing – are performed by', 'servlet filter', 'servlet config', 'servlet context', 'servlet container ', '1');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
