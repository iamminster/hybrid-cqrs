package jp.co.hybrid.read.service.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadService {
    @Autowired
    ReadRepository readRepository;

    public UserReadModel find(String id) {
        return readRepository.findById(id).orElse(null);
    }

    public List<UserReadModel> findAll() {
        return readRepository.findAll();
    }

}
