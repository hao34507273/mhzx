/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.mounts.SExtendMountsTimeSuccess;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.confbean.SMountsCfg;
/*     */ import mzm.gsp.mounts.confbean.SMountsUnLockItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AppearenceMountsInfo;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2mounts;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCExtendMountsTime extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int extendTimeItemId;
/*     */   private final int extendTimeItemNum;
/*     */   
/*     */   public PCExtendMountsTime(long roleId, int extendTimeItemId, int extendTimeItemNum)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.extendTimeItemId = extendTimeItemId;
/*  34 */     this.extendTimeItemNum = extendTimeItemNum;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if ((this.extendTimeItemNum <= 0) || (this.extendTimeItemId <= 0))
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCExtendMountsTime.processImp"))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!MountsManager.isLevelOpen(this.roleId, "PCExtendMountsTime.processImp"))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     String userId = RoleInterface.getUserId(this.roleId);
/*  56 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  58 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1033, true, true))
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  64 */     if (xRole2MountsInfo == null)
/*     */     {
/*  66 */       onExtendMountsTimeFail(2);
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     SMountsUnLockItemCfg sMountsUnLockItemCfg = SMountsUnLockItemCfg.get(this.extendTimeItemId);
/*  71 */     if (sMountsUnLockItemCfg == null)
/*     */     {
/*  73 */       onExtendMountsTimeFail(30);
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     int mountsCfgId = sMountsUnLockItemCfg.mountsCfgId;
/*  78 */     SMountsCfg sMountsCfg = SMountsCfg.get(mountsCfgId);
/*  79 */     if (sMountsCfg.mountsType != 6)
/*     */     {
/*  81 */       onExtendMountsTimeFail(52);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     AppearenceMountsInfo xAppearenceMountsInfo = null;
/*  86 */     long mountsId = 0L;
/*  87 */     Map<Long, MountsInfo> xMountsInfoMap = xRole2MountsInfo.getMounts_info_map();
/*  88 */     for (Map.Entry<Long, AppearenceMountsInfo> entry : xRole2MountsInfo.getAppearence_mounts_info_map().entrySet())
/*     */     {
/*  90 */       MountsInfo xMountsInfo = (MountsInfo)xMountsInfoMap.get(entry.getKey());
/*  91 */       if ((xMountsInfo != null) && (xMountsInfo.getMounts_cfg_id() == mountsCfgId))
/*     */       {
/*  93 */         xAppearenceMountsInfo = (AppearenceMountsInfo)entry.getValue();
/*  94 */         mountsId = ((Long)entry.getKey()).longValue();
/*  95 */         break;
/*     */       }
/*     */     }
/*     */     
/*  99 */     if (xAppearenceMountsInfo == null)
/*     */     {
/* 101 */       onExtendMountsTimeFail(53);
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     if (xAppearenceMountsInfo.getEffect_time() == -1L)
/*     */     {
/* 107 */       onExtendMountsTimeFail(54);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     TLogArg tLogArg = new TLogArg(LogReason.MOUNTS_EXTEND_TIME_COST_ITEM);
/* 112 */     boolean removeItemResult = ItemInterface.removeItemById(this.roleId, 340600000, this.extendTimeItemId, this.extendTimeItemNum, tLogArg);
/*     */     
/* 114 */     if (!removeItemResult)
/*     */     {
/* 116 */       onExtendMountsTimeFail(20);
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     SExtendMountsTimeSuccess sExtendMountsTimeSuccess = new SExtendMountsTimeSuccess();
/* 121 */     sExtendMountsTimeSuccess.mounts_id = mountsId;
/* 122 */     int extendTime = sMountsUnLockItemCfg.lastTime;
/* 123 */     if (extendTime == -1)
/*     */     {
/* 125 */       xAppearenceMountsInfo.setEffect_time(-1L);
/* 126 */       sExtendMountsTimeSuccess.remain_time = -1L;
/*     */     }
/*     */     else
/*     */     {
/* 130 */       int costItemNum = sMountsUnLockItemCfg.costItemNum;
/* 131 */       int extendHourTime = sMountsUnLockItemCfg.lastTime / costItemNum * this.extendTimeItemNum;
/*     */       
/* 133 */       xAppearenceMountsInfo.setEffect_time(xAppearenceMountsInfo.getEffect_time() + extendHourTime * 3600000L);
/*     */       
/* 135 */       long elpasedTime = DateTimeUtils.getCurrTimeInMillis() - xAppearenceMountsInfo.getStart_time();
/* 136 */       sExtendMountsTimeSuccess.remain_time = ((xAppearenceMountsInfo.getEffect_time() - elpasedTime) / 1000L);
/*     */     }
/*     */     
/* 139 */     OnlineManager.getInstance().send(this.roleId, sExtendMountsTimeSuccess);
/*     */     
/* 141 */     GameServer.logger().info(String.format("[mounts]PCExtendMountsTime.processImp@handle extend mounts time success|role_id=%d|extend_time_item_id=%d|extend_time_item_num=%d|mounts_id=%d|mounts_cfg_id=%d|remain_time=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.extendTimeItemId), Integer.valueOf(this.extendTimeItemNum), Long.valueOf(mountsId), Integer.valueOf(sMountsCfg.id), Long.valueOf(sExtendMountsTimeSuccess.remain_time) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 146 */     return true;
/*     */   }
/*     */   
/*     */   private void onExtendMountsTimeFail(int ret)
/*     */   {
/* 151 */     GameServer.logger().error(String.format("[mounts]PCExtendMountsTime.processImp@handle extend mounts time success|ret=%d|role_id=%d|extend_time_item_id=%d|extend_time_item_num=%d", new Object[] { Integer.valueOf(ret), Long.valueOf(this.roleId), Integer.valueOf(this.extendTimeItemId), Integer.valueOf(this.extendTimeItemNum) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 156 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 157 */     sMountsNormalFail.result = ret;
/*     */     
/* 159 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCExtendMountsTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */