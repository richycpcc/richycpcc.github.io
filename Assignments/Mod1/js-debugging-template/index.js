/**
 * Adds event listeners
 * @param {string} id element's id
 * @param {function} callback function to be run on click
 * @param {string} eventType defaults to click, but can be any event type
 */
const addListener = (id, callback, eventType = 'click') => {
    document.getElementById(id).addEventListener(eventType, callback); //error - Line 8 - changed getElementsByClassName to getElementById? why is this the only one that works.
  };
  
  /**
   * Adds a word to the word search set up
   * @param {Event} e
   */
  const onAddWord = (e) => {
    resetError();
    const wordInput = document.getElementById('new-word');
  
    const word = wordInput.value.toUpperCase();//error - Line19 - replaced "innerText" to "value"//console not getting input. Is a variable an HTML element for innerText ? https://www.w3schools.com/jsref/prop_attr_value.asp
  
    if (isValidWord(word)) { // error - Line 21 - changed "!isValidWord(word)" to "isValidWord(word)" //richy note. If not Valid word, remove error class else add error??
      wordInput.classList.toggle('error', false); //Remove error class from input
  
      writeWordToList(word);
  
      wordInput.value = ''; //Clear input text
    }else { //error line 27- added "}" to line.
      wordInput.classList.toggle('error', true); //Add error class to input
    }
  };
  
  /**
   * Handles user clicking create. Will either generate grid or write an error
   * @param {Event} e 
   */
  const onCreate = (e) => { 
    resetError();
    const words = getWordList(); //error - Line 38 changed "word" to "words"
    const height = Number(document.getElementById('height').value);
    const width = Number(document.getElementById('width').value);
  
    if (isValidWordList(words, width, height)) {
      try {
        generateWordSearch(words, height, width);
      } catch (err) {
        //Alert user of issue;
        if (err.message.indexOf('Unable to generate') === -1) {
          throw err;
        } else {
          writeError('The lazy developer was unable to generate a word search. Please try using a larger grid, or use fewer words.');
        }
      }
    } else {
      writeError('Are you trying to break the game? Your words must be smaller than the largest dimension of the game board');
    }
  };
  
  /**
   * Allows users to hit the "enter" key to add a word.
   * @param {} e
   */
  const onEnter = (e) => {
    if (e.keyCode === 13) {     //richy note* actually a thing. http://gcctech.org/csc/javascript/javascript_keycodes.htm
      document.getElementById('add-word').click(); //added "'" to line.
    }
  };
  
  /**
   * Checks validity of a word
   *
   * @param {string} word
   *
   * @returns {boolean} Word is all text, at least 3 characters, and is unique
   */
  const isValidWord = (word) => {
    const words = getWordList();
    return (        //Richy Note* is this like a if statement??
      !/[^A-Z]/.test(word) && //Only text   //error - line 78 - changed "!/[^A-Z]/" to "/[^A-Z]/" //why return not True?
      word.length >= 3 && //Word length at least 3 //error - line79 changed "<" to ">=""
      !words.includes(word)
    ); //Not allowing duplicates
  };
  
  /**
   * Adds word to word bank, with a trash can icon
   * @param {string} word - word to add to word bank
   */
  const writeWordToList = (word) => { //line 88 changed "writeWrodToList" to "writeWordToList"
    const li = document.createElement('li'); //*Richy note - can you name a variable with an element name??
  
    const trashButton = document.createElement('div');
    trashButton.classList.add('icon'); //error line 92 - changed "class" to "classList" ****Added ; to end of line! is this suppose to be a bug??
    let trashIcon = document.createElement('i'); //*richy note - an "i" element is in idiomatic Text Element, fancy way of saying italic?
    trashIcon.classList.add('fa', 'fa-trash-alt');
    trashButton.addEventListener('click', deleteWord); 
    trashButton.appendChild(trashIcon);
  
    const textSpan = document.createElement('span');
    textSpan.appendChild(document.createTextNode(word));
  
    li.appendChild(textSpan);
    li.appendChild(trashButton);
  
    getNextWordsContainer().appendChild(li);
  };
  
  /**
   * Removes the given word from the word bank
   * @param {Event} e Mouse Click
   */
  const deleteWord = (e) => { //**added() around param /
    const li = e.currentTarget.parentNode;
    li.parentNode.remove(li);
  };
  
  /**
   * Retrieves all words from the word bank
   * @returns {string []} - String array of all the words in the word bank
   */
  const getWordList = () => {
    let words = [];
    const liElements = getNextWordsContainer().children; // error - line 122 changed "child" to "children" console says .child is undefined and w3schools does not list child under properties/method. "children" returns an HTMLCollection of element child elements https://www.w3schools.com/jsref/dom_obj_all.asp
   //get the collection of li's child elements
    for (const liElement of liElements) {
      words.push(liElement.firstChild.innerText); //*Richy note - this pushes the first child node of next work list to words array
    }
  
    return words; //Error line 128 - changed "liElements" to "words" //want to return array for list
  };
  
  /**
   * Helper method to get the word bank
   */
  const getNextWordsContainer = () => document.getElementById('next-word-list');
 // *Where is 'next-words' // line 134 changed "next-word" to "next-word-list"   
 // reason why {} are omitted in this function https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions
  ////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////
  ///////THERE ARE NO INTENTIONAL BUGS BELOW THIS LINE////////
  /////////////NOTHING THERE NEEDS TO BE CHANGED//////////////
  ////////////////////////////////////////////////////////////
  /**
   * Writes error text to the DOM
   * @param {string} text - error text
   */
  const writeError = (text) => {
    document.getElementById('feedback').innerText = text;
  }
  
  /**
   * Removes error message
   */
  const resetError = () => { writeError('') }
  
  
  /**
   * Handles creating the board
   * @param {[string]} words
   * @param {int} width
   * @param {int} height
   */
  const generateWordSearch = (words, width, height) => {
    //DO NOT CHANGE THIS FUNCTION - ANY CHANGES MADE DO NOT COUNT TOWARD THE BUG TOTAL
    let grid = new Array(height);
  
    for (let i = 0; i < grid.length; i++) {
      grid[i] = new Array(width);
    }
  
    words.sort((a, b) => a.length - b.length); //More effective at actually creating a board if we place the longer words first
  
    words.forEach(word => {
      let placed = false;
      let attempts = 0;
      while (!placed && attempts < 9000) {
        //Using randomness. Hopefully we can create the word in fewer than 9000 attempts
        try {
          grid = placeWord(grid, word);
          placed = true;
        } catch (e) {
          attempts++;
        }
      }
      if (!placed) {
        // “¯\_(ツ)_/¯“ Maybe this was an impossible ask, maybe not. after 9000 tries, the word couldn't be placed.
        throw new Error(
          `Unable to place "${word}". Try expanding the grid or using fewer words`
        );
      }
    });
  
    fillMissingLetters(grid);
  
    writeGrid(grid);
  };
  
  /**
   * Fills in any empty cells with a random character
   * @param {[[string]]} arr The 2d Array of characters that needs empty cells filled
   */
  const fillMissingLetters = arr => {
    //DO NOT CHANGE THIS FUNCTION - ANY CHANGES MADE DO NOT COUNT TOWARD THE BUG TOTAL
    for (let i = 0; i < arr.length; i++) {
      let row = arr[i];
  
      for (let j = 0; j < row.length; j++) {
        let cellValue = row[j];
  
        if (!cellValue) {
          arr[i][j] = getRandomCharacter();
        }
      }
    }
  };
  
  /**
   * Writes the grid to the DOM
   *
   * @param {[[string]]} grid The 2d Array of characters
   */
  const writeGrid = grid => {
    //DO NOT CHANGE THIS FUNCTION - ANY CHANGES MADE DO NOT COUNT TOWARD THE BUG TOTAL
    const table = document.getElementById('word-search');
  
    while (table.firstChild) {
      table.removeChild(table.firstChild); //More performant version of table.innerHtml = '';
    }
  
    table.classList.toggle('table-complete', true);
  
    for (const row of grid) {
      const tr = document.createElement('tr');
  
      for (const cell of row) {
        const td = document.createElement('td');
        const text = document.createTextNode(cell);
  
        td.appendChild(text);
        tr.appendChild(td);
      }
  
      table.appendChild(tr);
    }
  };
  
  /**
   * Attempts to place the word in the grid at a random position and direction
   * @param {2d Array} grid
   * @param {string} word word that should be placed in the grid
   */
  const placeWord = (grid, word) => {
    //DO NOT CHANGE THIS FUNCTION - ANY CHANGES MADE DO NOT COUNT TOWARD THE BUG TOTAL
    const gridCopy = JSON.parse(JSON.stringify(grid)); //Make a deep copy of the grid
  
    let directions = ['E', 'W', 'N', 'S', 'NW', 'SW', 'NE', 'SE'];
    let eastward = new Set(['E', 'NE', 'SE']);
    let westward = new Set(['W', 'NW', 'SW']);
    let northward = new Set(['N', 'NW', 'NE']);
    let southward = new Set(['S', 'SW', 'SE']);
  
    const direction = directions[randomNumberFrom(0, 7)];
  
    //We will override these depending on the direction
    let startRowIndex = randomNumberFrom(0, grid.length - 1);
    let startColumnIndex = randomNumberFrom(0, grid[0].length - 1);
  
    if (eastward.has(direction)) {
      startColumnIndex = randomNumberFrom(
        0,
        Math.ceil(0, grid[0].length - word.length)
      ); //If going east, we have to start it on the left side of the grid
    }
  
    if (westward.has(direction)) {
      startColumnIndex = randomNumberFrom(
        Math.floor(word.length - 1, grid[0].length - 1),
        grid[0].length - 1
      );
    }
  
    if (southward.has(direction)) {
      startRowIndex = randomNumberFrom(
        0,
        Math.ceil(0, grid.length - word.length)
      ); //If going south, we have to start in the top section of the grid
    }
  
    if (northward.has(direction)) {
      startRowIndex = randomNumberFrom(
        Math.floor(word.length - 1, grid.length - 1),
        grid.length - 1
      );
    }
  
    for (let i = 0; i < word.length; i++) {
      let columnIndex = startColumnIndex;
      let rowIndex = startRowIndex;
  
      if (eastward.has(direction)) {
        columnIndex = startColumnIndex + i; //Moving toward the right
      }
  
      if (westward.has(direction)) {
        columnIndex = startColumnIndex - i; //Moving toward the left
      }
  
      if (southward.has(direction)) {
        rowIndex = startRowIndex + i; //Moving toward the bottom
      }
  
      if (northward.has(direction)) {
        rowIndex = startRowIndex - i; //Moving toward the top
      }
  
      if (!canPlaceLetter(gridCopy, rowIndex, columnIndex, word[i])) {
        placementViolationError(word); //Throw an error if we weren't able to place the current letter with this attempt
      }
  
      gridCopy[rowIndex][columnIndex] = word[i]; //Write current letter to the grid copy
    }
  
    return gridCopy;
  };
  
  /**
   * Generates a random number from min to max
   * @param {number} min - line 326 lowest number you want //changed "numberr" to "number"
   * @param {number} max - highest number you want
   * 
   * @returns {number}
   */
  const randomNumberFrom = (min, max) => {
    //DO NOT CHANGE THIS FUNCTION - ANY CHANGES MADE DO NOT COUNT TOWARD THE BUG TOTAL
    return Math.floor(Math.random() * (max - min + 1)) + min;
  };
  
  /**
   * Generates a random capital English letter
   * 
   * @returns {string}
   */
  const getRandomCharacter = () => {
    //DO NOT CHANGE THIS FUNCTION - ANY CHANGES MADE DO NOT COUNT TOWARD THE BUG TOTAL
    return String.fromCharCode(randomNumberFrom(65, 90)); //A-Z
  };
  
  //Error
  
  const placementViolationError = word => {
    //DO NOT CHANGE THIS FUNCTION - ANY CHANGES MADE DO NOT COUNT TOWARD THE BUG TOTAL
    throw new Error(
      `Unable to generate board, no position found for "${word}"`
    );
  };
  
  
  /**
   * Checks that each word's length is shorter or equal to the longest dimension.
   * @param {String[]} words array of words
   * @param {int} width board width
   * @param {int} height board height
   *
   * @returns {boolean} Words are all shorter or equal in length to the longest dimension.
   */
  const isValidWordList = (words, width, height) => {
    //DO NOT CHANGE THIS FUNCTION - ANY CHANGES MADE DO NOT COUNT TOWARD THE BUG TOTAL
    for (const word of words) {
      let wordLength = word.length;
      if (wordLength > width && wordLength > height) {
        return false;
      }
    }
    return true;
  };
  
  /**
   * Checks if we can place the letter here
   *
   * @param {2d Array} grid word search grid
   * @param {int} row row index
   * @param {int} column column index
   * @param {character} letter letter to check
   *
   * @returns {boolean} Ability to place the letter at the current row/column.
   */
  const canPlaceLetter = (grid, row, column, letter) => {
    //DO NOT CHANGE THIS FUNCTION - ANY CHANGES MADE DO NOT COUNT TOWARD THE BUG TOTAL
    return grid[row][column] === null || grid[row][column] === letter;
  };
  
  addListener('add-word', onAddWord);
  addListener('create', onCreate);
  addListener('new-word', onEnter, 'keyup');
