# Inheritance

### Strategies
- MappedSuperclass : the parent classes, can't be entities
- Single Table : the entities from different classes with a common ancestor are placed in a single table
- Joined Table : each class has its table and querying a subclass entity requires joining the tables
- Table-Per-Class : all the properties of a class, are in its table, so no join is required

### Getting Started 
- https://www.baeldung.com/hibernate-inheritance