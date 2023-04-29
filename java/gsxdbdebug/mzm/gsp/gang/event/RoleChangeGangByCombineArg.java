/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleChangeGangByCombineArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final long oldGangid;
/*    */   public final long newGangid;
/*    */   public final int oldDuty;
/*    */   
/*    */   public RoleChangeGangByCombineArg(long roleid, long oldGangid, long newGangid, int oldDuty)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.oldGangid = oldGangid;
/* 20 */     this.newGangid = newGangid;
/* 21 */     this.oldDuty = oldDuty;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isOldLeader()
/*    */   {
/* 29 */     return this.oldDuty == SGangConst.getInstance().BANGZHU_ID;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\RoleChangeGangByCombineArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */