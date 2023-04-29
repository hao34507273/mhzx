/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoUpdateMarqueeReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoUpdateMarqueeReq
/*    */   extends IDIPCmd<IDIPPacket_DoUpdateMarqueeReq, IDIPPacket_DoUpdateMarqueeRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4195;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoUpdateMarqueeReq, IDIPPacket_DoUpdateMarqueeRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoUpdateMarqueeReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoUpdateMarqueeReq req, IDIPPacket_DoUpdateMarqueeRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoUpdateMarqueeReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoUpdateMarqueeReq create()
/*    */   {
/* 33 */     IDIPPacket_DoUpdateMarqueeReq req = IDIPPacket_DoUpdateMarqueeReq.create();
/* 34 */     IDIPPacket_DoUpdateMarqueeRsp rsp = IDIPPacket_DoUpdateMarqueeRsp.create();
/* 35 */     return new IDIPCmd_DoUpdateMarqueeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoUpdateMarqueeReq create(IDIPPacket_DoUpdateMarqueeReq req, IDIPPacket_DoUpdateMarqueeRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoUpdateMarqueeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoUpdateMarqueeReq(IDIPPacket_DoUpdateMarqueeReq req, IDIPPacket_DoUpdateMarqueeRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4195;
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
/* 62 */     return new PIDIPCmd_DoUpdateMarqueeReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoUpdateMarqueeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */