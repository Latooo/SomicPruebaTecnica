const apiUrl = 'http://localhost:8080';
let articulos = {};
let clienteActual = null;

function cambiarNaturaleza() {
    const naturaleza = document.getElementById('naturaleza').value;
    const precioGroup = document.getElementById('precioVentaGroup');
    const precioInput = document.getElementById('precioVenta');
    const costoInput = document.getElementById('costo');

    if (naturaleza === '-') {
        precioGroup.style.display = 'flex';
        precioInput.disabled = false;
        costoInput.disabled = true;
    } else {
        precioGroup.style.display = 'none';
        precioInput.value = 0;
        precioInput.disabled = true;
        costoInput.disabled = false;
    }
}

async function buscarNit() {
    const nit = document.getElementById('nitBuscar').value;
    try {
        const response = await fetch(`${apiUrl}/nits/${nit}`);
        if (!response.ok) throw new Error("NIT no encontrado");
        const data = await response.json();
        clienteActual = data;
        document.getElementById('nitNombre').value = data.nitNom;
        document.getElementById('nitCupo').value = data.nitCup;
        document.getElementById('nitPlazo').value = data.nitPla;
        document.getElementById('nitDisponible').value = data.nitCup;
    } catch (error) {
        alert(error.message);
    }
}

async function buscarArticulo() {
    const cod = document.getElementById('artBuscar').value;
    try {
        const response = await fetch(`${apiUrl}/articulos/${cod}`);
        if (!response.ok) throw new Error("Artículo no encontrado");
        const art = await response.json();
        articulos[cod] = art;
        document.getElementById('artNombre').value = art.artNom;
        document.getElementById('artLab').value = art.artLab;
        document.getElementById('artSaldo').value = art.artSal;
        document.getElementById('costo').value = art.artCos;
        document.getElementById('precioVenta').value = art.artPre;
    } catch (error) {
        alert(error.message);
    }
}

function limpiarCamposArticulo() {
    document.getElementById('artBuscar').value = '';
    document.getElementById('artNombre').value = '';
    document.getElementById('artLab').value = '';
    document.getElementById('artSaldo').value = '';
    document.getElementById('unidades').value = '';
    document.getElementById('costo').value = '';
    document.getElementById('precioVenta').value = '';
}

function actualizarTotales() {
    const filas = document.querySelectorAll('#tablaRejilla tbody tr');
    let totalCosto = 0;
    let totalVenta = 0;

    filas.forEach(fila => {
        const celdas = fila.getElementsByTagName('td');
        totalCosto += parseFloat(celdas[7].innerText);
        totalVenta += parseFloat(celdas[8].innerText);
    });

    document.getElementById('totalCosto').innerText = totalCosto.toFixed(2);
    document.getElementById('totalVenta').innerText = totalVenta.toFixed(2);
}

function agregarRejilla() {
    const cod = document.getElementById('artBuscar').value;
    const art = articulos[cod];
    if (!art) {
        alert("Debes buscar un artículo válido.");
        return;
    }

    const nat = document.getElementById('naturaleza').value;
    const unidades = parseInt(document.getElementById('unidades').value);
    const costo = parseFloat(document.getElementById('costo').value);
    let precio = parseFloat(document.getElementById('precioVenta').value) || 0;

    if (isNaN(unidades) || unidades <= 0 || isNaN(costo)) {
        alert("Unidades y costo deben ser válidos.");
        return;
    }

    if (nat === '-' && (isNaN(precio) || precio < costo)) {
        alert("El precio de venta no puede ser menor al costo.");
        return;
    }

    const totalVenta = precio * unidades;
    const totalCosto = costo * unidades;

    const tabla = document.getElementById('tablaRejilla').getElementsByTagName('tbody')[0];
    const fila = tabla.insertRow();

    fila.innerHTML = `
        <td>${cod}</td>
        <td>${art.artNom}</td>
        <td>${art.artLab}</td>
        <td>${nat}</td>
        <td>${unidades}</td>
        <td>${costo.toFixed(2)}</td>
        <td>${precio.toFixed(2)}</td>
        <td>${totalCosto.toFixed(2)}</td>
        <td>${totalVenta.toFixed(2)}</td>
        <td><button type="button" onclick="eliminarFila(this)">X</button></td>
    `;

    actualizarTotales();
    limpiarCamposArticulo();
}

function eliminarFila(btn) {
    const fila = btn.parentNode.parentNode;
    fila.parentNode.removeChild(fila);
    actualizarTotales();
}

function guardarLocalmente(factura) {
    let facturas = JSON.parse(localStorage.getItem('facturas')) || [];
    facturas.push(factura);
    localStorage.setItem('facturas', JSON.stringify(facturas));
}

async function guardarFactura() {
    const facNum = document.getElementById('facNum').value.trim();
    const facFec = document.getElementById('facFec').value;
    const facVen = document.getElementById('facVen').value;

    if (!facNum || !facFec || !facVen) {
        alert("Debes completar el número de factura, la fecha y la fecha de vencimiento.");
        return;
    }

    if (!clienteActual) {
        alert("Debes seleccionar un cliente válido.");
        return;
    }

    const filas = document.getElementById('tablaRejilla').getElementsByTagName('tbody')[0].getElementsByTagName('tr');
    if (filas.length === 0) {
        alert("Debes agregar al menos un artículo.");
        return;
    }

    let detalles = Array.from(filas).map(fila => {
        const celdas = fila.getElementsByTagName('td');
        return {
            fakArt: parseInt(celdas[0].innerText),
            fakNom: celdas[1].innerText, // ✅ nombre del artículo
            fakNat: celdas[3].innerText,
            fakUni: parseInt(celdas[4].innerText),
            fakCos: parseFloat(celdas[5].innerText),
            fakPre: parseFloat(celdas[6].innerText),
            fakTotCos: parseFloat(celdas[7].innerText),
            fakTotVen: parseFloat(celdas[8].innerText)
        };
    });
    

    const facturaDTO = {
        facNum,
        facFec,
        facVen,
        facNit: clienteActual.nitId,
        cliente: clienteActual.nitNom,
        detalles
    };

    guardarLocalmente(facturaDTO);
    mostrarFacturasLocales();

    try {
        const response = await fetch(`${apiUrl}/factura`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(facturaDTO)
        });

        if (response.ok) {
            alert("Factura guardada con éxito.");
        } else {
            const error = await response.text();
            alert("Error al guardar en backend: " + error);
        }
    } catch (error) {
        console.error(error);
        alert("Factura guardada.");
    }

    document.getElementById('facturaForm').reset();
    document.getElementById('tablaRejilla').getElementsByTagName('tbody')[0].innerHTML = '';
    actualizarTotales();
}

function mostrarFacturasLocales() {
    const contenedor = document.getElementById('facturasGuardadas');
    const facturas = JSON.parse(localStorage.getItem('facturas')) || [];

    contenedor.innerHTML = `<h2>Facturas Guardadas</h2>`;

    if (facturas.length === 0) {
        contenedor.innerHTML += `<p>No hay facturas guardadas.</p>`;
        return;
    }

    facturas.forEach((f, index) => {
        let totalCosto = 0;
        let totalVenta = 0;

        const detallesHtml = f.detalles.map(d => {
            totalCosto += d.fakTotCos;
            totalVenta += d.fakTotVen;
            return `<li>${d.fakUni} x ${d.fakNom} (${d.fakNat})</li>`;
        }).join('');

        contenedor.innerHTML += `
            <div class="factura-local">
                <strong>#${f.facNum}</strong> - ${f.cliente} (${f.facFec})<br>
                <ul>${detallesHtml}</ul>
                <small>Total Costo: <strong>$${totalCosto.toFixed(2)}</strong> |
                Total Venta: <strong>$${totalVenta.toFixed(2)}</strong></small>
            </div>
            <hr>
        `;
    });
}


// Mostrar facturas locales al cargar
window.onload = mostrarFacturasLocales;
