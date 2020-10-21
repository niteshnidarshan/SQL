package com.oto.repository;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oto.entity.Passport;
@Repository
public interface PassportRepository extends JpaRepository<Passport,Integer> {

}
