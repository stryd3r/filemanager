package jUnits;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.filemanager.backend.dao.interfaces.QuestionnaireAnswerDao;
import com.filemanager.config.AppConfig;
import com.filemanager.config.AppInitializer;
import com.filemanager.config.DataSourceConfig;
import com.filemanager.utils.transporters.dto.simple.QuestionnaireAnswerDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppInitializer.class, AppConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class QuestionnaireAnswerTest {

	@Autowired
	private QuestionnaireAnswerDao dao;
	private static final int validQuestionId = 3;
	private static final int validQuestionnaireId = 3;
	private static final int validPacientId = 3;

	@Test
	public void insertRemoveQuestionnaireAnswer() {

		QuestionnaireAnswerDto questionnaireAnswer = new QuestionnaireAnswerDto();
		questionnaireAnswer.setPacientId(validPacientId);
		questionnaireAnswer.setQuestionId(validQuestionId);
		questionnaireAnswer.setQuestionnaireId(validQuestionnaireId);
		questionnaireAnswer.setAnswer("da");
		boolean resultInserted = dao.insertQuestionnaireAnswer(questionnaireAnswer);

		boolean resultDeleted = dao.removeQuestionnaireAnswer(validQuestionnaireId, validQuestionId, validPacientId);

		assert (resultInserted && resultDeleted);
	}

	@Test
	public void updateQuestionnaireAnswer() {

		QuestionnaireAnswerDto questionnaireAnswer = new QuestionnaireAnswerDto();
		questionnaireAnswer.setPacientId(validPacientId);
		questionnaireAnswer.setQuestionId(validQuestionId);
		questionnaireAnswer.setQuestionnaireId(validQuestionnaireId);
		questionnaireAnswer.setAnswer("daDd");
		boolean result = dao.updateQuestionnaireAnswer(questionnaireAnswer, 2, 2, 1);
		assert (result);
	}

	@Test
	public void getAnswer() {

		QuestionnaireAnswerDto questionnaireAnswerDto = dao.getAnswer(2, 2, 1);

		assert (questionnaireAnswerDto != null);
	}

	@Test
	public void getQuestionnaireAnswers() {

		List<QuestionnaireAnswerDto> questionnaireAnswers = dao.getQuestionnaireAnswers();
		System.out.println(questionnaireAnswers.size());
		assert (questionnaireAnswers.size() > 0);
	}

	@Test
	public void getAnswersForQuestionnaire() {
		List<QuestionnaireAnswerDto> answers = dao.getAnswersForQuestionnaire(1, 1);
		System.out.println(answers.size());
		assert !answers.isEmpty();
	}

}
