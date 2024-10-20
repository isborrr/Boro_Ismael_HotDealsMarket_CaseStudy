<h1># Boro_Ismael_HotDealsMarket_CaseStudy</h1>
<h2>A spring Boot marketplace application offering essential products to customers</h2>

<h3>Project Overview</h3>
This project is an E-commerce web application that allows users to browse, filter, and purchase products.
It supports user authentication, product management, shopping cart functionality, and administrative controls. 
The application provides different views for regular users and administrators, ensuring secure and role-based access to the system. 
The project is built with features for product management, user registration, and shopping history tracking.

<h3>Features</h3>
<h4>1. Home Page (Non-Registered User)</h4>
Returned Model: Displays a list of available products.
<ul>Category Filtration:</ul> Users can filter products based on categories. 
If the selected category does not have products, the message "We are out of stock" is shown.
<ul>Add-to-Cart:</ul> Displays an add-to-cart option for products.
<ul>Buy Now:</ul> When a user clicks "Buy Now", they are prompted to either:
<ul> Sign in</ul>
<!-- Proceed as a guest (without registering). -->
Sign In/Up: Links redirect to the appropriate pages for signing in or signing up.
<h4>2. Sign In Page</h4>
<ul>Error Handling:</ul> If the user enters an incorrect email or password, an error message is displayed.
<ul>User Authentication:</ul> 
Correct credentials will verify the user and redirect them to the user dashboard.
If the user is an admin, the admin dashboard will be displayed.
<ul>Sign Up Redirect:</ul>  Provides a link to navigate to the sign-up page if the user does not have an account.
<h4>3. Sign Up Page</h4>
<ul>Input Validation:</ul> Ensures that the user inputs are in the correct format.
If inputs are incorrect, an error message will be shown.
If inputs are correct, the user will be registered and redirected to the user dashboard.
<ul>Back to Home:</ul> A button is provided to return to the home page.
<h4>4. Shopping Cart</h4> (Visible Only to Logged-In Users)
<ul>Display Cart:</ul> The cart displays products added by the user:
	
<h4>5. Registered User Home Page</h4>
Returned Model: Displays a list of products.
Category Filtration: Users can filter products by category. If no products are available in a category, an "Out of stock" message is displayed.
<ul>>Add-to-Cart: </ul>Users can add products to their cart.
<ul>Buy Now:</ul> Clicking "Buy Now" opens a small pop-up window to complete the purchase.
<ul>Sign Out:</ul> Provides a sign-out option, which redirects the user back to the non-registered user home page.
<h4>6. Admin Page</h4>
<ul>Replenish Stock:</ul> Admin can select products from a dropdown list and replenish stock by adding the quantity to the existing product. 
The quantity must be a positive number.
<ul>Add New Product:</ul> Admin can add new products by filling out the following fields:
Product name
Buying unit price
Selling unit price
Market price
Quantity
Discount rate on quantity
<h4>New Features (Next Release):</h4>
<ul>Estimation:</ul> Will include an estimation feature for product pricing or sales projections.
<ul>Order Table: </ul>Will add an order management table for tracking all orders.
<ul>Customer Table:</ul> Displays basic user data for all customers except admins. Filters can be applied to show only users with a specific role.

<h1>Installation</h1>
git clone https://github.com/isborrr/Boro_Ismael_HotDealsMarket_CaseStudy.git
Clone and install the project. 
Connect a MySQL database named: storemanagement
Install necessary dependencies: Check the pom file
Run the application: This will automatically create the database and the tables needed. 
Run the following queries in your RDBMS, in my case Workbench.

INSERT INTO product_categories (category_name) VALUES 
('Soap'),
('Toilet Paper'),
('Shampoo');


INSERT INTO products (product_name_and_size, buying_price, selling_price, market_price, stock_quantity, product_category_id, discount_rate, discount_min_quantity, product_image_path) VALUES 
('Antibacterial Liquid Soap 500ml', 2.00, 3.50, 4.00, 100, 1, 0.50, 5, '../images/products/antibacterial-liquid-soap-500ml.png'),
('Moisturizing Bar Soap 100g', 1.00, 7.50, 3.00, 150, 1, 1.5, 10, '../images/products/moisturizing-bar-soap-100g.png'),
('Eco-Friendly Toilet Paper 12 Rolls', 5.00, 3.00, 9.00, 200, 2, 0.50, 9, '../images/products/eco-friendly-toilet-paper-12-Rolls.png'),
('Soft and Strong Toilet Paper 24 Rolls', 10.00, 12.50, 15.00, 180, 2, 0.50, 12, '../images/products/soft-and-strong-toilet-paper-24-rolls.png'),
('Herbal Shampoo 400ml', 6.00, 8.00, 12.00, 120, 3, 1.00, 10, '../images/products/herbal-shampoo-400ml.png'),
('Moisturizing Shampoo 500ml', 7.00, 9.00, 12.00, 90, 3, 1.50, 10, '../images/products/moisturizing-shampoo-500ml.png'),
('Antidandruff Shampoo 300ml', 8.00, 10.00, 12.50, 75, 3, 0.70, 6, '../images/products/antidandruff-shampoo-300ml.png'),
('Scented Bar Soap 150g', 1.50, 6.00, 3.00, 200, 1, 0.50, 9, '../images/products/scented-bar-Soap-150g.png'),
('Charcoal Detox Shampoo 500ml', 9.00, 11.00, 14.00, 60, 3, 1.00, 8, '../images/products/charcoal-detox-shampoo-500ml.png'),
('Luxury Bath Soap 200g', 3.00, 4.50, 5.50, 150, 1, 1.50, 12, '../images/products/luxury-bath-soap-200g.png');

<H3>You can now : Sign up, then sign in an enjoy the app</H3>





<h3>Full database creation queeries : if needed</h3>

- Drop and recreate the storemanagement database
DROP DATABASE IF EXISTS storemanagement;
CREATE DATABASE storemanagement;

-- Use the storemanagement database
USE storemanagement;

Select * from basic_users;



-- Create the  basic_users  table with a BIGINT primary key
CREATE TABLE basic_users (
   user_id BIGINT AUTO_INCREMENT PRIMARY KEY, 
   first_name VARCHAR(100) NOT NULL, 
   last_name VARCHAR(100) NOT NULL, 
   email VARCHAR(255) UNIQUE NOT NULL, 
   password VARCHAR(255) NOT NULL, 
   phone VARCHAR(15), 
   basic_users_type ENUM('Customer', 'Admin') NOT NULL
);



CREATE TABLE product_categories (
    category_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL
);

CREATE TABLE products ( 
    product_id BIGINT AUTO_INCREMENT PRIMARY KEY,   
    product_name_and_size VARCHAR(255) NOT NULL,  
    buying_price DECIMAL(10, 2) NOT NULL,  
    selling_price DECIMAL(10, 2) NOT NULL,    
    market_price DECIMAL(10, 2) NOT NULL,  
    stock_quantity INT NOT NULL,  
    product_category_id BIGINT NOT NULL,  -- Enforce category relationship
    discount_rate DECIMAL(10, 2) NOT NULL,  
    discount_min_quantity INT NOT NULL,  
    product_image_path VARCHAR(255) NOT NULL,
    CONSTRAINT fk_product_category  
         FOREIGN KEY (product_category_id)   
         REFERENCES product_categories(category_id)  
         ON DELETE CASCADE  ON UPDATE CASCADE 
);

CREATE TABLE cart (
    cart_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    receiving_status ENUM('Received', 'Shipped', 'Processed') NOT NULL,
    -- Add foreign key constraint to customers if necessary
     CONSTRAINT fk_cart FOREIGN KEY (customer_id) REFERENCES basic_users(user_id) ON DELETE CASCADE
);

CREATE TABLE cart_items (
    cart_item_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cart_items_cart_id BIGINT NOT NULL,  -- Renamed for consistency
    cart_items_product_id BIGINT NOT NULL,  -- Renamed for consistency
    quantity INT NOT NULL,
    CONSTRAINT fk_cart_items_cart_id
        FOREIGN KEY (cart_items_cart_id)
        REFERENCES cart(cart_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_product
        FOREIGN KEY (cart_items_product_id)
        REFERENCES products(product_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);


USE storemanagement;

INSERT INTO product_categories (category_name) VALUES 
('Soap'),
('Toilet Paper'),
('Shampoo');


INSERT INTO products (product_name_and_size, buying_price, selling_price, market_price, stock_quantity, product_category_id, discount_rate, discount_min_quantity, product_image_path) VALUES 
('Antibacterial Liquid Soap 500ml', 2.00, 3.50, 4.00, 100, 1, 0.50, 5, '../images/products/antibacterial-liquid-soap-500ml.png'),
('Moisturizing Bar Soap 100g', 1.00, 7.50, 3.00, 150, 1, 1.5, 10, '../images/products/moisturizing-bar-soap-100g.png'),
('Eco-Friendly Toilet Paper 12 Rolls', 5.00, 3.00, 9.00, 200, 2, 0.50, 9, '../images/products/eco-friendly-toilet-paper-12-Rolls.png'),
('Soft and Strong Toilet Paper 24 Rolls', 10.00, 12.50, 15.00, 180, 2, 0.50, 12, '../images/products/soft-and-strong-toilet-paper-24-rolls.png'),
('Herbal Shampoo 400ml', 6.00, 8.00, 12.00, 120, 3, 1.00, 10, '../images/products/herbal-shampoo-400ml.png'),
('Moisturizing Shampoo 500ml', 7.00, 9.00, 12.00, 90, 3, 1.50, 10, '../images/products/moisturizing-shampoo-500ml.png'),
('Antidandruff Shampoo 300ml', 8.00, 10.00, 12.50, 75, 3, 0.70, 6, '../images/products/antidandruff-shampoo-300ml.png'),
('Scented Bar Soap 150g', 1.50, 6.00, 3.00, 200, 1, 0.50, 9, '../images/products/scented-bar-Soap-150g.png'),
('Charcoal Detox Shampoo 500ml', 9.00, 11.00, 14.00, 60, 3, 1.00, 8, '../images/products/charcoal-detox-shampoo-500ml.png'),
('Luxury Bath Soap 200g', 3.00, 4.50, 5.50, 150, 1, 1.50, 12, '../images/products/luxury-bath-soap-200g.png');
