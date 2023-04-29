/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PGM_CheckLingLevel;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_checklinglevel
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private long uuid;
/*    */   private int current_level;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 23 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 25 */     if (this.m_arguments == null) {
/* 26 */       return false;
/*    */     }
/* 28 */     int index = 0;
/*    */     
/* 30 */     if (index >= this.m_arguments.size()) {
/* 31 */       return false;
/*    */     }
/* 33 */     Long targetId = null;
/* 34 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 36 */     if (targetId != null)
/*    */     {
/* 38 */       this.roleId = targetId.longValue();
/* 39 */       index++;
/*    */     }
/*    */     
/* 42 */     if (index >= this.m_arguments.size()) {
/* 43 */       return false;
/*    */     }
/* 45 */     Long L_uuid = parseLong((String)this.m_arguments.get(index++));
/* 46 */     if (L_uuid == null)
/* 47 */       return false;
/* 48 */     this.uuid = L_uuid.longValue();
/*    */     
/* 50 */     if (index >= this.m_arguments.size()) {
/* 51 */       return false;
/*    */     }
/* 53 */     Integer I_current_level = parseInt((String)this.m_arguments.get(index++));
/* 54 */     if (I_current_level == null) {
/* 55 */       return false;
/*    */     }
/* 57 */     this.current_level = I_current_level.intValue();
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
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 71 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 78 */     new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 84 */         PGM_CheckLingLevel.checkLingLevel(Cmd_checklinglevel.this.m_gmRole.getRoleid(), Cmd_checklinglevel.this.roleId, Cmd_checklinglevel.this.uuid, Cmd_checklinglevel.this.current_level);
/* 85 */         return true;
/*    */       }
/*    */     }.execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_checklinglevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */