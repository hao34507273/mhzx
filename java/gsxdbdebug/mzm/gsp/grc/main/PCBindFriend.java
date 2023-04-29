/*     */ package mzm.gsp.grc.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.grc.SBindFriendFailed;
/*     */ import mzm.gsp.grc.confbean.SRecallFriendConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PCBindFriend
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final String friendOpenid;
/*     */   
/*     */   public PCBindFriend(long roleid, String friendOpenid)
/*     */   {
/*  25 */     this.roleid = roleid;
/*  26 */     this.friendOpenid = friendOpenid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (this.friendOpenid.isEmpty())
/*     */     {
/*  34 */       return false;
/*     */     }
/*     */     
/*  37 */     if (!RecallFriendManager.canDoAction(this.roleid, 1932))
/*     */     {
/*  39 */       onFailed(5);
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!RecallFriendManager.isBindFriendFunOpen(this.roleid, true))
/*     */     {
/*  45 */       onFailed(4);
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     String userid = RoleInterface.getUserId(this.roleid);
/*  50 */     String openid = CommonUtils.getOpenId(userid);
/*     */     
/*  52 */     OctetsStream osContext = new OctetsStream();
/*  53 */     BindFriendContext context = new BindFriendContext();
/*  54 */     context.count = 1;
/*  55 */     context.roleid = this.roleid;
/*  56 */     context.marshal(osContext);
/*     */     
/*  58 */     int bindPeriodInHour = SRecallFriendConsts.getInstance().BIND_PERIOD_IN_HOUR;
/*  59 */     int bindFriendNum = SRecallFriendConsts.getInstance().BIND_FRIEND_NUM;
/*  60 */     int beBindFriendNum = SRecallFriendConsts.getInstance().BE_BIND_FRIEND_NUM;
/*     */     
/*  62 */     long serialNo = RecallFriendManager.getSerialNo();
/*  63 */     if (!GrcManager.bindFriend(openid, this.friendOpenid, serialNo, bindPeriodInHour, bindFriendNum, beBindFriendNum, osContext))
/*     */     {
/*     */ 
/*  66 */       onFailed(-7);
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     GameServer.logger().info(String.format("[recall]PCBindFriend.processImp@send bind friend|roleid=%d|openid=%s|friend_openid=%s|serial=%d", new Object[] { Long.valueOf(this.roleid), openid, this.friendOpenid, Long.valueOf(serialNo) }));
/*     */     
/*     */ 
/*     */ 
/*  74 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int retcode)
/*     */   {
/*  85 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int retcode, Map<String, Object> extras)
/*     */   {
/*  98 */     StringBuilder log = new StringBuilder();
/*  99 */     log.append("[recall]PCBindFriend.onFailed@bind friend failed");
/* 100 */     log.append("|retcode=").append(retcode);
/* 101 */     log.append("|roleid=").append(this.roleid);
/* 102 */     log.append("|friend_openid=").append(this.friendOpenid);
/* 103 */     if ((extras != null) && (!extras.isEmpty()))
/*     */     {
/* 105 */       for (Map.Entry<String, ?> entry : extras.entrySet())
/*     */       {
/* 107 */         log.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 110 */     GameServer.logger().error(log.toString());
/*     */     
/* 112 */     SBindFriendFailed msg = new SBindFriendFailed();
/* 113 */     msg.retcode = retcode;
/*     */     try
/*     */     {
/* 116 */       msg.open_id.setString(this.friendOpenid, "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/* 121 */     OnlineManager.getInstance().sendAtOnce(this.roleid, msg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCBindFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */