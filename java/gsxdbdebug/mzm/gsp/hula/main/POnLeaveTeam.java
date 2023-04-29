/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ import xbean.HulaInfo;
/*    */ import xbean.HulaWorldInfo;
/*    */ import xtable.Hulaworld;
/*    */ 
/*    */ public class POnLeaveTeam extends mzm.gsp.team.event.LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleid = ((LeaveTeamArg)this.arg).roleid;
/* 14 */     if (!HulaManager.isInHulaFubenWorld(roleid))
/*    */     {
/* 16 */       return false;
/*    */     }
/* 18 */     mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleid, 450);
/* 19 */     HulaInfo xHulaInfo = xtable.Role2hula.get(Long.valueOf(roleid));
/* 20 */     if (xHulaInfo != null)
/*    */     {
/* 22 */       long key = GameServerInfoManager.toGlobalId(xHulaInfo.getWorldid());
/* 23 */       HulaWorldInfo xHulaWorldInfo = Hulaworld.get(Long.valueOf(key));
/* 24 */       if (xHulaWorldInfo != null)
/*    */       {
/* 26 */         xHulaWorldInfo.getRoleids().remove(Long.valueOf(roleid));
/*    */       }
/* 28 */       xHulaInfo.setWorldid(0L);
/* 29 */       HulaManager.rankRole(roleid, xHulaInfo);
/*    */     }
/* 31 */     HulaManager.trnsferToWorld(roleid);
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */