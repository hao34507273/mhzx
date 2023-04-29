/*    */ package mzm.gsp.wing.main2;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.WingContent;
/*    */ import xbean.WingPlan;
/*    */ import xdb.Lockeys;
/*    */ 
/*    */ public class PGM_wingskillguarantee extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int wingId;
/*    */   private final int guaranteeTimes;
/*    */   
/*    */   public PGM_wingskillguarantee(long roleId, int wingId, int guaranteeTimes)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.wingId = wingId;
/* 18 */     this.guaranteeTimes = guaranteeTimes;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 26 */     lock(Lockeys.get(xtable.User.getTable(), userid));
/* 27 */     RoleWingInfo roleWingInfo = new RoleWingInfo(this.roleId, true);
/* 28 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/* 29 */     if (xWingPlan == null)
/*    */     {
/* 31 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("%d :未拥有指定羽翼", new Object[] { Integer.valueOf(this.wingId) }));
/*    */       
/* 33 */       return false;
/*    */     }
/* 35 */     RoleWingPlan xPlan = new RoleWingPlan(this.roleId, 1, xWingPlan);
/*    */     
/* 37 */     if (!xPlan.hasWing(this.wingId))
/*    */     {
/* 39 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("%d :未拥有指定羽翼", new Object[] { Integer.valueOf(this.wingId) }));
/*    */       
/* 41 */       return false;
/*    */     }
/* 43 */     WingContent xWingData = xPlan.getWingData(this.wingId);
/*    */     
/* 45 */     if (this.guaranteeTimes >= 0) {
/* 46 */       xWingData.setGuarantee_times(this.guaranteeTimes);
/* 47 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("设置成功！保底次数：%d", new Object[] { Integer.valueOf(xWingData.getGuarantee_times()) }));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 53 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("保底次数：%d", new Object[] { Integer.valueOf(xWingData.getGuarantee_times()) }));
/*    */     }
/*    */     
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PGM_wingskillguarantee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */