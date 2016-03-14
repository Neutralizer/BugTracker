# BugTracker
Designed to add issues and to store them in a database.<br/>
<p/>
	<p>1. Short description:<p/>
<blockquote>	This project is designed as a bug base application, via which the user is able to add issues and to store them in a database. Furthermore the user is required to register a username, that is stored also in the database and by doing so he must choose one of the roles available - Admin, Developer or Quality assurance.<blockquote/>
	2. Role security restriction:<br/>
	After a defect has been created, it can be viewed, edited or deleted, but the developer role has limitations to these functionalities - a developer can only view a defect, because it is not intended for him to be able to add a defect (nor edit it, nor delete it) - that is the job of a user with a Quality assurance role. Every defect can have comments, indicating its life cycle - who has been working on the defect, what was the status of the defect and when this defect was closed. The search function uses a separate method, that utilizes HQL and the LIKE keyword, thus able to extract only part of the object and not pulling everything. It can be used by all roles available and is used to filter the defects by their title.<br/>
	3. How to run it:<br/> 
	In order to run this project you must first run  BugTracker/BugTracker/src/main/java/utils/LoadRoles.java file, which has a main method that creates the hard coded roles for user creation. Hibernate then creates the rest of required tables, which are defect, Defect_comment and user tables. Don't forget to set your database connection settings for hibernate by changing  BugTracker/BugTracker/src/main/resources/hibernate.cfg.xml . After this you must run this project on a server and access it via localhost.<br/>
    4. Technologies used:<br/> 
    This project uses Hibernate ORM framework, HQL, Spring MVC, Spring security, JSP, Builder is used for the main class - DefectImpl, making it immutable;<br/> 
    5. Defect life cycle:<br/> 
    When a new defect is added it is with status NEW by default and the QA user must add title and description. His username is filled in automatically via Spring login information, that is extracted from the database. After that the developer can add his name in assigned to field, thus marking the defect as his responsibility. After the defect has been fixed the fixer must set the status as - FIXED_TO_CONFIRM and notify so in the comments by adding the version of the fix, making the defect QA responsibility. After QA dept. tests the defect he on the other side must mark the defect accordingly - REOPENED - if the defect was not fixed, or CONFIRMED_AS_FIXED if the defect is fixed and write the outcome in the comments with the appropriate version and any steps if required.
    
