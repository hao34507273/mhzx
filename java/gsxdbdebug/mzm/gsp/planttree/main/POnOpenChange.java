/*    */ package mzm.gsp.planttree.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*    */ import mzm.gsp.planttree.confbean.SPlantTreeModuleidCfg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnOpenChange extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     if (!PlantTreeManager.postInitFlag)
/*    */     {
/* 21 */       return false;
/*    */     }
/* 23 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     boolean isOpen = ((OpenChangeComplexArg)this.arg).isOpen();
/* 29 */     int type = ((OpenChangeComplexArg)this.arg).getType();
/* 30 */     if (!SPlantTreeModuleidCfg.getAll().containsKey(Integer.valueOf(type)))
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     int activityCfgid = SPlantTreeModuleidCfg.get(type).activity_cfg_id;
/* 35 */     SPlantTreeCfg cfg = SPlantTreeCfg.get(activityCfgid);
/* 36 */     if (cfg == null)
/*    */     {
/* 38 */       return false;
/*    */     }
/* 40 */     if (isOpen)
/*    */     {
/* 42 */       if (!ActivityInterface.isActivityOpen(activityCfgid))
/*    */       {
/* 44 */         return false;
/*    */       }
/* 46 */       for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 48 */         PlantTreeOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PInitActivity(roleid, activityCfgid));
/*    */       }
/*    */       
/*    */ 
/* 52 */       StringBuilder sb = new StringBuilder();
/* 53 */       sb.append(String.format("[planttree]POnOpenChange.processImp@plant tree activity start|activity_cfg_id=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*    */       
/* 55 */       PlantTreeManager.logger.info(sb.toString());
/*    */     }
/*    */     else
/*    */     {
/* 59 */       if (!ActivityInterface.isActivityOpen(activityCfgid))
/*    */       {
/* 61 */         return false;
/*    */       }
/* 63 */       for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 65 */         PlantTreeOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PStopActivity(roleid, activityCfgid));
/*    */       }
/*    */       
/*    */ 
/* 69 */       StringBuilder sb = new StringBuilder();
/* 70 */       sb.append(String.format("[planttree]POnOpenChange.processImp@plant tree activity end|activity_cfg_id=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*    */       
/* 72 */       PlantTreeManager.logger.info(sb.toString());
/*    */     }
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */