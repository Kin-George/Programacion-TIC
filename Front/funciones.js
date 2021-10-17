// Seccion fincas
// Funcion para traer la informacion de la url
function traerInformacionFincas(){
    $.ajax({
        url:"http://localhost:8080/api/Farm/all",
        type:"GET",
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            pintarRespuestaFincas(respuesta.items)
        }
    });
}

// Funcion para estructurar en forma de tabla la informacion
function pintarRespuestaFincas(items){

    let myTable ="<table>";
    for(i=0;i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+items[i].id+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].address+"</td>";
        myTable+="<td>"+items[i].extension+"</td>";
        myTable+="<td>"+items[i].description+"</td>";
        myTable+="<td>"+items[i].category_id+"</td>";
        myTable+="<td> <button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado").append(myTable);
}

//Funcion para almacenar la informacion que se deposita en el formulario
function guardarInformacionFincas(){
    let myData={
        id:$("#id").val(),
        name:$("#name").val(),
        address:$("#address").val(),
        extension:$("#extension").val(),
        description:$("description").val(),
        category_id:$("#category_id").val(),
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://localhost:8080/api/Farm/save",
        type:"POST",
        data:myData,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            $("#id").val("");
            $("#name").val("");
            $("#address").val("");
            $("#extension").val("");
            $("#description").val("");
            $("#category_id").val("");
            traerInformacion();
            alert("se ha guardado el dato")
        }
    });
}

// Seccion categorias
// Funcion para traer la informacion de la url
function traerInformacionCategoria(){
    $.ajax({
        url:"http://localhost:8080/api/Category/all",
        type:"GET",
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            pintarRespuestaCategoria(respuesta.items)
        }
    });
}
// Funcion para estructurar en forma de tabla la informacion
function pintarRespuestaCategoria(items){

    let myTable2 ="<table>";
    for(i=0;i<items.length;i++){
        myTable2+="<tr>";
        myTable2+="<td>"+items[i].id+"</td>";
        myTable2+="<td>"+items[i].name+"</td>";
        myTable2+="<td>"+items[i].description+"</td>";
        myTable2+="</tr>";
    }
    myTable2+="</table>";
    $("#resultado2").append(myTable2);
}

//Funcion para almacenar la informacion que se deposita en el formulario
function guardarInformacionCategoria(){
    let myData2={
        id:$("#id2").val(),
        name:$("#name2").val(),
        description:$("description2").val(),
    };
    let dataToSend=JSON.stringify(myData2);
    $.ajax({
        url:"http://localhost:8080/api/Category/save",
        type:"POST",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado2").empty();
            $("#id2").val("");
            $("#name2").val("");
            $("#description2").val("");
            traerInformacionCategoria();
            alert("se ha guardado el dato")
        }
    });
}


