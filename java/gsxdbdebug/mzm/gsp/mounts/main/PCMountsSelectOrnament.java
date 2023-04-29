/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.SMountsSelectOrnamentSuccess;
/*     */ import mzm.gsp.mounts.confbean.SMountsConsts;
/*     */ import mzm.gsp.mounts.event.RideMountsModelChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
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
/*     */ public class PCMountsSelectOrnament
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long mountsId;
/*     */   private final int selectRank;
/*     */   private int mountsCfgId;
/*     */   private int mountsRank;
/*     */   
/*     */   public PCMountsSelectOrnament(long roleId, long mountsId, int selectRank)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.mountsId = mountsId;
/*  35 */     this.selectRank = selectRank;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if ((this.selectRank <= 0) || (this.selectRank > SMountsConsts.getInstance().maxMountsRank))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCMountsSelectOrnament.processImp"))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (!MountsManager.isLevelOpen(this.roleId, "PCMountsSelectOrnament.processImp"))
/*     */     {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     String userId = RoleInterface.getUserId(this.roleId);
/*  57 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  59 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1042, true, true))
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  65 */     if (xRole2MountsInfo == null)
/*     */     {
/*  67 */       onMountsSelectOrnament(2);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     MountsInfo xMountsInfo = (MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(this.mountsId));
/*  72 */     if (xMountsInfo == null)
/*     */     {
/*  74 */       onMountsSelectOrnament(4);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     this.mountsCfgId = xMountsInfo.getMounts_cfg_id();
/*  79 */     this.mountsRank = xMountsInfo.getMounts_rank();
/*     */     
/*  81 */     if (this.selectRank > this.mountsRank)
/*     */     {
/*  83 */       Map<String, Object> extraMap = new HashMap();
/*  84 */       extraMap.put("select_rank", Integer.valueOf(this.selectRank));
/*  85 */       extraMap.put("mounts_rank", Integer.valueOf(this.mountsRank));
/*  86 */       onMountsSelectOrnament(69, extraMap);
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     if (this.selectRank == xMountsInfo.getCurrent_ornament_rank())
/*     */     {
/*  92 */       return false;
/*     */     }
/*  94 */     int oldOrnamentRank = xMountsInfo.getCurrent_ornament_rank();
/*  95 */     xMountsInfo.setCurrent_ornament_rank(this.selectRank);
/*     */     
/*  97 */     if (xRole2MountsInfo.getCurrent_ride_mounts_id() == this.mountsId)
/*     */     {
/*  99 */       MountsManager.triggerRideMountsModelChangeEvent(new RideMountsModelChangeArg(this.roleId, this.mountsCfgId, xMountsInfo.getCurrent_ornament_rank(), xMountsInfo.getMounts_dye_color_id(), 1));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 106 */     SMountsSelectOrnamentSuccess sMountsSelectOrnamentSuccess = new SMountsSelectOrnamentSuccess();
/* 107 */     sMountsSelectOrnamentSuccess.mounts_id = this.mountsId;
/* 108 */     sMountsSelectOrnamentSuccess.select_rank = this.selectRank;
/* 109 */     OnlineManager.getInstance().send(this.roleId, sMountsSelectOrnamentSuccess);
/*     */     
/* 111 */     MountsManager.tlogMountsSelectOrnamentRank(userId, this.roleId, this.mountsId, this.mountsCfgId, this.mountsRank, oldOrnamentRank, this.selectRank);
/*     */     
/* 113 */     GameServer.logger().info(String.format("[mounts]PCMountsSelectOrnament.processImp@handle mounts select ornament success|role_id=%d|mounts_id=%d|mounts_cfg_id=%d|old_ornamet_rank=%d|new_ornament_rank=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mountsId), Integer.valueOf(this.mountsCfgId), Integer.valueOf(oldOrnamentRank), Integer.valueOf(this.selectRank) }));
/*     */     
/*     */ 
/*     */ 
/* 117 */     return true;
/*     */   }
/*     */   
/*     */   private void onMountsSelectOrnament(int ret)
/*     */   {
/* 122 */     onMountsSelectOrnament(ret, null);
/*     */   }
/*     */   
/*     */   private void onMountsSelectOrnament(int ret, Map<String, ?> extraMap)
/*     */   {
/* 127 */     StringBuilder sbLog = new StringBuilder();
/* 128 */     sbLog.append("[mounts]PCMountsSelectOrnament.processImp@mounts replace protect pet failed");
/* 129 */     sbLog.append("|ret=").append(ret);
/* 130 */     sbLog.append("|role_id=").append(this.roleId);
/* 131 */     sbLog.append("|mounts_id=").append(this.mountsId);
/* 132 */     sbLog.append("|select_rank=").append(this.selectRank);
/* 133 */     sbLog.append("|mounts_cfg_id=").append(this.mountsCfgId);
/* 134 */     sbLog.append("|mounts_rank=").append(this.mountsRank);
/* 135 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 137 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 139 */         sbLog.append('|').append((String)entry.getKey()).append('|').append(entry.getValue());
/*     */       }
/*     */     }
/* 142 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 144 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 145 */     sMountsNormalFail.result = ret;
/*     */     
/* 147 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCMountsSelectOrnament.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */