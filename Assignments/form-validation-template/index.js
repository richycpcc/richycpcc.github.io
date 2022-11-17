/*const validateForm = formSelector =>{
    const formElement = document.querySelector(formSelector);

    const errorList = [];

        const validationOptions ={

            attribute: 'required',
            isValid: input => input.value.trim() !== '',
            errorMessage: (input, label) => `${label.textContent} is required`,

            attribute: 'minlength',
            isValid: input => input.value && input.value.length >= parseInt(input.minLength,10),
            errorMessage:(input, label) => `${label.textContent} needs to be`,

            attribute: 'pattern',
            isValid: input => {
                const patternRegex = new RegExp(input.patern);
                return patternRegex.test(input.value);
            },
            errorMessage: (input, label) =>`Not a valid `,



        }

        const validateSingleFormGroup = formGroup =>{
                const label = formGroup.querySelector('label');
                const input = formGroup.querySelector('input, textarea');
                const errorContainer = formGroup.querySelector('error');
                const errorIcon = formGroup.querySelector('.error-icon');
                const sucessIcon = formGroup.querySelector('.sucess-icon');

                let formGroupError=false;
                for (const option of validationOptions){
                        if (input.hasAttribute(option.attribute) && !option.isValid(input)){
                            errorContainer.textContent = option.errorMessage(input,label);
                            input.classList.add('redText');
                            formGroupError = true;
                        }
                }
                if (!formGroupError){
                    errorContainer.textContent ='';
                }
        };


    formElement.addEventListener ('submit', event =>{
        event.preventDeault();
    });

    const validateAllFormGroups = formToValidate =>{
        const formGroups = Array.from(formToValidate.querySelectorAll('.formGroup'));

        formGroups.forEach(formGroup => {
            validateSingleFormGroup(formGroup);
        });
    }
};
validateForm('form');

*/
/////////


//Validation Functions
const isRequiredValid = (input) => {
    return input != '';
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
    return input.value.length === parseInt(input.getAttribute("minlength"));
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
    const rule = /^(0[1-9]|1[012])[- /.] (0[1-9]|[12][0-9]|3[01])[- /.] (19|20)\d\d$/
    return rule.test(input.value);

};

form.addEventListener('submit', function (e){
    //Get all forms within the HTML page
    const forms = document.querySelectorAll('form');

//Loop forms within HTML page for validation
for (const form of forms){

    //Get all inputs within the form
    const inputs = document.querySelectorAll('input');

    //Loop the input through the vaildation errors
    for (const input of inputs){
        //const label = formGroup.querySelector('label');
        const input = formGroup.querySelector('input');
        const errorList = [];
    
        if(input.classList = 'requried'){
            !isRequiredValid(input);
            errorList.push('Required fields must have a value that is not empty or whitespace.');
        }
        if(input.classList = 'alphabetic'){
            !isAlphabeticValid(input);
            errorList.push('Alphabetic fields must be a series of alphabetic characters.');
        }
        if(input.classList = 'username'){
            !isUsernameValid(input);
            errorList.push('Username fields must contain only alphanumeric characters.');
        }
        if(input.classList = 'password'){
            !isPasswordValid(input);
            errorList.push('Password fields must contain one or more of each of the following types:uppercase letters, lowercase letters, numbers, special characters.');
        }
        if(input.classList = 'required_size'){
            !isRequiredLength(input);
            errorList.push('Required_size field lengths must exactly match the minlength attribute of that field.');
        }
        if(input.classList = 'phone'){
            !isphoneValid(input);
            errorList.push('Alphabetic fields must be a series of alphabetic characters.');
        }
        if(input.classList = 'date'){
            !isDateValid(input);
            errorList.push('Date fields must match the format of XX/XX/XXXX.');
        }
        if(input.classList = 'numeric'){
            !isNumberValid(input);
            errorList.push('Numeric fields must be a series of numbers.');
        }
        if(errorList.length > 0){
            writeErrorList(errorList);
        }
    }
    //Create error list in Error Div
    const writeErrorList = (errorList) => { 

        //create the ul element
        const newErrorList = document.createElement('ul');   
        newErrorList.append(.errors); //need to append to <div class="errors">?
        newErrorList.style="color:red";

        //loops through errorList array to create individual li elements and textnodes
        for (error of errorList){

            const newErrorListItem = document.createElement('li');
            newErrorList.appendChild(newErrorListItem);

            const errorText = document.createTextNode(error);
            newErrorListItem.appendChild(errorText);
      
        }
    }
}
});