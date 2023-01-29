$(document).ready(function () {
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
                        <a href="#" class="icon_modifier"></a>
                        <a href="/student/supprimerEtudiant?id=${row.numEtudiant}" class="icon_supprimer"></a>
                    </div>`
                },
                visible: true,
                orderable: false,
                searchable: false
            },
            {
                data: 'students.nomEtudiant',
                searchable: true,
                visible: true
            },
            {
                data: 'students.prenomEtudiant',
                searchable: true,
                visible: false
            },
            {
                data: 'students.anneeObtention',
                searchable: true,
                visible: false
            },
            {
                data: 'students.numClasse',
                searchable: true,
                visible: false
            },
            {
                data: 'students.enActivite',
                searchable: true,
                visible: false
            },
            {
                data: null, //Entreprise
                visible: true
            },
            {
                data: null, //profs
                visible: true
            }
        ]
    })
})