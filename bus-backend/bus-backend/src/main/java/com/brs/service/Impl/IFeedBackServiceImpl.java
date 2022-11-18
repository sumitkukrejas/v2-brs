package com.brs.service.Impl;



import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import com.brs.entity.Bus;
import com.brs.entity.Users;
import com.brs.exceptions.*;
import com.brs.service.interfaces.IFeedBackService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brs.dao.IFeedbackServiceDao;
import com.brs.entity.Feedback;


@Service
@Transactional
public class IFeedBackServiceImpl implements IFeedBackService {



	@Autowired
	IFeedbackServiceDao feedBackServiceDao;

	@Autowired IbusServiceImpl ibusService;

	@Autowired UsersServiceImpl usersService;

	@Override
	@SneakyThrows
	public Feedback addFeedBack(Feedback feedBack) {

		int id = feedBack.getFeedBackId();
		Optional<Feedback>feed = feedBackServiceDao.findById(id);
		if(!feed.isPresent())
		{
			return feedBackServiceDao.save(feedBack);
		}
		else
		{
			throw new FeedbackNotFoundException("ID ALREADY EXITS,TRY TO UPDATE");
		}


	}



	@Override
	@SneakyThrows
	public Feedback updateFeedBack(Feedback feedBack){

		int feedBackId = feedBack.getFeedBackId();
		Optional<Feedback> res = feedBackServiceDao.findById(feedBackId);
		if(res.isPresent()) {
			Feedback feed=res.get();
			feed.setFeedBackId(feedBack.getFeedBackId());
			feed.setDriverRating(feedBack.getDriverRating());
			feed.setServiceRating(feedBack.getServiceRating());
			feed.setOverallRating(feedBack.getOverallRating());
			feed.setComments(feedBack.getComments());
			feed.setFeedbackdate(feedBack.getFeedbackdate());
			if(feed.getBus().getBusId()==feedBack.getBus().getBusId())
			{
				Bus bus = ibusService.updateBus(feedBack.getBus());
				feed.setBus(bus);
			}
			else
			{
				feed.setBus(feedBack.getBus());
			}

			if(feed.getUsers().getUserLoginId()==feedBack.getUsers().getUserLoginId())
			{
				Users user = usersService.updateUser(feedBack.getUsers());
				feed.setUsers(user);
			}
			else
			{
				feed.setUsers(feedBack.getUsers());
			}


			return feed;
		}
		else 
		{
			throw new FeedbackNotFoundException("CANT UPDATE !  FEEDBACK NOT FOUND");
		}
	}



	@Override
	@SneakyThrows
	public Feedback viewFeedBack(int feedBackId){

		Optional<Feedback> b    = feedBackServiceDao.findById(feedBackId);
		if(b.isPresent())
		{
			return b.get();
		}
		else {

			throw new FeedbackNotFoundException("FEEDBACK ID NOT FOUND ");
		}
	}



	@Override
	public List<Feedback> viewAllFeedBack() {

		return feedBackServiceDao.findAll();
	}



}