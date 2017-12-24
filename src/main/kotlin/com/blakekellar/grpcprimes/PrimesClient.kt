package com.blakekellar.grpcprimes

import com.blakekellar.grpcprimes.proto.PrimesReply

interface PrimesClient {
    fun getPrimes(numPrimes: Int): PrimesReply?
}