/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_closerolefight extends CmdBase {
/*  6 */   private ArrayList<String> arg = new ArrayList();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean parse()
/*    */   {
/* 16 */     if (this.m_arguments == null) {
/* 17 */       return false;
/*    */     }
/* 19 */     int index = 0;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 24 */     while (index < this.m_arguments.size())
/*    */     {
/*    */ 
/* 27 */       if (index >= this.m_arguments.size()) {
/* 28 */         return false;
/*    */       }
/* 30 */       this.arg.add(this.m_arguments.get(index++));
/*    */     }
/* 32 */     if (index != this.m_arguments.size()) {
/* 33 */       return false;
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 49 */     long roleid = this.m_gmRole.getRoleid();
/* 50 */     int index = 0;
/* 51 */     if (this.arg.size() > 0) {
/* 52 */       Long targetId = xtable.Name2roleid.select((String)this.arg.get(index));
/* 53 */       if (targetId != null) {
/* 54 */         index++;
/* 55 */         roleid = targetId.longValue();
/*    */       }
/*    */     }
/*    */     
/* 59 */     boolean isWin = true;
/* 60 */     if (this.arg.size() > index) {
/* 61 */       int ret = parseInt(((String)this.arg.get(index)).trim()).intValue();
/* 62 */       if (ret <= 0) {
/* 63 */         isWin = false;
/*    */       }
/*    */     }
/* 66 */     mzm.gsp.Role.addRoleProcedure(roleid, new mzm.gsp.fight.main.PGM_closeRoleFight(roleid, isWin));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_closerolefight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */