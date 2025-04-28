package soraaslon.com.github.android_crypto_monitor.service

import retrofit2.Response
import retrofit2.http.GET
import soraaslon.com.github.android_crypto_monitor.model.TickerResponse

interface MercadoBitcoinService {

    @GET("api/BTC/ticker/")
    suspend fun getTicker(): Response<TickerResponse>
}