/*     */ package mzm.gsp.jiuxiao.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SJiuXiaoActivityInfoCfg;
/*     */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg;
/*     */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoConsts;
/*     */ import mzm.gsp.jiuxiao.SJiuXiaoNormalResult;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.JiuXiaoActivityBean;
/*     */ import xbean.JiuXiaoActivityInfo;
/*     */ import xbean.JiuXiaoBean;
/*     */ import xbean.JiuXiaoCacheBean;
/*     */ import xbean.JiuXiaoFloorBean;
/*     */ import xbean.JiuXiaoFloorCacheBean;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2jiuxiaocache;
/*     */ 
/*     */ class JiuXiaoManager
/*     */ {
/*     */   static void fillInJiuXiaoMapDataBean(mzm.gsp.jiuxiao.JiuXiaoMapDataBean xJiuXiaoMapDataBean, JiuXiaoFloorBean xJiuXiaoFloorBean, JiuXiaoFloorCacheBean xJiuXiaoFloorCacheBean, int floorCfgid)
/*     */   {
/*  29 */     xJiuXiaoMapDataBean.awarded = xJiuXiaoFloorBean.getIsawarded();
/*  30 */     xJiuXiaoMapDataBean.cfgid = floorCfgid;
/*  31 */     xJiuXiaoMapDataBean.processes.addAll(xJiuXiaoFloorCacheBean.getProcesses());
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
/*     */ 
/*     */   static boolean activityStart(int activityid, JiuXiaoActivityBean xActivityBean)
/*     */   {
/*  52 */     long wordldid = MapInterface.createWorld(JiuXiaoCfgManager.getJiuXiaoAllMapidsByActivityid(activityid));
/*  53 */     JiuXiaoActivityInfo xJiuXiaoActivityInfo = (JiuXiaoActivityInfo)xActivityBean.getActivityinfomap().get(Integer.valueOf(activityid));
/*  54 */     if (xJiuXiaoActivityInfo == null) {
/*  55 */       xJiuXiaoActivityInfo = Pod.newJiuXiaoActivityInfo();
/*  56 */       xActivityBean.getActivityinfomap().put(Integer.valueOf(activityid), xJiuXiaoActivityInfo);
/*     */     }
/*  58 */     xJiuXiaoActivityInfo.setWorldid(wordldid);
/*     */     
/*  60 */     new JiuXiaoAwardObserver(SJueZhanJiuXiaoConsts.getInstance().awardTimeInterval, wordldid, activityid);
/*     */     
/*  62 */     SJiuXiaoActivityInfoCfg jiuXiaoActivityInfoCfg = SJiuXiaoActivityInfoCfg.get(activityid);
/*     */     
/*  64 */     mzm.gsp.map.main.ControllerInterface.triggerController(jiuXiaoActivityInfoCfg.controller);
/*     */     
/*     */ 
/*  67 */     mzm.gsp.team.main.TeamInterface.registerJoinTeam(wordldid, new JoinTeamCheck(activityid));
/*  68 */     mzm.gsp.team.main.TeamInterface.registerActivityTeam(wordldid, new JiuXiaoActivityTeamHandler(activityid));
/*     */     
/*  70 */     GameServer.logger().info("九霄活动已经正式开始了,worldid:" + wordldid);
/*  71 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean activityEnd(int activityid, JiuXiaoActivityBean xActivityBean)
/*     */   {
/*  80 */     if (xActivityBean == null) {
/*  81 */       return true;
/*     */     }
/*  83 */     JiuXiaoActivityInfo xJiuXiaoActivityInfo = (JiuXiaoActivityInfo)xActivityBean.getActivityinfomap().remove(Integer.valueOf(activityid));
/*  84 */     if (xJiuXiaoActivityInfo == null) {
/*  85 */       return true;
/*     */     }
/*  87 */     long worldid = xJiuXiaoActivityInfo.getWorldid();
/*  88 */     List<Long> allRoleList = MapInterface.getRoleList(worldid);
/*  89 */     for (Iterator i$ = allRoleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*  91 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception
/*     */         {
/*  95 */           mzm.gsp.status.main.RoleStatusInterface.unsetStatus(this.val$roleid, 19);
/*  96 */           MapInterface.forceTransferToScene(this.val$roleid, SJueZhanJiuXiaoConsts.getInstance().outMapid);
/*  97 */           return true;
/*     */         }
/*     */       });
/*     */     }
/*     */     
/* 102 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception {
/* 105 */         MapInterface.destroyWorld(this.val$worldid);
/* 106 */         return true;
/*     */       }
/* 108 */     });
/* 109 */     mzm.gsp.team.main.TeamInterface.unRegisterJoinTeam(worldid);
/* 110 */     SJiuXiaoActivityInfoCfg jiuXiaoActivityInfoCfg = SJiuXiaoActivityInfoCfg.get(activityid);
/* 111 */     mzm.gsp.map.main.ControllerInterface.collectController(jiuXiaoActivityInfoCfg.controller);
/* 112 */     GameServer.logger().info("九霄活动已经结束,worldid:" + worldid);
/* 113 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/* 117 */         JiuXiaoRankManager.getInstance().saveToDB();
/* 118 */         return true;
/*     */       }
/* 120 */     });
/* 121 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void clearOldCacheFloor(long roleid, int activityid, int oldMapCfgid, JiuXiaoCacheBean xJiuXiaoCacheBean, JiuXiaoBean xJiuXiaoBean)
/*     */   {
/* 133 */     SJueZhanJiuXiaoCfg jueZhanJiuXiaoCfg = JiuXiaoCfgManager.getJueZhanJiuXiaoByMapId(activityid, oldMapCfgid);
/* 134 */     if (jueZhanJiuXiaoCfg == null) {
/* 135 */       if (GameServer.logger().isDebugEnabled()) {
/* 136 */         GameServer.logger().debug("玩家从等待大厅中进入九霄活动,mapCfgid:" + oldMapCfgid);
/*     */       }
/*     */     }
/*     */     else {
/* 140 */       JiuXiaoFloorCacheBean xJiuXiaoFloorCacheBean = (JiuXiaoFloorCacheBean)xJiuXiaoCacheBean.getFloorcachemap().get(Integer.valueOf(jueZhanJiuXiaoCfg.id));
/*     */       
/* 142 */       JiuXiaoFloorBean xJiuXiaoFloorBean = (JiuXiaoFloorBean)xJiuXiaoBean.getFloormap().get(Integer.valueOf(jueZhanJiuXiaoCfg.id));
/* 143 */       if (xJiuXiaoFloorBean == null) {
/* 144 */         xJiuXiaoFloorBean = Pod.newJiuXiaoFloorBean();
/*     */       }
/* 146 */       if ((xJiuXiaoFloorCacheBean != null) && (xJiuXiaoFloorCacheBean.getProcesses().size() > 0)) {
/* 147 */         xJiuXiaoFloorCacheBean.getProcesses().clear();
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void initNewFloor(long roleid, int activityid, int newMapCfgid, JiuXiaoCacheBean xJiuXiaoCacheBean, JiuXiaoBean xJiuXiaoBean)
/*     */   {
/* 169 */     SJueZhanJiuXiaoCfg newJueZhanJiuXiaoCfg = JiuXiaoCfgManager.getJueZhanJiuXiaoByMapId(activityid, newMapCfgid);
/* 170 */     if (newJueZhanJiuXiaoCfg != null)
/*     */     {
/* 172 */       JiuXiaoFloorBean xJiuXiaoFloorBean = (JiuXiaoFloorBean)xJiuXiaoBean.getFloormap().get(Integer.valueOf(newJueZhanJiuXiaoCfg.id));
/* 173 */       if (xJiuXiaoFloorBean == null) {
/* 174 */         xJiuXiaoFloorBean = Pod.newJiuXiaoFloorBean();
/* 175 */         xJiuXiaoBean.getFloormap().put(Integer.valueOf(newJueZhanJiuXiaoCfg.id), xJiuXiaoFloorBean);
/*     */       }
/*     */       
/* 178 */       JiuXiaoFloorCacheBean xJiuXiaoFloorCacheBean = (JiuXiaoFloorCacheBean)xJiuXiaoCacheBean.getFloorcachemap().get(Integer.valueOf(newJueZhanJiuXiaoCfg.id));
/*     */       
/* 180 */       if (xJiuXiaoFloorCacheBean == null) {
/* 181 */         xJiuXiaoFloorCacheBean = Pod.newJiuXiaoFloorCacheBean();
/* 182 */         xJiuXiaoCacheBean.getFloorcachemap().put(Integer.valueOf(newJueZhanJiuXiaoCfg.id), xJiuXiaoFloorCacheBean);
/*     */       }
/* 184 */       mzm.gsp.jiuxiao.SUpdateLayerDataRes sUpdateLayerDataRes = new mzm.gsp.jiuxiao.SUpdateLayerDataRes();
/* 185 */       fillInJiuXiaoMapDataBean(sUpdateLayerDataRes.mapdatabean, xJiuXiaoFloorBean, xJiuXiaoFloorCacheBean, newJueZhanJiuXiaoCfg.id);
/*     */       
/* 187 */       OnlineManager.getInstance().send(roleid, sUpdateLayerDataRes);
/*     */       
/* 189 */       mzm.gsp.activity.main.ActivityInterface.logActivity(roleid, activityid, mzm.gsp.activity.main.ActivityLogStatus.ATTEND);
/* 190 */       mzm.gsp.activity.main.ActivityInterface.tlogActivity(roleid, activityid, mzm.gsp.activity.main.ActivityLogStatus.ATTEND);
/*     */     }
/*     */   }
/*     */   
/*     */   static void sendNormalRet(long roleid, int ret, String... args) {
/* 195 */     SJiuXiaoNormalResult sJiuXiaoNormalResult = new SJiuXiaoNormalResult();
/* 196 */     sJiuXiaoNormalResult.result = ret;
/* 197 */     for (String arg : args) {
/* 198 */       sJiuXiaoNormalResult.args.add(arg);
/*     */     }
/* 200 */     OnlineManager.getInstance().sendAtOnce(roleid, sJiuXiaoNormalResult);
/*     */   }
/*     */   
/*     */   static void finishFloor(SJueZhanJiuXiaoCfg jueZhanJiuXiaoCfg, List<Long> roleids) {
/* 204 */     if (jueZhanJiuXiaoCfg != null) {
/* 205 */       SJiuXiaoNormalResult jiuXiaoNormalResult = new SJiuXiaoNormalResult();
/* 206 */       jiuXiaoNormalResult.result = 4;
/* 207 */       OnlineManager.getInstance().sendMulti(jiuXiaoNormalResult, roleids);
/* 208 */       delayTransfor(jueZhanJiuXiaoCfg.mapid, roleids, jueZhanJiuXiaoCfg.activityid);
/*     */     } else {
/* 210 */       SJiuXiaoNormalResult jiuXiaoNormalResult = new SJiuXiaoNormalResult();
/* 211 */       jiuXiaoNormalResult.result = 5;
/* 212 */       OnlineManager.getInstance().sendMulti(jiuXiaoNormalResult, roleids);
/* 213 */       delayTransfor(SJueZhanJiuXiaoConsts.getInstance().outMapid, roleids, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   static void delayTransfor(int mapid, java.util.Collection<Long> roleids, int activityid)
/*     */   {
/* 219 */     new DelayTranforSession(SJueZhanJiuXiaoConsts.getInstance().delayTranforTime, mapid, roleids, activityid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void rankRole(SJueZhanJiuXiaoCfg jueZhanJiuXiaoCfg, int sec, List<Long> roleids)
/*     */   {
/* 229 */     final List<JiuXiaoRankObj> jiuXiaoRankRoles = new java.util.ArrayList();
/* 230 */     int layer = jueZhanJiuXiaoCfg.floor;
/* 231 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 232 */       JiuXiaoRankObj jiuXiaoRankRole = new JiuXiaoRankObj(roleid, layer, sec);
/* 233 */       jiuXiaoRankRoles.add(jiuXiaoRankRole);
/*     */     }
/* 235 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/* 239 */         SJiuXiaoActivityInfoCfg jiuXiaoActivityInfoCfg = SJiuXiaoActivityInfoCfg.get(this.val$jueZhanJiuXiaoCfg.activityid);
/*     */         
/* 241 */         JiuXiaoChart jiuXiaoChart = JiuXiaoRankManager.getInstance().getJiuXiaoChart(jiuXiaoActivityInfoCfg.rankType);
/*     */         
/* 243 */         if (jiuXiaoChart == null) {
/* 244 */           GameServer.logger().error(String.format("[JiuXiao]JiuXiaoManager.rankRole@do not exist jiuxiao rank|rankType=%d", new Object[] { Integer.valueOf(jiuXiaoActivityInfoCfg.rankType) }));
/*     */           
/*     */ 
/* 247 */           return false;
/*     */         }
/* 249 */         for (JiuXiaoRankObj jiuXiaoRankRole : jiuXiaoRankRoles) {
/* 250 */           JiuXiaoRankObj jiuXiaoRankRole2 = (JiuXiaoRankObj)jiuXiaoChart.getObjByKey(jiuXiaoRankRole.getKey());
/* 251 */           if (jiuXiaoRankRole2 == null) {
/* 252 */             jiuXiaoChart.rank(jiuXiaoRankRole);
/* 253 */           } else if (jiuXiaoRankRole.isTopThan(jiuXiaoRankRole2)) {
/* 254 */             jiuXiaoChart.rank(jiuXiaoRankRole);
/*     */           }
/*     */         }
/*     */         
/* 258 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void setJiuxiaoActivityid(long roleId, int activityid)
/*     */   {
/* 269 */     JiuXiaoCacheBean xJiuXiaoCacheBean = Role2jiuxiaocache.get(Long.valueOf(roleId));
/* 270 */     if (xJiuXiaoCacheBean == null) {
/* 271 */       xJiuXiaoCacheBean = Pod.newJiuXiaoCacheBean();
/* 272 */       Role2jiuxiaocache.insert(Long.valueOf(roleId), xJiuXiaoCacheBean);
/*     */     }
/* 274 */     xJiuXiaoCacheBean.setJiuxiaoactivityid(activityid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getRoleActivityid(long roleid, boolean retainLock)
/*     */   {
/* 285 */     JiuXiaoCacheBean xJiuXiaoCacheBean = null;
/* 286 */     if (retainLock) {
/* 287 */       xJiuXiaoCacheBean = Role2jiuxiaocache.get(Long.valueOf(roleid));
/*     */     } else {
/* 289 */       xJiuXiaoCacheBean = Role2jiuxiaocache.select(Long.valueOf(roleid));
/*     */     }
/* 291 */     if (xJiuXiaoCacheBean == null) {
/* 292 */       return -1;
/*     */     }
/* 294 */     return xJiuXiaoCacheBean.getJiuxiaoactivityid();
/*     */   }
/*     */   
/*     */   static boolean checkInCross(long roleid) {
/* 298 */     if (mzm.gsp.status.main.RoleStatusInterface.containsStatus(roleid, 41)) {
/* 299 */       return true;
/*     */     }
/* 301 */     if (mzm.gsp.status.main.RoleStatusInterface.containsStatus(roleid, 44)) {
/* 302 */       return true;
/*     */     }
/* 304 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\JiuXiaoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */