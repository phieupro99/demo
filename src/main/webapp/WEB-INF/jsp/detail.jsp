<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product Detail</title>
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500" rel="stylesheet">
    <!-- CSS -->
    <link href="css/detail.css" rel="stylesheet">
    <meta name="robots" content="noindex,follow" />
	<link rel="stylesheet" type="text/css" href="slick/slick.css"/>
<link rel="stylesheet" type="text/css" href="slick/slick-theme.css"/>
  </head>

  <body>
    <main class="container">

      <!-- Left Column / Headphones Image -->
      <div class="left-column ">
		
        <img data-image="red" class="active" src="image/${product.image}" alt="">
        <div class="autoplay">
        <c:forEach items="${product.images}" var="img" varStatus="imgStatus">
        	<img src="image/${img}" alt="">
         </c:forEach>
        
        </div>
         
        </div>
     


      <!-- Right Column -->
      <div class="right-column">

        <!-- Product Description -->
        <div class="product-description">
          <span>Iphone</span>
          <h1>Iphones </h1>
          <p>${product.description}</p>
        </div>

        <!-- Product Configuration -->
        <div class="product-configuration">

          <!-- Product Color -->
          <div class="product-color">
            <span>Color</span>

            <div class="color-choose">
              <div>
                <input data-image="red" type="radio" id="red" name="color" value="red" checked>
                <label for="red"><span></span></label>
              </div>
              <div>
                <input data-image="blue" type="radio" id="blue" name="color" value="blue">
                <label for="blue"><span></span></label>
              </div>
              <div>
                <input data-image="black" type="radio" id="black" name="color" value="black">
                <label for="black"><span></span></label>
              </div>
            </div>

          </div>

          <!-- Cable Configuration -->
          <div class="cable-config">
            <span>Cable configuration</span>

            <div class="cable-choose">
              <button>Straight</button>
              <button>Coiled</button>
              <button>Long-coiled</button>
            </div>

            <a href="#">How to configurate your headphones</a>
          </div>
        </div>

        <!-- Product Pricing -->
        <div class="product-price">
          <span>${product.price}$</span>
          <a href="cart/addCart?product=${product.id}" class="cart-btn" id="addit">Add to cart</a>
        </div>
      </div>
    </main>

    <!-- Scripts -->
    <script src="javascript/jquery-3.3.1.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="slick/slick.min.js"></script>
    <script src="javascript/detail.js" charset="utf-8"></script>]
    
     <script type="text/javascript">
    $(document).ready(function(){
    	$('.autoplay').slick({
    		  slidesToShow: 3,
    		  slidesToScroll: 1,
    		  autoplay: true,
    		  autoplaySpeed: 2000,
    		});
    });
  </script>
  </body>
</html>
