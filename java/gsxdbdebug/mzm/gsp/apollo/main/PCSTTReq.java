/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCSTTReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final Octets fileid;
/*    */   
/*    */   public PCSTTReq(long roleid, Octets fileid)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.fileid = fileid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     return ApolloManager.sendApolloSTTReq(this.roleid, this.fileid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\PCSTTReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */