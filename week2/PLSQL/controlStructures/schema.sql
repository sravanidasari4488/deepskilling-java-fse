
CREATE TABLE customers (
    customer_id   NUMBER PRIMARY KEY,
    customer_name VARCHAR2(100) NOT NULL,
    age           NUMBER NOT NULL,
    balance       NUMBER(12, 2) DEFAULT 0,
    is_vip        CHAR(1) DEFAULT 'N' CHECK (is_vip IN ('Y', 'N'))
);

CREATE TABLE loans (
    loan_id       NUMBER PRIMARY KEY,
    customer_id   NUMBER NOT NULL REFERENCES customers(customer_id),
    interest_rate NUMBER(5, 2) NOT NULL,
    due_date      DATE NOT NULL,
    loan_amount   NUMBER(12, 2) NOT NULL
);
