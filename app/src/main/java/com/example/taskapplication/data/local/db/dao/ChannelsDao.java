package com.example.taskapplication.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.taskapplication.data.network.models.ChannelModel;
import java.util.List;
import io.reactivex.Single;

@Dao
public interface ChannelsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ChannelModel> list);

    @Query("SELECT * FROM channel")
    Single<List<ChannelModel>> loadAll();
}
