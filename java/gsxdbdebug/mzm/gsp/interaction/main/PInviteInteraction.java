/*     */ package mzm.gsp.interaction.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.interaction.SInviteInteractionFail;
/*     */ import mzm.gsp.interaction.SInviteInteractionSuccess;
/*     */ import mzm.gsp.interaction.SNotifyReceiveInteractionInvitation;
/*     */ import mzm.gsp.interaction.confbean.SInteractionCfg;
/*     */ import mzm.gsp.map.confbean.SMapConfig;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.mounts.main.MountsInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.InteractionInvitationBanRecord;
/*     */ import xtable.Basic;
/*     */ 
/*     */ 
/*     */ public class PInviteInteraction
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long activeRoleId;
/*     */   private final long passiveRoleId;
/*     */   private final int interactionId;
/*     */   
/*     */   public PInviteInteraction(int interactionId, long activeRoleId, long passiveRoleId)
/*     */   {
/*  35 */     this.interactionId = interactionId;
/*  36 */     this.activeRoleId = activeRoleId;
/*  37 */     this.passiveRoleId = passiveRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if (!InteractionManager.isEnable()) {
/*  44 */       return false;
/*     */     }
/*  46 */     SInteractionCfg interactionCfg = SInteractionCfg.get(this.interactionId);
/*  47 */     if (interactionCfg == null) {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) }));
/*     */     
/*  53 */     if (!checkOnlineStatus()) {
/*  54 */       return false;
/*     */     }
/*  56 */     if (!checkRoleLevels()) {
/*  57 */       return false;
/*     */     }
/*  59 */     if (!checkRoleGenders(interactionCfg)) {
/*  60 */       return false;
/*     */     }
/*  62 */     if (!checkActiveRoleMoveState()) {
/*  63 */       return false;
/*     */     }
/*  65 */     if (!checkBanRecord()) {
/*  66 */       return false;
/*     */     }
/*  68 */     if (!checkInvitationStatus()) {
/*  69 */       return false;
/*     */     }
/*  71 */     if (!checkTeamRelation()) {
/*  72 */       return false;
/*     */     }
/*  74 */     if (!checkRolePositions()) {
/*  75 */       return false;
/*     */     }
/*  77 */     if (!checkMultiRoleMount()) {
/*  78 */       return false;
/*     */     }
/*  80 */     if (!checkPassiveRoleStatusConflict()) {
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     if (!RoleStatusInterface.setStatus(this.activeRoleId, 1831, true))
/*     */     {
/*  86 */       InteractionLogger.error("PInviteInteraction.processImp()@failed on setting status|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/*     */ 
/*  89 */       return false;
/*     */     }
/*  91 */     if (!RoleStatusInterface.setStatus(this.passiveRoleId, 1832, false))
/*     */     {
/*  93 */       InteractionLogger.error("PInviteInteraction.processImp()@failed on setting status|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/*     */ 
/*  96 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 100 */     if (!InteractionInvitationContext.add(this.interactionId, this.activeRoleId, this.passiveRoleId))
/*     */     {
/* 102 */       InteractionLogger.error("PInviteInteraction.processImp()@failed on creating context|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/*     */ 
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     notifySuccess();
/* 109 */     InteractionLogger.info("PInviteInteraction.processImp()@success|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */     
/* 111 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkOnlineStatus()
/*     */   {
/* 119 */     if (!OnlineManager.getInstance().isOnline(this.passiveRoleId))
/*     */     {
/* 121 */       notifyFail(11);
/* 122 */       InteractionLogger.error("PInviteInteraction.checkOnlineStatus()passive role offline|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/*     */ 
/* 125 */       return false;
/*     */     }
/* 127 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkRoleLevels()
/*     */   {
/* 135 */     InteractionManager.meetLevelCondition(this.passiveRoleId);
/* 136 */     if (!InteractionManager.meetLevelCondition(this.activeRoleId))
/*     */     {
/* 138 */       notifyFail(2);
/* 139 */       InteractionLogger.error("PInviteInteraction.checkRoleLevels()@active role's level too low|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/*     */ 
/* 142 */       return false;
/*     */     }
/* 144 */     if (!InteractionManager.meetLevelCondition(this.passiveRoleId))
/*     */     {
/* 146 */       notifyFail(3);
/* 147 */       InteractionLogger.error("PInviteInteraction.checkRoleLevels()@passive role's level too low|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/*     */ 
/* 150 */       return false;
/*     */     }
/* 152 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkRoleGenders(SInteractionCfg interactionCfg)
/*     */   {
/* 160 */     if (interactionCfg.targetCanBeSameGender)
/* 161 */       return true;
/* 162 */     if (RoleInterface.getGender(this.activeRoleId) == RoleInterface.getGender(this.passiveRoleId))
/*     */     {
/* 164 */       notifyFail(4);
/* 165 */       InteractionLogger.error("PInviteInteraction.checkRoleGenders()@same gender error|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/*     */ 
/* 168 */       return false;
/*     */     }
/* 170 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkActiveRoleMoveState()
/*     */   {
/* 178 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.activeRoleId);
/* 179 */     if (teamInfo != null)
/*     */     {
/* 181 */       if (MapInterface.isInMoveState(teamInfo.getLeaderId()))
/*     */       {
/* 183 */         notifyFail(18);
/* 184 */         InteractionLogger.error("PInviteInteraction.checkActiveRoleMoveState()@team in moving|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */         
/*     */ 
/* 187 */         return false;
/*     */       }
/* 189 */       if (teamInfo.getTeamNormalList().contains(Long.valueOf(this.activeRoleId)))
/* 190 */         return true;
/*     */     }
/* 192 */     if (MapInterface.isInMoveState(this.activeRoleId))
/*     */     {
/* 194 */       notifyFail(18);
/* 195 */       InteractionLogger.error("PInviteInteraction.checkActiveRoleMoveState()@active role in moving|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/*     */ 
/* 198 */       return false;
/*     */     }
/* 200 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkBanRecord()
/*     */   {
/* 208 */     InteractionInvitationBanRecord xInvitationBanRecord = InteractionManager.getInvitationBanRecord(this.activeRoleId, this.passiveRoleId);
/*     */     
/* 210 */     if (xInvitationBanRecord == null)
/* 211 */       return true;
/* 212 */     int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 213 */     if (now > xInvitationBanRecord.getBan_time())
/* 214 */       return true;
/* 215 */     notifyFail(1);
/* 216 */     InteractionLogger.error("PInviteInteraction.checkBanRecord()@temporarily banned|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */     
/* 218 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkInvitationStatus()
/*     */   {
/* 226 */     if (RoleStatusInterface.containsStatus(this.activeRoleId, 1831))
/*     */     {
/* 228 */       notifyFail(6);
/* 229 */       InteractionLogger.error("PInviteInteraction.checkInvitationStatus()@active role is inviting other|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/* 231 */       return false;
/*     */     }
/* 233 */     if (RoleStatusInterface.containsStatus(this.activeRoleId, 1832))
/*     */     {
/* 235 */       notifyFail(7);
/* 236 */       InteractionLogger.error("PInviteInteraction.checkInvitationStatus()@active role is being invited|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/* 238 */       return false;
/*     */     }
/* 240 */     if (RoleStatusInterface.containsStatus(this.passiveRoleId, 1831))
/*     */     {
/* 242 */       notifyFail(8);
/* 243 */       InteractionLogger.error("PInviteInteraction.checkInvitationStatus()@passive role is inviting other|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/* 245 */       return false;
/*     */     }
/* 247 */     if (RoleStatusInterface.containsStatus(this.passiveRoleId, 1832))
/*     */     {
/* 249 */       notifyFail(9);
/* 250 */       InteractionLogger.error("PInviteInteraction.checkInvitationStatus()@passive role is being invited|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/* 252 */       return false;
/*     */     }
/* 254 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkTeamRelation()
/*     */   {
/* 263 */     TeamInfo activeRoleTeamInfo = TeamInterface.getTeamInfoByRoleId(this.activeRoleId);
/* 264 */     if (activeRoleTeamInfo != null)
/*     */     {
/* 266 */       if (activeRoleTeamInfo.getTeamMemberList().contains(Long.valueOf(this.passiveRoleId))) {
/* 267 */         return true;
/*     */       }
/* 269 */       if ((activeRoleTeamInfo.getLeaderId() != this.activeRoleId) && (activeRoleTeamInfo.getTeamNormalList().contains(Long.valueOf(this.activeRoleId))))
/*     */       {
/*     */ 
/* 272 */         notifyFail(21);
/* 273 */         InteractionLogger.error("PInviteInteraction.checkTeamRelation()@active role not leader and passive role not teammate|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */         
/*     */ 
/* 276 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 280 */     TeamInfo passiveRoleTeamInfo = TeamInterface.getTeamInfoByRoleId(this.passiveRoleId);
/*     */     
/* 282 */     if (passiveRoleTeamInfo == null) {
/* 283 */       return true;
/*     */     }
/* 285 */     if ((passiveRoleTeamInfo.getLeaderId() == this.passiveRoleId) && (passiveRoleTeamInfo.getTeamNormalList().size() == 1)) {
/* 286 */       return true;
/*     */     }
/* 288 */     if (!passiveRoleTeamInfo.getTeamNormalList().contains(Long.valueOf(this.passiveRoleId)))
/* 289 */       return true;
/* 290 */     notifyFail(5);
/* 291 */     InteractionLogger.error("PInviteInteraction.checkTeamRelation()@not same team not single status|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */     
/*     */ 
/* 294 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkMultiRoleMount()
/*     */   {
/* 303 */     if (MountsInterface.isOnMultiRoleMounts(this.activeRoleId, false))
/*     */     {
/* 305 */       notifyFail(19);
/* 306 */       InteractionLogger.error("PInviteInteraction.checkMultiRoleMount()@active role in multi-role mount|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/* 308 */       return false;
/*     */     }
/* 310 */     if (MountsInterface.isOnMultiRoleMounts(this.passiveRoleId, false))
/*     */     {
/* 312 */       notifyFail(20);
/* 313 */       InteractionLogger.error("PInviteInteraction.checkMultiRoleMount()@passive role in multi-role mount|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/* 315 */       return false;
/*     */     }
/* 317 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkPassiveRoleStatusConflict()
/*     */   {
/* 326 */     Set<Integer> statusSet = RoleStatusInterface.getStatusSet(this.passiveRoleId);
/* 327 */     if (statusSet.contains(Integer.valueOf(0)))
/*     */     {
/* 329 */       notifyFail(12);
/* 330 */       InteractionLogger.error("PInviteInteraction.checkActiveRoleStatusConflict()@passive role in combat|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/* 332 */       return false;
/*     */     }
/* 334 */     if (statusSet.contains(Integer.valueOf(28)))
/*     */     {
/* 336 */       notifyFail(13);
/* 337 */       InteractionLogger.error("PInviteInteraction.checkActiveRoleStatusConflict()@passive role in watching moon|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/* 339 */       return false;
/*     */     }
/* 341 */     if ((statusSet.contains(Integer.valueOf(32))) || (statusSet.contains(Integer.valueOf(33))))
/*     */     {
/* 343 */       notifyFail(14);
/* 344 */       InteractionLogger.error("PInviteInteraction.checkActiveRoleStatusConflict()@passive role in escorting|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/* 346 */       return false;
/*     */     }
/* 348 */     if (statusSet.contains(Integer.valueOf(29)))
/*     */     {
/* 350 */       notifyFail(15);
/* 351 */       InteractionLogger.error("PInviteInteraction.checkActiveRoleStatusConflict()@passive role in marriage parade|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/* 353 */       return false;
/*     */     }
/* 355 */     if (statusSet.contains(Integer.valueOf(1661)))
/*     */     {
/* 357 */       notifyFail(16);
/* 358 */       InteractionLogger.error("PInviteInteraction.checkActiveRoleStatusConflict()@passive role in marriage parade|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/* 360 */       return false;
/*     */     }
/* 362 */     if (statusSet.contains(Integer.valueOf(10)))
/*     */     {
/* 364 */       notifyFail(17);
/* 365 */       InteractionLogger.error("PInviteInteraction.checkActiveRoleStatusConflict()@passive role in marriage parade|active_roleid=%d|passive_roleid=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/* 367 */       return false;
/*     */     }
/* 369 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkRolePositions()
/*     */   {
/* 379 */     int activeRoleMapId = MapInterface.getRoleMapId(this.activeRoleId);
/* 380 */     SMapConfig activeRoleMapCfg = SMapConfig.get(activeRoleMapId);
/* 381 */     if (activeRoleMapCfg == null)
/*     */     {
/* 383 */       InteractionLogger.error("PInviteInteraction.checkRolePositions()@active map not found|active_roleid=%d|map_cfgid=%d", new Object[] { Long.valueOf(this.activeRoleId), Integer.valueOf(activeRoleMapId) });
/*     */       
/* 385 */       notifyFail(10);
/* 386 */       return false;
/*     */     }
/* 388 */     int passiveRoleMapId = MapInterface.getRoleMapId(this.passiveRoleId);
/* 389 */     SMapConfig passiveRoleMapCfg = SMapConfig.get(passiveRoleMapId);
/* 390 */     if (passiveRoleMapCfg == null)
/*     */     {
/* 392 */       InteractionLogger.error("PInviteInteraction.checkRolePositions()@passive map not found|passive_roleid=%d|map_cfgid=%d", new Object[] { Long.valueOf(this.passiveRoleId), Integer.valueOf(passiveRoleMapId) });
/*     */       
/* 394 */       notifyFail(10);
/* 395 */       return false;
/*     */     }
/* 397 */     if ((activeRoleMapCfg.mapType == 1) && (passiveRoleMapCfg.mapType == 1))
/*     */     {
/* 399 */       if (activeRoleMapId != passiveRoleMapId)
/*     */       {
/* 401 */         InteractionLogger.error("PInviteInteraction.checkRolePositions()@in different instances|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */         
/*     */ 
/* 404 */         notifyFail(10);
/* 405 */         return false;
/*     */       }
/* 407 */       if (MapInterface.getRoleWorldInstanceId(this.activeRoleId) != MapInterface.getRoleWorldInstanceId(this.passiveRoleId))
/*     */       {
/* 409 */         InteractionLogger.error("PInviteInteraction.checkRolePositions()@in different worlds|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */         
/*     */ 
/* 412 */         notifyFail(10);
/* 413 */         return false;
/*     */       }
/* 415 */       return true;
/*     */     }
/* 417 */     if ((activeRoleMapCfg.mapType == 1) || (passiveRoleMapCfg.mapType == 1))
/*     */     {
/* 419 */       InteractionLogger.error("PInviteInteraction.checkRolePositions()@in different worlds|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*     */       
/*     */ 
/* 422 */       notifyFail(10);
/* 423 */       return false;
/*     */     }
/* 425 */     return true;
/*     */   }
/*     */   
/*     */   private void notifySuccess()
/*     */   {
/* 430 */     SInviteInteractionSuccess success = new SInviteInteractionSuccess();
/* 431 */     success.interaction_id = this.interactionId;
/* 432 */     success.passive_role_id = this.passiveRoleId;
/* 433 */     OnlineManager.getInstance().send(this.activeRoleId, success);
/*     */     
/* 435 */     String activeRoleName = RoleInterface.getName(this.activeRoleId);
/* 436 */     if (activeRoleName == null)
/* 437 */       return;
/* 438 */     SNotifyReceiveInteractionInvitation notification = new SNotifyReceiveInteractionInvitation();
/* 439 */     notification.interaction_id = this.interactionId;
/* 440 */     notification.active_role_id = this.activeRoleId;
/*     */     try
/*     */     {
/* 443 */       notification.active_role_name.setString(activeRoleName, "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e)
/*     */     {
/* 447 */       InteractionLogger.error("PInviteInteraction.notifySuccess()@unsupported encoding exception", new Object[0]);
/* 448 */       return;
/*     */     }
/* 450 */     OnlineManager.getInstance().send(this.passiveRoleId, notification);
/*     */   }
/*     */   
/*     */   private void notifyFail(int reason)
/*     */   {
/* 455 */     SInviteInteractionFail fail = new SInviteInteractionFail();
/* 456 */     fail.reason = reason;
/* 457 */     fail.interaction_id = this.interactionId;
/* 458 */     fail.passive_role_id = this.passiveRoleId;
/* 459 */     OnlineManager.getInstance().sendAtOnce(this.activeRoleId, fail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\main\PInviteInteraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */