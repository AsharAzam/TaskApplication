package com.example.taskapplication.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.taskapplication.data.network.models.SocialModel;
import java.util.List;

@Dao
public interface SocialsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<SocialModel> list);

    @Query("SELECT * FROM social")
    List<SocialModel> loadAll();
}
