/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import mzm.gsp.worldgoal.SSyncSectionComplete;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*    */ import mzm.gsp.worldgoal.confbean.SectionInfo;
/*    */ import mzm.gsp.worldgoal.event.SectionPonitChangeArg;
/*    */ import mzm.gsp.worldgoal.event.SectionPonitChangeProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnSectionPonitChange
/*    */   extends SectionPonitChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     int activityCfgid = ((SectionPonitChangeArg)this.arg).getActivityCfgid();
/* 24 */     int sectionid = ((SectionPonitChangeArg)this.arg).getSectionid();
/* 25 */     int point = ((SectionPonitChangeArg)this.arg).getPoint();
/* 26 */     long timestamp = ((SectionPonitChangeArg)this.arg).getTimestamp();
/* 27 */     SWorldGoalCfg cfg = SWorldGoalCfg.get(activityCfgid);
/* 28 */     if (WorldGoalManager.logger.isDebugEnabled())
/*    */     {
/* 30 */       WorldGoalManager.logger.debug(String.format("[worldgoal]POnSectionPonitChange.processImp@section point change|activity_cfg_id=%d|sectionid=%d|point=%d|timestamp=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(sectionid), Integer.valueOf(point), Long.valueOf(timestamp) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 36 */     Map<Integer, Integer> replaceIntExtraInfoEntries = new HashMap();
/* 37 */     replaceIntExtraInfoEntries.put(Integer.valueOf(400), Integer.valueOf(point));
/* 38 */     replaceIntExtraInfoEntries.put(Integer.valueOf(401), Integer.valueOf((int)(timestamp / 1000L)));
/* 39 */     MapInterface.changeMapEntityInfos(MapEntityType.MGT_WORLD_GOAL_INFO, WorldGoalMapEntityInstanceManager.getInstanceid(activityCfgid, sectionid), WorldGoalCfgManager.getCfgid(activityCfgid, sectionid, point), replaceIntExtraInfoEntries, null, null, null, null);
/*    */     
/*    */     Iterator i$;
/*    */     
/* 43 */     if (point == ((SectionInfo)cfg.section_infos.get(Integer.valueOf(sectionid))).section_total_point)
/*    */     {
/* 45 */       WorldGoalManager.logger.info(String.format("[worldgoal]POnSectionPonitChange.processImp@section complete|activity_cfg_id=%d|sectionid=%d|point=%d|timestamp=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(sectionid), Integer.valueOf(point), Long.valueOf(timestamp) }));
/*    */       
/*    */ 
/*    */ 
/* 49 */       for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 51 */         RoleOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(roleid), new PSendAwardMail(roleid, activityCfgid, sectionid));
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 56 */       SSyncSectionComplete protocol = new SSyncSectionComplete();
/* 57 */       protocol.activity_cfg_id = activityCfgid;
/* 58 */       protocol.section_id = sectionid;
/* 59 */       OnlineManager.getInstance().sendAll(protocol);
/*    */       
/*    */ 
/* 62 */       if (sectionid == cfg.section_num)
/*    */       {
/* 64 */         WorldGoalManager.logger.info(String.format("[worldgoal]POnSectionPonitChange.processImp@activity complete|activity_cfg_id=%d|sectionid=%d|point=%d|timestamp=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(sectionid), Integer.valueOf(point), Long.valueOf(timestamp) }));
/*    */         
/*    */ 
/*    */ 
/* 68 */         for (i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */           
/* 70 */           RoleOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(roleid), new PSendAwardMail(roleid, activityCfgid, cfg.section_num + 1));
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\POnSectionPonitChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */