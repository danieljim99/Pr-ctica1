

# JAVA PROJECT 
---
---
---
- ## Categories:

	The categories have a name(String) that is introduced in the constructor, and an id(int) that is automatically defined when the object category is created, this is to avoid categories
	with the same id. The categories are all in one static list of type ***Category***, this help to locate all the categories easier, for example to find one category by its name or its id.
	Each object category has a list of type ***Product***, this list will store all the products of each category. When you create a category, it is added to the static list of categories,
	and if the boolean update is true, it rewrite the backup file of the categories, this is because maybe we want to make categories only for an auxiliar use and we don't want to save
	them in the backup file.
	
---	
- ## Products:

	The products have a name(String), an id(int), a category id(int), an amount of stock(int), and a price(float), all these elements must be introduced to create a product, except
	the id, because it is automatically defined like the category id, to avoid the same problem. In the product constructor, the first is to find the category by the introduced
	category id, it has to be higher than 0, using a loop for search if the category id exist in the static category list, if we find it, the product is added  to the product list
	of the category with that id, but if the category id is not found, a new undefined category will be created automatically, and the product will be added to its product list,
	and we can rename that undefined category later. At the same way like category, there is a bollean update with the same use, to update the backup file of products.
	
---	
- ## Users:

	The users have a name(String) and a password(String), this elements are introduced only when we select the option ***"Registrer"*** in the main menu(*Main and User interface*), the program is
	ready to take more than one user, so there is a static list of type ***User*** to store all the users that are in the data users backup file, and the new that would be created,
	there is too a list of type String for each user, this will be like a shopping cart, to store all the products that the user want to buy. When an object user is created,
	it is added to the static user list, and make an update to the user backup file only if the bollean update is true.
	
---	
- ## BackUp files:

	There are two types of methods to use the backup files, the first makes an update, the file is overwritten with the new information introduced, this can be any modification of 
	the objects(products, categories or users), and the other type makes a load from the files to create again the objects saved before, this is used only at the begining of the
	program, when the main is launched, it reads the file letter by letter and when it find a different tokens it does different things. The tokens and their meaning are: 
	the token ***"#"*** is used to separate the object attributes, ***"$"*** is used to separate the different objects and ***"!"*** is to indicate that there are no more objects in the file, 
	for example in the user backup file: ***username1#passworencrypted1$username2#passwordencrypted2$!*** The load of the files must be done in a especific order to load the objects 
	correctly.
	
---
- ## Main and User Interface:
	
	The user interface has all the methods that are necesary to use all the options that the program allow and the job of the main is to launch these methods and load the
	backup files. The first part of the UI is the main menu, in this menu you can choose to registrer with a new user or to login with a user that is already created, or with
	the admin account, that is created by deffect. The idea is that if it's the first time you run the program, is a good idea that the first thing you do is login with
	the admin account to create some categories and products, we can do this using login and introducing ***"admin", "admin"*** , now we are in the admin menu, where we have the
	admin options, like create categories and products, remove categories and products, rename categories and see the storage tree of all categories and products, the instructions
	to do all this options are shown when you select an option, you can not create categories with the same name than others either products with the same name than others; 
	when the categories and products are already created you can select exit and then registrer with a new account and enter to the user menu, this menu is only for normal 
	users, you can not modify anything like an admin, you can only see a list of the categories, see a list of the products by category, search a product, add a product to your 
	cart, remove a product of your cart, and see your cart, as the same way of the admin menu, the instructions are shown when you select and option, you can not add the same
	product twice to your cart.
