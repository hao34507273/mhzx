/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.point.RGM_SetPointRacePromotion;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setpointracepromotion
/*    */   extends CmdBase
/*    */ {
/*    */   private int activityCfgid;
/*    */   private int size;
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
/* 27 */     Integer I_activityCfgid = parseInt((String)this.m_arguments.get(index++));
/* 28 */     if (I_activityCfgid == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     this.activityCfgid = I_activityCfgid.intValue();
/*    */     
/* 33 */     if (index >= this.m_arguments.size()) {
/* 34 */       return false;
/*    */     }
/* 36 */     Integer I_size = parseInt((String)this.m_arguments.get(index++));
/* 37 */     if (I_size == null) {
/* 38 */       return false;
/*    */     }
/* 40 */     this.size = I_size.intValue();
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
/* 61 */     new RGM_SetPointRacePromotion(this.m_gmRole.getRoleid(), this.activityCfgid, this.size).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setpointracepromotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */