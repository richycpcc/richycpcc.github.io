/*const customer ={
    customer_id
    last_name
    first_name
    last_purchase_quantity
    last_purchase_amount_in_dollars
}
*/
const customer= 
[customer1 = {
    customer_id: '001',
    last_name: 'Smith',
    first_name: 'Jacob',
    last_purchase_quantity:'5',
    last_purchase_amount_in_dollars: '$50.00'
},
customer2 = {
    customer_id: '002',
    last_name: 'Johnson',
    first_name: 'Iris',
    last_purchase_quantity:'10',
    last_purchase_amount_in_dollars: '$100.00'
},
customer3 = {
    customer_id: '003',
    last_name: 'Perez',
    first_name: 'Javier',
    last_purchase_quantity:'5',
    last_purchase_amount_in_dollars: '$50.00'
},
customer4 = {
    customer_id: '004',
    last_name: 'Thomas',
    first_name: 'Henry',
    last_purchase_quantity:'20',
    last_purchase_amount_in_dollars: '$200.00'
},
customer5 = {
    customer_id: '005',
    last_name: 'Smith',
    first_name: 'Janice',
    last_purchase_quantity:'10',
    last_purchase_amount_in_dollars: '$100.00'
},
];
/*Write a function that allows your manager to gather more information about any
customer from your object. Your manager should be able to pass the customer’s id to the
function in the web page’s console log.
a. Hint: Your manager must be able to utilize the web page’s console log to return a
sentence that they will read word for word to describe the requested customer to
the investor. (For example, if the investor requests more information on customer
003, your leader should be able to request more information about customer 003
in the console log.)
*/
const answer = prompt("What is the customer ID?");
const findCustomerDetail (customer.customer_id) => {
    for (let counter = 0; counter < customer.length; counter++ ) {
     if (answer = customer[counter].customer_id){
        let thisCustomer = customer[Counter];
        console.log( `Customer ID: ${thisCustomer.customer_id} - ${thisCustomer.firstName} ${thisCustomer.lastName} Last purchase order of ${thisCustomer.last_purchase_quantity} for a total of $${thisCustomer.last_purchase_amount_in_dollars}`.);
     }
    }
    
};


/*
for (const thisCustomer of customer){

}
*/