document.getElementById("articuloForm").addEventListener("submit", guardarArticulo);

let modoEdicion = false;
let indexEditando = null;

function guardarArticulo(e) {
    e.preventDefault();

    const articulo = {
        ArtCod: document.getElementById("artCod").value.trim(),
        ArtNom: document.getElementById("artNom").value.trim(),
        ArtLab: document.getElementById("artLab").value.trim(),
        ArtSal: parseInt(document.getElementById("artSal").value),
        ArtCos: parseFloat(document.getElementById("artCos").value),
        ArtPre: parseFloat(document.getElementById("artPre").value)
    };

    let articulos = JSON.parse(localStorage.getItem("articulos")) || [];

    if (modoEdicion && indexEditando !== null) {
        articulos[indexEditando] = articulo;
        modoEdicion = false;
        indexEditando = null;
    } else {
        articulos.push(articulo);
    }

    localStorage.setItem("articulos", JSON.stringify(articulos));
    limpiarFormulario();
    mostrarArticulos();
}

function mostrarArticulos() {
    const tabla = document.querySelector("#tablaArticulos tbody");
    tabla.innerHTML = "";

    const articulos = JSON.parse(localStorage.getItem("articulos")) || [];

    articulos.forEach((art, index) => {
        const fila = tabla.insertRow();

        fila.innerHTML = `
            <td>${art.ArtCod}</td>
            <td>${art.ArtNom}</td>
            <td>${art.ArtLab}</td>
            <td>${art.ArtSal}</td>
            <td>${art.ArtCos.toFixed(2)}</td>
            <td>${art.ArtPre.toFixed(2)}</td>
            <td>
                <button onclick="editarArticulo(${index})">Editar</button>
                <button onclick="eliminarArticulo(${index})">Eliminar</button>
            </td>
        `;
    });
}

function editarArticulo(index) {
    const articulos = JSON.parse(localStorage.getItem("articulos")) || [];
    const art = articulos[index];

    document.getElementById("artCod").value = art.ArtCod;
    document.getElementById("artNom").value = art.ArtNom;
    document.getElementById("artLab").value = art.ArtLab;
    document.getElementById("artSal").value = art.ArtSal;
    document.getElementById("artCos").value = art.ArtCos;
    document.getElementById("artPre").value = art.ArtPre;

    modoEdicion = true;
    indexEditando = index;
}

function eliminarArticulo(index) {
    let articulos = JSON.parse(localStorage.getItem("articulos")) || [];
    if (confirm("¿Estás seguro de eliminar este artículo?")) {
        articulos.splice(index, 1);
        localStorage.setItem("articulos", JSON.stringify(articulos));
        mostrarArticulos();
    }
}

function limpiarFormulario() {
    document.getElementById("articuloForm").reset();
    modoEdicion = false;
    indexEditando = null;
}

window.onload = mostrarArticulos;
