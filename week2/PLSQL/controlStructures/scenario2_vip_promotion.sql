
SET SERVEROUTPUT ON;

DECLARE
    CURSOR c_customers IS
        SELECT customer_id, customer_name, balance, is_vip
        FROM customers;

    v_promoted_count NUMBER := 0;
BEGIN
    FOR rec IN c_customers LOOP
        IF rec.balance > 10000 THEN
            IF rec.is_vip <> 'Y' THEN
                UPDATE customers
                SET is_vip = 'Y'
                WHERE customer_id = rec.customer_id;

                v_promoted_count := v_promoted_count + 1;

                DBMS_OUTPUT.PUT_LINE(
                    'Promoted to VIP: ' || rec.customer_name
                    || ' (ID: ' || rec.customer_id
                    || ', Balance: $' || TO_CHAR(rec.balance, '999,999.99') || ')'
                );
            END IF;
        ELSE
            DBMS_OUTPUT.PUT_LINE(
                'Not eligible for VIP: ' || rec.customer_name
                || ' (Balance: $' || TO_CHAR(rec.balance, '999,999.99') || ')'
            );
        END IF;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Total customers promoted to VIP: ' || v_promoted_count);
END;
/
