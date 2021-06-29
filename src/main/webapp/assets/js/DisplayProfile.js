
window.onload = fetchempdetails;

/*update_profile.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (update_profile.checkValidity() === true) {
        //document.getElementById("update_profile").style.display = "none";
        //document.getElementById("spinner-button").style.display = "block";

        let response = await fetch('api/employee/Profile', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                employee_id: sessionStorage.getItem('id'),
                email: document.getElementById('email').value,
                password: document.getElementById('password').value,
                first_name: document.getElementById('firstName').value,
                last_name: document.getElementById('lastName').value,
                title: document.getElementById('title').value,
            })
        });

        try{
            let result = await response.json();
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
});*/


async function fetchempdetails() {
    console.log("fetch_emp_details");
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
    console.log(employee['photograph_path']);
    document.getElementById("firstName").innerHTML = employee['first_name'] + " " +employee['last_name'];
    //document.getElementById("lastName").innerHTML = employee['last_name'];
    document.getElementById("email").innerHTML = employee['email'];
    //document.getElementById("password").value = employee['password'];
    document.getElementById("title").innerHTML = employee['title'];
    document.getElementById("fac_title").innerHTML = employee['title'];
    document.getElementById("fac_name").innerHTML = employee['first_name'] + " " + employee['last_name'];
    console.log("*************")
    console.log(employee['department'])
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

    let response1 = await fetch('api/employees/fetchDepartment',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            employee_id: sessionStorage.getItem('id')
        })
    });
    console.log("Response Received for Department");
    console.log(response1);
    try {
        let department = await response1.json();
        console.log(department["name"]);
        document.getElementById("dept").innerHTML = department["name"];
    }catch(err){
        console.log(err)
    }
}
catch(err){
    console.log(err)
    }
}