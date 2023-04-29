/*    */ package mzm.gsp;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.GameServerInfo;
/*    */ import xdb.Xdb;
/*    */ import xdb.util.UniqNameConf;
/*    */ 
/*    */ class PGetServerZoneids extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     List<Long> zoneids = new ArrayList();
/* 16 */     List<Long> localids = new ArrayList();
/* 17 */     UniqNameConf uniqNameConf = Xdb.getInstance().getConf().getUniqNameConf();
/* 18 */     for (Integer id : uniqNameConf.getLocalIds())
/*    */     {
/* 20 */       localids.add(Long.valueOf(id.longValue()));
/*    */     }
/* 22 */     long localid = uniqNameConf.getLocalId();
/* 23 */     GameServerInfo xGameServerInfo = xtable.Gamesrv.get(Long.valueOf(localid));
/* 24 */     List<String> xZoneids = xGameServerInfo.getZoneids();
/* 25 */     int len = xZoneids.size();
/* 26 */     for (int i = 0; i < len; i++)
/*    */     {
/* 28 */       zoneids.add(Long.valueOf((String)xZoneids.get(i)));
/*    */     }
/* 30 */     long zoneid = ((Long)zoneids.get(0)).longValue();
/*    */     
/*    */ 
/*    */ 
/* 34 */     Set<Long> tmpZoneids = new java.util.HashSet(zoneids);
/* 35 */     if (tmpZoneids.size() != zoneids.size())
/*    */     {
/* 37 */       GetServerZoneids.logger().fatal(String.format("[merge]PGetServerZoneids.processImp@zoneid duplicate|tmp_zoneids=%s|zoneids=%s", new Object[] { tmpZoneids, zoneids }));
/*    */       
/*    */ 
/* 40 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 45 */     if (zoneid != localid)
/*    */     {
/* 47 */       GetServerZoneids.logger().fatal(String.format("[merge]PGetServerZoneids.processImp@zoneid and localid not match|zoneid=%d|localid=%d", new Object[] { Long.valueOf(zoneid), Long.valueOf(localid) }));
/*    */       
/*    */ 
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     GetServerZoneids.logger().info(String.format("[merge]PGetServerZoneids.processImp@dump zoneids|zoneid=%d|localid=%d|zoneids=%s", new Object[] { Long.valueOf(zoneid), Long.valueOf(localid), zoneids }));
/*    */     
/*    */ 
/*    */ 
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\PGetServerZoneids.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */