package com.blakekellar.grpcprimes

fun main(args: Array<String>) {
    val server = PrimesServerImpl()
    server.start()
    server.blockUntilShutdown()
}

