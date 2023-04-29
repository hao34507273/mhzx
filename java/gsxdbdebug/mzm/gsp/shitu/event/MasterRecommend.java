/*    */ package mzm.gsp.shitu.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MasterRecommend extends mzm.event.BasicEvent<MasterRecommendArg>
/*    */ {
/*  7 */   private static EventManager<MasterRecommendArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MasterRecommendArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.guide.main.POnMasterRecommend());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\event\MasterRecommend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */