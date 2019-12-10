package com.musheng.base;


import com.musheng.util.Logger;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseMvpView> {
        private V mMvpView;
        protected ArrayList<BaseModel> models = new ArrayList<>();

        public void bind(V v){
            this.mMvpView = v;
        }
        public BasePresenter(){//当创建p层对象的时候，会调用m层请求网络数据
                initModel();
        }

    protected abstract void initModel();

    public void onDestroy(){
        //打断M层与P层的关系
        mMvpView = null;
        //切断网络请求
        if (models != null && models.size() > 0 ){
            Logger.DebugLogger("models:的数量 "+models.size() );
//            for (BaseModel model : models) {
//                model.onDestroy();
//            }
            models.clear();//请求集合
        }

    }

}
