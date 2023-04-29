/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_selectionmatchstart
/*    */   extends CmdBase
/*    */ {
/*    */   private int selectionStage;
/*    */   private int fightIndexId;
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
/* 28 */     Integer I_selectionStage = parseInt((String)this.m_arguments.get(index++));
/* 29 */     if (I_selectionStage == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     this.selectionStage = I_selectionStage.intValue();
/*    */     
/* 34 */     if (index >= this.m_arguments.size()) {
/* 35 */       return false;
/*    */     }
/* 37 */     Integer I_fightIndexId = parseInt((String)this.m_arguments.get(index++));
/* 38 */     if (I_fightIndexId == null) {
/* 39 */       return false;
/*    */     }
/* 41 */     this.fightIndexId = I_fightIndexId.intValue();
/*    */     
/* 43 */     if (index != this.m_arguments.size()) {
/* 44 */       return false;
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 55 */     return true;
/*    */   }
/*    */   
/*    */   protected void run() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_selectionmatchstart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */