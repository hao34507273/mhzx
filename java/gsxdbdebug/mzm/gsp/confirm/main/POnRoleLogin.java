/*    */ package mzm.gsp.confirm.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xbean.TeamConfirmBean;
/*    */ import xtable.Role2teamconf;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     long roleId = ((Long)this.arg).longValue();
/* 16 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(roleId);
/* 17 */     if (teamInfo == null)
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     long leaderId = teamInfo.getLeaderId();
/*    */     
/* 23 */     TeamConfirmBean xConfBean = Role2teamconf.get(Long.valueOf(leaderId));
/* 24 */     if (xConfBean == null)
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     if (Session.getSession(xConfBean.getSessionid()) == null)
/*    */     {
/* 30 */       Role2teamconf.remove(Long.valueOf(leaderId));
/* 31 */       return true;
/*    */     }
/*    */     
/* 34 */     ConfirmManager.asynConfirmInfo(teamInfo.getTeamId(), xConfBean.getConfirmtype(), xConfBean.getContext(), Arrays.asList(new Long[] { Long.valueOf(roleId) }), ConfirmManager.getConfirmBaseInfo(xConfBean));
/*    */     
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confirm\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */