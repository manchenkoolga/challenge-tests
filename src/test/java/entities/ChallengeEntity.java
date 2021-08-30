package entities;

import util.helpers.Helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChallengeEntity {
    private String challengeTitle;
    private String challengeHashtag;
    private String challengeDescription;
    private String challengeStartDate;
    private String challengeEndDate;
    private String challengeStartTime;
    private String challengeEndTime;

    public ChallengeEntity() {
        this.challengeTitle = Helper.generateRandomChallengeTitle(5);
        this.challengeHashtag = Helper.generateRandomChallengeHashTag(3);
        this.challengeDescription = Helper.generateRandomChallengeDescription(3);
        this.challengeStartDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMddyyyy"));
        this.challengeEndDate = LocalDateTime.now().plusDays(10).format(DateTimeFormatter.ofPattern("MMddyyyy"));
        this.challengeStartTime = "12:00 A";
        this.challengeEndTime = "12:00 A";


    }

    public String getChallengeTitle() {
        return challengeTitle;
    }

    public void setChallengeTitle() {
        this.challengeTitle = challengeTitle;
    }

    public String getChallengeHashtag() {
        return challengeHashtag;
    }

    public void setChallengeHashtag(String hashtag) {
        this.challengeHashtag = challengeHashtag;
    }

    public String getChallengeDescription() {
        return challengeDescription;
    }

    public void setChallengeDescription(String description) {
        this.challengeDescription = challengeDescription;
    }

    public String getChallengeStartDate() {
        return challengeStartDate;
    }

    public void setChallengeStartDate(String startDate) {
        this.challengeStartDate = challengeStartDate;
    }

    public String getChallengeEndDate() {
        return challengeEndDate;
    }

    public void setChallengeEndDate(String endDate ) {
        this.challengeEndDate = challengeEndDate;
    }

    public String getChallengeStartTime() {
        return challengeStartTime;
    }

    public void setChallengeStartTime(String startTime) {
        this.challengeStartTime = challengeStartTime;
    }

    public String getChallengeEndTime() {
        return challengeEndTime;
    }

    public void setChallengeEndTime(String endTime) {
        this.challengeEndTime = challengeEndTime;
    }
}

