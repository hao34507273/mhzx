/*    */ package mzm.gsp.genius.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.genius.SGetGeninusSeriesSuccess;
/*    */ import mzm.gsp.genius.confbean.SGeniusConst;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.GeniusSeries;
/*    */ 
/*    */ public class PCGetGeniusSeries extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCGetGeniusSeries(long roleid)
/*    */   {
/* 20 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!GeniusManager.canDoAction(this.roleid, 1071, false))
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     if (!GeniusManager.isFunOpen(this.roleid))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     int level = RoleInterface.getLevel(this.roleid);
/* 37 */     if (level < SGeniusConst.getInstance().OPEN_LEVEL)
/*    */     {
/* 39 */       GameServer.logger().error(String.format("[genius]PCGetGeniusSeries.processImp@level limit|roleid=%d|level=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(level) }));
/*    */       
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     int ocpid = RoleInterface.getOccupationId(this.roleid);
/*    */     
/* 46 */     GeniusSeries xGeniusSeries = GeniusManager.getAndInitGeniusSeries(this.roleid, ocpid);
/*    */     
/* 48 */     SGetGeninusSeriesSuccess rsp = new SGetGeninusSeriesSuccess();
/* 49 */     fillRsp(rsp, xGeniusSeries);
/* 50 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*    */     
/* 52 */     GameServer.logger().info(String.format("[genius]PCGetGeniusSeries.processImp@get success|roleid=%d|ocpid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(ocpid) }));
/*    */     
/* 54 */     return true;
/*    */   }
/*    */   
/*    */   private void fillRsp(SGetGeninusSeriesSuccess rsp, GeniusSeries xGeniusSeries)
/*    */   {
/* 59 */     rsp.cur_series = xGeniusSeries.getCur_series();
/*    */     
/* 61 */     for (Map.Entry<Integer, xbean.GeniusSeriesInfo> xEntry : xGeniusSeries.getSeries().entrySet())
/*    */     {
/* 63 */       int geniusSeriesCfgid = ((Integer)xEntry.getKey()).intValue();
/* 64 */       xbean.GeniusSeriesInfo xGeniusSeriesInfo = (xbean.GeniusSeriesInfo)xEntry.getValue();
/*    */       
/* 66 */       mzm.gsp.genius.GeniusSeriesInfo geniusSeriesInfo = new mzm.gsp.genius.GeniusSeriesInfo();
/* 67 */       geniusSeriesInfo.genius_skills.putAll(xGeniusSeriesInfo.getGenius_skills());
/*    */       
/* 69 */       rsp.series.put(Integer.valueOf(geniusSeriesCfgid), geniusSeriesInfo);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\main\PCGetGeniusSeries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */