package uz.gita.placeimagegamenaj.domain

import uz.gita.placeimagegamenaj.data.ShapeData
import uz.gita.placeimagegamenaj.data.VoiceData

interface GameUseCase {
    fun getDataVoice(): List<VoiceData>
    fun getDataShape(): List<ShapeData>
}