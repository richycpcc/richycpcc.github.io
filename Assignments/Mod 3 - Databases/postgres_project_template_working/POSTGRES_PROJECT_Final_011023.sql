Select * from inventory;

SELECT stores.name, stores.id
FROM stores
Where stores.name ILIKE '%a%'

DELETE FROM inventory WHERE item_id = 56;
	
SELECT items.id
FROM items
WHERE items.name ='Frosted Flakes'

INSERT INTO inventory(store_id, item_id, quantity)
SELECT stores.id, items.id, 50
FROM stores, items
WHERE stores.name ILIKE '%a%' AND items.name ='Frosted Flakes'
