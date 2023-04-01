package uz.gita.placeimagegamenaj.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.placeimagegamenaj.R
import uz.gita.placeimagegamenaj.databinding.ScreenHomeBinding

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.screen_home) {
    private val binding: ScreenHomeBinding by viewBinding(ScreenHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnInfo.setOnClickListener {
            lifecycleScope.launch {
                zoomInOut(binding.btnInfo)
                delay(200)
                findNavController().navigate(HomeScreenDirections.actionHomeScreenToInfoScreen())
            }
        }

        binding.btnMatchTheShapes.setOnClickListener {
            findNavController().navigate(HomeScreenDirections.actionHomeScreenToShapeScreen())
        }

        binding.btnMatchTheVoices.setOnClickListener {
            lifecycleScope.launch {
                zoomInOut(binding.btnMatchTheVoices)
                delay(200)
                findNavController().navigate(HomeScreenDirections.actionHomeScreenToVoiceScreen())
            }
        }

        binding.btnSolveTheProblem.setOnClickListener {
            findNavController().navigate(HomeScreenDirections.actionHomeScreenToProblemScreen())
        }

//        butterFlyAnimation()
//        yellowButterFlyAnimation()

    }

    private fun butterFlyAnimation() {
        viewLifecycleOwner.lifecycleScope.launch {
            binding.animationBeautifulButterfly.x = 0f
            binding.animationBeautifulButterfly.y = 0f
            binding.animationBeautifulButterfly.rotation = 125f
            binding.animationBeautifulButterfly.animate().xBy(1200f).yBy(1200f).setDuration(10000)
                .withEndAction {
                    binding.animationBeautifulButterfly.rotation = 45f
                    binding.animationBeautifulButterfly.animate().yBy(-1200f).xBy(1200f)
                        .setDuration(10000).withEndAction {
                            butterFlyAnimation()
                        }.start()
                }.start()
        }
    }

    private fun yellowButterFlyAnimation() {
        viewLifecycleOwner.lifecycleScope.launch {
            binding.animationBeautifulButterfly.x = 0f
            binding.animationBeautifulButterfly.y = 0f
            binding.animationYellowButterfly.rotation = 90f
            binding.animationYellowButterfly.animate().xBy(2300f).setDuration(20000).withEndAction {
                binding.animationYellowButterfly.rotation = -90f
                binding.animationYellowButterfly.animate().xBy(-2300f).setDuration(20000)
                    .withEndAction {
                        yellowButterFlyAnimation()
                    }.start()
            }.start()
        }
    }

    private fun zoomInOut(view: View) {
        view.animate()
            .setDuration(50)
            .scaleX(1.2f)
            .scaleY(1.2f)
            .withEndAction {
                view.animate()
                    .setDuration(50)
                    .scaleX(1f)
                    .scaleY(1f)
                    .start()
            }
            .start()
    }

    private fun shakeView(view: View) {
        view.animate()
            .setDuration(50)
            .xBy(8f)
            .withEndAction {
                view.animate()
                    .setDuration(50)
                    .xBy(-16f)
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