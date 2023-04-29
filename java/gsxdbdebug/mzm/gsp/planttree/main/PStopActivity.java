/*    */ package mzm.gsp.planttree.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.PlantTreeInfo;
/*    */ import xbean.RolePlantTreeInfo;
/*    */ import xtable.Role_plant_tree_infos;
/*    */ 
/*    */ public class PStopActivity
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PStopActivity(long roleid, int activityCfgid)
/*    */   {
/* 20 */     this.roleid = roleid;
/* 21 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     OnlineRewardPointObserverManager.getInstance().stopObserver(this.roleid, this.activityCfgid);
/* 28 */     RolePlantTreeInfo xRolePlantTreeInfo = Role_plant_tree_infos.get(Long.valueOf(this.roleid));
/* 29 */     if (xRolePlantTreeInfo == null)
/*    */     {
/* 31 */       onFail(-4, null);
/* 32 */       return false;
/*    */     }
/* 34 */     PlantTreeInfo xPlantTreeInfo = (PlantTreeInfo)xRolePlantTreeInfo.getPlant_tree_infos().get(Integer.valueOf(this.activityCfgid));
/* 35 */     if (xPlantTreeInfo == null)
/*    */     {
/* 37 */       onFail(-4, null);
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if ((xPlantTreeInfo.getSpecial_state_refresh_sessionid() > 0L) && (Session.getSession(xPlantTreeInfo.getSpecial_state_refresh_sessionid()) != null) && ((Session.getSession(xPlantTreeInfo.getSpecial_state_refresh_sessionid()) instanceof SpecialStateRefreshSession)))
/*    */     {
/*    */ 
/*    */ 
/* 45 */       Session.removeSession(xPlantTreeInfo.getSpecial_state_refresh_sessionid(), this.roleid);
/*    */     }
/* 47 */     xPlantTreeInfo.setSpecial_state_refresh_sessionid(-1L);
/*    */     
/* 49 */     StringBuilder sb = new StringBuilder();
/* 50 */     sb.append(String.format("[planttree]PStopActivity.processImp@stop activity success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*    */     
/* 52 */     PlantTreeManager.logger.info(sb.toString());
/* 53 */     return true;
/*    */   }
/*    */   
/*    */   private void onFail(int res, Map<String, Object> extraInfo)
/*    */   {
/* 58 */     if (PlantTreeManager.logger.isDebugEnabled())
/*    */     {
/* 60 */       StringBuilder sb = new StringBuilder();
/* 61 */       sb.append(String.format("[planttree]PStopActivity.processImp@stop activity fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*    */       
/*    */ 
/* 64 */       if (extraInfo != null)
/*    */       {
/* 66 */         for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*    */         {
/* 68 */           sb.append("|").append((String)entry.getKey());
/* 69 */           sb.append("=").append(entry.getValue().toString());
/*    */         }
/*    */       }
/* 72 */       PlantTreeManager.logger.debug(sb.toString());
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\PStopActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */