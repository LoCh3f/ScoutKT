package com.example.scoutkt.data.remote

import yahoofinance.quotes.fx.FxSymbols

data class Crypto(
    var id: Int,
    var name: String,
    var symbols: String,
    var slug: String,
    var num_market_pairs: Int,
    var date_added: String,
    var tags: List<String>,
    var max_supply: Int,
    var circlating_supply: Int,
    var total_supply: Int,
    var infinite_supply: Boolean,
    var cmc_rank: Int,
    var self_reported_circulating_supply: Int?,
    var self_repoted_market_cap: Int?,
    var tvl_ratio: Int?,
    var last_update: String,
    var quote: Quote
    )