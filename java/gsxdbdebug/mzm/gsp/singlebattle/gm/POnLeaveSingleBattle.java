/*    */ package mzm.gsp.singlebattle.gm;
/*    */ 
/*    */ import mzm.gsp.homeland.confbean.SBanquetConsts;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.singlebattle.event.LeaveSingleBattleArg;
/*    */ import mzm.gsp.singlebattle.event.LeaveSingleBattleProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnLeaveSingleBattle
/*    */   extends LeaveSingleBattleProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     if (!(((LeaveSingleBattleArg)this.arg).get_context() instanceof GM_BattleContext))
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     MapInterface.transferToScene(((LeaveSingleBattleArg)this.arg).getRoleId(), SBanquetConsts.getInstance().TRANSFORM_MAP_ID);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gm\POnLeaveSingleBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */