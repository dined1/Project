drop schema test;
create schema test;
use test;


CREATE TABLE statisticscollector (SCId INTEGER NOT NULL, StatisticType VARCHAR(255), StatisticsInfo VARCHAR(255), CUSTOMER1_CustomerId INTEGER, PRIMARY KEY (SCId));
CREATE TABLE item (ItemId INTEGER NOT NULL, DefMP FLOAT, DefOTP FLOAT, Description VARCHAR(255), ModifiedDate VARCHAR(255), Name VARCHAR(255), Type VARCHAR(255), PRIMARY KEY (ItemId));
CREATE TABLE role (RoleId INTEGER NOT NULL, Name VARCHAR(255), PRIMARY KEY (RoleId));
CREATE TABLE address (AddressId INTEGER NOT NULL, AddressLine VARCHAR(255), City VARCHAR(255), Country VARCHAR(255), ModifiedDate VARCHAR(255), PostalCode VARCHAR(255), PRIMARY KEY (AddressId));
CREATE TABLE USERROLE (ID BIGINT NOT NULL, ROLE1_RoleId INTEGER, USER1_UserId INTEGER, PRIMARY KEY (ID));
CREATE TABLE discountrule (DRId INTEGER NOT NULL, DiscountProcent FLOAT, DiscountValue FLOAT, PRIMARY KEY (DRId));
CREATE TABLE PRODUCTITEMS (ID BIGINT NOT NULL, ITEM1_ItemId INTEGER, SOPRODUCT1_SOPId INTEGER, PRIMARY KEY (ID));
CREATE TABLE itemdiscount (IDid INTEGER NOT NULL, DISCOUNTRULE1_DRId INTEGER, ITEM1_ItemId INTEGER, PRIMARY KEY (IDid));
CREATE TABLE paymentbill (PBId INTEGER NOT NULL, CMPDisc FLOAT, COTPDisc FLOAT, CMP FLOAT, COTP FLOAT, PRIMARY KEY (PBId));
CREATE TABLE payment (PaymentId INTEGER NOT NULL, PaymentInfo VARCHAR(255), PAYMENTBILL1_PBId INTEGER, PAYMENTTYPE1_PTId INTEGER, SO1_SOId INTEGER, PRIMARY KEY (PaymentId));
CREATE TABLE itemgroup (IGId INTEGER NOT NULL, GROUPS1_GroupId INTEGER, ITEM1_ItemId INTEGER, PRIMARY KEY (IGId));
CREATE TABLE so (SOId INTEGER NOT NULL, DateCreated VARCHAR(255), DateModified VARCHAR(255), OrderDate VARCHAR(255), PurchaseOrderNumber VARCHAR(255), SONumber VARCHAR(255), Status VARCHAR(255), CUSTOMER1_CustomerId INTEGER, USER1_UserId INTEGER, PRIMARY KEY (SOId));
CREATE TABLE soproduct (SOPId INTEGER NOT NULL, MP FLOAT, OTP FLOAT, SO1_SOId INTEGER, PRIMARY KEY (SOPId));
CREATE TABLE user (UserId INTEGER NOT NULL, Login VARCHAR(255), Password VARCHAR(255), PRIMARY KEY (UserId));
CREATE TABLE paymenttype (PTId INTEGER NOT NULL, TypeName VARCHAR(255), PRIMARY KEY (PTId));
CREATE TABLE groups (GroupId INTEGER NOT NULL, Name VARCHAR(255) NOT NULL, PRIMARY KEY (GroupId));
CREATE TABLE customer (CustomerId INTEGER NOT NULL, Contact VARCHAR(255), Email VARCHAR(255), FirstName VARCHAR(255), LastName VARCHAR(255), Phone VARCHAR(255), ADDRESS1_AddressId INTEGER, PRIMARY KEY (CustomerId));
ALTER TABLE USERROLE ADD CONSTRAINT FK_USERROLE_USER1_UserId FOREIGN KEY (USER1_UserId) REFERENCES user (UserId);
ALTER TABLE USERROLE ADD CONSTRAINT FK_USERROLE_ROLE1_RoleId FOREIGN KEY (ROLE1_RoleId) REFERENCES role (RoleId);
ALTER TABLE statisticscollector ADD CONSTRAINT FK_statisticscollector_CUSTOMER1_CustomerId FOREIGN KEY (CUSTOMER1_CustomerId) REFERENCES customer (CustomerId);
ALTER TABLE PRODUCTITEMS ADD CONSTRAINT FK_PRODUCTITEMS_ITEM1_ItemId FOREIGN KEY (ITEM1_ItemId) REFERENCES item (ItemId);
ALTER TABLE PRODUCTITEMS ADD CONSTRAINT FK_PRODUCTITEMS_SOPRODUCT1_SOPId FOREIGN KEY (SOPRODUCT1_SOPId) REFERENCES soproduct (SOPId);
ALTER TABLE itemdiscount ADD CONSTRAINT FK_itemdiscount_ITEM1_ItemId FOREIGN KEY (ITEM1_ItemId) REFERENCES item (ItemId);
ALTER TABLE itemdiscount ADD CONSTRAINT FK_itemdiscount_DISCOUNTRULE1_DRId FOREIGN KEY (DISCOUNTRULE1_DRId) REFERENCES discountrule (DRId);
ALTER TABLE payment ADD CONSTRAINT FK_payment_SO1_SOId FOREIGN KEY (SO1_SOId) REFERENCES so (SOId);
ALTER TABLE payment ADD CONSTRAINT FK_payment_PAYMENTTYPE1_PTId FOREIGN KEY (PAYMENTTYPE1_PTId) REFERENCES paymenttype (PTId);
ALTER TABLE payment ADD CONSTRAINT FK_payment_PAYMENTBILL1_PBId FOREIGN KEY (PAYMENTBILL1_PBId) REFERENCES paymentbill (PBId);
ALTER TABLE itemgroup ADD CONSTRAINT FK_itemgroup_GROUPS1_GroupId FOREIGN KEY (GROUPS1_GroupId) REFERENCES groups (GroupId);
ALTER TABLE itemgroup ADD CONSTRAINT FK_itemgroup_ITEM1_ItemId FOREIGN KEY (ITEM1_ItemId) REFERENCES item (ItemId);
ALTER TABLE so ADD CONSTRAINT FK_so_CUSTOMER1_CustomerId FOREIGN KEY (CUSTOMER1_CustomerId) REFERENCES customer (CustomerId);
ALTER TABLE so ADD CONSTRAINT FK_so_USER1_UserId FOREIGN KEY (USER1_UserId) REFERENCES user (UserId);
ALTER TABLE soproduct ADD CONSTRAINT FK_soproduct_SO1_SOId FOREIGN KEY (SO1_SOId) REFERENCES so (SOId);
ALTER TABLE customer ADD CONSTRAINT FK_customer_ADDRESS1_AddressId FOREIGN KEY (ADDRESS1_AddressId) REFERENCES address (AddressId);


insert into role values ('1', 'Admin');
insert into role values ('2', 'Moderator');
insert into role values ('3', 'User');
insert into user values ('1', 'Adm1', 'Adm1');
insert into user values ('2', 'Moder1', 'Moder1');
insert into user values ('3', 'Max', 'Max');
insert into user values ('4', 'Vlad', 'Vlad');
insert into item values ('1', '10000', '3000', 'Play Minecraft', '08.11.2016', 'Computer', 'Tech');
insert into item values ('2', '1000', '500', 'Play Minecraft PE', '04.11.2016', 'Phone', 'Tech');
insert into item values ('3', '20000', '5000', 'Drive', '05.11.2016', 'Car', 'Vehicle');
insert into item values ('4', '20000', '5000', 'Drive', '05.11.2016', 'Pain 1', 'Pain');
insert into item values ('5', '20000', '5000', 'Drive', '05.11.2016', 'Pain 2', 'Pain');
insert into item values ('6', '20000', '5000', 'Drive', '05.11.2016', 'Suffering 1', 'Suffering');
insert into item values ('7', '20000', '5000', 'Drive', '05.11.2016', 'Suffering 2', 'Suffering');
insert into item values ('8', '20000', '5000', 'Drive', '05.11.2016', 'Olishevko 1', 'Olishevko');
insert into item values ('9', '20000', '5000', 'Drive', '05.11.2016', 'Olishevko 2', 'Olishevko');
insert into item values ('10', '20000', '5000', 'Drive', '05.11.2016', 'Terror 1', 'Terror');
insert into item values ('11', '20000', '5000', 'Drive', '05.11.2016', 'Terror 2', 'Terror');
insert into address values('1', 'Parkovaya 9-15', 'Minsk', 'Belarus', '06.11.2016', '234099');
insert into address values('2', 'Lesnaya 23-68', 'Moskow', 'Russia', '06.11.2016', '346734');
insert into discountrule values ('1', '50', '1000');
insert into discountrule values ('2', '60', '2000');
insert into paymentbill values ('1', '50', '1000', '3000',  '2000');
insert into paymentbill values ('2', '60', '1000', '1000',  '2000');
insert into groups values ('1', '353502');
insert into groups values ('2', '353505');
insert into paymenttype values ('1', 'Card');
insert into paymenttype values ('2', 'Cash');

insert into USERROLE values ('1', '1', '1');
insert into USERROLE values ('2', '2', '2');
insert into USERROLE values ('3', '3', '3');
insert into itemdiscount values ('1', '1', '1');
insert into itemdiscount values ('2', '2', '2');
insert into itemgroup values ('1', '1', '1');
insert into itemgroup values ('2', '2', '2');
insert into customer values ('1', '1111', 'Max@com', 'Maxim', 'Karpik', '9701065', '1');
insert into customer values ('2', '2222', 'Vlad@com', 'Vladislav', 'Lukashevich', '1234567', '2');
insert into so values ('1', '05.11.2016', '07.11.2016', '08.11.2016', '111111', '1', 'Ordered', '1', '3');
insert into so values ('2', '05.11.2016', '07.11.2016', '08.11.2016', '222222', '2', 'Ordered', '2', '3');
insert into soproduct values ('1', '1000', '2000', '1');
insert into soproduct values ('2', '1000', '2000', '2');
insert into payment values ('1', 'Info1', '1', '1', '1');
insert into payment values ('2', 'Info2', '2', '2', '2');
insert into statisticscollector values ('1', 'Type1', 'Info1', '1');
insert into statisticscollector values ('2', 'Type2', 'Info2', '2');
insert into PRODUCTITEMS values ('1', '1', '1');
insert into PRODUCTITEMS values ('2', '2', '2');


select * from USERROLE
































