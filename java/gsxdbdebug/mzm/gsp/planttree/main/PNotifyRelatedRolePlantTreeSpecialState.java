/*    */ package mzm.gsp.planttree.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.planttree.SGetRelatedRolePlantTreeSpecialStateSuccess;
/*    */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*    */ import xbean.PlantTreeInfo;
/*    */ import xbean.RolePlantTreeInfo;
/*    */ 
/*    */ public class PNotifyRelatedRolePlantTreeSpecialState extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PNotifyRelatedRolePlantTreeSpecialState(long roleid, int activityCfgid)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     SPlantTreeCfg cfg = SPlantTreeCfg.get(this.activityCfgid);
/* 27 */     if (cfg == null)
/*    */     {
/*    */ 
/* 30 */       return false;
/*    */     }
/* 32 */     SGetRelatedRolePlantTreeSpecialStateSuccess protocol = new SGetRelatedRolePlantTreeSpecialStateSuccess();
/* 33 */     protocol.activity_cfg_id = this.activityCfgid;
/* 34 */     for (Iterator i$ = PlantTreeManager.getRelatedRoleids(cfg.activity_type, this.roleid).iterator(); i$.hasNext();) { long relatedRoleid = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 37 */       RolePlantTreeInfo xRolePlantTreeInfo = xtable.Role_plant_tree_infos.select(Long.valueOf(relatedRoleid));
/* 38 */       if (xRolePlantTreeInfo != null)
/*    */       {
/*    */ 
/*    */ 
/* 42 */         PlantTreeInfo xPlantTreeInfo = (PlantTreeInfo)xRolePlantTreeInfo.getPlant_tree_infos().get(Integer.valueOf(this.activityCfgid));
/* 43 */         if (xPlantTreeInfo != null)
/*    */         {
/*    */ 
/*    */ 
/* 47 */           protocol.special_states.put(Long.valueOf(relatedRoleid), Integer.valueOf(xPlantTreeInfo.getSpecial_state_index())); }
/*    */       } }
/* 49 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*    */     
/* 51 */     StringBuilder sb = new StringBuilder();
/* 52 */     sb.append(String.format("[planttree]PNotifyRelatedRolePlantTreeSpecialState.processImp@get related role special state success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*    */     
/*    */ 
/* 55 */     PlantTreeManager.logger.info(sb.toString());
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\PNotifyRelatedRolePlantTreeSpecialState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */