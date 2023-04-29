/*     */ package mzm.gsp.children.guanyin;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.children.SAttendGuanYinShangGongFail;
/*     */ import mzm.gsp.children.confbean.GuanYinConsts;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.homeland.main.HomeInfoWrapper;
/*     */ import mzm.gsp.homeland.main.HomeServiceChecker;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shanggong.main.ShangGongInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAttendGuanYinShangGong
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCAttendGuanYinShangGong(long roleid)
/*     */   {
/*  34 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!GuanYinManager.isGuanYinShangGongSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  43 */       onFail(-1, null);
/*  44 */       return false;
/*     */     }
/*  46 */     if (!GuanYinManager.checkRoleStatus(this.roleid, 731))
/*     */     {
/*     */ 
/*  49 */       onFail(-2, null);
/*  50 */       return false;
/*     */     }
/*  52 */     HomeInfoWrapper homeInfoWrapper = HomelandInterface.getHomeInfoWrapper(this.roleid, false);
/*  53 */     if (homeInfoWrapper == null)
/*     */     {
/*     */ 
/*  56 */       onFail(-3, null);
/*  57 */       return false;
/*     */     }
/*  59 */     if (!NpcInterface.checkNpcService(this.roleid, SChildrenConsts.getInstance().pregnant_npc_service_id, HomelandInterface.getMaidNpc(homeInfoWrapper), new HomeServiceChecker(this.roleid, homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid())))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  64 */       onFail(-3, null);
/*  65 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  69 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*     */ 
/*  72 */       onFail(1, null);
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  78 */     long partnerid = MarriageInterface.getMarriedRoleid(this.roleid);
/*  79 */     if (partnerid < 0L)
/*     */     {
/*     */ 
/*  82 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/*  84 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     }
/*     */     else
/*     */     {
/*  88 */       String partnerUserid = RoleInterface.getUserId(partnerid);
/*     */       
/*  90 */       lock(User.getTable(), Arrays.asList(new String[] { userid, partnerUserid }));
/*     */       
/*  92 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(partnerid) }));
/*     */     }
/*     */     
/*     */ 
/*  96 */     int currentPoint = ChildrenInterface.isCanSignalBreed(this.roleid, true);
/*  97 */     if (currentPoint < 0)
/*     */     {
/*     */ 
/* 100 */       onFail(2, null);
/* 101 */       return false;
/*     */     }
/* 103 */     if (currentPoint >= GuanYinConsts.getInstance().POINT_UPPER_LIMIT)
/*     */     {
/*     */ 
/* 106 */       onFail(4, null);
/* 107 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 111 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, GuanYinConsts.getInstance().SHANGGONG_ACTIVITY_CFG_ID);
/*     */     
/* 113 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/* 116 */       Map<String, Object> extraInfo = new HashMap();
/* 117 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 118 */       onFail(5, extraInfo);
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     if (!ShangGongInterface.startShangGongSyn(this.roleid, GuanYinConsts.getInstance().SHANGGONG_ID))
/*     */     {
/*     */ 
/* 125 */       onFail(6, null);
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     StringBuilder sb = new StringBuilder();
/* 130 */     sb.append(String.format("[guanyin]PCAttendGuanYinShangGong.processImp@attend guan yin shang gong success|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */     
/* 132 */     GuanYinManager.logger.info(sb.toString());
/* 133 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 138 */     StringBuilder sb = new StringBuilder();
/* 139 */     sb.append(String.format("[guanyin]PCAttendGuanYinShangGong.processImp@attend guan yin shang gong fail|roleid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 142 */     if (extraInfo != null)
/*     */     {
/* 144 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 146 */         sb.append("|").append((String)entry.getKey());
/* 147 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 150 */     GuanYinManager.logger.info(sb.toString());
/* 151 */     if (res > 0)
/*     */     {
/* 153 */       SAttendGuanYinShangGongFail protocol = new SAttendGuanYinShangGongFail();
/* 154 */       protocol.res = res;
/* 155 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\guanyin\PCAttendGuanYinShangGong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */