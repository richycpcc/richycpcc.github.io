console.log("This script is running in the fizzbuzz page.");
        let output ="";
        let startNumber = 1;
        let endNumber = 100;

        for(let counter = startNumber; counter <= endNumber; counter = counter + 1)
        {
            output = output + "<li>";

            if ((counter % 3 == 0 ) && (counter % 5 == 0))
            {
                output = output + "FizzBuzz";
            }
            else if(counter % 3 == 0 )
            {
                output = output + "Fizz";
            }
            else if(counter % 5 == 0 )
            {
                output = output + "Buzz";
            }
            else 
            {
                output = output + counter;
            }
            output = output + "</li>";
        }

        output = output +"<ul>";
        document.getElementById("results1").innerHTML = output;

    let output2 = ""; 
    let startNumber2 = 1;
    let endNumber2 = 100;

    output2 = output2 + "<ol>";

    for(let counter2 = startNumber2; counter2 <= endNumber2; counter2 = counter2 + 1)
    {
        console.log("Your counter is " + counter2);
        output2 = output2 + "<li>";

        let newText = "";

        if (counter2 % 3 == 0){
            newText = "Fizz";
        }

        if (counter2 % 5 == 0){
            newtext = "Buzz"
        }

        if (newText == ""){
            newText = counter2;
        }

        output2 = output2 + newText + "</li>";
    } // end loop

    output2 = output2 + "</ol>";
    document.getElementById("results2").innerHTML = output2;
