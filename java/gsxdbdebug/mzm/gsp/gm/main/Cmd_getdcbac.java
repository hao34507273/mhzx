/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.drawcarnival.main.PGM_GetActivityBigAwardCount;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_getdcbac
/*    */   extends CmdBase
/*    */ {
/*    */   private int activityId;
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
/* 26 */     Integer I_activityId = parseInt((String)this.m_arguments.get(index++));
/* 27 */     if (I_activityId == null) {
/* 28 */       return false;
/*    */     }
/* 30 */     this.activityId = I_activityId.intValue();
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
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 50 */     new PGM_GetActivityBigAwardCount(this.m_gmRole.getRoleid(), this.activityId).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_getdcbac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */