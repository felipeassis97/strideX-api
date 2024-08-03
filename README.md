# SnapShoes API 👟
This project is a Spring Boot application developed in Kotlin for managing products, brands, sizes, and genres in an e-commerce platform. It uses MySQL for data persistence, leveraging Spring’s robust framework and Kotlin's modern syntax for a maintainable and scalable backend solution. The application features include handling HTTP requests, implementing business logic, and configuring security. It aims to provide an efficient and reliable system for managing an online store’s inventory.

## 📚 Layered Architecture
1. **Presentation Layer**
    - **Responsibility**: Manage user interface and HTTP requests.
    - **Components**:
        - **Controllers**: Handle HTTP requests and responses. In Spring, use `@RestController` or `@Controller` annotations.
        - **DTOs (Data Transfer Objects)**: Represent data being sent and received through the API.

2. **Service Layer**
    - **Responsibility**: Contains business logic of the application. This layer bridges the presentation layer and the persistence layer.
    - **Components**:
        - **Services**: Classes annotated with `@Service` that contain business logic.
        - **Service Interfaces**: Define contracts for business logic.

3. **Persistence Layer**
    - **Responsibility**: Manage data access and communication with the database.
    - **Components**:
        - **Repositories**: Interfaces annotated with `@Repository` that extend `JpaRepository` or `CrudRepository` for CRUD operations.
        - **Entities**: Classes representing database tables, annotated with `@Entity`.

4. **Configuration Layer**
    - **Responsibility**: Configure and manage Spring beans and settings.
    - **Components**:
        - **Configuration Classes**: Annotated with `@Configuration` to define beans and additional configurations.
        - **Security Configuration Classes**: Used to configure security aspects such as authentication and authorization.

#### ℹ️ Example Package Structure
```plaintext
com.snapshoes.store
├── controller
│   └── ProductController.kt
├── service
│   ├── ProductService.kt
│   └── impl
│       └── ProductServiceImpl.kt
├── repository
│   └── ProductRepository.kt
├── model
│   ├── Product.kt
│   ├── Size.kt
│   ├── Genre.kt
│   └── Brand.kt
├── config
│   └── SecurityConfig.kt
└── MyProjectApplication.kt
```

>#### 💡Additional
  >1. **Validate Inputs**: Use Bean Validation annotations (`javax.validation`) to ensure the integrity of data entering the application.
  >2. **Testing**: Write unit and integration tests to ensure your application functions correctly. Use frameworks like JUnit and MockK.
  >3. **API Documentation**: Consider using Swagger or Springdoc OpenAPI to generate API documentation.

# ↔️ Table Relationships
- In this project, the database schema is designed to efficiently manage products, brands, sizes, genres, and stores. The relationships between these tables are as follows:

1. **Address Table**: Contains address details for stores.
   - `address_id` is the primary key.

2. **Store Table**: Represents a physical or online store.
   - `address_id` is a foreign key linking to the Address table.
   - `store_id` is the primary key.

3. **Brand Table**: Contains information about brands.
   - `brand_id` is the primary key.

4. **Product Table**: Represents products sold in stores.
   - `store_id` is a foreign key linking to the Store table.
   - `brand_id` is a foreign key linking to the Brand table.
   - `product_id` is the primary key.

5. **Product Image Table**: Stores images associated with products.
   - `product_id` is a foreign key linking to the Product table.
   - `image_id` is the primary key.

6. **Size Table**: Contains different sizes available for products.
   - `size_id` is the primary key.

7. **Product Size Table**: Maps products to their available sizes.
   - `product_id` is a foreign key linking to the Product table.
   - `size_id` is a foreign key linking to the Size table.

8. **Genre Table**: Contains different genres or categories of products.
   - `genre_id` is the primary key.

9. **Product Genre Table**: Maps products to their associated genres.
   - `product_id` is a foreign key linking to the Product table.
   - `genre_id` is a foreign key linking to the Genre table.

 - These relationships ensure that each product is linked to a specific store and brand, can have multiple sizes and genres, and has associated images. This schema supports efficient querying and management of the e-commerce inventory.


## ℹ️ Commit Convention
- We follow the Conventional Commits specification to maintain clear and consistent commit messages. Below is a description of the commit types used in this project:

### Commit Types

- **`feat:`**  
  Introduces a new feature.  
  *Example*: `feat: add new user registration feature`

- **`fix:`**  
  Fixes a bug in the codebase.  
  *Example*: `fix: resolve issue with user login`

- **`docs:`**  
  Updates or adds documentation.  
  *Example*: `docs: update API usage instructions`

- **`style:`**  
  Changes that do not affect the code’s logic (e.g., whitespace, formatting).  
  *Example*: `style: adjust code indentation`

- **`refactor:`**  
  Refactoring code without adding features or fixing bugs.  
  *Example*: `refactor: improve performance of data processing`

- **`test:`**  
  Adds or modifies tests.  
  *Example*: `test: add unit tests for user service`

- **`chore:`**  
  Maintenance tasks or updates related to project management (e.g., build tasks, dependency updates).  
  *Example*: `chore: update build scripts`

## 𐂷 Branch Naming Convention
- To maintain consistency and clarity in our version control system, we use a standardized branch naming convention. The branch names should follow this format:

### Branch Name Format
- **`feat:`**  
  Branches related to new features.  
  *Example*: `feat/user-authentication`

- **`fix:`**  
  Branches for bug fixes.  
  *Example*: `fix/login-issue`

- **`docs:`**  
  Branches for documentation updates.  
  *Example*: `docs/api-documentation-update`

- **`style:`**  
  Branches for changes related to code style (e.g., formatting).  
  *Example*: `style/code-indentation`

- **`refactor:`**  
  Branches for code refactoring that does not add features or fix bugs.  
  *Example*: `refactor/data-processing`

- **`test:`**  
  Branches for adding or modifying tests.  
  *Example*: `test/user-service-tests`

- **`chore:`**  
  Branches for routine tasks and project maintenance (e.g., build tasks, dependency updates).  
  *Example*: `chore/dependency-updates`


