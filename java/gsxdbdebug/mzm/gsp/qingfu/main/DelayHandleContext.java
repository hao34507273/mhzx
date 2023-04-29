/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.qingfu.event.TssChangedArg.TssChangedInfo;
/*    */ 
/*    */ 
/*    */ public class DelayHandleContext
/*    */ {
/*  9 */   private ThreadLocal<Object> context = new ThreadLocal();
/*    */   
/*    */   public <T> void set(T value)
/*    */   {
/* 13 */     this.context.set(value);
/*    */   }
/*    */   
/*    */ 
/*    */   public Map<String, TssChangedArg.TssChangedInfo> getTssChangedInfoMap()
/*    */   {
/* 19 */     return (Map)get();
/*    */   }
/*    */   
/*    */   public Long getLong()
/*    */   {
/* 24 */     return (Long)get();
/*    */   }
/*    */   
/*    */   public Integer getInteger()
/*    */   {
/* 29 */     return (Integer)get();
/*    */   }
/*    */   
/*    */   public Short getShort()
/*    */   {
/* 34 */     return (Short)get();
/*    */   }
/*    */   
/*    */   private Object get()
/*    */   {
/* 39 */     return this.context.get();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\DelayHandleContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */