/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Gang;
/*     */ import xbean.GangMemoryBean;
/*     */ import xbean.GangTeam;
/*     */ import xtable.Basic;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PJoinGangTeamRep
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long applicantid;
/*     */   private final int reply;
/*     */   
/*     */   public PJoinGangTeamRep(long roleid, long applicantid, int reply)
/*     */   {
/*  25 */     this.roleid = roleid;
/*  26 */     this.applicantid = applicantid;
/*  27 */     this.reply = reply;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  32 */     if (!OpenInterface.getOpenStatus(513)) {
/*  33 */       GangManager.logError("PJoinGangTeamRep.processImp@not open|roleid=%d|applicantid=%d|reply=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.applicantid), Integer.valueOf(this.reply) });
/*     */       
/*     */ 
/*  36 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  40 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.applicantid) }));
/*  41 */     Long gangid = GangManager.getGangidByRole(this.roleid);
/*  42 */     if (gangid == null) {
/*  43 */       GangManager.sendNormalResult(this.roleid, 241, new Object[0]);
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     Gang xGang = GangManager.getXGang(gangid.longValue(), true);
/*  48 */     if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleid))) {
/*  49 */       GangManager.sendNormalResult(this.roleid, 241, new Object[0]);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     long gangTeamid = GangManager.getGangTeamid(xGang, this.roleid);
/*  54 */     if (gangTeamid <= 0L) {
/*  55 */       GangManager.sendNormalResult(this.roleid, 242, new Object[0]);
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     GangTeam xGangTeam = (GangTeam)xGang.getTeams().get(Long.valueOf(gangTeamid));
/*  60 */     if (!GangManager.isGangTeamLeader(xGangTeam, this.roleid)) {
/*  61 */       GangManager.sendNormalResult(this.roleid, 243, new Object[0]);
/*  62 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  67 */     GangMemoryBean xGangMemory = GangManager.getAndCreateXGangMemory(gangid.longValue());
/*  68 */     boolean bRemoveApplicant = GangManager.removeGangTeamApplicantAndBroadcast(xGangMemory, gangTeamid, xGangTeam, this.applicantid);
/*     */     
/*     */ 
/*  71 */     if (!bRemoveApplicant) {
/*  72 */       GangManager.sendNormalResult(this.roleid, 244, new Object[0]);
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     if (!GangManager.isInGang(xGang, this.applicantid)) {
/*  78 */       GangManager.sendNormalResult(this.roleid, 246, new Object[0]);
/*  79 */       return true;
/*     */     }
/*     */     
/*  82 */     if (GangManager.getGangTeamid(xGang, this.applicantid) > 0L) {
/*  83 */       GangManager.sendNormalResult(this.roleid, 247, new Object[0]);
/*  84 */       return true;
/*     */     }
/*     */     
/*  87 */     if (this.reply == 0)
/*     */     {
/*  89 */       if (GangManager.isGangTeamFull(xGangTeam)) {
/*  90 */         GangManager.sendNormalResult(this.roleid, 245, new Object[0]);
/*     */       }
/*     */       else {
/*  93 */         long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */         
/*  95 */         String applicantUserid = RoleInterface.getUserId(this.applicantid);
/*  96 */         int applicantLevel = RoleInterface.getLevel(this.applicantid);
/*  97 */         GangManager.joinGangTeamAndBroadcast(applicantUserid, this.applicantid, applicantLevel, gangTeamid, xGangTeam, gangid.longValue(), xGang, xGangMemory, nowMillis);
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else {
/* 103 */       GangManager.notifyJoinGangTeamRefused(this.roleid, this.applicantid);
/*     */     }
/*     */     
/* 106 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PJoinGangTeamRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */