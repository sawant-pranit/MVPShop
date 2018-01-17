package com.example.pranit.mvpshop.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.pranit.mvpshop.TABLE_PRODUCT
import com.example.pranit.mvpshop.data.models.Product

/**
 * Created by pranit on 12/1/18.
 */
@Dao interface ProductDao {

    /**
     * Select all products from Table product
     *
     * @return all tasks.
     */
    @Query("SELECT * FROM $TABLE_PRODUCT") fun getProducts(): List<Product>

    /**
     * Inserts product data into local database
     *
     * @param product data
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE) fun insertProduct(product: Product)

    /**
     * Delete all products.
     */
    @Query("DELETE FROM $TABLE_PRODUCT") fun deleteProducts()

    /**
     * Get product by id
     *
     * @return product's id looking into database
     */
    @Query("SELECT * FROM $TABLE_PRODUCT WHERE prod_id = :productId")
    fun getProductById(productId : Int) :Product

    /**
     * Get products by category Id
     *
     * @param categoryId to fetch all products
     * @return Products by category
     */
    @Query("SELECT * FROM $TABLE_PRODUCT WHERE category_id = :categoryId")
    fun getProductsByCateogryId(categoryId : Int) :List<Product>
}