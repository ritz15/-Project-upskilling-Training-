package net.upskilling.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.upskilling.springboot.entity.WikimediaData;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {

}
