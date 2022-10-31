USE store;
#Clean the database up
DROP TABLE IF EXISTS Purchase;
DROP TABLE IF EXISTS PaymentMethod;
DROP TABLE IF EXISTS EventItem;
DROP TABLE IF EXISTS Booking;
DROP TABLE IF EXISTS Venue;
DROP TABLE IF EXISTS CustomerAccount;
DROP TABLE IF EXISTS EmployeeAccount;
DROP TABLE IF EXISTS MenuItem;
DROP TABLE IF EXISTS FlowerArrangement;
DROP TABLE IF EXISTS DecorItem;
DROP TABLE IF EXISTS MusicEntertainmentOption;
DROP TABLE IF EXISTS Item;
DROP TABLE IF EXISTS Supplier;

#Create the tables
CREATE TABLE CustomerAccount ( 
    Username VARCHAR(20), 
    UserPassword VARCHAR(20) NOT NULL, 
    FirstName VARCHAR(20) NOT NULL, 
    LastName VARCHAR(20) NOT Null,
    PhoneNumber VARCHAR(20) NOT NULL, 
    EmailAddress VARCHAR(30) NOT NULL,
    PRIMARY KEY(Username)

 );
 
CREATE TABLE EmployeeAccount ( 

	Username VARCHAR(20) PRIMARY KEY, 
	EmployeePassword VARCHAR(20) NOT NULL, 
	FirstName VARCHAR(20) NOT NULL, 
	LastName VARCHAR(20) NOT NULL 

);

CREATE TABLE Supplier ( 

	SupplierId INT PRIMARY KEY AUTO_INCREMENT, 
	SupplierName VARCHAR(20) NOT NULL 

);

	

CREATE TABLE Item ( 

	ItemId INT PRIMARY KEY AUTO_INCREMENT, 
	SupplierId INT NOT NULL,
	ItemType VARCHAR(100) NOT NULL, 
	ItemName VARCHAR(20) NOT NULL, 
	ItemDescription VARCHAR(256) NOT NULL, 
	Price DECIMAL(7, 2) NOT NULL CHECK (Price >= 0),
    FOREIGN KEY(SupplierId) REFERENCES Supplier(SupplierId)
		ON UPDATE CASCADE 
		ON DELETE CASCADE

);

CREATE TABLE MenuItem( 

	ItemId INT,
	FOREIGN KEY(ItemId) REFERENCES Item(ItemId)
		ON UPDATE CASCADE 
		ON DELETE CASCADE 

);

CREATE TABLE FlowerArrangement( 

	ItemId INT,
	FOREIGN KEY(ItemId) REFERENCES Item(ItemId)
		ON UPDATE CASCADE 
		ON DELETE CASCADE 

);

CREATE TABLE DecorItem(

	ItemId INT,
    FOREIGN KEY(ItemId) REFERENCES Item(ItemId)
		ON UPDATE CASCADE
        ON DELETE CASCADE

);

CREATE TABLE MusicEntertainmentOption(

	ItemId INT PRIMARY KEY,
	AvailableStartDateTime DATETIME NOT NULL, #Check validity on frontend side
	AvailableEndDateTime DATETIME NOT NULL, #Check validity on frontend side 
    FOREIGN KEY(ItemId) REFERENCES Item(ItemId)
		ON UPDATE CASCADE 
		ON DELETE CASCADE

);


CREATE TABLE PaymentMethod (

	Username VARCHAR(20) NOT NULL,
	CardNumber CHAR(16) NOT NULL, 
	FirstName VARCHAR(20) NOT NULL, 
	LastName VARCHAR(20) NOT NULL, 
	ExpiryDate DATE NOT NULL, #Will have to check validity on the frontend side
	CVV CHAR(3) NOT NULL, 
	PhoneNumber VARCHAR(20) NOT NULL, 
	AddressLineOne VARCHAR(35) NOT NULL, 
	AddressLineTwo VARCHAR(35), 
	PostalCode CHAR(6) NOT NULL, 
	Province VARCHAR(20) NOT NULL, 
	Country VARCHAR(20) NOT NULL, 
	PRIMARY KEY (Username, CardNumber), 
    FOREIGN KEY (Username) REFERENCES CustomerAccount(Username) 

);

CREATE TABLE Venue (

	VenueId INT AUTO_INCREMENT PRIMARY KEY,
	VenueName VARCHAR(30) NOT NULL,
	Address VARCHAR(40) NOT NULL,
	BuildingType VARCHAR(30) NOT NULL,
	Capacity INT NOT NULL CHECK (Capacity >= 0),
	OperationStartTime TIME NOT NULL, #Check for validity on frontend side 
	OperationEndTime TIME NOT NULL

);

CREATE TABLE Booking (

	BookingId INT AUTO_INCREMENT, 
	BookingType VARCHAR(20) NOT NULL, 
	Username VARCHAR(20) NOT NULL,
	StartDateTime DateTime NOT NULL, #Will have to check validity on the frontend side 
	EndDateTime DateTime NOT NULL, #Will have to check validity on the frontend side
	VenueId INT NOT NULL,
	AttendeesNumber INT NOT NULL CHECK (AttendeesNumber >= 0),
    PRIMARY KEY(BookingId),
    FOREIGN KEY(VenueId) REFERENCES Venue(VenueId) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(Username) REFERENCES CustomerAccount(Username) ON UPDATE CASCADE
    
);

CREATE TABLE Purchase (

	PurchaseId INT AUTO_INCREMENT, 
	PurchaseDate DATE NOT NULL, 
	Username VARCHAR(20) NOT NULL, 
	CardNumber CHAR(16) NOT NULL, 
	BookingId INT NOT NULL,
	Amount DECIMAL(8,2) CHECK (amount >= 0),
    PRIMARY KEY(purchaseId),
	FOREIGN KEY(Username, CardNumber) REFERENCES PaymentMethod(Username, CardNumber)
		ON UPDATE CASCADE
        ON DELETE NO ACTION,
	FOREIGN KEY(BookingId) REFERENCES Booking(BookingId)
		ON UPDATE CASCADE
        ON DELETE CASCADE
        
);

CREATE TABLE EventItem (
	BookingId INT NOT NULL,
    ItemId INT,
    FOREIGN KEY(ItemId) REFERENCES Item(ItemId)
		ON UPDATE CASCADE
        ON DELETE CASCADE,
	FOREIGN KEY(BookingId) REFERENCES Booking(BookingId)
		ON UPDATE CASCADE
        ON DELETE CASCADE,
	PRIMARY KEY (BookingId, ItemId)
);