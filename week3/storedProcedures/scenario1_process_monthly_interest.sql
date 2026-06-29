
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    v_interest_rate CONSTANT NUMBER := 0.01;
    v_updated_count NUMBER := 0;
BEGIN
    UPDATE savings_accounts
    SET balance = balance + (balance * v_interest_rate);

    v_updated_count := SQL%ROWCOUNT;
    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Monthly interest applied to ' || v_updated_count || ' savings account(s).'
    );
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20001, 'Error processing monthly interest: ' || SQLERRM);
END ProcessMonthlyInterest;
/
