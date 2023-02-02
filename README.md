# Foodie - an eCommerce website for a food store
This repo is the backend of the app. Click [here](https://github.com/qingqing0226/FoodStore-Frontend) to see the frontend.

### Structure & Design of the API
#### The API consists of 6 packages 
- cart
- item
- product
- order
- section
- user
#### Each package contains a full structure following MVC principle (adjusted a bit), and represents an entity/table in the database, it has:
- model
- controller
- service
- repository (also utilizes CrudRepository)

### endpoints
There are a few endpoints used by the client app and some used only for API development. To name a few:
- `/api/users` : POST request, create new user
- `/api/products` : GET request, return a list of products
- `/api/orders` : POST request, create new order


### Main Functionalities of the app
#### A cart

the user is able to add products to the cart  
view their products  
See the total price  
remove products  
cart is saved in local storage  

#### Multiple sections of products 

The home page displays a few sections that are dropdowns. As the user clicks on a section it will show a drop-down of the products. And the user can add these products to their cart

#### The products themselves have

name
price  
image  
current stock 

#### Checkout the cart  
When user is done they can click on pay, and products will be deducted from the database  
