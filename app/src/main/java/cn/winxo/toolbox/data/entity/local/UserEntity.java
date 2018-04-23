package cn.winxo.toolbox.data.entity.local;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author lxlong
 * @date 23/04/2018
 * @desc
 */
@Entity(tableName = "user") public class UserEntity {

  @PrimaryKey(autoGenerate = true) private int _id;

  private String name;

  private String password;

  public int get_id() {
    return _id;
  }

  public void set_id(int _id) {
    this._id = _id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}