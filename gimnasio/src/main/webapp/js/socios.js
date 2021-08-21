var socios = $('#socios').DataTable( {
        lengthChange: true,
        // scrollY: 400,
        scrollCollapse: true,
        paging: true,
        order: [[ 0, "asc" ]],
        pagingType: "full_numbers",
        pageLength: 5,
        lengthMenu: [[2,5, 10, 25, 50, -1], [2,5, 10, 25, 50, "Todos"]], //primer array values, segundo array valores que se muestran en el select
        "language": {
                "lengthMenu": "Mostrar _MENU_ resultados por página",
                "zeroRecords": "No se han encontrado registros",
                "info": "Página _PAGE_ de _PAGES_",
                "infoEmpty": "No se han encontrado registros",
                "infoFiltered": "(filtrado de _MAX_ registros totales)",
                "search": "Buscar:",
                "paginate": {
                        "previous": '<span class="pagination-default"></span><span class="pagination-fa"><i class="fa fa-chevron-left" ></i></span>',
                        "next": '<span class="pagination-default"></span><span class="pagination-fa"><i class="fa fa-chevron-right" ></i></span>',
                        "first": '<span class="pagination-default"></span><span class="pagination-fa"><i class="fa fa-chevron-left" ></i><i class="fa fa-chevron-left" ></i></i></span>',
                        "last": '<span class="pagination-default"></span><span class="pagination-fa"><i class="fa fa-chevron-right" ></i><i class="fa fa-chevron-right" ></i></span>'
                }
        }
    } );

