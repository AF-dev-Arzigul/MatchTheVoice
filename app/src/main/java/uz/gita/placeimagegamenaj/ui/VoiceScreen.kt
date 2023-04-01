package uz.gita.placeimagegamenaj.ui

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.placeimagegamenaj.LocalData
import uz.gita.placeimagegamenaj.R
import uz.gita.placeimagegamenaj.data.VoiceData
import uz.gita.placeimagegamenaj.databinding.ScreenVoiceBinding
import uz.gita.placeimagegamenaj.presenter.GameScreenViewModel
import uz.gita.placeimagegamenaj.presenter.GameScreenViewModelImpl
import uz.gita.placeimagegamenaj.utils.ExplosionField

@AndroidEntryPoint
class VoiceScreen : Fragment(R.layout.screen_voice) {
    private val binding: ScreenVoiceBinding by viewBinding(ScreenVoiceBinding::bind)
    private val viewModel: GameScreenViewModel by viewModels<GameScreenViewModelImpl>()
    private var list1 = listOf<VoiceData>()
    private var list2 = listOf<VoiceData>()
    private lateinit var player: MediaPlayer
    private lateinit var time: CountDownTimer

    private var isWin = 0

    var firstSelectedItem: VoiceData? = null
    var secondSelectedItem: VoiceData? = null
    var cardSelectedItem: CardView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadData()
        loadView()
        startProgressBar()
        setCoinAndLevel()
        animation()
    }

    private fun animation() {
        binding.backBtn.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                shakeView(binding.backBtn)
                delay(200)
                findNavController().navigateUp()
            }
        }

        binding.level.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                shakeView(binding.level)
            }
        }

        binding.voices.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                shakeView(binding.voices)
            }
        }

        binding.images.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                shakeView(binding.images)
            }
        }

        binding.llCoin.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                shakeView(binding.llCoin)
//                shakeView(binding.coins)
//                shakeView(binding.tvCoins)
            }
        }

    }

    private fun setCoinAndLevel() {
        binding.level.text = "Level ${LocalData.getLevel()}"
        binding.tvCoins.text = LocalData.coin().toString()
    }

    private fun startProgressBar() {

        binding.progressBar.max = 70000

        viewLifecycleOwner.lifecycleScope.launch {
            time = object : CountDownTimer(70000, 2) {
                override fun onTick(millisUntilFinished: Long) {
                    binding.progressBar.progress = millisUntilFinished.toInt()
                }

                override fun onFinish() {
                    findNavController().navigate(VoiceScreenDirections.actionVoiceScreenToGameOverScreen())
                }
            }.start()
        }
    }

    private fun loadView() {
        lifecycleScope.launch {
            openView(binding.cardFirstS, binding.ivFirstS, list2[0])
            openView(binding.cardSecondS, binding.ivSecondS, list2[1])
            openView(binding.cardThirdS, binding.ivThirdS, list2[2])
            openView(binding.cardFourS, binding.ivFourS, list2[3])

            delay(2000)

            closeView(binding.cardFirstS, binding.ivFirstS)
            closeView(binding.cardSecondS, binding.ivSecondS)
            closeView(binding.cardThirdS, binding.ivThirdS)
            closeView(binding.cardFourS, binding.ivFourS)

            delay(1000)
        }

        binding.cardFirst.setOnClickListener {
            clickableFirstFalse()
            openMusicView(binding.cardFirst, binding.ivFirst, list1[0])
            player = MediaPlayer.create(requireContext(), list1[0].voice)
            player.start()

            if (secondSelectedItem == null) {
                cardSelectedItem = binding.cardFirst
                firstSelectedItem = list1[0]
            } else {
                firstSelectedItem = list1[0]
                checkResult(
                    firstSelectedItem!!,
                    secondSelectedItem!!,
                    cardSelectedItem!!,
                    binding.cardFirst
                )
            }

        }

        binding.cardSecond.setOnClickListener {
            clickableFirstFalse()
            openMusicView(binding.cardSecond, binding.ivSecond, list1[1])
            player = MediaPlayer.create(requireContext(), list1[1].voice)
            player.start()

            if (secondSelectedItem == null) {
                cardSelectedItem = binding.cardSecond
                firstSelectedItem = list1[1]
            } else {
                firstSelectedItem = list1[1]
                checkResult(
                    firstSelectedItem!!,
                    secondSelectedItem!!,
                    cardSelectedItem!!,
                    binding.cardSecond
                )
            }

        }

        binding.cardThird.setOnClickListener {
            clickableFirstFalse()
            openMusicView(binding.cardThird, binding.ivThird, list1[2])
            player = MediaPlayer.create(requireContext(), list1[2].voice)
            player.start()

            if (secondSelectedItem == null) {
                cardSelectedItem = binding.cardThird
                firstSelectedItem = list1[2]
            } else {
                firstSelectedItem = list1[2]
                checkResult(
                    firstSelectedItem!!,
                    secondSelectedItem!!,
                    cardSelectedItem!!,
                    binding.cardThird
                )
            }

        }

        binding.cardFour.setOnClickListener {
            clickableFirstFalse()
            openMusicView(binding.cardFour, binding.ivFour, list1[3])
            player = MediaPlayer.create(requireContext(), list1[3].voice)
            player.start()

            if (secondSelectedItem == null) {
                cardSelectedItem = binding.cardFour
                firstSelectedItem = list1[3]
            } else {
                firstSelectedItem = list1[3]
                checkResult(
                    firstSelectedItem!!,
                    secondSelectedItem!!,
                    cardSelectedItem!!,
                    binding.cardFour
                )
            }

        }

        binding.cardFirstS.setOnClickListener {
            clickableSecondFalse()
            openView(binding.cardFirstS, binding.ivFirstS, list2[0])

            secondSelectedItem = list2[0]

            if (firstSelectedItem != null) {
                checkResult(
                    firstSelectedItem!!,
                    secondSelectedItem!!,
                    cardSelectedItem!!,
                    binding.cardFirstS
                )
            } else {
                cardSelectedItem = binding.cardFirstS
                secondSelectedItem = list2[0]
            }

        }

        binding.cardSecondS.setOnClickListener {
            clickableSecondFalse()
            openView(binding.cardSecondS, binding.ivSecondS, list2[1])

            secondSelectedItem = list2[1]

            if (firstSelectedItem != null) {
                checkResult(
                    firstSelectedItem!!,
                    secondSelectedItem!!,
                    cardSelectedItem!!,
                    binding.cardSecondS
                )
            } else {
                cardSelectedItem = binding.cardSecondS
                secondSelectedItem = list2[1]
            }

        }

        binding.cardThirdS.setOnClickListener {
            clickableSecondFalse()
            openView(binding.cardThirdS, binding.ivThirdS, list2[2])

            secondSelectedItem = list2[2]

            if (firstSelectedItem != null) {
                checkResult(
                    firstSelectedItem!!,
                    secondSelectedItem!!,
                    cardSelectedItem!!,
                    binding.cardThirdS
                )
            } else {
                cardSelectedItem = binding.cardThirdS
                secondSelectedItem = list2[2]
            }

        }

        binding.cardFourS.setOnClickListener {
            clickableSecondFalse()
            openView(binding.cardFourS, binding.ivFourS, list2[3])

            secondSelectedItem = list2[3]

            if (firstSelectedItem != null) {
                checkResult(
                    firstSelectedItem!!,
                    secondSelectedItem!!,
                    cardSelectedItem!!,
                    binding.cardFourS
                )
            } else {
                cardSelectedItem = binding.cardFourS
                secondSelectedItem = list2[3]
            }

        }
    }

    private fun loadData() {
        list1 = viewModel.getVoiceData()
        list2 = list1.shuffled()
    }

    override fun onPause() {
        time.cancel()
        super.onPause()
    }

    private fun checkResult(item1: VoiceData, item2: VoiceData, v1: CardView, v2: CardView) {
        lifecycleScope.launch {
            if (item1.id == item2.id) {
                delay(1000)
                val mExplosionField = ExplosionField.attach2Window(activity)
                mExplosionField.explode(v1)
                mExplosionField.explode(v2)
                v1.visibility = View.INVISIBLE
                v2.visibility = View.INVISIBLE

                delay(500)
                player.stop()

                isWin++
                if (isWin == 4) {
                    delay(500)
                    isWin = 0
                    findNavController().navigate(VoiceScreenDirections.actionVoiceScreenToGameWinScreen())
                }

            } else {
                delay(1000)
                closeMusicView(v1, v1.children.first() as ImageView)
                closeView(v2, v2.children.first() as ImageView)

                delay(500)
                player.stop()
            }

            clickableFirstTrue()
            clickableSecondTrue()

            firstSelectedItem = null
            secondSelectedItem = null
            cardSelectedItem = null

        }
    }

    private fun clickableFirstFalse() {
        binding.cardFirst.isClickable = false
        binding.cardSecond.isClickable = false
        binding.cardThird.isClickable = false
        binding.cardFour.isClickable = false
    }

    private fun clickableFirstTrue() {
        binding.cardFirst.isClickable = true
        binding.cardSecond.isClickable = true
        binding.cardThird.isClickable = true
        binding.cardFour.isClickable = true
    }

    private fun clickableSecondFalse() {
        binding.cardFirstS.isClickable = false
        binding.cardSecondS.isClickable = false
        binding.cardThirdS.isClickable = false
        binding.cardFourS.isClickable = false
    }

    private fun clickableSecondTrue() {
        binding.cardFirstS.isClickable = true
        binding.cardSecondS.isClickable = true
        binding.cardThirdS.isClickable = true
        binding.cardFourS.isClickable = true
    }

    private fun closeMusicView(animateView: CardView, imageView: ImageView) {
        animateView.animate()
            .setDuration(500)
            .rotationY(90f)
            .withEndAction {
                imageView.setImageResource(R.drawable.card)
                animateView.animate()
                    .setDuration(200)
                    .rotationY(0f)
                    .withEndAction {

                    }.start()
            }.start()

    }

    private fun openMusicView(animateView: CardView, imageView: ImageView, item: VoiceData) {
        animateView.animate()
            .setDuration(500)
            .rotationY(90f)
            .withEndAction {
                imageView.setImageResource(R.drawable.card_back)
                animateView.animate()
                    .setDuration(200)
                    .rotationY(180f)
                    .withEndAction {

                    }.start()
            }.start()

    }

    private fun closeView(animateView: CardView, imageView: ImageView) {
        animateView.animate()
            .setDuration(500)
            .rotationY(90f)
            .withEndAction {
                imageView.setImageResource(R.drawable.card)
                animateView.animate()
                    .setDuration(200)
                    .rotationY(0f)
                    .withEndAction {

                    }.start()
            }.start()
    }

    private fun openView(animateView: CardView, imageView: ImageView, item: VoiceData) {
        animateView.animate()
            .setDuration(500)
            .rotationY(90f)
            .withEndAction {
                imageView.setImageResource(item.imageReal)
                animateView.animate()
                    .setDuration(200)
                    .rotationY(180f)
                    .withEndAction {

                    }.start()
            }.start()

    }

    private fun shakeView(view: View) {
        view.animate()
            .setDuration(50)
            .xBy(8f)
            .withEndAction {
                view.animate()
                    .setDuration(50)
                    .xBy(-8f)
                    //.setInterpolator(DecelerateInterpolator())
//                    .withEndAction {
//                        view.animate()
//                            .setDuration(50)
//                            .xBy(16f)
//                            .withEndAction {
//                                view.animate()
//                                    .setDuration(50)
//                                    .xBy(-8f)
//                                    .start()
//                            }
//                            .start()
//                    }
                    .start()
            }
            .start()
    }

}