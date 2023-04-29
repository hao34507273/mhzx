/*    */ package mzm.gsp.award.gem;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AddCountRes
/*    */ {
/*    */   private final boolean needAward;
/*    */   
/*    */ 
/*    */ 
/*    */   private final CountInfoCopy snap;
/*    */   
/*    */ 
/*    */ 
/*    */   public AddCountRes(long gemKey, int count, int awardNum, long startTime, boolean isAward, int curCircle, boolean needAward)
/*    */   {
/* 18 */     this.needAward = needAward;
/* 19 */     this.snap = new CountInfoCopy(gemKey, count, awardNum, startTime, isAward, curCircle);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isNeedAward()
/*    */   {
/* 29 */     return this.needAward;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public CountInfoCopy getSnap()
/*    */   {
/* 39 */     return this.snap;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gem\AddCountRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */