/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_startcontrol
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int id;
/*    */   private int count;
/*    */   private int max_spawn_num;
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
/* 50 */       return true;
/*    */     }
/* 52 */     Integer I_count = parseInt((String)this.m_arguments.get(index++));
/* 53 */     if (I_count == null) {
/* 54 */       return false;
/*    */     }
/* 56 */     this.count = I_count.intValue();
/*    */     
/* 58 */     if (index >= this.m_arguments.size()) {
/* 59 */       return true;
/*    */     }
/* 61 */     Integer I_max_spawn_num = parseInt((String)this.m_arguments.get(index++));
/* 62 */     if (I_max_spawn_num == null) {
/* 63 */       return false;
/*    */     }
/* 65 */     this.max_spawn_num = I_max_spawn_num.intValue();
/*    */     
/* 67 */     if (index != this.m_arguments.size()) {
/* 68 */       return false;
/*    */     }
/* 70 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 79 */     if ((this.count < 1) || (this.max_spawn_num < 0))
/*    */     {
/* 81 */       return false;
/*    */     }
/*    */     
/* 84 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 91 */     ControllerInterface.triggerController(this.roleId, this.id, this.count, this.max_spawn_num);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_startcontrol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */