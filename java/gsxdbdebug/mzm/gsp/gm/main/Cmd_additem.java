/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_additem extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int itemid;
/*  9 */   private int number = 1;
/* 10 */   private int isbind = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean parse()
/*    */   {
/* 20 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 22 */     if (this.m_arguments == null) {
/* 23 */       return false;
/*    */     }
/* 25 */     int index = 0;
/*    */     
/* 27 */     if (index >= this.m_arguments.size()) {
/* 28 */       return false;
/*    */     }
/* 30 */     Long targetId = null;
/* 31 */     targetId = xtable.Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 33 */     if (targetId != null)
/*    */     {
/* 35 */       this.roleId = targetId.longValue();
/* 36 */       index++;
/*    */     }
/*    */     
/* 39 */     if (index >= this.m_arguments.size()) {
/* 40 */       return false;
/*    */     }
/* 42 */     Integer I_itemid = parseInt((String)this.m_arguments.get(index++));
/* 43 */     if (I_itemid == null) {
/* 44 */       return false;
/*    */     }
/* 46 */     this.itemid = I_itemid.intValue();
/*    */     
/* 48 */     if (index >= this.m_arguments.size()) {
/* 49 */       return true;
/*    */     }
/* 51 */     Integer I_number = parseInt((String)this.m_arguments.get(index++));
/* 52 */     if (I_number == null) {
/* 53 */       return false;
/*    */     }
/* 55 */     this.number = I_number.intValue();
/*    */     
/* 57 */     if (index >= this.m_arguments.size()) {
/* 58 */       return true;
/*    */     }
/* 60 */     Integer I_isbind = parseInt((String)this.m_arguments.get(index++));
/* 61 */     if (I_isbind == null) {
/* 62 */       return false;
/*    */     }
/* 64 */     this.isbind = I_isbind.intValue();
/*    */     
/* 66 */     if (index != this.m_arguments.size()) {
/* 67 */       return false;
/*    */     }
/* 69 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 78 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 85 */     new mzm.gsp.item.main.PGM_AddItem(this.m_gmRole.getRoleid(), this.roleId, this.itemid, this.number, this.isbind == 1).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_additem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */