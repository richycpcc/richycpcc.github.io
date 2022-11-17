/////////

const validateForm = (event) => {
    event.preventDefault();
console.log('Start Valid');
    //Validation Functions
    const isRequiredValid = (input) => {
        const rule=/[\s]/;
        return rule.test(input.value);
    }

    const isAlphabeticValid = (input) => {
        const rule = /^A-Za-z$/;
        return rule.test(input.value);
    }

    const isPasswordValid = (input) => {
        const rule = /^A-Za-z\d\W$/; //At least one uppercase letter, At least one lowercase letter, At least one digit, At least one specal character
        return rule.test(input.value);
    }

    const isLengthValid = (input) => {
        const ruleLength = input.getAttribute("minlength");
        return input.value.length === parseInt(ruleLength);
    }

    const isNumberValid = (input) => {
        const rule = /^0-9$/;
        return rule.test(input.value);
    }

    const isphoneValid = (input) => {
        const rule =/\d{3}-\d{3}-\d{4}/;
        return rule.test(input.value);
    }

    const isDateValid = (input) => {
        const rule = /^\d{2}[- /.] d{2}[- /.] \d{4}$/;
        return rule.test(input.value);

    }

    const isUsernameValid = () => {
        //need to update
    }

    //Get all forms within the HTML page
    const forms = document.querySelectorAll('form');

    const errorsDiv = event.target.parentNode.querySelector('.errors');
    errorsDiv.textContent = ""; // clears out error field for new list

    //Loop forms within HTML page for validation
   // for (const form of forms){
    const form = event.target;

        console.log("hi")

       // event.preventDefault();
        //Get all inputs within the form
        const inputs = form.querySelectorAll('input');
            const errorList = []; 
        //Loop a single input through the vaildation errors on the form
        for (const input of inputs){
   //if characters in input field, then do action 
   //else do no action unless requried
        if (input.value == "" && input.classList.value.includes('required')){

            //if statements - match to class
            if(input.classList.value.includes('required') && (!isRequiredValid(input)))
            {
                errorList.push('Required fields must have a value that is not empty or whitespace.');
                console.log(input.value);
                console.log(errorList);
            }
            
            if(input.classList.value.includes('alphabetic') && (!isAlphabeticValid(input)))
            {
                    errorList.push('Alphabetic fields must be a series of alphabetic characters.');
            }
            
            if(input.classList.value.includes('username') && (!isUsernameValid(input)))
            {
                errorList.push('Username fields must contain only alphanumeric characters.');
            }

            if (input.classList.value.includes('username') && (!isLengthValid(input)))
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
        }else{
            errorList.push('No Problemo');
        }   
            /*//proof of how dumb I am :)
            if(input.classList = 'numeric'){
                !isNumberValid(input);
                errorList.push('Numeric fields must be a series of numbers.');
            */
        } //end for loop - input

        if(errorList.length > 0) {
            const newUnorderedList = document.createElement('ul');
            errorsDiv.appendChild(newUnorderedList);
            errorsDiv.style = "color:red";

            for (const error of errorList){                
                const newListItem = document.createElement('li');
                const liText = document.createTextNode(error);
                newListItem.appendChild(liText);
                newUnorderedList.appendChild(newListItem);
            }

        } //end if
 //   } // end for loop - form

} //end function - validateForm

const formButtons = document.querySelectorAll('form');
for (const button of formButtons){
    button.addEventListener('submit', validateForm);

}

//document.querySelector('form').addEventListener('submit', alert('Forms sumbitted'));