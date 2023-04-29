/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_QuerySxianLvNumReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_QuerySxianlvNumReq
/*    */   extends IDIPCmd<IDIPPacket_QuerySxianlvNumReq, IDIPPacket_QuerySxianlvNumRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4205;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_QuerySxianlvNumReq, IDIPPacket_QuerySxianlvNumRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_QuerySxianlvNumReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_QuerySxianlvNumReq req, IDIPPacket_QuerySxianlvNumRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_QuerySxianlvNumReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_QuerySxianlvNumReq create()
/*    */   {
/* 33 */     IDIPPacket_QuerySxianlvNumReq req = IDIPPacket_QuerySxianlvNumReq.create();
/* 34 */     IDIPPacket_QuerySxianlvNumRsp rsp = IDIPPacket_QuerySxianlvNumRsp.create();
/* 35 */     return new IDIPCmd_QuerySxianlvNumReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_QuerySxianlvNumReq create(IDIPPacket_QuerySxianlvNumReq req, IDIPPacket_QuerySxianlvNumRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_QuerySxianlvNumReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_QuerySxianlvNumReq(IDIPPacket_QuerySxianlvNumReq req, IDIPPacket_QuerySxianlvNumRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4205;
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
/* 62 */     return new PIDIPCmd_QuerySxianLvNumReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_QuerySxianlvNumReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */