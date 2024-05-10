CREATE TABLE jb178339.PIZZA
(
    ID_number VARCHAR(100) CONSTRAINT PK_ID_NUMBER PRIMARY KEY,
    PizzaName VARCHAR(100) NOT NULL,
    Price INTEGER NOT NULL CONSTRAINT CK_PIZZA_PRICE CHECK (Price > 0),
    Sauce VARCHAR(100),
    );