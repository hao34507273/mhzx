/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleJingjiChartInterface
/*    */ {
/*    */   static int getRank(long roleid)
/*    */   {
/* 19 */     return JingJiRankManager.getInstance().getRank(Long.valueOf(roleid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int getRankSize()
/*    */   {
/* 30 */     return JingJiRankManager.getInstance().size();
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
/*    */   static List<Long> getRankData(int from, int to)
/*    */   {
/* 43 */     List<Long> result = new ArrayList();
/* 44 */     Collection<RoleJingjiChart> reCharts = JingJiRankManager.getInstance().getRankObjs(from, to);
/* 45 */     for (RoleJingjiChart r : reCharts)
/*    */     {
/* 47 */       result.add(r.getKey());
/*    */     }
/* 49 */     return result;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void rank(long roleid, int winpoint)
/*    */   {
/* 61 */     RoleJingjiChart roleJingjiChart = new RoleJingjiChart(roleid, winpoint);
/* 62 */     JingJiRankManager.getInstance().rank(roleJingjiChart);
/*    */   }
/*    */   
/*    */ 
/*    */   static int getCapacity()
/*    */   {
/* 68 */     return JingJiRankManager.getInstance().getCapacity();
/*    */   }
/*    */   
/*    */ 
/*    */   static void clear()
/*    */   {
/* 74 */     new ClearJingjiChart(null).execute();
/*    */   }
/*    */   
/*    */   private static class ClearJingjiChart
/*    */     extends LogicProcedure
/*    */   {
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 83 */       JingJiRankManager.getInstance().clear();
/* 84 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\RoleJingjiChartInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */