/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.HulaInfo;
/*    */ import xbean.HulaWorldInfo;
/*    */ import xtable.Hulaworld;
/*    */ import xtable.Role2hula;
/*    */ 
/*    */ public class PLeaveHulaWorld extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PLeaveHulaWorld(long roleid)
/*    */   {
/* 17 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if ((!HulaManager.isInHulaFubenWorld(this.roleid)) && (!HulaManager.isInHulaPrepareWorld(this.roleid)))
/*    */     {
/* 26 */       String logstr = String.format("[hula]PLeaveHulaWorld.processImp@role not in hula world|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 27 */       HulaManager.logger.info(logstr);
/* 28 */       return false;
/*    */     }
/* 30 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleid, false);
/*    */     
/* 32 */     if ((teamId == null) || (!TeamInterface.isTeamMemberNormal(this.roleid)))
/*    */     {
/*    */ 
/* 35 */       mzm.gsp.status.main.RoleStatusInterface.unsetStatus(this.roleid, 450);
/* 36 */       HulaInfo xHulaInfo = Role2hula.get(Long.valueOf(this.roleid));
/* 37 */       if (xHulaInfo != null)
/*    */       {
/* 39 */         long key = GameServerInfoManager.toGlobalId(xHulaInfo.getWorldid());
/* 40 */         HulaWorldInfo xHulaWorldInfo = Hulaworld.get(Long.valueOf(key));
/* 41 */         if (xHulaWorldInfo != null)
/*    */         {
/* 43 */           xHulaWorldInfo.getRoleids().remove(Long.valueOf(this.roleid));
/*    */         }
/*    */       }
/*    */       
/* 47 */       HulaManager.trnsferToWorld(this.roleid);
/* 48 */       return true;
/*    */     }
/* 50 */     if (TeamInterface.isTeamLeader(teamId.longValue(), this.roleid, false))
/*    */     {
/* 52 */       java.util.List<Long> roleList = TeamInterface.getNormalRoleList(this.roleid);
/* 53 */       lock(xtable.Role2properties.getTable(), roleList);
/*    */       
/* 55 */       mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleList, 450);
/* 56 */       HulaInfo xHulaInfo = Role2hula.get(Long.valueOf(this.roleid));
/* 57 */       if (xHulaInfo != null)
/*    */       {
/* 59 */         long key = GameServerInfoManager.toGlobalId(xHulaInfo.getWorldid());
/* 60 */         HulaWorldInfo xHulaWorldInfo = Hulaworld.get(Long.valueOf(key));
/* 61 */         if (xHulaWorldInfo != null)
/*    */         {
/* 63 */           xHulaWorldInfo.getRoleids().removeAll(roleList);
/*    */         }
/*    */       }
/*    */       
/* 67 */       HulaManager.trnsferToWorld(this.roleid);
/* 68 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 72 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\PLeaveHulaWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */