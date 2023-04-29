/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.SMountsProtectPetSuccess;
/*     */ import mzm.gsp.mounts.confbean.SMountsConsts;
/*     */ import mzm.gsp.mounts.event.MountsPetPassiveSkillChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleMountsInfo;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xtable.Role2mounts;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCMountsProtectPet extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int cellId;
/*     */   private final int protect_index;
/*     */   private final long petId;
/*     */   private int protect_pet_expand_size;
/*     */   
/*     */   public PCMountsProtectPet(long roleId, int cellId, int protect_index, long petId)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.cellId = cellId;
/*  31 */     this.protect_index = protect_index;
/*  32 */     this.petId = petId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if ((this.cellId <= 0) || (this.cellId > SMountsConsts.getInstance().maxBattleMounts))
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCMountsProtectPet.processImp"))
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!MountsManager.isLevelOpen(this.roleId, "PCMountsProtectPet.processImp"))
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  53 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*     */     
/*  55 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1038, true, true))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  61 */     if (xRole2MountsInfo == null)
/*     */     {
/*  63 */       onMountsProtectPetFail(2);
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     BattleMountsInfo xBattleMountsInfo = (BattleMountsInfo)xRole2MountsInfo.getBattle_mounts_info_map().get(Integer.valueOf(this.cellId));
/*  69 */     if (xBattleMountsInfo == null)
/*     */     {
/*  71 */       onMountsProtectPetFail(3);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     long mountsId = xBattleMountsInfo.getMounts_id();
/*  76 */     MountsInfo xMountsInfo = (MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(mountsId));
/*  77 */     if (xMountsInfo == null)
/*     */     {
/*  79 */       onMountsProtectPetFail(4);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     Map.Entry<Integer, BattleMountsInfo> xProtectBattleMountsEntryInfo = MountsManager.getProtectePetMounts(this.roleId, this.petId, xRole2MountsInfo);
/*     */     
/*     */ 
/*  86 */     if (xProtectBattleMountsEntryInfo != null)
/*     */     {
/*  88 */       onMountsProtectPetFail(8);
/*  89 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  93 */     boolean isInPetBag = mzm.gsp.pet.main.PetInterface.isPetInBag(this.roleId, this.petId, true);
/*  94 */     if (!isInPetBag)
/*     */     {
/*  96 */       onMountsProtectPetFail(7);
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     this.protect_pet_expand_size = xMountsInfo.getProtect_pet_expand_size();
/* 101 */     if ((this.protect_index < 0) || (this.protect_index > this.protect_pet_expand_size))
/*     */     {
/* 103 */       onMountsProtectPetFail(70);
/* 104 */       return false;
/*     */     }
/* 106 */     List<Long> xProtectPetIdList = xBattleMountsInfo.getProtect_pet_id_list();
/*     */     
/*     */ 
/* 109 */     if (this.protect_index >= xProtectPetIdList.size())
/*     */     {
/* 111 */       int fillSize = this.protect_index - xProtectPetIdList.size();
/* 112 */       for (int i = 0; i < fillSize; i++)
/*     */       {
/* 114 */         xProtectPetIdList.add(Long.valueOf(-1L));
/*     */       }
/* 116 */       xProtectPetIdList.add(Long.valueOf(this.petId));
/*     */ 
/*     */     }
/* 119 */     else if (((Long)xProtectPetIdList.get(this.protect_index)).longValue() == -1L)
/*     */     {
/* 121 */       xProtectPetIdList.set(this.protect_index, Long.valueOf(this.petId));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 126 */       onMountsProtectPetFail(72);
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     SMountsProtectPetSuccess sMountsProtectPetSuccess = new SMountsProtectPetSuccess();
/* 131 */     sMountsProtectPetSuccess.cell_id = this.cellId;
/* 132 */     sMountsProtectPetSuccess.protect_index = this.protect_index;
/* 133 */     sMountsProtectPetSuccess.pet_id = this.petId;
/*     */     
/* 135 */     OnlineManager.getInstance().send(this.roleId, sMountsProtectPetSuccess);
/*     */     
/* 137 */     MountsManager.triggerMountsPetPassiveSkillChangeEvent(new MountsPetPassiveSkillChangeArg(this.roleId, this.petId));
/*     */     
/* 139 */     MountsManager.tlogMountsProtectPet(userId, this.roleId, xBattleMountsInfo.getMounts_id(), xMountsInfo.getMounts_cfg_id(), xMountsInfo.getMounts_rank(), this.petId, 1, this.protect_index);
/*     */     
/*     */ 
/* 142 */     GameServer.logger().info(String.format("[mounts]PCMountsProtectPet.processImp@handle protect pet success|role_id=%d|cell_id=%d|pet_id=%d|now_protect_list=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.cellId), Long.valueOf(this.petId), xProtectPetIdList.toString() }));
/*     */     
/*     */ 
/*     */ 
/* 146 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onMountsProtectPetFail(int ret)
/*     */   {
/* 154 */     GameServer.logger().error(String.format("[mounts]PCMountsProtectPet.processImp@protect pet failed|ret=%d|role_id=%d|cell_id=%d|protect_pet_expand_size=%d|protect_index=%d|pet_id=%d", new Object[] { Integer.valueOf(ret), Long.valueOf(this.roleId), Integer.valueOf(this.cellId), Integer.valueOf(this.protect_pet_expand_size), Integer.valueOf(this.protect_index), Long.valueOf(this.petId) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 159 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 160 */     sMountsNormalFail.result = ret;
/* 161 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCMountsProtectPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */