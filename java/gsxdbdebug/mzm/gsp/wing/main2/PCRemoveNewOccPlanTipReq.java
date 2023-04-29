/*    */ package mzm.gsp.wing.main2;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.AllWingPlans;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCRemoveNewOccPlanTipReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCRemoveNewOccPlanTipReq(long roleId)
/*    */   {
/* 17 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     RoleWingInfo roleWingInfo = new RoleWingInfo(this.roleId, true);
/* 24 */     AllWingPlans xWingPlans = roleWingInfo.getxWingPlans();
/* 25 */     if (xWingPlans == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     xWingPlans.getNewoccplans().clear();
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PCRemoveNewOccPlanTipReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */