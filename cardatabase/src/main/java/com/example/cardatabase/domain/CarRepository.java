package com.example.cardatabase.domain;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

 
// Method								Description
//--------------------------------------------------
// long count()							Returns the number of entities
// Iterable<T> findAll()				Returns all items of a given type
// Optional<T> findById(ID Id)			Returns one item by ID
// void delete(T entity)				Deletes an entity
// void deleteAll()						Deletes all the entities in the repository
// <S extends T> save(S entity)			Saves an entity
// List<S> saveAll(Iterable<S> 			Saves multiple entities
//entities)

@RepositoryRestResource
 public interface CarRepository extends CrudRepository<Car,Long> {
	// Fetch cars by brand using SQL
//	@Query("select c from Car c where c.brand = ?1")
	List<Car> findByBrand(@Param("brand") String brand);
	
//    // Fetch cars by brand using SQL
//    @Query("select c from Car c where c.brand like %?1")
//    List<Car> findByBrandEndsWith(String brand);
    
	// Fetch cars by color
	List<Car> findByColor(@Param("color") String color);
//	
//	// Fetch cars by model year
//	List<Car> findByModelYear(int modelYear);
//	
//	 // Fetch cars by brand and model
//    List<Car> findByBrandAndModel(String brand, String model);
//    
//    // Fetch cars by brand or color
//    List<Car> findByBrandOrColor(String brand, String color);
//    
//    // Fetch cars by brand and sort by year
//    List<Car> findByBrandOrderByModelYearAsc(String brand);
    
//	Method 										Description
//	-------------------------------------------------------
//	Iterable<T> findAll(Sort sort)				Returns all entities sorted by the given options
//	Page<T> findAll(Pageable pageable) 			Returns all entities according to the given 
//												paging options	 
//    
//    public interface CarRepository extends PagingAndSortingRepository <Car, Long> { }
    
 }