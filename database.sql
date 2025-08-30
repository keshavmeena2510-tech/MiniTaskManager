CREATE TABLE tasks (
    task_id NUMBER PRIMARY KEY,
    task_name VARCHAR2(100) NOT NULL,
    client_name VARCHAR2(50),
    status VARCHAR2(20),
    deadline DATE
);