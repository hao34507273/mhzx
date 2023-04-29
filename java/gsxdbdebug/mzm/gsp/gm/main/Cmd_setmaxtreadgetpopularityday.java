/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.friendscircle.main.PGM_SetMaxTreadGetPopularityDay;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setmaxtreadgetpopularityday
/*    */   extends CmdBase
/*    */ {
/*    */   private int popularity_value;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 18 */     if (this.m_arguments == null) {
/* 19 */       return false;
/*    */     }
/* 21 */     int index = 0;
/*    */     
/* 23 */     if (index >= this.m_arguments.size()) {
/* 24 */       return false;
/*    */     }
/* 26 */     Integer I_popularity_value = parseInt((String)this.m_arguments.get(index++));
/* 27 */     if (I_popularity_value == null) {
/* 28 */       return false;
/*    */     }
/* 30 */     this.popularity_value = I_popularity_value.intValue();
/*    */     
/* 32 */     if (index != this.m_arguments.size()) {
/* 33 */       return false;
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 51 */     new PGM_SetMaxTreadGetPopularityDay(this.popularity_value, this.m_gmRole.getRoleid()).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setmaxtreadgetpopularityday.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */