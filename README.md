This project is a demo model of the proposed bargain feature for the Myntra app. It allows users to negotiate the price of products through a simple and intuitive interface. This feature is designed to enhance user engagement by providing a more interactive shopping experience.

Features

User Authentication: New users are prompted to enter their name and phone number to log in. Product Display: A homepage displaying a list of products. Product Details: Clicking on a product shows detailed information along with options to bargain or buy. Bargain Option: Users can propose a new price for a product, which will be evaluated against the set minimum price and their shopping history. Eligibility Check: Only frequent buyers who meet the minimum order criteria can use the bargain feature. Technology Stack

Frontend: XML
Backend: Java
Database: SQLite

The code files are in .java and .xml format. For accessing the files, refer below
### Java Files
- **Customer.java**: A class to create a customer object.
- **DbHelper.java**: Contains SQL queries for creating tables and managing Customer and Product information.
- **HomeActivity.java**: Uses RecyclerView to display all products in the PRODUCT table.
- **LoginActivity.java**: Handles the login page for new users.
- **Product.java**: A class to create a product object.
- **ProductDetails.java**: Contains the main logic for evaluating user's requests and giving responses.
- **ProductListAdapter.java**: Adapter for displaying products in the RecyclerView.

### XML Files
- **activity_login.xml**: Layout for the login activity.
- **activity_home.xml**: Layout for the home activity displaying the list of products.
- **activity_product_details.xml**: Layout for the product details activity.
- **item_product.xml**: Layout for individual product items in the RecyclerView.

### Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/vidhi566/Mynthree-Submision.git
2. Open in Android Studio
   Open Android Studio.
   Click on File -> Open and navigate to the cloned repository folder.
   Select the project to open it.
3. Build the Project
4. Sync the project with Gradle files.
    Build the project to download all the necessary dependencies.
    Run the Application
5. Connect an Android device or start an emulator.
    Click on Run -> Run 'app' to install and start the application.
