
if (document.readyState === "loading") {
    document.addEventListener("DOMContentLoaded", ready);
} else {
    reay();
}

function ready() {
    var removeCartButtons = document.getElementsByClassName('cart-remove');
    for (var i = 0; i < removeCartButtons.length; i++) {
        var button = removeCartButtons[i];
        button.addEventListener('click', removeCartItem);
    }
    var quantityInputs = document.getElementsByClassName('cantidad_producto');
    for (var i = 0; i < quantityInputs.length; i++) {
        var input = quantityInputs[i];
        input.addEventListener("change", quantityChanged);
    }
// Añadir al carro
    var addCart = document.getElementsByClassName('add-cart');
    for (var i = 0; i < addCart.length; i++) {
        var button = addCart[i];
        button.addEventListener('click', addCartClicked);
    }
    
    //Boton comprar ahora
    document.getElementsByClassName('btn-buy')[0].addEventListener("click",buyButtonClicked);
}

function buyButtonClicked(){
    alert('Tu orden se ha enviado');
    var cartContent = document.getElementsByClassName('contenido_Carrito')[0];
    while(cartContent.hasChildNodes()){
        cartContent.removeChild(cartContent.firstChild);
    }
    updateTotal();
}

//Cantidad cambia
function quantityChanged(event) {
    var input = event.target;
    if (isNaN(input.value) || input.value <= 0) {
        input.value = 1;
    }
    updateTotal();
}

//Eliminar del carrito
function removeCartItem(event) {
    var buttomClicked = event.target;
    buttomClicked.parentElement.remove();
    updateTotal();
}

//Añadir al carro
function addCartClicked(event) {
    var button = event.target;
    var shopProducts = button.parentElement;
    var title = shopProducts.getElementsByClassName('titulo_producto')[0].innerText;
    var price = shopProducts.getElementsByClassName('price')[0].innerText;
    var productImg = shopProducts.getElementsByClassName('imagen_producto')[0].src;
    console.log(price);
    addProductToCart(title, price, productImg);
    updateTotal();
}

function addProductToCart(title, price, productImg) {
        var cartShopBox = document.createElement('div');
        cartShopBox.classList.add('caja_carrito');
        var cartItems = document.getElementsByClassName('contenido_Carrito')[0];
        var cartItemsNames = cartItems.getElementsByClassName('titulo_prod_carrito');
        console.log(title,price,productImg);
        for (var i = 0; i < cartItemsNames.length; i++) {
            if(cartItemsNames[i].innerText === title){
                alert('Ya añadiste este item al carrito');
                return;
            }
        }

        var cartBoxContent = `
        <img src="${productImg}" alt="alt" class="imagen_carrito"/>
        <div class="caja_detalle">
        <div class="titulo_prod_carrito">${title}</div>
        <div class="carrito_precio">${price}</div>
        <input type="number" value="1" class="cantidad_producto">
        </div>
        <i class='bx bx-trash cart-remove'></i>
        
        `;
    
        cartShopBox.innerHTML = cartBoxContent;
        cartItems.append(cartShopBox);
        cartShopBox.getElementsByClassName('cart-remove')[0].addEventListener('click', removeCartItem);
        cartShopBox.getElementsByClassName('cantidad_producto')[0].addEventListener('change', quantityChanged);
}
//Actualizar total
        function updateTotal() {    
        var cartContent = document.getElementsByClassName('contenido_Carrito')[0];
                var cartBoxes = cartContent.getElementsByClassName('caja_carrito');
                var total = 0;
                for (var i = 0; i < cartBoxes.length; i++) {
                    var cartBox = cartBoxes[i];
                    var priceElement = cartBox.getElementsByClassName('carrito_precio')[0];
                    var quantityElement = cartBox.getElementsByClassName('cantidad_producto')[0];
                    var price = parseFloat(priceElement.innerText.replace("$", ""));
                    var quantity = quantityElement.value;
                
                total = total + (price * quantity);
                
                total = Math.round(total * 100) / 100;
                }
                document.getElementsByClassName('total_precio')[0].innerText = "$" + total;
        
        }