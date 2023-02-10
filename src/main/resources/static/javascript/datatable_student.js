$(document).ready(function () {
    function isTeacher() {
        return document.getElementById("role").value === "teacher"
    }

    $('#student_table').DataTable({
        language: {
            "url": "https://cdn.datatables.net/plug-ins/1.13.1/i18n/fr-FR.json",
            "search": "Recherche rapide :",
        },
        ajax: '/student/data',
        serverSide: false,
        scrollX: true,
        dom: 'Bfrtip',
        buttons: [
            'colvis'
        ],
        order: [1, 'asc'],
        columns: [
            {
                data: null,
                render: function (data, type, row) {
                    console.log(data)
                    return `<div class="bouton_operation">
                        <a href="/student/voirEtudiant?id=${row.numEtudiant}" class="icon_voir"></a>
                    </div>`
                },
                visible: true,
                orderable: false,
                searchable: false
            },
            {
                data: null,
                render: function (data, type, row) {
                    return `<div class="bouton_operation">
                        <a href="/student/modifierEtudiant?id=${row.numEtudiant}" class="icon_modifier"></a>
                        <a href="/student/supprimerEtudiant?id=${row.numEtudiant}" class="icon_supprimer"></a>
                    </div>`
                },
                visible: isTeacher(),
                orderable: false,
                searchable: false
            },
            {
                data: 'student.nomEtudiant',
                searchable: true,
                visible: true
            },
            {
                data: 'student.prenomEtudiant',
                searchable: true,
                visible: false
            },
            {
                data: 'student.anneeObtention',
                searchable: true,
                visible: false
            },
            {
                data: 'student.numClasse',
                searchable: true,
                visible: false
            },
            {
                data: 'student.enActivite',
                searchable: true,
                visible: false
            },
            {
                data: 'companyName', //Entreprise
                visible: true
            },
            {
                data: 'professorName', //profs
                visible: true
            }
        ]
    })
})