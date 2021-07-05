package com.example.taskapplication.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.taskapplication.data.local.db.dao.ChannelsDao;
import com.example.taskapplication.data.local.db.dao.SocialsDao;
import com.example.taskapplication.data.network.models.ChannelModel;
import com.example.taskapplication.data.network.models.SocialModel;

@Database(entities = {SocialModel.class, ChannelModel.class}, version = 1 ,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ChannelsDao channelDao();

    public abstract SocialsDao socialDao();

}
