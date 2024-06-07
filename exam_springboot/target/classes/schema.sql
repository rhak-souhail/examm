CREATE TABLE IF NOT EXISTS employee (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    skills VARCHAR(255),
    role VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS project (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
    client VARCHAR(255),
    percentage VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS project_employee (
                                                project_id BIGINT NOT NULL,
                                                employee_id BIGINT NOT NULL,
                                                PRIMARY KEY (project_id, employee_id),
    FOREIGN KEY (project_id) REFERENCES project(id),
    FOREIGN KEY (employee_id) REFERENCES employee(id)
    );
