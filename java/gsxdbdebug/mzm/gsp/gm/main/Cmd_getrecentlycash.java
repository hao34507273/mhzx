/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.qingfu.main.PGM_GetRecentlyCash;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_getrecentlycash
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int day;
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
/* 30 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
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
/* 41 */     Integer I_day = parseInt((String)this.m_arguments.get(index++));
/* 42 */     if (I_day == null) {
/* 43 */       return false;
/*    */     }
/* 45 */     this.day = I_day.intValue();
/*    */     
/* 47 */     if (index != this.m_arguments.size()) {
/* 48 */       return false;
/*    */     }
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 59 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 66 */     new PGM_GetRecentlyCash(this.roleId, this.day).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_getrecentlycash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */