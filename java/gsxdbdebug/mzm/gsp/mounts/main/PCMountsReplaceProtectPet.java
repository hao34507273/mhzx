/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.SMountsReplaceProtectPetSuccess;
/*     */ import mzm.gsp.mounts.confbean.SMountsConsts;
/*     */ import mzm.gsp.mounts.event.MountsPetPassiveSkillChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2mounts;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCMountsReplaceProtectPet
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int cellId;
/*     */   private final int protect_index;
/*     */   private final long oldPetId;
/*     */   private final long nowPetId;
/*     */   private long mountsId;
/*     */   private int mountsCfgId;
/*     */   
/*     */   public PCMountsReplaceProtectPet(long roleId, int cellId, int protect_index, long oldPetId, long nowPetId)
/*     */   {
/*  43 */     this.roleId = roleId;
/*  44 */     this.cellId = cellId;
/*  45 */     this.protect_index = protect_index;
/*  46 */     this.oldPetId = oldPetId;
/*  47 */     this.nowPetId = nowPetId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  53 */     if ((this.cellId <= 0) || (this.cellId > SMountsConsts.getInstance().maxBattleMounts))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCMountsReplaceProtectPet.processImp"))
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     if (!MountsManager.isLevelOpen(this.roleId, "PCMountsReplaceProtectPet.processImp"))
/*     */     {
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     String userId = RoleInterface.getUserId(this.roleId);
/*  69 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  71 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1041, true, true))
/*     */     {
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  77 */     if (xRole2MountsInfo == null)
/*     */     {
/*  79 */       onMountsReplaceProtectPetFail(2);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     Map.Entry<Integer, xbean.BattleMountsInfo> xBattleMountsInfoEntry = MountsManager.getProtectePetMounts(this.roleId, this.oldPetId, xRole2MountsInfo);
/*     */     
/*  85 */     if (xBattleMountsInfoEntry == null)
/*     */     {
/*  87 */       onMountsReplaceProtectPetFail(3);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     boolean isInPetBag = PetInterface.isPetInBag(this.roleId, this.nowPetId, true);
/*  92 */     if (!isInPetBag)
/*     */     {
/*  94 */       onMountsReplaceProtectPetFail(7);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     boolean isInProtectState = MountsManager.isPetInProtect(this.roleId, this.nowPetId, xRole2MountsInfo);
/*  99 */     if (isInProtectState)
/*     */     {
/* 101 */       onMountsReplaceProtectPetFail(8);
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     xbean.BattleMountsInfo xBattleMountsInfo = (xbean.BattleMountsInfo)xBattleMountsInfoEntry.getValue();
/* 106 */     this.mountsId = xBattleMountsInfo.getMounts_id();
/*     */     
/* 108 */     MountsInfo xMountsInfo = (MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(this.mountsId));
/* 109 */     if (xMountsInfo == null)
/*     */     {
/* 111 */       onMountsReplaceProtectPetFail(4);
/* 112 */       return false;
/*     */     }
/* 114 */     this.mountsCfgId = xMountsInfo.getMounts_cfg_id();
/*     */     
/* 116 */     int currentIndex = xBattleMountsInfo.getProtect_pet_id_list().indexOf(Long.valueOf(this.oldPetId));
/* 117 */     if (currentIndex < 0)
/*     */     {
/* 119 */       onMountsReplaceProtectPetFail(1);
/* 120 */       return false;
/*     */     }
/* 122 */     if (currentIndex != this.protect_index)
/*     */     {
/* 124 */       onMountsReplaceProtectPetFail(70);
/* 125 */       return false;
/*     */     }
/* 127 */     xBattleMountsInfo.getProtect_pet_id_list().set(this.protect_index, Long.valueOf(this.nowPetId));
/*     */     
/* 129 */     SMountsReplaceProtectPetSuccess sMountsReplaceProtectPetSuccess = new SMountsReplaceProtectPetSuccess();
/* 130 */     sMountsReplaceProtectPetSuccess.cell_id = this.cellId;
/* 131 */     sMountsReplaceProtectPetSuccess.protect_index = this.protect_index;
/* 132 */     mzm.gsp.mounts.BattleMountsInfo battleMountsInfo = sMountsReplaceProtectPetSuccess.battle_mounts_info;
/* 133 */     battleMountsInfo.is_chief_battle_mounts = (xRole2MountsInfo.getCurrent_chief_battle_mounts() == this.cellId ? 1 : 0);
/*     */     
/* 135 */     battleMountsInfo.mounts_id = this.mountsId;
/* 136 */     battleMountsInfo.protect_pet_id_list.addAll(xBattleMountsInfo.getProtect_pet_id_list());
/*     */     
/* 138 */     OnlineManager.getInstance().send(this.roleId, sMountsReplaceProtectPetSuccess);
/*     */     
/*     */ 
/* 141 */     MountsManager.triggerMountsPetPassiveSkillChangeEvent(new MountsPetPassiveSkillChangeArg(this.roleId, this.oldPetId));
/*     */     
/* 143 */     MountsManager.triggerMountsPetPassiveSkillChangeEvent(new MountsPetPassiveSkillChangeArg(this.roleId, this.nowPetId));
/*     */     
/*     */ 
/* 146 */     MountsManager.tlogMountsProtectPet(userId, this.roleId, this.mountsId, this.mountsCfgId, xMountsInfo.getMounts_rank(), this.oldPetId, 0, this.protect_index);
/*     */     
/*     */ 
/* 149 */     MountsManager.tlogMountsProtectPet(userId, this.roleId, this.mountsId, this.mountsCfgId, xMountsInfo.getMounts_rank(), this.nowPetId, 1, this.protect_index);
/*     */     
/*     */ 
/* 152 */     GameServer.logger().info(String.format("[mounts]PCMountsReplaceProtectPet.processImp@handle replace protect pet success|role_id=%d|cell_id=%d|old_pet_id=%d|now_pet_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.cellId), Long.valueOf(this.oldPetId), Long.valueOf(this.nowPetId) }));
/*     */     
/*     */ 
/*     */ 
/* 156 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onMountsReplaceProtectPetFail(int ret)
/*     */   {
/* 166 */     onMountsReplaceProtectPetFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onMountsReplaceProtectPetFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 171 */     StringBuilder sbLog = new StringBuilder();
/* 172 */     sbLog.append("[mounts]PCMountsReplaceProtectPet.processImp@mounts replace protect pet failed");
/* 173 */     sbLog.append("|ret=").append(ret);
/* 174 */     sbLog.append("|role_id=").append(this.roleId);
/* 175 */     sbLog.append("|cell_id=").append(this.cellId);
/* 176 */     sbLog.append("|protect_index=").append(this.protect_index);
/* 177 */     sbLog.append("|old_pet_id=").append(this.oldPetId);
/* 178 */     sbLog.append("|now_pet_id=").append(this.nowPetId);
/* 179 */     sbLog.append("|mounts_id=").append(this.mountsId);
/* 180 */     sbLog.append("|mounts_cfg_id=").append(this.mountsCfgId);
/* 181 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 183 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 185 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 188 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 190 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 191 */     sMountsNormalFail.result = ret;
/*     */     
/* 193 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCMountsReplaceProtectPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */