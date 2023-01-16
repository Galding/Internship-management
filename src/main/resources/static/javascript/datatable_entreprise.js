$(document).ready( function () {
    $('#companies_table').DataTable({
        language: {
            "url": "https://cdn.datatables.net/plug-ins/1.13.1/i18n/fr-FR.json",
            "search": "Recherche rapide :",
        },
        ajax : '/entreprise/data',
        serverSide: false,
        scrollX: true,
        dom: 'Bfrtip',
        buttons : [
            'colvis'
        ],
        order: [1, 'asc'],
        columns : [
            {
                data: 'raisonSociale'
            },
            {
                data: 'nomContact',
                visible: false
            },
            {
                data: 'nomResp'
            },
            {
                data: null,
                render: function (data, type, row){
                    if(type === 'display'){
                        return `${row.rueEntreprise}<br/>${row.cpEntreprise} ${row.villeEntreprise}`
                    }
                    return row.cpEntreprise
                }
            },
            {
                data: 'telEntreprise',
                orderable: false,
                visible: false
            },
            {
                data: 'faxEntreprise',
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
                    return `
                    <div class="field">
                        <p class="control">
                            <a class="button" href="${row.siteEntreprise}">
                                <span class="icon is-small">
                                    <i class="fa fa-link"></i>
                                </span>
                            </a>
                        </p>
                    </div>
                    `
                },
                orderable: false,
                searchable: false,
            },
            {
                data: 'niveau',
                visible: false
            }, {
                data: 'specialites',
                render: function (data, type, row) {
                    return data.map(specialite => specialite.libelle).join('<br/>');
                },
                orderable: false,
                searchable: false
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
} );