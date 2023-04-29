/*     */ package mzm.gsp.crosscompete.roam;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*     */ import mzm.gsp.map.event.MapRoleCreatedArg;
/*     */ import mzm.gsp.map.event.MapRoleCreatedProcedure;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import xbean.RoamCrossCompeteFaction;
/*     */ import xbean.RoamCrossCompeteFactionTmp;
/*     */ import xbean.RoamCrossCompeteRole;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnMapRoleCreated
/*     */   extends MapRoleCreatedProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  23 */     if (!GameServerInfoManager.isRoamServer()) {
/*  24 */       return false;
/*     */     }
/*     */     
/*  27 */     if (CrossCompeteManager.isLoggerDebugEnabled()) {
/*  28 */       CrossCompeteManager.logDebug("POnMapRoleCreated.processImp@create roam map role|roleid=%d|world=%d|mapid=%d", new Object[] { Long.valueOf(((MapRoleCreatedArg)this.arg).roleid), Long.valueOf(((MapRoleCreatedArg)this.arg).worldid), Integer.valueOf(((MapRoleCreatedArg)this.arg).mapid) });
/*     */     }
/*     */     
/*     */ 
/*  32 */     String userid = RoleInterface.getUserId(((MapRoleCreatedArg)this.arg).roleid);
/*  33 */     if (userid == null) {
/*  34 */       CrossCompeteManager.logError("POnMapRoleCreated.processImp@no userid|roleid=%d|world=%d|mapid=%d", new Object[] { Long.valueOf(((MapRoleCreatedArg)this.arg).roleid), Long.valueOf(((MapRoleCreatedArg)this.arg).worldid), Integer.valueOf(((MapRoleCreatedArg)this.arg).mapid) });
/*     */       
/*  36 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  40 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*     */ 
/*     */ 
/*  44 */     if (RoleStatusInterface.containsStatus(((MapRoleCreatedArg)this.arg).roleid, 1502))
/*     */     {
/*     */ 
/*  47 */       RoamCrossCompeteRole xRoamRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(((MapRoleCreatedArg)this.arg).roleid, true);
/*     */       
/*     */ 
/*  50 */       if (xRoamRole == null)
/*     */       {
/*  52 */         CrossCompeteManager.logError("POnMapRoleCreated.processImp@has crosscompete roam status, but no roam role data|roleid=%d|world=%d|mapid=%d", new Object[] { Long.valueOf(((MapRoleCreatedArg)this.arg).roleid), Long.valueOf(((MapRoleCreatedArg)this.arg).worldid), Integer.valueOf(((MapRoleCreatedArg)this.arg).mapid) });
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*  59 */         RoamCrossCompeteFaction xRoamFaction = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(xRoamRole.getFactionid(), true);
/*     */         
/*     */ 
/*  62 */         if (xRoamFaction == null)
/*     */         {
/*  64 */           CrossCompeteManager.logError("POnMapRoleCreated.processImp@has crosscompete roam status, but no roam faction data|roleid=%d|factionid=%d|world=%d|mapid=%d", new Object[] { Long.valueOf(((MapRoleCreatedArg)this.arg).roleid), Long.valueOf(xRoamRole.getFactionid()), Long.valueOf(((MapRoleCreatedArg)this.arg).worldid), Integer.valueOf(((MapRoleCreatedArg)this.arg).mapid) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*  71 */         else if (!CrossCompeteRoamManager.isInRoamFaction(xRoamFaction, ((MapRoleCreatedArg)this.arg).roleid))
/*     */         {
/*  73 */           CrossCompeteManager.logError("POnMapRoleCreated.processImp@role not in roam faction|roleid=%d|factionid=%d|world=%d|mapid=%d", new Object[] { Long.valueOf(((MapRoleCreatedArg)this.arg).roleid), Long.valueOf(xRoamRole.getFactionid()), Long.valueOf(((MapRoleCreatedArg)this.arg).worldid), Integer.valueOf(((MapRoleCreatedArg)this.arg).mapid) });
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/*  81 */           RoamCrossCompeteFactionTmp xRoamFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(xRoamRole.getFactionid(), true);
/*     */           
/*     */ 
/*  84 */           if (xRoamFactionTmp == null)
/*     */           {
/*  86 */             CrossCompeteManager.logError("POnMapRoleCreated.processImp@no roam faction tmp|roleid=%d|factionid=%d|world=%d|mapid=%d", new Object[] { Long.valueOf(((MapRoleCreatedArg)this.arg).roleid), Long.valueOf(xRoamRole.getFactionid()), Long.valueOf(((MapRoleCreatedArg)this.arg).worldid), Integer.valueOf(((MapRoleCreatedArg)this.arg).mapid) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           }
/*  92 */           else if (xRoamFactionTmp.getWorld() < 0L)
/*     */           {
/*  94 */             CrossCompeteManager.logError("POnMapRoleCreated.processImp@no cross compete world|roleid=%d|factionid=%d|world=%d|mapid=%d", new Object[] { Long.valueOf(((MapRoleCreatedArg)this.arg).roleid), Long.valueOf(xRoamRole.getFactionid()), Long.valueOf(((MapRoleCreatedArg)this.arg).worldid), Integer.valueOf(((MapRoleCreatedArg)this.arg).mapid) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           }
/* 100 */           else if (xRoamFactionTmp.getWorld() != ((MapRoleCreatedArg)this.arg).worldid)
/*     */           {
/*     */ 
/* 103 */             int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*     */             
/* 105 */             if ((CrossCompeteManager.isPrepareStage()) || (CrossCompeteManager.isFightStage())) {
/* 106 */               MapInterface.forceTransferToScene(((MapRoleCreatedArg)this.arg).roleid, xRoamFactionTmp.getWorld(), xRoamFactionTmp.getMapid());
/*     */               
/*     */ 
/* 109 */               CrossCompeteManager.logInfo("POnMapRoleCreated.processImp@transfer role|roleid=%d|factionid=%d|src_world=%d|src_mapid=%d|dst_world=%d|dst_mapid=%d|stage=%d", new Object[] { Long.valueOf(((MapRoleCreatedArg)this.arg).roleid), Long.valueOf(xRoamRole.getFactionid()), Long.valueOf(((MapRoleCreatedArg)this.arg).worldid), Integer.valueOf(((MapRoleCreatedArg)this.arg).mapid), Long.valueOf(xRoamFactionTmp.getWorld()), Integer.valueOf(xRoamFactionTmp.getMapid()), Integer.valueOf(stage) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 121 */               CrossCompeteManager.logError("POnMapRoleCreated.processImp@not prepare or fight stage|roleid=%d|factionid=%d|world=%d|mapid=%d|stage=%d", new Object[] { Long.valueOf(((MapRoleCreatedArg)this.arg).roleid), Long.valueOf(xRoamRole.getFactionid()), Long.valueOf(((MapRoleCreatedArg)this.arg).worldid), Integer.valueOf(((MapRoleCreatedArg)this.arg).mapid), Integer.valueOf(stage) });
/*     */               
/*     */               break label1044;
/*     */             }
/*     */             
/* 126 */             return true;
/*     */           }
/*     */           else
/*     */           {
/* 130 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 136 */       RoamCrossCompeteRole xRoamRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(((MapRoleCreatedArg)this.arg).roleid, true);
/*     */       
/* 138 */       if (xRoamRole == null) {
/* 139 */         return true;
/*     */       }
/*     */       
/* 142 */       RoamCrossCompeteFactionTmp xRoamFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(xRoamRole.getFactionid(), true);
/*     */       
/*     */ 
/* 145 */       if (xRoamFactionTmp == null) {
/* 146 */         return true;
/*     */       }
/* 148 */       if ((((MapRoleCreatedArg)this.arg).worldid == xRoamFactionTmp.getWorld()) && (((MapRoleCreatedArg)this.arg).mapid == xRoamFactionTmp.getMapid())) {
/* 149 */         MapInterface.forceTransferWhenFault(((MapRoleCreatedArg)this.arg).roleid);
/* 150 */         CrossCompeteManager.logError("POnMapRoleCreated.processImp@no cross compete status, but in activity world|userid=%s|roleid=%d|factionid=%d|world=%d|mapid=%d", new Object[] { userid, Long.valueOf(((MapRoleCreatedArg)this.arg).roleid), Long.valueOf(xRoamRole.getFactionid()), Long.valueOf(((MapRoleCreatedArg)this.arg).worldid), Integer.valueOf(((MapRoleCreatedArg)this.arg).mapid) });
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 156 */         return true;
/*     */       }
/*     */     }
/*     */     label1044:
/* 160 */     CrossCompeteRoamManager.clearActivityStatus(((MapRoleCreatedArg)this.arg).roleid);
/*     */     
/* 162 */     CrossCompeteRoamManager.returnOriginalServer(userid, ((MapRoleCreatedArg)this.arg).roleid);
/*     */     
/* 164 */     CrossCompeteManager.logInfo("POnMapRoleCreated.processImp@clear status and return original server|userid=%s|roleid=%d|world=%d|mapid=%d", new Object[] { userid, Long.valueOf(((MapRoleCreatedArg)this.arg).roleid), Long.valueOf(((MapRoleCreatedArg)this.arg).worldid), Integer.valueOf(((MapRoleCreatedArg)this.arg).mapid) });
/*     */     
/*     */ 
/*     */ 
/* 168 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\POnMapRoleCreated.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */