/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.award.main.PGM_AwardToRolesXTime;
/*    */ import xdb.Procedure;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_awardto
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int awardId;
/*    */   private int modifyId;
/*    */   private int count;
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
/* 43 */     Integer I_awardId = parseInt((String)this.m_arguments.get(index++));
/* 44 */     if (I_awardId == null) {
/* 45 */       return false;
/*    */     }
/* 47 */     this.awardId = I_awardId.intValue();
/*    */     
/* 49 */     if (index >= this.m_arguments.size()) {
/* 50 */       return false;
/*    */     }
/* 52 */     Integer I_modifyId = parseInt((String)this.m_arguments.get(index++));
/* 53 */     if (I_modifyId == null) {
/* 54 */       return false;
/*    */     }
/* 56 */     this.modifyId = I_modifyId.intValue();
/*    */     
/* 58 */     if (index >= this.m_arguments.size()) {
/* 59 */       return false;
/*    */     }
/* 61 */     Integer I_count = parseInt((String)this.m_arguments.get(index++));
/* 62 */     if (I_count == null) {
/* 63 */       return false;
/*    */     }
/* 65 */     this.count = I_count.intValue();
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
/* 79 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 85 */     Procedure.execute(new PGM_AwardToRolesXTime(this.roleId, this.awardId, this.modifyId, this.count));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_awardto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */