/**
 * 1、注意事项，在上述修改JavaBean属性的时候，如果数据类型不对的话，会报错。
 * 例如BeanInfoUtil.setProperty(userInfo, “age”);报错是应为age属性是int数据类型，
 * 而setProperty方法里面默认给age属性赋的值是String类型。
 * 所以会爆出argument type mismatch参数类型不匹配的错误信息。 
 * 为了解决上述问题，Apache开发了一套简单、易用的API来操作Bean的属性——BeanUtils工具包。 
 * BeanUtils工具包：下载：http://commons.apache.org/beanutils/　
 * 注意：应用的时候还需要一个logging包http://commons.apache.org/logging/
 * 
 
 2、Spring BeanUtils.copyProperties和apache commons-beanutils
