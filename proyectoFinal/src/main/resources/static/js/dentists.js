// Call the dataTables jQuery plugin
$(document).ready(function() {
  loadDentists();
  $('#dentists').DataTable();
  actualizarEmailDelUsuario()
});

function actualizarEmailDelUsuario() {
    document.getElementById('user-email').outerHTML = localStorage.email;
}

function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json',
     'Authorization': localStorage.token
   };
}

async function loadDentists() {

    const request = await fetch('/dentists', {
      method: 'GET',
      headers: getHeaders()
    });
    const dentists = await request.json();
    let htmlList = '';

    for(let dentist of dentists) {
      let deleteButton = `<a href="#" onClick="deleteDentist(${dentist.id})" class="btn btn-danger btn-circle btn-sm">🗑️</a>`;
      let editButton = `<a href="#" type="button" onClick="loadDataToUpdate('${dentist.id}', '${dentist.firstName}', '${dentist.lastName}', '${dentist.registration}')" class="btn btn-info btn-circle btn-sm">🖊️</a>`;
      let dentistHtml = `<tr> 
      <td>${dentist.id}</td>
      <td>${dentist.firstName}</td>
      <td>${dentist.lastName}</td>
      <td>${dentist.registration}</td>
      <td>${deleteButton}${editButton}</td>
      </tr>`

      htmlList += dentistHtml;
    }
    document.querySelector('#dentists tbody').outerHTML = htmlList;
}

async function deleteDentist(id){

if (!confirm("¿Delete patient?")){
return;
}
const request = await fetch('/dentists/' + id, {
      method: 'DELETE',
      headers: getHeaders()
    });

location.reload();
}

function onClickCreateDentist() {
  const formData = {
    firstName: document.querySelector('#InputFirstName').value,
    lastName: document.querySelector('#InputLastName').value,
    registration: parseInt(document.querySelector('#InputRegistration').value)
};
createDentist(formData);

  }

function createDentist(formData){
  const url = '/dentists';
                const settings = {
                    method: 'POST',
                    headers: getHeaders(),
                    body: JSON.stringify(formData)
                }

            fetch(url, settings)
                        .then(response => response.json())
                        .then(data => {
                        console.log(data);


                        })
                        .catch(error => {
                        console.log(error);
                            });
}

  let form = document.querySelector('#add_new_dentist');


function submitAdd(){
    onClickCreateDentist()
    $('#myModal').modal('hide');
    resetUploadForm();
    location.reload()
}

function submitUpdate(){
editDentist()
$('#myModal').modal('hide');
resetUploadForm();
location.reload()
}

function resetUploadForm(){
        console.log("reset...")
        document.querySelector('#InputFirstName').value = "";
        document.querySelector('#InputLastName').value = "";
        document.querySelector('#InputRegistration').value = "";

    }

function loadDataToUpdate(id, firstName, lastName, registration) {
document.querySelector('#InputFirstName').value = firstName;
document.querySelector('#InputLastName').value = lastName;
document.querySelector('#InputRegistration').value = registration;
$('#myModal').modal('show');
}



function editDentist() {

  const dataToUpdate = {
    id: 1,
    firstName: document.querySelector('#InputFirstName').value,
    lastName: document.querySelector('#InputLastName').value,
    registration: parseInt(document.querySelector('#InputRegistration').value)
};

        const url = '/dentists';
                const settings = {
                    method: 'PUT',
                    headers: getHeaders(),
                    body: JSON.stringify(dataToUpdate)
                }

            fetch(url, settings)
                        .then(response => response.json())
                        .then(data => {
                        console.log(data);

                        })
                        .catch(error => {
                        console.log(error);
                            });

            
}


