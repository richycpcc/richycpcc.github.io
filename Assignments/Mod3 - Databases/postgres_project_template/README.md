# Postgres Project

## Setup Instructions
1. Download **project_dump.backup** file
2. After creating a new database in pgAdmin, right click on newly created database, then click `Restore`
3. Leave `Format` as "Custom or tar"
4. In the `Filename` selector, find and select **project_dump.backup**
5. Leave `Number of jobs` empty
6. For `Role Name`, click the drop-down and select **postgres**
7. Click `Restore` at the bottom to restore


## Relational Databases

### Foreign Key Relationships

| Table Name  | Foreign Key (FK) Name  | Table Matching FK |
| --- | --- | --- |
| customers | store_id | stores |

### Multiple Choice

1. Users are not allowed to add items to purchases where the amount of items bought exceeds the amount of items in the store. This is because:
    1. There is a Trigger Function preventing new purchases that exceed the current inventory.
    2. This will cause a Foreign Key Constraint Violation on the Inventory table.
    3. There is a custom rule on the items table that prevents it from ever having a negative value for the field 'quantity'.
    4. Users are actually allowed to add those purchases.
2. Why will the following SQL statement not work in the stores database?
   >SELECT s.name AS "Store Name", a.street AS "Street Address", a.street2 AS "Suite", a.city AS "City", a.state AS "State", a.zip AS "Zip Code"
   >FROM stores s
   >INNER JOIN address a
   >ON address_id = a.id
    1. It is missing a semi-colon.
    2. Double-quotes do not work with column names with pgAdmin and postgres. 
    3. address_id is an ambiguous field because it is not qualified with a table or alias name (should be s.address_id or stores.address_id).
    4. This is a valid query that will run without error.
3. What is the relationship between the stores and customers tables?
    1. Stores is a one-to-one relationship with Customers.
    2. Stores is a one-to-many relationship with Customers.
    3. Stores is a many-to-many relationship with Customers.
    4. Stores and Customers are unrelated tables.
4. What is the relationship between the purchases and items tables?
    1. The tables have a many-to-many relationship with the purchase_items table acting as a mapping table.
    2. Purchases has a one-to-many relationship with items, as a single purchase can have multiple items in it.
    3. Items has a one-to-many relationship with purchases, as a single item can have multiple purchases.
    4. Purchases and Items are unrelated tables.