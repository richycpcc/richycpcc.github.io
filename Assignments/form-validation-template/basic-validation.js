/*
///////Error message
1.Given there are errors somewhere on a form, when the"Validate" input button for that form is clicked, 
then all error messages from this form will appear in the div with class "errors" immediately preceding the form.

2.Given the "Validate" input button for a form has been clicked, when errors exist,
then they are displayed in an unordered list, with red text.

/////////Submissions
3.Given there are errors somewhere on a form, when the"Validate" input button for that form is clicked, 
then the form is not submitted.

4. Given there are no errors on the form, when the "Validate"input button for that form is clicked, 
then the form is submitted.

5.Given there are multiple forms on a page, when the"Validate" input button for any form is clicked, 
then only that form will run through validation.

6.Given an input of type "text" has a class of "required",and given nothing or only whitespace characters (spaces, tabs) 
has been entered into this input, when this form's validation runs, then an error appears in the correct location, and 
the error text says "Required fields must have a value that is not empty or whitespace."

7.Given an input of type "text" does not have a class of "required", and given nothing has been entered into this input, 
when this form's validation runs, then no error will appear from this input.

8.Given an input of type "text" has a class of "numeric",and given a non-numeric character has been entered into this input, 
when this form's validation runs, then an error appears in the correct location, and the error text says "Numeric fields must 
be a series of numbers."
 
9.Given an input of type "text" has a class of "required_size",and given the input has a minlength attribute, and given text 
has been entered with a length that does not exactly match the minlength attribute's value, when this form's validation runs, 
then an error appears in the correct location,and the error text says"Required_size field lengths must exactly match the 
minlength attribute of that field. 

10.Given an input of type "text" has a class of "username",and given anon-alphanumeric character has been entered into this input,
 when this form's validation runs, then an error appears in the correct location, and the error text says "Username fields must 
 contain only alphanumeric characters."
 
11.Given an input of type "text" has a class of "username",and given fewer than eight characters have been entered into this input,
 when this form's validation runs, then an error appears in the correct location,and the error text says"Username fields must contain 
 at least 8 characters.

12.Given an input of type "text" has a class of "date",and given an entry that does not match the "XX/XX/XXXX" format has been
  entered into this input, when this form's validation runs, then an error appears in the correct location, and the error text 
  says "Date fields must match the format of XX/XX/XXXX."
  
13.Given an input of type "text" has a class of "phone",and given an entry that does not match the "XXX-XXX-XXXX" format has been
entered into this input, when this form's validation runs, then an error appears in the correct location, and the error text says
"Phone fields must match the format of XXX-XXX-XXXX."
  
14.Given an input of type "text" has a class of "password",and an entry that does not contain one of: (uppercase letter, 
lowercase letter,number, special character) has been entered into this input, when this form's validation runs, then an error appears
 in the correct location, and the error text says "Password fields must contain one or more of each of the following types:uppercase 
 letters, lowercase letters, numbers, special characters."
 
15.Given an input of type "text" has a class of "alphabetic",and given anon-alphabetic character has been entered into this input, 
when this form's validation runs, then an error appears in the correct location, and the error text says "Alphabetic fields must be
a series of alphabetic characters."

16.Given an input of type "text" has multiple classes,when this form's validation runs, then all pertinent validation for this input 
is run:a.For example, if an input has alphabetic and required_size,then both the alphabetic validation and required_size validation 
would need to run.

//error section
1. If error in form, then error appears in error section.
2. Each form error will appear as an unordered list with red text

//submission section
3. Error will no submit form
4. If no error, form is submitted
5. Each form will run independently

///Requirement Classes
6. "Required" class needs to be filled with characters. Else error text shows on textfield and error section 
        "Required fields must have a value that is not empty or whitespace."
        [.].test
7. If no required class when validation runs, empty space shows no error
8. "Numeric" class needs to have numbers, if a non-numeric character has been entered into this input an error appears in the correct location, and the 
        error text says "Numeric fields must be a series of numbers."
        [0-9].test
9."required_size" Class ,and given the input has a minlength attribute, and given text length that does not exactly match the minlength attribute's value
then an error appears in the correct location
        error text says"Required_size field lengths must exactly match the minlength attribute of that field.
        /\w{3}/
10."username" class,and given a non-alphanumeric character has been entered into this input,
 when this form's validation runs, then an error appears in the correct location, and the 
        error text says "Username fields must contain only alphanumeric characters."
11."username" class ,and given fewer than eight characters have been entered into this input,when this form's validation runs, 
then an error appears in the correct location,and the
         error text says"Username fields must contain at least 8 characters.
12."date" class -if entry that does not match the "XX/XX/XXXX" format  then an error appears in the correct location, and the 
        error text says "Date fields must match the format of XX/XX/XXXX."
        /\d{2}/\d{2}/\d{4}/
13."phone" class - ,if entry that does not match the "XXX-XXX-XXXX" format then an error appears in the correct location, and the 
        error text says "Phone fields must match the format of XXX-XXX-XXXX."
        /\d{3}-\d{3}-\d{4}/
14."password" class - if entry that does not contain one of: 
    (uppercase letter, 
    lowercase letter,
    number, 
    special character)  
            error text says "Password fields must contain one or more of each of the following types:uppercase letters, lowercase letters, numbers, special characters."
15."alphabetic" class if a non-alphabetic character has been entered and the 
        error text says "Alphabetic fields must be a series of alphabetic characters."
16.multiple classes, if multiple validations in form  then all pertinent validation for this input is run
For example, if an input has alphabetic and required_size,then both the alphabetic validation and required_size validation would need to run.
*/

//create li and error message 
const writeErrorList = () => { 
    const errorText = null; //how do I get the error message from Validation Error?
    const newListItem = document.createElement('li');
    
    errorText.classList.add('error'); //link to class to change text red

    const textSpan = document.createElement('span');
    textSpan.appendChild(document.createTextNode("errorText"));
  
    newListItem.appendChild(textSpan);
    document.querySelector('ul').appendChild(newListItem)
  
  };

  /*Checks validity of a word
  
 const isValidWord = (word) => {
   const words = getWordList();
   return (        //Richy Note* is this like a if statement??
     !/[^A-Z]/.test(word) && //Only text   //error - line 78 - changed "!/[^A-Z]/" to "/[^A-Z]/" //why return not True?
     word.length >= 3 && //Word length at least 3 //error - line79 changed "<" to ">=""
     !words.includes(word)
     ); //Not allowing duplicates
  };
    */
const isRequired = () => {
    const requiredInput = null; //Need to get input from TextField ID
    return (
        /S/.test(requiredInput)
    );
}
const isNumber = () =>{
    const numberInput = null;
    return(
        /0-9/.test(numberInput)
    );
}

const isRequiredLength = () =>{
        const requiredLength = null;
        return(
                requiredLength.length === num//fill in with required number for field

        );
}

const isUsername =() =>{
        const userName = null;
        return (
                /\w/.test(userName)&&
                userName.length === num
        );
}

const isDate = () =>{
        const date = null;
        return(
       // /\d{2}/\d{2}/\d{4}/.test(date);
        );
}

const isPhoneNumber = () =>{
        const phonenumber = null;
        return(
        /\d{3}-\d{3}-\d{4}/.test(phonenumber)
        );
}

const isPassword = () =>{
        const password = null;
        return(
        /^a-z$/.test(password) && //At least one uppercase letter
        /^A-Z$/.test(password) && //At least one lowercase letter
        /^\d$/.test(password) && //At least one digit
        /^\W$/.test(password) // At least one specal character
        )
}

const isLetters =() =>{
        const letter = null;
        return(
        /A-Za-z/.test(letter)
        )

}

const validateForm = formSelector => {
        const formElement = document.querySelector(formSelector)
        
        const validateSingleFormGroup = formGroup => {
                const label = formGroup.querySelector('label');
                const input = formGroup.querySelector('input')
        };
        
        formElement.setAttribute('novalidate','');


        formElement.addEventListener('submit',event=>{
                event.preventDefault();
                validateAllFormGroups(formElement);
        });

        const validateAllFormGroups = formToValidate =>{
                const formGroups = Array.from(formToValidate.querySelectorAll(.'formGroups'))

                formGroups.forEach(formGroup=>{
                        validateSingleFormGroup(formGroup);
                })
        }
}
validateForm('novalidate')