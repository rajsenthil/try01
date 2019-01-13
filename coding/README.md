# Presto Coding assignment

This is to code the given assignment

## Getting Started



### Prerequisites

Apache Maven 3.6.0 is used but later other version may also work.
Ubuntu 18.10 is the OS to run the command *run.sh* though any linux/unix os may work.
Jdk 1.8 is used for development. For jdk 9 or 10 or 11, the jdk xml modules (jaxb-api, jaxb-core, jaxb-impl) needs to be add as dependency.

The below port numbers are reserved to run this assignment.

Port | 8080 | 9092
--- | --- | ---
Server | Jetty | H2 db

### Installing

Clone the assignment 
```
$ git clone git@github.com:rajsenthil/try01.git
```
and 
```
$cd coding
```

Using the below maven command, the assignemnt can be installed.
Also set the proxy accordingly, if you are behind the firewall.

```
$ mvn clean install
```

## Running the tests
Use the run.sh to start and run the assignment. This will bring the jetty and h2 server up and running
Make sure that the run.sh is executable.

```
$./run.sh

```

### Get the menus

The rest service is consumed at the url localhost:8080 with restaurant id and menu id, from any browser or any rest client.

```
http://localhost:8080/menu/0/1
```

### Test cases

The tests cases are not really unit cases but more for testing the function.
This is to speed up the setup and testing

## Authors

* **Senthil Rajendran** - *Initial work* - [rajsenthil](https://github.com/rajsenthil/try01/tree/master/coding)

See also the list of [modules](https://github.com/rajsenthil/coding).

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Stacktrace/forums and google search
* The menu is designed based on this [document](https://cdn2.hubspot.net/hubfs/412971/Comprehensive-Menu-Reference-Guide.pdf?t=1482418002169)