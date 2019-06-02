/**
 * @copyright ©2019 Onoff Insurance All rights reserved. Trade Secret, Confidential and Proprietary.
 *            Any dissemination outside of Onoff Insurance is strictly prohibited.
 */
package andika.app.jwttoken

import android.os.Parcel
import android.os.Parcelable

/**
 * This class is responsible to hold JWT token as model
 *
 * @author    Andika Kurniawan  <andikakurniawan@onoff.insure>
 */
data class JWTPayload(var name: String?) : Parcelable {
    var sub: String? = null
    var aud: String? = null
    var email_verified: Boolean? = null
    var event_id: String? = null
    var token_use: String? = null
    var auth_time: Int? = null
    var iss: String? = null
    var cognitoUsername: String? = null
    var exp: Int? = null
    var iat: Int? = null
    var email: String? = null

    constructor(parcel: Parcel) : this(parcel.readString()) {
        sub = parcel.readString()
        aud = parcel.readString()
        email_verified = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        event_id = parcel.readString()
        token_use = parcel.readString()
        auth_time = parcel.readValue(Int::class.java.classLoader) as? Int
        iss = parcel.readString()
        cognitoUsername = parcel.readString()
        exp = parcel.readValue(Int::class.java.classLoader) as? Int
        iat = parcel.readValue(Int::class.java.classLoader) as? Int
        email = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(sub)
        parcel.writeString(aud)
        parcel.writeValue(email_verified)
        parcel.writeString(event_id)
        parcel.writeString(token_use)
        parcel.writeValue(auth_time)
        parcel.writeString(iss)
        parcel.writeString(cognitoUsername)
        parcel.writeValue(exp)
        parcel.writeValue(iat)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<JWTPayload> {
        override fun createFromParcel(parcel: Parcel) : JWTPayload {
            return JWTPayload(parcel)
        }

        override fun newArray(size: Int) : Array<JWTPayload?> {
            return arrayOfNulls(size)
        }
    }
}
