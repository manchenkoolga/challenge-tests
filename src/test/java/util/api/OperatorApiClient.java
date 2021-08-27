package util.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperatorApiClient {
    private static final Logger logger = LoggerFactory.getLogger(OperatorApiClient.class);

    public static void iTurnOffIdeaSubmissionBanner (String operatorEmail, String password) {
        logger.info("turn off the Idea Submission Banner with operator  email:- {}" + operatorEmail + "password: "+ password);
        OperatorApiMethods.setIdeaPromotionBannerState(OperatorApiMethods.login(operatorEmail, password));

    }
}
