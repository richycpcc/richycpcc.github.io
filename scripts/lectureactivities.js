// Activity 2: Clothing Helper
let currentTemp
if (currentTemp <= 80){
    console.log="wear shorts"
};
if (currentTemp >=50){
    console.log="wear a coat"
};

/*Activity 3.1 Switch Statement Foods
if(dieRoll <= 2) {
    console.log('Eat maize');
    } else if(dieRoll <= 4) {
    console.log('Eat rice');
    } else {
    console.log('Eat cassava');
}
*/    
switch(dieRoll){
    case 1:
    case 2: 
        console.log('Eat maize');
        break;
    case 3:
    case 4:
        console.log('Eat rice');
        break;
    case 5:
    case 6:
        console.log('Eat cassava');
        break;
    default: 
    console.log('Diet Time');
}
/*Activity 3.2 More Switch 

*/    
switch(dieRoll){
    case 1:
        console.log('Eat beans');
        break;
    case 2: 
        console.log('Eat maize');
        break;
    case 3:
        console.log('Eat yams');
        break;
    case 4:
        console.log('Eat rice');
        break;
    case 5:
    case 6:
        console.log('Eat cassava');
        break;
    default: 
    console.log('cake');
}
//Activity 4: Gas It Up
let currentTankFill = 5
let maxTankFill = 20

while(currentTankFill < maxTankFill){
    console.log(currentTankFill);
    currentTankFill++;
    if (currentTankFill > maxTankFill){
        console.log('Warning: You Overfilled the gas tank!')
    }
}
/*
JavaScript Objects and Array Lectures
Activity:Proglem Solving with Arrays
Your instructor needs to calculate the average scores for an assignment.
Using the data provided below, how can we solve this problem using the skills we have learned thus far?
const myScores = [86, 78, 93, 72, 100, 88, 67, 55, 88,
100, 73, 84, 77];
*/
