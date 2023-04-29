/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.server.main.Pgm_SetLevel;
/*    */ 
/*    */ public class Cmd_setserverlevel
/*    */   extends CmdBase
/*    */ {
/*    */   private int newlevel;
/* 10 */   private String endtime = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 28 */     Integer I_newlevel = parseInt((String)this.m_arguments.get(index++));
/* 29 */     if (I_newlevel == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     this.newlevel = I_newlevel.intValue();
/*    */     
/* 34 */     if (index >= this.m_arguments.size()) {
/* 35 */       return true;
/*    */     }
/* 37 */     this.endtime = ((String)this.m_arguments.get(index++));
/* 38 */     if (index != this.m_arguments.size()) {
/* 39 */       return false;
/*    */     }
/* 41 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 57 */     new Pgm_SetLevel(this.newlevel, this.endtime).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setserverlevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */