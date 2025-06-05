package cn.microvideo.framework3.mvpd.mybatis.business.enterprise.runnable;

import cn.microvideo.framework3.mvpd.mybatis.business.enterprise.service.LockService;

public class LockRunnable implements Runnable{
    private LockService service;
    private String id;
    private String name;

    public LockRunnable(LockService service,String id, String name){
        this.service=service;
        this.id=id;
        this.name=name;
    }

    @Override
    public void run() {
        this.service.test(this.id, this.name );
    }
}
