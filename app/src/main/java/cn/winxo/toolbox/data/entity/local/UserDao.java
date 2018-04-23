package cn.winxo.toolbox.data.entity.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao public interface UserDao {

  @Insert void insert(UserEntity entity);

  @Query("DELETE FROM user") void deleteAll();

  @Query("SELECT * from user ORDER BY _id ASC") List<UserEntity> getAllWords();
}