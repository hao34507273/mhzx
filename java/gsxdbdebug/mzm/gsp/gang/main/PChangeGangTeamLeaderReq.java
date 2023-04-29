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
/*     */ import xbean.GangMemoryBean;
/*     */ import xbean.GangTeam;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PChangeGangTeamLeaderReq extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long newLeader;
/*     */   
/*     */   public PChangeGangTeamLeaderReq(long roleid, long newLeader)
/*     */   {
/*  28 */     this.roleid = roleid;
/*  29 */     this.newLeader = newLeader;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  34 */     if (!OpenInterface.getOpenStatus(513)) {
/*  35 */       GangManager.logError("PChangeGangTeamLeaderReq.processImp@not open|roleid=%d|new_leader=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.newLeader) });
/*     */       
/*     */ 
/*  38 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  42 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.newLeader) }));
/*     */     
/*  44 */     Long gangid = GangManager.getGangidByRole(this.roleid);
/*     */     
/*  46 */     if (gangid == null) {
/*  47 */       GangManager.sendNormalResult(this.roleid, 291, new Object[0]);
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     Gang xGang = GangManager.getXGang(gangid.longValue(), true);
/*  53 */     if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleid))) {
/*  54 */       GangManager.sendNormalResult(this.roleid, 291, new Object[0]);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     long gangTeamid = GangManager.getGangTeamid(xGang, this.roleid);
/*  59 */     if (gangTeamid <= 0L) {
/*  60 */       GangManager.sendNormalResult(this.roleid, 292, new Object[0]);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     GangTeam xGangTeam = (GangTeam)xGang.getTeams().get(Long.valueOf(gangTeamid));
/*     */     
/*  66 */     if (!GangManager.isGangTeamLeader(xGangTeam, this.roleid)) {
/*  67 */       GangManager.sendNormalResult(this.roleid, 293, new Object[0]);
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     if (!GangManager.isInGangTeam(xGangTeam, this.newLeader)) {
/*  73 */       GangManager.sendNormalResult(this.roleid, 294, new Object[0]);
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     if (this.newLeader == this.roleid) {
/*  79 */       GangManager.sendNormalResult(this.roleid, 295, new Object[0]);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     GangManager.changeGangTeamLeaderAndBroadcast(xGang, gangTeamid, xGangTeam, this.newLeader);
/*     */     
/*     */ 
/*  86 */     GangMemoryBean xGangMemory = GangManager.getXGangMemory(gangid.longValue(), true);
/*  87 */     if (xGangMemory != null) {
/*  88 */       GangManager.syncGangTeamApplicants(this.newLeader, gangTeamid, xGangMemory);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  93 */     String oldLeaderName = RoleInterface.getName(this.roleid);
/*  94 */     String newLeaderName = RoleInterface.getName(this.newLeader);
/*  95 */     List<String> contentArgs = new ArrayList();
/*  96 */     contentArgs.add(oldLeaderName);
/*  97 */     contentArgs.add(newLeaderName);
/*  98 */     contentArgs.add(newLeaderName);
/*     */     
/* 100 */     TLogArg tlogArg = new TLogArg(LogReason.GANG_TEAM_LEADER_CHANGE_MAIL);
/*     */     
/* 102 */     for (Iterator i$ = xGangTeam.getMembers().keySet().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 103 */       MailInterface.asynBuildAndSendMail(r, SGangTeamConst.getInstance().ChangeTeamLeaderMail, null, contentArgs, tlogArg);
/*     */     }
/*     */     
/*     */ 
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PChangeGangTeamLeaderReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */