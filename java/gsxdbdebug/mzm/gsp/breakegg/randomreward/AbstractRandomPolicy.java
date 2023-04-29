/*    */ package mzm.gsp.breakegg.randomreward;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractRandomPolicy<T extends IRandomPolicyArgs>
/*    */ {
/*    */   protected final int groupId;
/*    */   protected final T arg;
/*    */   
/*    */   public AbstractRandomPolicy(int groupId, T arg)
/*    */   {
/* 19 */     this.groupId = groupId;
/* 20 */     this.arg = arg;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public abstract List<Integer> getRewardInfoIds(int paramInt, boolean paramBoolean);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getRewardInfoId(boolean forShow)
/*    */   {
/* 43 */     List<Integer> ewardInfoIds = getRewardInfoIds(1, forShow);
/* 44 */     if ((ewardInfoIds == null) || (ewardInfoIds.size() <= 0))
/*    */     {
/* 46 */       return -1;
/*    */     }
/* 48 */     return ((Integer)ewardInfoIds.get(0)).intValue();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\randomreward\AbstractRandomPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */