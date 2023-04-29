/*    */ package mzm.gsp.feisheng.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.feisheng.confbean.SFeiShengCfg;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ 
/*    */ 
/*    */ public class POnRoleLevelUp
/*    */   extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 18 */       return false;
/*    */     }
/* 20 */     long roleid = ((RoleLevelUpArg)this.arg).roleId;
/* 21 */     int newLevel = ((RoleLevelUpArg)this.arg).newLevel;
/* 22 */     for (SFeiShengCfg cfg : SFeiShengCfg.getAll().values())
/*    */     {
/* 24 */       if (newLevel == cfg.level)
/*    */       {
/* 26 */         FeiShengOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(cfg.activity_cfg_id), new PActiveTaskGraph(roleid, cfg.activity_cfg_id));
/*    */       }
/*    */     }
/*    */     
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */