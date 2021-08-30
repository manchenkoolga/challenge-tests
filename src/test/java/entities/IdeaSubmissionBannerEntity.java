package entities;

import util.helpers.Helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IdeaSubmissionBannerEntity {
    public String ideaReward;
    public String submissionStartDate;
    public String submissionEndDate;
    public String submissionStartTime;
    public String submissionEndTime;
    public String updatedIdeaReward;
    public String updatedSubmissionStartDate;
    public String updatedSubmissionEndDate;
    public String updatedSubmissionStartTime;
    public String updatedSubmissionEndTime;


    public IdeaSubmissionBannerEntity() {
        this.ideaReward = String.valueOf(Helper.getRandomIntInRange(99));
        this.submissionStartDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMddyyyy"));
        this.submissionEndDate = LocalDateTime.now().plusDays(2).format(DateTimeFormatter.ofPattern("MMddyyyy"));
        this.submissionStartTime = "11:00 A";
        this.submissionEndTime = "11:00 A";
        this.updatedIdeaReward = ideaReward + 0;
        this.updatedSubmissionStartDate = LocalDateTime.now().plusDays(7).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        this.updatedSubmissionEndDate = LocalDateTime.now().plusDays(9).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        this.updatedSubmissionStartTime = "12:00 A";
        this.updatedSubmissionEndTime = "12:00 A";
    }

    public String getIdeaReward() { return ideaReward; }

    public String getSubmissionStartDate() { return submissionStartDate; }

    public String getSubmissionEndDate() { return submissionEndDate;}

    public String getSubmissionStartTime() { return submissionStartTime; }

    public String getSubmissionEndTime() { return submissionEndTime; }

    public void setUpdatedIdeaReward(String updatedIdeaReward) { this.updatedIdeaReward = updatedIdeaReward; }

    public String getUpdatedIdeaReward() { return updatedIdeaReward; }


    public String getUpdatedSubmissionStartDate() {
        return updatedSubmissionStartDate;
    }


    public String getUpdatedSubmissionEndDate() {
        return updatedSubmissionEndDate;
    }

    public String getUpdatedSubmissionStartTime() {
        return updatedSubmissionStartTime;
    }

    public String getUpdatedSubmissionEndTime() {
        return updatedSubmissionEndTime;
    }
}
