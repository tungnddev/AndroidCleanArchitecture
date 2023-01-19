package com.greaper.data.local.db

import com.greaper.data.local.db.dao.PostDao
import com.greaper.data.model.entity.PostEntity
import com.greaper.data.utils.TestUtil
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

@OptIn(ExperimentalCoroutinesApi::class)
class PostDaoTest : BaseDaoTest() {

    private lateinit var postDao: PostDao

    @Before
    override fun setup() {
        super.setup()
        postDao = appDatabase.postDao()
    }

    @Test
    fun writePostAndReadInList() = runTest {
        val post = createPostEntity("1")
        postDao.insert(post)
        val data = postDao.findById("1").first()
        Assert.assertEquals(post, data)
    }


    @Test
    fun deleteItem() = runTest {
        val post = createPostEntity("1")
        postDao.insert(post)
        postDao.deleteById("1")
        val data = postDao.findById("1").first()
        Assert.assertEquals(null, data)
    }

    @Test
    fun updateItem() = runTest {
        val post = createPostEntity("1")
        postDao.insert(post)
        val newPost = createPostEntityUpdated("1")
        postDao.update(newPost)
        val data = postDao.findById("1").first()
        Assert.assertEquals(newPost, data)
    }

    private fun createPostEntity(id: String) = PostEntity(
        id, TestUtil.LOREM_STRING, "https://fakeimg.pl/700", Date(1673461750000), "{}"
    )

    private fun createPostEntityUpdated(id: String) = PostEntity(
        id,
        "${TestUtil.LOREM_STRING}_update",
        "https://fakeimg.pl/700_update",
        Date(1673461750001),
        "{1}"
    )
}