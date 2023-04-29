/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.util.List;
/*    */ import mzm.gsp.menpaistar.MenPaiStarChampionInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MenPaiStarChartManager
/*    */ {
/* 15 */   static final MenPaiStarChart chart = new MenPaiStarChart(100, 100);
/*    */   
/*    */ 
/*    */ 
/*    */   static void init() {}
/*    */   
/*    */ 
/*    */   static MenPaiStarChartObj getChartObj(int ocpid)
/*    */   {
/* 24 */     return (MenPaiStarChartObj)chart.getObjByKey(Integer.valueOf(ocpid));
/*    */   }
/*    */   
/*    */   static List<MenPaiStarChartObj> getAll()
/*    */   {
/* 29 */     return chart.getAllChartObjs();
/*    */   }
/*    */   
/*    */   static void rank(MenPaiStarChartObj chartObj)
/*    */   {
/* 34 */     int ocpid = chartObj.getOcpid();
/* 35 */     chart.delete(Integer.valueOf(ocpid));
/* 36 */     chart.rank(chartObj);
/*    */   }
/*    */   
/*    */   static void delete(int ocpid)
/*    */   {
/* 41 */     chart.delete(Integer.valueOf(ocpid));
/*    */   }
/*    */   
/*    */   static MenPaiStarChampionInfo trans(MenPaiStarChartObj chartObj)
/*    */   {
/* 46 */     MenPaiStarChampionInfo info = new MenPaiStarChampionInfo();
/* 47 */     info.occupationid = chartObj.getOcpid();
/* 48 */     info.point = chartObj.getPoint();
/* 49 */     info.roleid = chartObj.getRoleid();
/*    */     try
/*    */     {
/* 52 */       info.role_name.setString(chartObj.getName(), "UTF-8");
/*    */     }
/*    */     catch (UnsupportedEncodingException e) {}
/*    */     
/*    */ 
/* 57 */     return info;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\MenPaiStarChartManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */