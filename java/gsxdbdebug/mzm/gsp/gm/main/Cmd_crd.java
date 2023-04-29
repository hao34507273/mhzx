/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_crd extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int itemsubid;
/*  9 */   private int unhitcout = 0;
/* 10 */   private int dropcount = -1;
/* 11 */   private int hisdropcount = -1;
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
/* 22 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 24 */     if (this.m_arguments == null) {
/* 25 */       return false;
/*    */     }
/* 27 */     int index = 0;
/*    */     
/* 29 */     if (index >= this.m_arguments.size()) {
/* 30 */       return false;
/*    */     }
/* 32 */     Long targetId = null;
/* 33 */     targetId = xtable.Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 35 */     if (targetId != null)
/*    */     {
/* 37 */       this.roleId = targetId.longValue();
/* 38 */       index++;
/*    */     }
/*    */     
/* 41 */     if (index >= this.m_arguments.size()) {
/* 42 */       return false;
/*    */     }
/* 44 */     Integer I_itemsubid = parseInt((String)this.m_arguments.get(index++));
/* 45 */     if (I_itemsubid == null) {
/* 46 */       return false;
/*    */     }
/* 48 */     this.itemsubid = I_itemsubid.intValue();
/*    */     
/* 50 */     if (index >= this.m_arguments.size()) {
/* 51 */       return true;
/*    */     }
/* 53 */     Integer I_unhitcout = parseInt((String)this.m_arguments.get(index++));
/* 54 */     if (I_unhitcout == null) {
/* 55 */       return false;
/*    */     }
/* 57 */     this.unhitcout = I_unhitcout.intValue();
/*    */     
/* 59 */     if (index >= this.m_arguments.size()) {
/* 60 */       return true;
/*    */     }
/* 62 */     Integer I_dropcount = parseInt((String)this.m_arguments.get(index++));
/* 63 */     if (I_dropcount == null) {
/* 64 */       return false;
/*    */     }
/* 66 */     this.dropcount = I_dropcount.intValue();
/*    */     
/* 68 */     if (index >= this.m_arguments.size()) {
/* 69 */       return true;
/*    */     }
/* 71 */     Integer I_hisdropcount = parseInt((String)this.m_arguments.get(index++));
/* 72 */     if (I_hisdropcount == null) {
/* 73 */       return false;
/*    */     }
/* 75 */     this.hisdropcount = I_hisdropcount.intValue();
/*    */     
/* 77 */     if (index != this.m_arguments.size()) {
/* 78 */       return false;
/*    */     }
/* 80 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 89 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 96 */     new mzm.gsp.awardpool.main.PGM_ClearRoleDrop(this.m_gmRole.getRoleid(), this.roleId, this.itemsubid, this.unhitcout, this.dropcount, this.hisdropcount).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_crd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */