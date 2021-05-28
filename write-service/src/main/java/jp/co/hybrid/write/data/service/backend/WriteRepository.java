package jp.co.hybrid.write.data.service.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriteRepository extends JpaRepository<UserWriteModel, String> {
}
