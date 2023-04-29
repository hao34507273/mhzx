/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.chat.question.PGM_NoticeAll;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setquestionid
/*    */   extends CmdBase
/*    */ {
/*    */   private int questionId;
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
/* 28 */     Integer I_questionId = parseInt((String)this.m_arguments.get(index++));
/* 29 */     if (I_questionId == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     this.questionId = I_questionId.intValue();
/*    */     
/* 34 */     if (index != this.m_arguments.size()) {
/* 35 */       return false;
/*    */     }
/* 37 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 52 */     Procedure.execute(new PGM_NoticeAll(this.questionId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setquestionid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */