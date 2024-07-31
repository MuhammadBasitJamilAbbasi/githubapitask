package com.github.myapplication.Models

import android.os.Parcel
import android.os.Parcelable

data class GitHubRepo(
    val id: Int,
    val name: String,
    val full_name: String,
    val description: String?,
    val language: String?,
    val stargazers_count: Int,
    val html_url: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<GitHubRepo> {
        override fun createFromParcel(parcel: Parcel): GitHubRepo {
            return GitHubRepo(parcel)
        }

        override fun newArray(size: Int): Array<GitHubRepo?> {
            return arrayOfNulls(size)
        }
    }
}
