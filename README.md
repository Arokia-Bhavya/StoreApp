# StoreApp
- UserMangementSystem
  * POST /store-app/users/create
  * PUT /store-app/users/update
  * GET /store-app/users/{userId}
  * DELETE /store-app/users/{userId}
- CartMangementSystem
  * POST /store-app/cart/create
  * GET /store-app/cart/{cartId}
  * PUT /store-app/cart/update
  * DELETE /store-app/cart/{cartId}
  * POST /store-app/cartItem/create
  * GET /store-app/cartItem/{cartItemId}
  * DELETE /store-app/cartItem/{cartItemId}
  * PUT /store-app/cartItem/update
- ProductManagementSystem
  * POST /store-app/product/create
  * PUT /store-app/product/update
  * GET /store-app/product/{productId}
  * GET /store-app/product/all
  * DELETE /store-app/users/{productId}
- OrderManagementSystem
  * POST /store-app/order/create
  * POST /store-app/order/create/{cartId}
  * GET /store-app/order/{orderId}
  * PUT /store-app/order/update
  * DELETE /store-app/order/{orderId}
  * POST /store-app/orderItem/create
  * GET /store-app/orderItem/{orderItemId}
  * DELETE /store-app/orderItem/{orderItemId}
  * PUT /store-app/orderItem/update
