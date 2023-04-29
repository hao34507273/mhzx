/*    */ package mzm.gsp.singlebattle.grab;
/*    */ 
/*    */ import mzm.gsp.singlebattle.confbean.SPositionInfoCfg;
/*    */ import mzm.gsp.singlebattle.event.GrabPositionSucProcedure;
/*    */ import mzm.gsp.singlebattle.main.RoleBattleBaseInfo;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ 
/*    */ public class POnGrabPositionSuc
/*    */   extends GrabPositionSucProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (!((EventArg_GrabPositionSuc)this.arg).isFirstGrab())
/*    */     {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     SPositionInfoCfg positionInfoCfg = SPositionInfoCfg.get(((EventArg_GrabPositionSuc)this.arg).getPositionCfgId());
/* 19 */     if (positionInfoCfg == null)
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     RoleBattleBaseInfo roleBaseInfo = SingleBattleInterface.getRoleBattleBaseInfo(((EventArg_GrabPositionSuc)this.arg).getRoleId(), true);
/* 25 */     if (roleBaseInfo == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     SingleBattleInterface.addRolePoint(roleBaseInfo.getBattleId(), roleBaseInfo.getCampId(), ((EventArg_GrabPositionSuc)this.arg).getRoleId(), positionInfoCfg.firstGrabAddPoint);
/*    */     
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\grab\POnGrabPositionSuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */