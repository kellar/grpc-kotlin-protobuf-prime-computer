package com.blakekellar.grpcprimes

interface PrimesServer {
    fun start()
    fun blockUntilShutdown()
}