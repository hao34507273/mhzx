/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SExpandProtectPetSizeSuccess;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.confbean.SMountsProtectCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2mounts;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCExpandProtectPetSize extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long mountsId;
/*     */   private final long clientYuanBao;
/*     */   private final int needYuanBao;
/*     */   private final int isUseYuanBao;
/*     */   private int mountsCfgId;
/*     */   private int protect_pet_expand_size;
/*     */   
/*     */   public PCExpandProtectPetSize(long roleId, long mounts_id, int isUseYuanBao, long clientYuanBao, int needYuanBao)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.mountsId = mounts_id;
/*  33 */     this.isUseYuanBao = isUseYuanBao;
/*  34 */     this.clientYuanBao = clientYuanBao;
/*  35 */     this.needYuanBao = needYuanBao;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if ((this.isUseYuanBao != 0) || (this.needYuanBao < 0) || (this.clientYuanBao < 0L))
/*     */     {
/*     */ 
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!MountsManager.isExpandProtectPetSizeSwitchOpen(this.roleId, "PCExpandProtectPetSize.processImp"))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     if (!MountsManager.isLevelOpen(this.roleId, "PCExpandProtectPetSize.processImp"))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     String userId = RoleInterface.getUserId(this.roleId);
/*  59 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  61 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1049, true, true))
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*     */     
/*  68 */     if (xRole2MountsInfo == null)
/*     */     {
/*  70 */       onExpandProtectPetSizeFail(2);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     Map<Long, MountsInfo> xMountsInfoMap = xRole2MountsInfo.getMounts_info_map();
/*  75 */     MountsInfo xRankUpMountsInfo = (MountsInfo)xMountsInfoMap.get(Long.valueOf(this.mountsId));
/*     */     
/*  77 */     if (xRankUpMountsInfo == null)
/*     */     {
/*  79 */       onExpandProtectPetSizeFail(4);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     this.protect_pet_expand_size = xRankUpMountsInfo.getProtect_pet_expand_size();
/*  84 */     this.mountsCfgId = xRankUpMountsInfo.getMounts_cfg_id();
/*     */     
/*  86 */     int next_expand_size = this.protect_pet_expand_size + 1;
/*     */     
/*  88 */     SMountsProtectCfg mountsProtectCfg = SMountsProtectCfg.get(next_expand_size);
/*     */     
/*  90 */     if (mountsProtectCfg == null)
/*     */     {
/*  92 */       onExpandProtectPetSizeFail(71);
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     long roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  98 */     if (roleLevel < mountsProtectCfg.openLevel)
/*     */     {
/* 100 */       onExpandProtectPetSizeFail(57);
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     if (xRankUpMountsInfo.getMounts_rank() < mountsProtectCfg.minMountsRank)
/*     */     {
/* 106 */       onExpandProtectPetSizeFail(73);
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     boolean result = MountsManager.costItem(userId, this.roleId, this.isUseYuanBao, this.clientYuanBao, this.needYuanBao, mountsProtectCfg.costItemType, mountsProtectCfg.costItemId, mountsProtectCfg.costItemNum, CostType.COST_BIND_FIRST_MOUNTS_EXPAND_PROTECT_PET_SIZE, LogReason.MOUNTS_EXPAND_PROTECT_PET_SIZE_COST_ITEM);
/*     */     
/*     */ 
/* 113 */     if (!result)
/*     */     {
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     xRankUpMountsInfo.setProtect_pet_expand_size(next_expand_size);
/*     */     
/* 120 */     SExpandProtectPetSizeSuccess sExpandProtectPetSizeSuccess = new SExpandProtectPetSizeSuccess();
/* 121 */     sExpandProtectPetSizeSuccess.mounts_id = this.mountsId;
/* 122 */     sExpandProtectPetSizeSuccess.protect_pet_expand_size = next_expand_size;
/* 123 */     OnlineManager.getInstance().send(this.roleId, sExpandProtectPetSizeSuccess);
/*     */     
/* 125 */     MountsManager.tlogMountsCostItemExpandProtectPetSize(userId, this.roleId, this.mountsId, this.mountsCfgId, xRankUpMountsInfo.getMounts_rank(), mountsProtectCfg.costItemId, mountsProtectCfg.costItemNum, this.isUseYuanBao, this.protect_pet_expand_size, next_expand_size);
/*     */     
/*     */ 
/*     */ 
/* 129 */     GameServer.logger().info(String.format("[mounts]PCExpandProtectPetSize.processImp@mounts cost item expand protect pet size success|role_id=%d|mounts_id=%d|mounts_cfgId=%d|protect_pet_expand_size=%d|next_expand_size=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mountsId), Integer.valueOf(this.mountsCfgId), Integer.valueOf(this.protect_pet_expand_size), Integer.valueOf(next_expand_size) }));
/*     */     
/*     */ 
/*     */ 
/* 133 */     return true;
/*     */   }
/*     */   
/*     */   private void onExpandProtectPetSizeFail(int ret)
/*     */   {
/* 138 */     GameServer.logger().error(String.format("[mounts]PCExpandProtectPetSize.processImp@mounts cost item expand protect pet size fail|role_id=%d|mounts_id=%d|mounts_cfgId=%d|protect_pet_expand_size=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mountsId), Integer.valueOf(this.mountsCfgId), Integer.valueOf(this.protect_pet_expand_size) }));
/*     */     
/*     */ 
/*     */ 
/* 142 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 143 */     sMountsNormalFail.result = ret;
/*     */     
/* 145 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCExpandProtectPetSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */