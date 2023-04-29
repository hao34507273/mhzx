/*    */ package mzm.gsp.masswedding.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MassWeddingJoin extends mzm.event.BasicEvent<MassWeddingJoinArg>
/*    */ {
/*  7 */   private static EventManager<MassWeddingJoinArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MassWeddingJoinArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnMassWeddingJoin());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\event\MassWeddingJoin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */