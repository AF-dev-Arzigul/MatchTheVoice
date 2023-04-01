package uz.gita.placeimagegamenaj.presenter

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.placeimagegamenaj.data.ShapeData
import uz.gita.placeimagegamenaj.data.VoiceData
import uz.gita.placeimagegamenaj.domain.GameUseCase
import javax.inject.Inject

@HiltViewModel
class GameScreenViewModelImpl @Inject constructor(private val useCase: GameUseCase) :
    GameScreenViewModel, ViewModel() {

    override fun getShapeData(): List<ShapeData> = useCase.getDataShape()

    override fun getVoiceData(): List<VoiceData> = useCase.getDataVoice()

}