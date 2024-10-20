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
