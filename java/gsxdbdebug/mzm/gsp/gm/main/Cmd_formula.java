/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_formula extends CmdBase
/*    */ {
/*    */   private int formulaid;
/*  8 */   private ArrayList<String> params = new ArrayList();
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
/* 19 */     if (this.m_arguments == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     int index = 0;
/*    */     
/* 24 */     if (index >= this.m_arguments.size()) {
/* 25 */       return false;
/*    */     }
/* 27 */     Integer I_formulaid = parseInt((String)this.m_arguments.get(index++));
/* 28 */     if (I_formulaid == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     this.formulaid = I_formulaid.intValue();
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 36 */     while (index < this.m_arguments.size())
/*    */     {
/*    */ 
/* 39 */       if (index >= this.m_arguments.size()) {
/* 40 */         return false;
/*    */       }
/* 42 */       this.params.add(this.m_arguments.get(index++));
/*    */     }
/* 44 */     if (index != this.m_arguments.size()) {
/* 45 */       return false;
/*    */     }
/* 47 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 56 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 63 */     new mzm.gsp.fight.main.PGM_Formula(this.m_gmRole.getRoleid(), this.formulaid, this.params).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_formula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */