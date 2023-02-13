var rootUrl = "http://localhost:8090/laptopshop/rest/inventory";

$(document).ready(function() {
//	$('#laptopTable').DataTable();
	findAll();
	 /* Get iframe src attribute value i.e. YouTube video url
    and store it in a variable */
	 var url = $("#top52016").attr('src');
	    
	    /* Assign empty url value to the iframe src attribute when
	    modal hide, which stop the video playing */
	    $("#vidModal").on('hide.bs.modal', function(){
	        $("#top52016").attr('src', '');
	    });
	    
	    /* Assign the initially stored url back to the iframe src
	    attribute when modal is displayed again */
	    $("#vidModal").on('show.bs.modal', function(){
	        $("#top52016").attr('src', url);
	    });
});

// Read all laptops
var findAll = function() {
	
	$.ajax({
		type : 'GET',
		url : rootUrl,
		dataType : "json",
		 success: function (data) {
		        $('#laptopTable').dataTable({
		        	data: data,
		            paging: true,
		            sort: true,
		            searching: true,
		            scrollY: 200,
		            columns: [
		                { 'data': 'id' },
		                { 'data': 'lapName' },
		                { 'data': 'brand' },
		                { 'data': 'processor' },
		                { 'data': 'lapMem' },
		                { 'data': 'harddrive' },
		                
		                ],
		        });
		    }
	});
};
// Image Modals
$('.thumbnail').click(function(){
  	$('.modal-body').empty();
  	var title = $(this).parent('a').attr("title");
  	$('.modal-title').html(title);
  	$($(this).parents('div').html()).appendTo('.modal-body');
  	$('#myModal').modal({show:true});
});