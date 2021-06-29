
******************************
SQL queries:
Tables created - Departments, Employees, Courses, Course_Schedule;

insert into Departments values(1,7,"Computer Science");

insert into Departments values(2,8,"Data Sciences");

insert into Departments values(3,5,"Software Engineering");

insert into Departments values(4,8,"Network Communication & Signal Processing");

insert into Departments values(5,3,"VLSI");

insert into Departments values(6,7,"Information Technology & Society");

insert into Departments values(7,4,"Mathematics & Basic Sciences");

****************************************************
insert into Employees values(2, "ashish.choudhury@iiitb.ac.in", "Ashish", "Choudhury", "1234", "Ashish-Choudhury.jpeg", "Associate professor", 1);

insert into Employees values(3, "meenakshi@iiitb.ac.in", "Meenakshi", "D'Souza", "1234", "Prof_Meenakshi_D_Souza_1.jpeg", "Associate professor",1);

insert into Employees values(4, "rc@iiitb.ac.in", "Chandrashekhar", "Ramanathan", "1234", "chandrashekar1.jpeg", "Professor", 2); 

insert into Employees values(5, "jdinesh@iiitb.ac.in", "Dinesh", "Babu", "1234", "Prof_Dinesh_Babu_Jayagopi.jpeg", "Associate Professor", 2);

insert into Employees values(6, "sujitkc@iiitb.ac.in", "Sujit", "Chakrabarti", "1234", "Prof_Sujith.jpeg", "Associate Professor", 3); 

insert into Employees values(7, " ddas@iiitb.ac.in", "Debabrata", "Das", "1234", "Prof_Debabrata_Das_1.jpeg", "Director", 4);

insert into Employees values(8, "madhav.rao@iiitb.ac.in", "Madhav", "Rao", "1234", "Prof_Madhav_Rao.jpeg", "Associate Professor", 5); 

insert into Employees values(9, "amitprakash@iiitb.ac.in", "Amit", "Prakash", "1234", "Amit_Prakash_Apr2019.jpeg", "Associate Professor", 6);

insert into Employees values(10, "manisha.kulkarni@iiitb.ac.in", "Manisha", "Kulkarni", "1234", "Manisha_Kulkarni_.jpeg", "Associate Professor",7);

*********************************************************
insert into Courses values(1,150,"CS511",4,"","Algorithms","Aug-Dec",2020-21,NULL);

insert into Courses values(2,150,"CS711",4,"","Advanced Algorithms","Aug-Dec",2020-21,NULL);

insert into Courses values(3,150,"CS513",4,"","Software Systems","Aug-Dec",2020-21,NULL);

insert into Courses values(4,100,"CS825",4,"","Computational Sustainability","Aug-Dec",2020-21,NULL);

insert into Courses values(5,300,"AI512",4,"","MML","Aug-Dec",2020-21,NULL);

insert into Courses values(6,50,"NC824",4,"","IOT","Aug-Dec",2020-21,NULL);

insert into Courses values(7,150,"NC850",4,"","Foundations of Cryptography","Aug-Dec",2020-21,NULL);

*******************************************************************
insert into Course_Schedule values(4,"B1",3,"Wednesday","R105","16:00",3);

insert into Course_Schedule values(5,"B1",3,"Saturday","R105","16:00",3);

insert into Course_Schedule values(6,"B1",4,"Monday","R105","16:00",4);

insert into Course_Schedule values(7,"B1",4,"Tuesday","R105","16:00",4);

insert into Course_Schedule values(8,"B1",5,"Monday","R105","11:00",5);

insert into Course_Schedule values(9,"B1",5,"Tuesday","R105","11:00",5);

insert into Course_Schedule values(10,"B1",6,"Friday","R105","11:00",6);

insert into Course_Schedule values(11,"B1",6,"Saturday","R105","11:00",6);

insert into Course_Schedule values(12,"B1",7,"Friday","R105","11:00",7);

insert into Course_Schedule values(13,"B1",7,"Saturday","R105","11:00",7);


