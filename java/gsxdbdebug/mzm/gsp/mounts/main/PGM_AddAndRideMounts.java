/*    */ package mzm.gsp.mounts.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Random;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.mounts.SRideMountsSuccess;
/*    */ import mzm.gsp.mounts.SUnlockMountsSuccess;
/*    */ import mzm.gsp.mounts.confbean.SMountsCfg;
/*    */ import mzm.gsp.mounts.confbean.SMountsRankCfg;
/*    */ import mzm.gsp.mounts.event.RideMountsModelChangeArg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.MountsInfo;
/*    */ import xbean.Pod;
/*    */ import xbean.Role2MountsInfo;
/*    */ import xdb.Xdb;
/*    */ import xtable.Role2mounts;
/*    */ 
/*    */ public class PGM_AddAndRideMounts extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_AddAndRideMounts(long roleId)
/*    */   {
/* 25 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (!MountsManager.checkMutexStatus(this.roleId))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 37 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*    */     
/* 39 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/* 40 */     if (xRole2MountsInfo == null)
/*    */     {
/* 42 */       xRole2MountsInfo = Pod.newRole2MountsInfo();
/* 43 */       Role2mounts.add(Long.valueOf(this.roleId), xRole2MountsInfo);
/*    */     }
/* 45 */     int mountsSize = SMountsRankCfg.getAll().size();
/*    */     
/* 47 */     int randomSize = Xdb.random().nextInt(mountsSize);
/*    */     
/* 49 */     int mountsIndex = 0;
/* 50 */     int mountsCfgId = 0;
/* 51 */     SMountsRankCfg sMountsRankCfg = null;
/* 52 */     for (Map.Entry<Integer, SMountsRankCfg> entry : SMountsRankCfg.getAll().entrySet())
/*    */     {
/* 54 */       if (mountsIndex++ == randomSize)
/*    */       {
/* 56 */         mountsCfgId = ((Integer)entry.getKey()).intValue();
/* 57 */         sMountsRankCfg = (SMountsRankCfg)entry.getValue();
/*    */       }
/*    */     }
/*    */     
/* 61 */     MountsInfo xMountsInfo = Pod.newMountsInfo();
/* 62 */     long mountsUuid = mzm.gsp.util.UuidUtils.generateUuid(mzm.gsp.util.UuidUtils.UuidType.MOUNTS);
/*    */     
/* 64 */     xMountsInfo.setMounts_cfg_id(mountsCfgId);
/*    */     
/* 66 */     int maxMountsRank = sMountsRankCfg.mountsRankMapInfo.size();
/* 67 */     int randomRank = Xdb.random().nextInt(maxMountsRank);
/* 68 */     xMountsInfo.setMounts_rank(randomRank + 1);
/*    */     
/* 70 */     SMountsCfg sMountsCfg = SMountsCfg.get(mountsCfgId);
/* 71 */     xRole2MountsInfo.getMounts_info_map().put(Long.valueOf(mountsUuid), xMountsInfo);
/* 72 */     xRole2MountsInfo.setCurrent_ride_mounts_id(mountsUuid);
/* 73 */     xMountsInfo.setMounts_dye_color_id(sMountsCfg.defaultDyeColorId);
/* 74 */     xMountsInfo.setCurrent_ornament_rank(randomRank + 1);
/* 75 */     SRideMountsSuccess sRideMountsSuccess = new SRideMountsSuccess();
/* 76 */     sRideMountsSuccess.mounts_id = mountsUuid;
/*    */     
/* 78 */     OnlineManager.getInstance().send(this.roleId, sRideMountsSuccess);
/*    */     
/* 80 */     SUnlockMountsSuccess sUnlockMountsSuccess = new SUnlockMountsSuccess();
/* 81 */     sUnlockMountsSuccess.mounts_id = mountsUuid;
/* 82 */     MountsManager.fillMountsInfoProtocol(xMountsInfo, sUnlockMountsSuccess.unlock_mounts_info);
/* 83 */     OnlineManager.getInstance().send(this.roleId, sUnlockMountsSuccess);
/*    */     
/* 85 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 86 */     messagetip.result = Integer.MAX_VALUE;
/* 87 */     messagetip.args.add(String.format("增加坐骑成功!", new Object[0]));
/* 88 */     OnlineManager.getInstance().send(this.roleId, messagetip);
/*    */     
/* 90 */     MountsManager.triggerRideMountsModelChangeEvent(new RideMountsModelChangeArg(this.roleId, mountsCfgId, randomRank + 1, xMountsInfo.getMounts_dye_color_id(), 1));
/*    */     
/*    */ 
/*    */ 
/* 94 */     MultiRoleMountsManager.onRoleRideMounts(this.roleId, xMountsInfo.getMounts_cfg_id());
/* 95 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PGM_AddAndRideMounts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */