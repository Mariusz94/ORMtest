package pl.mariuszlyszczarz.AORMtest.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mariuszlyszczarz.AORMtest.models.UserModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {
    //List<UserModel> findByAgeGreaterThan(int a);   //własne nasze zapytanie sql
    //List<UserModel> findByAgeGreaterThanAndLoginLike(int a, String login); //ci co mają 20 lat i mają literkę a
    //Optional<UserModel> findByLoginAndPassword(String login,String password);
    boolean existsByLoginAndPassword(String login,String password);
}
