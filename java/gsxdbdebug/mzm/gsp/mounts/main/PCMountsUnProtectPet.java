/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.SMountsUnProtectPetSuccess;
/*     */ import mzm.gsp.mounts.event.MountsPetPassiveSkillChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleMountsInfo;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2mounts;
/*     */ 
/*     */ public class PCMountsUnProtectPet extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int cellId;
/*     */   private final int protect_index;
/*     */   private final long petId;
/*     */   
/*     */   public PCMountsUnProtectPet(long roleId, int cellId, int protect_index, long petId)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.cellId = cellId;
/*  28 */     this.protect_index = protect_index;
/*  29 */     this.petId = petId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (this.cellId <= 0)
/*     */     {
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCMountsUnProtectPet.processImp"))
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!MountsManager.isLevelOpen(this.roleId, "PCMountsUnProtectPet.processImp"))
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  50 */     lock(Lockeys.get(xtable.User.getTable(), userId));
/*     */     
/*  52 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1045, true, true))
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  58 */     if (xRole2MountsInfo == null)
/*     */     {
/*  60 */       onMountsUnProtectPetFailed(2);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     Map<Integer, BattleMountsInfo> xBattleMountsInfoMap = xRole2MountsInfo.getBattle_mounts_info_map();
/*  65 */     BattleMountsInfo xBattleMountsInfo = (BattleMountsInfo)xBattleMountsInfoMap.get(Integer.valueOf(this.cellId));
/*  66 */     if (xBattleMountsInfo == null)
/*     */     {
/*  68 */       onMountsUnProtectPetFailed(3);
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     MountsInfo xMountsInfo = (MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(xBattleMountsInfo.getMounts_id()));
/*  73 */     if (xMountsInfo == null)
/*     */     {
/*  75 */       onMountsUnProtectPetFailed(4);
/*  76 */       return false;
/*     */     }
/*  78 */     List<Long> xProtectPetIdList = xBattleMountsInfo.getProtect_pet_id_list();
/*  79 */     int currentIndex = xProtectPetIdList.indexOf(Long.valueOf(this.petId));
/*  80 */     if (currentIndex < 0)
/*     */     {
/*  82 */       onMountsUnProtectPetFailed(1);
/*  83 */       return false;
/*     */     }
/*  85 */     if (currentIndex != this.protect_index)
/*     */     {
/*  87 */       onMountsUnProtectPetFailed(70);
/*  88 */       return false;
/*     */     }
/*  90 */     xProtectPetIdList.set(this.protect_index, Long.valueOf(-1L));
/*     */     
/*  92 */     MountsManager.tlogMountsProtectPet(userId, this.roleId, xBattleMountsInfo.getMounts_id(), xMountsInfo.getMounts_cfg_id(), xMountsInfo.getMounts_rank(), this.petId, 0, this.protect_index);
/*     */     
/*     */ 
/*  95 */     SMountsUnProtectPetSuccess sMountsUnProtectPetSuccess = new SMountsUnProtectPetSuccess();
/*  96 */     sMountsUnProtectPetSuccess.cell_id = this.cellId;
/*  97 */     sMountsUnProtectPetSuccess.protect_index = this.protect_index;
/*  98 */     sMountsUnProtectPetSuccess.pet_id = this.petId;
/*     */     
/* 100 */     OnlineManager.getInstance().send(this.roleId, sMountsUnProtectPetSuccess);
/*     */     
/* 102 */     MountsManager.triggerMountsPetPassiveSkillChangeEvent(new MountsPetPassiveSkillChangeArg(this.roleId, this.petId));
/*     */     
/* 104 */     GameServer.logger().info(String.format("[mounts]PCMountsUnProtectPet.processImp@handle mounts un protect pet success|role_id=%d|pet_id=%d|cell_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(this.cellId) }));
/*     */     
/*     */ 
/*     */ 
/* 108 */     return true;
/*     */   }
/*     */   
/*     */   private void onMountsUnProtectPetFailed(int ret)
/*     */   {
/* 113 */     GameServer.logger().error(String.format("[mounts]PCMountsUnProtectPet.processImp@mounts un protect pet failed|ret=%d|role_id=%d|pet_id=%d|cell_id=%d|protect_index=%d", new Object[] { Integer.valueOf(ret), Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(this.cellId), Integer.valueOf(this.protect_index) }));
/*     */     
/*     */ 
/*     */ 
/* 117 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 118 */     sMountsNormalFail.result = ret;
/*     */     
/* 120 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCMountsUnProtectPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */