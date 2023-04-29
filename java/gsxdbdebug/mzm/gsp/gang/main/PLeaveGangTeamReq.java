/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.gang.confbean.SGangTeamConst;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Gang;
/*     */ import xbean.GangTeam;
/*     */ import xdb.Procedure;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PLeaveGangTeamReq extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PLeaveGangTeamReq(long roleid)
/*     */   {
/*  27 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  32 */     if (!OpenInterface.getOpenStatus(513)) {
/*  33 */       GangManager.logError("PLeaveGangTeamReq.processImp@not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  35 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  39 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*     */ 
/*  42 */     Long gangid = GangManager.getGangidByRole(this.roleid);
/*     */     
/*  44 */     if (gangid == null) {
/*  45 */       GangManager.sendNormalResult(this.roleid, 311, new Object[0]);
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     Gang xGang = GangManager.getXGang(gangid.longValue(), true);
/*  51 */     if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleid))) {
/*  52 */       GangManager.sendNormalResult(this.roleid, 311, new Object[0]);
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     Long gangTeamid = (Long)xGang.getMember2teamid().remove(Long.valueOf(this.roleid));
/*  57 */     if (gangTeamid == null) {
/*  58 */       GangManager.sendNormalResult(this.roleid, 312, new Object[0]);
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     GangTeam xGangTeam = (GangTeam)xGang.getTeams().get(gangTeamid);
/*  63 */     boolean bLeader = GangManager.isGangTeamLeader(xGangTeam, this.roleid);
/*     */     
/*  65 */     xbean.GangMemoryBean xGangMemory = GangManager.getXGangMemory(gangid.longValue(), true);
/*     */     
/*  67 */     boolean ret = GangManager.removeGangTeamMemberAndBroadcast(gangid.longValue(), xGang, xGangMemory, gangTeamid.longValue(), xGangTeam, this.roleid);
/*     */     
/*  69 */     if (!ret) {
/*  70 */       GangManager.sendNormalResult(this.roleid, 312, new Object[0]);
/*  71 */       GangManager.logError("PLeaveGangTeamReq.processImp@leave gang team failed|roleid=%d|gangid=%d|gang_teamid=%d", new Object[] { Long.valueOf(this.roleid), gangid, gangTeamid });
/*     */       
/*     */ 
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     String userid = RoleInterface.getUserId(this.roleid);
/*  79 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */     
/*  81 */     if (!xGangTeam.getMembers().isEmpty()) { TLogArg tLogArg;
/*  82 */       List<String> contentArgs; Iterator i$; if (bLeader)
/*     */       {
/*  84 */         Procedure.execute(new PChangeLeaderByLeaveGangTeamMail(this.roleid, xGangTeam.getLeader(), xGangTeam.getMembers().keySet()));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*  90 */         String roleName = RoleInterface.getName(this.roleid);
/*  91 */         tLogArg = new TLogArg(LogReason.GANG_TEAM_LEAVE_MAIL);
/*  92 */         contentArgs = new ArrayList();
/*  93 */         contentArgs.add(roleName);
/*     */         
/*  95 */         for (i$ = xGangTeam.getMembers().keySet().iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/*  96 */           MailInterface.asynBuildAndSendMail(memberid, SGangTeamConst.getInstance().LeaveTeamMail, null, contentArgs, tLogArg);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 101 */       GangManager.tlogLeaveGangTeam(userid, this.roleid, roleLevel, gangid.longValue(), xGang.getDisplayid(), gangTeamid.longValue());
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 106 */       GangManager.tlogGangTeamDissolved(userid, this.roleid, roleLevel, gangid.longValue(), xGang.getDisplayid(), gangTeamid.longValue());
/*     */     }
/*     */     
/*     */ 
/* 110 */     GangManager.logInfo("PLeaveGangTeamReq.processImp@leave gang team|roleid=%d|gangid=%d|gang_teamid=%d", new Object[] { Long.valueOf(this.roleid), gangid, gangTeamid });
/*     */     
/*     */ 
/*     */ 
/* 114 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PLeaveGangTeamReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */