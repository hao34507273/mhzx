/*    */ package mzm.gsp.fabao.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.fabao.event.FabaoSysChange;
/*    */ import mzm.gsp.fabao.event.FabaoSysChangeArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import xbean.RoleFabaoSysInfo;
/*    */ 
/*    */ public class POnRoleLevelUp extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.getRoleFabaoSysInfo(((RoleLevelUpArg)this.arg).roleId, true);
/*    */     
/* 17 */     int lowRank = FabaoManager.getExtraLowRank(xRoleFabaoSysInfo);
/* 18 */     if (lowRank != 1) {
/* 19 */       FabaoSysChangeArg fabaoSysChangeArg = new FabaoSysChangeArg(((RoleLevelUpArg)this.arg).roleId, new java.util.HashSet(1));
/* 20 */       TriggerEventsManger.getInstance().triggerEvent(new FabaoSysChange(), fabaoSysChangeArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(((RoleLevelUpArg)this.arg).roleId)));
/*    */     }
/*    */     
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */