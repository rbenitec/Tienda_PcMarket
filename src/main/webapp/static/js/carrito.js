// CARRITO
let cartIcon = document.querySelector('#cart-icon');
let cart = document.querySelector('.cart');
let closeCart = document.querySelector('#close_cart');
let tienda = document.querySelector('#tienda');

// Abrir carrito
cartIcon.addEventListener('click', () => {
  cart.classList.add("active");
  tienda.classList.add("izquierda");
});

// Cerrar carrito
closeCart.addEventListener('click', () => {
  cart.classList.remove("active");
  tienda.classList.remove("izquierda");
});
