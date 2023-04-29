/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.IDIPCmd_QueryRolelistInfoReq;
/*     */ import idip.IDIPPacket_QueryRolelistInfoReq;
/*     */ import idip.IDIPPacket_QueryRolelistInfoRsp;
/*     */ import idip.QueryRolelistInfoReq;
/*     */ import idip.QueryRolelistInfoRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.arena.main.ArenaInterface;
/*     */ import mzm.gsp.bigboss.main.BigbossInterface;
/*     */ import mzm.gsp.chart.main.RankInterface;
/*     */ import mzm.gsp.item.main.ItemGiveManager;
/*     */ import mzm.gsp.jingji.main.JingjiInterface;
/*     */ import mzm.gsp.jiuxiao.main.JiuXiaoRankManager;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PIDIPCmd_QueryRolelistInfoReq extends PIDIPCmd<IDIPCmd_QueryRolelistInfoReq>
/*     */ {
/*     */   public PIDIPCmd_QueryRolelistInfoReq(IDIPCmd_QueryRolelistInfoReq cmd)
/*     */   {
/*  28 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  34 */     String openId = ((QueryRolelistInfoReq)((IDIPPacket_QueryRolelistInfoReq)((IDIPCmd_QueryRolelistInfoReq)this.cmd).req).body).OpenId;
/*  35 */     int areaId = ((QueryRolelistInfoReq)((IDIPPacket_QueryRolelistInfoReq)((IDIPCmd_QueryRolelistInfoReq)this.cmd).req).body).AreaId;
/*  36 */     int partition = ((QueryRolelistInfoReq)((IDIPPacket_QueryRolelistInfoReq)((IDIPCmd_QueryRolelistInfoReq)this.cmd).req).body).Partition;
/*     */     
/*  38 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  39 */     xbean.User xUser = xtable.User.get(userId);
/*  40 */     if (null == xUser)
/*     */     {
/*  42 */       ((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.Result = 1;
/*  43 */       ((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  44 */       ((IDIPCmd_QueryRolelistInfoReq)this.cmd).sendResponse();
/*     */       
/*  46 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRolelistInfoReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryRolelistInfoReq)((IDIPPacket_QueryRolelistInfoReq)((IDIPCmd_QueryRolelistInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryRolelistInfoReq)((IDIPPacket_QueryRolelistInfoReq)((IDIPCmd_QueryRolelistInfoReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  51 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  55 */     if (((QueryRolelistInfoReq)((IDIPPacket_QueryRolelistInfoReq)((IDIPCmd_QueryRolelistInfoReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  57 */       ((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.Result = 1;
/*  58 */       ((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.RetErrMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) });
/*  59 */       ((IDIPCmd_QueryRolelistInfoReq)this.cmd).sendResponse();
/*     */       
/*  61 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRolelistInfoReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryRolelistInfoReq)((IDIPPacket_QueryRolelistInfoReq)((IDIPCmd_QueryRolelistInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryRolelistInfoReq)((IDIPPacket_QueryRolelistInfoReq)((IDIPCmd_QueryRolelistInfoReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  72 */       roleId = Long.parseLong(((QueryRolelistInfoReq)((IDIPPacket_QueryRolelistInfoReq)((IDIPCmd_QueryRolelistInfoReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  76 */       ((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.Result = 1;
/*  77 */       ((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.RetErrMsg = "roleid format error";
/*  78 */       ((IDIPCmd_QueryRolelistInfoReq)this.cmd).sendResponse();
/*     */       
/*  80 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRolelistInfoReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((QueryRolelistInfoReq)((IDIPPacket_QueryRolelistInfoReq)((IDIPCmd_QueryRolelistInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryRolelistInfoReq)((IDIPPacket_QueryRolelistInfoReq)((IDIPCmd_QueryRolelistInfoReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  90 */       ((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.Result = 1;
/*  91 */       ((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  92 */       ((IDIPCmd_QueryRolelistInfoReq)this.cmd).sendResponse();
/*     */       
/*  94 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRolelistInfoReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((QueryRolelistInfoReq)((IDIPPacket_QueryRolelistInfoReq)((IDIPCmd_QueryRolelistInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryRolelistInfoReq)((IDIPPacket_QueryRolelistInfoReq)((IDIPCmd_QueryRolelistInfoReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  99 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 103 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleId)));
/*     */     
/* 105 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).FightRank = RankInterface.getMaxRank(roleId, 0);
/* 106 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).FightScore = RoleInterface.getFightValue(roleId);
/*     */     
/*     */ 
/* 109 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).LevelRank = RankInterface.getMaxRank(roleId, 2);
/* 110 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).LevelScore = RoleInterface.getLevel(roleId);
/*     */     
/*     */ 
/* 113 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).EvilRank = RankInterface.getMaxRank(roleId, 1);
/* 114 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).EvilScore = getPetYaoLi(roleId);
/*     */     
/*     */ 
/* 117 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).CompetitiveRank = RankInterface.getMaxRank(roleId, 3);
/* 118 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).CompetitiveScore = JingjiInterface.getWinpoint(roleId, false);
/*     */     
/*     */ 
/* 121 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).ExamRank = RankInterface.getMaxRank(roleId, 4);
/* 122 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).ExamScore = mzm.gsp.question.main.QuestionInterface.getDianshiUsetime(roleId);
/*     */     
/*     */ 
/* 125 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).WushuRank = RankInterface.getMaxRank(roleId, 7);
/* 126 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).WushuScore = ArenaInterface.getScore(userId, roleId, false);
/*     */     
/*     */ 
/* 129 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).BossRank = RankInterface.getMaxRank(roleId, IdipManager.getBigBossChartType(roleId));
/* 130 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).BossScore = BigbossInterface.getDamagePoint(roleId);
/*     */     
/*     */ 
/* 133 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).BattleRank = RankInterface.getMaxRank(roleId, 9);
/* 134 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).BattleScore = JiuXiaoRankManager.getInstance().getRankLayer(roleId, 9);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 139 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).FlowerRank = RankInterface.getMaxRank(roleId, 6);
/* 140 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).FlowerScore = ItemGiveManager.getReceiveFlowerPoint(roleId, true);
/*     */     
/*     */ 
/* 143 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).BloomRank = RankInterface.getMaxRank(roleId, 5);
/* 144 */     ((QueryRolelistInfoRsp)((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).body).BloomScore = ItemGiveManager.getGiveFlowerPoint(roleId, true);
/*     */     
/* 146 */     ((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.Result = 0;
/* 147 */     ((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 148 */     ((IDIPCmd_QueryRolelistInfoReq)this.cmd).sendResponse();
/*     */     
/* 150 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryRolelistInfoReq.handle@query role list done|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRolelistInfoRsp)((IDIPCmd_QueryRolelistInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryRolelistInfoReq)((IDIPPacket_QueryRolelistInfoReq)((IDIPCmd_QueryRolelistInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryRolelistInfoReq)((IDIPPacket_QueryRolelistInfoReq)((IDIPCmd_QueryRolelistInfoReq)this.cmd).req).body).RoleId }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 156 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getPetYaoLi(long roleId)
/*     */   {
/* 167 */     Map<Long, Integer> petYaoLis = PetInterface.getPetYaoliMap(roleId);
/* 168 */     if (petYaoLis.size() == 0)
/*     */     {
/* 170 */       return 0;
/*     */     }
/* 172 */     int result = 0;
/* 173 */     for (Integer yaoLi : petYaoLis.values())
/*     */     {
/* 175 */       if (yaoLi.intValue() > result)
/*     */       {
/* 177 */         result = yaoLi.intValue();
/*     */       }
/*     */     }
/* 180 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QueryRolelistInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */