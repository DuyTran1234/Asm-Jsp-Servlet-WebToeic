package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.Exercise;
import BEAN.ListeningExercise;
import DB.Connect;

public class GetListeningExerciseDAO {
	public static List<ListeningExercise> getAllListeningExercise() {
		List<ListeningExercise> list = new ArrayList<>();
		String sql = "SELECT * FROM web_toeic.listening_exercise;";
		try {
			PreparedStatement statement = Connect.connectDB().prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				ListeningExercise exercise = new ListeningExercise();
				exercise.setExerciseID(result.getInt("exerciseID"));
				exercise.setExerciseName(result.getString("exerciseName"));
				exercise.setQuestionID(result.getString("questionID"));
				exercise.setQuestionContent(result.getString("questionContent"));
				exercise.setOptionA(result.getString("optionA"));
				exercise.setOptionB(result.getString("optionB"));
				exercise.setOptionC(result.getString("optionC"));
				exercise.setOptionD(result.getString("optionD"));
				exercise.setResult(result.getString("result"));
				exercise.setDate(result.getString("date"));
				exercise.setPath(result.getString("path"));
				list.add(exercise);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	public static ArrayList<Exercise> getListSearch(String exerciseName) {
		ArrayList<Exercise> list = new ArrayList<>();
		String sql = "select distinct exerciseName from listening_exercise where exerciseName like '%" + exerciseName + "%'";
		try {
			PreparedStatement statement = Connect.connectDB().prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			if(!result.isBeforeFirst()) {
				return null;
			}
			while(result.next()) {
				Exercise exercise = new Exercise();
				exercise.setExerciseName(result.getString("exerciseName"));
				list.add(exercise);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static ArrayList<ListeningExercise> getExerciseBasedName(String exerciseName) {
		ArrayList<ListeningExercise> list = new ArrayList<>();
		String sql = "select * from listening_exercise where exerciseName = ?";
		try {
			PreparedStatement statement = Connect.connectDB().prepareStatement(sql);
			statement.setString(1, exerciseName);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				ListeningExercise exercise = new ListeningExercise();
				exercise.setExerciseID(result.getInt("exerciseID"));
				exercise.setExerciseName(result.getString("exerciseName"));
				exercise.setQuestionID(result.getString("questionID"));
				exercise.setQuestionContent(result.getString("questionContent"));
				exercise.setOptionA(result.getString("optionA"));
				exercise.setOptionB(result.getString("optionB"));
				exercise.setOptionC(result.getString("optionC"));
				exercise.setOptionD(result.getString("optionD"));
				exercise.setResult(result.getString("result"));
				exercise.setDate(result.getString("date"));
				exercise.setPath(result.getString("path"));
				list.add(exercise);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
