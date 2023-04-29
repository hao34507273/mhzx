/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.own.PGM_restartRoundRobinRound;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_restartround
/*    */   extends CmdBase
/*    */ {
/*    */   private int activity_cfg_id;
/*    */   private int round_index;
/*    */   private int restart_level;
/*    */   private String timestamp;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 21 */     if (this.m_arguments == null) {
/* 22 */       return false;
/*    */     }
/* 24 */     int index = 0;
/*    */     
/* 26 */     if (index >= this.m_arguments.size()) {
/* 27 */       return false;
/*    */     }
/* 29 */     Integer I_activity_cfg_id = parseInt((String)this.m_arguments.get(index++));
/* 30 */     if (I_activity_cfg_id == null) {
/* 31 */       return false;
/*    */     }
/* 33 */     this.activity_cfg_id = I_activity_cfg_id.intValue();
/*    */     
/* 35 */     if (index >= this.m_arguments.size()) {
/* 36 */       return false;
/*    */     }
/* 38 */     Integer I_round_index = parseInt((String)this.m_arguments.get(index++));
/* 39 */     if (I_round_index == null) {
/* 40 */       return false;
/*    */     }
/* 42 */     this.round_index = I_round_index.intValue();
/*    */     
/* 44 */     if (index >= this.m_arguments.size()) {
/* 45 */       return false;
/*    */     }
/* 47 */     Integer I_restart_level = parseInt((String)this.m_arguments.get(index++));
/* 48 */     if (I_restart_level == null) {
/* 49 */       return false;
/*    */     }
/* 51 */     this.restart_level = I_restart_level.intValue();
/*    */     
/* 53 */     if (index >= this.m_arguments.size()) {
/* 54 */       return false;
/*    */     }
/* 56 */     this.timestamp = ((String)this.m_arguments.get(index++));
/* 57 */     if (index != this.m_arguments.size()) {
/* 58 */       return false;
/*    */     }
/* 60 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 68 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 74 */     new PGM_restartRoundRobinRound(this.m_gmRole.getRoleid(), this.activity_cfg_id, this.round_index, this.restart_level, this.timestamp).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_restartround.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */