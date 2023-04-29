/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.SortedMap;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.SUnlockMountsSuccess;
/*     */ import mzm.gsp.mounts.confbean.MountsPassiveSkillBean;
/*     */ import mzm.gsp.mounts.confbean.MountsRankInfoBean;
/*     */ import mzm.gsp.mounts.confbean.SMountsCfg;
/*     */ import mzm.gsp.mounts.confbean.SMountsConsts;
/*     */ import mzm.gsp.mounts.confbean.SMountsPassiveSkillCfg;
/*     */ import mzm.gsp.mounts.confbean.SMountsRankCfg;
/*     */ import mzm.gsp.mounts.confbean.SMountsStarLifeCfg;
/*     */ import mzm.gsp.mounts.confbean.SMountsUnLockItemCfg;
/*     */ import mzm.gsp.mounts.event.MountsRolePropertyChangeArg;
/*     */ import mzm.gsp.mounts.event.NewMountsGet;
/*     */ import mzm.gsp.mounts.event.NewMountsGetArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.UuidUtils;
/*     */ import mzm.gsp.util.UuidUtils.UuidType;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AppearenceMountsInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2mounts;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCUnlockMounts extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long itemUuid;
/*     */   
/*     */   public PCUnlockMounts(long roleId, long itemUuid)
/*     */   {
/*  55 */     this.roleId = roleId;
/*  56 */     this.itemUuid = itemUuid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  62 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCUnlockMounts.processImp"))
/*     */     {
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     if (!MountsManager.isLevelOpen(this.roleId, "PCUnlockMounts.processImp"))
/*     */     {
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     String userId = RoleInterface.getUserId(this.roleId);
/*  73 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  75 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1047, true, true))
/*     */     {
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  81 */     if (xRole2MountsInfo == null)
/*     */     {
/*  83 */       xRole2MountsInfo = Pod.newRole2MountsInfo();
/*  84 */       xRole2MountsInfo.setCurrent_chief_battle_mounts(-1);
/*  85 */       Role2mounts.add(Long.valueOf(this.roleId), xRole2MountsInfo);
/*     */     }
/*     */     
/*  88 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, this.itemUuid);
/*  89 */     if (basicItem == null)
/*     */     {
/*  91 */       onUnLockMountsFailed(68);
/*  92 */       return false;
/*     */     }
/*  94 */     int unlockItemId = basicItem.getCfgId();
/*  95 */     SMountsUnLockItemCfg sMountsUnLockItemCfg = SMountsUnLockItemCfg.get(unlockItemId);
/*  96 */     if (sMountsUnLockItemCfg == null)
/*     */     {
/*  98 */       onUnLockMountsFailed(30);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     int mountsCfgId = sMountsUnLockItemCfg.mountsCfgId;
/* 103 */     SMountsCfg sMountsCfg = SMountsCfg.get(mountsCfgId);
/*     */     
/* 105 */     if ((sMountsCfg.mountsType == 6) && (isAppearenceRepeat(mountsCfgId, xRole2MountsInfo)))
/*     */     {
/* 107 */       onUnLockMountsFailed(55);
/* 108 */       return false;
/*     */     }
/* 110 */     int mountsRank = sMountsUnLockItemCfg.mountsRank;
/* 111 */     SMountsRankCfg sMountsRankCfg = SMountsRankCfg.get(mountsCfgId);
/* 112 */     if (sMountsRankCfg == null)
/*     */     {
/* 114 */       onUnLockMountsFailed(44);
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     MountsRankInfoBean mountsRankInfoBean = (MountsRankInfoBean)sMountsRankCfg.mountsRankMapInfo.get(Integer.valueOf(mountsRank));
/* 119 */     if (mountsRankInfoBean == null)
/*     */     {
/* 121 */       onUnLockMountsFailed(44);
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/* 126 */     if (roleLevel < mountsRankInfoBean.needRoleLevel)
/*     */     {
/* 128 */       onUnLockMountsFailed(57);
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     Map<Long, xbean.MountsInfo> xMountsInfoMap = xRole2MountsInfo.getMounts_info_map();
/* 133 */     if (xMountsInfoMap.size() >= SMountsConsts.getInstance().maxMountsNum)
/*     */     {
/* 135 */       onUnLockMountsFailed(21);
/* 136 */       return false;
/*     */     }
/* 138 */     int needItemNum = sMountsUnLockItemCfg.costItemNum;
/*     */     
/* 140 */     int hasItemNum = ItemInterface.getItemNumberById(this.roleId, unlockItemId);
/* 141 */     if (hasItemNum < needItemNum)
/*     */     {
/* 143 */       GameServer.logger().error(String.format("[mounts]PCUnlockMounts.processImp@unlock itemid num not enough|role_id=%d|item_uuid=%d|unlock_item_id=%d|mounts_cfg_id=%d|mounts_rank=%d|need_item_num=%d|has_item_num=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.itemUuid), Integer.valueOf(unlockItemId), Integer.valueOf(mountsCfgId), Integer.valueOf(mountsRank), Integer.valueOf(needItemNum), Integer.valueOf(hasItemNum) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 148 */       onUnLockMountsFailed(31);
/* 149 */       return false;
/*     */     }
/*     */     
/* 152 */     TLogArg tLogArg = new TLogArg(LogReason.MOUNTS_UN_LOCK_COST_ITEM);
/*     */     
/* 154 */     boolean removeItemResult = ItemInterface.removeItemByUuid(this.roleId, this.itemUuid, needItemNum, tLogArg);
/* 155 */     if (!removeItemResult)
/*     */     {
/* 157 */       GameServer.logger().error(String.format("[mounts]PCUnlockMounts.processImp@remove item failed|role_id=%d|unlock_item_id=%d|mounts_cfg_id=%d|mounts_rank=%d|need_item_num=%d|has_item_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(unlockItemId), Integer.valueOf(mountsCfgId), Integer.valueOf(mountsRank), Integer.valueOf(needItemNum), Integer.valueOf(hasItemNum) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 162 */       onUnLockMountsFailed(20);
/* 163 */       return false;
/*     */     }
/*     */     
/* 166 */     long mountsId = UuidUtils.generateUuid(UuidUtils.UuidType.MOUNTS);
/* 167 */     xbean.MountsInfo xMountsInfo = Pod.newMountsInfo();
/* 168 */     xRole2MountsInfo.getMounts_info_map().put(Long.valueOf(mountsId), xMountsInfo);
/*     */     
/* 170 */     xMountsInfo.setMounts_cfg_id(mountsCfgId);
/* 171 */     xMountsInfo.setMounts_rank(mountsRank);
/*     */     
/* 173 */     SUnlockMountsSuccess sUnlockMountsSuccess = new SUnlockMountsSuccess();
/* 174 */     sUnlockMountsSuccess.mounts_id = mountsId;
/* 175 */     mzm.gsp.mounts.MountsInfo sMountsInfo = sUnlockMountsSuccess.unlock_mounts_info;
/* 176 */     sMountsInfo.mounts_cfg_id = mountsCfgId;
/* 177 */     sMountsInfo.mounts_rank = mountsRank;
/* 178 */     if (sMountsCfg.mountsType == 6)
/*     */     {
/*     */ 
/* 181 */       createAppearanceMounts(xRole2MountsInfo, sMountsInfo, sMountsUnLockItemCfg.lastTime, mountsId);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 186 */       randomPassiveSkill(xRole2MountsInfo, xMountsInfo, sMountsInfo.passive_skill_list, mountsCfgId, mountsRank, mountsId);
/*     */     }
/*     */     
/* 189 */     sMountsInfo.color_id = sMountsCfg.defaultDyeColorId;
/* 190 */     xMountsInfo.setMounts_dye_color_id(sMountsCfg.defaultDyeColorId);
/* 191 */     xMountsInfo.setCurrent_ornament_rank(mountsRank);
/*     */     
/* 193 */     fillMountsStarLifeInfo(mountsCfgId, xMountsInfo);
/* 194 */     sMountsInfo.current_max_active_star_num = xMountsInfo.getCurrent_max_star_num();
/* 195 */     sMountsInfo.current_star_level = xMountsInfo.getCurrent_mounts_star_level();
/* 196 */     sMountsInfo.current_ornament_rank = xMountsInfo.getCurrent_ornament_rank();
/* 197 */     OnlineManager.getInstance().send(this.roleId, sUnlockMountsSuccess);
/*     */     
/* 199 */     TriggerEventsManger.getInstance().triggerEvent(new NewMountsGet(), new NewMountsGetArg(this.roleId, mountsCfgId, mountsRank), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*     */ 
/* 203 */     MountsManager.tlogMountsUnLock(userId, this.roleId, mountsId, xMountsInfo.getMounts_cfg_id(), xMountsInfo.getMounts_rank(), unlockItemId, xMountsInfo.getMounts_passive_skill_list());
/*     */     
/*     */ 
/* 206 */     GameServer.logger().info(String.format("[mounts]PCUnlockMounts.processImp@unlock mounts success|role_id=%d|unlock_item_id=%d|mounts_cfg_id=%d|mounts_rank=%d|need_item_num=%d|has_item_num=%d|mounts_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(unlockItemId), Integer.valueOf(mountsCfgId), Integer.valueOf(mountsRank), Integer.valueOf(needItemNum), Integer.valueOf(hasItemNum), Long.valueOf(mountsId) }));
/*     */     
/*     */ 
/*     */ 
/* 210 */     return true;
/*     */   }
/*     */   
/*     */   private boolean isAppearenceRepeat(int mountsCfgId, Role2MountsInfo xRole2MountsInfo)
/*     */   {
/* 215 */     for (Iterator i$ = xRole2MountsInfo.getAppearence_mounts_info_map().keySet().iterator(); i$.hasNext();) { long appearenceMountsId = ((Long)i$.next()).longValue();
/*     */       
/* 217 */       xbean.MountsInfo xMountsInfo = (xbean.MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(appearenceMountsId));
/* 218 */       if ((xMountsInfo != null) && (xMountsInfo.getMounts_cfg_id() == mountsCfgId))
/*     */       {
/* 220 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 224 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void fillMountsStarLifeInfo(int mountsCfgId, xbean.MountsInfo xMountsInfo)
/*     */   {
/* 236 */     SMountsStarLifeCfg sMountsStarLifeCfg = SMountsStarLifeCfg.get(mountsCfgId);
/* 237 */     if (sMountsStarLifeCfg == null)
/*     */     {
/* 239 */       return;
/*     */     }
/* 241 */     if (sMountsStarLifeCfg.starLifeLevelMap.isEmpty())
/*     */     {
/* 243 */       return;
/*     */     }
/* 245 */     xMountsInfo.setCurrent_mounts_star_level(((Integer)sMountsStarLifeCfg.starLifeLevelMap.firstKey()).intValue());
/* 246 */     xMountsInfo.setCurrent_max_star_num(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void createAppearanceMounts(Role2MountsInfo xRole2MountsInfo, mzm.gsp.mounts.MountsInfo mountsInfo, int lastTime, long mountsId)
/*     */   {
/* 255 */     AppearenceMountsInfo xAppearenceMountsInfo = Pod.newAppearenceMountsInfo();
/* 256 */     xAppearenceMountsInfo.setStart_time(DateTimeUtils.getCurrTimeInMillis());
/* 257 */     xAppearenceMountsInfo.setMounts_id(mountsId);
/*     */     
/* 259 */     if (lastTime == -1)
/*     */     {
/* 261 */       xAppearenceMountsInfo.setEffect_time(-1L);
/* 262 */       mountsInfo.remain_time = -1L;
/*     */     }
/*     */     else
/*     */     {
/* 266 */       xAppearenceMountsInfo.setEffect_time(lastTime * 3600000L);
/* 267 */       mountsInfo.remain_time = (lastTime * 3600L);
/* 268 */       MountsManager.triggerAppearanceMountsObserverEvent(new mzm.gsp.mounts.event.AppearanceMountsObserverArg(this.roleId, mountsId, mountsInfo.remain_time * 1000L));
/*     */     }
/*     */     
/* 271 */     MountsManager.triggerMountsRolePropertyChangeEvent(new MountsRolePropertyChangeArg(this.roleId));
/* 272 */     xRole2MountsInfo.getAppearence_mounts_info_map().put(Long.valueOf(mountsId), xAppearenceMountsInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void randomPassiveSkill(Role2MountsInfo xRole2MountsInfo, xbean.MountsInfo xMountsInfo, List<mzm.gsp.mounts.PassiveSkillInfo> passiveSkillList, int mountsCfgId, int mountsRank, long mountsId)
/*     */   {
/* 282 */     SMountsPassiveSkillCfg sMountsPassiveSkillCfg = SMountsPassiveSkillCfg.get(mountsCfgId);
/* 283 */     if (sMountsPassiveSkillCfg == null)
/*     */     {
/* 285 */       return;
/*     */     }
/*     */     
/* 288 */     SortedMap<Integer, MountsPassiveSkillBean> subMap = sMountsPassiveSkillCfg.rankPassiveSkillMap.headMap(Integer.valueOf(mountsRank + 1));
/* 289 */     for (Map.Entry<Integer, MountsPassiveSkillBean> entry : subMap.entrySet())
/*     */     {
/* 291 */       MountsPassiveSkillBean mountsPassiveSkillBean = (MountsPassiveSkillBean)entry.getValue();
/* 292 */       TreeMap<Integer, Integer> randomPassiveSkillMap = mountsPassiveSkillBean.randomPassiveSkillRandomMap;
/*     */       
/* 294 */       Map.Entry<Integer, Integer> lastEntry = randomPassiveSkillMap.lastEntry();
/* 295 */       if (lastEntry != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 300 */         int random = Xdb.random().nextInt(((Integer)lastEntry.getKey()).intValue());
/*     */         
/*     */ 
/* 303 */         Map.Entry<Integer, Integer> randomEntry = randomPassiveSkillMap.ceilingEntry(Integer.valueOf(random));
/*     */         
/* 305 */         xbean.PassiveSkillInfo xPassiveSkillInfo = Pod.newPassiveSkillInfo();
/* 306 */         xPassiveSkillInfo.setPassive_skill_cfg_id(((Integer)randomEntry.getValue()).intValue());
/* 307 */         xPassiveSkillInfo.setRefresh_passive_skill_cfg_id(0);
/*     */         
/* 309 */         xMountsInfo.getMounts_passive_skill_list().add(xPassiveSkillInfo);
/*     */       }
/*     */     }
/* 312 */     for (xbean.PassiveSkillInfo xPassiveSkillInfo : xMountsInfo.getMounts_passive_skill_list())
/*     */     {
/* 314 */       passiveSkillList.add(new mzm.gsp.mounts.PassiveSkillInfo(xPassiveSkillInfo.getPassive_skill_cfg_id(), xPassiveSkillInfo.getRefresh_passive_skill_cfg_id()));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onUnLockMountsFailed(int ret)
/*     */   {
/* 327 */     GameServer.logger().error(String.format("[mounts]PCUnlockMounts.processImp@unlock itemid not match mounts|ret=%d|role_id=%d|item_uuid=%d", new Object[] { Integer.valueOf(ret), Long.valueOf(this.roleId), Long.valueOf(this.itemUuid) }));
/*     */     
/*     */ 
/*     */ 
/* 331 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 332 */     sMountsNormalFail.result = ret;
/*     */     
/* 334 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCUnlockMounts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */