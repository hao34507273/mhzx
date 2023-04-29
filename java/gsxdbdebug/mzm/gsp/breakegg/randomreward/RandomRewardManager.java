/*    */ package mzm.gsp.breakegg.randomreward;
/*    */ 
/*    */ import mzm.gsp.nationalholiday.confbean.SRewardRandomCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RandomRewardManager
/*    */ {
/*    */   static AbstractRandomPolicy<?> getRandomPolicy(int groupId, IRandomPolicyArgs args)
/*    */   {
/* 19 */     SRewardRandomCfg sRewardRandomCfg = SRewardRandomCfg.get(groupId);
/* 20 */     if (sRewardRandomCfg == null)
/*    */     {
/* 22 */       return null;
/*    */     }
/* 24 */     switch (sRewardRandomCfg.randomType)
/*    */     {
/*    */     case 1: 
/* 27 */       return new RandomAny(groupId);
/*    */     }
/* 29 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\randomreward\RandomRewardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */