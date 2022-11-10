# redission-lock
基于redission的分布式锁

**使用方法:**

直接在方法上增加 @LockAction注解 （支持spring El表达式）

```
	LockAction("'test'.concat(#user.id)")
	public void update(UserVO user){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			logger.error("exp", e);
		}
	}
```
