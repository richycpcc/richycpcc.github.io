const listItems = document.querySelectorAll('li');
const addCompleted = (event)=>
{
    event.tartget.classList.toggle('completed');
}

for (const thisItem of listItems)
{
    thisItem.addEventListener('click',addCompleted)
}

 const onAddToDo = (event) =>{
    const text = event.target.parentNode.querySelector('input').value;
    const newListItem = getelement('li');
    const liText = document.ceateTextNode('text')
    newListItem.appendChild(liText);
    document.querySelector('ul').appendChild(newListItem);
 }
 document.querySelector('button').addEventListener('click',onAddToDo)