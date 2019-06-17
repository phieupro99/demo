getData();
function getData(){
	$.ajax({
		  method: "GET",
		  url: "cart/get"
		}).done(function( object ) {
			var data= JSON.parse(object);
			for(var i =0; i<data.length;i++){
				var prodData = data[i];
				var dataProductHtml = "<div class='item' >"+
				"<div class='buttons'> <a href = 'cart/removeCart?product="+prodData.id+ "'"+ 
				"<span class='delete-btn'></span></a></div>"+
        "<div class='image'><img style='width:100px;' src='image/"+prodData.image+"'/>"+
        "</div><div class='description'>"+
          "<span>"+prodData.title+"</span></div><div class='quantity'>"+
          "<button class='plus-btn' type='button' name='button'>"+
           "<img src='shoppingcart/plus.svg' /></button><input type='text' class='quatity' value='1' price='"+prodData.price+"'>"+
          "<button class='minus-btn' type='button' name='button'>"+
            "<img src='shoppingcart/minus.svg' /></button></div>"+
            "<div class='total-price'>"+prodData.price+"$</div></div>";
				$("#cart-render").append(dataProductHtml);
				$( ".quatity" ).change(function() {
					var items = $( "#cart-render .item" );
					var sum = 0;
					for(var i = 0;i<items.length;i++){
						var item = $(items[i]).find('.quatity')
						sum += $(item).val()*$(item).attr('price');
					}
					$('#total').text(sum)
				});
			}
			
			 $('.minus-btn').on('click', function(e) {
		    		e.preventDefault();
		    		var $this = $(this);
		    		var $input = $this.closest('div').find('input');
		    		var value = parseInt($input.val());

		    		if (value > 1) {
		    			value = value - 1;
		    		} else {
		    			value = 0;
		    		}

		        $input.val(value);$input.change();

		    	});
			
		    	$('.plus-btn').on('click', function(e) {
		    		e.preventDefault();
		    		var $this = $(this);
		    		var $input = $this.closest('div').find('input');
		    		var value = parseInt($input.val());

		    		if (value < 100) {
		      		value = value + 1;
		    		} else {
		    			value =100;
		    		}

		    		$input.val(value);
		    		$input.change();
		    	});

		      $('.like-btn').on('click', function() {
		        $(this).toggleClass('is-active');
		      });
	});
};