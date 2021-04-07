package io.github.fuadreza.basecleanarchitecture.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.fuadreza.basecleanarchitecture.data.vo.Results
import io.github.fuadreza.basecleanarchitecture.domain.entity.NowPlaying

@Dao
interface NowPlayingDao {

    @Query("SELECT * FROM now_playing")
    fun getMovieNowPlaying(): Results<List<NowPlaying>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<NowPlaying>)
}