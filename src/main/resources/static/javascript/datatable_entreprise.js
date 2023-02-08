$(document).ready(function () {
    $('#companies_table').DataTable({
        language: {
            "url": "https://cdn.datatables.net/plug-ins/1.13.1/i18n/fr-FR.json",
            "search": "Recherche rapide :",
        },
        ajax: '/entreprise/data',
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
                            <a class="icon_voir" href="/entreprise/voirEntreprise?id=${row.numEntreprise}"></a>&nbsp;
                            <a class="icon_inscrire" href="/inscription?companyName=${row.raisonSociale}"></a>&nbsp;
                            <a class="icon_modifier" href="/entreprise/modifierEntreprise?id=${row.numEntreprise}"></a>&nbsp;
                            <a class="icon_supprimer" href="/entreprise/supprimerEntreprise?id=${row.numEntreprise}"></a>&nbsp;
                       </div>`
                },
                visible: true,
                orderable: false,
                searchable: false
            },
            {
                data: 'raisonSociale',
                visible: true
            },
            {
                data: 'nomContact',
                visible: false
            },
            {
                data: 'nomResp',
                visible: true
            },
            {
                data: null,
                render: function (data, type, row) {
                    if (type === 'display') {
                        return `${row.rueEntreprise}<br/>${row.cpEntreprise} ${row.villeEntreprise}`
                    }
                    return row.cpEntreprise
                },
                visible: true
            },
            {
                data: 'telEntreprise',
                render: function (data, type, row) {
                    return row.telEntreprise.replace(/ /g, "&nbsp")
                },
                orderable: false,
                visible: false
            },
            {
                data: 'faxEntreprise',
                render: function (data, type, row) {
                    return row.faxEntreprise.replace(/ /g, "&nbsp")
                },
                orderable: false,
                visible: false
            },
            {
                data: 'email',
                orderable: false,
                visible: false
            },
            {
                data: 'observation',
                visible: false
            },
            {
                data: null,
                render: function (data, type, row) {
                    if (row.siteEntreprise === null || row.siteEntreprise === '') {
                        return '';
                    }
                    return `<div class="bouton_operation"><a class="icon_website" href="${row.siteEntreprise}"></a></div>`
                },
                orderable: false,
                searchable: false,
                visible: true
            },
            {
                data: 'niveau',
                visible: false,
                searchable: true
            }, {
                data: 'specialites',
                render: function (data, type, row) {
                    return data.map(specialite => specialite.libelle).join('<br/>');
                },
                orderable: false,
                searchable: true,
                visible: true
            },
            {
                data: 'enActivite',
                render: function (data, type, row) {
                    return row.enActivite ? 'Oui' : 'Non';
                },
                searchable: false,
                visible: false
            }
        ]
    });
});