/*const customer ={
    customer_id
    last_name
    first_name
    last_purchase_quantity
    last_purchase_amount_in_dollars
}
*/
const customers= 
[
{
    customer_id: '001',
    last_name: 'Smith',
    first_name: 'Jacob',
    last_purchase_quantity:'5',
    last_purchase_amount_in_dollars: '$50.00'
},
{
    customer_id: '002',
    last_name: 'Johnson',
    first_name: 'Iris',
    last_purchase_quantity:'10',
    last_purchase_amount_in_dollars: '$100.00'
},
{
    customer_id: '003',
    last_name: 'Perez',
    first_name: 'Javier',
    last_purchase_quantity:'5',
    last_purchase_amount_in_dollars: '$50.00'
},
{
    customer_id: '004',
    last_name: 'Thomas',
    first_name: 'Henry',
    last_purchase_quantity:'20',
    last_purchase_amount_in_dollars: '$200.00'
},
{
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

const getCustomerDetail = () => {
    const inputId = document.getElementById("_customerId").value
    //const newId = parseInt(inputId);
    for (const customer of customers){
        if (inputId === customer.customer_id){
            document.getElementById('output').innerHTML = `Customer Id: ${customer.customer_id} - ${customer.first_name} ${customer.last_name} Last purchase order of ${customer.last_purchase_quantity} for a total of ${customer.last_purchase_amount_in_dollars}.`;
            return;
        }else{
            document.getElementById('output').innerHTML = `Customer Id: ${inputId} does not exist. Please enter a valid Customer ID ${customer.customer_id}`;
        }
    }
}

/*
const getCustomerDetail = () => {
    const inputId = document.getElementById("_customerId").value
    for (let counter = 0; counter < customer.length; counter++ ){
        if (inputId === customer.){
        document.getElementById('output').innerHTML = `Customer Id: ${customer.customer_id} - ${customer.first_name} ${customer.last_name} Last purchase order of ${customer.last_purchase_quantity} for a total of ${customer.last_purchase_amount_in_dollars}.`;
        }else{
        document.getElementById('output').innerHTML = `Customer Id: ${inputId} does not exist. Please enter a valid Customer ID ${customer.customer_id}`;
        }
    }
};
*/