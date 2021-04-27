package com.miniebay.auction_platform.services;

import com.miniebay.auction_platform.entity.Bid;
import com.miniebay.auction_platform.entity.User;
import com.miniebay.auction_platform.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BidServiceImpl implements BidService {

    @Autowired
    private BidRepository bidRepository;

    @Override
    public List<Bid> getUserBids(Long id) {
       return bidRepository.getAllByUserOrderById(id);
    }
}
