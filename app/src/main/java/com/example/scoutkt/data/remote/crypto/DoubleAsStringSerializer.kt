package com.example.scoutkt.data.remote.crypto

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object DoubleAsStringSerializer : KSerializer<Double> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("MyConverter", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Double {
        val string = decoder.decodeString()
        return string.toDoubleOrNull() ?: 0.0
    }

    override fun serialize(encoder: Encoder, value: Double) {
        encoder.encodeString(value.toString())
    }
}
