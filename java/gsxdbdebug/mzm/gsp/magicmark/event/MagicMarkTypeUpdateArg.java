/*    */ package mzm.gsp.magicmark.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MagicMarkTypeUpdateArg
/*    */ {
/*    */   public static final int STATE_OUT_OF_DATE = 1;
/*    */   
/*    */ 
/*    */   public static final int STATE_EXTEND_TIME = 2;
/*    */   
/*    */ 
/*    */   public static final int STATE_REMOVED_BY_COMMAND = 3;
/*    */   
/*    */ 
/*    */   public final long roleId;
/*    */   
/*    */   public final int markType;
/*    */   
/*    */   public final int state;
/*    */   
/*    */ 
/*    */   public MagicMarkTypeUpdateArg(long roleId, int markType, int state)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.markType = markType;
/* 27 */     this.state = state;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\event\MagicMarkTypeUpdateArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */