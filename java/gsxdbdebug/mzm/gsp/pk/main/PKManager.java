/*     */ package mzm.gsp.pk.main;
/*     */ 
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.pk.event.MoralValueChangeArg;
/*     */ import mzm.gsp.pk.event.MoralValueChanged;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.Pair;
/*     */ import xbean.Pod;
/*     */ import xbean.RolePKInformation;
/*     */ import xbean.RolePKTimerInformation;
/*     */ import xtable.Role2pk_info;
/*     */ import xtable.Role2pk_timer_info;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PKManager
/*     */ {
/*     */   static boolean isNotEnable()
/*     */   {
/*  29 */     return !OpenInterface.getOpenStatus(411);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Pair<Boolean, Boolean> chargeMoney(long roleId, int moneyType, int currentNum, int costNum, CostType costType, TLogArg tLogArg)
/*     */   {
/*     */     boolean chargeResult;
/*     */     
/*     */ 
/*     */ 
/*  42 */     switch (moneyType)
/*     */     {
/*     */     case 1: 
/*  45 */       String userId = RoleInterface.getUserId(roleId);
/*  46 */       if ((userId == null) || (QingfuInterface.getBalance(userId, true) != currentNum))
/*  47 */         return new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
/*  48 */       chargeResult = QingfuInterface.costYuanbao(userId, roleId, costNum, costType, tLogArg) == CostResult.Success;
/*  49 */       return new Pair(Boolean.valueOf(true), Boolean.valueOf(chargeResult));
/*     */     
/*     */     case 2: 
/*  52 */       if (RoleInterface.getGold(roleId) != currentNum)
/*  53 */         return new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
/*  54 */       chargeResult = RoleInterface.cutGold(roleId, costNum, tLogArg);
/*  55 */       return new Pair(Boolean.valueOf(true), Boolean.valueOf(chargeResult));
/*     */     
/*     */     case 3: 
/*  58 */       if (RoleInterface.getSilver(roleId) != currentNum)
/*  59 */         return new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
/*  60 */       chargeResult = RoleInterface.cutSilver(roleId, costNum, tLogArg);
/*  61 */       return new Pair(Boolean.valueOf(true), Boolean.valueOf(chargeResult));
/*     */     
/*     */     case 5: 
/*  64 */       if (RoleInterface.getGoldIngot(roleId) != currentNum)
/*  65 */         return new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
/*  66 */       chargeResult = RoleInterface.cutGold(roleId, costNum, tLogArg);
/*  67 */       return new Pair(Boolean.valueOf(true), Boolean.valueOf(chargeResult));
/*     */     
/*     */     case 4: 
/*  70 */       if (GangInterface.getBangGong(roleId) != currentNum)
/*  71 */         return new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
/*  72 */       chargeResult = GangInterface.cutBangGong(roleId, costNum, tLogArg);
/*  73 */       return new Pair(Boolean.valueOf(true), Boolean.valueOf(chargeResult));
/*     */     }
/*     */     
/*  76 */     PKLogManager.error(String.format("PKManager.chargeMoney()@invalid money type|money_type=%d", new Object[] { Integer.valueOf(moneyType) }));
/*  77 */     return new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static RolePKInformation getRolePKInformation(long roleId)
/*     */   {
/*  86 */     RolePKInformation xRolePKInformation = Role2pk_info.get(Long.valueOf(roleId));
/*  87 */     long nowInMs = DateTimeUtils.getCurrTimeInMillis();
/*  88 */     if ((xRolePKInformation != null) && (!DateTimeUtils.isInSameDay(nowInMs, xRolePKInformation.getUpdate_time() * 1000L)))
/*     */     {
/*  90 */       xRolePKInformation.setUpdate_time((int)(nowInMs / 1000L));
/*  91 */       xRolePKInformation.setActive_pk_times(0);
/*  92 */       xRolePKInformation.setPk_death_times(0);
/*  93 */       xRolePKInformation.setBought_moral_value(0);
/*     */     }
/*  95 */     return xRolePKInformation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static RolePKInformation getOrCreateRolePKInformation(long roleId)
/*     */   {
/* 104 */     long nowInMs = DateTimeUtils.getCurrTimeInMillis();
/* 105 */     RolePKInformation xRolePKInformation = Role2pk_info.get(Long.valueOf(roleId));
/* 106 */     if (xRolePKInformation == null)
/*     */     {
/* 108 */       xRolePKInformation = Pod.newRolePKInformation();
/* 109 */       xRolePKInformation.setUpdate_time((int)(nowInMs / 1000L));
/* 110 */       xRolePKInformation.setPk_mode_expire_time(0);
/* 111 */       xRolePKInformation.setProtection_expire_time(0);
/* 112 */       xRolePKInformation.setForce_protection_expire_time(0);
/* 113 */       xRolePKInformation.setActive_pk_times(0);
/* 114 */       xRolePKInformation.setPk_death_times(0);
/* 115 */       xRolePKInformation.setBought_moral_value(0);
/* 116 */       Role2pk_info.add(Long.valueOf(roleId), xRolePKInformation);
/*     */ 
/*     */ 
/*     */     }
/* 120 */     else if (!DateTimeUtils.isInSameDay(nowInMs, xRolePKInformation.getUpdate_time() * 1000L))
/*     */     {
/* 122 */       xRolePKInformation.setUpdate_time((int)(nowInMs / 1000L));
/* 123 */       xRolePKInformation.setActive_pk_times(0);
/* 124 */       xRolePKInformation.setPk_death_times(0);
/* 125 */       xRolePKInformation.setBought_moral_value(0);
/*     */     }
/*     */     
/* 128 */     return xRolePKInformation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static RolePKTimerInformation getRolePKTimerInformation(long roleId)
/*     */   {
/* 136 */     return Role2pk_timer_info.get(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static RolePKTimerInformation getOrCreateRolePKTimerInformation(long roleId)
/*     */   {
/* 145 */     RolePKTimerInformation xRolePKTimerInformation = Role2pk_timer_info.get(Long.valueOf(roleId));
/* 146 */     if (xRolePKTimerInformation == null)
/*     */     {
/* 148 */       xRolePKTimerInformation = Pod.newRolePKTimerInformation();
/* 149 */       xRolePKTimerInformation.setPk_mode_session_id(0L);
/* 150 */       xRolePKTimerInformation.setProtection_session_id(0L);
/* 151 */       xRolePKTimerInformation.setForce_protection_session_id(0L);
/* 152 */       Role2pk_timer_info.add(Long.valueOf(roleId), xRolePKTimerInformation);
/*     */     }
/* 154 */     return xRolePKTimerInformation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void triggerMoralValueChangeEvent(long roleId, int oldValue, int newValue)
/*     */   {
/* 162 */     MoralValueChangeArg arg = new MoralValueChangeArg(roleId, oldValue, newValue);
/* 163 */     TriggerEventsManger.getInstance().triggerEvent(new MoralValueChanged(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PKManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */