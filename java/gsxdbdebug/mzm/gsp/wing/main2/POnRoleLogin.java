/*    */ package mzm.gsp.wing.main2;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.WingPlan;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 21 */     String userid = RoleInterface.getUserId(roleId);
/* 22 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/*    */ 
/* 25 */     RoleWingInfo roleWingInfo = new RoleWingInfo(roleId, true);
/*    */     
/*    */ 
/* 28 */     if (!roleWingInfo.hasXData())
/*    */     {
/* 30 */       roleWingInfo.createXData();
/*    */     }
/*    */     
/* 33 */     WingManager.transformOccData(roleId, roleWingInfo.getxWingPlans());
/*    */     
/* 35 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
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
/* 46 */     if (xWingPlan == null)
/*    */     {
/* 48 */       return true;
/*    */     }
/*    */     
/* 51 */     WingManager.synRoleWingInfo(roleId, roleWingInfo.getxWingPlans(), 2);
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */