/*    */ package mzm.gsp.luckybag.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.item.main.LotteryManager;
/*    */ import mzm.gsp.luckybag.SOpenLuckyBagFailed;
/*    */ import mzm.gsp.luckybag.confbean.SLuckyBagCfgConsts;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCOpenLuckyBag extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int instanceid;
/*    */   private final boolean useYuanbao;
/*    */   private final long clientYuanbao;
/*    */   private final long needYuanbao;
/*    */   private final boolean multiple;
/*    */   
/*    */   public PCOpenLuckyBag(long roleid, int instanceid, boolean useYuanbao, long clientYuanbao, long needYuanbao)
/*    */   {
/* 26 */     this(roleid, instanceid, useYuanbao, clientYuanbao, needYuanbao, false);
/*    */   }
/*    */   
/*    */ 
/*    */   public PCOpenLuckyBag(long roleid, int instanceid, boolean useYuanbao, long clientYuanbao, long needYuanbao, boolean multiple)
/*    */   {
/* 32 */     this.roleid = roleid;
/* 33 */     this.instanceid = instanceid;
/* 34 */     this.useYuanbao = useYuanbao;
/* 35 */     this.clientYuanbao = clientYuanbao;
/* 36 */     this.needYuanbao = needYuanbao;
/* 37 */     this.multiple = multiple;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 43 */     if ((this.clientYuanbao < 0L) || (this.needYuanbao < 0L) || (this.instanceid < 0))
/*    */     {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     if (!LuckyBagManager.isFunOpen(this.roleid))
/*    */     {
/* 50 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 54 */     if (!LuckyBagManager.checkRoleStatus(this.roleid))
/*    */     {
/* 56 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 60 */     String userid = RoleInterface.getUserId(this.roleid);
/* 61 */     int activityCfgid = SLuckyBagCfgConsts.getInstance().ACTIVITY_CFG_ID;
/* 62 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, activityCfgid).isCanJoin())
/*    */     {
/* 64 */       onFailed(-4);
/* 65 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 69 */     if (!LotteryManager.canAdd(this.roleid, 6))
/*    */     {
/* 71 */       onFailed(3);
/* 72 */       return false;
/*    */     }
/*    */     
/* 75 */     MapInterface.gatherMapItem(this.roleid, this.instanceid, new LuckyBagGatherContext(this.instanceid, this.useYuanbao, this.clientYuanbao, this.multiple));
/*    */     
/*    */ 
/* 78 */     GameServer.logger().info(String.format("[luckybag]PCOpenLuckyBag.processImp@invoke done|roleid=%d|activity_cfgid=%d|instanceid=%d|use_yuanbao=%b|client_yuanbao=%d|need_yuanbao=%d|multiple=%b", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(activityCfgid), Integer.valueOf(this.instanceid), Boolean.valueOf(this.useYuanbao), Long.valueOf(this.clientYuanbao), Long.valueOf(this.needYuanbao), Boolean.valueOf(this.multiple) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 83 */     return true;
/*    */   }
/*    */   
/*    */   private void onFailed(int retcode)
/*    */   {
/* 88 */     if (retcode < 0)
/*    */     {
/* 90 */       SOpenLuckyBagFailed resp = new SOpenLuckyBagFailed();
/* 91 */       resp.retcode = retcode;
/* 92 */       resp.use_yuanbao = ((byte)(this.useYuanbao ? 1 : 0));
/* 93 */       resp.client_yuanbao = this.clientYuanbao;
/* 94 */       resp.need_yuanbao = this.needYuanbao;
/* 95 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*    */     }
/*    */     
/* 98 */     GameServer.logger().error(String.format("[luckybag]PCOpenLuckyBag.onFailed@open lukcy bag failed|roleid=%d|activity_cfgid=%d|retcode=%d|instanceid=%d|use_yuanbao=%b|client_yuanbao=%d|need_yuanbao=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(SLuckyBagCfgConsts.getInstance().ACTIVITY_CFG_ID), Integer.valueOf(retcode), Integer.valueOf(this.instanceid), Boolean.valueOf(this.useYuanbao), Long.valueOf(this.clientYuanbao), Long.valueOf(this.needYuanbao) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\main\PCOpenLuckyBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */