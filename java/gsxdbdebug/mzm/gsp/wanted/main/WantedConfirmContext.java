/*    */ package mzm.gsp.wanted.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.confirm.main.TeamConfirmContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WantedConfirmContext
/*    */   implements TeamConfirmContext
/*    */ {
/*    */   final Octets wantedName;
/*    */   final long wantedRoleId;
/*    */   final long activeLeaderId;
/*    */   
/*    */   public WantedConfirmContext(Octets wantedName, long wantedRoleId, long activeLeaderId)
/*    */   {
/* 17 */     this.wantedName = wantedName;
/* 18 */     this.wantedRoleId = wantedRoleId;
/* 19 */     this.activeLeaderId = activeLeaderId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\WantedConfirmContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */