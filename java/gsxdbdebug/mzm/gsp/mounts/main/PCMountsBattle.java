/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SMountsBattleSuccess;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.confbean.SMountsBattleCellCfg;
/*     */ import mzm.gsp.mounts.confbean.SMountsCfg;
/*     */ import mzm.gsp.mounts.confbean.SMountsConsts;
/*     */ import mzm.gsp.mounts.event.MountsRolePropertyChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleMountsInfo;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2mounts;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCMountsBattle extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int cellId;
/*     */   private final long mountsId;
/*     */   
/*     */   public PCMountsBattle(long roleId, int cellId, long mountsId)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.cellId = cellId;
/*  31 */     this.mountsId = mountsId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if ((this.cellId <= 0) || (this.cellId > SMountsConsts.getInstance().maxBattleMounts))
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCMountsBattle.processImp"))
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!MountsManager.isLevelOpen(this.roleId, "PCMountsBattle.processImp"))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     String userId = RoleInterface.getUserId(this.roleId);
/*  54 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  56 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1035, true, true))
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  62 */     if (xRole2MountsInfo == null)
/*     */     {
/*  64 */       onMountsBattleFail(2);
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     SMountsBattleCellCfg sMountsBattleCellCfg = SMountsBattleCellCfg.get(this.cellId);
/*  69 */     if (sMountsBattleCellCfg == null)
/*     */     {
/*  71 */       onMountsBattleFail(12);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*  76 */     int cellNeedLevel = sMountsBattleCellCfg.unLockRoleLevel;
/*  77 */     if (roleLevel < cellNeedLevel)
/*     */     {
/*  79 */       GameServer.logger().error(String.format("[mounts]PCMountsBattle.processImp@cell level not enough|role_id=%d|cell_id=%d|mounts_id=%d|cell_need_level=%d|role_level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.cellId), Long.valueOf(this.mountsId), Integer.valueOf(cellNeedLevel), Integer.valueOf(roleLevel) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  84 */       onMountsBattleFail(13);
/*     */       
/*  86 */       return false;
/*     */     }
/*  88 */     Map<Long, MountsInfo> xMountsInfoMap = xRole2MountsInfo.getMounts_info_map();
/*     */     
/*  90 */     MountsInfo xMountsInfo = (MountsInfo)xMountsInfoMap.get(Long.valueOf(this.mountsId));
/*  91 */     if (xMountsInfo == null)
/*     */     {
/*  93 */       onMountsBattleFail(4);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     SMountsCfg sBattleMountsCfg = SMountsCfg.get(xMountsInfo.getMounts_cfg_id());
/*  98 */     if (sBattleMountsCfg == null)
/*     */     {
/* 100 */       onMountsBattleFail(24);
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     if (sBattleMountsCfg.mountsType == 6)
/*     */     {
/* 106 */       onMountsBattleFail(46);
/* 107 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 111 */     Map<Integer, BattleMountsInfo> xBattleMountsInfoMap = xRole2MountsInfo.getBattle_mounts_info_map();
/* 112 */     for (BattleMountsInfo xBattleMountsInfo : xBattleMountsInfoMap.values())
/*     */     {
/* 114 */       long alreadyBattleMountsId = xBattleMountsInfo.getMounts_id();
/* 115 */       if (alreadyBattleMountsId == this.mountsId)
/*     */       {
/*     */ 
/* 118 */         return false;
/*     */       }
/* 120 */       MountsInfo xAleardyBattleMountsInfo = (MountsInfo)xMountsInfoMap.get(Long.valueOf(alreadyBattleMountsId));
/* 121 */       if (xAleardyBattleMountsInfo != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 126 */         SMountsCfg sAleardyBattleMountsCfg = SMountsCfg.get(xAleardyBattleMountsInfo.getMounts_cfg_id());
/* 127 */         if (sAleardyBattleMountsCfg != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 132 */           if (sAleardyBattleMountsCfg.mountsType == sBattleMountsCfg.mountsType)
/*     */           {
/* 134 */             onMountsBattleFail(23);
/* 135 */             return false;
/*     */           } }
/*     */       }
/*     */     }
/* 139 */     BattleMountsInfo xBattleMountsInfo = (BattleMountsInfo)xBattleMountsInfoMap.get(Integer.valueOf(this.cellId));
/* 140 */     if (xBattleMountsInfo != null)
/*     */     {
/* 142 */       GameServer.logger().error(String.format("[mounts]PCMountsBattle.processImp@cell not empty|role_id=%d|cell_id=%d|mounts_id=%d|cell_mounts_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.cellId), Long.valueOf(this.mountsId), Long.valueOf(xBattleMountsInfo.getMounts_id()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 147 */       onMountsBattleFail(14);
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     if ((xBattleMountsInfoMap.size() == 0) && (this.cellId != SMountsConsts.getInstance().chiefMountsCellId))
/*     */     {
/* 153 */       onMountsBattleFail(66);
/* 154 */       return false;
/*     */     }
/*     */     
/* 157 */     xBattleMountsInfo = xbean.Pod.newBattleMountsInfo();
/* 158 */     xBattleMountsInfo.setMounts_id(this.mountsId);
/*     */     
/* 160 */     xRole2MountsInfo.getBattle_mounts_info_map().put(Integer.valueOf(this.cellId), xBattleMountsInfo);
/*     */     
/* 162 */     if (xRole2MountsInfo.getBattle_mounts_info_map().size() == 1)
/*     */     {
/* 164 */       xRole2MountsInfo.setCurrent_chief_battle_mounts(this.cellId);
/*     */     }
/* 166 */     SMountsBattleSuccess sMountsBattleSuccess = new SMountsBattleSuccess();
/* 167 */     sMountsBattleSuccess.cell_id = this.cellId;
/* 168 */     sMountsBattleSuccess.mounts_id = this.mountsId;
/* 169 */     sMountsBattleSuccess.battle_mounts_state = (xBattleMountsInfoMap.size() == 1 ? 1 : 0);
/*     */     
/*     */ 
/* 172 */     OnlineManager.getInstance().send(this.roleId, sMountsBattleSuccess);
/*     */     
/*     */ 
/* 175 */     MountsManager.triggerMountsRolePropertyChangeEvent(new MountsRolePropertyChangeArg(this.roleId));
/*     */     
/* 177 */     MountsManager.tlogMountsBattle(userId, this.roleId, xBattleMountsInfo.getMounts_id(), xMountsInfo.getMounts_cfg_id(), xMountsInfo.getMounts_rank(), 1);
/*     */     
/*     */ 
/* 180 */     GameServer.logger().info(String.format("[mounts]PCMountsBattle.processImp@handle mounts battle success|role_id=%d|cell_id=%d|mounts_id=%d|battle_mounts_state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.cellId), Long.valueOf(this.mountsId), Integer.valueOf(sMountsBattleSuccess.battle_mounts_state) }));
/*     */     
/*     */ 
/*     */ 
/* 184 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onMountsBattleFail(int ret)
/*     */   {
/* 195 */     GameServer.logger().error(String.format("[mounts]PCMountsBattle.processImp@mounts battle failed|ret=%d|role_id=%d|cell_id=%d|mounts_id=%d", new Object[] { Integer.valueOf(ret), Long.valueOf(this.roleId), Integer.valueOf(this.cellId), Long.valueOf(this.mountsId) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 200 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 201 */     sMountsNormalFail.result = ret;
/* 202 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCMountsBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */