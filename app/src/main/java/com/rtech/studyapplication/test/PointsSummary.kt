package com.rtech.studyapplication.test

data class PointsSummary(
    val adjusted: String,
    val cumulativePurchases: String,
    val currentSlab: String,
    val delayed_points: String,
    val delayed_returned_points: String,
    val expired: String,
    val gap_to_renew: GapToRenew,
    val gap_to_upgrade: GapToUpgrade,
    val lifetimePoints: String,
    val linked_partner_programs: LinkedPartnerPrograms,
    val loyaltyPoints: String,
    val nextSlab: String,
    val nextSlabDescription: String,
    val nextSlabSerialNumber: String,
    val programId: String,
    val program_description: String,
    val program_points_to_currency_ratio: String,
    val program_title: String,
    val redeemed: String,
    val returned: String,
    val slabExpiryDate: String,
    val slabSNo: String,
    val totalPoints: String,
    val total_available_points: String,
    val total_returned_points: String
)