/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.SSyncLevelGrowthFundActivityInfo;
/*     */ import mzm.gsp.qingfu.confbean.SLevelGrowthFundActivityAwardInfo;
/*     */ import mzm.gsp.qingfu.confbean.SLevelGrowthFundCfg;
/*     */ import mzm.gsp.qingfu.confbean.SQingfuCfgConsts;
/*     */ import mzm.gsp.qingfu.event.TssChangedArg;
/*     */ import mzm.gsp.qingfu.event.TssChangedArg.TssChangedInfo;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.QingfuInfo;
/*     */ import xtable.Qingfu;
/*     */ 
/*     */ public class LevelGrowthFundActivityManager
/*     */ {
/*     */   static final void init()
/*     */   {
/*  30 */     LevelGrowthFundActivtiyHandler handler = new LevelGrowthFundActivtiyHandler();
/*  31 */     ActivityInterface.registerActivityByLogicType(42, handler, true);
/*     */   }
/*     */   
/*     */   static final void initData(String userid, long roleid, int activityCfgid)
/*     */   {
/*  36 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/*  37 */     if (xQingfuInfo == null)
/*     */     {
/*  39 */       return;
/*     */     }
/*     */     
/*  42 */     xbean.LevelGrowthFundActivityInfo xLevelGrowthFundActivityInfo = (xbean.LevelGrowthFundActivityInfo)xQingfuInfo.getLevel_growth_fund_activity_infos().get(Integer.valueOf(activityCfgid));
/*     */     
/*  44 */     if (xLevelGrowthFundActivityInfo == null)
/*     */     {
/*  46 */       xLevelGrowthFundActivityInfo = xbean.Pod.newLevelGrowthFundActivityInfo();
/*  47 */       xQingfuInfo.getLevel_growth_fund_activity_infos().put(Integer.valueOf(activityCfgid), xLevelGrowthFundActivityInfo);
/*     */     }
/*     */     
/*  50 */     long currPurchaseNum = getCalcPurchaseNum(userid, activityCfgid, xQingfuInfo);
/*  51 */     xLevelGrowthFundActivityInfo.setPurchase_num(currPurchaseNum);
/*  52 */     xLevelGrowthFundActivityInfo.setIs_reset(true);
/*  53 */     xLevelGrowthFundActivityInfo.setPurchased(false);
/*  54 */     xLevelGrowthFundActivityInfo.setSortid(-1);
/*     */   }
/*     */   
/*     */   static final boolean onRoleLogin(String userid, long roleid)
/*     */   {
/*  59 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/*  60 */     if (xQingfuInfo == null)
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     SSyncLevelGrowthFundActivityInfo core = new SSyncLevelGrowthFundActivityInfo();
/*  66 */     for (SLevelGrowthFundCfg cfg : SLevelGrowthFundCfg.getAll().values())
/*     */     {
/*  68 */       int activityCfgid = cfg.id;
/*  69 */       if (ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid).isCanJoin())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  74 */         xbean.LevelGrowthFundActivityInfo xLevelGrowthFundActivityInfo = (xbean.LevelGrowthFundActivityInfo)xQingfuInfo.getLevel_growth_fund_activity_infos().get(Integer.valueOf(activityCfgid));
/*     */         
/*  76 */         if (xLevelGrowthFundActivityInfo != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  81 */           if (!xLevelGrowthFundActivityInfo.getIs_reset())
/*     */           {
/*  83 */             xLevelGrowthFundActivityInfo.setIs_reset(true);
/*  84 */             xLevelGrowthFundActivityInfo.setPurchase_num(0L);
/*     */           }
/*     */           
/*  87 */           long currPurchaseNum = getPurchaseNum(userid, activityCfgid, xQingfuInfo);
/*  88 */           long purchaseNum = currPurchaseNum - xLevelGrowthFundActivityInfo.getPurchase_num();
/*  89 */           if (purchaseNum > 0L)
/*     */           {
/*  91 */             xLevelGrowthFundActivityInfo.setPurchased(true);
/*     */             
/*     */ 
/*  94 */             addTlog(userid, roleid, 1, 0, activityCfgid);
/*     */           }
/*     */           
/*  97 */           mzm.gsp.qingfu.LevelGrowthFundActivityInfo info = new mzm.gsp.qingfu.LevelGrowthFundActivityInfo();
/*  98 */           boxLevelGrowthFundActivityInfo(xLevelGrowthFundActivityInfo, info);
/*  99 */           core.activity_infos.put(Integer.valueOf(activityCfgid), info);
/*     */         }
/*     */       } }
/* 102 */     if (core.activity_infos.size() > 0)
/*     */     {
/* 104 */       OnlineManager.getInstance().send(roleid, core);
/*     */     }
/*     */     
/* 107 */     return true;
/*     */   }
/*     */   
/*     */   static final boolean onPurchaseService(TssChangedArg arg)
/*     */   {
/* 112 */     String userid = arg.userid;
/* 113 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 114 */     if (xQingfuInfo == null)
/*     */     {
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     Long roleid = QingfuManager.getSuitableRoleId(userid);
/* 120 */     if (roleid == null)
/*     */     {
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     SSyncLevelGrowthFundActivityInfo core = new SSyncLevelGrowthFundActivityInfo();
/* 126 */     for (SLevelGrowthFundCfg cfg : SLevelGrowthFundCfg.getAll().values())
/*     */     {
/* 128 */       QingfuManager.delayHandleContext.set(arg.changedInfos);
/*     */       try
/*     */       {
/* 131 */         int activityCfgid = cfg.id;
/* 132 */         if (!ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid.longValue(), activityCfgid).isCanJoin())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 166 */           QingfuManager.delayHandleContext.set(null);
/*     */         }
/*     */         else
/*     */         {
/* 137 */           xbean.LevelGrowthFundActivityInfo xLevelGrowthFundActivityInfo = (xbean.LevelGrowthFundActivityInfo)xQingfuInfo.getLevel_growth_fund_activity_infos().get(Integer.valueOf(activityCfgid));
/*     */           
/* 139 */           if (xLevelGrowthFundActivityInfo == null)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 166 */             QingfuManager.delayHandleContext.set(null);
/*     */           }
/*     */           else
/*     */           {
/* 144 */             if (!xLevelGrowthFundActivityInfo.getIs_reset())
/*     */             {
/* 146 */               xLevelGrowthFundActivityInfo.setIs_reset(true);
/* 147 */               xLevelGrowthFundActivityInfo.setPurchase_num(0L);
/*     */             }
/*     */             
/* 150 */             long currPurchaseNum = getPurchaseNum(userid, activityCfgid, xQingfuInfo);
/* 151 */             long purchaseNum = currPurchaseNum - xLevelGrowthFundActivityInfo.getPurchase_num();
/* 152 */             if (purchaseNum > 0L)
/*     */             {
/* 154 */               xLevelGrowthFundActivityInfo.setPurchased(true);
/*     */               
/*     */ 
/* 157 */               addTlog(userid, roleid.longValue(), 1, 0, activityCfgid);
/*     */             }
/*     */             
/* 160 */             mzm.gsp.qingfu.LevelGrowthFundActivityInfo info = new mzm.gsp.qingfu.LevelGrowthFundActivityInfo();
/* 161 */             boxLevelGrowthFundActivityInfo(xLevelGrowthFundActivityInfo, info);
/* 162 */             core.activity_infos.put(Integer.valueOf(activityCfgid), info);
/*     */           }
/*     */         }
/*     */       } finally {
/* 166 */         QingfuManager.delayHandleContext.set(null);
/*     */       }
/*     */     }
/*     */     
/* 170 */     if (core.activity_infos.size() > 0)
/*     */     {
/* 172 */       OnlineManager.getInstance().send(userid, core);
/*     */     }
/*     */     
/* 175 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static final void boxLevelGrowthFundActivityInfo(xbean.LevelGrowthFundActivityInfo xLevelGrowthFundActivityInfo, mzm.gsp.qingfu.LevelGrowthFundActivityInfo info)
/*     */   {
/* 181 */     info.sortid = xLevelGrowthFundActivityInfo.getSortid();
/* 182 */     info.purchased = ((byte)(xLevelGrowthFundActivityInfo.getPurchased() ? 1 : 0));
/*     */   }
/*     */   
/*     */   static final long getCalcPurchaseNum(String userid, int activityCfgid, QingfuInfo xQingfuInfo)
/*     */   {
/* 187 */     SLevelGrowthFundCfg cfg = SLevelGrowthFundCfg.get(activityCfgid);
/* 188 */     if (cfg == null)
/*     */     {
/* 190 */       return 0L;
/*     */     }
/*     */     
/* 193 */     Map<String, TssChangedArg.TssChangedInfo> tssChangedInfos = QingfuManager.delayHandleContext.getTssChangedInfoMap();
/* 194 */     if (tssChangedInfos == null)
/*     */     {
/* 196 */       return QingfuManager.getTssBuyTimes(userid, xQingfuInfo, cfg.serviceId);
/*     */     }
/*     */     
/* 199 */     TssChangedArg.TssChangedInfo tssChangedInfo = (TssChangedArg.TssChangedInfo)tssChangedInfos.get(String.valueOf(cfg.serviceId));
/* 200 */     if (tssChangedInfo == null)
/*     */     {
/* 202 */       return QingfuManager.getTssBuyTimes(userid, xQingfuInfo, cfg.serviceId);
/*     */     }
/*     */     
/* 205 */     return QingfuManager.getTssBuyTimes(userid, tssChangedInfo.oldTotalOpenDays, cfg.serviceId);
/*     */   }
/*     */   
/*     */   static final long getPurchaseNum(String userid, int activityCfgid, QingfuInfo xQingfuInfo)
/*     */   {
/* 210 */     SLevelGrowthFundCfg cfg = SLevelGrowthFundCfg.get(activityCfgid);
/* 211 */     if (cfg == null)
/*     */     {
/* 213 */       return 0L;
/*     */     }
/*     */     
/* 216 */     return QingfuManager.getTssBuyTimes(userid, xQingfuInfo, cfg.serviceId);
/*     */   }
/*     */   
/*     */   static final int getAward(String userid, long roleid, int activityCfgid, int sortid)
/*     */   {
/* 221 */     SLevelGrowthFundCfg levelGrowthFundCfg = SLevelGrowthFundCfg.get(activityCfgid);
/* 222 */     if (levelGrowthFundCfg == null)
/*     */     {
/* 224 */       return 1;
/*     */     }
/*     */     
/* 227 */     SLevelGrowthFundActivityAwardInfo levelGrowthFundActivityAwardInfo = (SLevelGrowthFundActivityAwardInfo)levelGrowthFundCfg.award_infos.get(Integer.valueOf(sortid));
/* 228 */     if (levelGrowthFundActivityAwardInfo == null)
/*     */     {
/* 230 */       return 2;
/*     */     }
/*     */     
/* 233 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 234 */     if (xQingfuInfo == null)
/*     */     {
/* 236 */       return 3;
/*     */     }
/*     */     
/* 239 */     xbean.LevelGrowthFundActivityInfo xLevelGrowthFundActivityInfo = (xbean.LevelGrowthFundActivityInfo)xQingfuInfo.getLevel_growth_fund_activity_infos().get(Integer.valueOf(activityCfgid));
/*     */     
/* 241 */     if (xLevelGrowthFundActivityInfo == null)
/*     */     {
/* 243 */       return 4;
/*     */     }
/*     */     
/* 246 */     if (!xLevelGrowthFundActivityInfo.getIs_reset())
/*     */     {
/* 248 */       xLevelGrowthFundActivityInfo.setIs_reset(true);
/* 249 */       xLevelGrowthFundActivityInfo.setPurchase_num(0L);
/*     */     }
/*     */     
/* 252 */     long currPurchaseNum = getPurchaseNum(userid, activityCfgid, xQingfuInfo);
/* 253 */     long basePurchaseNum = xLevelGrowthFundActivityInfo.getPurchase_num();
/* 254 */     if (!xLevelGrowthFundActivityInfo.getPurchased())
/*     */     {
/* 256 */       long deltaPurchaseNum = currPurchaseNum - basePurchaseNum;
/* 257 */       if (deltaPurchaseNum <= 0L)
/*     */       {
/* 259 */         return -1;
/*     */       }
/*     */     }
/*     */     
/* 263 */     int oldSortid = xLevelGrowthFundActivityInfo.getSortid();
/* 264 */     if (oldSortid >= 0)
/*     */     {
/* 266 */       int delta = sortid - oldSortid;
/* 267 */       if (delta <= 0)
/*     */       {
/* 269 */         return -3;
/*     */       }
/*     */       
/* 272 */       if (delta > 1)
/*     */       {
/* 274 */         return 5;
/*     */       }
/*     */     }
/* 277 */     else if (sortid != 1)
/*     */     {
/* 279 */       return 5;
/*     */     }
/*     */     
/* 282 */     Role role = RoleInterface.getRole(roleid, true);
/* 283 */     if (role == null)
/*     */     {
/* 285 */       return 6;
/*     */     }
/*     */     
/* 288 */     int roleLevel = role.getLevel();
/* 289 */     if ((roleLevel < SQingfuCfgConsts.getInstance().LEVEL_GROWTH_FUND_ENABLE_NEED_ROLE_LEVEL) || (roleLevel < levelGrowthFundActivityAwardInfo.level_cond))
/*     */     {
/*     */ 
/* 292 */       return -2;
/*     */     }
/*     */     
/* 295 */     AwardReason levelGrowthFundActivityAwardReason = new AwardReason(LogReason.LEVEL_GROWTH_FUND_ACTIVITY_AWARD_ADD, activityCfgid, PresentType.PRESENT_BIND_LEVEL_GROWTH_FUND_ACTIVITY);
/*     */     
/*     */ 
/*     */ 
/* 299 */     levelGrowthFundActivityAwardReason.setAwardItemBind(true);
/* 300 */     mzm.gsp.award.main.AwardModel awardModel = AwardInterface.awardFixAward(levelGrowthFundActivityAwardInfo.award_cfg_id, userid, roleid, true, true, levelGrowthFundActivityAwardReason);
/*     */     
/* 302 */     if (awardModel == null)
/*     */     {
/*     */ 
/* 305 */       return 7;
/*     */     }
/*     */     
/* 308 */     if (!xLevelGrowthFundActivityInfo.getPurchased())
/*     */     {
/* 310 */       xLevelGrowthFundActivityInfo.setPurchased(true);
/*     */       
/*     */ 
/* 313 */       addTlog(userid, roleid, 1, 0, activityCfgid);
/*     */     }
/* 315 */     xLevelGrowthFundActivityInfo.setSortid(sortid);
/*     */     
/*     */ 
/* 318 */     addTlog(userid, roleid, 2, levelGrowthFundActivityAwardInfo.award_cfg_id, activityCfgid);
/*     */     
/* 320 */     GameServer.logger().info(String.format("[qingfu]LevelGrowthFundActivityManager.getAward@get level growth fund activity award|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|award_cfg_id=%d|purchase_num=%d|base_purchase_num=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(activityCfgid), Integer.valueOf(sortid), Integer.valueOf(levelGrowthFundActivityAwardInfo.award_cfg_id), Long.valueOf(currPurchaseNum), Long.valueOf(basePurchaseNum) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 326 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static final void addTlog(String userid, long roleid, int status, int awardid, int activityCfgid)
/*     */   {
/* 346 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 347 */     StringBuilder sbLog = new StringBuilder();
/* 348 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|').append(userid).append('|').append(roleid).append('|').append(roleLevel).append('|');
/*     */     
/* 350 */     sbLog.append(status).append('|').append(awardid).append('|').append(activityCfgid);
/* 351 */     TLogManager.getInstance().addLog(roleid, "LevelGrowthFundForServer", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\LevelGrowthFundActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */