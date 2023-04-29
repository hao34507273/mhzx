/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.JiuXiaoActivityInfo;
/*    */ import xbean.JiuXiaoCacheBean;
/*    */ 
/*    */ public class PGM_EnterJiuXiaoMap extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int floor;
/*    */   
/*    */   public PGM_EnterJiuXiaoMap(long roleid, int floor)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.floor = floor;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     xbean.JiuXiaoActivityBean xJiuXiaoActivityBean = xtable.Jiuxiaotable.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 22 */     if (xJiuXiaoActivityBean == null) {
/* 23 */       if (GameServer.logger().isDebugEnabled())
/* 24 */         GameServer.logger().debug("九霄活动已经结束了！！");
/* 25 */       return false;
/*    */     }
/* 27 */     JiuXiaoCacheBean xJiuXiaoCacheBean = xtable.Role2jiuxiaocache.get(Long.valueOf(this.roleid));
/* 28 */     if (xJiuXiaoCacheBean == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     int activityid = xJiuXiaoCacheBean.getJiuxiaoactivityid();
/* 32 */     mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg jueZhanJiuXiaoCfg = JiuXiaoCfgManager.getJiuXiaoCfg(activityid, this.floor);
/* 33 */     if (jueZhanJiuXiaoCfg == null) {
/* 34 */       if (GameServer.logger().isDebugEnabled())
/* 35 */         GameServer.logger().debug("第一层数据不存在");
/* 36 */       return false;
/*    */     }
/* 38 */     JiuXiaoActivityInfo xJiuXiaoActivityInfo = (JiuXiaoActivityInfo)xJiuXiaoActivityBean.getActivityinfomap().get(Integer.valueOf(activityid));
/* 39 */     if (xJiuXiaoActivityInfo == null) {
/* 40 */       if (GameServer.logger().isDebugEnabled())
/* 41 */         GameServer.logger().debug("九霄活动已经结束了！！");
/* 42 */       return false;
/*    */     }
/* 44 */     mzm.gsp.map.main.MapInterface.transferToScene(this.roleid, xJiuXiaoActivityInfo.getWorldid(), jueZhanJiuXiaoCfg.mapid);
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\PGM_EnterJiuXiaoMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */