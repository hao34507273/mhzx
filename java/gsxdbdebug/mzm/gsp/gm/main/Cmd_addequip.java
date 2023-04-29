/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_addequip extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int itemid;
/*  9 */   private int skillid = -1;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean parse()
/*    */   {
/* 19 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 21 */     if (this.m_arguments == null) {
/* 22 */       return false;
/*    */     }
/* 24 */     int index = 0;
/*    */     
/* 26 */     if (index >= this.m_arguments.size()) {
/* 27 */       return false;
/*    */     }
/* 29 */     Long targetId = null;
/* 30 */     targetId = xtable.Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 32 */     if (targetId != null)
/*    */     {
/* 34 */       this.roleId = targetId.longValue();
/* 35 */       index++;
/*    */     }
/*    */     
/* 38 */     if (index >= this.m_arguments.size()) {
/* 39 */       return false;
/*    */     }
/* 41 */     Integer I_itemid = parseInt((String)this.m_arguments.get(index++));
/* 42 */     if (I_itemid == null) {
/* 43 */       return false;
/*    */     }
/* 45 */     this.itemid = I_itemid.intValue();
/*    */     
/* 47 */     if (index >= this.m_arguments.size()) {
/* 48 */       return true;
/*    */     }
/* 50 */     Integer I_skillid = parseInt((String)this.m_arguments.get(index++));
/* 51 */     if (I_skillid == null) {
/* 52 */       return false;
/*    */     }
/* 54 */     this.skillid = I_skillid.intValue();
/*    */     
/* 56 */     if (index != this.m_arguments.size()) {
/* 57 */       return false;
/*    */     }
/* 59 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 68 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 75 */     new mzm.gsp.item.main.PGM_AddEquip(this.m_gmRole.getRoleid(), this.roleId, this.itemid, this.skillid).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_addequip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */