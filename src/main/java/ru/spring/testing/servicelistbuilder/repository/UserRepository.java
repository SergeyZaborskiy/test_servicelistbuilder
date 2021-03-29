package ru.spring.testing.servicelistbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spring.testing.servicelistbuilder.entity.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
