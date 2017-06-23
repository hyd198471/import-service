
package com.wewash.services.domain.dto.fixture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "CompetitorType",
        "HomeAway",
        "Competitors",
        "FirstName",
        "LastName",
        "SquadNumber",
        "Position",
        "Gender"
})
public class Competitor {

    @JsonProperty(value = "Id", required = true)
    private int id;
    @JsonProperty(value = "Name", required = true)
    private String name;
    @JsonProperty(value = "CompetitorType", required = true)
    private CompetitorType competitorType;
    @JsonProperty(value = "HomeAway")
    private HomeAway homeAway;
    @JsonProperty(value = "Competitors")
    private List<Competitor> competitors;
    @JsonProperty(value = "FirstName")
    private String firstName;
    @JsonProperty(value = "LastName")
    private String lastName;
    @JsonProperty(value = "SquadNumber")
    private String squadNumber;
    @JsonProperty(value = "Position")
    private String position;


    @JsonProperty(value = "Gender", required = true)
    private Gender gender;

    @JsonProperty(value = "Id", required = true)
    public int getId() {
        return id;
    }

    @JsonProperty(value = "Id", required = true)
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty(value = "Name", required = true)
    public String getName() {
        return name;
    }

    @JsonProperty(value = "Name", required = true)
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty(value = "HomeAway", required = true)
    public HomeAway getHomeAway() {
        return homeAway;
    }

    @JsonProperty(value = "HomeAway", required = true)
    public void setHomeAway(HomeAway homeAway) {
        this.homeAway = homeAway;
    }

    @JsonProperty(value = "Gender", required = true)
    public Gender getGender() {
        return gender;
    }

    @JsonProperty(value = "Gender", required = true)
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @JsonProperty(value = "CompetitorType", required = true)
    public CompetitorType getCompetitorType() {
        return competitorType;
    }

    @JsonProperty(value = "CompetitorType", required = true)
    public void setCompetitorType(CompetitorType competitorType) {
        this.competitorType = competitorType;
    }

    @JsonProperty(value = "Competitors")
    public List<Competitor> getCompetitors() {
        return competitors != null ? Collections.unmodifiableList(competitors) : Collections.emptyList();
    }

    @JsonProperty(value = "Competitors")
    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = new ArrayList<>(competitors);
    }

    @JsonProperty(value = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty(value = "FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty(value = "LastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty(value = "LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty(value = "SquadNumber")
    public String getSquadNumber() {
        return squadNumber;
    }

    @JsonProperty(value = "SquadNumber")
    public void setSquadNumber(String squadNumber) {
        this.squadNumber = squadNumber;
    }

    @JsonProperty(value = "Position")
    public String getPosition() {
        return position;
    }

    @JsonProperty(value = "Position")
    public void setPosition(String position) {
        this.position = position;
    }
}
