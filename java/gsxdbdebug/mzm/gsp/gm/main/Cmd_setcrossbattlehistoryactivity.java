/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.knockout.PGM_SetCrossBattleHistoryActivity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setcrossbattlehistoryactivity
/*    */   extends CmdBase
/*    */ {
/*    */   private int session;
/*    */   private int activityCfgId;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 19 */     if (this.m_arguments == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     int index = 0;
/*    */     
/* 24 */     if (index >= this.m_arguments.size()) {
/* 25 */       return false;
/*    */     }
/* 27 */     Integer I_session = parseInt((String)this.m_arguments.get(index++));
/* 28 */     if (I_session == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     this.session = I_session.intValue();
/*    */     
/* 33 */     if (index >= this.m_arguments.size()) {
/* 34 */       return false;
/*    */     }
/* 36 */     Integer I_activityCfgId = parseInt((String)this.m_arguments.get(index++));
/* 37 */     if (I_activityCfgId == null) {
/* 38 */       return false;
/*    */     }
/* 40 */     this.activityCfgId = I_activityCfgId.intValue();
/*    */     
/* 42 */     if (index != this.m_arguments.size()) {
/* 43 */       return false;
/*    */     }
/* 45 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 54 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 61 */     new PGM_SetCrossBattleHistoryActivity(this.m_gmRole.getRoleid(), this.session, this.activityCfgId).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setcrossbattlehistoryactivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */