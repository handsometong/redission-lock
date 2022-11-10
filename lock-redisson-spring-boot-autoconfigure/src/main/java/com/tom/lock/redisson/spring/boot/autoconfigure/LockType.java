package com.tom.lock.redisson.spring.boot.autoconfigure;

/**  
 * @author handsometong
 * @date 2022年11月9日 上午11:25:59
 * @version 1.0.0
 */
public enum LockType {

	/** 可重入锁*/
	REENTRANT_LOCK,
	
	/** 公平锁*/
	FAIR_LOCK,
	
	/** 读锁*/
	READ_LOCK,
	
	/** 写锁*/
	WRITE_LOCK;
}
