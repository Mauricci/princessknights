CREATE TABLE Scen (
ID nvarchar(25) NOT NULL PRIMARY KEY,
EnemyID int NOT NULL FOREIGN KEY REFERENCES [dbo].[Enemy]([ID])
);