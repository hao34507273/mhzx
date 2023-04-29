/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg;
/*    */ import mzm.gsp.jiuxiao.SUpdateLayerDataRes;
/*    */ import mzm.gsp.npc.event.GetNpcBuffArg;
/*    */ import xbean.JiuXiaoCacheBean;
/*    */ import xbean.JiuXiaoFloorCacheBean;
/*    */ 
/*    */ public class POnGetNpcBuffEvent extends mzm.gsp.npc.event.GetNpcBuffEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     int npcid = ((GetNpcBuffArg)this.arg).npcId;
/* 14 */     long leaderid = ((Long)((GetNpcBuffArg)this.arg).roleIds.get(0)).longValue();
/* 15 */     long worldid = mzm.gsp.map.main.MapInterface.getRoleWorldInstanceId(leaderid);
/* 16 */     int mapCfgid = mzm.gsp.map.main.MapInterface.getRoleMapId(leaderid);
/* 17 */     JiuXiaoCacheBean xSelectJiuXiaoCacheBean = xtable.Role2jiuxiaocache.select(Long.valueOf(leaderid));
/* 18 */     if (xSelectJiuXiaoCacheBean == null) {
/* 19 */       return false;
/*    */     }
/* 21 */     int activityid = xSelectJiuXiaoCacheBean.getJiuxiaoactivityid();
/* 22 */     SJueZhanJiuXiaoCfg jueZhanJiuXiaoCfg; int index; java.util.Iterator i$; if (JiuXiaoCfgManager.isJiuXiaoMap(activityid, mapCfgid))
/*    */     {
/* 24 */       jueZhanJiuXiaoCfg = JiuXiaoCfgManager.getJueZhanJiuXiaoByMapId(activityid, mapCfgid);
/* 25 */       if (jueZhanJiuXiaoCfg == null) {
/* 26 */         return false;
/*    */       }
/* 28 */       index = jueZhanJiuXiaoCfg.npcids.indexOf(Integer.valueOf(npcid));
/* 29 */       if (index < 0) {
/* 30 */         return false;
/*    */       }
/*    */       
/* 33 */       xbean.JiuXiaoActivityBean xJiuXiaoActivityBean = xtable.Jiuxiaotable.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/*    */       
/* 35 */       if (xJiuXiaoActivityBean == null) {
/* 36 */         return false;
/*    */       }
/* 38 */       xbean.JiuXiaoActivityInfo xJiuXiaoActivityInfo = (xbean.JiuXiaoActivityInfo)xJiuXiaoActivityBean.getActivityinfomap().get(Integer.valueOf(activityid));
/* 39 */       if (xJiuXiaoActivityInfo == null) {
/* 40 */         return false;
/*    */       }
/* 42 */       if (worldid != xJiuXiaoActivityInfo.getWorldid()) {
/* 43 */         return false;
/*    */       }
/*    */       
/* 46 */       lock(xtable.Role2jiuxiaocache.getTable(), ((GetNpcBuffArg)this.arg).roleIds);
/* 47 */       for (i$ = ((GetNpcBuffArg)this.arg).roleIds.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 49 */         xbean.JiuXiaoBean xjiuXiaoBean = xtable.Role2jiuxiao.get(Long.valueOf(roleid));
/* 50 */         xbean.JiuXiaoFloorBean xjiuXiaoFloorBean = (xbean.JiuXiaoFloorBean)xjiuXiaoBean.getFloormap().get(Integer.valueOf(jueZhanJiuXiaoCfg.id));
/* 51 */         JiuXiaoCacheBean xJiuXiaoCacheBean = xtable.Role2jiuxiaocache.get(Long.valueOf(roleid));
/* 52 */         JiuXiaoFloorCacheBean xJiuXiaoFloorCacheBean = (JiuXiaoFloorCacheBean)xJiuXiaoCacheBean.getFloorcachemap().get(Integer.valueOf(jueZhanJiuXiaoCfg.id));
/*    */         
/*    */ 
/* 55 */         if (xJiuXiaoFloorCacheBean != null)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 60 */           if (!xJiuXiaoFloorCacheBean.getProcesses().contains(Integer.valueOf(index))) {
/* 61 */             xJiuXiaoFloorCacheBean.getProcesses().add(Integer.valueOf(index));
/*    */             
/* 63 */             SUpdateLayerDataRes updateLayerDataRes = new SUpdateLayerDataRes();
/* 64 */             JiuXiaoManager.fillInJiuXiaoMapDataBean(updateLayerDataRes.mapdatabean, xjiuXiaoFloorBean, xJiuXiaoFloorCacheBean, jueZhanJiuXiaoCfg.id);
/*    */             
/* 66 */             mzm.gsp.online.main.OnlineManager.getInstance().send(roleid, updateLayerDataRes);
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     else {
/* 72 */       return false;
/*    */     }
/*    */     
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\POnGetNpcBuffEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */