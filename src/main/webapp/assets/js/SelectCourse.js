let selectCourses = document.getElementById("selectCourses");
selectCourses.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (selectCourses.checkValidity() === true) {
        //document.getElementById("update_profile").style.display = "none";
        //document.getElementById("spinner-button").style.display = "block";
        console.log("Select Courses")
        //let list = document.querySelector('.messageCheckbox');
        let arr_courseid = new Array();
        let checkedValue = null;
        let inputElements = document.getElementsByClassName('messageCheckbox');
        for(let i=0; inputElements[i]; ++i){
            if(inputElements[i].checked){
                checkedValue = inputElements[i].value;
                let temp = parseInt(checkedValue);
                arr_courseid.push(temp);
            }
        }
        console.log(arr_courseid);
        //console.log(list);
        let response = await fetch('api/courses/selectCourses', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                emp_id: sessionStorage.getItem('id'),arrayList: arr_courseid,
            })
        });
        let result = await response.json();
        try{

            //document.getElementById("update_profile").style.display = "block";
            //document.getElementById("spinner-button").style.display = "none";
            console.log(result);
            console.log("Courses Selected Successfully");
            window.alert("Courses Selected Successfully, click ok to continue");
            location.href = "dash.html";
        }catch (err){
            window.alert("Courses not Selected Successfully, click ok to continue");
            console.log(result);
            //document.getElementById("update_profile").style.display = "block";
            //document.getElementById("spinner-button").style.display = "none";
        }
    }
});