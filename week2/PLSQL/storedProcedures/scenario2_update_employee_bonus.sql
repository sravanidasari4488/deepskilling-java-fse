
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department    IN VARCHAR2,
    p_bonus_percent IN NUMBER
) IS
    v_updated_count NUMBER := 0;
BEGIN
    IF p_bonus_percent < 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Bonus percentage cannot be negative.');
    END IF;

    UPDATE employees
    SET salary = salary + (salary * (p_bonus_percent / 100))
    WHERE UPPER(department) = UPPER(p_department);

    v_updated_count := SQL%ROWCOUNT;

    IF v_updated_count = 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'No employees found in department: ' || p_department);
    END IF;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Bonus of ' || p_bonus_percent || '% applied to '
        || v_updated_count || ' employee(s) in ' || p_department || '.'
    );
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END UpdateEmployeeBonus;
/
