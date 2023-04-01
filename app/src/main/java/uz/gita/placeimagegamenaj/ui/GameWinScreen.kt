package uz.gita.placeimagegamenaj.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.placeimagegamenaj.LocalData
import uz.gita.placeimagegamenaj.R
import uz.gita.placeimagegamenaj.databinding.ScreenGameWinBinding

class GameWinScreen : Fragment(R.layout.screen_game_win) {
    private val binding: ScreenGameWinBinding by viewBinding(ScreenGameWinBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        LocalData.coin(LocalData.coin() + 10)
        LocalData.levelUp()

        binding.okBtn.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                shakeView(binding.okBtn)
                delay(200)
                findNavController().navigateUp()
            }
        }

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