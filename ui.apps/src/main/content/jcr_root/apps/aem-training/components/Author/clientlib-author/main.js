$(window).on('load',function (){
    let resourcePath = document.getElementsByClassName("dialog-data")[0].getAttribute('data-path')
    let dataUrl = "/bin/public/aem/training/get/sample?resource="+resourcePath.toString()
    $.ajax({
        method:'get',
        url: dataUrl, //query params
        headers:{
            'Accept': 'application/json',
            'Content-type':'application/json'
        },
        success: (response) =>{
            console.log(response,"*******")
            let resourcePath = document.querySelector(".dialog-data");
            let jsonContainer = document.createElement("pre");
            jsonContainer.textContent = JSON.stringify(response, null, 2); // The third argument (2) adds indentation for better readability
            resourcePath.appendChild(jsonContainer);

        },

        error:error => console.log(error)
    })
})