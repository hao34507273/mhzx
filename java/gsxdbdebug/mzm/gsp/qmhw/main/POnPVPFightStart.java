/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.event.PVPFightStartArg;
/*    */ import xbean.RoleQMHWScore;
/*    */ 
/*    */ public class POnPVPFightStart extends mzm.gsp.fight.event.PVPFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (!(((PVPFightStartArg)this.arg).context instanceof QMHWFightContext)) {
/* 14 */       return false;
/*    */     }
/* 16 */     List<Long> lockroles = ((PVPFightStartArg)this.arg).getAllRoles();
/*    */     
/* 18 */     lock(xtable.Role2qmhw.getTable(), lockroles);
/* 19 */     for (Iterator i$ = ((PVPFightStartArg)this.arg).activeRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 20 */       RoleQMHWScore xRoleQMHWScore = QMHWManager.getXQMHWRoleCreateIfNotExist(roleid);
/* 21 */       xRoleQMHWScore.setExtendmatchscore(0);
/* 22 */       xRoleQMHWScore.getLatestmatchroles().clear();
/* 23 */       xRoleQMHWScore.getLatestmatchroles().addAll(((PVPFightStartArg)this.arg).passiveRoles);
/*    */     }
/* 25 */     for (Iterator i$ = ((PVPFightStartArg)this.arg).passiveRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 26 */       RoleQMHWScore xRoleQMHWScore = QMHWManager.getXQMHWRoleCreateIfNotExist(roleid);
/* 27 */       xRoleQMHWScore.setExtendmatchscore(0);
/* 28 */       xRoleQMHWScore.getLatestmatchroles().clear();
/* 29 */       xRoleQMHWScore.getLatestmatchroles().addAll(((PVPFightStartArg)this.arg).activeRoles);
/*    */     }
/*    */     
/* 32 */     for (Iterator i$ = lockroles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 33 */       mzm.gsp.activity.main.ActivityInterface.tlogActivity(r, mzm.gsp.qmhw.confbean.SQMHWCfgConsts.getInstance().ACTIVITY_ID, mzm.gsp.activity.main.ActivityLogStatus.ATTEND);
/*    */     }
/*    */     
/* 36 */     xbean.QMHWActivity xQmhwActivity = QMHWManager.getXQmhwCreateIfNotExist();
/* 37 */     xQmhwActivity.getFightids().add(Long.valueOf(((PVPFightStartArg)this.arg).fightid));
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\POnPVPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */