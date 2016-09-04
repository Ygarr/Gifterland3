package gifterland3.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * ProductCategory repository
 * Created by kdiv on 8/20/16.
 */
@Transactional
public interface MealDao extends CrudRepository<Meal, Long> {

 }
