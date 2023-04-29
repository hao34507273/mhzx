/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg;
/*    */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoMapToKeyCfg;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.JiuXiaoBean;
/*    */ import xbean.JiuXiaoFloorBean;
/*    */ import xtable.Role2jiuxiao;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JiuXiaoInterface
/*    */ {
/*    */   public static void setJiuXiaoRankDataForIDIP(long roleid, int layer, int timeSec, int rankType)
/*    */   {
/* 23 */     JiuXiaoChart jiuXiaoChart = JiuXiaoRankManager.getInstance().getJiuXiaoChart(rankType);
/* 24 */     if (jiuXiaoChart != null) {
/* 25 */       jiuXiaoChart.setLayerAndRank(roleid, layer, timeSec);
/*    */     } else {
/* 27 */       GameServer.logger().error(String.format("[JiuXiao]JiuXiaoInterface.setJiuXiaoRankDataForIDIP@IDIP ranktype error|ranktype=%d", new Object[] { Integer.valueOf(rankType) }));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getCurJiuXiaoLayer(String userid, long roleid, boolean retainLock)
/*    */   {
/* 43 */     JiuXiaoBean xjiuXiaoBean = null;
/* 44 */     if (retainLock) {
/* 45 */       xjiuXiaoBean = Role2jiuxiao.get(Long.valueOf(roleid));
/*    */     } else {
/* 47 */       xjiuXiaoBean = Role2jiuxiao.select(Long.valueOf(roleid));
/*    */     }
/* 49 */     if (xjiuXiaoBean == null) {
/* 50 */       return -1;
/*    */     }
/* 52 */     Set<Integer> activityids = new HashSet();
/* 53 */     for (Iterator i$ = SJueZhanJiuXiaoMapToKeyCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityid = ((Integer)i$.next()).intValue();
/* 54 */       if (ActivityInterface.canJoinActivityToday(userid, roleid, activityid)) {
/* 55 */         activityids.add(Integer.valueOf(activityid));
/*    */       }
/*    */     }
/* 58 */     int maxLayer = -1;
/* 59 */     for (Map.Entry<Integer, JiuXiaoFloorBean> xjiuXiaoFloorEntry : xjiuXiaoBean.getFloormap().entrySet()) {
/* 60 */       JiuXiaoFloorBean xJiuXiaoFloorBean = (JiuXiaoFloorBean)xjiuXiaoFloorEntry.getValue();
/* 61 */       if (xJiuXiaoFloorBean.getIsawarded() == 1) {
/* 62 */         int jiuxiaoCfgid = ((Integer)xjiuXiaoFloorEntry.getKey()).intValue();
/* 63 */         SJueZhanJiuXiaoCfg jueZhanJiuXiaoCfg = SJueZhanJiuXiaoCfg.get(jiuxiaoCfgid);
/* 64 */         if ((activityids.contains(Integer.valueOf(jueZhanJiuXiaoCfg.activityid))) && 
/* 65 */           (jueZhanJiuXiaoCfg.floor > maxLayer)) {
/* 66 */           maxLayer = jueZhanJiuXiaoCfg.floor;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 71 */     return maxLayer;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\JiuXiaoInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */