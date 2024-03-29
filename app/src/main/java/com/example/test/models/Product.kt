package com.example.test.models

data class Product(
    val id: String,
    val site_id: String,
    val title: String,
    val subtitle: String,
    val seller_id: Int,
    val category_id: String,
    val official_store_id: String,
    val price: Double,
    val base_price: Double,
    val original_price: String,
    val currency_id: String,
    val initial_quantity: Int,
    val available_quantity: Int,
    val sold_quantity: Int,
    val sale_terms: List<SaleTerms>,
    val buying_mode: String,
    val listing_type_id: String,
    val start_time: String,
    val stop_time: String,
    val condition: String,
    val permalink: String,
    val thumbnail: String,
    val secure_thumbnail: String,
    val pictures: List<Pictures>,
    val video_id: String,
    val descriptions: List<Descriptions>,
    val accepts_mercadopago: Boolean,
    val non_mercado_pago_payment_methods: List<NonMercadoPagoPaymentMethods>,
    val shipping: Shipping,
    val international_delivery_mode: String,
    val seller_address: SellerAddress,
    val seller_contact: String,
    val location: Location,
    val geolocation: Geolocation,
    val coverage_areas: List<String>,
    val attributes: List<Attributes>,
    val warnings: List<String>,
    val listing_source: String,
    val variations: List<Variations>,
    val status: String,
    val sub_status: List<String>,
    val tags: List<String>,
    val warranty: String,
    val catalog_product_id: String,
    val domain_id: String,
    val parent_item_id: String,
    val differential_pricing: String,
    val deal_ids: List<String>,
    val automatic_relist: Boolean,
    val date_created: String,
    val last_updated: String,
    val health: String,
    val catalog_listing: Boolean
)