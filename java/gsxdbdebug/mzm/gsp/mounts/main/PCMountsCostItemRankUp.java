/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SMountsCostItemRankUpSuccess;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.confbean.MountsPassiveSkillBean;
/*     */ import mzm.gsp.mounts.confbean.MountsRankInfoBean;
/*     */ import mzm.gsp.mounts.confbean.SMountsPassiveSkillCfg;
/*     */ import mzm.gsp.mounts.confbean.SMountsRankCfg;
/*     */ import mzm.gsp.mounts.event.MountsPetPassiveSkillChangeArg;
/*     */ import mzm.gsp.mounts.event.MountsRankUp;
/*     */ import mzm.gsp.mounts.event.RideMountsModelChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleMountsInfo;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.PassiveSkillInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xtable.Role2mounts;
/*     */ 
/*     */ public class PCMountsCostItemRankUp extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long rankUpMountsId;
/*     */   private final long clientYuanBao;
/*     */   private final int needYuanBao;
/*     */   private final int isUseYuanBao;
/*     */   private int mountsCfgId;
/*     */   
/*     */   public PCMountsCostItemRankUp(long roleId, long rankUpMountsId, long clientYuanBao, int needYuanBao, int isUseYuanBao)
/*     */   {
/*  42 */     this.roleId = roleId;
/*  43 */     this.rankUpMountsId = rankUpMountsId;
/*  44 */     this.clientYuanBao = clientYuanBao;
/*  45 */     this.needYuanBao = needYuanBao;
/*  46 */     this.isUseYuanBao = isUseYuanBao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  52 */     if (((this.isUseYuanBao != 1) && (this.isUseYuanBao != 0)) || (this.needYuanBao < 0) || (this.clientYuanBao < 0L))
/*     */     {
/*     */ 
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCMountsCostItemRankUp.processImp"))
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     if (!MountsManager.isLevelOpen(this.roleId, "PCMountsCostItemRankUp.processImp"))
/*     */     {
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     String userId = RoleInterface.getUserId(this.roleId);
/*  69 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*     */     
/*  71 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1036, true, true))
/*     */     {
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  77 */     if (xRole2MountsInfo == null)
/*     */     {
/*  79 */       onMountsCostItemRankUpFail(2);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     Map<Long, MountsInfo> xMountsInfoMap = xRole2MountsInfo.getMounts_info_map();
/*  84 */     MountsInfo xRankUpMountsInfo = (MountsInfo)xMountsInfoMap.get(Long.valueOf(this.rankUpMountsId));
/*  85 */     if (xRankUpMountsInfo == null)
/*     */     {
/*  87 */       onMountsCostItemRankUpFail(4);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     this.mountsCfgId = xRankUpMountsInfo.getMounts_cfg_id();
/*  92 */     SMountsRankCfg sMountsRankCfg = SMountsRankCfg.get(this.mountsCfgId);
/*  93 */     if (sMountsRankCfg == null)
/*     */     {
/*  95 */       onMountsCostItemRankUpFail(59);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     int nextMountsRank = xRankUpMountsInfo.getMounts_rank() + 1;
/* 100 */     MountsRankInfoBean mountsRankInfoBean = (MountsRankInfoBean)sMountsRankCfg.mountsRankMapInfo.get(Integer.valueOf(nextMountsRank));
/* 101 */     if (mountsRankInfoBean == null)
/*     */     {
/* 103 */       onMountsCostItemRankUpFail(59);
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     long roleLevel = RoleInterface.getLevel(this.roleId);
/* 108 */     if (roleLevel < mountsRankInfoBean.needRoleLevel)
/*     */     {
/* 110 */       onMountsCostItemRankUpFail(57);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     int xNowMountsScore = xRankUpMountsInfo.getCurrent_score();
/* 115 */     int nextRankNeedScore = mountsRankInfoBean.rankUpNeedScoreNum;
/*     */     
/* 117 */     if (xNowMountsScore < nextRankNeedScore)
/*     */     {
/* 119 */       onMountsCostItemRankUpFail(61);
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     int costItemId = mountsRankInfoBean.rankUpCostItemId;
/* 124 */     int costItemNum = mountsRankInfoBean.rankUpCostItemIdNum;
/*     */     
/* 126 */     boolean result = MountsManager.costItem(userId, this.roleId, this.isUseYuanBao, this.clientYuanBao, this.needYuanBao, mountsRankInfoBean.rankUpcostItemType, costItemId, costItemNum, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_MOUNTS_RANK_UP, mzm.gsp.tlog.LogReason.MOUNTS_RANK_UP_COST_ITEM);
/*     */     
/*     */ 
/* 129 */     if (!result)
/*     */     {
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     int nowScore = xNowMountsScore - nextRankNeedScore;
/* 135 */     xRankUpMountsInfo.setCurrent_score(nowScore);
/* 136 */     xRankUpMountsInfo.setMounts_rank(nextMountsRank);
/* 137 */     xRankUpMountsInfo.setCurrent_ornament_rank(nextMountsRank);
/* 138 */     SMountsPassiveSkillCfg sMountsPassiveSkillCfg = SMountsPassiveSkillCfg.get(this.mountsCfgId);
/* 139 */     if (sMountsPassiveSkillCfg == null)
/*     */     {
/* 141 */       onMountsCostItemRankUpFail(44);
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     MountsPassiveSkillBean mountsPassiveSkillBean = (MountsPassiveSkillBean)sMountsPassiveSkillCfg.rankPassiveSkillMap.get(Integer.valueOf(nextMountsRank));
/* 146 */     if (mountsPassiveSkillBean != null)
/*     */     {
/*     */ 
/* 149 */       TreeMap<Integer, Integer> randomPassiveSkillMap = mountsPassiveSkillBean.randomPassiveSkillRandomMap;
/*     */       
/* 151 */       Map.Entry<Integer, Integer> lastEntry = randomPassiveSkillMap.lastEntry();
/* 152 */       if (lastEntry != null)
/*     */       {
/* 154 */         int random = xdb.Xdb.random().nextInt(((Integer)lastEntry.getKey()).intValue());
/*     */         
/*     */ 
/* 157 */         Map.Entry<Integer, Integer> randomEntry = randomPassiveSkillMap.ceilingEntry(Integer.valueOf(random));
/*     */         
/* 159 */         PassiveSkillInfo xPassiveSkillInfo = xbean.Pod.newPassiveSkillInfo();
/* 160 */         xPassiveSkillInfo.setPassive_skill_cfg_id(((Integer)randomEntry.getValue()).intValue());
/* 161 */         xPassiveSkillInfo.setRefresh_passive_skill_cfg_id(0);
/*     */         
/* 163 */         xRankUpMountsInfo.getMounts_passive_skill_list().add(xPassiveSkillInfo);
/*     */       }
/*     */     }
/*     */     
/* 167 */     for (BattleMountsInfo xBattleMountsInfo : xRole2MountsInfo.getBattle_mounts_info_map().values())
/*     */     {
/*     */ 
/* 170 */       if (xBattleMountsInfo.getMounts_id() == this.rankUpMountsId)
/*     */       {
/* 172 */         MountsManager.triggerMountsRolePropertyChangeEvent(new mzm.gsp.mounts.event.MountsRolePropertyChangeArg(this.roleId));
/*     */         
/* 174 */         for (Iterator i$ = xBattleMountsInfo.getProtect_pet_id_list().iterator(); i$.hasNext();) { long petId = ((Long)i$.next()).longValue();
/*     */           
/* 176 */           MountsManager.triggerMountsPetPassiveSkillChangeEvent(new MountsPetPassiveSkillChangeArg(this.roleId, petId));
/*     */         }
/* 178 */         break;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 183 */     if (xRole2MountsInfo.getCurrent_ride_mounts_id() == this.rankUpMountsId)
/*     */     {
/* 185 */       MountsManager.triggerRideMountsModelChangeEvent(new RideMountsModelChangeArg(this.roleId, xRankUpMountsInfo.getMounts_cfg_id(), xRankUpMountsInfo.getCurrent_ornament_rank(), xRankUpMountsInfo.getMounts_dye_color_id(), 1));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 192 */     SMountsCostItemRankUpSuccess sMountsCostItemRankUpSuccess = new SMountsCostItemRankUpSuccess();
/* 193 */     sMountsCostItemRankUpSuccess.mounts_id = this.rankUpMountsId;
/* 194 */     MountsManager.fillMountsInfoProtocol(xRankUpMountsInfo, sMountsCostItemRankUpSuccess.rank_up_mounts_info);
/* 195 */     OnlineManager.getInstance().send(this.roleId, sMountsCostItemRankUpSuccess);
/*     */     
/* 197 */     MountsManager.tlogMountsCostItemRankUp(userId, this.roleId, this.rankUpMountsId, this.mountsCfgId, xRankUpMountsInfo.getMounts_rank(), costItemId, costItemNum, this.isUseYuanBao, xRankUpMountsInfo.getMounts_passive_skill_list());
/*     */     
/*     */ 
/*     */ 
/* 201 */     TriggerEventsManger.getInstance().triggerEvent(new MountsRankUp(), new mzm.gsp.mounts.event.MountsRankUpArg(this.roleId, this.rankUpMountsId, this.mountsCfgId, nextMountsRank), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*     */ 
/* 205 */     GameServer.logger().info(String.format("[mounts]PCMountsCostItemRankUp.processImp@mounts cost item rank up success|role_id=%d|rank_up_mounts_id=%d|now_rank=%d|now_score=%d|mount_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.rankUpMountsId), Integer.valueOf(nextMountsRank), Integer.valueOf(nowScore), Integer.valueOf(this.mountsCfgId) }));
/*     */     
/*     */ 
/*     */ 
/* 209 */     return true;
/*     */   }
/*     */   
/*     */   private void onMountsCostItemRankUpFail(int ret)
/*     */   {
/* 214 */     GameServer.logger().error(String.format("[mounts]PCMountsCostItemRankUp.processImp@mounts cost item rank up fail|role_id=%d|rank_up_mounts_id=%d|mounts_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.rankUpMountsId), Integer.valueOf(this.mountsCfgId) }));
/*     */     
/*     */ 
/*     */ 
/* 218 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 219 */     sMountsNormalFail.result = ret;
/*     */     
/* 221 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCMountsCostItemRankUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */