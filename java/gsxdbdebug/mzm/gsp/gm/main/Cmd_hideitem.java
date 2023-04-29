/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.idip.main.PGM_HideItem;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_hideitem
/*    */   extends CmdBase
/*    */ {
/*    */   private int type;
/*    */   private int cfgid;
/*    */   private int hide;
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
/* 28 */     Integer I_type = parseInt((String)this.m_arguments.get(index++));
/* 29 */     if (I_type == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     this.type = I_type.intValue();
/*    */     
/* 34 */     if (index >= this.m_arguments.size()) {
/* 35 */       return false;
/*    */     }
/* 37 */     Integer I_cfgid = parseInt((String)this.m_arguments.get(index++));
/* 38 */     if (I_cfgid == null) {
/* 39 */       return false;
/*    */     }
/* 41 */     this.cfgid = I_cfgid.intValue();
/*    */     
/* 43 */     if (index >= this.m_arguments.size()) {
/* 44 */       return false;
/*    */     }
/* 46 */     Integer I_hide = parseInt((String)this.m_arguments.get(index++));
/* 47 */     if (I_hide == null) {
/* 48 */       return false;
/*    */     }
/* 50 */     this.hide = I_hide.intValue();
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
/* 71 */     new PGM_HideItem(this.m_gmRole.getRoleid(), this.type, this.cfgid, this.hide == 0).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_hideitem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */