package com.blakekellar.grpcprimes

import io.grpc.Server
import io.grpc.ServerBuilder

class PrimesServerImpl(private val port: Int = 50051) : PrimesServer {

    private var server: Server? = null

    override fun start() {
        server = ServerBuilder.forPort(port).addService(PrimeServiceImpl()).build().start()
    }

    override fun blockUntilShutdown() {
        if (server != null) {
            server!!.awaitTermination()
        }
    }
}

