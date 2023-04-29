/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoUpdateSilverReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoUpdateSilverReq
/*    */   extends IDIPCmd<IDIPPacket_DoUpdateSilverReq, IDIPPacket_DoUpdateSilverRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4101;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoUpdateSilverReq, IDIPPacket_DoUpdateSilverRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoUpdateSilverReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoUpdateSilverReq req, IDIPPacket_DoUpdateSilverRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoUpdateSilverReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoUpdateSilverReq create()
/*    */   {
/* 33 */     IDIPPacket_DoUpdateSilverReq req = IDIPPacket_DoUpdateSilverReq.create();
/* 34 */     IDIPPacket_DoUpdateSilverRsp rsp = IDIPPacket_DoUpdateSilverRsp.create();
/* 35 */     return new IDIPCmd_DoUpdateSilverReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoUpdateSilverReq create(IDIPPacket_DoUpdateSilverReq req, IDIPPacket_DoUpdateSilverRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoUpdateSilverReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoUpdateSilverReq(IDIPPacket_DoUpdateSilverReq req, IDIPPacket_DoUpdateSilverRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4101;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 62 */     return new PIDIPCmd_DoUpdateSilverReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoUpdateSilverReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */