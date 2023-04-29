/*    */ package mzm.gsp.buff.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UninstallBuffArg
/*    */ {
/*    */   public final long roleid;
/*    */   
/*    */ 
/*    */   public final int buffid;
/*    */   
/*    */   public final int state;
/*    */   
/*    */ 
/*    */   public UninstallBuffArg(long roleid, int buffid, int state)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.buffid = buffid;
/* 19 */     this.state = state;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\event\UninstallBuffArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */