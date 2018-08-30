package com.spring.factory;

import com.spring.bean.MysqlSequenceBo;
import com.spring.mapper.MysqlSequenceDAO;
import com.spring.repository.MysqlSequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by admin on 2018/8/28.
 */
@Component
public class MysqlSequenceFactory {
    private final Lock lock = new ReentrantLock();

    /**  */
    private Map<String,MysqlSequenceHolder> holderMap = new ConcurrentHashMap<>();

    @Autowired
    private MysqlSequenceDAO msqlSequenceDAO;

//    @Autowired
//    MysqlSequenceRepository mysqlSequenceRepository ;

    /** 单个sequence初始化乐观锁更新失败重试次数 */
    @Value("${seq.init.retry:5}")
    private int initRetryNum;
    /** 单个sequence更新序列区间乐观锁更新失败重试次数 */
    @Value("${seq.get.retry:20}")
    private int getRetryNum;

    @PostConstruct
    private void init(){
        //初始化所有sequence
        initAll();
    }


    /**
     * <p> 加载表中所有sequence，完成初始化 </p>
     * @return void
     * @author coderzl
     */
    private void initAll(){
        try {
            lock.lock();
//            List<MysqlSequenceBo> boList = mysqlSequenceRepository.findAll();
            List<MysqlSequenceBo> boList = msqlSequenceDAO.getAll();
            if (boList == null) {
                throw new IllegalArgumentException("The sequenceRecord is null!");
            }
            for (MysqlSequenceBo bo : boList) {
                MysqlSequenceHolder holder = new MysqlSequenceHolder(msqlSequenceDAO, bo,initRetryNum,getRetryNum);
                holder.init();
                holderMap.put(bo.getSeqName(), holder);
            }
        }finally {
            lock.unlock();
        }
    }


    /**
     * <p>  </p>
     * @param seqName
     * @return long
     * @author coderzl
     */
    public long getNextVal(String seqName){
        MysqlSequenceHolder holder = holderMap.get(seqName);
        if (holder == null) {
            try {
                lock.lock();
                holder = holderMap.get(seqName);
                if (holder != null){
                    return holder.getNextVal();
                }
//                MysqlSequenceBo bo = mysqlSequenceRepository.findBySeqName(seqName);
                MysqlSequenceBo bo =  msqlSequenceDAO.getSequence(seqName);
                holder = new MysqlSequenceHolder(msqlSequenceDAO, bo,initRetryNum,getRetryNum);
                holder.init();
                holderMap.put(seqName, holder);
            }finally {
                lock.unlock();
            }
        }
        return holder.getNextVal();
    }
}
