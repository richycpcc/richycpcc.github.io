const testData = [
    {
      quizName: "History 1",
      quizModule: "History",
      quizScore: 70,
      studentId: 1,
      studentName: "Bob Ross",
      submissionDate: "12/20/2020"
    },
    {
      quizName: "History 1",
      quizModule: "History",
      quizScore: 77,
      studentId: 16,
      studentName: "Diana Ross",
      submissionDate: "12/20/2020"
    },
    {
      quizName: "History 1",
      quizModule: "History",
      quizScore: 82,
      studentId: 15,
      studentName: "Steve Smith",
      submissionDate: "12/20/2020"
    },
    {
      quizName: "History 1",
      quizModule: "History",
      quizScore: 88,
      studentId: 14,
      studentName: "Dylan Roberts",
      submissionDate: "12/20/2020"
    },
    {
      quizName: "History 2",
      quizModule: "History",
      quizScore: 82,
      studentId: 1,
      studentName: "Bob Ross",
      submissionDate: "1/20/2021"
    },
    {
      quizName: "History 2",
      quizModule: "History",
      quizScore: 89,
      studentId: 16,
      studentName: "Diana Ross",
      submissionDate: "1/20/2021"
    },
  
    {
      quizName: "History 2",
      quizModule: "History",
      quizScore: 73,
      studentId: 15,
      studentName: "Steve Smith",
      submissionDate: "1/20/2021"
    },
  
    {
      quizName: "History 2",
      quizModule: "History",
      quizScore: 85,
      studentId: 15,
      studentName: "Steve Smith",
      submissionDate: "1/20/2021"
    },
    {
      quizName: "Reading Comprehension",
      quizModule: "English",
      quizScore: 60,
      studentId: 15,
      studentName: "Steve Smith",
      submissionDate: "2/20/2020"
    },
    {
      quizName: "Reading Comprehension",
      quizModule: "English",
      quizScore: 83,
      studentId: 16,
      studentName: "Diana Ross",
      submissionDate: "2/20/2020"
    },
    {
      quizName: "Reading Comprehension",
      quizModule: "English",
      quizScore: 70,
      studentId: 14,
      studentName: "Dylan Roberts",
      submissionDate: "2/20/2020"
    }
  ];
//Filter By Date Feature
  const filterByDate = () => {
    console.log("Test");
    //const inputDate = event.target.parentNode.querySelector('input').value;
    let inputDate = document.getElementById('_submissionDate').value
    const submissionDates = [];

    for (const test of testData){
      if (inputDate == test.submissionDate){
        submissionDates.push(test.studentName);
        document.getElementById('resultFilterByDate').innerHTML = submissionDates +`Done ${submissionDate}`;
      } //End If Statement

        //console.log("Test");

    } //End For Of Loop
    //console.log("Test");

    document.getElementById('resultFilterByDate').innerHTML = submissionDates +`Done ${submissionDate}`;
    //document.querySelector('p').(submissionDates)
  }
  //document.querySelector('button.addEventListener('click',filterByDate)

//filter By StudentID Feature
const filterByStudentId = () =>{
};
/*
}
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
};
*/
//Find Unsubmitted Feature
const findUnsubmitted = () =>{

};

//Get Quiz Average Feature
const getAverageScore = () =>{

};