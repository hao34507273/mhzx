/*     */ package mzm.gsp.apollo.event;
/*     */ 
/*     */ import apollo.ApolloJoinVoipRoomRsp;
/*     */ import apollo.VoipRoomUserAccess;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class JoinVoipRoomResponseArg
/*     */ {
/*     */   private final ApolloJoinVoipRoomRsp rsp;
/*     */   
/*     */   public JoinVoipRoomResponseArg(ApolloJoinVoipRoomRsp rsp)
/*     */   {
/*  15 */     this.rsp = rsp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSucceed()
/*     */   {
/*  25 */     return this.rsp.retcode == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRetcode()
/*     */   {
/*  35 */     return this.rsp.retcode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUserid()
/*     */   {
/*  45 */     return this.rsp.account.getString("UTF-8");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/*  55 */     return this.rsp.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRoomid()
/*     */   {
/*  65 */     return this.rsp.room_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOpenid()
/*     */   {
/*  75 */     return this.rsp.user_access.open_id.getString("UTF-8");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Octets getOpenidOctets()
/*     */   {
/*  85 */     return this.rsp.user_access.open_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getMemberid()
/*     */   {
/*  95 */     return this.rsp.user_access.member_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRoomKey()
/*     */   {
/* 105 */     return this.rsp.user_access.room_key;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getExtraData()
/*     */   {
/* 115 */     return this.rsp.user_access.extra_data;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<String> getAccessIPList()
/*     */   {
/* 126 */     List<Octets> ipList = this.rsp.user_access.access_ip_list;
/* 127 */     if (ipList.isEmpty())
/*     */     {
/* 129 */       return null;
/*     */     }
/* 131 */     List<String> retIPList = new java.util.ArrayList();
/* 132 */     for (Octets accessIP : ipList)
/*     */     {
/* 134 */       retIPList.add(accessIP.getString("UTF-8"));
/*     */     }
/* 136 */     return retIPList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public LinkedList<Octets> getAccessIPOctetsList()
/*     */   {
/* 147 */     LinkedList<Octets> ipList = this.rsp.user_access.access_ip_list;
/* 148 */     if (ipList.isEmpty())
/*     */     {
/* 150 */       return null;
/*     */     }
/*     */     
/* 153 */     return ipList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Octets getContext()
/*     */   {
/* 163 */     return this.rsp.async_data;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\event\JoinVoipRoomResponseArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */