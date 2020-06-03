# Grocery Shopping Application

For the final project in the Server Programming course, I built a simple webapp which provides a weekly grocery shopping list. 

The web app was made from the perspective of a family (parent and child users). The parent has the ‘admin’ role and the child has the ‘user’ role. A child can add new items to the weekly grocery list and define the name and quantity of the item, and which shop the item can be found in (s market, k market or lidl – using a drop down list). 

Parents can add, edit and delete items from the list. After completing the shopping, parents can ‘empty’ the grocery list, which deletes all items from the list. NOTE: The 'upload image' functionality is not implemented yet. 

The app can be accessed using the following credentials:

Username: parent, Password: parent 

OR 

Username: child, Password: child

* [Live Demo](https://grocery-list-pant.herokuapp.com/)

## Quick start

1. [Clone the repo](#1-clone-the-repo).
1. [Run the app](#2-run-the-app).

### 1. Clone the repo

Clone the `GroceryItems` repository locally. In a terminal, run:

```
$ git clone https://github.com/pankaj-pant/GroceryItems.git
$ cd GroceryItems
```

### 2. Run the app

This command serves the app at `http://localhost:8080/`.

    $ ./mvnw spring-boot:run

## License
[MIT](https://choosealicense.com/licenses/mit/)