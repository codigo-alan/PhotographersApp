package com.example.photographers.data.local

import com.example.photographers.data.local.model.ItemEntity
import com.example.photographers.domain.model.Item
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
//import org.junit.jupiter.api.Test

class LocalDataSourceTest {

    @RelaxedMockK
    private lateinit var itemDatabase: ItemDatabase

    lateinit var localDataSource: LocalDataSource

    private val mockedItem = Item(0,"mail","first","last",false,"desc","image")

    private val mockedItemEntity = ItemEntity(0, false,"mail","first","last",false,"desc","image")

    private val mockedItems =
        List<Item>(3){
            Item(0,"mail","first","last",false,"desc","image")
        }
    private val mockedItemsEntity =
        List<ItemEntity>(3){
            ItemEntity(0, false,"mail","first","last",false,"desc","image")
        }

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        localDataSource = LocalDataSource()
    }

    /**
     * Give a Bug intermittent error: Bad recording sequence. State: SafeLoggingState
     */
    @Test
    fun `when call insert data of local repo must call addItem of itemDao`() = runBlocking {
        //Given
        coEvery { itemDatabase.itemDao().addItem(mockedItemsEntity) }

        //When
        localDataSource.insertData(mockedItems, itemDatabase)

        //Then
        coVerify(exactly = 1) { itemDatabase.itemDao().addItem(any()) }
    }

    @Test
    fun `when call fetch data of local repo must call getItems one time`() = runBlocking {
        //Given
        coEvery { itemDatabase.itemDao().getItems() }

        //When
        localDataSource.fetchData(itemDatabase)

        //Then
        coVerify(exactly = 1) { itemDatabase.itemDao().getItems() }
    }

    @Test
    fun `when call itemToEntity should return ItemEntity`() = runBlocking {
        //Given

        //When
        val itemEntity = localDataSource.itemToEntity(mockedItem)

        //Then
        assert(itemEntity == mockedItemEntity)
    }

    @Test
    fun `when call entityToItem should return Item`() = runBlocking {
        //Given

        //When
        val item = localDataSource.entityToItem(mockedItemEntity)

        //Then
        assert(item == mockedItem)
    }

}