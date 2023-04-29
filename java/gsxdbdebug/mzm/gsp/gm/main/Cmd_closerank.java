/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_closerank extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int rankType;
/*    */   private int periodSec;
/* 10 */   private int isclear = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 32 */     targetId = xtable.Name2roleid.select((String)this.m_arguments.get(index));
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
/* 43 */     Integer I_rankType = parseInt((String)this.m_arguments.get(index++));
/* 44 */     if (I_rankType == null) {
/* 45 */       return false;
/*    */     }
/* 47 */     this.rankType = I_rankType.intValue();
/*    */     
/* 49 */     if (index >= this.m_arguments.size()) {
/* 50 */       return false;
/*    */     }
/* 52 */     Integer I_periodSec = parseInt((String)this.m_arguments.get(index++));
/* 53 */     if (I_periodSec == null) {
/* 54 */       return false;
/*    */     }
/* 56 */     this.periodSec = I_periodSec.intValue();
/*    */     
/* 58 */     if (index >= this.m_arguments.size()) {
/* 59 */       return true;
/*    */     }
/* 61 */     Integer I_isclear = parseInt((String)this.m_arguments.get(index++));
/* 62 */     if (I_isclear == null) {
/* 63 */       return false;
/*    */     }
/* 65 */     this.isclear = I_isclear.intValue();
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
/*    */ 
/*    */   protected void run()
/*    */   {
/* 86 */     new mzm.gsp.idip.main.PGMBanRank(this.m_gmRole.getRoleid(), this.roleId, this.rankType, this.periodSec, this.isclear).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_closerank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */