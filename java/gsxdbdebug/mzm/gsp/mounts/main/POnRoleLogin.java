/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SSyncMountsInfo;
/*     */ import mzm.gsp.mounts.SSyncRolesOnMultiRoleMounts;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AppearenceMountsInfo;
/*     */ import xbean.MultiRoleMounts;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xtable.Role2mounts;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  27 */     doMultiRoleMountsSync();
/*     */     
/*  29 */     long roleId = ((Long)this.arg).longValue();
/*     */     
/*  31 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/*  32 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*     */     
/*  34 */     SSyncMountsInfo sSyncMountsInfo = new SSyncMountsInfo();
/*  35 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(roleId));
/*  36 */     if (xRole2MountsInfo == null)
/*     */     {
/*  38 */       OnlineManager.getInstance().send(roleId, sSyncMountsInfo);
/*  39 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  43 */     sSyncMountsInfo.current_ride_mounts = xRole2MountsInfo.getCurrent_ride_mounts_id();
/*  44 */     Map<Long, xbean.MountsInfo> xMountsInfoMap = xRole2MountsInfo.getMounts_info_map();
/*     */     
/*  46 */     for (Map.Entry<Long, xbean.MountsInfo> entry : xMountsInfoMap.entrySet())
/*     */     {
/*  48 */       long mountsId = ((Long)entry.getKey()).longValue();
/*  49 */       xbean.MountsInfo xMountsInfo = (xbean.MountsInfo)entry.getValue();
/*  50 */       mzm.gsp.mounts.MountsInfo sMountsInfo = new mzm.gsp.mounts.MountsInfo();
/*     */       
/*  52 */       MountsManager.fillMountsInfoProtocol(xMountsInfo, sMountsInfo);
/*     */       
/*  54 */       sSyncMountsInfo.mounts_info_map.put(Long.valueOf(mountsId), sMountsInfo);
/*     */     }
/*     */     
/*     */ 
/*  58 */     MountsManager.fillBattleMountsInfoProtocol(xRole2MountsInfo, sSyncMountsInfo.battle_mounts_info_map);
/*     */     
/*     */ 
/*  61 */     Iterator<Map.Entry<Long, AppearenceMountsInfo>> iterator = xRole2MountsInfo.getAppearence_mounts_info_map().entrySet().iterator();
/*  62 */     while (iterator.hasNext())
/*     */     {
/*  64 */       Map.Entry<Long, AppearenceMountsInfo> entry = (Map.Entry)iterator.next();
/*  65 */       long appearanceMountsId = ((Long)entry.getKey()).longValue();
/*  66 */       AppearenceMountsInfo xAppearenceMountsInfo = (AppearenceMountsInfo)entry.getValue();
/*     */       
/*     */ 
/*  69 */       if (!xMountsInfoMap.containsKey(Long.valueOf(appearanceMountsId)))
/*     */       {
/*  71 */         sSyncMountsInfo.mounts_info_map.remove(Long.valueOf(appearanceMountsId));
/*  72 */         iterator.remove();
/*     */       }
/*     */       else
/*     */       {
/*  76 */         mzm.gsp.mounts.MountsInfo sMountsInfo = (mzm.gsp.mounts.MountsInfo)sSyncMountsInfo.mounts_info_map.get(Long.valueOf(appearanceMountsId));
/*  77 */         if (xAppearenceMountsInfo.getEffect_time() == -1L)
/*     */         {
/*  79 */           sMountsInfo.remain_time = -1L;
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*  84 */           long elapsedTime = DateTimeUtils.getCurrTimeInMillis() - xAppearenceMountsInfo.getStart_time();
/*  85 */           long remainTime = xAppearenceMountsInfo.getEffect_time() - elapsedTime;
/*  86 */           if (remainTime <= 0L)
/*     */           {
/*  88 */             iterator.remove();
/*  89 */             sSyncMountsInfo.mounts_info_map.remove(Long.valueOf(appearanceMountsId));
/*  90 */             xMountsInfoMap.remove(Long.valueOf(appearanceMountsId));
/*     */             
/*  92 */             int mountsCfgId = sMountsInfo.mounts_cfg_id;
/*  93 */             MountsManager.triggerAppearanceMountsExpiredEvent(roleId, mountsCfgId, sSyncMountsInfo.current_ride_mounts, appearanceMountsId);
/*     */             
/*     */ 
/*  96 */             GameServer.logger().info(String.format("[mounts]POnRoleLogin.processImp@appearence mounts expired|role_id=%d|mounts_cfg_id=%d|mounts_id=%d|mounts_rank=%d|start_time=%d|effect_time=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(mountsCfgId), Long.valueOf(appearanceMountsId), Integer.valueOf(sMountsInfo.mounts_rank), Long.valueOf(xAppearenceMountsInfo.getStart_time()), Long.valueOf(xAppearenceMountsInfo.getEffect_time()) }));
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 103 */           sMountsInfo.remain_time = (remainTime / 1000L);
/*     */           
/* 105 */           MountsManager.triggerAppearanceMountsObserverEvent(new mzm.gsp.mounts.event.AppearanceMountsObserverArg(roleId, appearanceMountsId, remainTime));
/*     */         }
/*     */       }
/*     */     }
/* 109 */     OnlineManager.getInstance().send(roleId, sSyncMountsInfo);
/*     */     
/* 111 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void doMultiRoleMountsSync()
/*     */   {
/* 120 */     if (!OpenInterface.getOpenStatus(409))
/*     */     {
/* 122 */       return;
/*     */     }
/* 124 */     Long teamId = TeamInterface.getTeamidByRoleid(((Long)this.arg).longValue(), false);
/* 125 */     if (null == teamId)
/*     */     {
/* 127 */       return;
/*     */     }
/* 129 */     MultiRoleMounts xMultiRoleMounts = xtable.Team2multirolemounts.select(teamId);
/*     */     
/* 131 */     if (null == xMultiRoleMounts)
/*     */     {
/* 133 */       GameServer.logger().error(String.format("[mounts]POnRoleLogin.processImp@xMultiRoleMounts not exist!|roleId=%d,teamId=%d", new Object[] { this.arg, teamId }));
/*     */       
/*     */ 
/* 136 */       return;
/*     */     }
/* 138 */     long leaderId = TeamInterface.getTeamLeaderByTeamid(teamId.longValue(), false);
/*     */     
/* 140 */     MountsInterface.RideMountsObj rideMountsObj = MountsInterface.getRideMountsObj(leaderId, false);
/* 141 */     SSyncRolesOnMultiRoleMounts protocol = MultiRoleMountsManager.getRolesOnMultiRoleProto(teamId.longValue(), rideMountsObj.getMountsCfgId(), xMultiRoleMounts.getRole_ids());
/*     */     
/* 143 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */