package jp.co.hybrid.read.service.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadRepository extends JpaRepository<UserReadModel, String> {
}
