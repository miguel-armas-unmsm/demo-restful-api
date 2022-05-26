-- holders
INSERT INTO accounts(account_number, currency, account_balance) VALUES ('1234567891092', 'PEN', 5000);
INSERT INTO accounts(account_number, currency, account_balance) VALUES ('1234567891093', 'PEN', 25000);

INSERT INTO holders(name, account_id) VALUES ('Titular 1', 2);
INSERT INTO holders(name, account_id) VALUES ('Titular 2', 3);
