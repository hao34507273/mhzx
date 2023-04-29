/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.map.main.message.MMH_FindMonster;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_findmonster
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int id;
/*    */   private int order;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 21 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 23 */     if (this.m_arguments == null) {
/* 24 */       return false;
/*    */     }
/* 26 */     int index = 0;
/*    */     
/* 28 */     if (index >= this.m_arguments.size()) {
/* 29 */       return false;
/*    */     }
/* 31 */     Long targetId = null;
/* 32 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 34 */     if (targetId != null)
/*    */     {
/* 36 */       this.roleId = targetId.longValue();
/* 37 */       index++;
/*    */     }
/*    */     
/* 40 */     if (index >= this.m_arguments.size()) {
/* 41 */       return false;
/*    */     }
/* 43 */     Integer I_id = parseInt((String)this.m_arguments.get(index++));
/* 44 */     if (I_id == null) {
/* 45 */       return false;
/*    */     }
/* 47 */     this.id = I_id.intValue();
/*    */     
/* 49 */     if (index >= this.m_arguments.size()) {
/* 50 */       return false;
/*    */     }
/* 52 */     Integer I_order = parseInt((String)this.m_arguments.get(index++));
/* 53 */     if (I_order == null) {
/* 54 */       return false;
/*    */     }
/* 56 */     this.order = I_order.intValue();
/*    */     
/* 58 */     if (index != this.m_arguments.size()) {
/* 59 */       return false;
/*    */     }
/* 61 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 70 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 76 */     if (this.order <= 0)
/*    */     {
/* 78 */       sendError("must input a order big than 0");
/* 79 */       return;
/*    */     }
/*    */     
/* 82 */     new MMH_FindMonster(this.m_gmRole.getRoleid(), this.roleId, this.id, this.order).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_findmonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */