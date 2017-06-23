
package com.wewash.services.domain.dto.matchdetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "BookingStateChanges",
    "IsCollected",
    "IsReliable"
})
public class BookingStateChanges {

    /*
    Suppress Warnings due to not our API
        - squid:S1700 A field should not duplicate the name of its containing class
     */
    @SuppressWarnings({"squid:S1700"})
    @JsonProperty("BookingStateChanges")
    private List<BookingStateChange> bookingStateChanges;
    @JsonProperty("IsCollected")
    private boolean isCollected;
    @JsonProperty("IsReliable")
    private boolean isReliable;

    @JsonProperty("BookingStateChanges")
    public List<BookingStateChange> getBookingStateChanges() {
        return Collections.unmodifiableList(bookingStateChanges);
    }

    @JsonProperty("BookingStateChanges")
    public void setBookingStateChanges(List<BookingStateChange> bookingStateChanges) {
        this.bookingStateChanges = new ArrayList<>(bookingStateChanges);
    }

    @JsonProperty("IsCollected")
    public boolean isIsCollected() {
        return isCollected;
    }

    @JsonProperty("IsCollected")
    public void setIsCollected(boolean isCollected) {
        this.isCollected = isCollected;
    }

    @JsonProperty("IsReliable")
    public boolean isIsReliable() {
        return isReliable;
    }

    @JsonProperty("IsReliable")
    public void setIsReliable(boolean isReliable) {
        this.isReliable = isReliable;
    }

}
