


//Addition Button
const toAdd = (event) =>{
  let input1 = document.getElementById('input1').value;
  let input2 = document.getElementById('input2').value;
  
  let num1 =parseInt(input1);
  let num2 = parseInt(input2);


    let total = num1 + num2;

  document.querySelector('#output').append(`${num1} + ${num2} = ${total}`);

} //end function

document.querySelector('#add').addEventListener('click', toAdd);

//Subtract Button
const toSubtract = (event) =>{

  let input1 = document.getElementById('input1').value;
  let input2 = document.getElementById('input2').value;
    let num1 =parseInt(input1);
    let num2 = parseInt(input2);
    let total = num1 - num2;

    document.querySelector('#output').append(`${num1} - ${num2} = ${total}`)

} //end function

document.querySelector('#subtract').addEventListener('click', toSubtract);


//Multiply Button
const toMultiply = (event) =>{

  let input1 = document.getElementById('input1').value;
  let input2 = document.getElementById('input2').value;
  let num1 =parseInt(input1);
  let num2 = parseInt(input2);

  let total = input1 * input2;

  document.querySelector('#output').append(`${num1} * ${num2} = ${total}`)

} //end function

document.querySelector('#multiply').addEventListener('click', toMultiply);

//Divide Button
const toDivide = (event) =>{

  let input1 = document.getElementById('input1').value;
  let input2 = document.getElementById('input2').value;
  let num1 =parseInt(input1);
  let num2 = parseInt(input2);

  if(num2 != 0){
    let total = num1 / num2;
    document.querySelector('#output').append(`${num1} / ${num2} = ${total}`);
  }else{
    document.querySelector('#output').append("Error: cannot divide by zero")
  } // end if

} //end function

document.querySelector('#divide').addEventListener('click', toDivide);

const toClear = () => {
  let input1 = document.querySelector("#input1");
  let input2 = document.querySelector("#input2");

  input1.value = "";
  input2.value = "";
  document.querySelector("#output").textContent = "";

};
document.querySelector('#clear').addEventListener('click', toClear);
/*
const toCalculate = (event) => {
  const input1 = event.target.parentNode.querySelector('#_input1').value;
  const input2 = event.target.parentNode.querySelector('#_input2').value;
  let output = null;
  console.log(input1);
}
document.querySelector('#toCalculate').addEventListener('click', toCalculate);

  switch ()
  {
    case 'add':
      output = input1 + input2;
      break;
    case 'subtract':
      output = input1 - input2;
      break;
    case 'multiply':
      output = input1 * input2;
      break;
    case 'divide':
      if (input2 != 0){ 
      output = input1 / input2
      }else{
        output = "Error: cannot divide by zero";
      }
      break;
  }

selectOperation = () =>{

}
compute =()=>{

}
clear = () => {

}

}
document.querySelector('#toCalculate').addEventListener('click', toCalculate);
*/