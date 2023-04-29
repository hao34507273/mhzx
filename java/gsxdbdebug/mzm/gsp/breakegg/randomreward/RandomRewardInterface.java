/*    */ package mzm.gsp.breakegg.randomreward;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RandomRewardInterface
/*    */ {
/*    */   public static AbstractRandomPolicy<?> getRandomPolicy(int groupId, IRandomPolicyArgs args)
/*    */   {
/* 15 */     return RandomRewardManager.getRandomPolicy(groupId, args);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\randomreward\RandomRewardInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */