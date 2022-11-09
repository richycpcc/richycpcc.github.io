
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

const getStudentNames = (_testData) =>{
  const studentNames = [];
  for (data of testData)
  {
    if(!studentNames.includes(data.studentName))
    {
      studentNames.push(data.studentName);
    }
  }
  return studentNames // adds Student Name in Array
}

const studentRegister = getStudentNames(testData);

//Filter By Date Feature
const filterByDate = (event) => {
  const inputDate = event.target.parentNode.querySelector('#_subDate').value;

  let submissionDates = [];

  for (const test of testData) {
    if (inputDate === test.submissionDate) {
      submissionDates.push(test);
    } // end if
  } // end for

  let output = null;
  if (submissionDates.length != 0) {
    for (const thisSubmission of submissionDates) {
      document.querySelector('#resultFilterByDate').append(thisSubmission.quizName);
      document.querySelector('#resultFilterByDate').append(thisSubmission.quizModule);
      document.querySelector('#resultFilterByDate').append(thisSubmission.quizScore);
      document.querySelector('#resultFilterByDate').append(thisSubmission.studentId);
      document.querySelector('#resultFilterByDate').append(thisSubmission.studentName);
      document.querySelector('#resultFilterByDate').append(thisSubmission.submissionDate);
      document.querySelector('#resultFilterByDate').append(document.createElement('br'));
    }//end for
  }
  else {
    document.querySelector('#resultFilterByDate').append("Empty Array");
  } //end if
} // end function
document.querySelector('#dateButton').addEventListener('click', filterByDate);

//filter By StudentID Feature
const filterByStudentId = (event) =>{
  const inputId = event.target.parentNode.querySelector('#studentId').value;
  let submissionObjects = [];

  for (const test of testData) {
    if (parseInt(inputId) === test.studentId) {

      submissionObjects.push(test);
    } // end if
  } // end for

  let output = null;
  if (submissionObjects.length != 0) {
    for (const thisSubmission of submissionObjects) {
      document.querySelector('#resultFilterStudentID').append(thisSubmission.quizName);
      document.querySelector('#resultFilterStudentID').append(document.createElement('br'));
      document.querySelector('#resultFilterStudentID').append(thisSubmission.quizModule);
      document.querySelector('#resultFilterStudentID').append(document.createElement('br'));
      document.querySelector('#resultFilterStudentID').append(thisSubmission.quizScore);
      document.querySelector('#resultFilterStudentID').append(document.createElement('br'));
      document.querySelector('#resultFilterStudentID').append(thisSubmission.studentId);
      document.querySelector('#resultFilterStudentID').append(document.createElement('br'));
      document.querySelector('#resultFilterStudentID').append(thisSubmission.studentName);
      document.querySelector('#resultFilterStudentID').append(document.createElement('br'));
      document.querySelector('#resultFilterStudentID').append(thisSubmission.submissionDate);
      document.querySelector('#resultFilterStudentID').append(document.createElement('br'));
    }//end for
  }
  else {
    document.querySelector('#resultFilterStudentID').append("Empty Array");
  } //end if
} // end function
document.querySelector('#idButton').addEventListener('click', filterByStudentId);

/*
        Given I have an array of submission objects, when I supply a date, an array of student names, and an array of 
        submission objects(in that order) to the findUnsubmitted function, then I am returned an array of names of students
         that have not completed any quiz on that date
*/

//Find Unsubmitted Feature

const findNotSubmitted = (event) =>{
  const inputSubmittedDate = event.target.parentNode.querySelector('#_submissionDate').value;
  let matchedSubmittedStudents = [];
  let notSubmittedStudents = [];
  

  for(const test of testData){
    if (inputSubmittedDate === test.submissionDate){
      matchedSubmittedStudents.push(test.studentName); //array contains name of students who have submitted assignments matching input date.
    } //end if
  } //end for
 
  for (const student of matchedSubmittedStudents){
    if (student != studentRegister){
      notSubmittedStudents = studentRegister.splice(student,1);
    }// end if
  }//end for

  document.querySelector('#resultNotSubmitted').append(notSubmittedStudents);
  } //end function
  document.querySelector('#submissionDateButton').addEventListener('click', findNotSubmitted);

//Get Quiz Average Feature
const getAverageScore = (event) =>{
  let quizTotal = 0;
  let quizAverage = 0;
  console.log("test");

  for (const test of testData){
    quizTotal = quizTotal + test.quizScore;
    quizAverage = quizTotal/testData.length;
  } //end for
  
  document.querySelector('#resultAverageScore').append("The average score of the quizzes is " + quizAverage.toFixed(1));
}
  document.querySelector('#averageQuizButton').addEventListener('click', getAverageScore);
