/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.children.main.PGM_AddChildHealth;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_addchildhealth
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int childId;
/*    */   private int health;
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
/* 31 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
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
/* 42 */     Integer I_childId = parseInt((String)this.m_arguments.get(index++));
/* 43 */     if (I_childId == null) {
/* 44 */       return false;
/*    */     }
/* 46 */     this.childId = I_childId.intValue();
/*    */     
/* 48 */     if (index >= this.m_arguments.size()) {
/* 49 */       return false;
/*    */     }
/* 51 */     Integer I_health = parseInt((String)this.m_arguments.get(index++));
/* 52 */     if (I_health == null) {
/* 53 */       return false;
/*    */     }
/* 55 */     this.health = I_health.intValue();
/*    */     
/* 57 */     if (index != this.m_arguments.size()) {
/* 58 */       return false;
/*    */     }
/* 60 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 69 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 76 */     new PGM_AddChildHealth(this.roleId, this.childId, this.health).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_addchildhealth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */