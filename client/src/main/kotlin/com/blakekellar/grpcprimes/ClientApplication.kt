package com.blakekellar.grpcprimes

import com.blakekellar.grpcprimes.proto.PrimesReply

fun main(args: Array<String>) {
    val client = PrimesClientImpl()
    val primes : PrimesReply? = client.getPrimes(50)

    var i = 0
    primes?.primesList?.forEach {
        println("prime[$i] = $it")
        i++
    }

}

