/*   */ package mzm.event.mbeans;
/*   */ 
/*   */ public abstract class BasicMXBean {
/*   */   public BasicMXBean() {
/* 5 */     MBeanManager.getInstance().registerToManager(getClass().getName(), this);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\mbeans\BasicMXBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */