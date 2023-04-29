/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.map.main.message.MMH_TeamLeaderChange;
/*    */ import mzm.gsp.mounts.main.MountsInterface;
/*    */ import mzm.gsp.mounts.main.MultiRoleMountsInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.TeamMember;
/*    */ import mzm.gsp.team.event.TeamLeaderChangedArg;
/*    */ import mzm.gsp.team.event.TeamLeaderChangedProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnTeamLeaderChanged extends TeamLeaderChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     if (((TeamLeaderChangedArg)this.arg).oldLeader == ((TeamLeaderChangedArg)this.arg).newLeader)
/*    */     {
/* 25 */       GameServer.logger().error(String.format("[map]POnTeamLeaderChanged.processImp@新旧对长相同|teamid=%d|roleid=%d", new Object[] { Long.valueOf(((TeamLeaderChangedArg)this.arg).teamid), Long.valueOf(((TeamLeaderChangedArg)this.arg).newLeader) }));
/*    */       
/*    */ 
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     MultiRoleMountsInfo multiMountsInfo = MountsInterface.getMultiRoleMountsInfo(((TeamLeaderChangedArg)this.arg).teamid, false);
/*    */     
/* 33 */     boolean oldOffline = false;
/* 34 */     Set<Long> lockRoles = new HashSet();
/* 35 */     List<Long> normalRoles = new ArrayList();
/* 36 */     for (TeamMember tMember : ((TeamLeaderChangedArg)this.arg).teamMembers)
/*    */     {
/* 38 */       if (tMember.status == 0)
/*    */       {
/* 40 */         long tempRoleid = tMember.roleid;
/* 41 */         normalRoles.add(Long.valueOf(tempRoleid));
/* 42 */         lockRoles.add(Long.valueOf(tempRoleid));
/*    */       }
/* 44 */       if (tMember.roleid == ((TeamLeaderChangedArg)this.arg).oldLeader)
/*    */       {
/* 46 */         if (tMember.status == 2)
/*    */         {
/* 48 */           oldOffline = true;
/*    */         }
/*    */       }
/*    */     }
/* 52 */     lockRoles.add(Long.valueOf(((TeamLeaderChangedArg)this.arg).newLeader));
/* 53 */     lockRoles.add(Long.valueOf(((TeamLeaderChangedArg)this.arg).oldLeader));
/* 54 */     lock(xtable.Role2properties.getTable(), lockRoles);
/*    */     
/* 56 */     int flySpeed = 0;
/* 57 */     boolean isNewFly = RoleStatusInterface.containsStatus(((TeamLeaderChangedArg)this.arg).newLeader, 2);
/* 58 */     if (isNewFly)
/*    */     {
/* 60 */       flySpeed = RoleInterface.getFlySpeed(((TeamLeaderChangedArg)this.arg).newLeader, true);
/*    */     }
/* 62 */     if (flySpeed <= 0)
/*    */     {
/* 64 */       RoleStatusInterface.unsetStatus(((TeamLeaderChangedArg)this.arg).newLeader, 2);
/* 65 */       RoleStatusInterface.unsetStatus(normalRoles, 2);
/*    */     }
/*    */     
/* 68 */     boolean oldLeaveTeam = true;
/* 69 */     if (normalRoles.contains(Long.valueOf(((TeamLeaderChangedArg)this.arg).oldLeader)))
/*    */     {
/* 71 */       oldLeaveTeam = false;
/*    */     }
/* 73 */     if (!oldOffline)
/*    */     {
/* 75 */       oldOffline = !OnlineManager.getInstance().isOnline(((TeamLeaderChangedArg)this.arg).oldLeader);
/*    */     }
/*    */     
/* 78 */     if (multiMountsInfo == null)
/*    */     {
/* 80 */       new MMH_TeamLeaderChange(((TeamLeaderChangedArg)this.arg).teamid, ((TeamLeaderChangedArg)this.arg).newLeader, flySpeed, ((TeamLeaderChangedArg)this.arg).oldLeader, oldLeaveTeam, oldOffline).execute();
/*    */     }
/*    */     else
/*    */     {
/* 84 */       new MMH_TeamLeaderChange(((TeamLeaderChangedArg)this.arg).teamid, ((TeamLeaderChangedArg)this.arg).newLeader, flySpeed, ((TeamLeaderChangedArg)this.arg).oldLeader, oldLeaveTeam, oldOffline, multiMountsInfo.mountsCfgId, multiMountsInfo.roleIds).execute();
/*    */     }
/*    */     
/*    */ 
/* 88 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnTeamLeaderChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */