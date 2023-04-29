/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.children.main.ChildrenInterface;
/*    */ import mzm.gsp.children.main.ChildrenOutFightObj;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PChildrenInFight
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long childrenid;
/*    */   
/*    */   public PChildrenInFight(long roleid, long childrenid)
/*    */   {
/* 30 */     this.roleid = roleid;
/* 31 */     this.childrenid = childrenid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 36 */     lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 37 */     ChildrenOutFightObj childrenOutFightObj = ChildrenInterface.getChildrenOutFightObj(this.roleid, this.childrenid);
/* 38 */     if (childrenOutFightObj != null) {
/* 39 */       childrenOutFightObj.setFightFlag(true);
/* 40 */       return true;
/*    */     }
/* 42 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PChildrenInFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */