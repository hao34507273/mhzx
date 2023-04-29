/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.ladder.RoleLadderLoginInfo;
/*    */ import mzm.gsp.ladder.SNewMemberAttendLadderRes;
/*    */ import mzm.gsp.ladder.SSynLadderInfo;
/*    */ import mzm.gsp.ladder.confbean.SLadderConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.event.JoinTeamArg;
/*    */ import mzm.gsp.team.event.JoinTeamProcedure;
/*    */ import mzm.gsp.team.event.TeamMember;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.LadderActivity;
/*    */ import xtable.Ladderactivity;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnJoinTeam extends JoinTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     if (!mzm.gsp.activity.main.ActivityInterface.isActivityOpen(SLadderConsts.getInstance().activityid)) {
/* 27 */       return false;
/*    */     }
/* 29 */     List<Long> memberList = TeamInterface.getTeamMemberList(((JoinTeamArg)this.arg).teamid, false);
/* 30 */     if (!memberList.contains(Long.valueOf(((JoinTeamArg)this.arg).member.roleid))) {
/* 31 */       return false;
/*    */     }
/* 33 */     Map<Long, String> role2Userid = new HashMap();
/* 34 */     for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 35 */       role2Userid.put(Long.valueOf(roleid), mzm.gsp.role.main.RoleInterface.getUserId(roleid));
/*    */     }
/* 37 */     lock(User.getTable(), role2Userid.values());
/* 38 */     lock(xtable.Role2properties.getTable(), memberList);
/* 39 */     List<Long> tempList = TeamInterface.getTeamMemberList(((JoinTeamArg)this.arg).teamid, false);
/* 40 */     if (tempList.contains(Long.valueOf(((JoinTeamArg)this.arg).member.roleid))) {
/* 41 */       long leaderid = ((Long)tempList.get(0)).longValue();
/* 42 */       LadderActivity xLadderActivity = Ladderactivity.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 43 */       if (xLadderActivity == null) {
/* 44 */         return false;
/*    */       }
/* 46 */       if (xLadderActivity.getRoleids().contains(Long.valueOf(leaderid))) {
/* 47 */         xLadderActivity.getRoleids().add(Long.valueOf(((JoinTeamArg)this.arg).member.roleid));
/*    */         
/* 49 */         SNewMemberAttendLadderRes newMemberAttendLadderRes = new SNewMemberAttendLadderRes();
/*    */         
/* 51 */         SSynLadderInfo synLadderInfo = new SSynLadderInfo();
/* 52 */         for (Iterator i$ = tempList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 53 */           RoleLadderLoginInfo roleLadderLoginInfo = new RoleLadderLoginInfo();
/* 54 */           LadderManager.fillRoleLadderInfo(roleLadderLoginInfo.roleladderinfo, roleid);
/* 55 */           Set<Integer> statuses = mzm.gsp.status.main.RoleStatusInterface.getStatusSet(roleid);
/* 56 */           if (statuses.contains(Integer.valueOf(42))) {
/* 57 */             roleLadderLoginInfo.matchstage = 2;
/* 58 */           } else if (statuses.contains(Integer.valueOf(43))) {
/* 59 */             roleLadderLoginInfo.matchstage = 1;
/*    */           }
/*    */           
/*    */ 
/* 63 */           synLadderInfo.roleladderlogininfos.add(roleLadderLoginInfo);
/* 64 */           if (roleid == ((JoinTeamArg)this.arg).member.roleid) {
/* 65 */             newMemberAttendLadderRes.roleladderinfo = roleLadderLoginInfo.roleladderinfo;
/*    */           }
/*    */         }
/* 68 */         OnlineManager.getInstance().send(((JoinTeamArg)this.arg).member.roleid, synLadderInfo);
/* 69 */         Set<Long> allroleSet = new java.util.HashSet(tempList);
/* 70 */         allroleSet.remove(Long.valueOf(((JoinTeamArg)this.arg).member.roleid));
/* 71 */         OnlineManager.getInstance().sendMulti(newMemberAttendLadderRes, allroleSet);
/*    */       }
/*    */     }
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */