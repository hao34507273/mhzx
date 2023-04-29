/*     */ package mzm.gsp.husong.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.SHuSongRes;
/*     */ import mzm.gsp.activity.confbean.SHuSongCfg;
/*     */ import mzm.gsp.activity.confbean.SHuSongConst;
/*     */ import mzm.gsp.activity.confbean.SHuSongMoneyCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HuSongDataBean;
/*     */ import xtable.Role2husong;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCHuSongReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int husongType;
/*     */   
/*     */   public PCHuSongReq(long roleid, int husongtype)
/*     */   {
/*  37 */     this.roleid = roleid;
/*  38 */     this.husongType = husongtype;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if ((!OpenInterface.getOpenStatus(5)) || (OpenInterface.isBanPlay(this.roleid, 5)))
/*     */     {
/*     */ 
/*  47 */       OpenInterface.sendBanPlayMsg(this.roleid, 5);
/*  48 */       return false;
/*     */     }
/*  50 */     List<Long> roleList = new ArrayList();
/*  51 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleid);
/*  52 */     if (teamInfo != null)
/*     */     {
/*  54 */       roleList.addAll(teamInfo.getTeamMemberList());
/*     */     }
/*     */     else
/*     */     {
/*  58 */       roleList.add(Long.valueOf(this.roleid));
/*     */     }
/*  60 */     Map<Long, String> roleie2userid = new HashMap();
/*  61 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */       
/*  63 */       roleie2userid.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/*  66 */     lock(User.getTable(), roleie2userid.values());
/*     */     
/*  68 */     lock(Role2husong.getTable(), roleie2userid.keySet());
/*     */     
/*  70 */     switch (this.husongType)
/*     */     {
/*     */     case 1: 
/*  73 */       if (!NpcInterface.checkNpcService(SHuSongConst.getInstance().npcid, 150205052, this.roleid))
/*     */       {
/*  75 */         if (GameServer.logger().isDebugEnabled())
/*     */         {
/*  77 */           GameServer.logger().debug("护送普通类型的服务不可用!!");
/*     */         }
/*  79 */         return false;
/*     */       }
/*  81 */       ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(roleie2userid, roleList, SHuSongConst.getInstance().activity);
/*     */       
/*  83 */       if (!activityJoinResult.isCanJoin())
/*     */       {
/*  85 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     case 2: 
/*  90 */       if (!NpcInterface.checkNpcService(SHuSongConst.getInstance().npcid, 150205052, this.roleid))
/*     */       {
/*  92 */         if (GameServer.logger().isDebugEnabled())
/*     */         {
/*  94 */           GameServer.logger().debug("护送特殊类型的服务不可用!!");
/*     */         }
/*  96 */         return false;
/*     */       }
/*  98 */       ActivityJoinResult activityJoinResult2 = ActivityInterface.canJoinAndCheckInitActivityData(roleie2userid, roleList, SHuSongConst.getInstance().activity);
/*     */       
/* 100 */       if ((!activityJoinResult2.isCanJoin()) && (!activityJoinResult2.isActivityJoinCountMax()))
/*     */       {
/* 102 */         GameServer.logger().info(String.format("[Husong]PCHuSongReq.processImp@can not husong|roleid=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(activityJoinResult2.getReasonValue()) }));
/* 103 */         return false;
/*     */       }
/* 105 */       if (!ActivityInterface.isToMaxCount((String)roleie2userid.get(Long.valueOf(this.roleid)), this.roleid, SHuSongConst.getInstance().activity))
/*     */       {
/* 107 */         if (GameServer.logger().isDebugEnabled()) {
/* 108 */           GameServer.logger().debug("普通护送类型没有达到最大次数!!!");
/*     */         }
/* 110 */         return false;
/*     */       }
/* 112 */       Integer specialCount = Role2husong.selectSpecialcount(Long.valueOf(this.roleid));
/* 113 */       if ((specialCount != null) && (specialCount.intValue() >= SHuSongConst.getInstance().specialNum))
/*     */       {
/* 115 */         if (GameServer.logger().isDebugEnabled())
/*     */         {
/* 117 */           GameServer.logger().debug("护送已经到达最大次数了!!");
/*     */         }
/* 119 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     default: 
/* 124 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 126 */         GameServer.logger().debug("不存在的护送类型");
/*     */       }
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     HuSongDataBean xHuSongDataBean = Role2husong.get(Long.valueOf(this.roleid));
/* 132 */     if (xHuSongDataBean == null)
/*     */     {
/* 134 */       xHuSongDataBean = xbean.Pod.newHuSongDataBean();
/* 135 */       Role2husong.insert(Long.valueOf(this.roleid), xHuSongDataBean);
/*     */     }
/* 137 */     SHuSongMoneyCfg huSongMoneyCfg = HuSongCfgManager.getHuSongMoneyCfgByLevelType(RoleInterface.getLevel(this.roleid), this.husongType);
/*     */     
/* 139 */     long silver = RoleInterface.getSilver(this.roleid);
/* 140 */     if (silver < huSongMoneyCfg.needSilver)
/*     */     {
/* 142 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 144 */         GameServer.logger().debug("金钱数目不足!!");
/*     */       }
/* 146 */       return false;
/*     */     }
/*     */     
/* 149 */     if (HuSongManager.containsHuSong(this.roleid))
/*     */     {
/* 151 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 153 */         GameServer.logger().debug("在护送中 不能再次护送");
/*     */       }
/* 155 */       return false;
/*     */     }
/* 157 */     if (!HuSongManager.setRoleHuSongStatus(this.roleid, this.husongType))
/*     */     {
/*     */ 
/* 160 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 162 */         GameServer.logger().debug("设置护送状态失败");
/*     */       }
/* 164 */       return false;
/*     */     }
/*     */     
/* 167 */     SHuSongCfg huSongCfg = HuSongCfgManager.randomHuSongCfg(this.husongType);
/*     */     
/* 169 */     RoleInterface.cutSilver(this.roleid, huSongMoneyCfg.needSilver, new TLogArg(LogReason.HUSONG_ACTIVITY_REM, this.husongType));
/*     */     
/*     */ 
/* 172 */     xHuSongDataBean.getParammap().clear();
/*     */     
/* 174 */     xHuSongDataBean.getParammap().put(Integer.valueOf(1), Integer.valueOf(huSongCfg.id));
/* 175 */     xHuSongDataBean.getParammap().put(Integer.valueOf(2), Integer.valueOf(huSongMoneyCfg.id));
/*     */     
/*     */ 
/* 178 */     if (SHuSongConst.getInstance().maxFightNum > 0)
/*     */     {
/* 180 */       int interval = HuSongCfgManager.getHusongFightSec();
/* 181 */       HuSongFightSession huSongFightSession = new HuSongFightSession(interval, this.roleid, huSongCfg.id);
/* 182 */       long sessionid = huSongFightSession.getSessionId();
/* 183 */       int high = CommonUtils.getLongHigh(sessionid);
/* 184 */       int low = CommonUtils.getLongLow(sessionid);
/* 185 */       xHuSongDataBean.getParammap().put(Integer.valueOf(6), Integer.valueOf(high));
/* 186 */       xHuSongDataBean.getParammap().put(Integer.valueOf(5), Integer.valueOf(low));
/*     */     }
/*     */     
/* 189 */     int husongCoupleNpcCfgid = HuSongManager.getHusongCoupleNpcCfgidAndSetMapRoleHuSongState(this.roleid, huSongCfg);
/*     */     
/* 191 */     SHuSongRes huSongRes = new SHuSongRes();
/* 192 */     huSongRes.husongcfgid = huSongCfg.id;
/* 193 */     huSongRes.husong_couple_npc_cfgid = husongCoupleNpcCfgid;
/* 194 */     OnlineManager.getInstance().send(this.roleid, huSongRes);
/*     */     
/* 196 */     ActivityInterface.logActivity(this.roleid, SHuSongConst.getInstance().activity, ActivityLogStatus.ATTEND);
/* 197 */     ActivityInterface.tlogActivity(this.roleid, SHuSongConst.getInstance().activity, ActivityLogStatus.ATTEND);
/*     */     
/* 199 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\husong\main\PCHuSongReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */