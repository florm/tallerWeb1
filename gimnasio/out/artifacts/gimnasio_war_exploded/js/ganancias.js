var txtPeriodo = $("#txtPeriodo");
var selSucursal = $("#selSucursal");
var btnBuscar =$("#btnBuscar");
var periodoFormat = $("#periodoFormat");


$('#txtPeriodo').MonthPicker({
    Button: false,
	MonthFormat: 'M, yy', // Short month name, Full year.
    AltFormat: 'yy-mm-dd', // ODBC time stamp.
    AltField: '#periodoFormat' // Selector for hidden input.
});

btnBuscar.click(function(){
	var periodo = periodoFormat.val();
	var sucursal = selSucursal.val();
	window.location.href = "/gimnasio/ganancias?sucursal="+sucursal+"&periodo="+periodo;
	
	
}); 