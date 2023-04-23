function fetchProducts() {
    fetch('localhost:8080/product/getAllProduct')
      .then(response => response.json())
      .then(data => {
        const productList = document.getElementById('product-list');
        data.forEach(product => {
          const productElement = document.createElement('div');
          productElement.innerHTML = `<h2>${product.name} - ${product.price}</h2>`;
          productList.appendChild(productElement);
        });
      })
      .catch(error => console.error(error));
}
window.onload = fetchProducts;

  