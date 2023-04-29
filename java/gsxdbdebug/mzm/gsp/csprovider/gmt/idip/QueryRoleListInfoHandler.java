/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.QueryRolelistInfoRsp;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.arena.main.ArenaInterface;
/*     */ import mzm.gsp.bigboss.main.BigbossInterface;
/*     */ import mzm.gsp.chart.main.RankInterface;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.idip.main.IdipInterface;
/*     */ import mzm.gsp.item.main.ItemGiveManager;
/*     */ import mzm.gsp.jingji.main.JingjiInterface;
/*     */ import mzm.gsp.jiuxiao.main.JiuXiaoRankManager;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.question.main.QuestionInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class QueryRoleListInfoHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  30 */     String userid = (String)params.get(0);
/*  31 */     long roleid = Long.parseLong((String)params.get(1));
/*     */     
/*  33 */     xbean.User xUser = xtable.User.get(userid);
/*  34 */     if (null == xUser)
/*     */     {
/*  36 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  37 */       rsp.retcode = retcode;
/*  38 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  39 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  41 */       GameServer.logger().error(String.format("[gmt]QueryRoleListInfoHandler.execute@user not found|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*     */       
/*  43 */       return;
/*     */     }
/*     */     
/*  46 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  48 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  49 */       rsp.retcode = retcode;
/*  50 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  51 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  53 */       GameServer.logger().error(String.format("[gmt]QueryRoleListInfoHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid) }));
/*     */       
/*     */ 
/*  56 */       return;
/*     */     }
/*     */     
/*     */ 
/*  60 */     Lockeys.lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*     */     
/*  62 */     QueryRolelistInfoRsp queryRolelistInfoRsp = new QueryRolelistInfoRsp();
/*     */     
/*  64 */     queryRolelistInfoRsp.FightRank = RankInterface.getMaxRank(roleid, 0);
/*  65 */     queryRolelistInfoRsp.FightScore = RoleInterface.getFightValue(roleid);
/*     */     
/*     */ 
/*  68 */     queryRolelistInfoRsp.LevelRank = RankInterface.getMaxRank(roleid, 2);
/*  69 */     queryRolelistInfoRsp.LevelScore = RoleInterface.getLevel(roleid);
/*     */     
/*     */ 
/*  72 */     queryRolelistInfoRsp.EvilRank = RankInterface.getMaxRank(roleid, 1);
/*  73 */     queryRolelistInfoRsp.EvilScore = getPetYaoLi(roleid);
/*     */     
/*     */ 
/*  76 */     queryRolelistInfoRsp.CompetitiveRank = RankInterface.getMaxRank(roleid, 3);
/*  77 */     queryRolelistInfoRsp.CompetitiveScore = JingjiInterface.getWinpoint(roleid, false);
/*     */     
/*     */ 
/*  80 */     queryRolelistInfoRsp.ExamRank = RankInterface.getMaxRank(roleid, 4);
/*  81 */     queryRolelistInfoRsp.ExamScore = QuestionInterface.getDianshiUsetime(roleid);
/*     */     
/*     */ 
/*  84 */     queryRolelistInfoRsp.WushuRank = RankInterface.getMaxRank(roleid, 7);
/*  85 */     queryRolelistInfoRsp.WushuScore = ArenaInterface.getScore(userid, roleid, false);
/*     */     
/*     */ 
/*  88 */     queryRolelistInfoRsp.BossRank = RankInterface.getMaxRank(roleid, IdipInterface.getBigBossChartType(roleid));
/*  89 */     queryRolelistInfoRsp.BossScore = BigbossInterface.getDamagePoint(roleid);
/*     */     
/*     */ 
/*  92 */     queryRolelistInfoRsp.BattleRank = RankInterface.getMaxRank(roleid, 9);
/*  93 */     queryRolelistInfoRsp.BattleScore = JiuXiaoRankManager.getInstance().getRankLayer(roleid, 9);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  98 */     queryRolelistInfoRsp.FlowerRank = RankInterface.getMaxRank(roleid, 6);
/*  99 */     queryRolelistInfoRsp.FlowerScore = ItemGiveManager.getReceiveFlowerPoint(roleid, true);
/*     */     
/*     */ 
/* 102 */     queryRolelistInfoRsp.BloomRank = RankInterface.getMaxRank(roleid, 5);
/* 103 */     queryRolelistInfoRsp.BloomScore = ItemGiveManager.getGiveFlowerPoint(roleid, true);
/*     */     
/* 105 */     rsp.retcode = Retcode.SUCCESS.value;
/* 106 */     Response response = new Response();
/* 107 */     response.data = queryRolelistInfoRsp;
/* 108 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 110 */     GameServer.logger().info(String.format("[gmt]QueryRoleListInfoHandler.execute@query role list done|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getPetYaoLi(long roleId)
/*     */   {
/* 122 */     Map<Long, Integer> petYaoLis = PetInterface.getPetYaoliMap(roleId);
/* 123 */     if (petYaoLis.size() == 0)
/*     */     {
/* 125 */       return 0;
/*     */     }
/* 127 */     int result = 0;
/* 128 */     for (Integer yaoLi : petYaoLis.values())
/*     */     {
/* 130 */       if (yaoLi.intValue() > result)
/*     */       {
/* 132 */         result = yaoLi.intValue();
/*     */       }
/*     */     }
/* 135 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\QueryRoleListInfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */