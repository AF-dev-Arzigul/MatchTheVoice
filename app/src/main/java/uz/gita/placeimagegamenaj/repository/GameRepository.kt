package uz.gita.placeimagegamenaj.repository

import uz.gita.placeimagegamenaj.data.ShapeData
import uz.gita.placeimagegamenaj.data.VoiceData

interface GameRepository {
    fun loadVoiceData(): List<VoiceData>
    fun loadShapeData(): List<ShapeData>
}