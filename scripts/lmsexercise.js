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
    let dateInput = document.getElementById('_submissionDate')
    const submissionDateArray = [];
    for (const test of testData){
        if (dateInput === testData[test].submissionDate){
            submissionDateArray.push(testData[test].studentName);
        }else{
          alert("Try Again");
        }

      }
    document.getElementById('resultFilterByDate').innerHTML = submissionDateArray;
  };

//filter By StudentID Feature
const filterByStudentId = (studentID) =>{
    
}
