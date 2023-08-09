package com.example.foodrecipeapp.data.model

data class AnalyzedInstruction(
    @Suppress("UnusedPrivateMember")
    private val name: String,
    @Suppress("UnusedPrivateMember")
    private val steps: ArrayList<Step>
)
