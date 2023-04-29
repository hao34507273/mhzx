/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.item.main.PGM_QilinScore;
/*    */ 
/*    */ public class Cmd_qilinscore extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int wearpos;
/* 10 */   private int score = -1;
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
/* 43 */     Integer I_wearpos = parseInt((String)this.m_arguments.get(index++));
/* 44 */     if (I_wearpos == null) {
/* 45 */       return false;
/*    */     }
/* 47 */     this.wearpos = I_wearpos.intValue();
/*    */     
/* 49 */     if (index >= this.m_arguments.size()) {
/* 50 */       return true;
/*    */     }
/* 52 */     Integer I_score = parseInt((String)this.m_arguments.get(index++));
/* 53 */     if (I_score == null) {
/* 54 */       return false;
/*    */     }
/* 56 */     this.score = I_score.intValue();
/*    */     
/* 58 */     if (index != this.m_arguments.size()) {
/* 59 */       return false;
/*    */     }
/* 61 */     return true;
/*    */   }
/*    */   
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
/*    */ 
/*    */   protected void run()
/*    */   {
/* 77 */     new PGM_QilinScore(this.m_gmRole.getRoleid(), this.roleId, this.wearpos, this.score).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_qilinscore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */