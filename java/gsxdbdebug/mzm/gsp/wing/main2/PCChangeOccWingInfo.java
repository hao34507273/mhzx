/*    */ package mzm.gsp.wing.main2;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCChangeOccWingInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int occId;
/*    */   
/*    */   public PCChangeOccWingInfo(long roleId, int occId)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.occId = occId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     return WingManager.changeOccPlan(this.roleId, this.occId, RoleInterface.getOccupationId(this.roleId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PCChangeOccWingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */