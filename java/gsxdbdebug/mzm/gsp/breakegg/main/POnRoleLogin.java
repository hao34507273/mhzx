/*    */ package mzm.gsp.breakegg.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xbean.BreakEggGameInfo;
/*    */ import xtable.Breakegg_info;
/*    */ import xtable.Role2breakegg_info;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/*    */ 
/* 19 */     Long breakEggId = Role2breakegg_info.get(Long.valueOf(roleId));
/* 20 */     if (breakEggId == null)
/*    */     {
/* 22 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 29 */     BreakEggGameInfo xBreakEggGameInfo = Breakegg_info.get(breakEggId);
/* 30 */     if (xBreakEggGameInfo == null)
/*    */     {
/* 32 */       if (RoleStatusInterface.containsStatus(roleId, 1864))
/*    */       {
/* 34 */         RoleStatusInterface.unsetStatus(roleId, 1864);
/*    */       }
/* 36 */       Role2breakegg_info.remove(Long.valueOf(roleId));
/* 37 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 42 */     if (Session.getSession(xBreakEggGameInfo.getSession_id()) == null)
/*    */     {
/* 44 */       BreakEggManager.destroyBreakEggGameInfo(roleId);
/* 45 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 50 */     BreakEggManager.sSynBreakEggJoinInfo(Arrays.asList(new Long[] { Long.valueOf(roleId) }), xBreakEggGameInfo);
/*    */     
/*    */ 
/*    */ 
/* 54 */     BreakEggManager.sSynBreakEggRewardInfo(Arrays.asList(new Long[] { Long.valueOf(roleId) }), xBreakEggGameInfo);
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */