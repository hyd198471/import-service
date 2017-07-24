package com.wewash.services.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "fixture_snapshot")
public class FixtureSnapshot {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;

    @Version
    private Long version;

    @Column(name = "snapshot_json", nullable = false)
    @Lob
    private String snapshotJson;

    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    @Column(name = "published_at")
    private Date publishedAt;

    @Column(name = "published", nullable = false)
    private Boolean published;

    @Column(name = "bg_header_timestamp")
    private Date bgHeaderTimestamp;

    @Column(name = "section_number")
    @Max(message = "section_number is stored as a tinyint - up to 127", value = 127)
    private Integer sectionNumber;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getSnapshotJson() {
        return snapshotJson;
    }

    public void setSnapshotJson(String snapshotJson) {
        this.snapshotJson = snapshotJson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Date getBgHeaderTimestamp() {
        return bgHeaderTimestamp;
    }

    public void setBgHeaderTimestamp(Date bgHeaderTimestamp) {
        this.bgHeaderTimestamp = bgHeaderTimestamp;
    }

    public Integer getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(Integer sectionNumber) {
        this.sectionNumber = sectionNumber;
    }
}
