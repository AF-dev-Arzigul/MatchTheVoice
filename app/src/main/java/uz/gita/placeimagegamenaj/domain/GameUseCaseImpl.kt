package uz.gita.placeimagegamenaj.domain

import uz.gita.placeimagegamenaj.data.ShapeData
import uz.gita.placeimagegamenaj.data.VoiceData
import uz.gita.placeimagegamenaj.repository.GameRepository
import javax.inject.Inject

class GameUseCaseImpl @Inject constructor(private val repository: GameRepository) : GameUseCase {

    override fun getDataVoice(): List<VoiceData> = repository.loadVoiceData()

    override fun getDataShape(): List<ShapeData> = repository.loadShapeData()
}