/////////

const validateForm = (event) => {
    event.preventDefault();

    //Validation Functions
    const isRequiredValid = (input) => {
        const rule=/[\s]/
        return rule.test(input.value);
    };

    const isAlphabeticValid = (input) =>{
        const rule = /^A-Za-z$/;
        return rule.test(input.value);
    };

    const isPasswordValid = (input) =>{
        const rule = /^A-Za-z\d\W$/ //At least one uppercase letter, At least one lowercase letter, At least one digit, At least one specal character
        return rule.test(input.value);
    };

    const isLengthValid = (input) =>{
        const ruleLength = input.getAttribute("minlength")
        return input.value.length === parseInt(ruleLength);
    };

    const isNumberValid = (input) => {
        const rule = /^0-9$/
        return rule.test(input.value);
    };

    const isphoneValid = (input) => {
        const rule =/\d{3}-\d{3}-\d{4}/
        return rule.test(input.value);
    };

    const isDateValid = (input) => {
        const rule = /^\d{2}[- /.] d{2}[- /.] \d{4}$/
        return rule.test(input.value);

    };

    const isUsernameValid = () => {
        //need to update
    };

    //Get all forms within the HTML page
    const forms = document.querySelectorAll('form');

    //Loop forms within HTML page for validation
    for (const form of forms){

        //Get all inputs within the form
        const inputs = form.querySelectorAll('input');

        //Loop a single input through the vaildation errors on the form
        for (const input of inputs){
        const errorList = [];    
            
            //if statements - match to class
            if(input.classList.value === ('required')){ //getElementsByClassName()
                if (isRequiredValid(input) === false){
                    errorList.push('Required fields must have a value that is not empty or whitespace.');
                    console.log(input.value +);
                    console.log(errorList);
                }
            }

            if(input.classList == 'alphabetic'){
                 if(isAlphabeticValid(input) === false){
                    errorList.push('Alphabetic fields must be a series of alphabetic characters.');
                 };
            }

            if(input.classList == 'username'){//need to add length error check as well
                if (isUsernameValid(input) === false){
                    errorList.push('Username fields must contain only alphanumeric characters.');
                }
                else if (isLengthValid(input)===false){
                    errorList.push('Username fields must contain at least 8 characters.');
                };
            }

            if(input.classList === 'password'){
                if (isPasswordValid(input)===false){
                errorList.push('Password fields must contain one or more of each of the following types:uppercase letters, lowercase letters, numbers, special characters.');
                }
            }

            if(input.classList === 'required_size'){
                if (isLengthValid(input)===false){
                errorList.push('Required_size field lengths must exactly match the minlength attribute of that field.');
                }
            }

            if(input.classList === 'phone'){
                if (isphoneValid(input)===false){
                errorList.push('Phone fields must match the format of XXX-XXX-XXXX.');
                }
            }

            if(input.classList === 'date'){
                if (isDateValid(input) === false){
                errorList.push('Date fields must match the format of XX/XX/XXXX.');
                }
            }

            if(input.classList === 'numeric'){
                if (isNumberValid(input) === false){
                errorList.push('Numeric fields must be a series of numbers.');
                }
            }
            /*//proof of how dumb I am :)
            if(input.classList = 'numeric'){
                !isNumberValid(input);
                errorList.push('Numeric fields must be a series of numbers.');
            */
        //} 

            if(errorList.length > 0){
                //writeErrorList(errorList);
                event.preventDefault();
                //writeErrorList(errorList);
                document.querySelector('.errors').innerHTML = errorList.join(',');
                document.querySelector('.errors').style="color:red";
                console.log(errorList);        

            } //end if

        }//end for loop - input

    }// end for loop - form


    /*
    //Create error list in Error Div
    const writeErrorList = (errorList) => { 

        //create the ul element
        const newErrorListu = document.createElement('ul');   
        const errorDivLocation = document.querySelector('.errors');
        newErrorListu.append(errorDivLocation); //need to append to <div class="errors">?
        newErrorListu.style="color:red";
        const newErrorList = [...new Set (errorList)];
        //loops through errorList array to create individual li elements and textnodes
        for (const error of newErrorList){

            const newErrorListItem = document.createElement('li');
            newErrorList.appendChild(newErrorListItem);

            const errorText = document.createTextNode(error);
            newErrorListItem.appendChild(errorText);
        } //end for loop

    } //end function - writeErrorList
    */  

} //end function - validateForm

document.querySelector('form').addEventListener('submit',validateForm);