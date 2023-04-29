/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_AqDoRelievePunishReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_AqDoRelievePunishReq
/*    */   extends IDIPCmd<IDIPPacket_AqDoRelievePunishReq, IDIPPacket_AqDoRelievePunishRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4159;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_AqDoRelievePunishReq, IDIPPacket_AqDoRelievePunishRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_AqDoRelievePunishReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_AqDoRelievePunishReq req, IDIPPacket_AqDoRelievePunishRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_AqDoRelievePunishReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_AqDoRelievePunishReq create()
/*    */   {
/* 33 */     IDIPPacket_AqDoRelievePunishReq req = IDIPPacket_AqDoRelievePunishReq.create();
/* 34 */     IDIPPacket_AqDoRelievePunishRsp rsp = IDIPPacket_AqDoRelievePunishRsp.create();
/* 35 */     return new IDIPCmd_AqDoRelievePunishReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_AqDoRelievePunishReq create(IDIPPacket_AqDoRelievePunishReq req, IDIPPacket_AqDoRelievePunishRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_AqDoRelievePunishReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_AqDoRelievePunishReq(IDIPPacket_AqDoRelievePunishReq req, IDIPPacket_AqDoRelievePunishRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4159;
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
/* 62 */     return new PIDIPCmd_AqDoRelievePunishReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_AqDoRelievePunishReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */