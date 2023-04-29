/*     */ package mzm.gsp.grc.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.grc.SGetBindRewardFailed;
/*     */ import mzm.gsp.grc.confbean.SRecallFriendConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PCGetBindReward
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final String friendOpenid;
/*     */   private final int bindType;
/*     */   
/*     */   public PCGetBindReward(long roleid, String friendOpenid, int bindType)
/*     */   {
/*  26 */     this.roleid = roleid;
/*  27 */     this.friendOpenid = friendOpenid;
/*  28 */     this.bindType = bindType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if ((this.friendOpenid.isEmpty()) || ((this.bindType != 0) && (this.bindType != 1)))
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     if (!RecallFriendManager.canDoAction(this.roleid, 1935))
/*     */     {
/*  41 */       onFailed(5);
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!RecallFriendManager.isBindFriendFunOpen(this.roleid, true))
/*     */     {
/*  47 */       onFailed(4);
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     String userid = RoleInterface.getUserId(this.roleid);
/*  52 */     String openid = CommonUtils.getOpenId(userid);
/*  53 */     long serialNo = RecallFriendManager.getSerialNo();
/*  54 */     GetVitalityRewardContext rewardContext = new GetVitalityRewardContext();
/*  55 */     rewardContext.count = 1;
/*  56 */     rewardContext.roleid = this.roleid;
/*  57 */     OctetsStream osContext = new OctetsStream();
/*  58 */     rewardContext.marshal(osContext);
/*  59 */     if (!GrcManager.getBindReward(openid, this.friendOpenid, this.bindType, serialNo, SRecallFriendConsts.getInstance().BIND_VITALITY, osContext))
/*     */     {
/*     */ 
/*  62 */       onFailed(-7);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     GameServer.logger().info(String.format("[grc]PCGetBindReward.processImp@success|openid=%s|friend_openid=%s|roleid=%d|serial=%d|bind_type=%d", new Object[] { openid, this.friendOpenid, Long.valueOf(this.roleid), Long.valueOf(serialNo), Integer.valueOf(this.bindType) }));
/*     */     
/*     */ 
/*     */ 
/*  70 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/*  75 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extras)
/*     */   {
/*  80 */     StringBuilder log = new StringBuilder();
/*  81 */     log.append("[recall]PCGetBindReward.onFailed@get bind award failed");
/*  82 */     log.append("|retcode=").append(retcode);
/*  83 */     log.append("|roleid=").append(this.roleid);
/*  84 */     log.append("|friend_openid=").append(this.friendOpenid);
/*  85 */     log.append("|bind_type=").append(this.bindType);
/*  86 */     if ((extras != null) && (!extras.isEmpty()))
/*     */     {
/*  88 */       for (Map.Entry<String, ?> entry : extras.entrySet())
/*     */       {
/*  90 */         log.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/*  93 */     GameServer.logger().error(log.toString());
/*     */     
/*  95 */     SGetBindRewardFailed msg = new SGetBindRewardFailed();
/*  96 */     msg.retcode = retcode;
/*  97 */     msg.bind_type = this.bindType;
/*     */     try
/*     */     {
/* 100 */       msg.open_id.setString(this.friendOpenid, "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/* 105 */     OnlineManager.getInstance().sendAtOnce(this.roleid, msg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGetBindReward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */