//document.write("welcome to java script")
function AddTask()
{
    var input=document.getElementById('input1').value
    var element = document.getElementById('task-container')
    console.log(element)
    var newElement= document.createElement('div')
    newElement.setAttribute('id', 'individual-container')
    newElement.innerHTML=`<h3>${input}</h3><button onclick="DeleteTask(event)">Delete</button>`
    element.append(newElement)
}
function DeleteTask(event)
{
   event.target.parentElement.remove()
   
}


