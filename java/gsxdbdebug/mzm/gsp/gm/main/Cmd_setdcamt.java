/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.drawcarnival.main.PGM_SetActivityAmt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setdcamt
/*    */   extends CmdBase
/*    */ {
/*    */   private int activityId;
/*    */   private long count;
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
/* 27 */     Integer I_activityId = parseInt((String)this.m_arguments.get(index++));
/* 28 */     if (I_activityId == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     this.activityId = I_activityId.intValue();
/*    */     
/* 33 */     if (index >= this.m_arguments.size()) {
/* 34 */       return false;
/*    */     }
/* 36 */     Long L_count = parseLong((String)this.m_arguments.get(index++));
/* 37 */     if (L_count == null)
/* 38 */       return false;
/* 39 */     this.count = L_count.longValue();
/*    */     
/* 41 */     if (index != this.m_arguments.size()) {
/* 42 */       return false;
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 53 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 59 */     new PGM_SetActivityAmt(this.m_gmRole.getRoleid(), this.activityId, this.count).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setdcamt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */