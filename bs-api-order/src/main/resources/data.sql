DROP TABLE IF EXISTS order_detail;
DROP TABLE IF EXISTS menu_item;
DROP TABLE IF EXISTS requested_order;

CREATE TABLE IF NOT EXISTS requested_order (
    id bigint auto_increment,
    number varchar(15) NOT NULL,
    status_code varchar(15) NOT NULL,
    order_date date NOT NULL,

    PRIMARY KEY (id),
    CHECK (status_code in ('progress', 'cancelled', 'finished'))
);

CREATE TABLE IF NOT EXISTS menu_item (
    id bigint auto_increment,
    number tinyint NOT NULL,
    name varchar(255) NOT NULL,
    category_code varchar(15) NOT NULL,
    description varchar(255) NOT NULL,
    price decimal NOT NULL,
    is_active boolean NOT NULL,

    CHECK (category_code in ('drink', 'plate')),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS order_detail (
    order_id bigint NOT NULL,
    menu_item_id bigint NOT NULL,
    quantity tinyint NOT NULL,

    FOREIGN KEY (order_id) REFERENCES requested_order(id),
    FOREIGN KEY (menu_item_id) REFERENCES menu_item(id),
    PRIMARY KEY (order_id, menu_item_id)
);

INSERT INTO requested_order (id, number, status_code, order_date) VALUES
(1, 'ORD001', 'progress', '2021-11-20'),
(2, 'ORD002', 'finished', '2021-11-20');

INSERT INTO menu_item(id, number, name, category_code, description, price, is_active) VALUES
(1, 1, 'Ají de gallina', 'plate', 'Ají de gallina', 14.99, true),
(2, 2, 'Arroz tapado', 'plate', 'Arroz tapado', 13.99, true),
(3, 3, 'Pachamanca', 'plate', 'Pachamanca', 35.00, true),
(4, 4, 'Chicha morada', 'drink', 'Chicha morada', 12.00, true),
(5, 5, 'Maracuyá', 'drink', 'Maracuyá', 10.00, true);

INSERT INTO order_detail(order_id, menu_item_id, quantity) VALUES
(1, 1, 1),
(1, 2, 2),
(1, 5, 1),
(2, 3, 3),
(2, 4, 2),
(2, 5, 7);

