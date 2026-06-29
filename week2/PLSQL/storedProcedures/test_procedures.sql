
SET SERVEROUTPUT ON;

-- Scenario 1
BEGIN
    ProcessMonthlyInterest;
END;
/

-- Scenario 2
BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/

-- Scenario 3
BEGIN
    TransferFunds(3001, 3002, 500);
END;
/
