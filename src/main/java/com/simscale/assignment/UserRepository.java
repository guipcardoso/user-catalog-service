package com.simscale.assignment;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, String> {

	public List<User> findByFirstName(@Param("firstName")String firstName);

	public List<User> findByLastName(@Param("lastName")String lastName);
	
	public List<User> findByLastNameAndLastName(@Param("firstName")String firstName, @Param("lastName")String lastName);
	
	@Override
	@RestResource(exported = false)
	public void delete(User t);
}
