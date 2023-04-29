/*    */ package mzm.gsp.constellation.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChooseCardArg
/*    */ {
/*    */   public final long roleid;
/*    */   
/*    */   public final int constellation;
/*    */   
/*    */   public final int star;
/*    */   
/*    */ 
/*    */   public ChooseCardArg(long roleid, int constellation, int star)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.constellation = constellation;
/* 18 */     this.star = star;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\event\ChooseCardArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */