package com.brs.service.interfaces;



import java.util.List;



//import com.brs.List;
import com.brs.entity.Feedback;
import com.brs.exceptions.*;


public interface IFeedBackService {


   Feedback addFeedBack(Feedback feedBack);

    Feedback updateFeedBack(Feedback feedBack) throws FeedbackNotFoundException, BusNotFoundException, UserNotFoundException, ReservationNotFoundException, UnModifiableException;
    Feedback viewFeedBack(int feedBackId) throws FeedbackNotFoundException;
    List<Feedback> viewAllFeedBack();
    
}