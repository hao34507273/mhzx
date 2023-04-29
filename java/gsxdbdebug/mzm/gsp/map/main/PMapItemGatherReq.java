/*     */ package mzm.gsp.map.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.awardpool.confbean.SAwardPoolMainTable;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.map.SMapCommonResult;
/*     */ import mzm.gsp.map.SMapItemGatherSuccess;
/*     */ import mzm.gsp.map.confbean.SMapItemCfg;
/*     */ import mzm.gsp.map.event.PlayerGatherItemSuccess;
/*     */ import mzm.gsp.map.main.message.MMH_MapItemGatherCheck;
/*     */ import mzm.gsp.map.main.message.MMH_OnMapItemGathered;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GatherMapItemInfo;
/*     */ import xbean.Properties;
/*     */ import xdb.Lockey;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PMapItemGatherReq
/*     */   extends LogicProcedure
/*     */ {
/*  46 */   private static final Logger logger = Logger.getLogger(MapModule.class);
/*     */   
/*     */   private final long roleid;
/*     */   private final int instanceid;
/*     */   private final MapItemGatherContext context;
/*     */   
/*     */   public PMapItemGatherReq(long roleid, int instanceid, MapItemGatherContext context)
/*     */   {
/*  54 */     this.roleid = roleid;
/*  55 */     this.instanceid = instanceid;
/*  56 */     this.context = context;
/*     */   }
/*     */   
/*     */   public long getGatherRoleId()
/*     */   {
/*  61 */     return this.roleid;
/*     */   }
/*     */   
/*     */   public int getMapItemInstanceId()
/*     */   {
/*  66 */     return this.instanceid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  73 */     MMH_MapItemGatherCheck checker = new MMH_MapItemGatherCheck(this.roleid, this.instanceid);
/*  74 */     checker.call();
/*     */     
/*  76 */     SMapItemCfg cfg = checker.getMapItemCfg();
/*  77 */     if (cfg == null)
/*     */     {
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if (!MapManager.canDoAction(this.roleid, 162))
/*     */     {
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     if (this.context != null)
/*     */     {
/*  89 */       if ((this.context instanceof MapItemGatherSavePostionContext))
/*     */       {
/*  91 */         ((MapItemGatherSavePostionContext)this.context).saveMapItemPosition(checker.getMapItemPos());
/*     */       }
/*     */     }
/*     */     
/*  95 */     long worldid = checker.getWorldid();
/*  96 */     int mapCfgid = checker.getMapCfgid();
/*  97 */     int mapItemCfgid = checker.getMapItemCfgid();
/*     */     
/*  99 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*     */ 
/* 102 */     Set<Lockey> lockeys = new HashSet();
/*     */     
/* 104 */     lockeys.add(Lockeys.get(User.getTable(), userid));
/*     */     
/* 106 */     lockeys.add(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/* 107 */     MapItemGatherHandler handler = MapItemGatherHandlerManager.getInstance().getHandler(cfg.handlerType);
/* 108 */     if (handler != null)
/*     */     {
/* 110 */       Set<Lockey> tmpLockeys = handler.collectLocks(userid, this.roleid, worldid, mapCfgid, mapItemCfgid, this.context);
/*     */       
/* 112 */       if ((tmpLockeys != null) && (!tmpLockeys.isEmpty()))
/*     */       {
/* 114 */         lockeys.addAll(tmpLockeys);
/*     */       }
/*     */     }
/* 117 */     Lockey[] arrLockeys = new Lockey[lockeys.size()];
/* 118 */     lock((Lockey[])lockeys.toArray(arrLockeys));
/*     */     
/* 120 */     if (handler != null)
/*     */     {
/* 122 */       if (!handler.gatherCheck(userid, this.roleid, worldid, mapCfgid, mapItemCfgid, this.context))
/*     */       {
/* 124 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 128 */     Role role = RoleInterface.getRole(this.roleid, true);
/*     */     
/* 130 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleid);
/* 131 */     if ((teamInfo != null) && (!cfg.isTeamMemberCanOpen))
/*     */     {
/* 133 */       if (!teamInfo.isLeader(this.roleid))
/*     */       {
/* 135 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 140 */     if (cfg.minNum > 1)
/*     */     {
/* 142 */       if (teamInfo.getTeamNormalMembersNum() < cfg.minNum)
/*     */       {
/* 144 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 149 */     int lv = role.getLevel();
/* 150 */     if ((cfg.minLevel > lv) || (cfg.maxLevel < lv))
/*     */     {
/* 152 */       return false;
/*     */     }
/*     */     
/* 155 */     if (cfg.dailyMaxGatherLimit > 0)
/*     */     {
/* 157 */       Properties xProperties = Role2properties.get(Long.valueOf(this.roleid));
/* 158 */       if (xProperties == null)
/*     */       {
/* 160 */         return false;
/*     */       }
/*     */       
/* 163 */       GatherMapItemInfo xGatherMapItemInfo = (GatherMapItemInfo)xProperties.getGather_map_item_infos().get(Integer.valueOf(mapItemCfgid));
/* 164 */       if (xGatherMapItemInfo == null)
/*     */       {
/* 166 */         return false;
/*     */       }
/*     */       
/* 169 */       long currTime = DateTimeUtils.getCurrTimeInMillis();
/* 170 */       int gatherSuccessTimes = 0;
/* 171 */       if (!DateTimeUtils.needDailyReset(xGatherMapItemInfo.getGather_success_timestamp(), currTime, 0))
/*     */       {
/* 173 */         gatherSuccessTimes = xGatherMapItemInfo.getGather_success_times();
/*     */       }
/* 175 */       if (gatherSuccessTimes >= cfg.dailyMaxGatherLimit)
/*     */       {
/* 177 */         SMapCommonResult mapCommonResult = new SMapCommonResult();
/* 178 */         mapCommonResult.result = 104;
/* 179 */         OnlineManager.getInstance().sendAtOnce(this.roleid, mapCommonResult);
/* 180 */         return false;
/*     */       }
/*     */       
/* 183 */       xGatherMapItemInfo.setGather_success_times(gatherSuccessTimes + 1);
/* 184 */       xGatherMapItemInfo.setGather_success_timestamp(currTime);
/*     */     }
/*     */     
/*     */ 
/* 188 */     if ((cfg.needItemId > 0) && (cfg.needItemNum > 0))
/*     */     {
/* 190 */       if (!ItemInterface.removeItemById(this.roleid, 340600000, cfg.needItemId, cfg.needItemNum, new TLogArg(LogReason.MAP_ITEM_OPEN_REM, cfg.needItemId)))
/*     */       {
/*     */ 
/* 193 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 198 */     if (cfg.openCostYuanBao > 0)
/*     */     {
/* 200 */       if (QingfuInterface.costYuanbao(userid, this.roleid, cfg.openCostYuanBao, CostType.COST_BIND_FIRST_MAP_ITEM_GATHER, new TLogArg(LogReason.MAP_ITEM_OPEN_REM, cfg.needItemId)) != CostResult.Success)
/*     */       {
/*     */ 
/* 203 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 207 */     if (cfg.openCostGold > 0)
/*     */     {
/* 209 */       if (!RoleInterface.cutGold(this.roleid, cfg.openCostGold, new TLogArg(LogReason.MAP_ITEM_OPEN_REM, cfg.needItemId)))
/*     */       {
/* 211 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 215 */     if (cfg.openCostSilver > 0)
/*     */     {
/* 217 */       if (!RoleInterface.cutSilver(this.roleid, cfg.openCostSilver, new TLogArg(LogReason.MAP_ITEM_OPEN_REM, cfg.needItemId)))
/*     */       {
/* 219 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 223 */     if (cfg.fixAwardId > 0)
/*     */     {
/* 225 */       AwardModel awardModel = AwardInterface.awardFixAward(cfg.fixAwardId, userid, this.roleid, true, true, new AwardReason(LogReason.MAP_ITEM_OPEN_ADD));
/*     */       
/* 227 */       if (awardModel == null)
/*     */       {
/* 229 */         return false;
/*     */       }
/*     */     }
/* 232 */     int awardItemId = 0;
/* 233 */     int awardItemNum = 0;
/* 234 */     if (cfg.awardPoolId > 0)
/*     */     {
/* 236 */       SAwardPoolMainTable poolId = AwardPoolInterface.getAwardPoolSumIdByLevel(cfg.awardPoolId, RoleInterface.getLevel(this.roleid));
/*     */       
/* 238 */       if (poolId != null)
/*     */       {
/* 240 */         AwardPoolResultData resultData = AwardPoolInterface.randomAwardPoolForRole(this.roleid, poolId.buffEffectIds, poolId.awardPoolSumId);
/*     */         
/* 242 */         if (resultData != null)
/*     */         {
/* 244 */           AwardPoolInterface.doAward(userid, this.roleid, resultData, new TLogArg(LogReason.MAP_ITEM_OPEN_ADD));
/* 245 */           for (Map.Entry<Integer, Integer> entry : resultData.getItemMap().entrySet())
/*     */           {
/* 247 */             awardItemId = ((Integer)entry.getKey()).intValue();
/* 248 */             awardItemNum = ((Integer)entry.getValue()).intValue();
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 254 */         String logString = String.format("[mapitem]PMapItemGatherReq.processImp@SAwardPoolMainTable null|roleid=%d|awardpoolid=%d|level=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(cfg.awardPoolId), Integer.valueOf(RoleInterface.getLevel(this.roleid)) });
/*     */         
/*     */ 
/*     */ 
/* 258 */         logger.error(logString);
/*     */       }
/*     */     }
/*     */     
/* 262 */     if (handler != null)
/*     */     {
/* 264 */       if (!handler.onGather(userid, this.roleid, worldid, mapCfgid, mapItemCfgid, awardItemId, awardItemNum, this.context))
/*     */       {
/* 266 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 270 */     SMapItemGatherSuccess mapItemGatherSuccess = new SMapItemGatherSuccess();
/* 271 */     mapItemGatherSuccess.instanceid = mapItemCfgid;
/* 272 */     mapItemGatherSuccess.itemid = awardItemId;
/* 273 */     mapItemGatherSuccess.num = awardItemNum;
/* 274 */     OnlineManager.getInstance().send(this.roleid, mapItemGatherSuccess);
/*     */     
/* 276 */     PlayerGatherItemSuccess gatherItemSuccess = new PlayerGatherItemSuccess();
/* 277 */     GatherItemEventArg gatherItemEventArg = new GatherItemEventArg();
/* 278 */     gatherItemEventArg.gatherItemCfgId = mapItemCfgid;
/* 279 */     gatherItemEventArg.mapId = mapCfgid;
/* 280 */     gatherItemEventArg.worldId = worldid;
/* 281 */     gatherItemEventArg.roleId = this.roleid;
/* 282 */     gatherItemEventArg.itemid = awardItemId;
/* 283 */     gatherItemEventArg.itemNum = awardItemNum;
/* 284 */     TriggerEventsManger.getInstance().triggerEvent(gatherItemSuccess, gatherItemEventArg);
/*     */     
/*     */ 
/* 287 */     new MMH_OnMapItemGathered(this.roleid, this.instanceid).call();
/*     */     
/* 289 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PMapItemGatherReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */