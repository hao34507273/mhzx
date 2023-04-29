/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.server.main.PGM_ResetServeLevel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_resetlevel
/*    */   extends CmdBase
/*    */ {
/*    */   private int newlevel;
/*    */   private long endtimesec;
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
/* 27 */     Integer I_newlevel = parseInt((String)this.m_arguments.get(index++));
/* 28 */     if (I_newlevel == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     this.newlevel = I_newlevel.intValue();
/*    */     
/* 33 */     if (index >= this.m_arguments.size()) {
/* 34 */       return false;
/*    */     }
/* 36 */     Long L_endtimesec = parseLong((String)this.m_arguments.get(index++));
/* 37 */     if (L_endtimesec == null)
/* 38 */       return false;
/* 39 */     this.endtimesec = L_endtimesec.longValue();
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
/*    */ 
/*    */   protected void run()
/*    */   {
/* 60 */     new PGM_ResetServeLevel(this.newlevel, this.endtimesec).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_resetlevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */