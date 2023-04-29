/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_getextrarate extends CmdBase
/*    */ {
/*    */   private int activityId;
/*  8 */   private int typeId = -1;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 34 */       return true;
/*    */     }
/* 36 */     Integer I_typeId = parseInt((String)this.m_arguments.get(index++));
/* 37 */     if (I_typeId == null) {
/* 38 */       return false;
/*    */     }
/* 40 */     this.typeId = I_typeId.intValue();
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
/*    */   protected void run()
/*    */   {
/* 60 */     new mzm.gsp.drawcarnival.main.PGM_GetExtraRate(this.m_gmRole.getRoleid(), this.activityId, this.typeId).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_getextrarate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */