/*     */ package mzm.gsp.interaction.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.interaction.SNotifyCancelInteractionInvitation;
/*     */ import mzm.gsp.interaction.SNotifyDeclineInteractionInvitation;
/*     */ import mzm.gsp.interaction.confbean.SInteractionConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.InteractionInvitationBanRecord;
/*     */ import xbean.InteractionInvitationBanRecords;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2interaction_invitation_ban_records;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class InteractionManager
/*     */ {
/*     */   static boolean isEnable()
/*     */   {
/*  27 */     return OpenInterface.getOpenStatus(481);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean meetLevelCondition(long roleId)
/*     */   {
/*  35 */     return RoleInterface.getLevel(roleId) >= SInteractionConsts.getInstance().OPEN_LEVEL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static InteractionInvitationBanRecord getInvitationBanRecord(long activeRoleId, long passiveRoleId)
/*     */   {
/*  43 */     InteractionInvitationBanRecords xInvitationBanRecords = Role2interaction_invitation_ban_records.get(Long.valueOf(activeRoleId));
/*     */     
/*  45 */     if (xInvitationBanRecords == null)
/*  46 */       return null;
/*  47 */     return (InteractionInvitationBanRecord)xInvitationBanRecords.getRecords().get(Long.valueOf(passiveRoleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static InteractionInvitationBanRecord getOrCreateInvitationBanRecord(long activeRoleId, long passiveRoleId)
/*     */   {
/*  56 */     InteractionInvitationBanRecords xInvitationBanRecords = Role2interaction_invitation_ban_records.get(Long.valueOf(activeRoleId));
/*     */     
/*  58 */     if (xInvitationBanRecords == null)
/*     */     {
/*  60 */       xInvitationBanRecords = Pod.newInteractionInvitationBanRecords();
/*  61 */       Role2interaction_invitation_ban_records.add(Long.valueOf(activeRoleId), xInvitationBanRecords);
/*     */     }
/*  63 */     InteractionInvitationBanRecord xInvitationBanRecord = (InteractionInvitationBanRecord)xInvitationBanRecords.getRecords().get(Long.valueOf(passiveRoleId));
/*  64 */     if (xInvitationBanRecord == null)
/*     */     {
/*  66 */       xInvitationBanRecord = Pod.newInteractionInvitationBanRecord();
/*  67 */       int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*  68 */       xInvitationBanRecord.setReset_time(now);
/*  69 */       xInvitationBanRecord.setFail_count(0);
/*  70 */       xInvitationBanRecord.setBan_time(0);
/*  71 */       xInvitationBanRecords.getRecords().put(Long.valueOf(passiveRoleId), xInvitationBanRecord);
/*     */     }
/*  73 */     return xInvitationBanRecord;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void recordFailedInteractionInvitation(long activeRoleId, long passiveRoleId)
/*     */   {
/*  81 */     int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*  82 */     InteractionInvitationBanRecord xBanRecord = getOrCreateInvitationBanRecord(activeRoleId, passiveRoleId);
/*     */     
/*  84 */     if (xBanRecord.getReset_time() - now >= SInteractionConsts.getInstance().INVITE_FAIL_DETERMINE_DURATION * 60L)
/*     */     {
/*     */ 
/*  87 */       xBanRecord.setReset_time(now);
/*  88 */       xBanRecord.setFail_count(0);
/*     */     }
/*  90 */     xBanRecord.setFail_count(xBanRecord.getFail_count() + 1);
/*  91 */     if (xBanRecord.getFail_count() > SInteractionConsts.getInstance().INVITE_FAIL_BAN_TIMES)
/*     */     {
/*  93 */       xBanRecord.setBan_time(now + (int)(SInteractionConsts.getInstance().INVITE_FAIL_BAN_DURATION * 60L));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean cancelOrDeclineInteractionInvitationOnEvent(long roleId)
/*     */   {
/* 103 */     InteractionInvitationContext context = InteractionInvitationContext.get(roleId);
/* 104 */     if (context == null) {
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     long activeRoleId = context.activeRoleId;
/* 109 */     long passiveRoleId = context.passiveRoleId;
/* 110 */     Lockeys.lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(activeRoleId), Long.valueOf(passiveRoleId) }));
/* 111 */     context = InteractionInvitationContext.remove(roleId);
/*     */     
/*     */ 
/* 114 */     if (context == null)
/* 115 */       return false;
/* 116 */     if ((context.activeRoleId != activeRoleId) || (context.passiveRoleId != passiveRoleId)) {
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     RoleStatusInterface.unsetStatus(context.activeRoleId, 1831);
/* 121 */     RoleStatusInterface.unsetStatus(context.passiveRoleId, 1832);
/*     */     
/*     */ 
/* 124 */     recordFailedInteractionInvitation(context.activeRoleId, context.passiveRoleId);
/*     */     
/*     */ 
/* 127 */     if (roleId == context.activeRoleId)
/*     */     {
/* 129 */       SNotifyCancelInteractionInvitation cancelled = new SNotifyCancelInteractionInvitation();
/* 130 */       cancelled.interaction_id = context.interactionId;
/* 131 */       cancelled.active_role_id = context.activeRoleId;
/* 132 */       OnlineManager.getInstance().send(context.passiveRoleId, cancelled);
/* 133 */       InteractionLogger.info("InteractionManager.cancelOrDeclineInteractionInvitationOnEvent()@cancelled|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(context.interactionId), Long.valueOf(context.activeRoleId), Long.valueOf(context.passiveRoleId) });
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 139 */       SNotifyDeclineInteractionInvitation declined = new SNotifyDeclineInteractionInvitation();
/* 140 */       declined.interaction_id = context.interactionId;
/* 141 */       declined.passive_role_id = context.passiveRoleId;
/* 142 */       OnlineManager.getInstance().send(context.activeRoleId, declined);
/* 143 */       InteractionLogger.info("InteractionManager.cancelOrDeclineInteractionInvitationOnEvent()@declined|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(context.interactionId), Long.valueOf(context.activeRoleId), Long.valueOf(context.passiveRoleId) });
/*     */     }
/*     */     
/*     */ 
/* 147 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\main\InteractionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */