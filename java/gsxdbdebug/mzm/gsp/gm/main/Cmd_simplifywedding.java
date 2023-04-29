/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.masswedding.main.PGM_SimplifyWedding;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_simplifywedding
/*    */   extends CmdBase
/*    */ {
/*    */   private int maxcacheCouples;
/*    */   private int maxCouples;
/*    */   private int robSub;
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
/* 28 */     Integer I_maxcacheCouples = parseInt((String)this.m_arguments.get(index++));
/* 29 */     if (I_maxcacheCouples == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     this.maxcacheCouples = I_maxcacheCouples.intValue();
/*    */     
/* 34 */     if (index >= this.m_arguments.size()) {
/* 35 */       return false;
/*    */     }
/* 37 */     Integer I_maxCouples = parseInt((String)this.m_arguments.get(index++));
/* 38 */     if (I_maxCouples == null) {
/* 39 */       return false;
/*    */     }
/* 41 */     this.maxCouples = I_maxCouples.intValue();
/*    */     
/* 43 */     if (index >= this.m_arguments.size()) {
/* 44 */       return false;
/*    */     }
/* 46 */     Integer I_robSub = parseInt((String)this.m_arguments.get(index++));
/* 47 */     if (I_robSub == null) {
/* 48 */       return false;
/*    */     }
/* 50 */     this.robSub = I_robSub.intValue();
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
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 64 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 71 */     new PGM_SimplifyWedding(this.m_gmRole.getRoleid(), this.maxcacheCouples, this.maxCouples, this.robSub).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_simplifywedding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */