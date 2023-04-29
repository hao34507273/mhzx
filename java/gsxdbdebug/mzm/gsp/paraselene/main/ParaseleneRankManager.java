/*     */ package mzm.gsp.paraselene.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.main.RankDBManager;
/*     */ import mzm.gsp.chart.main.RoleKeyRankManagerNew;
/*     */ import mzm.gsp.paraselene.confbean.SParaseleneCfgConsts;
/*     */ import xbean.Paraselene;
/*     */ import xbean.ParaseleneRank;
/*     */ import xbean.ParaseleneRankRole;
/*     */ import xtable.Paraselenerank;
/*     */ import xtable.Role2paraselene;
/*     */ 
/*     */ public class ParaseleneRankManager extends RoleKeyRankManagerNew<ParaseleneRankObj>
/*     */ {
/*     */   private static ParaseleneRankManager instance;
/*     */   
/*     */   private ParaseleneRankManager(int charttype)
/*     */   {
/*  21 */     super(charttype);
/*     */   }
/*     */   
/*     */   static ParaseleneRankManager getInstance()
/*     */   {
/*  26 */     return instance;
/*     */   }
/*     */   
/*     */   static void init()
/*     */   {
/*  31 */     if (instance != null)
/*     */     {
/*  33 */       return;
/*     */     }
/*     */     
/*     */ 
/*  37 */     instance = new ParaseleneRankManager(10);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void saveToDB()
/*     */   {
/*  45 */     long endTime = mzm.gsp.activity.main.ActivityInterface.getActivityEndTime(SParaseleneCfgConsts.getInstance().ActivityId);
/*  46 */     if (endTime <= 0L)
/*     */     {
/*  48 */       return;
/*     */     }
/*  50 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  51 */     if (curTime > endTime + RankDBManager.getInstance().getSaveDbIntervalSec() * 1000)
/*     */     {
/*  53 */       return;
/*     */     }
/*     */     
/*  56 */     List<ParaseleneRankObj> rankObjs = getAllChartObjs();
/*  57 */     ParaseleneRank paraseleneRank = Paraselenerank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  58 */     if (paraseleneRank != null)
/*     */     {
/*  60 */       paraseleneRank.getRanklist().clear();
/*     */     }
/*     */     else
/*     */     {
/*  64 */       paraseleneRank = xbean.Pod.newParaseleneRank();
/*  65 */       Paraselenerank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), paraseleneRank);
/*     */     }
/*  67 */     for (ParaseleneRankObj obj : rankObjs)
/*     */     {
/*  69 */       ParaseleneRankRole paraseleneRankRole = xbean.Pod.newParaseleneRankRole();
/*  70 */       paraseleneRankRole.setRoleid(obj.getKey().longValue());
/*     */       
/*  72 */       paraseleneRank.getRanklist().add(paraseleneRankRole);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void rankDataFromDB()
/*     */   {
/*  80 */     ParaseleneRank paraseleneRank = Paraselenerank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  81 */     if (paraseleneRank != null)
/*     */     {
/*  83 */       for (ParaseleneRankRole rankRole : paraseleneRank.getRanklist())
/*     */       {
/*  85 */         long roleid = rankRole.getRoleid();
/*  86 */         if (mzm.gsp.role.main.RoleInterface.isRoleRealDel(roleid))
/*     */         {
/*  88 */           ParaseleneManager.logger.info(String.format("[paraselene]ParaseleneRankManager.rankDataFromDB@ role is deleted!|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */         }
/*     */         else
/*     */         {
/*  92 */           Paraselene paraselene = Role2paraselene.select(Long.valueOf(roleid));
/*  93 */           if (paraselene != null)
/*     */           {
/*     */ 
/*     */ 
/*  97 */             ParaseleneRankObj rankObj = new ParaseleneRankObj(roleid, (int)TimeUnit.MILLISECONDS.toSeconds(paraselene.getFinishtime() - paraselene.getStarttime()));
/*     */             
/*     */ 
/*     */ 
/* 101 */             getInstance().rank(rankObj);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void clear()
/*     */   {
/* 112 */     ParaseleneRank roleBossRank = Paraselenerank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 113 */     if (roleBossRank != null)
/*     */     {
/* 115 */       roleBossRank.getRanklist().clear();
/*     */     }
/* 117 */     super.clear();
/*     */   }
/*     */   
/*     */ 
/*     */   public void addRankRoleForIDIP(long roleid)
/*     */   {
/* 123 */     getInstance().rank(new ParaseleneRankObj(roleid, ParaseleneManager.getRoleFinishtime(roleid)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void clearRoleRankData(long roleid)
/*     */   {
/* 130 */     getInstance().delete(Long.valueOf(roleid));
/* 131 */     Paraselene xParaselene = Role2paraselene.get(Long.valueOf(roleid));
/* 132 */     if (xParaselene != null)
/*     */     {
/* 134 */       xParaselene.setStarttime(0L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\ParaseleneRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */