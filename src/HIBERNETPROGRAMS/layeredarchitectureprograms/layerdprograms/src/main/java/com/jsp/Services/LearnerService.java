package com.jsp.Services;





import java.util.List;

import com.jsp.Entity.Learner;
import com.jsp.dao.LearnerDAO;

public class LearnerService {
//DAO instance to handle database operation
	
	private LearnerDAO learnerDAO=new LearnerDAO();
	/**
	 * Register a new learner
	 * @param name  Name of the learner
	 * 
	 */
	public void registerLearner(String name, String course, int marks) {
		learnerDAO.saveLearner(new Learner(name, course, marks));
	}
	/**
	 * Fetch a learner by ID
	 * @param id Learner ID
	 * @return Learner object or null if not found
	 */
	public Learner fetchLearner(int id) {
		return learnerDAO.getLearnerById(id);
		
	}
	/**
	 * Fetch all learners from the database
	 * @return List of Learner objects
	 */
	public List<Learner> fetchAllLearners(){
		return learnerDAO.getAllLearners();
	}
	
	public void updateLearner(int id,String name,String course,int marks) {
		Learner learner=new Learner(name, course, marks);
		if(learner !=null) {
			learner.setName(name);
			learner.setCourse(course);
			learner.setMarks(marks);
			
		}
	}
	public void deleteLearner(int id) {
		learnerDAO.deleteLearner(id);
	}
	public void shutDown() {
		learnerDAO.closeFactory();
	}
	
}
