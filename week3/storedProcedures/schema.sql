
CREATE TABLE savings_accounts (
    account_id   NUMBER PRIMARY KEY,
    customer_id  NUMBER NOT NULL,
    balance      NUMBER(12, 2) DEFAULT 0 CHECK (balance >= 0)
);

CREATE TABLE employees (
    employee_id  NUMBER PRIMARY KEY,
    employee_name VARCHAR2(100) NOT NULL,
    department   VARCHAR2(50) NOT NULL,
    salary       NUMBER(12, 2) NOT NULL CHECK (salary > 0)
);

CREATE TABLE accounts (
    account_id   NUMBER PRIMARY KEY,
    customer_id  NUMBER NOT NULL,
    balance      NUMBER(12, 2) DEFAULT 0 CHECK (balance >= 0)
);
