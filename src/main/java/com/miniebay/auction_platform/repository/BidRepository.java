package com.miniebay.auction_platform.repository;

import com.miniebay.auction_platform.entity.Bid;
import com.miniebay.auction_platform.entity.Product;
import com.miniebay.auction_platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid,Long> {

    List<Bid> getAllByUserOrderById(Long id);
}
