/*    */ package mzm.gsp.qingfu.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PresentYuanbao extends mzm.event.BasicEvent<PresentYuanbaoArg>
/*    */ {
/*  7 */   private static EventManager<PresentYuanbaoArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PresentYuanbaoArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.qingfu.main.POnUserPresentYuanbao());
/* 16 */     manager.register(new mzm.gsp.msdkprofile.main.POnUserPresentYuanbao());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnUserPresentYuanbao());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\event\PresentYuanbao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */