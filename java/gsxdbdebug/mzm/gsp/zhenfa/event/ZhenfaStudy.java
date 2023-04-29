/*    */ package mzm.gsp.zhenfa.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ZhenfaStudy extends mzm.event.BasicEvent<ZhenfaStudyArg>
/*    */ {
/*  7 */   private static EventManager<ZhenfaStudyArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ZhenfaStudyArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnZhenFaStudy());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\event\ZhenfaStudy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */