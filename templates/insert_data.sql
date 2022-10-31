INSERT INTO CustomerAccount VALUES
("ThomasSmith", "1234", "Thomas", "Smith", "1987654321", "tsmith@hotmail.com"),
("WilliamScott", "1234", "William", "Scott", "1987654321", "wScott@hotmail.com"),
("Lea Wilson", "1234", "Lea", "Wilson", "1987654321", "lWilson@hotmail.com");

INSERT INTO Venue VALUES
(1, "Brown's Concerts and Events", "35 University Avenue East, Waterloo", "Arena", 1000, '06:00:00', '23:00:00'),
(2, "Hacienda Sarria", "1254 Union St, Kitchener", "Church", 200, '09:00:00', '18:00:00'),
(3, "Moore Event Centre", "151 Charles St W, Kitchener", "Conference Centre", 1000, '09:00:00', '21:00:00'),
(4, "Starlight Social Club", "47 King St N, Waterloo", "NightClub", 500, '22:00:00', '02:00:00'),
(5, "Columbus Conference Centre", "145 Dearborn Pl, Waterloo", "Conference Centre", 2000, '09:00:00', '17:00:00');

INSERT INTO Booking VALUES
(1, "Wedding", "ThomasSmith", '2019-07-01 09:00:00', '2019-07-01 17:00:00', 2, 100),
(2, "Party", "ThomasSmith", '2019-06-25 22:00:00', '2019-06-26 02:00:00', 4, 20)
;

INSERT INTO PaymentMethod VALUES
("ThomasSmith", "5006123478907654", "Thomas", "Smith", '2021-01-09', "111", "1987654321", 
	"200 University Avenue West", "Waterloo", "N2L3G1", "ON", "Canada");

INSERT INTO Purchase VALUES
(1, '2019-06-05', "ThomasSmith", "5006123478907654", 2, 2000.00),
(2, '2019-06-07', "ThomasSmith", "5006123478907654", 1, 12222.00);

INSERT INTO Supplier VALUES
(1, "Party City"),
(2, "Micheals"),
(3, "The Cake Box"),
(4, "OldMill"),
(5, "Supersonic Hearts");
    
INSERT INTO Item VALUES
(1, 1, "DecorItem", "Helium Balloon", "Various Helium Balloons including animal, number, etc", 5.00),
(2, 4, "FlowerArrangement", "Wedding Flower", "Beautiful flower designed by Old Mill Flower Shop", 20.00),
(3, 3, "MenuItem", "Wedding Cake", "Custmized Wedding Cake from The Cake Box", 200.00),
(4, 5, "MusicEntertainmentOption", "Live Band", "High energy live music for parties", 800.00);

INSERT INTO DecorItem VALUES
(1);

INSERT INTO FlowerArrangement VALUES
(2);

INSERT INTO MenuItem VALUES
(3);

INSERT INTO MusicEntertainmentOption VALUES
(4, '2019-04-01 09:00:00', '2021-01-01 21:00:00');

INSERT INTO EventItem VALUES
(1, 2),
(1, 3),
(2, 1), 
(2, 4);


