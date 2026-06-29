
SET SERVEROUTPUT ON;

DECLARE
    CURSOR c_due_loans IS
        SELECT c.customer_id,
               c.customer_name,
               l.loan_id,
               l.due_date,
               l.loan_amount
        FROM loans l
        JOIN customers c ON c.customer_id = l.customer_id
        WHERE l.due_date BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE) + 30
        ORDER BY l.due_date;

    v_reminder_count NUMBER := 0;
BEGIN
    FOR rec IN c_due_loans LOOP
        v_reminder_count := v_reminder_count + 1;

        DBMS_OUTPUT.PUT_LINE(
            'REMINDER: Dear ' || rec.customer_name
            || ', your loan (ID: ' || rec.loan_id
            || ', Amount: $' || TO_CHAR(rec.loan_amount, '999,999.99')
            || ') is due on ' || TO_CHAR(rec.due_date, 'DD-MON-YYYY') || '.'
        );
    END LOOP;

    IF v_reminder_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No loans due within the next 30 days.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Total reminders sent: ' || v_reminder_count);
    END IF;
END;
/
