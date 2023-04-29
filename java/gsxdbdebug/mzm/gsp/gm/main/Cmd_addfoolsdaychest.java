/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.foolsday.main.FoolsDayInterface;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_addfoolsdaychest
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int activity_cfg_id;
/*    */   private int buff_id;
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
/* 33 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
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
/* 44 */     Integer I_activity_cfg_id = parseInt((String)this.m_arguments.get(index++));
/* 45 */     if (I_activity_cfg_id == null) {
/* 46 */       return false;
/*    */     }
/* 48 */     this.activity_cfg_id = I_activity_cfg_id.intValue();
/*    */     
/* 50 */     if (index >= this.m_arguments.size()) {
/* 51 */       return false;
/*    */     }
/* 53 */     Integer I_buff_id = parseInt((String)this.m_arguments.get(index++));
/* 54 */     if (I_buff_id == null) {
/* 55 */       return false;
/*    */     }
/* 57 */     this.buff_id = I_buff_id.intValue();
/*    */     
/* 59 */     if (index != this.m_arguments.size()) {
/* 60 */       return false;
/*    */     }
/* 62 */     return true;
/*    */   }
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
/* 76 */     FoolsDayInterface.asynAddChestByIdip(this.roleId, this.activity_cfg_id, this.buff_id);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_addfoolsdaychest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */