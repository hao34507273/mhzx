/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_GetBattlePoint extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_GetBattlePoint(long roleId)
/*    */   {
/* 12 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     RoleBattleBaseInfo roleBaseInfo = SingleBattleInterface.getRoleBattleBaseInfo(this.roleId, false);
/* 19 */     if (roleBaseInfo == null)
/*    */     {
/* 21 */       GmManager.getInstance().sendResultToGM(this.roleId, "没在战场中呐~");
/* 22 */       return false;
/*    */     }
/* 24 */     SingleBattleGlobalInfo globalInfo = SingleBattleInterface.getSingleBattleGlobalInfo(roleBaseInfo.getBattleId(), false);
/* 25 */     if (globalInfo == null)
/*    */     {
/* 27 */       GmManager.getInstance().sendResultToGM(this.roleId, "战场不存在呐~");
/* 28 */       return false;
/*    */     }
/* 30 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("个人战场积分=%d", new Object[] { Integer.valueOf(globalInfo.getRolePoint(this.roleId, roleBaseInfo.getCampId())) }));
/*    */     
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\PGM_GetBattlePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */