/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoUpdateCompetitivePointReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoUpdateCompetitivePointReq
/*    */   extends IDIPCmd<IDIPPacket_DoUpdateCompetitivePointReq, IDIPPacket_DoUpdateCompetitivePointRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4113;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoUpdateCompetitivePointReq, IDIPPacket_DoUpdateCompetitivePointRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoUpdateCompetitivePointReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoUpdateCompetitivePointReq req, IDIPPacket_DoUpdateCompetitivePointRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoUpdateCompetitivePointReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoUpdateCompetitivePointReq create()
/*    */   {
/* 33 */     IDIPPacket_DoUpdateCompetitivePointReq req = IDIPPacket_DoUpdateCompetitivePointReq.create();
/* 34 */     IDIPPacket_DoUpdateCompetitivePointRsp rsp = IDIPPacket_DoUpdateCompetitivePointRsp.create();
/* 35 */     return new IDIPCmd_DoUpdateCompetitivePointReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoUpdateCompetitivePointReq create(IDIPPacket_DoUpdateCompetitivePointReq req, IDIPPacket_DoUpdateCompetitivePointRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoUpdateCompetitivePointReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoUpdateCompetitivePointReq(IDIPPacket_DoUpdateCompetitivePointReq req, IDIPPacket_DoUpdateCompetitivePointRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4113;
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
/* 62 */     return new PIDIPCmd_DoUpdateCompetitivePointReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoUpdateCompetitivePointReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */