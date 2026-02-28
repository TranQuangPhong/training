CREATE TABLE IF NOT EXISTS employee (
    employee_id INT NOT NULL,
    employee_name VARCHAR (100) NOT NULL,
    employee_address VARCHAR (256) NOT NULL
);

insert into public.employee values(1, 'phong', 'Ha Noi');
