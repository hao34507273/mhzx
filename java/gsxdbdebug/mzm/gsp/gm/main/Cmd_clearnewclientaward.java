/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.award.gift.PClearGiftData;
/*    */ import mzm.gsp.award.gift.RoleGiftInfo;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_clearnewclientaward
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int awardXId;
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
/* 45 */     Integer I_awardXId = parseInt((String)this.m_arguments.get(index++));
/* 46 */     if (I_awardXId == null) {
/* 47 */       return false;
/*    */     }
/* 49 */     this.awardXId = I_awardXId.intValue();
/*    */     
/* 51 */     if (index != this.m_arguments.size()) {
/* 52 */       return false;
/*    */     }
/* 54 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 63 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 69 */     new PClearGiftData(this.roleId, RoleGiftInfo.COMPLETE_CLIENT_AWARD, -1).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_clearnewclientaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */