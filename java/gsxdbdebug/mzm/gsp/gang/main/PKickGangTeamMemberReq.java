/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gang.confbean.SGangTeamConst;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Gang;
/*    */ import xbean.GangMemoryBean;
/*    */ import xbean.GangTeam;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ public class PKickGangTeamMemberReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long kickedMemberid;
/*    */   
/*    */   public PKickGangTeamMemberReq(long roleid, long kickedMemberid)
/*    */   {
/* 28 */     this.roleid = roleid;
/* 29 */     this.kickedMemberid = kickedMemberid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 34 */     if (!OpenInterface.getOpenStatus(513)) {
/* 35 */       GangManager.logError("PKickGangTeamMemberReq.processImp@not open|roleid=%d|kicked_memberid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.kickedMemberid) });
/*    */       
/*    */ 
/* 38 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 42 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.kickedMemberid) }));
/*    */     
/* 44 */     Long gangid = GangManager.getGangidByRole(this.roleid);
/* 45 */     if (gangid == null) {
/* 46 */       GangManager.sendNormalResult(this.roleid, 321, new Object[0]);
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     Gang xGang = GangManager.getXGang(gangid.longValue(), true);
/* 51 */     if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleid))) {
/* 52 */       GangManager.sendNormalResult(this.roleid, 321, new Object[0]);
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     long gangTeamid = GangManager.getGangTeamid(xGang, this.roleid);
/* 57 */     if (gangTeamid <= 0L) {
/* 58 */       GangManager.sendNormalResult(this.roleid, 322, new Object[0]);
/* 59 */       return false;
/*    */     }
/*    */     
/* 62 */     GangTeam xGangTeam = (GangTeam)xGang.getTeams().get(Long.valueOf(gangTeamid));
/* 63 */     if (!GangManager.isGangTeamLeader(xGangTeam, this.roleid)) {
/* 64 */       GangManager.sendNormalResult(this.roleid, 323, new Object[0]);
/* 65 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 69 */     GangMemoryBean xGangMemory = GangManager.getXGangMemory(gangid.longValue(), true);
/*    */     
/* 71 */     boolean ret = GangManager.removeGangTeamMemberAndBroadcast(gangid.longValue(), xGang, xGangMemory, gangTeamid, xGangTeam, this.kickedMemberid);
/*    */     
/* 73 */     if (!ret) {
/* 74 */       GangManager.sendNormalResult(this.roleid, 324, new Object[0]);
/* 75 */       return false;
/*    */     }
/* 77 */     xGang.getMember2teamid().remove(Long.valueOf(this.kickedMemberid));
/*    */     
/*    */ 
/*    */ 
/* 81 */     TLogArg tlogArg = new TLogArg(LogReason.GANG_TEAM_KICKED_MAIL);
/* 82 */     List<String> contentArgs = new ArrayList();
/* 83 */     contentArgs.add(xGangTeam.getName());
/*    */     
/* 85 */     MailInterface.synBuildAndSendMail(this.kickedMemberid, SGangTeamConst.getInstance().KickedByTeamLeaderMail, null, contentArgs, tlogArg);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 90 */     String leaderUserid = RoleInterface.getUserId(this.roleid);
/* 91 */     int leaderLevel = RoleInterface.getLevel(this.roleid);
/* 92 */     String kickedUserid = RoleInterface.getUserId(this.kickedMemberid);
/* 93 */     int kickedRoleLevel = RoleInterface.getLevel(this.kickedMemberid);
/* 94 */     GangManager.tlogKickGangTeamMember(leaderUserid, this.roleid, leaderLevel, kickedUserid, this.kickedMemberid, kickedRoleLevel, gangid.longValue(), xGang.getDisplayid(), gangTeamid);
/*    */     
/*    */ 
/* 97 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PKickGangTeamMemberReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */