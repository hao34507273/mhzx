/*    */ package mzm.gsp.wing.main2;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.AllWingPlans;
/*    */ import xtable.Role2wingplans;
/*    */ 
/*    */ public class PGM_ClearWingData extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_ClearWingData(long roleId)
/*    */   {
/* 13 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     AllWingPlans xWingPlansOld = Role2wingplans.get(Long.valueOf(this.roleId));
/* 20 */     if (xWingPlansOld == null)
/*    */     {
/* 22 */       return true;
/*    */     }
/* 24 */     if (xWingPlansOld.getTransfer_occupation_wing_map().size() > 1)
/*    */     {
/* 26 */       GmManager.getInstance().sendResultToGM(this.roleId, "改玩家已经转过职业，不允许清除羽翼信息！");
/* 27 */       return false;
/*    */     }
/* 29 */     Role2wingplans.remove(Long.valueOf(this.roleId));
/* 30 */     AllWingPlans xWingPlans = xbean.Pod.newAllWingPlans();
/* 31 */     Role2wingplans.insert(Long.valueOf(this.roleId), xWingPlans);
/* 32 */     mzm.gsp.online.main.OnlineManager.getInstance().forceReconnect(this.roleId);
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PGM_ClearWingData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */