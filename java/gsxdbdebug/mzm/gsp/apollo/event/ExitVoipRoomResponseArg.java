/*     */ package mzm.gsp.apollo.event;
/*     */ 
/*     */ import apollo.ApolloExitVoipRoomRsp;
/*     */ 
/*     */ public class ExitVoipRoomResponseArg
/*     */ {
/*     */   private final ApolloExitVoipRoomRsp rsp;
/*     */   
/*     */   public ExitVoipRoomResponseArg(ApolloExitVoipRoomRsp rsp)
/*     */   {
/*  11 */     this.rsp = rsp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSucceed()
/*     */   {
/*  21 */     return this.rsp.retcode == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRetcode()
/*     */   {
/*  31 */     return this.rsp.retcode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUserid()
/*     */   {
/*  41 */     return this.rsp.account.getString("UTF-8");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/*  51 */     return this.rsp.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRoomid()
/*     */   {
/*  61 */     return this.rsp.room_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getMemberid()
/*     */   {
/*  71 */     return this.rsp.member_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getMemberCountAfterExit()
/*     */   {
/*  81 */     return this.rsp.member_count_after_exit;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUserOpenid()
/*     */   {
/*  91 */     return this.rsp.user_open_id.getString("UTF-8");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public com.goldhuman.Common.Octets getUserOpenidOctets()
/*     */   {
/* 101 */     return this.rsp.user_open_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public com.goldhuman.Common.Octets getContext()
/*     */   {
/* 111 */     return this.rsp.async_data;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\event\ExitVoipRoomResponseArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */