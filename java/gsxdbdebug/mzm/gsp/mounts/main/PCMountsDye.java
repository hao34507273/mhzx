/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SMountsDyeSuccess;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.confbean.MountsDyeColorBean;
/*     */ import mzm.gsp.mounts.confbean.SMountsDyeColorCfg;
/*     */ import mzm.gsp.mounts.event.RideMountsModelChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2mounts;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCMountsDye extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int colorId;
/*     */   private final long mountsId;
/*     */   private final int isUseYuanBao;
/*     */   private final long clientYuanBao;
/*     */   private final int needYuanBao;
/*     */   
/*     */   public PCMountsDye(long roleId, long mountsId, int colorId, int isUseYuanBao, long clientYuanBao, int needYuanBao)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.colorId = colorId;
/*  33 */     this.mountsId = mountsId;
/*  34 */     this.clientYuanBao = clientYuanBao;
/*  35 */     this.needYuanBao = needYuanBao;
/*  36 */     this.isUseYuanBao = isUseYuanBao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if ((this.colorId <= 0) || ((this.isUseYuanBao != 1) && (this.isUseYuanBao != 0)) || (this.needYuanBao < 0) || (this.clientYuanBao < 0L))
/*     */     {
/*     */ 
/*     */ 
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCMountsDye.processImp"))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (!MountsManager.isLevelOpen(this.roleId, "PCMountsDye.processImp"))
/*     */     {
/*  56 */       return false;
/*     */     }
/*  58 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  59 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  61 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1037, true, true))
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  67 */     if (xRole2MountsInfo == null)
/*     */     {
/*  69 */       onMountsDyeFail(2);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     MountsInfo xMountsInfo = (MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(this.mountsId));
/*  74 */     if (xMountsInfo == null)
/*     */     {
/*  76 */       onMountsDyeFail(4);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (xMountsInfo.getMounts_dye_color_id() == this.colorId)
/*     */     {
/*     */ 
/*  83 */       onMountsDyeFail(16);
/*  84 */       return false;
/*     */     }
/*  86 */     int mountsCfgId = xMountsInfo.getMounts_cfg_id();
/*  87 */     SMountsDyeColorCfg sMountsDyeColorCfg = SMountsDyeColorCfg.get(xMountsInfo.getMounts_cfg_id());
/*  88 */     if (sMountsDyeColorCfg == null)
/*     */     {
/*     */ 
/*  91 */       onMountsDyeFail(17);
/*  92 */       return false;
/*     */     }
/*  94 */     MountsDyeColorBean mountsDyeColorBean = (MountsDyeColorBean)sMountsDyeColorCfg.mountsDyeColorMap.get(Integer.valueOf(this.colorId));
/*  95 */     if (mountsDyeColorBean == null)
/*     */     {
/*     */ 
/*  98 */       onMountsDyeFail(15);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     boolean result = MountsManager.costItem(userId, this.roleId, this.isUseYuanBao, this.clientYuanBao, this.needYuanBao, mountsDyeColorBean.costItemType, mountsDyeColorBean.itemId, mountsDyeColorBean.itemCount, CostType.COST_BIND_FIRST_MOUNTS_DYE_COLOR, mzm.gsp.tlog.LogReason.MOUNTS_DYE_COST_ITEM);
/*     */     
/*     */ 
/* 105 */     if (!result)
/*     */     {
/* 107 */       return false;
/*     */     }
/* 109 */     int oldColorId = xMountsInfo.getMounts_dye_color_id();
/* 110 */     xMountsInfo.setMounts_dye_color_id(this.colorId);
/* 111 */     if (this.mountsId == xRole2MountsInfo.getCurrent_ride_mounts_id())
/*     */     {
/* 113 */       MountsManager.triggerRideMountsModelChangeEvent(new RideMountsModelChangeArg(this.roleId, mountsCfgId, xMountsInfo.getCurrent_ornament_rank(), xMountsInfo.getMounts_dye_color_id(), 0));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 121 */     SMountsDyeSuccess sMountsDyeSuccess = new SMountsDyeSuccess();
/* 122 */     sMountsDyeSuccess.mounts_id = this.mountsId;
/* 123 */     sMountsDyeSuccess.color_id = this.colorId;
/* 124 */     OnlineManager.getInstance().send(this.roleId, sMountsDyeSuccess);
/*     */     
/* 126 */     MountsManager.tlogMountsDye(userId, this.roleId, this.mountsId, mountsCfgId, xMountsInfo.getMounts_rank(), this.colorId, this.isUseYuanBao, oldColorId);
/*     */     
/*     */ 
/* 129 */     GameServer.logger().info(String.format("[mounts]PCMountsDye.processImp@mounts dye success|role_id=%d|mounts_id=%d|color_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mountsId), Integer.valueOf(this.colorId) }));
/*     */     
/*     */ 
/* 132 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onMountsDyeFail(int ret)
/*     */   {
/* 143 */     GameServer.logger().error(String.format("[mounts]PCMountsDye.processImp@mounts dye fail|ret=%d|role_id=%d|mounts_id=%d|color_id=%d", new Object[] { Integer.valueOf(ret), Long.valueOf(this.roleId), Long.valueOf(this.mountsId), Integer.valueOf(this.colorId) }));
/*     */     
/*     */ 
/*     */ 
/* 147 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 148 */     sMountsNormalFail.result = ret;
/*     */     
/* 150 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCMountsDye.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */