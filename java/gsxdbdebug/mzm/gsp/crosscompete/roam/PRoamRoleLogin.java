/*     */ package mzm.gsp.crosscompete.roam;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.RoamCrossCompeteFaction;
/*     */ import xbean.RoamCrossCompeteFactionTmp;
/*     */ import xbean.RoamCrossCompeteRole;
/*     */ import xtable.Gang;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PRoamRoleLogin extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PRoamRoleLogin(long roleid)
/*     */   {
/*  24 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  29 */     if (CrossCompeteManager.isLoggerDebugEnabled()) {
/*  30 */       CrossCompeteManager.logDebug("PRoamRoleLogin.processImp@roam role login|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  35 */     String userid = RoleInterface.getUserId(this.roleid);
/*  36 */     if (userid == null) {
/*  37 */       CrossCompeteManager.logError("PRoamRoleLogin.processImp@no userid|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  38 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  42 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*     */ 
/*  45 */     if (!mzm.gsp.status.main.RoleStatusInterface.containsStatus(this.roleid, 1502)) {
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  51 */     RoamCrossCompeteRole xRoamRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(this.roleid, true);
/*     */     
/*     */ 
/*  54 */     if (xRoamRole == null)
/*     */     {
/*  56 */       CrossCompeteManager.logError("PRoamRoleLogin.processImp@has crosscompete roam status, but no roam role data|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/*  62 */       long factionid = xRoamRole.getFactionid();
/*     */       
/*     */ 
/*  65 */       RoamCrossCompeteFaction xRoamFaction = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(factionid, false);
/*     */       
/*  67 */       if (xRoamFaction == null)
/*     */       {
/*  69 */         CrossCompeteManager.logError("PRoamRoleLogin.processImp@has crosscompete roam status, but no roam faction data|roleid=%d|factionid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(xRoamRole.getFactionid()) });
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*  75 */         long oppoFactionid = xRoamFaction.getOpponent();
/*     */         
/*  77 */         lock(Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(factionid), Long.valueOf(oppoFactionid) }));
/*  78 */         xRoamFaction = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(factionid, true);
/*     */         
/*     */ 
/*  81 */         if (!CrossCompeteRoamManager.isInRoamFaction(xRoamFaction, this.roleid))
/*     */         {
/*  83 */           CrossCompeteManager.logError("PRoamRoleLogin.processImp@role not in roam faction|roleid=%d|factionid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(factionid) });
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/*  91 */           RoamCrossCompeteFactionTmp xRoamFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(factionid, true);
/*     */           
/*  93 */           if (xRoamFactionTmp == null)
/*     */           {
/*  95 */             CrossCompeteManager.logError("PRoamRoleLogin.processImp@no roam faction tmp|roleid=%d|factionid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(factionid) });
/*     */ 
/*     */ 
/*     */ 
/*     */           }
/* 100 */           else if (xRoamFactionTmp.getWorld() < 0L)
/*     */           {
/* 102 */             CrossCompeteManager.logError("PRoamRoleLogin.processImp@no cross compete world|roleid=%d|factionid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(factionid) });
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 108 */             long srcWorld = MapInterface.getRoleWorldInstanceId(this.roleid);
/* 109 */             if (xRoamFactionTmp.getWorld() != srcWorld)
/*     */             {
/* 111 */               int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/* 112 */               if ((CrossCompeteManager.isPrepareStage(stage)) || (CrossCompeteManager.isFightStage(stage))) {
/* 113 */                 MapInterface.forceTransferToScene(this.roleid, xRoamFactionTmp.getWorld(), xRoamFactionTmp.getMapid());
/*     */                 
/*     */ 
/* 116 */                 CrossCompeteManager.logInfo("PRoamRoleLogin.processImp@transfer role|roleid=%d|factionid=%d|src_world=%d|dst_world=%d|dst_mapid=%d|stage=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(factionid), Long.valueOf(srcWorld), Long.valueOf(xRoamFactionTmp.getWorld()), Integer.valueOf(xRoamFactionTmp.getMapid()), Integer.valueOf(stage) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               }
/*     */               else
/*     */               {
/*     */ 
/*     */ 
/*     */ 
/* 127 */                 CrossCompeteManager.logError("PRoamRoleLogin.processImp@not prepare or fight stage|roleid=%d|factionid=%d|world=%d|stage=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(factionid), Long.valueOf(srcWorld), Integer.valueOf(stage) });
/*     */                 
/*     */ 
/*     */ 
/*     */ 
/*     */                 break label685;
/*     */               }
/*     */             }
/*     */             else
/*     */             {
/* 137 */               CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/* 138 */               CrossCompeteAgainst xAgainst = null;
/* 139 */               if (xCompete != null) {
/* 140 */                 xAgainst = CrossCompeteManager.getXAgainst(xCompete, factionid, oppoFactionid);
/*     */               }
/*     */               
/* 143 */               if (xAgainst == null)
/*     */               {
/* 145 */                 CrossCompeteManager.logError("PRoamRoleLogin.processImp@no against|roleid=%d|factionid=%d|opponentid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(factionid), Long.valueOf(oppoFactionid) });
/*     */                 
/*     */ 
/*     */                 break label685;
/*     */               }
/*     */               
/*     */ 
/* 152 */               CrossCompeteRoamManager.syncRoleCompete(this.roleid, xRoamRole, xRoamFaction, xAgainst.getCompete_index());
/*     */               
/* 154 */               if (CrossCompeteManager.isPrepareStage())
/*     */               {
/* 156 */                 CrossCompeteRoamManager.syncFactionPlayerNumber(this.roleid, factionid, xRoamFactionTmp);
/*     */ 
/*     */               }
/*     */               else
/*     */               {
/*     */ 
/* 162 */                 RoamCrossCompeteFaction xOppoFaction = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(oppoFactionid, true);
/*     */                 
/* 164 */                 RoamCrossCompeteFactionTmp xOppoFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(oppoFactionid, true);
/*     */                 
/*     */ 
/*     */ 
/* 168 */                 CrossCompeteRoamManager.syncAgainst(this.roleid, factionid, xRoamFaction, xRoamFactionTmp, oppoFactionid, xOppoFaction, xOppoFactionTmp);
/*     */                 
/*     */ 
/*     */ 
/*     */ 
/* 173 */                 CrossCompeteRoamManager.setFactionTitle(this.roleid, xRoamRole, xRoamFaction);
/*     */               }
/*     */             }
/*     */             
/*     */ 
/* 178 */             return true;
/*     */           }
/*     */         } } }
/*     */     label685:
/* 182 */     CrossCompeteRoamManager.clearActivityStatus(this.roleid);
/*     */     
/* 184 */     CrossCompeteRoamManager.returnOriginalServer(userid, this.roleid);
/*     */     
/* 186 */     CrossCompeteManager.logInfo("PRoamRoleLogin.processImp@clear status and return original server|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(this.roleid) });
/*     */     
/*     */ 
/* 189 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PRoamRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */