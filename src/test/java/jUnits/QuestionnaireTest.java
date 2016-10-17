package jUnits;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.filemanager.backend.service.interfaces.QuestionnaireService;
import com.filemanager.config.AppConfig;
import com.filemanager.config.AppInitializer;
import com.filemanager.config.DataSourceConfig;
import com.filemanager.exceptions.ConstraintException;
import com.filemanager.utils.transporters.dto.simple.QuestionnaireDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppInitializer.class, AppConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class QuestionnaireTest {

	@Autowired
	private QuestionnaireService questionnaireService;

	@Test
	public void insertRemoveQuestionnaire() {

		QuestionnaireDto questionnaire = new QuestionnaireDto();
		questionnaire.setQuestionId(3);
		questionnaire.setQuestionnaireId(3);
		questionnaire.setQuestion("ce?");
		boolean resultInserted = questionnaireService.insertQuestionnaire(questionnaire);

		boolean resultDeleted = questionnaireService.removeQuestionFromQuestionnaire(3, 3);

		assert (resultInserted && resultDeleted);
	}

	@Test
	public void removeQuestionnaireWhichHasAnswers() throws ConstraintException{
		questionnaireService.removeQuestionnaire(1);
	}
	@Test
	public void updateQuestionnaire() {

		QuestionnaireDto questionnaire = new QuestionnaireDto();
		questionnaire.setQuestionnaireId(4);
		questionnaire.setQuestionId(5);
		questionnaire.setQuestion("ce?");
		boolean result = questionnaireService.updateQuestionnaire(questionnaire, 1, 1);
		assert (result);
	}

	@Test
	public void getQuestionnaireById() {

		QuestionnaireDto questionnaireAnswerDto = questionnaireService.getQuestionFromQuestionnaire(4, 5);

		assert (questionnaireAnswerDto != null);
	}

	@Test
	public void getQuestionnaires() {

		List<QuestionnaireDto> questionnaireAnswers = questionnaireService.getQuestionnaires();
		System.out.println(questionnaireAnswers.size());
		assert (!questionnaireAnswers.isEmpty());
	}

	@Test
	public void removeQuestionnaire() throws ConstraintException {
		boolean result = questionnaireService.removeQuestionnaire(1);
		assert result;
	}

	@Test
	public void getQuestionnaire() {
		List<QuestionnaireDto> questionsForQuestionnaire = questionnaireService.getQuestionnaire(1);
		System.out.println(questionsForQuestionnaire.size());
		assert !questionsForQuestionnaire.isEmpty();
	}

}
