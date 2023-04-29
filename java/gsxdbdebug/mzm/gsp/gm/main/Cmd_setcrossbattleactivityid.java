/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.own.RGM_SetCrossBattleCurrentActivityCfgid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setcrossbattleactivityid
/*    */   extends CmdBase
/*    */ {
/*    */   private int activity_cfg_id;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 18 */     if (this.m_arguments == null) {
/* 19 */       return false;
/*    */     }
/* 21 */     int index = 0;
/*    */     
/* 23 */     if (index >= this.m_arguments.size()) {
/* 24 */       return false;
/*    */     }
/* 26 */     Integer I_activity_cfg_id = parseInt((String)this.m_arguments.get(index++));
/* 27 */     if (I_activity_cfg_id == null) {
/* 28 */       return false;
/*    */     }
/* 30 */     this.activity_cfg_id = I_activity_cfg_id.intValue();
/*    */     
/* 32 */     if (index != this.m_arguments.size()) {
/* 33 */       return false;
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 49 */     new RGM_SetCrossBattleCurrentActivityCfgid(this.m_gmRole.getRoleid(), this.activity_cfg_id).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setcrossbattleactivityid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */