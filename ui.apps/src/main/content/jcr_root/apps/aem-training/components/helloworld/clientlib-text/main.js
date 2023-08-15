$(window).on('load',function (){
    $.ajax({
        method:'get',
        url: '/bin/public/aem/training/list/get/sample',
        headers:{
            'Accept': 'application/json',
            'Content-type':'application/json'
        },
        success: (response) =>{
            console.log(response)
            var dataApiDiv = $(".data-api");
            for (let i = 0; i < response.length; i++) {
                const name = $("<p>").text(response[i].name);
                const age = $("<p>").text(response[i].age);
                dataApiDiv.append(name);
                dataApiDiv.append(age);
            }
        },

        error:error => console.log(error)
    })
})
