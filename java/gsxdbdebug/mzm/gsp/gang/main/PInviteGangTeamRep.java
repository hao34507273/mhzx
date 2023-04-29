/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.gang.SInviteGangTeamRefusedNotify;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Gang;
/*     */ import xbean.GangMemoryBean;
/*     */ import xbean.GangTeam;
/*     */ import xbean.GangTeamInvitations;
/*     */ import xtable.Basic;
/*     */ 
/*     */ 
/*     */ public class PInviteGangTeamRep
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long inviter;
/*     */   private final long gangTeamid;
/*     */   private final int reply;
/*     */   
/*     */   public PInviteGangTeamRep(long roleid, long inviter, long gangTeamid, int reply)
/*     */   {
/*  28 */     this.roleid = roleid;
/*  29 */     this.inviter = inviter;
/*  30 */     this.gangTeamid = gangTeamid;
/*  31 */     this.reply = reply;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  36 */     if (!OpenInterface.getOpenStatus(513)) {
/*  37 */       GangManager.logError("PInviteGangTeamRep.processImp@not open|roleid=%d|inviter=%d|gang_teamid=%d|reply=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.inviter), Long.valueOf(this.gangTeamid), Integer.valueOf(this.reply) });
/*     */       
/*     */ 
/*  40 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  44 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.inviter) }));
/*     */     
/*     */ 
/*  47 */     Long gangid = GangManager.getGangidByRole(this.roleid);
/*  48 */     if (gangid == null) {
/*  49 */       GangManager.sendNormalResult(this.roleid, 271, new Object[0]);
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     Gang xGang = GangManager.getXGang(gangid.longValue(), true);
/*  55 */     if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleid))) {
/*  56 */       GangManager.sendNormalResult(this.roleid, 271, new Object[0]);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     long selfGangTeamid = GangManager.getGangTeamid(xGang, this.roleid);
/*  61 */     if (selfGangTeamid > 0L) {
/*  62 */       GangManager.sendNormalResult(this.roleid, 272, new Object[0]);
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     GangTeamInvitations xInvitations = GangManager.getXTeamInvitations(this.roleid, true);
/*  68 */     if (xInvitations == null) {
/*  69 */       GangManager.sendNormalResult(this.roleid, 275, new Object[0]);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     boolean bRemove = GangManager.removeGangTeamInvitation(xInvitations, this.inviter, this.gangTeamid);
/*  74 */     if (!bRemove) {
/*  75 */       GangManager.sendNormalResult(this.roleid, 275, new Object[0]);
/*  76 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  80 */     if (!GangManager.isInGang(xGang, this.inviter)) {
/*  81 */       GangManager.sendNormalResult(this.roleid, 272, new Object[0]);
/*  82 */       return true;
/*     */     }
/*     */     
/*  85 */     if (this.reply == 0)
/*     */     {
/*  87 */       GangTeam xGangTeam = (GangTeam)xGang.getTeams().get(Long.valueOf(this.gangTeamid));
/*  88 */       if (xGangTeam == null) {
/*  89 */         GangManager.sendNormalResult(this.roleid, 273, new Object[0]);
/*  90 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  94 */       if (GangManager.isGangTeamFull(xGangTeam)) {
/*  95 */         GangManager.sendNormalResult(this.roleid, 274, new Object[0]);
/*  96 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 100 */       if (!GangManager.isInGangTeam(xGangTeam, this.inviter)) {
/* 101 */         GangManager.sendNormalResult(this.roleid, 277, new Object[0]);
/* 102 */         return true;
/*     */       }
/*     */       
/* 105 */       GangMemoryBean xGangMemory = GangManager.getAndCreateXGangMemory(gangid.longValue());
/*     */       
/* 107 */       if (GangManager.isGangTeamLeader(xGangTeam, this.inviter))
/*     */       {
/* 109 */         long now = DateTimeUtils.getCurrTimeInMillis();
/*     */         
/* 111 */         String userid = RoleInterface.getUserId(this.roleid);
/* 112 */         int roleLevel = RoleInterface.getLevel(this.roleid);
/* 113 */         GangManager.joinGangTeamAndBroadcast(userid, this.roleid, roleLevel, this.gangTeamid, xGangTeam, gangid.longValue(), xGang, xGangMemory, now);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 118 */         GangManager.addGangTeamApplicantAndBroadcast(xGangMemory, this.gangTeamid, xGangTeam, this.roleid);
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 124 */       SInviteGangTeamRefusedNotify notify = new SInviteGangTeamRefusedNotify();
/* 125 */       notify.invitee = this.roleid;
/* 126 */       OnlineManager.getInstance().send(this.inviter, notify);
/*     */     }
/*     */     
/* 129 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PInviteGangTeamRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */