/*    */ package mzm.gsp.zoo.main;
/*    */ 
/*    */ import mzm.gsp.homeland.confbean.SAnimalConst;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCheckClean extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCheckClean(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     int level = RoleInterface.getLevel(this.roleid);
/* 20 */     if (level < SAnimalConst.getInstance().OPEN_LEVEL)
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     ZooManager.checkCleanForEscape(this.roleid);
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\PCheckClean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */