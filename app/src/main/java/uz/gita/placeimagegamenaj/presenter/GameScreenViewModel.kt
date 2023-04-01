package uz.gita.placeimagegamenaj.presenter

import uz.gita.placeimagegamenaj.data.ShapeData
import uz.gita.placeimagegamenaj.data.VoiceData


interface GameScreenViewModel {

    fun getShapeData(): List<ShapeData>
    fun getVoiceData(): List<VoiceData>

}