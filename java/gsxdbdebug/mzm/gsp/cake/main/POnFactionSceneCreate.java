/*    */ package mzm.gsp.cake.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity4.confbean.SCakeActivityCfg;
/*    */ import mzm.gsp.cake.event.FactionSceneCreateArg;
/*    */ import mzm.gsp.cake.event.FactionSceneCreateProcedure;
/*    */ 
/*    */ public class POnFactionSceneCreate extends FactionSceneCreateProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     for (SCakeActivityCfg cfg : SCakeActivityCfg.getAll().values())
/*    */     {
/* 15 */       int activityId = cfg.activityId;
/* 16 */       if ((ActivityInterface.isActivityOpen(activityId)) && 
/*    */       
/*    */ 
/*    */ 
/* 20 */         (mzm.gsp.open.main.OpenInterface.getOpenStatus(cfg.switchId)))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 25 */         CakeManager.triggerFactionOvens(activityId, ((FactionSceneCreateArg)this.arg).getFactionId()); }
/*    */     }
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\POnFactionSceneCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */