/*     */ package mzm.gsp.pk.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.confirm.main.TeamConfirmContext;
/*     */ import mzm.gsp.confirm.main.TeamConfirmHandler;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pk.SNotifyTeamPKConfirm;
/*     */ import mzm.gsp.pk.SStartPKFail;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import xio.Protocol;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PKTeamConfirmHandler
/*     */   implements TeamConfirmHandler
/*     */ {
/*     */   public Protocol getConfirmProtocol(long teamId, int confirmType, TeamConfirmContext context)
/*     */   {
/*  27 */     if ((confirmType == 3) && ((context instanceof PKTeamConfirmContext)))
/*     */     {
/*  29 */       PKTeamConfirmContext ctx = (PKTeamConfirmContext)context;
/*  30 */       SNotifyTeamPKConfirm sNotifyTeamPKConfirm = new SNotifyTeamPKConfirm();
/*  31 */       sNotifyTeamPKConfirm.role_id = ctx.targetRoleId;
/*  32 */       return sNotifyTeamPKConfirm;
/*     */     }
/*     */     
/*  35 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean afterAllAccepted(long teamId, int confirmType, TeamConfirmContext context)
/*     */   {
/*  45 */     if ((confirmType != 3) || (!(context instanceof PKTeamConfirmContext))) {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     PKTeamConfirmContext ctx = (PKTeamConfirmContext)context;
/*  50 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId, false);
/*  51 */     if (teamInfo == null)
/*     */     {
/*  53 */       PKLogManager.error(String.format("PKTeamConfirmHandler.afterAllAccepted()@team not exists|teamid=%d", new Object[] { Long.valueOf(teamId) }));
/*  54 */       return false;
/*     */     }
/*  56 */     if ((teamInfo.getLeaderId() != ctx.activeRoleId) && (!RoleStatusInterface.containsStatus(ctx.activeRoleId, 7)))
/*     */     {
/*     */ 
/*  59 */       PKLogManager.error(String.format("PKTeamConfirmHandler.afterAllAccepted()@not team leader or in temp leaving|teamid=%d|roleid=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(ctx.activeRoleId) }));
/*     */       
/*     */ 
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     PStartPK.InnerStatus status = new PStartPK.InnerStatus();
/*     */     
/*     */ 
/*  68 */     PStartPK.holdAllLocks(status, ctx.activeRoleId, ctx.targetRoleId);
/*  69 */     if (status.returnFalse)
/*     */     {
/*  71 */       notifyFail(status, ctx);
/*  72 */       PKLogManager.error(String.format("PKTeamConfirmHandler.afterAllAccepted()@cannot hold correct locks|active_roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(ctx.activeRoleId), Long.valueOf(ctx.targetRoleId) }));
/*     */       
/*     */ 
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  79 */     checkActiveTeamMembers(status, ctx);
/*  80 */     if (status.returnFalse)
/*     */     {
/*  82 */       notifyFail(status, ctx);
/*  83 */       PKLogManager.error(String.format("PKTeamConfirmHandler.afterAllAccepted()@team changed after confirmation|active_roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(ctx.activeRoleId), Long.valueOf(ctx.targetRoleId) }));
/*     */       
/*     */ 
/*  86 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  90 */     PStartPK.checkPKRoleRelation(status, ctx.activeRoleId, ctx.targetRoleId);
/*  91 */     if (status.returnFalse) {
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     PStartPK.checkMap(status, ctx.activeRoleId);
/*  96 */     if (status.returnFalse)
/*     */     {
/*  98 */       notifyFail(status, ctx);
/*  99 */       PKLogManager.error(String.format("PKTeamConfirmHandler.afterAllAccepted()@@in safe map|active_roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(ctx.activeRoleId), Long.valueOf(ctx.targetRoleId) }));
/*     */       
/*     */ 
/* 102 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 106 */     PStartPK.checkDistance(status, ctx.activeRoleId, ctx.targetRoleId);
/* 107 */     if (status.returnFalse)
/*     */     {
/* 109 */       notifyFail(status, ctx);
/* 110 */       PKLogManager.error(String.format("PKTeamConfirmHandler.afterAllAccepted()@distance too far away|active_roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(ctx.activeRoleId), Long.valueOf(ctx.targetRoleId) }));
/*     */       
/*     */ 
/* 113 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 117 */     PStartPK.checkFightStatus(status, ctx.activeRoleId, ctx.targetRoleId);
/* 118 */     if (status.returnFalse)
/*     */     {
/* 120 */       notifyFail(status, ctx);
/* 121 */       PKLogManager.error(String.format("PKTeamConfirmHandler.afterAllAccepted()@in fight status|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(ctx.activeRoleId), Long.valueOf(ctx.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 124 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 128 */     PStartPK.checkPKStatus(status, ctx.activeRoleId);
/* 129 */     if (status.returnFalse)
/*     */     {
/* 131 */       notifyFail(status, ctx);
/* 132 */       PKLogManager.error(String.format("PKTeamConfirmHandler.afterAllAccepted()@pk status not enabled|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(ctx.activeRoleId), Long.valueOf(ctx.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 135 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 139 */     PStartPK.checkActivePKTimes(status, ctx.activeRoleId);
/* 140 */     if (status.returnFalse)
/*     */     {
/* 142 */       notifyFail(status, ctx);
/* 143 */       PKLogManager.error(String.format("PKTeamConfirmHandler.afterAllAccepted()@max pk times reached|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(ctx.activeRoleId), Long.valueOf(ctx.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 146 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 150 */     PStartPK.checkZeroMoralValue(status, ctx.activeRoleId);
/* 151 */     if (status.returnFalse)
/*     */     {
/* 153 */       notifyFail(status, ctx);
/* 154 */       PKLogManager.error(String.format("PStartPK.processImp()@zero moral value|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(ctx.activeRoleId), Long.valueOf(ctx.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 157 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 161 */     PStartPK.checkActiveRoleForceProtection(status, ctx.activeRoleId);
/* 162 */     if (status.returnFalse)
/*     */     {
/* 164 */       notifyFail(status, ctx);
/* 165 */       PKLogManager.error(String.format("PKTeamConfirmHandler.afterAllAccepted()@cannot start pk (force protected)|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(ctx.activeRoleId), Long.valueOf(ctx.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 168 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 172 */     PStartPK.checkTargetLevel(status);
/* 173 */     if (status.returnFalse)
/*     */     {
/* 175 */       notifyFail(status, ctx);
/* 176 */       PKLogManager.error(String.format("PKTeamConfirmHandler.afterAllAccepted()@target level too low|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(ctx.activeRoleId), Long.valueOf(ctx.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 179 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 183 */     PStartPK.checkTargetRoleProtection(status);
/* 184 */     if (status.returnFalse)
/*     */     {
/* 186 */       notifyFail(status, ctx);
/* 187 */       PKLogManager.error(String.format("PKTeamConfirmHandler.afterAllAccepted()@cannot be pk target (protected)|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(ctx.activeRoleId), Long.valueOf(ctx.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 190 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 194 */     PStartPK.checkOutPrisonProtection(status, ctx.activeRoleId);
/* 195 */     if (status.returnFalse)
/*     */     {
/* 197 */       notifyFail(status, ctx);
/* 198 */       PKLogManager.error(String.format("PStartPK.processImp()@out of prison protection|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(ctx.activeRoleId), Long.valueOf(ctx.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 201 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 205 */     PStartPK.checkOtherStatusConflict(status, ctx.activeRoleId);
/* 206 */     if (status.returnFalse)
/*     */     {
/* 208 */       notifyFail(status, ctx);
/* 209 */       PKLogManager.error(String.format("PKTeamConfirmHandler.afterAllAccepted()@status conflict|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(ctx.activeRoleId), Long.valueOf(ctx.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 212 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 216 */     PKFightContext fightContext = new PKFightContext();
/* 217 */     fightContext.mainActiveRoleId = ctx.activeRoleId;
/* 218 */     fightContext.mainTargetRoleId = ctx.targetRoleId;
/*     */     long passiveRoleId;
/* 220 */     long passiveRoleId; if (status.targetTeamId == null)
/*     */     {
/* 222 */       passiveRoleId = ctx.targetRoleId;
/*     */     }
/*     */     else
/*     */     {
/* 226 */       passiveRoleId = status.targetInTempLeaving ? ctx.targetRoleId : TeamInterface.getTeamLeaderByTeamid(status.targetTeamId.longValue(), true);
/*     */     }
/*     */     
/* 229 */     FightInterface.startPVPFight(ctx.activeRoleId, passiveRoleId, fightContext, 25, FightReason.PK_FIGHT);
/* 230 */     PKLogManager.info(String.format("PKTeamConfirmHandler.afterAllAccepted()@team pk started|active_roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(ctx.activeRoleId), Long.valueOf(ctx.targetRoleId) }));
/*     */     
/*     */ 
/* 233 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void checkActiveTeamMembers(PStartPK.InnerStatus status, PKTeamConfirmContext context)
/*     */   {
/* 242 */     if (status.activeRoleInTempLeaving)
/* 243 */       return;
/* 244 */     if ((context.activeRoleIds.size() < context.activeRoleIds.size()) || (!context.activeRoleIds.containsAll(status.activeRoleIds)))
/*     */     {
/*     */ 
/* 247 */       status.returnFalse = true;
/* 248 */       status.returnCode = 3;
/*     */     }
/*     */   }
/*     */   
/*     */   private void notifyFail(PStartPK.InnerStatus status, PKTeamConfirmContext ctx)
/*     */   {
/* 254 */     SStartPKFail sStartPKFail = new SStartPKFail();
/* 255 */     sStartPKFail.retcode = status.returnCode;
/* 256 */     sStartPKFail.role_type = status.returnRoleType;
/* 257 */     if ((status.returnRoleId != -1L) && (status.returnRoleType > 0))
/*     */     {
/*     */       try
/*     */       {
/* 261 */         String name = RoleInterface.getName(status.returnRoleId);
/* 262 */         if (name != null)
/*     */         {
/* 264 */           sStartPKFail.role_name.setString(name, "UTF-8");
/*     */         }
/*     */       }
/*     */       catch (UnsupportedEncodingException e)
/*     */       {
/* 269 */         PKLogManager.error("PStartPK.notifyFail()@unsupported encoding exception");
/*     */       }
/*     */     }
/* 272 */     OnlineManager.getInstance().sendMultiAtOnce(sStartPKFail, ctx.activeRoleIds);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PKTeamConfirmHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */