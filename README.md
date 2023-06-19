# Foundations of Distributed Systems (Summer Semester 2023) Portfolio Exams 3 and 4

## Introduction

For the module *Foundations of Distributed _Systems_, a portfolio is defined as a form of examination. This means that students must complete several partial examinations over the semester, which are assessed individually. The final grade for this module is made up of partial grades. The partial exams are weighted according to their difficulty.

Four partial exams (i.e. assignments) will be issued this semester. A total of **90 points** can be earned over all four exams. The final grade is then formed from the total number of points achieved according to the usual grading scheme. It is not necessary but of course, recommended to work on all four assignments. Each of the four assignments consists of the development of software in the context of the contents of the lecture.

In this document, the third and fourth assignments are described. **For both tasks, 50 points can be earned**.

# Organization

For each of the four tasks, a separate project is created in our [Bitbucket System of the Faculty of Computer Science and Business Information Systems](https://bitbucket.student.fiw.fhws.de:8443/projects/FDSSZ). A separate repository is created for each student. Students submit their solutions to an assignment with a final push to the `master` branch before the deadline.

| Date               | Description                                       |
| ------------------ | ------------------------------------------------- |
| 2023-06-12         | Publication of the topic of this exam             |
| 2023-07-30 at 3 pm | Deadline to push your final solution to Bitbucket |

Each solution is reviewed and jointly evaluated by two examiners. Each student receives an identical assignment. Each student works on the tasks alone. It is not allowed to share source code or parts of source code with each other. In case of plagiarism, all identical solutions will be excluded from the evaluation.

## The topic of the third portfolio exam (35 points)

1. Develop a REST server for managing events. An event is for example a lecture or a workshop. 
1. Develop a graphical user interface that displays events in a table. Events can be filtered and ordered by different attributes.
1. Extend the existing Postman collection with test cases.

## Requirements

1. Your model classes for events must at least contain the attributes shown in the existing Postman collection.
2. Your server must be implemented in a way so that at least the test cases of the provided Postman collection are running without error. For this, the server must have at least one event in the database on start-up.
3. Your server must allow filtering events by reasonable attributes (it's your task to decide)
4. Your server must allow ordering events by reasonable attributes (it's your task to decide)
5. Your server must provide paging by offset/size.
6. Your server must provide hyperlinks so that the graphical user interface must never construct an URL by itself. This is even true for all types of filter and order attributes including reversing an order.
7. Your server must implement reasonable caching strategies.
8. Your server must contain a graphical user interface that displays events in a table with 10 to 20 entries.
8. Your graphical user interface must open a "detail view" of an event when clicking on the respective row of the table. 
9. Your graphical user interface must support paging, filtering and sorting by using hyperlinks provided by the server.
9. Your graphical user interface *can* (but not must) also provide views for creating, updating, and deleting events. 

## Your tasks

1. Copy all files from this template to **your** repository (don't forget the hidden files, e.g. `.gitignore`). Do **NOT** fork this repository.
2. Add all missing classes in package `de.fhws fiw.fds.exam03`.
3. Implement a graphical user interface in folder `src/main/webapp` using Vue.js 2 or 3.
4. Extend the Postman collection with more test cases to verify hypermedia links. You should, for example, try to implement a verification of **all** hypermedia links. 

## Evaluation criteria

### What we rate

* The quality of the REST server, in particular hypermedia links, filtering, and ordering.
* The implementation of the graphical user interface, in particular hypermedia handling. (We will use it.)
* The test cases are implemented as Postman scripts. (We will execute them.)
 
### What we do not rate

* Commit history in Bitbucket
* Documentation is not (and should not be) necessary
* The design of the graphical user interface (unless you choose colors that make me sick)

# The topic of the fourth portfolio Exam (15 points)

* Record a short screencast in which you explain your implementation of the server (not the graphical user interface) and demonstrate that the graphical user interface works as expected.

## Your tasks

* Record the screencast and store the video in format MP4 in the root directory of the repository.
* The video should have at least a screen resolution of 720p, better would be 1080p. But not more.
* The video should not be larger than 15 to 20 MB (just a guess). Use compression tools like `ffmpeg` (Linux, macOS) or Handbrake (all platforms). 
## Requirements

* You must explain in the video how you implemented filtering and ordering by showing source code in the IDE.
* You must in particular explain how you implemented the hypermedia principle by showing source code in the IDE.
* You must show where you implemented caching and briefly explain the caching strategy. 
* You must show the graphical user interface in a Web browser and demonstrate filtering and ordering. 
* You must record your voice. You can speak English or German. 
* You **must not** record yourself. 
* It is **not** necessary to use slides in addition to the screencast. No title page, no agenda page, no summary page. 

## Evaluation criteria

### What we rate

* The quality of the contents of your presentation. 
* How did you structure your presentation?
* Did you cover all requirements? 

### What we do not rate

* It doesn't matter if you use English or German.
