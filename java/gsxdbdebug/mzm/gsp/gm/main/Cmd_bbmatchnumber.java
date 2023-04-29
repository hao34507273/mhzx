/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_bbmatchnumber extends CmdBase
/*    */ {
/*    */   private int activityId;
/*  8 */   private int minNumber = -1;
/*  9 */   private int defaultNumber = -1;
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
/* 20 */     if (this.m_arguments == null) {
/* 21 */       return false;
/*    */     }
/* 23 */     int index = 0;
/*    */     
/* 25 */     if (index >= this.m_arguments.size()) {
/* 26 */       return false;
/*    */     }
/* 28 */     Integer I_activityId = parseInt((String)this.m_arguments.get(index++));
/* 29 */     if (I_activityId == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     this.activityId = I_activityId.intValue();
/*    */     
/* 34 */     if (index >= this.m_arguments.size()) {
/* 35 */       return true;
/*    */     }
/* 37 */     Integer I_minNumber = parseInt((String)this.m_arguments.get(index++));
/* 38 */     if (I_minNumber == null) {
/* 39 */       return false;
/*    */     }
/* 41 */     this.minNumber = I_minNumber.intValue();
/*    */     
/* 43 */     if (index >= this.m_arguments.size()) {
/* 44 */       return true;
/*    */     }
/* 46 */     Integer I_defaultNumber = parseInt((String)this.m_arguments.get(index++));
/* 47 */     if (I_defaultNumber == null) {
/* 48 */       return false;
/*    */     }
/* 50 */     this.defaultNumber = I_defaultNumber.intValue();
/*    */     
/* 52 */     if (index != this.m_arguments.size()) {
/* 53 */       return false;
/*    */     }
/* 55 */     return true;
/*    */   }
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
/* 69 */     new mzm.gsp.ballbattle.main.RGM_BallBattleMatchNumber(this.m_gmRole.getRoleid(), this.activityId, this.minNumber, this.defaultNumber).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_bbmatchnumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */