/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.birthdaypray.main.PGM_setbirthdaypray;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setbirthdaypray
/*    */   extends CmdBase
/*    */ {
/*    */   private int activityId;
/*    */   private int taskActivityId;
/*    */   private int changeTimes;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 20 */     if (this.m_arguments == null) {
/* 21 */       return false;
/*    */     }
/* 23 */     int index = 0;
/*    */     
/* 25 */     if (index >= this.m_arguments.size()) {
/* 26 */       return false;
/*    */     }
/* 28 */     Integer I_activityId = parseInt((String)this.m_arguments.get(index++));
/* 29 */     if (I_activityId == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     this.activityId = I_activityId.intValue();
/*    */     
/* 34 */     if (index >= this.m_arguments.size()) {
/* 35 */       return false;
/*    */     }
/* 37 */     Integer I_taskActivityId = parseInt((String)this.m_arguments.get(index++));
/* 38 */     if (I_taskActivityId == null) {
/* 39 */       return false;
/*    */     }
/* 41 */     this.taskActivityId = I_taskActivityId.intValue();
/*    */     
/* 43 */     if (index >= this.m_arguments.size()) {
/* 44 */       return false;
/*    */     }
/* 46 */     Integer I_changeTimes = parseInt((String)this.m_arguments.get(index++));
/* 47 */     if (I_changeTimes == null) {
/* 48 */       return false;
/*    */     }
/* 50 */     this.changeTimes = I_changeTimes.intValue();
/*    */     
/* 52 */     if (index != this.m_arguments.size()) {
/* 53 */       return false;
/*    */     }
/* 55 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 64 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 71 */     new PGM_setbirthdaypray(this.activityId, this.taskActivityId, this.changeTimes).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setbirthdaypray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */