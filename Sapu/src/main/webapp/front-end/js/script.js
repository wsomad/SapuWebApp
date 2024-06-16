const header = document.querySelector('header');
const menuButton = document.querySelector('#menu-button');
const closeMenuButton = document.querySelector('#close-menu-button');

menuButton.addEventListener('click', function() {
    header.classList.toggle('show-mobile-menu');
})

closeMenuButton.addEventListener('click', function() {
    menuButton.click();
});