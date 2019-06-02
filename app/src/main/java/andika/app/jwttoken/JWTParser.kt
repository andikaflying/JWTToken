/**
 * @copyright ©2019 Onoff Insurance All rights reserved. Trade Secret, Confidential and Proprietary.
 *            Any dissemination outside of Onoff Insurance is strictly prohibited.
 */
package andika.app.jwttoken

import com.auth0.android.jwt.JWT

object JWTParser {
    //These are parameter names of JWT payload
    private val keys: Array<String> = arrayOf("name", "sub", "aud", "email_verified", "event_id", "token_use", "auth_time", "iss", "cognito:username", "exp", "iat", "email")

    fun parseToken(token: String) : JWTPayload {
        val jwt : JWT = JWT(token)
        var jwtUserData : JWTPayload = JWTPayload(jwt.getClaim(keys[0]).asString())
        jwtUserData.sub = jwt.getClaim(keys[1]).asString()
        jwtUserData.aud = jwt.getClaim(keys[2]).asString()
        jwtUserData.email_verified = jwt.getClaim(keys[3]).asBoolean()
        jwtUserData.event_id = jwt.getClaim(keys[4]).asString()
        jwtUserData.token_use = jwt.getClaim(keys[5]).asString()
        jwtUserData.auth_time = jwt.getClaim(keys[6]).asInt()
        jwtUserData.iss = jwt.getClaim(keys[7]).asString()
        jwtUserData.cognitoUsername = jwt.getClaim(keys[8]).asString()
        jwtUserData.exp = jwt.getClaim(keys[9]).asInt()
        jwtUserData.iat = jwt.getClaim(keys[10]).asInt()
        jwtUserData.email = jwt.getClaim(keys[11]).asString()

        return jwtUserData
    }
}
