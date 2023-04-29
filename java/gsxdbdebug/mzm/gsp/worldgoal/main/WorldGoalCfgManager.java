/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*    */ import mzm.gsp.worldgoal.confbean.SectionInfo;
/*    */ import xbean.WorldGoal;
/*    */ import xtable.Worldgoals;
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
/*    */ public class WorldGoalCfgManager
/*    */ {
/*    */   static int getCfgid(int activityCfgid, int sectionid, int point)
/*    */   {
/* 29 */     return ((Integer)((SectionInfo)SWorldGoalCfg.get(activityCfgid).section_infos.get(Integer.valueOf(sectionid))).trigger_points.floorEntry(Integer.valueOf(point)).getValue()).intValue();
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
/*    */   static Set<Integer> getAlreadyCompleteSectionid(int activityCfgid, int currentSectionid, int currentSectionPoint)
/*    */   {
/* 43 */     SWorldGoalCfg cfg = SWorldGoalCfg.get(activityCfgid);
/* 44 */     Set<Integer> sectionids = new HashSet();
/* 45 */     for (int i = 1; i < currentSectionid; i++)
/*    */     {
/* 47 */       sectionids.add(Integer.valueOf(i));
/*    */     }
/* 49 */     if (((SectionInfo)cfg.section_infos.get(Integer.valueOf(currentSectionid))).section_total_point == currentSectionPoint)
/*    */     {
/* 51 */       sectionids.add(Integer.valueOf(currentSectionid));
/* 52 */       if (currentSectionid == cfg.section_num)
/*    */       {
/* 54 */         sectionids.add(Integer.valueOf(cfg.section_num + 1));
/*    */       }
/*    */     }
/* 57 */     return sectionids;
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
/*    */   static boolean isRoleInWorldGoalActivityMap(long roleid, int activityCfgid)
/*    */   {
/* 70 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 71 */     WorldGoal xWorldGoal = Worldgoals.get(Long.valueOf(globalActivityCfgid));
/* 72 */     if (xWorldGoal == null)
/*    */     {
/* 74 */       return false;
/*    */     }
/* 76 */     if (MapInterface.getRoleWorldInstanceId(roleid) != xWorldGoal.getWorld_id())
/*    */     {
/* 78 */       return false;
/*    */     }
/* 80 */     SWorldGoalCfg cfg = SWorldGoalCfg.get(activityCfgid);
/* 81 */     if (cfg == null)
/*    */     {
/* 83 */       return false;
/*    */     }
/* 85 */     for (SectionInfo sectionInfo : cfg.section_infos.values())
/*    */     {
/* 87 */       if (sectionInfo.map_cfg_id == MapInterface.getRoleMapId(roleid))
/*    */       {
/* 89 */         return true;
/*    */       }
/*    */     }
/* 92 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\WorldGoalCfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */