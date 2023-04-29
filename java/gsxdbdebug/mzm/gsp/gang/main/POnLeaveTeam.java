/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.gang.confbean.SGangTeamConst;
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ import mzm.gsp.team.event.LeaveTeamProcedure;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.Gang;
/*    */ import xbean.GangTeam;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnLeaveTeam
/*    */   extends LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     long roleid = ((LeaveTeamArg)this.arg).roleid;
/* 21 */     if (((LeaveTeamArg)this.arg).status == 0)
/*    */     {
/* 23 */       Gang xGang = GangManager.getXGangByRoleid(roleid, false);
/*    */       
/* 25 */       if ((xGang == null) || (!GangManager.isInGang(xGang, roleid))) {
/* 26 */         return false;
/*    */       }
/*    */       
/* 29 */       GangTeam xGangTeam = GangManager.getXGangTeamByRoleid(xGang, roleid);
/* 30 */       if (xGangTeam == null) {
/* 31 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 35 */       List<Long> normalRoleList = TeamInterface.getTeamMemberList(((LeaveTeamArg)this.arg).teamid, false);
/*    */       
/* 37 */       List<Long> gangTeamMembers = new ArrayList();
/* 38 */       for (Iterator i$ = normalRoleList.iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/* 39 */         if (GangManager.isInGangTeam(xGangTeam, memberid)) {
/* 40 */           gangTeamMembers.add(Long.valueOf(memberid));
/*    */         }
/*    */       }
/*    */       Iterator i$;
/* 44 */       if (gangTeamMembers.size() < SGangTeamConst.getInstance().GangTeamBuffNeedNumber)
/*    */       {
/* 46 */         gangTeamMembers.add(Long.valueOf(roleid));
/* 47 */         lock(Basic.getTable(), gangTeamMembers);
/* 48 */         for (i$ = gangTeamMembers.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 49 */           BuffInterface.uninstallBuf(r, SGangTeamConst.getInstance().GangTeamBuffid);
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 54 */         BuffInterface.uninstallBuf(roleid, SGangTeamConst.getInstance().GangTeamBuffid);
/*    */       }
/*    */     }
/*    */     
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */