/*     */ package mzm.gsp.interaction.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.interaction.SAcceptInteractionInvitationFail;
/*     */ import mzm.gsp.interaction.SNotifyDeclineInteractionInvitation;
/*     */ import mzm.gsp.interaction.SNotifyStartInteraction;
/*     */ import mzm.gsp.interaction.confbean.SInteractionCfg;
/*     */ import mzm.gsp.interaction.event.InteractionPlayed;
/*     */ import mzm.gsp.interaction.event.InteractionPlayedArg;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.PLand;
/*     */ import mzm.gsp.map.main.PPlayerFlyReq;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xtable.Basic;
/*     */ 
/*     */ 
/*     */ public class PAcceptInteractionInvitation
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final int interactionId;
/*     */   private final long activeRoleId;
/*     */   private final long passiveRoleId;
/*     */   
/*     */   public PAcceptInteractionInvitation(int interactionId, long activeRoleId, long passiveRoleId)
/*     */   {
/*  38 */     this.interactionId = interactionId;
/*  39 */     this.activeRoleId = activeRoleId;
/*  40 */     this.passiveRoleId = passiveRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (!InteractionManager.isEnable()) {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) }));
/*     */     
/*     */ 
/*  53 */     if (!InteractionInvitationContext.exists(this.interactionId, this.activeRoleId, this.passiveRoleId)) {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     if (!checkActiveRoleMoveState()) {
/*  58 */       return true;
/*     */     }
/*     */     
/*  61 */     if (!RoleStatusInterface.checkCanSetStatus(this.activeRoleId, 1833, false))
/*     */     {
/*  63 */       InteractionLogger.error("PAcceptInteractionInvitation.processImp()@active role status conflict|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/*  65 */       abortInteraction(Integer.valueOf(5));
/*  66 */       return true;
/*     */     }
/*  68 */     if (!RoleStatusInterface.checkCanSetStatus(this.passiveRoleId, 1833, true))
/*     */     {
/*  70 */       InteractionLogger.error("PAcceptInteractionInvitation.startInteractionImmediately()@status conflict|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/*     */ 
/*  73 */       abortInteraction(null);
/*  74 */       return true;
/*     */     }
/*     */     
/*  77 */     TeamRelation teamRelation = checkTeamRelation();
/*  78 */     switch (teamRelation)
/*     */     {
/*     */ 
/*     */     case SAME_TEAM_BOTH_NORMAL: 
/*  82 */       startInteractionImmediately();
/*  83 */       InteractionLogger.info("PAcceptInteractionInvitation.processImp()@success|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/*  85 */       break;
/*     */     
/*     */ 
/*     */     case SAME_TEAM_BOTH_AWAY: 
/*     */     case SAME_TEAM_PASSIVE_ROLE_AWAY: 
/*     */     case SAME_TEAM_ACTIVE_ROLE_AWAY_PASSIVE_ROLE_ALONE: 
/*     */     case DIFFERENT_TEAM_PASSIVE_ROLE_SINGLE: 
/*  92 */       startInteractionAfterTeleport();
/*  93 */       break;
/*     */     
/*     */ 
/*     */     case SAME_TEAM_ACTIVE_ROLE_AWAY: 
/*  97 */       InteractionLogger.error("PAcceptInteractionInvitation.processImp()@same team active role away|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/*  99 */       abortInteraction(Integer.valueOf(1));
/* 100 */       break;
/*     */     
/*     */ 
/*     */     case DIFFERENT_TEAM_PASSIVE_ROLE_NOT_SINGLE: 
/* 104 */       InteractionLogger.error("PAcceptInteractionInvitation.processImp()@different team passive role not single|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/* 106 */       abortInteraction(Integer.valueOf(2));
/*     */     }
/*     */     
/*     */     
/* 110 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkActiveRoleMoveState()
/*     */   {
/* 118 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.activeRoleId);
/* 119 */     if (teamInfo != null)
/*     */     {
/* 121 */       if (MapInterface.isInMoveState(teamInfo.getLeaderId()))
/*     */       {
/* 123 */         InteractionLogger.error("PAcceptInteractionInvitation.checkActiveRoleMoveState()@team in moving|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */         
/*     */ 
/* 126 */         abortInteraction(Integer.valueOf(6));
/* 127 */         return false;
/*     */       }
/* 129 */       if (teamInfo.getTeamNormalList().contains(Long.valueOf(this.activeRoleId)))
/* 130 */         return true;
/*     */     }
/* 132 */     if (MapInterface.isInMoveState(this.activeRoleId))
/*     */     {
/* 134 */       InteractionLogger.error("PAcceptInteractionInvitation.checkActiveRoleMoveState()@active role in moving|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/*     */ 
/* 137 */       abortInteraction(Integer.valueOf(6));
/* 138 */       return false;
/*     */     }
/* 140 */     return true;
/*     */   }
/*     */   
/*     */   private static enum TeamRelation
/*     */   {
/* 145 */     SAME_TEAM_BOTH_NORMAL, 
/* 146 */     SAME_TEAM_BOTH_AWAY, 
/* 147 */     SAME_TEAM_ACTIVE_ROLE_AWAY, 
/* 148 */     SAME_TEAM_PASSIVE_ROLE_AWAY, 
/* 149 */     SAME_TEAM_ACTIVE_ROLE_AWAY_PASSIVE_ROLE_ALONE, 
/* 150 */     DIFFERENT_TEAM_PASSIVE_ROLE_SINGLE, 
/* 151 */     DIFFERENT_TEAM_PASSIVE_ROLE_NOT_SINGLE;
/*     */     
/*     */ 
/*     */     private TeamRelation() {}
/*     */   }
/*     */   
/*     */   private TeamRelation checkTeamRelation()
/*     */   {
/* 159 */     TeamInfo passiveRoleTeamInfo = TeamInterface.getTeamInfoByRoleId(this.passiveRoleId);
/* 160 */     if (passiveRoleTeamInfo == null) {
/* 161 */       return TeamRelation.DIFFERENT_TEAM_PASSIVE_ROLE_SINGLE;
/*     */     }
/* 163 */     TeamInfo activeRoleTeamInfo = TeamInterface.getTeamInfoByRoleId(this.activeRoleId);
/* 164 */     if ((activeRoleTeamInfo == null) || (activeRoleTeamInfo.getTeamId() != passiveRoleTeamInfo.getTeamId()))
/*     */     {
/*     */ 
/* 167 */       if (!passiveRoleTeamInfo.getTeamNormalList().contains(Long.valueOf(this.passiveRoleId))) {
/* 168 */         return TeamRelation.DIFFERENT_TEAM_PASSIVE_ROLE_SINGLE;
/*     */       }
/* 170 */       if ((passiveRoleTeamInfo.getLeaderId() == this.passiveRoleId) && (passiveRoleTeamInfo.getTeamNormalList().size() == 1))
/* 171 */         return TeamRelation.DIFFERENT_TEAM_PASSIVE_ROLE_SINGLE;
/* 172 */       return TeamRelation.DIFFERENT_TEAM_PASSIVE_ROLE_NOT_SINGLE;
/*     */     }
/*     */     
/* 175 */     if ((activeRoleTeamInfo.getTeamNormalList().contains(Long.valueOf(this.activeRoleId))) && (passiveRoleTeamInfo.getTeamNormalList().contains(Long.valueOf(this.passiveRoleId))))
/*     */     {
/* 177 */       return TeamRelation.SAME_TEAM_BOTH_NORMAL; }
/* 178 */     if (activeRoleTeamInfo.getTeamNormalList().contains(Long.valueOf(this.activeRoleId)))
/* 179 */       return TeamRelation.SAME_TEAM_PASSIVE_ROLE_AWAY;
/* 180 */     if (passiveRoleTeamInfo.getTeamNormalList().contains(Long.valueOf(this.passiveRoleId)))
/*     */     {
/* 182 */       if (passiveRoleTeamInfo.getTeamNormalList().size() == 1) {
/* 183 */         return TeamRelation.SAME_TEAM_ACTIVE_ROLE_AWAY_PASSIVE_ROLE_ALONE;
/*     */       }
/* 185 */       return TeamRelation.SAME_TEAM_ACTIVE_ROLE_AWAY;
/*     */     }
/* 187 */     return TeamRelation.SAME_TEAM_BOTH_AWAY;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void startInteractionImmediately()
/*     */   {
/* 195 */     RoleStatusInterface.unsetStatus(this.activeRoleId, 1831);
/* 196 */     RoleStatusInterface.unsetStatus(this.passiveRoleId, 1832);
/* 197 */     RoleStatusInterface.unsetStatus(this.passiveRoleId, 1834);
/* 198 */     notifyStartInteraction();
/* 199 */     TriggerEventsManger.getInstance().triggerEvent(new InteractionPlayed(), new InteractionPlayedArg(this.interactionId, this.activeRoleId, this.passiveRoleId));
/*     */     
/* 201 */     InteractionInvitationContext.remove(this.activeRoleId);
/* 202 */     InteractionLogger.tlogInteractionPlayed(this.activeRoleId, this.passiveRoleId, this.interactionId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void startInteractionAfterTeleport()
/*     */   {
/* 214 */     if (!RoleStatusInterface.setStatus(this.passiveRoleId, 1834, false))
/*     */     {
/* 216 */       abortInteraction(Integer.valueOf(4));
/* 217 */       InteractionLogger.error("PAcceptInteractionInvitation.startInteractionAfterTeleport()@set status failed|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/*     */ 
/* 220 */       return;
/*     */     }
/*     */     
/* 223 */     if ((RoleStatusInterface.containsStatus(this.activeRoleId, 2)) && (!RoleStatusInterface.containsStatus(this.passiveRoleId, 2)))
/*     */     {
/*     */ 
/*     */ 
/* 227 */       MapInterface.getRolesPosition(Collections.singleton(Long.valueOf(this.passiveRoleId)), new RFlyAfterGetPosition(null));
/*     */     }
/* 229 */     else if ((RoleStatusInterface.containsStatus(this.passiveRoleId, 2)) && (!RoleStatusInterface.containsStatus(this.activeRoleId, 2)))
/*     */     {
/*     */ 
/*     */ 
/* 233 */       teleportPassiveRoleToActiveRole(true);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 238 */       teleportPassiveRoleToActiveRole(false);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void teleportPassiveRoleToActiveRole(boolean landAfterTeleport)
/*     */   {
/* 247 */     long activeRoleWorldInstanceId = MapInterface.getRoleWorldInstanceId(this.activeRoleId);
/* 248 */     if (activeRoleWorldInstanceId == -1L)
/*     */     {
/* 250 */       InteractionLogger.error("PAcceptInteractionInvitation.teleportPassiveRoleToActiveRole()@active role map not found|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/*     */ 
/* 253 */       abortInteraction(Integer.valueOf(5));
/* 254 */       return;
/*     */     }
/*     */     
/* 257 */     long homelandOwnerRoleId = HomelandInterface.getRoleByHomeWorldId(activeRoleWorldInstanceId, false);
/* 258 */     if (homelandOwnerRoleId > 0L)
/*     */     {
/* 260 */       HomelandInterface.transferHome(homelandOwnerRoleId, this.passiveRoleId, new PHandleTransferToHomelandResult(landAfterTeleport, null));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 265 */       MapInterface.transformToRole(this.passiveRoleId, this.activeRoleId, new PHandleTeleportResult(landAfterTeleport, null));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private class RFlyAfterGetPosition
/*     */     implements MapCallback<Map<Long, Position>>
/*     */   {
/*     */     private RFlyAfterGetPosition() {}
/*     */     
/*     */     public boolean isCallInProcedure()
/*     */     {
/* 277 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean onResult(Map<Long, Position> result)
/*     */     {
/* 284 */       Position position = (Position)result.get(Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId));
/* 285 */       if (position == null) {
/* 286 */         return false;
/*     */       }
/*     */       
/* 289 */       boolean r = new PPlayerFlyReq(PAcceptInteractionInvitation.this.passiveRoleId, position.getX(), position.getY()).call();
/* 290 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 295 */           return RoleStatusInterface.unsetStatus(PAcceptInteractionInvitation.this.passiveRoleId, 1834);
/*     */         }
/*     */       }.call();
/*     */       
/*     */ 
/* 300 */       if (!r)
/*     */       {
/* 302 */         PAcceptInteractionInvitation.this.abortInteractionInRunnable(Integer.valueOf(4));
/* 303 */         InteractionLogger.error("RFlyAfterGetPosition.onResult()@failed on flying|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(PAcceptInteractionInvitation.this.interactionId), Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) });
/*     */         
/*     */ 
/* 306 */         return false;
/*     */       }
/*     */       
/* 309 */       MapInterface.transformToRole(PAcceptInteractionInvitation.this.passiveRoleId, PAcceptInteractionInvitation.this.activeRoleId, new PAcceptInteractionInvitation.PHandleTeleportResult(PAcceptInteractionInvitation.this, false, null));
/* 310 */       InteractionLogger.info("RFlyAfterGetPosition.onResult()@success|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(PAcceptInteractionInvitation.this.interactionId), Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) });
/*     */       
/*     */ 
/* 313 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private class PHandleTransferToHomelandResult
/*     */     implements MapCallback<Boolean>
/*     */   {
/*     */     private final boolean landAfterTeleport;
/*     */     
/*     */ 
/*     */     private PHandleTransferToHomelandResult(boolean landAfterTeleport)
/*     */     {
/* 327 */       this.landAfterTeleport = landAfterTeleport;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isCallInProcedure()
/*     */     {
/* 333 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean onResult(Boolean result)
/*     */     {
/* 340 */       PAcceptInteractionInvitation.this.lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) }));
/*     */       
/*     */ 
/* 343 */       if (!InteractionInvitationContext.exists(PAcceptInteractionInvitation.this.interactionId, PAcceptInteractionInvitation.this.activeRoleId, PAcceptInteractionInvitation.this.passiveRoleId))
/*     */       {
/* 345 */         InteractionLogger.error("PHandleTransferToHomelandResult.onResult()@already cancelled|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(PAcceptInteractionInvitation.this.interactionId), Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) });
/*     */         
/* 347 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 351 */       if (!result.booleanValue())
/*     */       {
/* 353 */         InteractionLogger.error("PHandleTransferToHomelandResult.onResult()@failed on teleporting|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(PAcceptInteractionInvitation.this.interactionId), Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) });
/*     */         
/* 355 */         PAcceptInteractionInvitation.this.abortInteraction(Integer.valueOf(3));
/* 356 */         return true;
/*     */       }
/*     */       
/* 359 */       MapInterface.transformToRole(PAcceptInteractionInvitation.this.passiveRoleId, PAcceptInteractionInvitation.this.activeRoleId, new PAcceptInteractionInvitation.PHandleTeleportResult(PAcceptInteractionInvitation.this, this.landAfterTeleport, null));
/* 360 */       InteractionLogger.info("PHandleTransferToHomelandResult.onResult()@success|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(PAcceptInteractionInvitation.this.interactionId), Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) });
/*     */       
/* 362 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private class PHandleTeleportResult
/*     */     implements MapCallback<Boolean>
/*     */   {
/*     */     private final boolean landAfterTeleport;
/*     */     
/*     */ 
/*     */     private PHandleTeleportResult(boolean landAfterTeleport)
/*     */     {
/* 375 */       this.landAfterTeleport = landAfterTeleport;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isCallInProcedure()
/*     */     {
/* 381 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean onResult(Boolean result)
/*     */     {
/* 388 */       PAcceptInteractionInvitation.this.lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) }));
/*     */       
/*     */ 
/* 391 */       if (!InteractionInvitationContext.exists(PAcceptInteractionInvitation.this.interactionId, PAcceptInteractionInvitation.this.activeRoleId, PAcceptInteractionInvitation.this.passiveRoleId))
/*     */       {
/* 393 */         InteractionLogger.error("PHandleTeleportResult.onResult()@already cancelled|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(PAcceptInteractionInvitation.this.interactionId), Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) });
/*     */         
/* 395 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 399 */       if (!result.booleanValue())
/*     */       {
/* 401 */         InteractionLogger.error("PHandleTeleportResult.onResult()@failed on teleporting|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(PAcceptInteractionInvitation.this.interactionId), Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) });
/*     */         
/* 403 */         PAcceptInteractionInvitation.this.abortInteraction(Integer.valueOf(3));
/* 404 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 408 */       if (this.landAfterTeleport)
/*     */       {
/* 410 */         MapInterface.getRolesPosition(Collections.singleton(Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId)), new PAcceptInteractionInvitation.RLandAfterGetPosition(PAcceptInteractionInvitation.this, null));
/* 411 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 415 */       if (!RoleStatusInterface.checkCanSetStatus(PAcceptInteractionInvitation.this.activeRoleId, 1833, false))
/*     */       {
/* 417 */         InteractionLogger.error("PHandleTeleportResult.onResult()@active role status conflict|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(PAcceptInteractionInvitation.this.interactionId), Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) });
/*     */         
/* 419 */         PAcceptInteractionInvitation.this.abortInteraction(Integer.valueOf(5));
/* 420 */         return true;
/*     */       }
/* 422 */       if (!RoleStatusInterface.checkCanSetStatus(PAcceptInteractionInvitation.this.passiveRoleId, 1833, true))
/*     */       {
/* 424 */         InteractionLogger.error("PHandleTeleportResult.onResult()@status conflict|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(PAcceptInteractionInvitation.this.interactionId), Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) });
/*     */         
/*     */ 
/* 427 */         PAcceptInteractionInvitation.this.abortInteraction(null);
/* 428 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 432 */       PAcceptInteractionInvitation.this.startInteractionImmediately();
/* 433 */       InteractionLogger.info("PHandleTeleportResult.onResult()@success|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(PAcceptInteractionInvitation.this.interactionId), Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) });
/*     */       
/* 435 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private class RLandAfterGetPosition implements MapCallback<Map<Long, Position>>
/*     */   {
/*     */     private RLandAfterGetPosition() {}
/*     */     
/*     */     public boolean isCallInProcedure() {
/* 444 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean onResult(Map<Long, Position> result)
/*     */     {
/* 451 */       Position position = (Position)result.get(Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId));
/* 452 */       if (position == null) {
/* 453 */         return false;
/*     */       }
/*     */       
/* 456 */       boolean r = new PLand(PAcceptInteractionInvitation.this.passiveRoleId, position.getX(), position.getY()).call();
/* 457 */       if (!r)
/*     */       {
/* 459 */         PAcceptInteractionInvitation.this.abortInteractionInRunnable(Integer.valueOf(4));
/* 460 */         InteractionLogger.error("RLandAfterGetPosition.onResult()@@failed on landing|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(PAcceptInteractionInvitation.this.interactionId), Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) });
/*     */         
/*     */ 
/* 463 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 467 */       new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 473 */           lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) }));
/*     */           
/*     */ 
/* 476 */           if (!InteractionInvitationContext.exists(PAcceptInteractionInvitation.this.interactionId, PAcceptInteractionInvitation.this.activeRoleId, PAcceptInteractionInvitation.this.passiveRoleId))
/*     */           {
/* 478 */             InteractionLogger.error("RLandAfterGetPosition.processImp()@@already cancelled|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(PAcceptInteractionInvitation.this.interactionId), Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) });
/*     */             
/*     */ 
/* 481 */             return false;
/*     */           }
/*     */           
/*     */ 
/* 485 */           if (!RoleStatusInterface.checkCanSetStatus(PAcceptInteractionInvitation.this.activeRoleId, 1833, false))
/*     */           {
/* 487 */             InteractionLogger.error("RLandAfterGetPosition.processImp()@active role status conflict|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(PAcceptInteractionInvitation.this.interactionId), Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) });
/*     */             
/*     */ 
/* 490 */             PAcceptInteractionInvitation.this.abortInteraction(Integer.valueOf(5));
/* 491 */             return true;
/*     */           }
/* 493 */           if (!RoleStatusInterface.checkCanSetStatus(PAcceptInteractionInvitation.this.passiveRoleId, 1833, true))
/*     */           {
/* 495 */             InteractionLogger.error("RLandAfterGetPosition.processImp()@status conflict|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(PAcceptInteractionInvitation.this.interactionId), Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) });
/*     */             
/*     */ 
/* 498 */             PAcceptInteractionInvitation.this.abortInteraction(null);
/* 499 */             return true;
/*     */           }
/*     */           
/* 502 */           PAcceptInteractionInvitation.this.startInteractionImmediately();
/* 503 */           InteractionLogger.info("RLandAfterGetPosition.processImp()@success|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(PAcceptInteractionInvitation.this.interactionId), Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) });
/*     */           
/*     */ 
/* 506 */           return true;
/*     */         }
/*     */       }.call();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void abortInteraction(Integer acceptFailReason)
/*     */   {
/* 517 */     if (acceptFailReason != null)
/* 518 */       notifyAcceptFail(acceptFailReason.intValue());
/* 519 */     notifyDeclined();
/* 520 */     RoleStatusInterface.unsetStatus(this.activeRoleId, 1831);
/* 521 */     RoleStatusInterface.unsetStatus(this.passiveRoleId, 1832);
/* 522 */     InteractionManager.recordFailedInteractionInvitation(this.activeRoleId, this.passiveRoleId);
/* 523 */     InteractionInvitationContext.remove(this.activeRoleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void abortInteractionInRunnable(final Integer acceptFailReason)
/*     */   {
/* 531 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 536 */         lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(PAcceptInteractionInvitation.this.activeRoleId), Long.valueOf(PAcceptInteractionInvitation.this.passiveRoleId) }));
/* 537 */         PAcceptInteractionInvitation.this.abortInteraction(acceptFailReason);
/* 538 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void notifyStartInteraction()
/*     */   {
/* 548 */     SInteractionCfg interactionCfg = SInteractionCfg.get(this.interactionId);
/* 549 */     if (interactionCfg == null)
/* 550 */       return;
/* 551 */     SNotifyStartInteraction startInteraction = new SNotifyStartInteraction();
/* 552 */     startInteraction.interaction_id = this.interactionId;
/* 553 */     startInteraction.inviter_role_id = this.activeRoleId;
/* 554 */     startInteraction.invitee_role_id = this.passiveRoleId;
/* 555 */     if ((interactionCfg.activeRoleGenderLimit == 1) && (RoleInterface.getGender(this.activeRoleId) != 1))
/*     */     {
/*     */ 
/* 558 */       startInteraction.active_role_id = this.passiveRoleId;
/* 559 */       startInteraction.passive_role_id = this.activeRoleId;
/*     */     }
/* 561 */     else if ((interactionCfg.activeRoleGenderLimit == 2) && (RoleInterface.getGender(this.activeRoleId) != 2))
/*     */     {
/*     */ 
/* 564 */       startInteraction.active_role_id = this.passiveRoleId;
/* 565 */       startInteraction.passive_role_id = this.activeRoleId;
/*     */     }
/*     */     else
/*     */     {
/* 569 */       startInteraction.active_role_id = this.activeRoleId;
/* 570 */       startInteraction.passive_role_id = this.passiveRoleId;
/*     */     }
/* 572 */     MapInterface.asyncBroadcastInSight(this.activeRoleId, startInteraction, true);
/*     */   }
/*     */   
/*     */   private void notifyAcceptFail(int reason)
/*     */   {
/* 577 */     SAcceptInteractionInvitationFail fail = new SAcceptInteractionInvitationFail();
/* 578 */     fail.reason = reason;
/* 579 */     fail.interaction_id = this.interactionId;
/* 580 */     fail.active_role_id = this.activeRoleId;
/* 581 */     OnlineManager.getInstance().send(this.passiveRoleId, fail);
/*     */   }
/*     */   
/*     */   private void notifyDeclined()
/*     */   {
/* 586 */     SNotifyDeclineInteractionInvitation notification = new SNotifyDeclineInteractionInvitation();
/* 587 */     notification.interaction_id = this.interactionId;
/* 588 */     notification.passive_role_id = this.passiveRoleId;
/* 589 */     OnlineManager.getInstance().send(this.activeRoleId, notification);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\main\PAcceptInteractionInvitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */