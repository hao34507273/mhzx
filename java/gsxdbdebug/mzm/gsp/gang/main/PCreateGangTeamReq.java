/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gang.confbean.SGangTeamConst;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Gang;
/*     */ import xbean.GangMember;
/*     */ import xbean.GangMemoryBean;
/*     */ import xtable.Gangteam_invitations;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCreateGangTeamReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final String name;
/*     */   
/*     */   public PCreateGangTeamReq(long roleid, String name)
/*     */   {
/*  25 */     this.roleid = roleid;
/*  26 */     this.name = name;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  31 */     if (!OpenInterface.getOpenStatus(513)) {
/*  32 */       GangManager.logError("PCreateGangTeamReq.processImp@not open|roleid=%d|name=%s", new Object[] { Long.valueOf(this.roleid), this.name });
/*     */       
/*  34 */       return false;
/*     */     }
/*  36 */     if (GameServerInfoManager.isRoamServer()) {
/*  37 */       GangManager.logError("PCreateGangTeamReq.processImp@invalid in roam server|roleid=%d|name=%s", new Object[] { Long.valueOf(this.roleid), this.name });
/*     */       
/*  39 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  43 */     GangMember xMember = GangManager.getXGangMember(this.roleid, true);
/*  44 */     if (xMember == null) {
/*  45 */       GangManager.sendNormalResult(this.roleid, 201, new Object[0]);
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     String userid = RoleInterface.getUserId(this.roleid);
/*  51 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */     
/*     */ 
/*  54 */     Long gangid = GangManager.getGangidByRole(this.roleid);
/*  55 */     if (gangid == null) {
/*  56 */       GangManager.sendNormalResult(this.roleid, 201, new Object[0]);
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     Gang xGang = GangManager.getXGang(gangid.longValue(), true);
/*  62 */     if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleid))) {
/*  63 */       GangManager.sendNormalResult(this.roleid, 201, new Object[0]);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     long gangTeamid = GangManager.getGangTeamid(xGang, this.roleid);
/*  68 */     if (gangTeamid > 0L) {
/*  69 */       GangManager.sendNormalResult(this.roleid, 202, new Object[0]);
/*  70 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  74 */     if (GangConfigManager.getInstance().isGangTeamNameTooLong(this.name)) {
/*  75 */       GangManager.sendNormalResult(this.roleid, 203, new Object[0]);
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     if (!GangConfigManager.getInstance().isGangTeamNameLegal(this.name)) {
/*  81 */       GangManager.sendNormalResult(this.roleid, 204, new Object[0]);
/*  82 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  86 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  87 */     if (xMember.getCreate_gang_team_time() > 0L) {
/*  88 */       long leftMillis = xMember.getCreate_gang_team_time() + TimeUnit.MINUTES.toMillis(SGangTeamConst.getInstance().CreateCoolDownMinutes) - now;
/*     */       
/*  90 */       if (leftMillis > 0L) {
/*  91 */         long leftSeconds = TimeUnit.MILLISECONDS.toSeconds(leftMillis);
/*  92 */         if (leftSeconds > 0L) {
/*  93 */           GangManager.sendNormalResult(this.roleid, 205, new Object[] { Long.valueOf(leftSeconds) });
/*     */           
/*  95 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 100 */     gangTeamid = GangManager.createGangTeam(gangid.longValue(), xGang, this.roleid, this.name, now);
/* 101 */     xMember.setCreate_gang_team_time(now);
/*     */     
/*     */ 
/* 104 */     GangMemoryBean xGangMemory = GangManager.getXGangMemory(gangid.longValue(), true);
/* 105 */     GangManager.removeApplicantOfAllGangTeamsAndBrd(xGang, xGangMemory, this.roleid);
/*     */     
/*     */ 
/* 108 */     Gangteam_invitations.remove(Long.valueOf(this.roleid));
/*     */     
/*     */ 
/* 111 */     GangManager.logInfo("PCreateGangTeamReq.processImp@create gang team|roleid=%d|gangid=%d|gang_teamid=%d|gang_team_name=%s", new Object[] { Long.valueOf(this.roleid), gangid, Long.valueOf(gangTeamid), this.name });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 116 */     GangManager.tlogGangTeamCreated(userid, this.roleid, roleLevel, gangid.longValue(), xGang.getDisplayid(), gangTeamid, this.name);
/*     */     
/*     */ 
/* 119 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCreateGangTeamReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */