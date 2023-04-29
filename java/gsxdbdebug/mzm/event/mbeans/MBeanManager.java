/*    */ package mzm.event.mbeans;
/*    */ 
/*    */ import java.util.Map;
/*    */ 
/*    */ public class MBeanManager
/*    */ {
/*  7 */   private static MBeanManager instance = new MBeanManager();
/*    */   
/*  9 */   public static MBeanManager getInstance() { return instance; }
/*    */   
/*    */ 
/* 12 */   Map<String, Object> objs = new java.util.TreeMap();
/*    */   
/*    */   public void registerToManager(String name, Object obj) {
/* 15 */     register(obj, name);
/* 16 */     this.objs.put(name, obj);
/*    */   }
/*    */   
/*    */   public Object getObjectByName(String name) {
/* 20 */     return this.objs.get(name);
/*    */   }
/*    */   
/*    */   private void register(Object obj, String name) {
/*    */     try {
/* 25 */       javax.management.MBeanServer server = java.lang.management.ManagementFactory.getPlatformMBeanServer();
/* 26 */       server.registerMBean(obj, getObjName(name));
/*    */     } catch (Throwable e) {
/* 28 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */   
/*    */   private javax.management.ObjectName getObjName(String name) {
/*    */     try {
/* 34 */       return new javax.management.ObjectName("mz:type=gsp,name=" + name);
/*    */     }
/*    */     catch (Throwable e) {
/* 37 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\mbeans\MBeanManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */