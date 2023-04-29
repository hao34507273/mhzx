/*     */ package mzm.gsp.gratefuldelivery.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.DeliveryStatus;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2gratefuldelivery;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCheckAndSendRewardMail
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final int activityId;
/*     */   private final long roleId;
/*     */   
/*     */   PCheckAndSendRewardMail(int activityId, long roleId)
/*     */   {
/*  32 */     this.activityId = activityId;
/*  33 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     SDeliveryCfg sDeliveryCfg = SDeliveryCfg.get(this.activityId);
/*  41 */     if (sDeliveryCfg == null) {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!OpenInterface.getOpenStatus(sDeliveryCfg.switchId)) {
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     DeliveryStatus xDeliveryStatus = GratefulDeliveryManager.getLatestDeliveryStatus(this.activityId, false);
/*  51 */     if ((xDeliveryStatus == null) || (xDeliveryStatus.getMail_receivers().contains(Long.valueOf(this.roleId)))) {
/*  52 */       return false;
/*     */     }
/*  54 */     boolean result = false;
/*  55 */     int activitySubtype = sDeliveryCfg.activitySubtype;
/*  56 */     switch (activitySubtype)
/*     */     {
/*     */     case 1: 
/*  59 */       result = sendMailForMothersDay();
/*  60 */       break;
/*     */     case 2: 
/*  62 */       result = sendMailForFathersDay();
/*     */     }
/*     */     
/*     */     
/*  66 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean sendMailForMothersDay()
/*     */   {
/*  77 */     SDeliveryCfg sDeliveryCfg = SDeliveryCfg.get(this.activityId);
/*  78 */     if (sDeliveryCfg == null) {
/*  79 */       return false;
/*     */     }
/*  81 */     String userId = RoleInterface.getUserId(this.roleId);
/*  82 */     if (userId == null) {
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if (!ActivityInterface.canJoinActivityToday(userId, this.roleId, this.activityId)) {
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     if (RoleInterface.getGender(this.roleId) != 2) {
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     long spouseId = MarriageInterface.getMarriedRoleid(this.roleId, false);
/*  95 */     if (spouseId > 0L) {
/*  96 */       Lockeys.lock(Role2gratefuldelivery.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(spouseId) }));
/*     */     } else {
/*  98 */       Lockeys.lock(Role2gratefuldelivery.getTable(), Collections.singletonList(Long.valueOf(this.roleId)));
/*     */     }
/*     */     
/*     */ 
/* 102 */     List<String> childrenNameList = ChildrenInterface.getOwnChildNameList(this.roleId, spouseId);
/* 103 */     if ((childrenNameList == null) || (childrenNameList.size() == 0)) {
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     DeliveryStatus xDeliveryStatus = GratefulDeliveryManager.getLatestDeliveryStatus(this.activityId, true);
/* 108 */     if (xDeliveryStatus == null) {
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     StringBuilder sb = new StringBuilder();
/* 113 */     for (String name : childrenNameList)
/*     */     {
/* 115 */       sb.append(name);
/* 116 */       sb.append("、");
/*     */     }
/* 118 */     sb.deleteCharAt(sb.length() - 1);
/*     */     
/*     */ 
/* 121 */     xDeliveryStatus.getMail_receivers().add(Long.valueOf(this.roleId));
/*     */     
/*     */ 
/* 124 */     TLogArg reason = new TLogArg(LogReason.DELIVERY_MAIL_REWARD, 1);
/* 125 */     MailInterface.asynBuildAndSendMail(this.roleId, sDeliveryCfg.mailId, null, Collections.singletonList(sb.toString()), reason);
/*     */     
/* 127 */     GratefulDeliveryManager.info(this, ".sendMailForMothersDay()@mail sent for mother's day|activity_cfgid=%d|roleid=%d", new Object[] { Integer.valueOf(this.activityId), Long.valueOf(this.roleId) });
/*     */     
/* 129 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean sendMailForFathersDay()
/*     */   {
/* 140 */     SDeliveryCfg sDeliveryCfg = SDeliveryCfg.get(this.activityId);
/* 141 */     if (sDeliveryCfg == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     String userId = RoleInterface.getUserId(this.roleId);
/* 145 */     if (userId == null) {
/* 146 */       return false;
/*     */     }
/*     */     
/* 149 */     if (!ActivityInterface.canJoinActivityToday(userId, this.roleId, this.activityId)) {
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     if (RoleInterface.getGender(this.roleId) != 1) {
/* 154 */       return false;
/*     */     }
/*     */     
/* 157 */     long spouseId = MarriageInterface.getMarriedRoleid(this.roleId, false);
/* 158 */     if (spouseId > 0L) {
/* 159 */       Lockeys.lock(Role2gratefuldelivery.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(spouseId) }));
/*     */     } else {
/* 161 */       Lockeys.lock(Role2gratefuldelivery.getTable(), Collections.singletonList(Long.valueOf(this.roleId)));
/*     */     }
/*     */     
/*     */ 
/* 165 */     List<String> childrenNameList = ChildrenInterface.getOwnChildNameList(this.roleId, spouseId);
/* 166 */     if ((childrenNameList == null) || (childrenNameList.size() == 0)) {
/* 167 */       return false;
/*     */     }
/*     */     
/* 170 */     DeliveryStatus xDeliveryStatus = GratefulDeliveryManager.getLatestDeliveryStatus(this.activityId, true);
/* 171 */     if (xDeliveryStatus == null) {
/* 172 */       return false;
/*     */     }
/*     */     
/* 175 */     StringBuilder sb = new StringBuilder();
/* 176 */     for (String name : childrenNameList)
/*     */     {
/* 178 */       sb.append(name);
/* 179 */       sb.append("、");
/*     */     }
/* 181 */     sb.deleteCharAt(sb.length() - 1);
/*     */     
/*     */ 
/* 184 */     xDeliveryStatus.getMail_receivers().add(Long.valueOf(this.roleId));
/*     */     
/*     */ 
/* 187 */     TLogArg reason = new TLogArg(LogReason.DELIVERY_MAIL_REWARD, 1);
/* 188 */     MailInterface.asynBuildAndSendMail(this.roleId, sDeliveryCfg.mailId, null, Collections.singletonList(sb.toString()), reason);
/*     */     
/* 190 */     GratefulDeliveryManager.info(this, ".sendMailForFathersDay()@mail sent for mother's day|activity_cfgid=%d|roleid=%d", new Object[] { Integer.valueOf(this.activityId), Long.valueOf(this.roleId) });
/*     */     
/* 192 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\PCheckAndSendRewardMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */