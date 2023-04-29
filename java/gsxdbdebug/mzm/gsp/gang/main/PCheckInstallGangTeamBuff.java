/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.gang.confbean.SGangTeamConst;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Gang;
/*    */ import xbean.GangTeam;
/*    */ import xtable.Basic;
/*    */ 
/*    */ class PCheckInstallGangTeamBuff
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   PCheckInstallGangTeamBuff(long roleid)
/*    */   {
/* 21 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     Long gangid = GangManager.getGangidByRole(this.roleid);
/* 28 */     if (gangid == null) {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     Gang xGang = GangManager.getXGang(gangid.longValue(), false);
/*    */     
/* 34 */     if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleid))) {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     GangTeam xGangTeam = GangManager.getXGangTeamByRoleid(xGang, this.roleid);
/* 39 */     if (xGangTeam == null) {
/* 40 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 44 */     List<Long> normalRoleList = TeamInterface.getNormalRoleList(this.roleid);
/*    */     
/* 46 */     List<Long> gangTeamMembers = new ArrayList();
/* 47 */     for (Iterator i$ = normalRoleList.iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/* 48 */       if (GangManager.isInGangTeam(xGangTeam, memberid)) {
/* 49 */         gangTeamMembers.add(Long.valueOf(memberid));
/*    */       }
/*    */     }
/*    */     
/* 53 */     int sameGangTeamCount = gangTeamMembers.size();
/* 54 */     if (sameGangTeamCount < SGangTeamConst.getInstance().GangTeamBuffNeedNumber) {
/* 55 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 59 */     lock(Basic.getTable(), gangTeamMembers);
/* 60 */     for (Iterator i$ = gangTeamMembers.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 61 */       BuffInterface.installBuff(r, SGangTeamConst.getInstance().GangTeamBuffid);
/*    */     }
/*    */     
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCheckInstallGangTeamBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */