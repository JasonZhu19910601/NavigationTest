package com.leading.navigationtest


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass.
 *
 */
class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn.setOnClickListener {
            //            activity?.let { it1 -> Navigation.findNavController(it1,R.id.btn).navigate(R.id.first_frag_to_second_frag) }
            //            getView()?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.first_frag_to_second_frag) }
//            NavHostFragment.findNavController(this).navigate(R.id.first_frag_to_second_frag)
//            val bundle = Bundle()
//            bundle.putString("key", "info from first frag")
//            NavHostFragment.findNavController(this).navigate(R.id.first_frag_to_second_frag,bundle)

            // 类型安全的传递参数
            val secondFragmentArgs = SecondFragmentArgs.Builder(true, 66666,
                    6, 6.6f, "safe info").build()
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_first_frag_to_second_frag, secondFragmentArgs.toBundle())
        }

        // 从动态加载的navGraph中获取数据
        val firstFragmentArgs = FirstFragmentArgs.fromBundle(arguments)
        val data = firstFragmentArgs.data
        Toast.makeText(context, data, Toast.LENGTH_SHORT).show()
    }
}
