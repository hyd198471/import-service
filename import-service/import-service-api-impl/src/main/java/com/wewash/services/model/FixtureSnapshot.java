package com.wewash.services.model;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import java.util.Date;

@Entity
@Table(name = "fixture_snapshot")
public class FixtureSnapshot {

    @Id
    @Column(name = "id")
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return new Date(updateTime.getTime());
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = new Date(updateTime.getTime());
    }

    public Date getPublishedAt() {
        return new Date(publishedAt.getTime());
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = new Date(publishedAt.getTime());
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Date getBgHeaderTimestamp() {
        return new Date(bgHeaderTimestamp.getTime());
    }

    public void setBgHeaderTimestamp(Date bgHeaderTimestamp) {
        this.bgHeaderTimestamp = new Date(bgHeaderTimestamp.getTime());
    }

    public Integer getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(Integer sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FixtureSnapshot that = (FixtureSnapshot) o;
        return Objects.equal(snapshotJson, that.snapshotJson) &&
                Objects.equal(updateTime, that.updateTime) &&
                Objects.equal(publishedAt, that.publishedAt) &&
                Objects.equal(published, that.published) &&
                Objects.equal(bgHeaderTimestamp, that.bgHeaderTimestamp) &&
                Objects.equal(sectionNumber, that.sectionNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(snapshotJson, updateTime, publishedAt, published, bgHeaderTimestamp, sectionNumber);
    }
}
