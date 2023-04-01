package uz.gita.placeimagegamenaj.repository


import uz.gita.placeimagegamenaj.R
import uz.gita.placeimagegamenaj.data.ShapeData
import uz.gita.placeimagegamenaj.data.VoiceData
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor() :
    GameRepository {

    private val voiceData = ArrayList<VoiceData>()
    private val shapeData = ArrayList<ShapeData>()

    init {
        voiceData.add(VoiceData(1, R.raw.snake, R.drawable.snake))
        voiceData.add(VoiceData(2, R.raw.bird, R.drawable.bird))
        voiceData.add(VoiceData(3, R.raw.kangaroo, R.drawable.kangaroo))
        voiceData.add(VoiceData(4, R.raw.cow, R.drawable.cow))
//        voiceData.add(VoiceData(5, 0, R.drawable.sloth))
        voiceData.add(VoiceData(6, R.raw.hippo, R.drawable.hippo))
        voiceData.add(VoiceData(7, R.raw.fish, R.drawable.fish))
        voiceData.add(VoiceData(8, R.raw.penguin, R.drawable.penguin))
        voiceData.add(VoiceData(9, R.raw.tiger, R.drawable.tiger))
        voiceData.add(VoiceData(10, R.raw.bear, R.drawable.bear))
        voiceData.add(VoiceData(11, R.raw.camel, R.drawable.camel))
//        voiceData.add(VoiceData(12, 0, R.drawable.rabbit))
//        voiceData.add(VoiceData(13, 0, R.drawable.shark))
        voiceData.add(VoiceData(14, R.raw.elephant, R.drawable.elephant))
        voiceData.add(VoiceData(15, R.raw.gorilla, R.drawable.gorilla))
        voiceData.add(VoiceData(16, R.raw.bee, R.drawable.bee))
        voiceData.add(VoiceData(17, R.raw.crocodile, R.drawable.crocodile))
        voiceData.add(VoiceData(18, R.raw.owl, R.drawable.owl))
        voiceData.add(VoiceData(19, R.raw.cat, R.drawable.cat))
        voiceData.add(VoiceData(20, R.raw.dog, R.drawable.dog))
        voiceData.add(VoiceData(21, R.raw.lion, R.drawable.lion))
        voiceData.add(VoiceData(22, R.raw.panda, R.drawable.panda))
        voiceData.add(VoiceData(23, R.raw.zebra, R.drawable.zebra))
//        voiceData.add(VoiceData(24, 0, R.drawable.tortoise))
        voiceData.add(VoiceData(25, R.raw.rooster, R.drawable.ruster))
        voiceData.add(VoiceData(26, R.raw.dolphin, R.drawable.delphin))


        shapeData.add(ShapeData(1, R.drawable.baqlajon, R.drawable.baqlajon_back))
        shapeData.add(ShapeData(2, R.drawable.behi, R.drawable.behi_back))
        shapeData.add(ShapeData(3, R.drawable.bouling_ball, R.drawable.bouling_ball_back))
        shapeData.add(ShapeData(4, R.drawable.pumpkin, R.drawable.pumpkin_back))
        shapeData.add(ShapeData(5, R.drawable.apple, R.drawable.apple_back))
        shapeData.add(ShapeData(6, R.drawable.carrot, R.drawable.carrot_back))
        shapeData.add(ShapeData(7, R.drawable.noxot, R.drawable.noxot_back))
        shapeData.add(ShapeData(8, R.drawable.jenshen, R.drawable.jenshen_back))
        shapeData.add(ShapeData(9, R.drawable.leaves, R.drawable.leaves_back))
        shapeData.add(ShapeData(10, R.drawable.joxori, R.drawable.joxori_back))
        shapeData.add(ShapeData(11, R.drawable.potato, R.drawable.potato_back))
        shapeData.add(ShapeData(12, R.drawable.egg, R.drawable.egg_back))
        shapeData.add(ShapeData(13, R.drawable.tomato, R.drawable.tomato_back))
        shapeData.add(ShapeData(14, R.drawable.sholgom, R.drawable.sholgom_back))
        shapeData.add(ShapeData(15, R.drawable.bita, R.drawable.bita_back))
        shapeData.add(ShapeData(16, R.drawable.tennis_ball, R.drawable.tennis_ball_back))
        shapeData.add(ShapeData(17, R.drawable.tennis_tayaq, R.drawable.tennis_tayaq_back))
        shapeData.add(ShapeData(18, R.drawable.baseball, R.drawable.baseball_back))
        shapeData.add(ShapeData(19, R.drawable.tosh, R.drawable.tosh_back))
        shapeData.add(ShapeData(20, R.drawable.qolqop, R.drawable.gloves))
        shapeData.add(ShapeData(21, R.drawable.bouling, R.drawable.bouling_back))
        shapeData.add(ShapeData(22, R.drawable.tennis, R.drawable.tennis_back))
        shapeData.add(ShapeData(23, R.drawable.little_ball, R.drawable.little_ball_back))
        shapeData.add(ShapeData(24, R.drawable.strawberry, R.drawable.strawberry_back))
    }

    override fun loadVoiceData(): List<VoiceData> {
        voiceData.shuffle()
        return voiceData.subList(0, 4)
    }

    override fun loadShapeData(): List<ShapeData> {
        shapeData.shuffle()
        return shapeData
    }

}