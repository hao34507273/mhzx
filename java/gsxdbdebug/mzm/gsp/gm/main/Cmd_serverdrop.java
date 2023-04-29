/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.awardpool.main.PGm_SeverDrop;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_serverdrop
/*    */   extends CmdBase
/*    */ {
/*    */   private int itemsubid;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 17 */     if (this.m_arguments == null) {
/* 18 */       return false;
/*    */     }
/* 20 */     int index = 0;
/*    */     
/* 22 */     if (index >= this.m_arguments.size()) {
/* 23 */       return false;
/*    */     }
/* 25 */     Integer I_itemsubid = parseInt((String)this.m_arguments.get(index++));
/* 26 */     if (I_itemsubid == null) {
/* 27 */       return false;
/*    */     }
/* 29 */     this.itemsubid = I_itemsubid.intValue();
/*    */     
/* 31 */     if (index != this.m_arguments.size()) {
/* 32 */       return false;
/*    */     }
/* 34 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 50 */     new PGm_SeverDrop(this.m_gmRole.getRoleid(), this.itemsubid).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_serverdrop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */