# Blog CMS Project

## Description

This is an online Blog Content Management System (CMS) built using JSP, MySQL, and Java. The system allows users to create, edit, and manage blog posts with an easy-to-use interface.

## Features

- User authentication (Login/Signup)
- Create, edit, and delete blog posts
- Commenting system
- Admin panel for managing users and posts
- Responsive design

## Technologies Used

- Java (JSP & Servlets)
- MySQL
- HTML, CSS, Javascript
- Eclipse IDE
- Apache Tomcat Server

## Installation & Setup

### Prerequisites

- Install [Eclipse IDE](https://www.eclipse.org/downloads/)
- Install [Apache Tomcat](https://tomcat.apache.org/download-90.cgi)
- Install MySQL and MySQL Workbench
- Clone the repository from GitHub:
  ```sh
  git clone https://github.com/VENOMGHOST16/Online-Blog-CMS
  ```

### Database Setup

1. Create a MySQL database named `blogging`.
2. Import the `blog_cms.sql` file from the repository into MySQL.
3. Update the `dbconfig.properties` file with your database credentials:
   ```properties
   db.url=jdbc:mysql://localhost:3306/blogging
   db.username=root
   db.password=yourpassword
   ```

### Running the Project

1. Open Eclipse and import the project.
2. Configure Apache Tomcat in Eclipse.
3. Deploy the project and start the Tomcat server.
4. Access the application at: `http://localhost:8080/your-project-name/`

## License

This project is open-source. Feel free to modify and use it.

## Contributing

Pull requests are welcome. For major changes, please open an issue first.

## Contact

For any issues or suggestions, contact me at [(sarvottamko2@gmail.com)].

