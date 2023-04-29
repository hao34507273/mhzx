/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.map.main.message.MMH_GM_GoFault;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_gofault
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 18 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 20 */     if (this.m_arguments == null) {
/* 21 */       return true;
/*    */     }
/* 23 */     int index = 0;
/*    */     
/* 25 */     if (index >= this.m_arguments.size()) {
/* 26 */       return true;
/*    */     }
/* 28 */     Long targetId = null;
/* 29 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 31 */     if (targetId != null)
/*    */     {
/* 33 */       this.roleId = targetId.longValue();
/* 34 */       index++;
/*    */     }
/*    */     
/* 37 */     if (index != this.m_arguments.size()) {
/* 38 */       return false;
/*    */     }
/* 40 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 55 */     new MMH_GM_GoFault(this.m_gmRole.getRoleid(), this.roleId).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_gofault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */