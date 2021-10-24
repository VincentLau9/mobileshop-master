<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Add Products</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../addproduct.css">
    </head>
    <body>
         <form action="Controller?url=ADDPRODUCT" method="POST" enctype="multipart/form-data">
        <div class="container">
            <div class="title">
                <h1>Create A New Product</h1>
            </div>
            <div class="input-container">
                <div class="input-box">
                    <label class="lable-ele">Product Name</label>
                    <input class="input" type="text" name="productname" required="true"/>
                </div>
                <div class="input-box">
                    <label class="lable-ele">Unit Price</label>
                    <input class="input" type="text" name="price" required="true"/>
                </div> 
                <div class="input-box">
                    <label class="lable-ele">Units In Stock</label>
                    <input class="input" type="text" name="quantity" required="true"/>
                </div> 
                <div class="input-box">
                    <label class="lable-ele">Description</label>
                    <textarea class="textarea" name="description" required="true"></textarea>
                </div> 
                <div class="input-box">
                    <label class="lable-ele">Manufacturer</label>
                    <input class="input" type="text" name="manufacturer" required="true"/>
                </div> 
                <div class="input-box">
                    <label class="lable-ele">Category</label>
                    <input class="input" type="text" name="categoryID" required="true"/>
                </div> 
                <div class="input-box">
                    <label class="lable-ele" required="true" >Condition</label>
                    <input class="radio-el" type="radio" name="condition" value="new"/>new
                    <input class="radio-el" type="radio" name="condition" value="old"/>old
                    <input class="radio-el" type="radio" name="condition" value="refurbished"/>refurbished
                </div>
                <div class="input-box">
                    <label class="lable-ele">Product Image File</label>
                    <input class="myfile" type="file" name="image" />
                </div> 
                <div class="input-box">
                <button class="btn" type="submit" name="action" value="CreateProduct">Add Product</button>
                </div>
            </div>
        </div>
    </div>
    </form>
</body>
</html>
