/*
 1. App should use JavaScript, HTML, and CSS
2. The page should display a grid of buttons containing numbers from 1-25
3. The initial class name of any button containing numbers must be “tile” with a hex
code of rgb(27, 62, 119) and this color may NOT be used anywhere else in the
exercise.
4. Numbers should have a randomized order
5. When a user clicks a number, if it is the next number in order, then its background
turns a different color for the remainder of the test. If it is the wrong number,
nothing happens
6. Once all numbers have been clicked in order, display a win message with the text
“You Win!”.
7. Include a button to start a new game at any time with the text content “Start!”.
8. Hitting the “Start!” button defaults to starting a game containing 25 numbers and
clicking the start button on subsequent clicks defaults to starting a game
containing 25 numbers and will shuffle the numbers and restart the game. No
other buttons to start a game are allowed.
*/ 

/////// TONY

// The grid div
let allButtons = document.getElementById("buttons")

// The amount of grid spots
let gridSpots = 60

// The amount of numbers to find
let amountOfChosenNumbers = 8

// Numbers to find
let chosenNumbers = []

//need to make a loop adding numbers into an array up to max number 
//should be like while i<max array.push i
//rng to select a number from the array that is UNIQUE
//maybe just need to guarantee the array value is unique? so if array[random] = array[random] then jump to top
/* since we are doing input max we need to have the HTML grid be of variable height/width, 
could maybe do width=sqrt(max) or maybe set it a rectangle? */
//maybe we could remove it from the array in the same function we are pushing it to html?

// Generate a random number from 0 to y
let RandomRange = (y) => {
    return Math.floor(Math.random() * y);
}

// Check if value exists in an array
let ValueInArray = (v, arr) => {
    // Set the return value
    let ret = false
    arr.forEach(x => {
        if (x == v) {
            ret = true; // Exit the loop
        }
    });

    return ret;
}

// Generate the random number
let GenerateNumbers = () => {
    chosenNumbers = [] // clear the array

    // Loop through each number slot
    for (let index = 0; index < amountOfChosenNumbers; index++) {
        let done = false

        // Generate a random number
        while (!done) {
            let val = RandomRange(gridSpots)
            // Check if number has already been generated
            if (!ValueInArray(val, chosenNumbers)) {
                // Add number and exit loop
                chosenNumbers.push(val)
                done = true
            }
        }
    }
}


// Generate the button div's
let GenerateButtons = () => {
    // Loop through each button slot
    for (let i = 0; i < gridSpots; i++) {
        // Check if number is a chosen number
        let chosenButton = ValueInArray(i, chosenNumbers)

        // Set the class depending on if the button is chosen
        if (chosenButton) {
            allButtons.innerHTML += "<button class= \"correct-tile\">" + i + "</button>"
        } else {
            allButtons.innerHTML += "<button class= \"tile\">" + i + "</button>"
        }
    }
}

// Generate the listeners
let GenerateListeners = () => {
    for (let index = 0; index < allButtons.children.length; index++) {
        const element = allButtons.children[index];

        element.addEventListener("click", () => {
            if (element.className === "correct-tile") {
                element.className = "found-tile"
            } else {
                element.className = "wrong-tile"
            }
        })
        
    }

}

/* put the event listener for max number and submit button here and function call */
let maxNumberInArray = 25 // user input
/* end of event listener calls */

////////////////////////////////////////////////////////////////////////////////////////////////
//lucas will do this one 
/* put the rng array and random loop caller here */ 
// math.rand(array.length) - 1? 
//loop while array.length>0 then put number in html and strip from array
let gameArray = [];
let loopCounter = 1
while (loopCounter <= maxNumberInArray) {
    gameArray.push(loopCounter);
    loopCounter++;
}//fills the array up to user input (starting at 1)
console.log(gameArray)

while (gameArray.length > 0){
    let randomArrayCaller = Math.floor(Math.random()*gameArray.length)
    console.log(gameArray[randomArrayCaller])
    gameArray.splice(randomArrayCaller,1)
}
console.log(gameArray)


/* end of the rng and loop array */

/////////////////////////////////////////////////////////////////////////////////////////////////////

//set up if color statement if(number click = previous + 1){change color}

// end of color changer

/////////////////////////////////////////////////////////////////////////////////////////////////////

// Start the game




//Richy's work



const startProject = (event)=>{
//generate randomized number array
//const getGridNumber = (event) => {
    const totalButtonInput = event.target.parentNode.querySelector('#tileNumberInput').value;
    let totalButton = parseInt(totalButtonInput)
    let totalButtons = 25;
    const gridNumbers =[];
    for (let counter = 1; counter <= totalButtons;counter++){//need to update to totalButton after confirm testing
        gridNumbers.push(counter);
        gridNumbers.sort(() => Math.random() - 0.5);
    }
//}

//generate tile buttons
//const getTiles = () =>{
    for (grid of gridNumbers){
    //generating tiles
        const tile = document.createElement('button');
        const menu = document.querySelector('#menu');

        //attaching values to tiles
        tile.classList = "tileStyle";
        menu.appendChild(tile);
        tile.innerText = grid;
        const titleNum = tile.value = grid;

        //attaching click event to button if needed
        //button.addEventListener('click',selectedTile)
            //add check for correct clicked button??
    }
//}

//check for correct clicked button
const selectedTile = ()=>{
    let tileCounter = 1;
        if (tileNum = tileCounter){//
            console.log("correct");
            tileCounter  = tileCounter + 1;
            document.body.style.background = randomBackgroundColor();
            tile.classList.add("correct-tile");
        }else if(tileCounter = totalButtons){ //need to update to totalButton after confirm testing
            console.log("nothing");
            document.querySelector('#results').append("You Win!")
        }else{
            console.log("nothing");
        }
}

//generate random background color
const randomBackgroundColor = () =>{
    let x = Math.floor(Math.random()*256);
    let y = Math.floor(Math.random()*256);
    let z = Math.floor(Math.random()*256);
    let newBackgroundColor = `rgb(${x},${y},${z})`;
    console.log(newBackgroundColor);
}
/*
//clear game
const clearGame = () =>{
    totalButtonInput = 0;
    counter = 0;
    titleCounter =1;
    gridNumbers=[];
    document.body.style.background = rgb(27,62,119);
    remove class from all buttons
}
*/
/*
//timer
 let time = 0;
 let timePassing = setInterval(function()){
    time = time + 1;
    document.getElementById("timer").innerHTML = time;
 }
 */
}
document.querySelector('#buttonStart').addEventListener('click', startProject);