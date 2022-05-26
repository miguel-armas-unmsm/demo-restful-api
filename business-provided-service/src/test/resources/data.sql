create schema db_services_pay;

-- servicios
INSERT INTO accounts(account_number, currency, account_balance) VALUES ('1234567891012', 'PEN', 10000);
INSERT INTO accounts(account_number, currency, account_balance) VALUES ('1234567891013', 'PEN', 20000);

INSERT INTO provided_services(short_name, display_name, service_provider_id, is_active, consumer_identification, account_id) VALUES
('Luz', 'Recibo de luz', 1, true, 'CÓDIGO DE SUMINISTRO', 1);

INSERT INTO provided_services(short_name, display_name, service_provider_id, is_active, consumer_identification, account_id) VALUES
('Celular', 'Recibo de celular', 2, true, 'NÚMERO DE CELULAR', 2);