SELECT stores.name AS "Store name", payment_types.payment_method AS "Payment method", Count(purchases.id) AS "Count of purchases by payment method"
FROM purchases
INNER JOIN stores
ON purchases.store_id = stores.id
INNER JOIN payment_types
ON purchases.payment_type_id = payment_types.id
WHERE stores.name = 'Benchmark Electronics, Inc.'
GROUP BY payment_types.payment_method,stores.name
ORDER BY payment_types.payment_method;

SELECT stores.name AS "Store Name", items.name AS "Item Name",inventory.quantity AS "Quantity of Item in that store"
FROM inventory
INNER JOIN stores
ON inventory.store_id = stores.id
INNER JOIN items
ON inventory.item_id = items.id
WHERE inventory.quantity <10
ORDER BY stores.name;

SELECT CONCAT(customers.first_name, ' ', customers.last_name) AS "Members first and last name", purchases.purchase_date AS "Purchase date", items.name AS "Name of item purchased", payment_types.payment_method AS "Payment type used", purchase_items.quantity AS "Quantity purchased"
FROM purchases
INNER JOIN customers
ON purchases.customer_id = customers.id
INNER JOIN payment_types
ON purchases.payment_type_id = payment_types.id
INNER JOIN purchase_items
ON purchases.id = purchase_items.purchase_id
INNER JOIN items
ON purchase_items.item_id = items.id
WHERE customers.first_name = 'Alfred' AND customers.last_name = 'Poggi'
ORDER BY purchases.purchase_date DESC;
/*
UPDATE purchases
SET payment_type_id = 3 --'credit'
WHERE payment_type_id = 5 --'apple pay';

DELETE FROM payment_types WHERE payment_types.id = 5 OR payment_types.payment_method = 'apple pay';

INSERT INTO items(name, price, notes)
VALUES ('Frosted Flakes', 5, 'They''re Grate!');
*/
SELECT stores.name
FROM stores
WHERE stores.name LIKE '%a%'

INSERT INTO inventory (item_id, quantity)
VALUES ('56', '50')
WHERE 
		(SELECT stores.names
		FROM store
		Where store.name LIKE '%a')
		
UPDATE inventory
SET quantity = quantity + 50
FROM stores
WHERE inventory.store_id = stores.id
AND item_id = 56
AND stores.name LIKE '%a%'
--INNER JOIN Stores ON inventory.store_id = stores.id	
/*	
UPDATE items
Set Notes = 'Incorrect (Current) Notes - They''re Grate!
			Correct Notes (please update to this)- They''re Gr-r-reat'
Where items.name = 'Frosted Flakes'
*/	

SELECT s.name AS "Store Name", a.street AS "Street Address", a.street2 AS "Suite", a.city AS "City", a.state AS "State", a.zip AS "Zip Code"
   FROM stores s
   INNER JOIN address a
   ON address_id = a.id
   
 SELECT stores.name, inventory.quantity, items.name
 FROM inventory
 INNER JOIN stores
 ON inventory.store_id = stores.id
 INNER JOIN items
 ON inventory.item_id = items.id
 
