
INSERT INTO jb178339.EMPLOYEE (Ssn, Name, Age, Wage)
VALUES
    ('123456789', 'Jason', '18', '1'),
    ('234567890', 'Trini', '18', '1' ),
    ('345678901', 'Billy', '18', '1'),
    ('456789012', 'Kimberly', '18', '1'),
    ('567890123', 'Adam', '18', '1'),
    ('678901234', 'Tommy', '19', '1'),
    ('789012345', 'Zack', '18', '1'),
    ('890123456', 'Aisha', '18', '1'),
    ('901234567', 'Lord Zedd', '0', '0'),
    ('012345678', 'Zordon', '0', '10');

GO




INSERT INTO jb178339.PIZZA (ID_number, PizzaName, Price, Sauce)
VALUES
    ('1738', 'Cheese', '12', 'red'),
	('1739', 'pepperoni', '14', 'red'),
	('1740', 'meat', '16', 'red'),
	('1741', 'combination', '16', 'red'),
	('1742', 'veggie', '14', 'oil');
go




INSERT INTO jb178339.PASTA_RICE (ID_number, pasta_riceName, Price, grain)
VALUES
    ('1801', 'chicken alfredo', '18', 'pasta'),
	('1802', 'ziti', '18', 'pasta'),
	('1803', 'carbinara', '18', 'pasta'),
	('1804', 'cajun', '16', 'rice'),
	('1805', 'tso', '16', 'rice');
go


INSERT INTO jb178339.TABLEORDER (order_number, menu_item, Price, item_quantity, cost)
VALUES
('72', '1738', '14', '2', '28'),
('73', '1739', '16', '2', '32')

go
