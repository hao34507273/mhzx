/*    */ package mzm.gsp.wing.main2;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import xbean.WingPlan;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleWingCheckData
/*    */ {
/*    */   private WingPlan xWingPlan;
/*    */   
/*    */   public RoleWingCheckData(WingPlan xWingPlan)
/*    */   {
/* 17 */     this.xWingPlan = xWingPlan;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getCurRank()
/*    */   {
/* 27 */     return this.xWingPlan.getCurrank();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getCurLv()
/*    */   {
/* 37 */     return this.xWingPlan.getCurlv();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getCurWingId()
/*    */   {
/* 47 */     return this.xWingPlan.getCurwing();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Set<Integer> getAllOwnWingIds()
/*    */   {
/* 57 */     return this.xWingPlan.getWings().keySet();
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
/*    */   public boolean ownWing(int wingId)
/*    */   {
/* 70 */     return this.xWingPlan.getWings().containsKey(Integer.valueOf(wingId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\RoleWingCheckData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */