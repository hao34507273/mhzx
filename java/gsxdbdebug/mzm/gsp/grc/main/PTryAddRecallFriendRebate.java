/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.grc.confbean.SRecallFriendConsts;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PTryAddRecallFriendRebate
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final String userid;
/*    */   private final long saveAmt;
/*    */   
/*    */   public PTryAddRecallFriendRebate(String userid, long saveAmt)
/*    */   {
/* 19 */     this.userid = userid;
/* 20 */     this.saveAmt = saveAmt;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!OpenInterface.getOpenStatus(515))
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     int rebate = (int)(this.saveAmt * SRecallFriendConsts.getInstance().RECHARGE_REBATE_PERCENT / 100L);
/* 32 */     if (rebate <= 0)
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 39 */     String openid = CommonUtils.getOpenId(this.userid);
/* 40 */     long serialNo = RecallFriendManager.getSerialNo();
/* 41 */     OctetsStream osContext = new OctetsStream();
/* 42 */     osContext.marshal(1);
/* 43 */     if (!GrcManager.recallRechargeRebate(openid, rebate, serialNo, SRecallFriendConsts.getInstance().YUAN_BAO_POLL_MAX, SRecallFriendConsts.getInstance().RECHARGE_REBATE_MAX, osContext))
/*    */     {
/*    */ 
/* 46 */       GameServer.logger().error(String.format("[recall]PTryAddRecallFriendRebate.processImp@send msg failed|userid=%s|openid=%s|rebate=%d|serial=%d", new Object[] { this.userid, openid, Integer.valueOf(rebate), Long.valueOf(serialNo) }));
/*    */       
/*    */ 
/*    */ 
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     GameServer.logger().info(String.format("[recall]PTryAddRecallFriendRebate.processImp@send msg success|userid=%s|openid=%s|rebate=%d|serial=%d", new Object[] { this.userid, openid, Integer.valueOf(rebate), Long.valueOf(serialNo) }));
/*    */     
/*    */ 
/*    */ 
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PTryAddRecallFriendRebate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */