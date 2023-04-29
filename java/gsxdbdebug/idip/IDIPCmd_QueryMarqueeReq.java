/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_QueryMarqueeReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_QueryMarqueeReq
/*    */   extends IDIPCmd<IDIPPacket_QueryMarqueeReq, IDIPPacket_QueryMarqueeRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4193;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_QueryMarqueeReq, IDIPPacket_QueryMarqueeRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_QueryMarqueeReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_QueryMarqueeReq req, IDIPPacket_QueryMarqueeRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_QueryMarqueeReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_QueryMarqueeReq create()
/*    */   {
/* 33 */     IDIPPacket_QueryMarqueeReq req = IDIPPacket_QueryMarqueeReq.create();
/* 34 */     IDIPPacket_QueryMarqueeRsp rsp = IDIPPacket_QueryMarqueeRsp.create();
/* 35 */     return new IDIPCmd_QueryMarqueeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_QueryMarqueeReq create(IDIPPacket_QueryMarqueeReq req, IDIPPacket_QueryMarqueeRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_QueryMarqueeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_QueryMarqueeReq(IDIPPacket_QueryMarqueeReq req, IDIPPacket_QueryMarqueeRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4193;
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
/* 62 */     return new PIDIPCmd_QueryMarqueeReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_QueryMarqueeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */