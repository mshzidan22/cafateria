package com.isi.cafateria.repository;

import com.isi.cafateria.model.Fatora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatoraRepo extends JpaRepository<Fatora,Long> {
}
