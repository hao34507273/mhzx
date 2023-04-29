/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGoalMapEntityInstanceManager
/*    */ {
/*    */   static long getInstanceid(int activityCfgid, int sectionid)
/*    */   {
/* 26 */     return CommonUtils.getLong(activityCfgid, sectionid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static Set<Long> getInstanceids(int activityCfgid)
/*    */   {
/* 37 */     Set<Long> instanceids = new HashSet();
/* 38 */     SWorldGoalCfg cfg = SWorldGoalCfg.get(activityCfgid);
/* 39 */     for (int i = 1; i <= cfg.section_num; i++)
/*    */     {
/* 41 */       instanceids.add(Long.valueOf(CommonUtils.getLong(activityCfgid, i)));
/*    */     }
/* 43 */     return instanceids;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int getActivityCfgidByInstanceid(long instanceid)
/*    */   {
/* 54 */     return CommonUtils.getLongHigh(instanceid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int getSectionidByInstanceid(long instanceid)
/*    */   {
/* 65 */     return CommonUtils.getLongLow(instanceid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\WorldGoalMapEntityInstanceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */