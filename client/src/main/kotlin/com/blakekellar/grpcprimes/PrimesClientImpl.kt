package com.blakekellar.grpcprimes

import com.blakekellar.grpcprimes.proto.PrimesGrpc
import com.blakekellar.grpcprimes.proto.PrimesReply
import com.blakekellar.grpcprimes.proto.PrimesRequest
import io.grpc.Channel
import io.grpc.ManagedChannelBuilder

class PrimesClientImpl(host: String = "localhost",
                       port: Int = 50051) : PrimesClient {

    private val channel: Channel

    init {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build()
    }

    override fun getPrimes(numPrimes: Int): PrimesReply? {
        val request = PrimesRequest.newBuilder().setNumPrimes(numPrimes).build()
        val stub = PrimesGrpc.newBlockingStub(channel)
        return stub.getPrimes(request)
    }
}
