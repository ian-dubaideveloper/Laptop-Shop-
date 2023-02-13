// JavaScript Document
// Default URL - FindAll
var rootUrl = "http://localhost:8090/laptopshop/rest/inventory";
var currentLaptop;
// Load these when the page is fully loaded
$(document).ready(function() {
	findAll();
	// Event handler for when we click on a Laptop Name in the List that was
	// populated from FindAll
	$(document).on("click", "#laptopList a", function() {
		findById(this.id);
	});
	// add event handler to the "New Wine" Button
	$('#btnAdd').click(function() {
		newLaptop();
		return false;
	});
	// Save button event handler
	$('#btnSave').click(function() {
		if ($('#id').val() == '')
			addLaptop();
		else
			updateLaptop();
		return false;
	});
	// hide delete button until a wine is clicked on
	// Nothing to delete in initial application state
	$('#btnDelete').hide();
	$('#btnReset').hide();
	// delete button event handler
	$('#btnDelete').click(function() {
		deleteLaptop();
		return false;
	});
	$('#btnReset').click(function() {
		findAll();
		return false;
	});
	// adds an event listener to the Search button:
	// Register listeners
	$('#btnSearch').click(function() {
		search($('#searchKey').val());
		return false;
	});
	// Add a trigger to the search by pressing enter key
	// Trigger search when pressing 'Return' on search key input field
	$('#searchKey').keypress(function(e) {
		if (e.which == 13) {
			search($('#searchKey').val());
			e.preventDefault();
			return false;
		}
	});
	// Replace broken images with generic laptop image
	$("img").error(function() {
		$(this).attr("src", "images/Generic_Laptop.jpg");
	});
});

// if Search key is empty use findAll() else findByName()
var search = function(searchKey) {
	if (searchKey == '')
		findAll();
	else
		findByName(searchKey);
	$('#btnReset').show();
};

// Read all laptops
var findAll = function() {
	$('#btnReset').hide();
	$('#laptopList').empty();
	$.ajax({
		type : 'GET',
		url : rootUrl,
		dataType : "json",
		success : renderList,
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('findAll error: ' + textStatus);
		}
	});
};

// Read a Laptop by id
var findById = function(id) {
	$.ajax({
		type : 'GET',
		url : rootUrl + '/' + id,
		dataType : "json",
		success : function(data) {
			$('#btnDelete').show();
			console.log('findById success: ' + data.lapName);
			currentLaptop = data;
			renderListID(currentLaptop);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('findById error: ' + textStatus);
		}
	});
};

// Read a Laptop by Name:
var findByName = function(searchKey) {
	$('#laptopList').empty();
	console.log('...findByName: ' + searchKey);
	$.ajax({
		type : 'GET',
		url : rootUrl + '/name/' + searchKey,
		dataType : "json",
		success : renderList,
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('search: ' + textStatus);
		}
	});
};

// Display the Laptops in a list
var renderList = function(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an
	// object (not an 'array of one')
	var list = data == null ? [] : (data instanceof Array ? data : [ data ]);

	$.each(data, function(index, laptop) {
		$('#laptopList').append(
				'<li><a href="#" id="' + laptop.id + '">' + laptop.lapName
						+ '</a></li>');
	});
};

// Display the details in the middle panel
var renderListID = function(laptop) {
	$('#id').val(laptop.id);
	$('#lapName').val(laptop.lapName);
	$('#brand').val(laptop.brand);
	$('#display').val(laptop.display);
	$('#processor').val(laptop.processor);
	$('#lapMem').val(laptop.lapMem);
	$('#harddrive').val(laptop.harddrive);
	$('#graphics').val(laptop.graphics);
	$('#numUsb').val(laptop.numUsb);
	$('#pic').attr('src', 'images/laptops/' + laptop.picture);
	$('#price').val(laptop.price);

};
// Clear the Laptop fields in middle section
var newLaptop = function() {
	$('#id').val('');
	$('#lapName').val('');
	$('#brand').val('');
	$('#display').val('');
	$('#processor').val('');
	$('#lapMem').val('');
	$('#harddrive').val('');
	$('#graphics').val('');
	$('#numUsb').val('');
	$('#pic').attr('src', '');
	$('#price').val('');
};

// Create a Laptop
var addLaptop = function() {
	console.log('addLaptop()');
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : rootUrl,
		data : formToJSON(),
		success : function(data, textStatus, jqXHR) {
			console.log('Laptop CREATED successfully');
			$('#btnDelete').show();
			$('#id').val(data.id);
			findAll();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('addLaptop() error: ' + textStatus);
		}
	});
};

// Update a Wine
var updateLaptop = function() {
	console.log('...update a Laptop...');
	$.ajax({
		type : 'PUT',
		contentType : 'application/json',
		url : rootUrl + '/' + $('#id').val(),
		dataType : "json",
		data : formToJSON(),
		success : function(data, textStatus, jqXHR) {
			findAll();
			console.log('Laptop UPDATED successfully');
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('updateLaptop() error: ' + textStatus);
		}
	});
};

// Delete a wine
var deleteLaptop = function() {
	console.log('delete wine...');
	$.ajax({
		type : 'DELETE',
		url : rootUrl + '/' + $('#id').val(),
		success : function(data, textStatus, jqXHR) {
			console.log('Laptop DELETED successfully');
			// newWine();
			// findAll();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('deleteLaptop() error....')
		}
	});
};

// Helper Function to serialize all the form fields into a JSON String
var formToJSON = function() {
	var id = $('#id').val();
	return JSON.stringify({
		"id" : $('#id').val(),
		"lapName" : $('#lapName').val(),
		"brand" : $('#brand').val(),
		"display" : $('#display').val(),
		"processor" : $('#processor').val(),
		"lapMem" : $('#lapMem').val(),
		"harddrive" : $('#harddrive').val(),
		"graphics" : $('#graphics').val(),
		"numUsb" : $('#numUsb').val(),
		"picture" : "",
		"price" : $('#price').val(),

	});
};
