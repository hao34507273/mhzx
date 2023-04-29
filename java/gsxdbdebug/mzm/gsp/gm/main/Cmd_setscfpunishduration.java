/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossfield.main.RGM_SetSingleCrossFieldActiveLeavePunishDuration;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setscfpunishduration
/*    */   extends CmdBase
/*    */ {
/*    */   private int duration;
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
/* 26 */     Integer I_duration = parseInt((String)this.m_arguments.get(index++));
/* 27 */     if (I_duration == null) {
/* 28 */       return false;
/*    */     }
/* 30 */     this.duration = I_duration.intValue();
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
/* 49 */     new RGM_SetSingleCrossFieldActiveLeavePunishDuration(this.m_gmRole.getRoleid(), this.duration).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setscfpunishduration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */