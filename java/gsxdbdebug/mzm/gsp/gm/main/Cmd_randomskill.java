/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_randomskill extends CmdBase
/*    */ {
/*    */   private int itemid;
/*    */   private int num;
/*  9 */   private int skillid1 = -1;
/* 10 */   private int skillid2 = -1;
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
/* 29 */     Integer I_itemid = parseInt((String)this.m_arguments.get(index++));
/* 30 */     if (I_itemid == null) {
/* 31 */       return false;
/*    */     }
/* 33 */     this.itemid = I_itemid.intValue();
/*    */     
/* 35 */     if (index >= this.m_arguments.size()) {
/* 36 */       return false;
/*    */     }
/* 38 */     Integer I_num = parseInt((String)this.m_arguments.get(index++));
/* 39 */     if (I_num == null) {
/* 40 */       return false;
/*    */     }
/* 42 */     this.num = I_num.intValue();
/*    */     
/* 44 */     if (index >= this.m_arguments.size()) {
/* 45 */       return true;
/*    */     }
/* 47 */     Integer I_skillid1 = parseInt((String)this.m_arguments.get(index++));
/* 48 */     if (I_skillid1 == null) {
/* 49 */       return false;
/*    */     }
/* 51 */     this.skillid1 = I_skillid1.intValue();
/*    */     
/* 53 */     if (index >= this.m_arguments.size()) {
/* 54 */       return true;
/*    */     }
/* 56 */     Integer I_skillid2 = parseInt((String)this.m_arguments.get(index++));
/* 57 */     if (I_skillid2 == null) {
/* 58 */       return false;
/*    */     }
/* 60 */     this.skillid2 = I_skillid2.intValue();
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
/* 81 */     new mzm.gsp.item.main.PGM_RandomSkill(this.m_gmRole.getRoleid(), this.itemid, this.num, this.skillid1, this.skillid2).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_randomskill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */