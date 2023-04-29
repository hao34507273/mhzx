/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.cat.main.PGM_SetCatBestPartner;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setcatbestpartner
/*    */   extends CmdBase
/*    */ {
/*    */   private int partner_cfgid;
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
/* 26 */     Integer I_partner_cfgid = parseInt((String)this.m_arguments.get(index++));
/* 27 */     if (I_partner_cfgid == null) {
/* 28 */       return false;
/*    */     }
/* 30 */     this.partner_cfgid = I_partner_cfgid.intValue();
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
/*    */ 
/*    */   protected void run()
/*    */   {
/* 51 */     new PGM_SetCatBestPartner(this.m_gmRole.getRoleid(), this.partner_cfgid).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setcatbestpartner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */