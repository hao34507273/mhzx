/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RGM_GetCrossBattleCurrentActivityCfgid
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleid;
/*    */   
/*    */   public RGM_GetCrossBattleCurrentActivityCfgid(long gmRoleid)
/*    */   {
/* 17 */     this.gmRoleid = gmRoleid;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 23 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("跨服战当前活动配置ID=%d", new Object[] { Integer.valueOf(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\RGM_GetCrossBattleCurrentActivityCfgid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */