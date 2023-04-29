/*     */ package mzm.gsp.jiuxiao.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.jiuxiao.event.JoinJiuXiaoArg;
/*     */ import mzm.gsp.map.event.MapTransferArg;
/*     */ import xbean.JiuXiaoActivityInfo;
/*     */ import xbean.JiuXiaoBean;
/*     */ import xbean.JiuXiaoCacheBean;
/*     */ import xtable.Role2jiuxiao;
/*     */ import xtable.Role2jiuxiaocache;
/*     */ 
/*     */ public class POnTransferScene extends mzm.gsp.map.event.PlayerTransferSceneProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  21 */     long oldWorldid = ((MapTransferArg)this.arg).oldWorldId;
/*  22 */     long newWorldid = ((MapTransferArg)this.arg).newWorldId;
/*  23 */     int oldMapCfgid = ((MapTransferArg)this.arg).oldMapCfgId;
/*  24 */     int newMapCfgid = ((MapTransferArg)this.arg).newMapCfgId;
/*  25 */     xbean.JiuXiaoActivityBean xJiuXiaoActivityBean = xtable.Jiuxiaotable.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/*  26 */     if (xJiuXiaoActivityBean == null) {
/*  27 */       return false;
/*     */     }
/*  29 */     long leaderid = ((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue();
/*  30 */     int activityid = JiuXiaoManager.getRoleActivityid(leaderid, false);
/*  31 */     JiuXiaoActivityInfo xJiuXiaoActivityInfo = (JiuXiaoActivityInfo)xJiuXiaoActivityBean.getActivityinfomap().get(Integer.valueOf(activityid));
/*  32 */     if (xJiuXiaoActivityInfo == null) {
/*  33 */       return false;
/*     */     }
/*  35 */     long jiuxiaoWorld = xJiuXiaoActivityInfo.getWorldid();
/*     */     
/*  37 */     Map<Long, String> role2user = new java.util.HashMap();
/*  38 */     for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long tmpRoleid = ((Long)i$.next()).longValue();
/*  39 */       role2user.put(Long.valueOf(tmpRoleid), mzm.gsp.role.main.RoleInterface.getUserId(tmpRoleid));
/*     */     }
/*  41 */     lock(xtable.User.getTable(), role2user.values());
/*  42 */     lock(Role2jiuxiao.getTable(), ((MapTransferArg)this.arg).roleList);
/*     */     
/*  44 */     if ((oldWorldid == jiuxiaoWorld) && (newWorldid == jiuxiaoWorld)) {
/*  45 */       for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/*  47 */         JiuXiaoCacheBean xJiuXiaoCacheBean = Role2jiuxiaocache.get(Long.valueOf(roleid));
/*  48 */         JiuXiaoBean xJiuXiaoBean = Role2jiuxiao.get(Long.valueOf(roleid));
/*     */         
/*     */ 
/*  51 */         JiuXiaoManager.clearOldCacheFloor(roleid, activityid, oldMapCfgid, xJiuXiaoCacheBean, xJiuXiaoBean);
/*     */         
/*     */ 
/*  54 */         JiuXiaoManager.initNewFloor(roleid, activityid, newMapCfgid, xJiuXiaoCacheBean, xJiuXiaoBean);
/*     */       }
/*     */       
/*  57 */       SJueZhanJiuXiaoCfg newJueZhanJiuXiaoCfg = JiuXiaoCfgManager.getJueZhanJiuXiaoByMapId(activityid, newMapCfgid);
/*     */       
/*  59 */       int floor = 0;
/*  60 */       if (newJueZhanJiuXiaoCfg != null) {
/*  61 */         floor = newJueZhanJiuXiaoCfg.floor;
/*     */       }
/*  63 */       long endTime = ActivityInterface.getActivityEndTime(activityid);
/*  64 */       JoinJiuXiaoArg joinJiuXiaoArg = new JoinJiuXiaoArg(((MapTransferArg)this.arg).roleList, endTime, activityid, floor);
/*  65 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.jiuxiao.event.JoinJiuXiaoEvent(), joinJiuXiaoArg);
/*     */     }
/*  67 */     else if ((oldWorldid == jiuxiaoWorld) && (newWorldid != jiuxiaoWorld)) {
/*  68 */       for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/*  70 */         JiuXiaoCacheBean xJiuXiaoCacheBean = Role2jiuxiaocache.get(Long.valueOf(roleid));
/*  71 */         JiuXiaoBean xJiuXiaoBean = Role2jiuxiao.get(Long.valueOf(roleid));
/*  72 */         JiuXiaoManager.clearOldCacheFloor(roleid, activityid, oldMapCfgid, xJiuXiaoCacheBean, xJiuXiaoBean);
/*     */       }
/*     */       
/*  75 */       mzm.gsp.status.main.RoleStatusInterface.unsetStatus(((MapTransferArg)this.arg).roleList, 19);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*  82 */     else if ((oldWorldid != jiuxiaoWorld) && (newWorldid == jiuxiaoWorld)) {
/*  83 */       for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/*  85 */         JiuXiaoCacheBean xJiuXiaoCacheBean = Role2jiuxiaocache.get(Long.valueOf(roleid));
/*  86 */         if (xJiuXiaoCacheBean == null) {
/*  87 */           xJiuXiaoCacheBean = xbean.Pod.newJiuXiaoCacheBean();
/*  88 */           Role2jiuxiaocache.insert(Long.valueOf(roleid), xJiuXiaoCacheBean);
/*     */         }
/*     */         
/*  91 */         JiuXiaoBean xJiuXiaoBean = Role2jiuxiao.get(Long.valueOf(roleid));
/*  92 */         if (xJiuXiaoBean == null) {
/*  93 */           xJiuXiaoBean = xbean.Pod.newJiuXiaoBean();
/*  94 */           Role2jiuxiao.insert(Long.valueOf(roleid), xJiuXiaoBean);
/*     */         }
/*     */         
/*  97 */         JiuXiaoManager.initNewFloor(roleid, activityid, newMapCfgid, xJiuXiaoCacheBean, xJiuXiaoBean);
/*     */       }
/*  99 */       ActivityInterface.canJoinAndCheckInitActivityData(role2user, ((MapTransferArg)this.arg).roleList, activityid);
/* 100 */       long endTime = ActivityInterface.getActivityEndTime(activityid);
/*     */       
/* 102 */       SJueZhanJiuXiaoCfg newJueZhanJiuXiaoCfg = JiuXiaoCfgManager.getJueZhanJiuXiaoByMapId(activityid, newMapCfgid);
/*     */       
/* 104 */       int floor = 0;
/* 105 */       if (newJueZhanJiuXiaoCfg != null) {
/* 106 */         floor = newJueZhanJiuXiaoCfg.floor;
/*     */       }
/* 108 */       JoinJiuXiaoArg joinJiuXiaoArg = new JoinJiuXiaoArg(((MapTransferArg)this.arg).roleList, endTime, activityid, floor);
/* 109 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.jiuxiao.event.JoinJiuXiaoEvent(), joinJiuXiaoArg);
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */