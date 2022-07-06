// Call the dataTables jQuery plugin
$(document).ready(function() {
});

async function UserRegister() {

    const request = await fetch('/dentists', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });
    const dentists = await request.json();
    }