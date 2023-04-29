/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoDeleteMarqueeReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoDeleteMarqueeReq
/*    */   extends IDIPCmd<IDIPPacket_DoDeleteMarqueeReq, IDIPPacket_DoDeleteMarqueeRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4179;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoDeleteMarqueeReq, IDIPPacket_DoDeleteMarqueeRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoDeleteMarqueeReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoDeleteMarqueeReq req, IDIPPacket_DoDeleteMarqueeRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoDeleteMarqueeReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoDeleteMarqueeReq create()
/*    */   {
/* 33 */     IDIPPacket_DoDeleteMarqueeReq req = IDIPPacket_DoDeleteMarqueeReq.create();
/* 34 */     IDIPPacket_DoDeleteMarqueeRsp rsp = IDIPPacket_DoDeleteMarqueeRsp.create();
/* 35 */     return new IDIPCmd_DoDeleteMarqueeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoDeleteMarqueeReq create(IDIPPacket_DoDeleteMarqueeReq req, IDIPPacket_DoDeleteMarqueeRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoDeleteMarqueeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoDeleteMarqueeReq(IDIPPacket_DoDeleteMarqueeReq req, IDIPPacket_DoDeleteMarqueeRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4179;
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
/* 62 */     return new PIDIPCmd_DoDeleteMarqueeReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoDeleteMarqueeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */