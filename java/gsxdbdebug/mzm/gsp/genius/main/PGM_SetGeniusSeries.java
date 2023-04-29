/*    */ package mzm.gsp.genius.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.genius.SGetGeninusSeriesSuccess;
/*    */ import mzm.gsp.genius.confbean.SGeniusConst;
/*    */ import mzm.gsp.genius.confbean.SGeniusSeriesCfg;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.GeniusSeries;
/*    */ 
/*    */ public class PGM_SetGeniusSeries extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int geniusSeriesCfgid;
/*    */   
/*    */   public PGM_SetGeniusSeries(long gmRoleid, long roleid, int geniusSeriesCfgid)
/*    */   {
/* 22 */     this.gmRoleid = gmRoleid;
/* 23 */     this.roleid = roleid;
/* 24 */     this.geniusSeriesCfgid = geniusSeriesCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     int level = RoleInterface.getLevel(this.roleid);
/* 31 */     if (level < SGeniusConst.getInstance().OPEN_LEVEL)
/*    */     {
/* 33 */       notifyClient(String.format("等级%d开启", new Object[] { Integer.valueOf(SGeniusConst.getInstance().OPEN_LEVEL) }));
/* 34 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 38 */     int ocpid = RoleInterface.getOccupationId(this.roleid);
/* 39 */     SGeniusSeriesCfg geniusSeriesCfg = SGeniusSeriesCfg.get(ocpid);
/* 40 */     if (geniusSeriesCfg == null)
/*    */     {
/* 42 */       notifyClient("当前门派未配置天赋系");
/* 43 */       return false;
/*    */     }
/* 45 */     if (geniusSeriesCfg.series.get(Integer.valueOf(this.geniusSeriesCfgid)) == null)
/*    */     {
/* 47 */       notifyClient("天赋系配置不存在");
/* 48 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 52 */     GeniusSeries xGeniusSeries = GeniusManager.getAndInitGeniusSeries(this.roleid, ocpid);
/* 53 */     xGeniusSeries.setCur_series(this.geniusSeriesCfgid);
/*    */     
/*    */ 
/* 56 */     SGetGeninusSeriesSuccess rsp = new SGetGeninusSeriesSuccess();
/* 57 */     fillRsp(rsp, xGeniusSeries);
/* 58 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*    */     
/* 60 */     notifyClient("设置成功");
/* 61 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 66 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 67 */     messagetip.result = Integer.MAX_VALUE;
/* 68 */     messagetip.args.add(str);
/* 69 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */   
/*    */   private void fillRsp(SGetGeninusSeriesSuccess rsp, GeniusSeries xGeniusSeries)
/*    */   {
/* 74 */     rsp.cur_series = xGeniusSeries.getCur_series();
/* 75 */     for (Map.Entry<Integer, xbean.GeniusSeriesInfo> xEntry : xGeniusSeries.getSeries().entrySet())
/*    */     {
/* 77 */       int geniusSeriesCfgid = ((Integer)xEntry.getKey()).intValue();
/* 78 */       xbean.GeniusSeriesInfo xGeniusSeriesInfo = (xbean.GeniusSeriesInfo)xEntry.getValue();
/*    */       
/* 80 */       mzm.gsp.genius.GeniusSeriesInfo geniusSeriesInfo = new mzm.gsp.genius.GeniusSeriesInfo();
/* 81 */       geniusSeriesInfo.genius_skills.putAll(xGeniusSeriesInfo.getGenius_skills());
/*    */       
/* 83 */       rsp.series.put(Integer.valueOf(geniusSeriesCfgid), geniusSeriesInfo);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\main\PGM_SetGeniusSeries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */