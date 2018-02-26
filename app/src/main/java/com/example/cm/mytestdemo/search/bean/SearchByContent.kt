package com.example.cm.mytestdemo.search.bean
import com.google.gson.annotations.SerializedName


/**
 * Date: 2018/2/4 17:07
 * Email: luojie@cmcm.com
 * Author: luojie
 * Description: TODO
 */


data class SearchByContent(
		@SerializedName("from") var from: Int, //0
		@SerializedName("size") var size: Int, //10
		@SerializedName("query") var query: Query,
		@SerializedName("_sorece") var sorece: List<String>
)

data class Query(
		@SerializedName("match") var match: Match
)

data class Match(
		@SerializedName("content") var content: String //中国
)