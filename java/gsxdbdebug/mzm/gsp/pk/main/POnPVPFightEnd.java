/*     */ package mzm.gsp.pk.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fight.event.PVPFightEndArg;
/*     */ import mzm.gsp.fight.event.PVPFightEndProcedure;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.EquipmentItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.RoleEquipBag;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pk.SNotifyPKPenalty;
/*     */ import mzm.gsp.pk.confbean.SPKConsts;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.RolePKInformation;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnPVPFightEnd
/*     */   extends PVPFightEndProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!(((PVPFightEndArg)this.arg).context instanceof PKFightContext)) {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     Lockeys.lock(Basic.getTable(), ((PVPFightEndArg)this.arg).getAllRoles());
/*     */     
/*     */ 
/*  44 */     Map<Long, Integer> moralValuePenaltyMap = new HashMap();
/*     */     
/*  46 */     Set<Long> equipmentPenaltySet = new HashSet();
/*     */     
/*     */ 
/*  49 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).activeRoleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  51 */       applyMoralValuePenalty(roleId, moralValuePenaltyMap);
/*     */       
/*  53 */       if (((PVPFightEndArg)this.arg).activeDeadRoles.contains(Long.valueOf(roleId)))
/*     */       {
/*  55 */         applyEquipmentPenalty(roleId, equipmentPenaltySet);
/*  56 */         updateDeathTimeAndCheckProtectionStatus(roleId, true);
/*  57 */         if (((PVPFightEndArg)this.arg).getLoserList().contains(Long.valueOf(roleId)))
/*     */         {
/*  59 */           PKStatusManager.unsetPKEnabled(roleId);
/*  60 */           PKLogManager.info(String.format("POnPVPFightEnd.processImp()@lost and died|roleid=%d", new Object[] { Long.valueOf(roleId) }));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  66 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).passiveDeadRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  68 */       applyEquipmentPenalty(roleId, equipmentPenaltySet);
/*  69 */       updateDeathTimeAndCheckProtectionStatus(roleId, false);
/*     */     }
/*     */     
/*     */ 
/*  73 */     for (Long roleId : ((PVPFightEndArg)this.arg).getAllRoles())
/*     */     {
/*  75 */       int moralValuePenalty = moralValuePenaltyMap.containsKey(roleId) ? ((Integer)moralValuePenaltyMap.get(roleId)).intValue() : 0;
/*  76 */       int equipmentPenalty = equipmentPenaltySet.contains(roleId) ? SPKConsts.getInstance().PK_DEATH_EQUIPMENT_PENALTY / 100 : 0;
/*     */       
/*  78 */       if ((moralValuePenalty != 0) || (equipmentPenalty != 0))
/*     */       {
/*  80 */         SNotifyPKPenalty sNotifyPKPenalty = new SNotifyPKPenalty();
/*  81 */         sNotifyPKPenalty.moral_value_penalty = moralValuePenalty;
/*  82 */         sNotifyPKPenalty.equipment_usability_penalty = equipmentPenalty;
/*  83 */         OnlineManager.getInstance().send(roleId.longValue(), sNotifyPKPenalty);
/*     */       }
/*     */     }
/*  86 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void applyMoralValuePenalty(long roleId, Map<Long, Integer> penaltyMap)
/*     */   {
/*  94 */     RolePKInformation xRolePKInformation = PKManager.getOrCreateRolePKInformation(roleId);
/*  95 */     int moralValuePenalty = SPKConsts.getInstance().PK_MORAL_VALUE_REDUCE_FACTOR_A * ((PVPFightEndArg)this.arg).passiveDeadRoles.size() + SPKConsts.getInstance().PK_MORAL_VALUE_REDUCE_FACTOR_B * xRolePKInformation.getActive_pk_times();
/*     */     
/*  97 */     moralValuePenalty = Math.min(moralValuePenalty, (int)MallInterface.getJifen(roleId, 7));
/*  98 */     if (moralValuePenalty == 0)
/*     */     {
/* 100 */       PKLogManager.info(String.format("POnPVPFightEnd.applyMoralValuePenalty()@no moral value cut|roleid=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/* 102 */       return;
/*     */     }
/*     */     
/* 105 */     TLogArg tLogArg = new TLogArg(LogReason.START_PK);
/* 106 */     JifenOperateResult jifenOperateResult = MallInterface.cutJifen(roleId, moralValuePenalty, 7, tLogArg);
/*     */     
/* 108 */     if (jifenOperateResult.isSuccess())
/*     */     {
/* 110 */       penaltyMap.put(Long.valueOf(roleId), Integer.valueOf(moralValuePenalty));
/* 111 */       int currentMoralValue = (int)MallInterface.getJifen(roleId, 7);
/* 112 */       PKManager.triggerMoralValueChangeEvent(roleId, currentMoralValue + moralValuePenalty, currentMoralValue);
/*     */     }
/*     */     else
/*     */     {
/* 116 */       PKLogManager.error(String.format("POnPVPFightEnd.applyMoralValuePenalty()@error when cutJifen()|roleid=%d", new Object[] { Long.valueOf(roleId) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void applyEquipmentPenalty(long roleId, Set<Long> penaltySet)
/*     */   {
/* 126 */     RoleEquipBag bag = ItemInterface.getRoleEquipBag(roleId);
/* 127 */     if (bag == null)
/* 128 */       return;
/* 129 */     for (int i = 0; i <= 5; i++)
/*     */     {
/* 131 */       BasicItem basicItem = bag.get(i);
/* 132 */       if ((basicItem != null) && ((basicItem instanceof EquipmentItem)))
/*     */       {
/* 134 */         EquipmentItem item = (EquipmentItem)basicItem;
/* 135 */         item.reduceUsePointByRatio(SPKConsts.getInstance().PK_DEATH_EQUIPMENT_PENALTY);
/* 136 */         penaltySet.add(Long.valueOf(roleId));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateDeathTimeAndCheckProtectionStatus(long roleId, boolean isActiveRole)
/*     */   {
/* 146 */     RolePKInformation xRolePKInformation = PKManager.getOrCreateRolePKInformation(roleId);
/* 147 */     xRolePKInformation.setPk_death_times(xRolePKInformation.getPk_death_times() + 1);
/* 148 */     if (xRolePKInformation.getPk_death_times() >= SPKConsts.getInstance().MAX_PK_DEATH_TIMES_PER_DAY)
/*     */     {
/* 150 */       PKStatusManager.setForceProtection(roleId);
/* 151 */       PKLogManager.info(String.format("POnPVPFightEnd.processImp()@enter force protection status|roleid=%d", new Object[] { Long.valueOf(roleId) }));
/*     */ 
/*     */     }
/* 154 */     else if (!isActiveRole)
/*     */     {
/* 156 */       PKStatusManager.setProtection(roleId);
/* 157 */       PKLogManager.info(String.format("POnPVPFightEnd.processImp()@enter protection status|roleid=%d", new Object[] { Long.valueOf(roleId) }));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */