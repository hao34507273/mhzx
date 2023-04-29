/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg;
/*    */ import mzm.gsp.jiuxiao.SUpdateLayerDataRes;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.JiuXiaoActivityInfo;
/*    */ import xbean.JiuXiaoBean;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     long roleid = ((Long)this.arg).longValue();
/* 19 */     if ((!OpenInterface.getOpenStatus(13)) || (OpenInterface.isBanPlay(roleid, 13)))
/*    */     {
/* 21 */       mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleid, 19);
/* 22 */       return true;
/*    */     }
/*    */     
/* 25 */     int activityid = JiuXiaoManager.getRoleActivityid(roleid, true);
/* 26 */     if ((activityid > 0) && (mzm.gsp.activity.main.ActivityInterface.isActivityOpen(activityid)))
/*    */     {
/*    */ 
/* 29 */       xbean.JiuXiaoActivityBean xJiuXiaoActivityBean = xtable.Jiuxiaotable.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/*    */       
/* 31 */       if (xJiuXiaoActivityBean == null) {
/* 32 */         return true;
/*    */       }
/* 34 */       JiuXiaoActivityInfo xJiuXiaoActivityInfo = (JiuXiaoActivityInfo)xJiuXiaoActivityBean.getActivityinfomap().get(Integer.valueOf(activityid));
/* 35 */       if (xJiuXiaoActivityInfo == null) {
/* 36 */         return true;
/*    */       }
/* 38 */       long worldid = MapInterface.getRoleWorldInstanceId(((Long)this.arg).longValue());
/* 39 */       if (worldid == xJiuXiaoActivityInfo.getWorldid()) {
/* 40 */         xbean.JiuXiaoCacheBean xJiuXiaoCacheBean = xtable.Role2jiuxiaocache.get((Long)this.arg);
/* 41 */         if (xJiuXiaoCacheBean == null) {
/* 42 */           return true;
/*    */         }
/* 44 */         int mapCfgid = MapInterface.getRoleMapId(((Long)this.arg).longValue());
/* 45 */         SJueZhanJiuXiaoCfg jueZhanJiuXiaoCfg = JiuXiaoCfgManager.getJueZhanJiuXiaoByMapId(activityid, mapCfgid);
/* 46 */         if (jueZhanJiuXiaoCfg == null)
/*    */         {
/* 48 */           return true;
/*    */         }
/* 50 */         xbean.JiuXiaoFloorCacheBean xJiuXiaoFloorCacheBean = (xbean.JiuXiaoFloorCacheBean)xJiuXiaoCacheBean.getFloorcachemap().get(Integer.valueOf(jueZhanJiuXiaoCfg.id));
/*    */         
/* 52 */         if (xJiuXiaoFloorCacheBean == null) {
/* 53 */           GameServer.logger().error(String.format("[JiuXiao]POnRoleLogin.processImp@do not exist jiuxiao floor cache data|activityid=%d|mapcfgid=%d|roleid=%d", new Object[] { Integer.valueOf(activityid), Integer.valueOf(mapCfgid), Long.valueOf(roleid) }));
/*    */           
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 60 */           return false;
/*    */         }
/* 62 */         JiuXiaoBean xJiuXiaoBean = xtable.Role2jiuxiao.get((Long)this.arg);
/* 63 */         if (xJiuXiaoBean == null) {
/* 64 */           GameServer.logger().error(String.format("[JiuXiao]POnRoleLogin.processImp@do not exist jiuxiao bean data|activityid=%d|mapcfgid=%d|roleid=%d", new Object[] { Integer.valueOf(activityid), Integer.valueOf(mapCfgid), Long.valueOf(roleid) }));
/*    */           
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 71 */           return false;
/*    */         }
/* 73 */         xbean.JiuXiaoFloorBean xJiuXiaoFloorBean = (xbean.JiuXiaoFloorBean)xJiuXiaoBean.getFloormap().get(Integer.valueOf(jueZhanJiuXiaoCfg.id));
/* 74 */         if (xJiuXiaoFloorBean == null) {
/* 75 */           GameServer.logger().error(String.format("[JiuXiao]POnRoleLogin.processImp@do not exist jiuxiao floor bean data|activityid=%d|mapcfgid=%d|roleid=%d", new Object[] { Integer.valueOf(activityid), Integer.valueOf(mapCfgid), Long.valueOf(roleid) }));
/*    */           
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 82 */           return false;
/*    */         }
/* 84 */         SUpdateLayerDataRes updateLayerDataRes = new SUpdateLayerDataRes();
/* 85 */         JiuXiaoManager.fillInJiuXiaoMapDataBean(updateLayerDataRes.mapdatabean, xJiuXiaoFloorBean, xJiuXiaoFloorCacheBean, jueZhanJiuXiaoCfg.id);
/*    */         
/* 87 */         OnlineManager.getInstance().send(((Long)this.arg).longValue(), updateLayerDataRes);
/* 88 */         return true;
/*    */       }
/*    */     } else {
/* 91 */       mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleid, 19);
/* 92 */       return true;
/*    */     }
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */