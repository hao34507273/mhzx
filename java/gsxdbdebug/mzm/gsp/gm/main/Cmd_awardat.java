/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.award.main.PGM_AwardAtTime;
/*    */ import xdb.Procedure;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_awardat
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int awardId;
/*    */   private int modifyId;
/*    */   private int count;
/*    */   private String awardTime;
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
/* 44 */     Integer I_awardId = parseInt((String)this.m_arguments.get(index++));
/* 45 */     if (I_awardId == null) {
/* 46 */       return false;
/*    */     }
/* 48 */     this.awardId = I_awardId.intValue();
/*    */     
/* 50 */     if (index >= this.m_arguments.size()) {
/* 51 */       return false;
/*    */     }
/* 53 */     Integer I_modifyId = parseInt((String)this.m_arguments.get(index++));
/* 54 */     if (I_modifyId == null) {
/* 55 */       return false;
/*    */     }
/* 57 */     this.modifyId = I_modifyId.intValue();
/*    */     
/* 59 */     if (index >= this.m_arguments.size()) {
/* 60 */       return false;
/*    */     }
/* 62 */     Integer I_count = parseInt((String)this.m_arguments.get(index++));
/* 63 */     if (I_count == null) {
/* 64 */       return false;
/*    */     }
/* 66 */     this.count = I_count.intValue();
/*    */     
/* 68 */     if (index >= this.m_arguments.size()) {
/* 69 */       return false;
/*    */     }
/* 71 */     this.awardTime = ((String)this.m_arguments.get(index++));
/* 72 */     if (index != this.m_arguments.size()) {
/* 73 */       return false;
/*    */     }
/* 75 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 84 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 90 */     Procedure.execute(new PGM_AwardAtTime(this.roleId, this.awardId, this.modifyId, this.count, this.awardTime));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_awardat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */