/*    */ package mzm.gsp.mounts.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MountsRankUp extends mzm.event.BasicEvent<MountsRankUpArg>
/*    */ {
/*  7 */   private static EventManager<MountsRankUpArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MountsRankUpArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnMountsRankUp());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\event\MountsRankUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */