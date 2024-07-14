function addNote() {

	let note = document.getElementById('note').value;

	data = `newNote=${note}`      // string interpolation (this line is for quary input in the url)
	//step 1 create Request Object 

	var xhr = new XMLHttpRequest();  //AJAX - XHR 


	// step 2  - open the connection 

	xhr.open('GET', `addNote?${data}`);   // route?data=""&id="someid"  

	// step 4
	xhr.onload = () => {

		console.log('on load triggered');



		if (xhr.readyState === 4) {

			if (xhr.status == 200) {
				

				let listObject = JSON.parse(xhr.responseText);  // for converting the obtained response (is comes into the array format[that's why we got the length]) to JSON format
				console.log(listObject);
  
				document.getElementById('tbdy').innerHTML = '';
				
				for (let i = 0; i < listObject.length; i++) {
					
					let tr = document.createElement('tr');
					
					let idElement = document.createElement('td');
					idElement.textContent=listObject[i].id;
					//document.getElementsByClassName("tbdy")[0].appendChild(idElement);
					tr.appendChild(idElement);
					
					let noteElement =document.createElement('td');
					noteElement.textContent=listObject[i].note;
					//document.getElementsByClassName("tbdy")[0].appendChild(noteElement);
					tr.appendChild(noteElement);

					document.getElementById("tbdy").appendChild(tr);

				}

			}
			else {

				console.log("error occured")
			}
		}
	} // prepareing the request 
	xhr.send();

	console.log(xhr);

}




function updateNote() {


	let note = document.getElementById('note').value;
	let id = document.getElementById('mapId').value;


	let dataObject = {

		id: id,
		note: note
	}

	postData = JSON.stringify(dataObject);
	console.log(postData);
	//step 1 
	let xhr = new XMLHttpRequest();


	//step 2
	xhr.open('POST', 'update');

	//step 3

	xhr.onload = () => {

		if (xhr.readyState === 4) {

			if (xhr.status == 200) {  // STATUS-OK

				let listObject = JSON.parse(xhr.responseText);  // for converting the obtained response (is comes into the array format[that's why we got the length]) to JSON format
				console.log(listObject);

				document.getElementById('tbdy').innerHTML = '';

				for (let i = 0; i < listObject.length; i++) {

					let tr = document.createElement('tr');

					let idElement = document.createElement('td');
					idElement.textContent = listObject[i].id;
					//document.getElementsByClassName("tbdy")[0].appendChild(idElement);
					tr.appendChild(idElement);

					let noteElement = document.createElement('td');
					noteElement.textContent = listObject[i].note;
					//document.getElementsByClassName("tbdy")[0].appendChild(noteElement);
					tr.appendChild(noteElement);

					document.getElementById("tbdy").appendChild(tr);
					}

			}
			else {

				console.log("error occured")
			}
		}
	}
	xhr.send(postData);

}


function deleteNote() {
	

	    let id = document.getElementById('mapId').value;
		let dataObject = {

			id: id,
		}

		postData = JSON.stringify(dataObject);
		console.log(id);
	    // Create Request Object
	    var xhr = new XMLHttpRequest();

	    // Open the connection
	    xhr.open('POST', 'delete');

	    // Handle the response
	    xhr.onload = () => {
	        console.log('on load triggered');

	        if (xhr.readyState === 4) {

	            if (xhr.status == 200) 
				{
					let listObject = JSON.parse(xhr.responseText);  // for converting the obtained response (is comes into the array format[that's why we got the length]) to JSON format
					console.log(listObject);

					document.getElementById('tbdy').innerHTML = '';

					for (let i = 0; i < listObject.length; i++) {

						let tr = document.createElement('tr');

						let idElement = document.createElement('td');
						idElement.textContent = listObject[i].id;
						//document.getElementsByClassName("tbdy")[0].appendChild(idElement);
						tr.appendChild(idElement);

						let noteElement = document.createElement('td');
						noteElement.textContent = listObject[i].note;
						//document.getElementsByClassName("tbdy")[0].appendChild(noteElement);
						tr.appendChild(noteElement);

						document.getElementById("tbdy").appendChild(tr);
                        } 
				}
				else {
	                console.log("error occurred");
	            }
	        }
	    }
	    // Send the request
		// you need to send the JSON string to the backend right?  now you need to get it 
	    xhr.send(postData);

	    console.log(xhr);
	}


function getNote() {
		

		    let id = document.getElementById('mapId').value;
			let dataObject = {

				id: id,
			}

			postData = JSON.stringify(dataObject);
			console.log(id);
		    // Create Request Object
		    var xhr = new XMLHttpRequest();

		    // Open the connection
			xhr.open('POST', 'getNote');
			xhr.onload = () => {

					console.log('on load triggereddd');
					if (xhr.readyState === 4) {

						if (xhr.status == 200) 
							{
							//document.getElementsByClassName('raj').innerHTML = xhr.responseText;

							/*let listObject = JSON.parse(xhr.responseText);  // for converting the obtained response (is comes into the array format[that's why we got the length]) to JSON format
							console.log(listObject);

								let noteElement = document.createElement('tr');
								noteElement.textContent = listObject.note;

								document.getElementsByClassName("task-list").appendChild(noteElement);
			 

							*/

							let listObject = JSON.parse(xhr.responseText);  // for converting the obtained response (is comes into the array format[that's why we got the length]) to JSON format
												console.log(listObject);

							document.getElementById('tbdy').innerHTML = '';

							let tr = document.createElement('tr');

							let idElement = document.createElement('td');
							idElement.textContent = listObject.id;
							//document.getElementsByClassName("tbdy")[0].appendChild(idElement);
							tr.appendChild(idElement);

							let noteElement = document.createElement('td');
							noteElement.textContent = listObject.note;
							//document.getElementsByClassName("tbdy")[0].appendChild(noteElement);
							tr.appendChild(noteElement);
                            document.getElementById("tbdy").appendChild(tr);
					}

				}
				else {

					console.log("error occured")
				}
			}
				 // prepareing the request 
				xhr.send(postData);

				console.log(xhr);

		}