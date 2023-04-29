/*    */ package mzm.gsp.gangskill.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PSynGangSkill extends LogicProcedure {
/*    */   private long roleid;
/*    */   
/*    */   public PSynGangSkill(long roleid) {
/*  9 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     GangSkillManager.synGangSkill(this.roleid);
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangskill\main\PSynGangSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */