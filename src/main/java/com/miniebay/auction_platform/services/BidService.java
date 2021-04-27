package com.miniebay.auction_platform.services;

import com.miniebay.auction_platform.entity.Bid;
import com.miniebay.auction_platform.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
public interface BidService {

    List<Bid> getUserBids(Long id);

}
