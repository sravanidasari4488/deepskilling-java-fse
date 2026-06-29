
SET SERVEROUTPUT ON;

DECLARE
    CURSOR c_senior_customers IS
        SELECT customer_id, customer_name, age
        FROM customers
        WHERE age > 60;

    v_updated_count NUMBER := 0;
BEGIN
    FOR rec IN c_senior_customers LOOP
        UPDATE loans
        SET interest_rate = interest_rate - 0.01
        WHERE customer_id = rec.customer_id
          AND interest_rate > 0.01;

        v_updated_count := v_updated_count + SQL%ROWCOUNT;

        DBMS_OUTPUT.PUT_LINE(
            'Applied 1% interest discount for customer '
            || rec.customer_name || ' (ID: ' || rec.customer_id
            || ', Age: ' || rec.age || ')'
        );
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Total loan records updated: ' || v_updated_count);
END;
/
