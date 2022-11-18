package com.brs.service.interfaces;



import java.util.List;



//import com.brs.List;
import com.brs.entity.Feedback;
import com.brs.exceptions.*;


public interface IFeedBackService {


   public Feedback addFeedBack(Feedback feedBack);

    public Feedback updateFeedBack(Feedback feedBack) throws FeedbackNotFoundException, BusNotFoundException, UserNotFoundException, ReservationNotFoundException, UnModifiableException;
    public Feedback viewFeedBack(int feedBackId) throws FeedbackNotFoundException;
    public List<Feedback> viewAllFeedBack();
    
}