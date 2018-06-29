package cn.winxo.toolbox.data.entity.local;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.util.Date;

/**
 * @author lxlong
 * @date 6/29/2018
 * @desc
 */
@Entity(tableName = "task") public class Task {
  @PrimaryKey(autoGenerate = true) private long id;
  private String content;
  private Boolean finished = false;
  private Date createTime;
  private Date modifiedTime;

  public Task(String content, Date createTime, Date modifiedTime) {
    this.content = content;
    this.createTime = createTime;
    this.modifiedTime = modifiedTime;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Boolean getFinished() {
    return finished;
  }

  public void setFinished(Boolean finished) {
    this.finished = finished;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getModifiedTime() {
    return modifiedTime;
  }

  public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }
}
