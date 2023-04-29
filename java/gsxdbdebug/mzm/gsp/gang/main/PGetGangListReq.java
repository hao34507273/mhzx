/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.CGetGangListReq;
/*    */ 
/*    */ 
/*    */ public class PGetGangListReq
/*    */   extends GangProcedure<CGetGangListReq>
/*    */ {
/*    */   public PGetGangListReq(CGetGangListReq protocol)
/*    */   {
/* 11 */     super(protocol);
/*    */   }
/*    */   
/*    */   protected boolean doProcess(long roleId, CGetGangListReq protocol)
/*    */   {
/* 16 */     GangManager.syncGangInfoList(roleId, protocol.lastid, protocol.size);
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGetGangListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */