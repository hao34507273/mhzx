/*    */ package mzm.gsp.mall.event;
/*    */ 
/*    */ 
/*    */ public class JiFenChangedArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final int tokenType;
/*    */   public final long changeNum;
/*    */   public final long leftNum;
/*    */   
/*    */   public JiFenChangedArg(long roleId, int tokenType, long changeNum, long leftNum)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.tokenType = tokenType;
/* 15 */     this.changeNum = changeNum;
/* 16 */     this.leftNum = leftNum;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\event\JiFenChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */