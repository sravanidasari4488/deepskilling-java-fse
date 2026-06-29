
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) IS
    v_from_balance accounts.balance%TYPE;
BEGIN
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20004, 'Transfer amount must be greater than zero.');
    END IF;

    IF p_from_account = p_to_account THEN
        RAISE_APPLICATION_ERROR(-20005, 'Source and destination accounts must be different.');
    END IF;

    SELECT balance
    INTO v_from_balance
    FROM accounts
    WHERE account_id = p_from_account
    FOR UPDATE;

    IF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20006, 'Insufficient balance in source account.');
    END IF;

    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account;

    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Transferred $' || TO_CHAR(p_amount, '999,999.99')
        || ' from account ' || p_from_account
        || ' to account ' || p_to_account || '.'
    );
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20007, 'One or both account IDs do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END TransferFunds;
/
