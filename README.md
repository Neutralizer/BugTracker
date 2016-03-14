# BugTracker

	This project is designed as a bug base application, via which the user is able to add issues and to store them in a database. Furthermore the user is required to register a username, that is stored also in the database and by doing so he must choose one of the roles available - Admin, Developer or Quality assurance. 
	After a defect has been created, it can be viewed, edited or deleted, but the deveoper role has limitations to these functionalities - a developer can only view a defect, because it is not intended for him to be able to add a defect (nor edit it, nor delete it) - that is the job of a user with a Quality assurance role. Every defect can have comments, indicating its lifecycle - who has been working on the defect, what was the status of the defect and when this defect was closed.
	The search function uses a separate method, that utilizes HQL and the LIKE keyword, thus able to extract only part of the object and not pulling everything. It can be used by all roles available and is used to filther the defects by their title.
	
  
