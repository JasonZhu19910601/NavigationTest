package com.leading.navigationtest


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // // 传统类型的传递参数
        //        val info = arguments?.getString("key")
//        Toast.makeText(context,info,Toast.LENGTH_SHORT).show()
        // 类型安全的传递参数
        val fromBundle = SecondFragmentArgs.fromBundle(arguments)
        val booleanData = fromBundle.booleanData
        val floatData = fromBundle.floatData
        val intData = fromBundle.intData
        val stringData = fromBundle.stringData
        val longData = fromBundle.longData

        val text = tv.text
        val stringBuilder = StringBuilder()
        stringBuilder.append(text)
                .append("\n")
                .append(booleanData)
                .append("\n")
                .append(floatData)
                .append("\n")
                .append(intData)
                .append("\n")
                .append(stringData)
                .append("\n")
                .append(longData)
        tv.text = stringBuilder.toString()

        btn.setOnClickListener { getView()?.let {
//            it1 -> Navigation.findNavController(it1).navigateUp()
            it1 -> Navigation.findNavController(it1).navigate(R.id.action_second_frag_to_third_frag)
        } }
    }
}
