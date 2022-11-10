package com.tom.demo.lock.redisson.service;

import com.tom.demo.lock.redisson.vo.UserVO;
import com.tom.lock.redisson.spring.boot.autoconfigure.LockAction;
import com.tom.lock.redisson.spring.boot.autoconfigure.LockType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class RedissonLockService {

	private final Logger logger = LoggerFactory.getLogger(RedissonLockService.class);
	
	@LockAction("'updateKey'")
	public void update(String key){
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			logger.error("exp", e);
		}
	}
	
	@LockAction("'test'.concat(#UserVO.id)")
	public void spel(UserVO userVO){
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			logger.error("exp", e);
		}
	}
	
	@LockAction(value = "#userVO.id", lockType = LockType.WRITE_LOCK, waitTime = 30000)
	public void update(UserVO userVO){
		logger.info("write user : {}", userVO.getId());
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			logger.error("exp", e);
		}
	}
	
	@LockAction(value = "#userVO.id", lockType = LockType.READ_LOCK, waitTime = 30000)
	public UserVO read(UserVO userVO) {
		logger.info("read user : {}", userVO.getId());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			logger.error("exp", e);
		}
		return userVO;
	}
}
