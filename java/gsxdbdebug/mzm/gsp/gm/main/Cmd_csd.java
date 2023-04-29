/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_csd extends CmdBase
/*    */ {
/*    */   private int itemsubid;
/*  8 */   private int unhitcout = 0;
/*  9 */   private int dropcount = -1;
/* 10 */   private int hisdropcount = -1;
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
/* 21 */     if (this.m_arguments == null) {
/* 22 */       return false;
/*    */     }
/* 24 */     int index = 0;
/*    */     
/* 26 */     if (index >= this.m_arguments.size()) {
/* 27 */       return false;
/*    */     }
/* 29 */     Integer I_itemsubid = parseInt((String)this.m_arguments.get(index++));
/* 30 */     if (I_itemsubid == null) {
/* 31 */       return false;
/*    */     }
/* 33 */     this.itemsubid = I_itemsubid.intValue();
/*    */     
/* 35 */     if (index >= this.m_arguments.size()) {
/* 36 */       return true;
/*    */     }
/* 38 */     Integer I_unhitcout = parseInt((String)this.m_arguments.get(index++));
/* 39 */     if (I_unhitcout == null) {
/* 40 */       return false;
/*    */     }
/* 42 */     this.unhitcout = I_unhitcout.intValue();
/*    */     
/* 44 */     if (index >= this.m_arguments.size()) {
/* 45 */       return true;
/*    */     }
/* 47 */     Integer I_dropcount = parseInt((String)this.m_arguments.get(index++));
/* 48 */     if (I_dropcount == null) {
/* 49 */       return false;
/*    */     }
/* 51 */     this.dropcount = I_dropcount.intValue();
/*    */     
/* 53 */     if (index >= this.m_arguments.size()) {
/* 54 */       return true;
/*    */     }
/* 56 */     Integer I_hisdropcount = parseInt((String)this.m_arguments.get(index++));
/* 57 */     if (I_hisdropcount == null) {
/* 58 */       return false;
/*    */     }
/* 60 */     this.hisdropcount = I_hisdropcount.intValue();
/*    */     
/* 62 */     if (index != this.m_arguments.size()) {
/* 63 */       return false;
/*    */     }
/* 65 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 74 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 81 */     new mzm.gsp.awardpool.main.PGM_ClearServerDrop(this.m_gmRole.getRoleid(), this.itemsubid, this.unhitcout, this.dropcount, this.hisdropcount).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_csd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */