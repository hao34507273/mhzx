/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_openchange
/*    */   extends CmdBase
/*    */ {
/*    */   private int opentype;
/*    */   private int isopen;
/*    */   private int funid;
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
/* 28 */     Integer I_opentype = parseInt((String)this.m_arguments.get(index++));
/* 29 */     if (I_opentype == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     this.opentype = I_opentype.intValue();
/*    */     
/* 34 */     if (index >= this.m_arguments.size()) {
/* 35 */       return false;
/*    */     }
/* 37 */     Integer I_isopen = parseInt((String)this.m_arguments.get(index++));
/* 38 */     if (I_isopen == null) {
/* 39 */       return false;
/*    */     }
/* 41 */     this.isopen = I_isopen.intValue();
/*    */     
/* 43 */     if (index >= this.m_arguments.size()) {
/* 44 */       return true;
/*    */     }
/* 46 */     Integer I_funid = parseInt((String)this.m_arguments.get(index++));
/* 47 */     if (I_funid == null) {
/* 48 */       return false;
/*    */     }
/* 50 */     this.funid = I_funid.intValue();
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
/*    */   protected void run()
/*    */   {
/* 70 */     OpenInterface.setOpenStatus(this.opentype, this.funid, this.isopen > 0);
/* 71 */     GmManager.getInstance().sendResultToGM(this.m_gmRole.getRoleid(), String.format("set open status success|open_type=%d|is_open=%d|funid=%d", new Object[] { Integer.valueOf(this.opentype), Integer.valueOf(this.isopen), Integer.valueOf(this.funid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_openchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */