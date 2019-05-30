package com.zry.basemodule.component

/**
 * 组件未找到
 */
class AndroidComponentNotFoundException(msg: String) : IllegalStateException(msg)

/**
 * 组件已经存在
 */
class AndroidComponentAlreadyExistException(msg: String) : IllegalStateException(msg)
