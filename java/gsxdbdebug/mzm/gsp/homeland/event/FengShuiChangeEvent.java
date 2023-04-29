/*    */ package mzm.gsp.homeland.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FengShuiChangeEvent extends mzm.event.BasicEvent<FengShuiArg>
/*    */ {
/*  7 */   private static EventManager<FengShuiArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FengShuiArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnFengShuiChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\event\FengShuiChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */