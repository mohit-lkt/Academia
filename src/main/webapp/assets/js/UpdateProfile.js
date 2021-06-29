let update_profile = document.getElementById("user_profile");
let imageUpload = document.getElementById("user_profile_image");
window.onload = fetchempdetails1;

imageUpload.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (imageUpload.checkValidity() === true) {
        document.getElementById("upload").style.display = "none";
        document.getElementById("spinner-button-upload").style.display = "block";

        let form_data = new FormData();
        form_data.append('file', document.getElementById('formFile').files[0]);
        form_data.append('employee_id', sessionStorage.getItem('id'));
        console.log(form_data);
        let response = await fetch('api/employees/uploadImage', {
            method: 'POST',
            body: form_data
        });
        try {
            let res = response.json();
            document.getElementById("upload").style.display = "block";
            document.getElementById("spinner-button-upload").style.display = "none";
            console.log(res);
            console.log("Update Successful");
            window.alert("Profile Updated Successfully click ok to continue");
            location.href = "dash.html";
        } catch (err) {
            console.log(err);
            document.getElementById("upload").style.display = "block";
            document.getElementById("spinner-button-upload").style.display = "none";
        }
    }
});

update_profile.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (update_profile.checkValidity() === true) {
        //document.getElementById("update_profile").style.display = "none";
        //document.getElementById("spinner-button").style.display = "block";
        console.log("update profile kaksh")
        let skillsSelect = document.getElementById("title");
        let selectedText = skillsSelect.options[skillsSelect.selectedIndex].text;
        let response = await fetch('api/employees/Profile', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                employee_id: sessionStorage.getItem('id'),
                email: document.getElementById('email').value,
                //password: document.getElementById('password').value,
                first_name: document.getElementById('firstName').value,
                last_name: document.getElementById('lastName').value,
                title: selectedText,
            })
        });
        let result = await response.json();
        try{

            //document.getElementById("update_profile").style.display = "block";
            //document.getElementById("spinner-button").style.display = "none";
            console.log(result);
            console.log("Update Successful");
            window.alert("Profile Updated Successfully click ok to continue");
            location.href = "dash.html";
        }catch (err){
            console.log(result);
            //document.getElementById("update_profile").style.display = "block";
            //document.getElementById("spinner-button").style.display = "none";
        }
    }
});
async function fetchempdetails1() {
    console.log("update_emp_details");
    if (!sessionStorage.getItem('id')) {
        location.href = "dash.html";
        return;
    }
    console.log("Sending Req");
    console.log(sessionStorage);
    let response = await fetch('api/employees/get_details',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            employee_id: sessionStorage.getItem('id')
        })
    });
    console.log("Response Received");
    console.log(response);
    try {
        let employee = await response.json(); // read response body and parse as JSON
        console.log(employee['title']);
        console.log(employee['first_name']);
        document.getElementById("firstName").value = employee['first_name'];
        document.getElementById("lastName").value = employee['last_name'];
        document.getElementById("email").value = employee['email'];
        //document.getElementById("password").value = employee['password'];
        document.getElementById("title").value = employee['title'];
        if(employee['photograph_path'] != null || employee['photograph_path'] != "null" )
        {
            let path = "api/employees/images/" + employee['photograph_path'];
            document.getElementById("fac_image").src = path;
            console.log("src path set");
        }
        else {
            document.getElementById("fac_image").src = 'assets/images/Avatar.jpg';
        }
        console.log(document.getElementById("fac_image").src);
    }
    catch(err){
        console.log(err)
    }
}