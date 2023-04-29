/*     */ package mzm.gsp.cat.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.cat.SSendCatToExploreFailed;
/*     */ import mzm.gsp.cat.SSendCatToExploreSuccess;
/*     */ import mzm.gsp.cat.confbean.SCatCfgConsts;
/*     */ import mzm.gsp.cat.confbean.SCatLevelCfg;
/*     */ import mzm.gsp.cat.confbean.SLevelToCatCfg;
/*     */ import mzm.gsp.cat.event.SendCatToExplore;
/*     */ import mzm.gsp.cat.event.SendCatToExploreArg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CatInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Catexploreobservers;
/*     */ 
/*     */ public class PCSendCatToExplore extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private long catid;
/*     */   
/*     */   public PCSendCatToExplore(long roleid)
/*     */   {
/*  35 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!CatManager.isFunOpen(this.roleid))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     if (!CatManager.checkRoleStatus(this.roleid))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  55 */       onFailed(6);
/*  56 */       return false;
/*     */     }
/*  58 */     long worldid = HomelandInterface.getHomeWorldIdByRoleId(this.roleid, false);
/*  59 */     if (worldid < 0L)
/*     */     {
/*  61 */       onFailed(11);
/*  62 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  66 */     CatInfo xCatInfo = CatManager.getHomelandCat(this.roleid, true);
/*  67 */     if (xCatInfo == null)
/*     */     {
/*  69 */       onFailed(4);
/*  70 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  74 */     if (!CatManager.checkNpcService(this.roleid, xCatInfo))
/*     */     {
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     this.catid = xCatInfo.getId();
/*  81 */     lock(Lockeys.get(Catexploreobservers.getTable(), Long.valueOf(this.catid)));
/*     */     
/*     */ 
/*  84 */     if (!CatManager.checkState(xCatInfo))
/*     */     {
/*  86 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  90 */     if (xCatInfo.getState() != 1)
/*     */     {
/*  92 */       Map<String, Object> extras = new HashMap();
/*  93 */       extras.put("current_state", Integer.valueOf(xCatInfo.getState()));
/*  94 */       extras.put("item_cfgid", Integer.valueOf(xCatInfo.getItem_cfgid()));
/*  95 */       extras.put("cat_level_cfgid", Integer.valueOf(xCatInfo.getCat_level_cfgid()));
/*     */       
/*  97 */       onFailed(5, extras);
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     int curLevel = CatManager.getCatLevel(xCatInfo);
/* 102 */     if (curLevel < 0)
/*     */     {
/* 104 */       return false;
/*     */     }
/* 106 */     SLevelToCatCfg levelToCatCfg = SLevelToCatCfg.get(curLevel);
/* 107 */     if (levelToCatCfg == null)
/*     */     {
/* 109 */       Map<String, Object> extras = new HashMap();
/* 110 */       extras.put("item_cfgid", Integer.valueOf(xCatInfo.getItem_cfgid()));
/* 111 */       extras.put("cat_level_cfgid", Integer.valueOf(xCatInfo.getCat_level_cfgid()));
/* 112 */       extras.put("total_explore_num", Integer.valueOf(xCatInfo.getTotal_explore_num()));
/*     */       
/* 114 */       onFailed(14, extras);
/* 115 */       return false;
/*     */     }
/* 117 */     SCatLevelCfg catLevelCfg = SCatLevelCfg.get(levelToCatCfg.catLevelCfgid);
/* 118 */     if (catLevelCfg == null)
/*     */     {
/* 120 */       Map<String, Object> extras = new HashMap();
/* 121 */       extras.put("item_cfgid", Integer.valueOf(xCatInfo.getItem_cfgid()));
/* 122 */       extras.put("cat_level_cfgid", Integer.valueOf(xCatInfo.getCat_level_cfgid()));
/* 123 */       extras.put("total_explore_num", Integer.valueOf(xCatInfo.getTotal_explore_num()));
/* 124 */       extras.put("cur_cat_level_cfgid", Integer.valueOf(levelToCatCfg.catLevelCfgid));
/*     */       
/* 126 */       onFailed(15, extras);
/* 127 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 131 */     int vigor = xCatInfo.getVigor();
/* 132 */     if (vigor < catLevelCfg.vigorMax)
/*     */     {
/* 134 */       Map<String, Object> extras = new HashMap();
/* 135 */       extras.put("item_cfgid", Integer.valueOf(xCatInfo.getItem_cfgid()));
/* 136 */       extras.put("cat_level_cfgid", Integer.valueOf(xCatInfo.getCat_level_cfgid()));
/* 137 */       extras.put("total_explore_num", Integer.valueOf(xCatInfo.getTotal_explore_num()));
/* 138 */       extras.put("current_vigor", Integer.valueOf(xCatInfo.getVigor()));
/* 139 */       extras.put("vigor_max", Integer.valueOf(catLevelCfg.vigorMax));
/*     */       
/* 141 */       onFailed(-1, extras);
/* 142 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 146 */     CatManager.checkDailyExploreNum(xCatInfo);
/* 147 */     if (xCatInfo.getExplore_num() >= catLevelCfg.exploreMax)
/*     */     {
/* 149 */       Map<String, Object> extras = new HashMap();
/* 150 */       extras.put("item_cfgid", Integer.valueOf(xCatInfo.getItem_cfgid()));
/* 151 */       extras.put("cat_level_cfgid", Integer.valueOf(xCatInfo.getCat_level_cfgid()));
/* 152 */       extras.put("explore_num", Integer.valueOf(xCatInfo.getExplore_num()));
/* 153 */       extras.put("explore_max", Integer.valueOf(catLevelCfg.exploreMax));
/*     */       
/* 155 */       onFailed(-2, extras);
/* 156 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 160 */     if ((xCatInfo.getExplored_level() != 0) || (xCatInfo.getExplored_partner_cfgid() != 0))
/*     */     {
/* 162 */       Map<String, Object> extras = new HashMap();
/* 163 */       extras.put("item_cfgid", Integer.valueOf(xCatInfo.getItem_cfgid()));
/* 164 */       extras.put("cat_level_cfgid", Integer.valueOf(xCatInfo.getCat_level_cfgid()));
/* 165 */       extras.put("explored_level", Integer.valueOf(xCatInfo.getExplored_level()));
/* 166 */       extras.put("explored_partner_cfgid", Integer.valueOf(xCatInfo.getExplored_partner_cfgid()));
/*     */       
/* 168 */       onFailed(-3, extras);
/* 169 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 173 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 174 */     int costMinutes = CatManager.randomCostTime(catLevelCfg.exploreTimeMin, catLevelCfg.exploreTimeMax);
/* 175 */     long costTime = TimeUnit.MINUTES.toMillis(costMinutes);
/* 176 */     long endTime = now + costTime;
/* 177 */     int oldPartnerCfgid = xCatInfo.getPartner_cfgid();
/* 178 */     int bestPartnerCfgid = BestPartner.getInstance().getPartnerCfgid();
/* 179 */     boolean isBestPartner = oldPartnerCfgid == bestPartnerCfgid;
/*     */     
/* 181 */     xCatInfo.setExplore_starttime(now);
/* 182 */     xCatInfo.setExplore_costtime(costTime);
/* 183 */     xCatInfo.setExplore_endtime(endTime);
/* 184 */     if (curLevel < SCatCfgConsts.getInstance().MAX_CAT_LEVEL)
/*     */     {
/* 186 */       xCatInfo.setTotal_explore_num(xCatInfo.getTotal_explore_num() + 1);
/*     */     }
/* 188 */     xCatInfo.setState(2);
/* 189 */     xCatInfo.setExplored_level(curLevel);
/* 190 */     if (isBestPartner)
/*     */     {
/* 192 */       xCatInfo.setExplored_partner_cfgid(oldPartnerCfgid);
/*     */     }
/*     */     else
/*     */     {
/* 196 */       xCatInfo.setExplored_partner_cfgid(0);
/*     */     }
/* 198 */     xCatInfo.setVigor(0);
/* 199 */     xCatInfo.setExplore_num(xCatInfo.getExplore_num() + 1);
/*     */     
/* 201 */     int newPartnerCfgid = CatManager.randomPartner();
/* 202 */     if (newPartnerCfgid < 0)
/*     */     {
/* 204 */       return false;
/*     */     }
/* 206 */     xCatInfo.setPartner_cfgid(newPartnerCfgid);
/*     */     
/*     */ 
/* 209 */     SendCatToExplore sendCatToExploreEvent = new SendCatToExplore();
/* 210 */     TriggerEventsManger.getInstance().triggerEvent(sendCatToExploreEvent, new SendCatToExploreArg(this.roleid, this.catid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/*     */ 
/* 214 */     CatManager.exploreObserver(this.roleid, this.catid, TimeUnit.MINUTES.toSeconds(costMinutes));
/*     */     
/*     */ 
/* 217 */     tlog(this.roleid, this.catid, xCatInfo.getCat_level_cfgid(), xCatInfo.getItem_cfgid(), xCatInfo.getTotal_explore_num(), xCatInfo.getVigor(), xCatInfo.getState(), oldPartnerCfgid, bestPartnerCfgid, TimeUnit.MILLISECONDS.toSeconds(now), costMinutes, TimeUnit.MILLISECONDS.toSeconds(endTime), xCatInfo.getExplore_num());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 222 */     SSendCatToExploreSuccess resp = new SSendCatToExploreSuccess();
/* 223 */     resp.explore_end_timestamp = ((int)TimeUnit.MILLISECONDS.toSeconds(endTime));
/* 224 */     resp.is_best_partner = ((byte)(isBestPartner ? 1 : 0));
/* 225 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/* 227 */     GameServer.logger().info(String.format("[cat]PCSendCatToExplore.processImp@send cat to explore success|roleid=%d|catid=%d|cat_level_cfgid=%d|item_cfgid=%d|total_explore_num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.catid), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()), Integer.valueOf(xCatInfo.getTotal_explore_num()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 233 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void tlog(long roleid, long catid, int catLevelCfgid, int itemCfgid, int totalExploreNum, int vigor, int state, int partnerCfgid, int bestPartnerCfgid, long exploreStartTime, int costMinutes, long exploreEndTime, int exploreNum)
/*     */   {
/* 241 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 242 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 243 */     String userid = RoleInterface.getUserId(roleid);
/* 244 */     TLogManager.getInstance().addLog(userid, "SendCatToExploreForServer", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Long.valueOf(catid), Integer.valueOf(catLevelCfgid), Integer.valueOf(itemCfgid), Integer.valueOf(totalExploreNum), Integer.valueOf(vigor), Integer.valueOf(state), Integer.valueOf(partnerCfgid), Integer.valueOf(bestPartnerCfgid), Long.valueOf(exploreStartTime), Integer.valueOf(costMinutes), Long.valueOf(exploreEndTime), Integer.valueOf(exploreNum) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onFailed(int retcode)
/*     */   {
/* 251 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 256 */     if (retcode < 0)
/*     */     {
/* 258 */       SSendCatToExploreFailed resp = new SSendCatToExploreFailed();
/* 259 */       resp.retcode = retcode;
/* 260 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 263 */     StringBuffer logBuilder = new StringBuffer();
/* 264 */     logBuilder.append("[cat]PCSendCatToExplore.onFailed@send cat to explore failed");
/* 265 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 266 */     logBuilder.append('|').append("catid=").append(this.catid);
/* 267 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 269 */     if (extraParams != null)
/*     */     {
/* 271 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 273 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 277 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\PCSendCatToExplore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */