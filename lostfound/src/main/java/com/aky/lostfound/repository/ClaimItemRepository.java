package com.aky.lostfound.repository;

import com.aky.lostfound.entity.ClaimItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimItemRepository extends JpaRepository<ClaimItem, Long> {

}
