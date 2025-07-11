/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

$(function buscar() {
    document.getElementById("lupa").onclick = function () {

        var tabla = document.getElementById('tablaActividades');
        var searchText = document.getElementById('buscar').value;
        var cellsOfRow = "";
        var found = false;
        var compareWith = "";

        // Recorremos todas las filas con contenido de la tabla
        for (var i = 1; i < tabla.rows.length; i++) {
            cellsOfRow = tabla.rows[i].getElementsByTagName('td');
            found = false;
            // Recorremos todas las celdas
            for (var j = 0; j < cellsOfRow.length && !found; j++) {
                compareWith = cellsOfRow[j].innerHTML.toLowerCase();
                // Buscamos el texto en el contenido de la celda
                if (searchText.length === 0 || (compareWith.indexOf(searchText) > -1)) {
                    found = true;
                }
            }//Fin del for interno
            if (found) {
                tabla.rows[i].style.display = '';
            } else {
                // si no ha encontrado ninguna coincidencia, esconde la
                // fila de la tabla
                tabla.rows[i].style.display = 'none';
            }//Fin del else
        }//Fin del for principal

    };
});
