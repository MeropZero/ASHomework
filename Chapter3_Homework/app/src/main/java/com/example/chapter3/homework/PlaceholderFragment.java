package com.example.chapter3.homework;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;

public class PlaceholderFragment extends Fragment {

    private View view;
    private SimpleAdapter simpleAdapter;
    private ListView listView;
    private LottieAnimationView animationView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        view = inflater.inflate(R.layout.fragment_placeholder, container,false);
        listView = view.findViewById(R.id.list);
        animationView = view.findViewById(R.id.loading);
        simpleAdapter = new SimpleAdapter(getActivity(), getData(), R.layout.item, new String[]{"title", "image"}, new int[]{R.id.name,R.id.iamge});
        listView.setAdapter(simpleAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(animationView,"alpha",1f,0f);
                animator1.setDuration(1000);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(listView,"alpha",0f,1f);
                animator2.setDuration(1000);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator1,animator2);
                animatorSet.start();
            }
        }, 5000);
    }

    private List<Map<String,Object>> getData() {
        String [] titles={"1 Marry", "2 John", "3 Kate", "4 Kelly", "5 Alex", "6 Jack", "7 Zoey", "8 Bob", "9 Danny", "10 Petty"};
        int [] images={R.drawable.image_0,R.drawable.image_1,R.drawable.image_2,R.drawable.image_3,R.drawable.image_4,R.drawable.image_5,R.drawable.image_6,R.drawable.image_7,R.drawable.image_8,R.drawable.image_9};
        List<Map<String,Object>> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Map map = new HashMap();
            map.put("title", titles[i]);
            map.put("image", images[i]);
            list.add(map);
        }
        return list;
    }
}
