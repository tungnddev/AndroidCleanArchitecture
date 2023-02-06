package com.greaper.data.utils.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.greaper.data.remote.api.PostApi
import com.greaper.data.remote.mapper.post.PostMapper
import com.greaper.domain.model.Post

class PostPagingSource(
    private val postApi: PostApi,
    private val pageSize: Int,
    private val mapper: PostMapper
) : PagingSource<Int, Post>() {
    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, Post> {
        try {
            // Start refresh at page 1 if undefined.
            val nextPageNumber = params.key ?: 1
            val response = postApi.getPosts(nextPageNumber, pageSize)
                .map { mapper.postDtoMapper.mapToDomain(it) }
            return LoadResult.Page(
                data = response,
                prevKey = null, // Only paging forward.
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            // Handle errors in this block and return LoadResult.Error if it is an
            // expected error (such as a network failure).
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}