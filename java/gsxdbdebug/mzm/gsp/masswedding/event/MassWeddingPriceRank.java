/*    */ package mzm.gsp.masswedding.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MassWeddingPriceRank extends mzm.event.BasicEvent<MassWeddingPriceRankArg>
/*    */ {
/*  7 */   private static EventManager<MassWeddingPriceRankArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MassWeddingPriceRankArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnMassWeddingPriceRank());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\event\MassWeddingPriceRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */