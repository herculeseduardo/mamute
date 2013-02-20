package br.com.caelum.brutal.integration.scene;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.brutal.integration.pages.QuestionPage;
import br.com.caelum.brutal.model.VoteType;

public class VoteUpDownTest extends AcceptanceTestBase {
    
    private QuestionPage questionPage;

    @Before
    public void setup() {
        loginRandomly();
        questionPage = home().toFirstQuestionPage();
    }
    
    @After
    public void logout() {
        home().logOut();
    }
    
    @Test
    public void should_vote_question_up() throws Exception {
        int initialQuestionVoteCount = questionPage.questionVoteCount();
        int countAfter = questionPage
            .voteQuestion(VoteType.UP)
            .questionVoteCount();
        
        assertEquals(initialQuestionVoteCount + 1, countAfter);
    }
    
    @Test
    public void should_vote_question_down() throws Exception {
        int initialQuestionVoteCount = questionPage.questionVoteCount();
        int countAfter = questionPage
                .voteQuestion(VoteType.DOWN)
                .questionVoteCount();
        
        assertEquals(initialQuestionVoteCount - 1, countAfter);
    }
    
    @Test
    public void should_vote_answer_up() throws Exception {
        int firstAnswerVoteCount = questionPage.firstAnswerVoteCount();
        int countAfter = questionPage
                .voteFirstAnswer(VoteType.UP)
                .firstAnswerVoteCount();
        
        assertEquals(firstAnswerVoteCount + 1, countAfter);
    }
    
    @Test
    public void should_vote_answer_down() throws Exception {
        int firstAnswerVoteCount = questionPage.firstAnswerVoteCount();
        int countAfter = questionPage
                .voteFirstAnswer(VoteType.DOWN)
                .firstAnswerVoteCount();
        
        assertEquals(firstAnswerVoteCount - 1, countAfter);
    }
    

    private void loginRandomly() {
        home().toSignUpPage()
                .signUp("chico sokol", 
                        "chico"+new Random().nextLong()+"@brutal.com", 
                        "123456", "123456");
    }
    
}