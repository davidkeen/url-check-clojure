# url-check

Checks a collection of URLs. Anything other than a 200-207/300-307 response is considered a failure.

## Installation

Download from https://gitlab.com/davidkeen/url-check-clojure.

Database schema:

    CREATE TABLE `event` (
      `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
      `url` varchar(255) DEFAULT NULL,
      `start` date DEFAULT NULL,
      `finish` date DEFAULT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

## Usage

Run using Leiningen

    $ lein run

## License

Copyright © 2016 David Keen

Distributed under the MIT License.
