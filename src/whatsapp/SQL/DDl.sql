CREATE TABLE `calls` (
  `From` int(11) NOT NULL,
  `To` int(11) NOT NULL,
  `Time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `callstatus` varchar(100) NOT NULL,
  `duration` double NOT NULL,
  `counttry` varchar(100) NOT NULL,
  `ifvideo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `contacts` (
  `userid` int(11) NOT NULL,
  `contacts` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `groupmembers` (
  `group id` int(11) NOT NULL,
  `Member` varchar(100) NOT NULL,
  `addition_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `admin` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`group id`,`Member`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `groups` (
  `name` varchar(100) NOT NULL,
  `image` longblob DEFAULT NULL,
  `no of admins` int(11) NOT NULL,
  `Created by` int(11) NOT NULL,
  `Starting time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `groupid` double NOT NULL,
  PRIMARY KEY (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `individual_text_chat` (
  `sender` int(11) NOT NULL,
  `reciever` int(11) NOT NULL,
  `message` varchar(200) NOT NULL,
  `Time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `messagestatus` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
  `Number` int(11) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `Description` varchar(150) NOT NULL DEFAULT 'Hey there! I am using whatsapp.',
  `Connectivity` varchar(10) NOT NULL,
  `Image` blob DEFAULT NULL,
  PRIMARY KEY (`Number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
