//Addition Button
const toAdd = (event) =>{

    const input1 = event.target.parentNode.querySelector('#_input1').value;
    const input2 = event.target.parentNode.querySelector('#_input2').value;

    let total = input1 + input2;

  document.querySelector('#result').append(total);

} //end function

document.querySelector('#addition').addEventListener('click', toAdd);

//Subtract Button
const toSubtract = (event) =>{

    const input1 = event.target.parentNode.querySelector('#_input1').value;
    const input2 = event.target.parentNode.querySelector('#_input2').value;

    let total = input1 - input2;

  document.querySelector('#result').append(total);

} //end function

document.querySelector('#subtraction').addEventListener('click', toSubtract);


//Multiply Button
const toMultiply = (event) =>{

    const input1 = event.target.parentNode.querySelector('#_input1').value;
    const input2 = event.target.parentNode.querySelector('#_input2').value;

    let total = input1 * input2;

  document.querySelector('#result').append(total);

} //end function

document.querySelector('#multiply').addEventListener('click', toMultiply);

//Divide Button
const toDivide = (event) =>{

    const input1 = event.target.parentNode.querySelector('#_input1').value;
    const input2 = event.target.parentNode.querySelector('#_input2').value;

    let total = input1 / input2;

  document.querySelector('#result').append(total);

} //end function

document.querySelector('#divide').addEventListener('click', toDivide);