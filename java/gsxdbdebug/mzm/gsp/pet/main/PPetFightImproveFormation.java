/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.item.confbean.SPetFightFormationFragmentCfg;
/*     */ import mzm.gsp.item.confbean.SPetFightFormationItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetFightImproveFormationFail;
/*     */ import mzm.gsp.pet.SPetFightImproveFormationSuccess;
/*     */ import mzm.gsp.pet.confbean.PetFightFormationImproveCfg;
/*     */ import mzm.gsp.pet.confbean.PetFightFormationLevelInfo;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.PetFightFormationInfo;
/*     */ import xbean.RolePetFightFormation;
/*     */ 
/*     */ 
/*     */ public class PPetFightImproveFormation
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int formationId;
/*     */   private final long itemUUID;
/*     */   private final boolean useAll;
/*     */   
/*     */   public PPetFightImproveFormation(long roleId, int formationId, long itemUUID, boolean useAll)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.formationId = formationId;
/*  34 */     this.itemUUID = itemUUID;
/*  35 */     this.useAll = useAll;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!PetFightManager.isEnabled())
/*     */     {
/*  43 */       return false;
/*     */     }
/*  45 */     if (!PetFightManager.isRoleLevelEnough(this.roleId))
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 2091, true))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     BasicItem item = ItemInterface.getItemByUuid(this.roleId, this.itemUUID);
/*  55 */     if (item == null)
/*     */     {
/*  57 */       onFail(2);
/*  58 */       PetFightManager.logError("PPetFightImproveFormation.processImp()@item not exists|roleid=%d|item_uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.itemUUID) });
/*     */       
/*  60 */       return false;
/*     */     }
/*  62 */     SPetFightFormationItemCfg itemCfg = SPetFightFormationItemCfg.get(item.getCfgId());
/*  63 */     SPetFightFormationFragmentCfg fragmentCfg = SPetFightFormationFragmentCfg.get(item.getCfgId());
/*  64 */     if ((itemCfg == null) && (fragmentCfg == null))
/*     */     {
/*  66 */       onFail(1);
/*  67 */       PetFightManager.logError("PPetFightImproveFormation.processImp()@invalid item|roleid=%d|item_uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.itemUUID) });
/*     */       
/*  69 */       return false;
/*     */     }
/*     */     
/*     */     PetFightFormationInfo xPetFightFormationInfo;
/*     */     PetFightFormationInfo xPetFightFormationInfo;
/*  74 */     if ((itemCfg != null) && (itemCfg.formationId == this.formationId))
/*     */     {
/*  76 */       RolePetFightFormation xRolePetFightFormation = PetFightManager.getOrCreateRolePetFightFormation(this.roleId);
/*  77 */       xPetFightFormationInfo = PetFightManager.getOrCreatePetFightFormationInfo(xRolePetFightFormation, this.formationId);
/*     */     }
/*     */     else
/*     */     {
/*  81 */       RolePetFightFormation xRolePetFightFormation = PetFightManager.getRolePetFightFormation(this.roleId, true);
/*  82 */       if (xRolePetFightFormation == null)
/*     */       {
/*  84 */         onFail(4);
/*  85 */         PetFightManager.logError("PPetFightImproveFormation.processImp()@formation locked|roleid=%d|formationid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.formationId) });
/*     */         
/*  87 */         return false;
/*     */       }
/*  89 */       xPetFightFormationInfo = (PetFightFormationInfo)xRolePetFightFormation.getFormation_info().get(Integer.valueOf(this.formationId));
/*  90 */       if ((xPetFightFormationInfo == null) || (xPetFightFormationInfo.getLevel() < 1))
/*     */       {
/*  92 */         onFail(4);
/*  93 */         PetFightManager.logError("PPetFightImproveFormation.processImp()@formation locked|roleid=%d|formationid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.formationId) });
/*     */         
/*  95 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  99 */     int providedExp = itemCfg != null ? itemCfg.exp / 2 : itemCfg.formationId == this.formationId ? itemCfg.exp : fragmentCfg.exp;
/*     */     
/* 101 */     PetFightFormationImproveCfg improveCfg = PetFightFormationImproveCfg.get(this.formationId);
/* 102 */     if (improveCfg == null)
/*     */     {
/* 104 */       return false;
/*     */     }
/* 106 */     int maxLevel = improveCfg.levels.size() - 1;
/* 107 */     if (xPetFightFormationInfo.getLevel() >= maxLevel)
/*     */     {
/* 109 */       onFail(3, this.formationId);
/* 110 */       PetFightManager.logError("PPetFightImproveFormation.processImp()@reach max level|roleid=%d|formationid=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.formationId), Integer.valueOf(xPetFightFormationInfo.getLevel()) });
/*     */       
/*     */ 
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     int itemUseCount = this.useAll ? item.getNumber() : 1;
/* 117 */     int level = xPetFightFormationInfo.getLevel();
/* 118 */     int exp = xPetFightFormationInfo.getExp();
/* 119 */     TLogArg tLogArg = new TLogArg(LogReason.PET_FIGHT_IMPROVE_FORMATION);
/* 120 */     for (int i = 0; i < itemUseCount; i++)
/*     */     {
/* 122 */       if (!ItemInterface.removeItemByUuid(this.roleId, this.itemUUID, 1, tLogArg))
/*     */       {
/* 124 */         onFail(2);
/* 125 */         PetFightManager.logError("PPetFightImproveFormation.processImp()@item not exists|roleid=%d|item_uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.itemUUID) });
/*     */         
/* 127 */         return false;
/*     */       }
/*     */       
/* 130 */       exp += providedExp;
/*     */       
/* 132 */       int expToNextLevel = ((PetFightFormationLevelInfo)improveCfg.levels.get(level)).expToNextLevel;
/* 133 */       if (exp >= expToNextLevel)
/*     */       {
/* 135 */         exp -= expToNextLevel;
/* 136 */         level++;
/* 137 */         if (level >= maxLevel) {
/*     */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 143 */     xPetFightFormationInfo.setLevel(level);
/* 144 */     xPetFightFormationInfo.setExp(exp);
/* 145 */     onSuccess(this.formationId, level, exp);
/* 146 */     PetFightManager.logInfo("PPetFightImproveFormation.processImp()@success|roleid=%d|formationid=%d|level=%d|exp=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.formationId), Integer.valueOf(level), Integer.valueOf(exp) });
/*     */     
/* 148 */     return true;
/*     */   }
/*     */   
/*     */   private void onSuccess(int formationId, int newLevel, int newExp)
/*     */   {
/* 153 */     SPetFightImproveFormationSuccess success = new SPetFightImproveFormationSuccess();
/* 154 */     success.formation_id = formationId;
/* 155 */     success.level = newLevel;
/* 156 */     success.exp = newExp;
/* 157 */     OnlineManager.getInstance().send(this.roleId, success);
/* 158 */     PetFightManager.tlogImproveFormation(this.roleId, formationId, newLevel, newExp);
/*     */   }
/*     */   
/*     */   private void onFail(int reason)
/*     */   {
/* 163 */     onFail(reason, 0);
/*     */   }
/*     */   
/*     */   private void onFail(int reason, int formationId)
/*     */   {
/* 168 */     SPetFightImproveFormationFail fail = new SPetFightImproveFormationFail();
/* 169 */     fail.reason = reason;
/* 170 */     fail.formation_id = formationId;
/* 171 */     OnlineManager.getInstance().sendAtOnce(this.roleId, fail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PPetFightImproveFormation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */