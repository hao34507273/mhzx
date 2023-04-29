/*    */ package mzm.gsp.qiuqian.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class QiuQianSuccess extends mzm.event.BasicEvent<QiuQianSuccessArg>
/*    */ {
/*  7 */   private static EventManager<QiuQianSuccessArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<QiuQianSuccessArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.children.guanyin.POnQiuQianSuccess());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qiuqian\event\QiuQianSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */