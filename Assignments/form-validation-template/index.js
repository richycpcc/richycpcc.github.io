
/**
 * 
 * @param {*} event 
 */
const validateForm = (event) => {
    event.preventDefault();

        //Regular Expression Bank
    const alphabeticRegEx = /^[A-Za-z]+$/;
    const numberRegEx = /^\d+$/s;
    const phoneRegEx = /^\d{3}-\d{3}-\d{4}$/;
    const dateRegEx = /^\d{2}[\/]\d{2}[\/]\d{4}$/;
    const alphanumericRegEx = /^[A-Za-z0-9]*$/;
    const passwordRegEx = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\W).*$/
 
        //Validation Functions
    /**
     * 
    * @param {*} input 
    * @returns {boolean} - validation for Regular Expression 
    */
    const isAlphabeticValid = (input) => {
        const test = alphabeticRegEx.test(input.value);
        return test;
    }
    /**
     * 
    * @param {*} input 
    * @returns {boolean} - validation for Regular Expression 
    */
    const isPasswordValid = (input) => {
        const test = passwordRegEx.test(input.value); //At least one uppercase letter, At least one lowercase letter, At least one digit, At least one specal character
        return test;
    }
    /**
     * 
    * @param {*} input 
    * @returns {boolean} - validation for Regular Expression 
    */
    const isLengthValid = (input) => {
        const ruleLength = input.getAttribute("minlength");
        return input.value.length === parseInt(ruleLength);
    }
    /**
     * 
     * @param {*} input 
    * @returns {boolean} - validation for Regular Expression 
    */
    const isNumberValid = (input) => {
        const test = numberRegEx.test(input.value);
        return test;
    }
    /**
     * 
    * @param {*} input 
    * @returns {boolean} - validation for Regular Expression 
    */
    const isphoneValid = (input) => {
        const test = phoneRegEx.test(input.value);
        return test;
    }
    /**
    * 
    * @param {*} input 
    * @returns {boolean} - validation for Regular Expression 
    */
    const isDateValid = (input) => {
        const test = dateRegEx.test(input.value);
        return test;
    }
    /**
     * 
     * @param {*} input 
     * @returns {boolean} - validation for Regular Expression 
    */
    const isAlphanumericValid = (input) => {
        const test = alphanumericRegEx.test(input.value);
        return test;
    }
    /**
     * 
     * @param {*} input 
     * @returns {boolean} - validation for Regular Expression 
    */
    const isUsernameLengthValid =(input) => {
        const requiredUsernameLength = 8;
        const inputUsernameLength = input.value.length
        return inputUsernameLength >= requiredUsernameLength
    }

        //Get all forms within the HTML page////// Do I still need this
    //const forms = document.querySelectorAll('form');

        //targeting specific form to validate
    const form = event.target;
    const errorsDiv = event.target.parentNode.querySelector('.errors');
    const errorList = []; 
    errorsDiv.textContent = ""; // clears out error field for new list

        //Loop a single input through the vaildation errors on the form
    for (const input of inputs)
    {
        //validate inputs
            //if characters in input field, then do action 
            //else do no action unless requried
        if (input.value.trim() != "")
        {
                //if statements - match to class
            if(input.classList.value.includes('alphabetic') && (!isAlphabeticValid(input)))
            {
                errorList.push('Alphabetic fields must be a series of alphabetic characters.');
            }
            
            if(input.classList.value.includes('username') && (!isAlphanumericValid(input)))
            {
                errorList.push('Username fields must contain only alphanumeric characters.');
            }

            if (input.classList.value.includes('username') && (!isUsernameLengthValid(input)))
            {
                errorList.push('Username fields must contain at least 8 characters.');
            }
            
            if(input.classList.value.includes ('password') && (!isPasswordValid(input)))
            {
                errorList.push('Password fields must contain one or more of each of the following types: uppercase letters, lowercase letters, numbers, special characters.');
            }

            if(input.classList.value.includes('required_size') && (!isLengthValid(input)))
            {
                errorList.push('Required_size field lengths must exactly match the minlength attribute of that field.');
            }
            
            if(input.classList.value.includes('phone') && (!isphoneValid(input)))
            {
                errorList.push('Phone fields must match the format of XXX-XXX-XXXX.');
            }
            
            if(input.classList.value.includes('date') && (!isDateValid(input)))
            {
                errorList.push('Date fields must match the format of XX/XX/XXXX.');
            }
        
            if(input.classList.value.includes('numeric') && (!isNumberValid(input)))
            {
               errorList.push('Numeric fields must be a series of numbers.');
            }
        }
            // Select class with required and exclude required_size as well. 
        else if(input.classList.value.includes('required') && (!input.classList.value.includes('_size')))
        {
            errorList.push('Required fields must have a value that is not empty or whitespace.');
        } // end if - validations

    } // end for loop - input

        // create error list on form
    if(errorList.length > 0) 
    {
        const newUnorderedList = document.createElement('ul');
        errorsDiv.appendChild(newUnorderedList);
        errorsDiv.style = "color:red";

        for (const error of errorList)
        {                
            const newListItem = document.createElement('li');
            const liText = document.createTextNode(error);
            newListItem.appendChild(liText);
            newUnorderedList.appendChild(newListItem);
        } // end for - error
    }
    else // will only submit form if no errors in array
    {
        form.submit();
    } // end if

} // end function - validateForm

    // add an addEventListener to each form when submit is clicked
const formButtons = document.querySelectorAll('form');
for (const button of formButtons) 
{
    button.addEventListener('submit', validateForm);
} // end for - addEventListeners
