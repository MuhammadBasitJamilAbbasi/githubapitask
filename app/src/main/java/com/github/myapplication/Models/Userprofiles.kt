package com.github.myapplication.Models



import android.os.Parcel
import android.os.Parcelable
data class GitHubUserprofile(
    val login: String,
    val id: Int,
    val node_id: String,
    val avatar_url: String,
    val gravatar_id: String,
    val url: String,
    val html_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val starred_url: String,
    val subscriptions_url: String,
    val organizations_url: String,
    val repos_url: String,
    val events_url: String,
    val received_events_url: String,
    val type: String,
    val site_admin: Boolean,
    val name: String?,
    val company: String?,
    val blog: String?,
    val location: String?,
    val email: String?,
    val hireable: Boolean?,
    val bio: String?,
    val twitter_username: String?,
    val public_repos: Int,
    val public_gists: Int,
    val followers: Int,
    val following: Int,
    val created_at: String,
    val updated_at: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(login)
        parcel.writeInt(id)
        parcel.writeString(node_id)
        parcel.writeString(avatar_url)
        parcel.writeString(gravatar_id)
        parcel.writeString(url)
        parcel.writeString(html_url)
        parcel.writeString(followers_url)
        parcel.writeString(following_url)
        parcel.writeString(gists_url)
        parcel.writeString(starred_url)
        parcel.writeString(subscriptions_url)
        parcel.writeString(organizations_url)
        parcel.writeString(repos_url)
        parcel.writeString(events_url)
        parcel.writeString(received_events_url)
        parcel.writeString(type)
        parcel.writeByte(if (site_admin) 1 else 0)
        parcel.writeString(name)
        parcel.writeString(company)
        parcel.writeString(blog)
        parcel.writeString(location)
        parcel.writeString(email)
        parcel.writeValue(hireable)
        parcel.writeString(bio)
        parcel.writeString(twitter_username)
        parcel.writeInt(public_repos)
        parcel.writeInt(public_gists)
        parcel.writeInt(followers)
        parcel.writeInt(following)
        parcel.writeString(created_at)
        parcel.writeString(updated_at)
    }

    override fun describeContents(): Int {
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
