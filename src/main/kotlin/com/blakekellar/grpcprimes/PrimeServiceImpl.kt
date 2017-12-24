package com.blakekellar.grpcprimes

import com.blakekellar.grpcprimes.proto.PrimesGrpc
import com.blakekellar.grpcprimes.proto.PrimesReply
import com.blakekellar.grpcprimes.proto.PrimesRequest
import io.grpc.stub.StreamObserver

// naive implementation
class PrimeServiceImpl : PrimesGrpc.PrimesImplBase() {

    private fun isPrime(candidate: Int): Boolean {
        var i = 2
        while (i < Math.sqrt(candidate.toDouble()) + 1) {
            if (candidate % i == 0) {
                return false
            }
            i += 1
        }
        return true
    }

    override fun getPrimes(req: PrimesRequest, responseObserver: StreamObserver<PrimesReply>) {
        val primes = mutableListOf<Int>()
        var candidate = 3
        var foundPrimes = 0
        while (foundPrimes < req.numPrimes) {
            if (isPrime(candidate)) {
                primes.add(candidate)
                foundPrimes++
            }
            candidate++
        }
        val reply = PrimesReply.newBuilder().addAllPrimes(primes).build()
        responseObserver.onNext(reply)
        responseObserver.onCompleted()
    }
}