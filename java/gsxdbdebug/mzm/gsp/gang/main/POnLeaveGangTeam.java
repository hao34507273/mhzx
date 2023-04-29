/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.gang.confbean.SGangTeamConst;
/*    */ import mzm.gsp.gang.event.LeaveGangTeamArg;
/*    */ import mzm.gsp.gang.event.LeaveGangTeamProcedure;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnLeaveGangTeam
/*    */   extends LeaveGangTeamProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     long roleid = ((LeaveGangTeamArg)this.arg).roleid;
/*    */     
/* 21 */     List<Long> normalRoleList = TeamInterface.getNormalRoleList(roleid);
/* 22 */     if ((normalRoleList == null) || (normalRoleList.isEmpty())) {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     if (!normalRoleList.contains(Long.valueOf(roleid))) {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     List<Long> gangTeamMembers = new ArrayList();
/* 31 */     for (Iterator i$ = normalRoleList.iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/* 32 */       if (((LeaveGangTeamArg)this.arg).members.contains(Long.valueOf(memberid))) {
/* 33 */         gangTeamMembers.add(Long.valueOf(memberid));
/*    */       }
/*    */     }
/*    */     Iterator i$;
/* 37 */     if (gangTeamMembers.size() < SGangTeamConst.getInstance().GangTeamBuffNeedNumber)
/*    */     {
/* 39 */       gangTeamMembers.add(Long.valueOf(roleid));
/*    */       
/* 41 */       lock(Basic.getTable(), gangTeamMembers);
/* 42 */       for (i$ = gangTeamMembers.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 43 */         BuffInterface.uninstallBuf(r, SGangTeamConst.getInstance().GangTeamBuffid);
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 48 */       BuffInterface.uninstallBuf(roleid, SGangTeamConst.getInstance().GangTeamBuffid);
/*    */     }
/*    */     
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\POnLeaveGangTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */