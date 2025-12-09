function cargarDoctores() {
    const fecha = document.getElementById("fecha").value;
    const hora  = document.getElementById("hora").value;

    if (fecha && hora) {
        fetch(`/admin/citas/doctores-disponibles?fecha=${fecha}&hora=${hora}`)
            .then(res => res.json())
            .then(doctores => {
                const select = document.getElementById("doctor");
                select.innerHTML = "";

                doctores.forEach(d => {
                    const opt = document.createElement("option");
                    opt.value = d.idDoctor;
                    opt.textContent = d.nombre;
                    select.appendChild(opt);
                });
            });
    }
}

document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("fecha").addEventListener("change", cargarDoctores);
    document.getElementById("hora").addEventListener("change", cargarDoctores);
});
