package hu.charmanthere.ease;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCicaRepositoryInterface extends JpaRepository<TestCica, Long> {
}
