/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.PGMClearRoleActivity;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*    */ import mzm.gsp.instance.confbean.SOperaInstanceCfg;
/*    */ import xtable.Role2instance;
/*    */ 
/*    */ public class PGMSetInstanceProcess extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gm_Roleid;
/*    */   private final long roleid;
/*    */   private final int instanceid;
/*    */   private final int process;
/*    */   
/*    */   public PGMSetInstanceProcess(long gm_Roleid, long roleid, int instanceid, int process)
/*    */   {
/* 18 */     this.gm_Roleid = gm_Roleid;
/* 19 */     this.roleid = roleid;
/* 20 */     this.instanceid = instanceid;
/* 21 */     this.process = process;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     SInstanceCfg instanceCfg = SInstanceCfg.get(this.instanceid);
/* 27 */     if (instanceCfg == null) {
/* 28 */       return false;
/*    */     }
/* 30 */     if (instanceCfg.instanceType == 2) {
/* 31 */       SOperaInstanceCfg operaInstanceCfg = InstanceCfgManager.getOperaInstanceCfg(this.instanceid);
/* 32 */       xdb.Procedure.execute(new PGMClearRoleActivity(this.gm_Roleid, this.roleid, operaInstanceCfg.activityid));
/*    */     }
/*    */     
/* 35 */     xbean.InstanceBean xInstanceBean = Role2instance.get(Long.valueOf(this.roleid));
/* 36 */     if (instanceCfg.instanceType == 2) {
/* 37 */       TeamInstance.setProcess(this.roleid, this.instanceid, this.process, xInstanceBean);
/* 38 */     } else if (instanceCfg.instanceType == 1) {
/* 39 */       SingleInstance.setProcess(this.roleid, this.instanceid, this.process, xInstanceBean);
/*    */     }
/* 41 */     GmManager.getInstance().sendResultToGM(this.gm_Roleid, String.format("set instance process success|roleid=%d|instanceid=%d|process=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.instanceid), Integer.valueOf(this.process) }));
/*    */     
/*    */ 
/*    */ 
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\PGMSetInstanceProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */