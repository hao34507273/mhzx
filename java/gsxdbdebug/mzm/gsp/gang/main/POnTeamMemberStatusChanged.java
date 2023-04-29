/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.gang.confbean.SGangTeamConst;
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedProcedure;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.Gang;
/*    */ import xbean.GangTeam;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnTeamMemberStatusChanged
/*    */   extends TeamMemberStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     if ((((TeamMemberStatusChangedArg)this.arg).status != 0) && (((TeamMemberStatusChangedArg)this.arg).oldStatus != 0))
/*    */     {
/* 23 */       return false;
/*    */     }
/* 25 */     long roleid = ((TeamMemberStatusChangedArg)this.arg).roleid;
/*    */     
/* 27 */     if (((TeamMemberStatusChangedArg)this.arg).status == 0) {
/* 28 */       return new PCheckInstallGangTeamBuff(roleid).call();
/*    */     }
/* 30 */     if (((TeamMemberStatusChangedArg)this.arg).oldStatus == 0)
/*    */     {
/* 32 */       Gang xGang = GangManager.getXGangByRoleid(roleid, false);
/*    */       
/* 34 */       if ((xGang == null) || (!GangManager.isInGang(xGang, roleid))) {
/* 35 */         return false;
/*    */       }
/*    */       
/* 38 */       GangTeam xGangTeam = GangManager.getXGangTeamByRoleid(xGang, roleid);
/* 39 */       if (xGangTeam == null) {
/* 40 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 44 */       List<Long> normalRoleList = TeamInterface.getNormalRoleList(roleid);
/* 45 */       List<Long> gangTeamMembers = new ArrayList();
/* 46 */       for (Iterator i$ = normalRoleList.iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/* 47 */         if (GangManager.isInGangTeam(xGangTeam, memberid)) {
/* 48 */           gangTeamMembers.add(Long.valueOf(memberid));
/*    */         }
/*    */       }
/*    */       Iterator i$;
/* 52 */       if (gangTeamMembers.size() < SGangTeamConst.getInstance().GangTeamBuffNeedNumber)
/*    */       {
/* 54 */         gangTeamMembers.add(Long.valueOf(roleid));
/* 55 */         lock(Basic.getTable(), gangTeamMembers);
/* 56 */         for (i$ = gangTeamMembers.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 57 */           BuffInterface.uninstallBuf(r, SGangTeamConst.getInstance().GangTeamBuffid);
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 62 */         BuffInterface.uninstallBuf(roleid, SGangTeamConst.getInstance().GangTeamBuffid);
/*    */       }
/*    */     }
/*    */     
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\POnTeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */