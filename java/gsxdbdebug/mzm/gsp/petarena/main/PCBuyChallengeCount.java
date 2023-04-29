/*     */ package mzm.gsp.petarena.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.petarena.SBuyChallengeCountFailed;
/*     */ import mzm.gsp.petarena.SBuyChallengeCountSuccess;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaConst;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetArenaInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCBuyChallengeCount extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCBuyChallengeCount(long roleid)
/*     */   {
/*  25 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (!PetArenaManager.canDoAction(this.roleid, 2113))
/*     */     {
/*  33 */       return false;
/*     */     }
/*     */     
/*  36 */     if (!PetArenaManager.isFunOpen(this.roleid))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     int level = RoleInterface.getLevel(this.roleid);
/*  42 */     if (level < SPetArenaConst.getInstance().OPEN_LEVEL)
/*     */     {
/*  44 */       onFailed(-1);
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     String userid = RoleInterface.getUserId(this.roleid);
/*  50 */     lock(Lockeys.get(User.getTable(), userid));
/*  51 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  53 */     PetArenaInfo xPetArenaInfo = xtable.Role2petarenainfo.get(Long.valueOf(this.roleid));
/*  54 */     if (xPetArenaInfo == null)
/*     */     {
/*  56 */       onFailed(1);
/*  57 */       return false;
/*     */     }
/*  59 */     PetArenaManager.checkData(xPetArenaInfo);
/*     */     
/*  61 */     int freeCount = SPetArenaConst.getInstance().FREE_CHALLENGE_COUNT;
/*  62 */     int challengeCount = xPetArenaInfo.getChallenge_count();
/*  63 */     if (challengeCount < freeCount)
/*     */     {
/*  65 */       Map<String, Object> extras = new HashMap();
/*  66 */       extras.put("challenge_count", Integer.valueOf(challengeCount));
/*     */       
/*  68 */       onFailed(1, extras);
/*  69 */       return false;
/*     */     }
/*  71 */     int buyCount = xPetArenaInfo.getBuy_count();
/*  72 */     if (freeCount + buyCount - challengeCount > 0)
/*     */     {
/*  74 */       Map<String, Object> extras = new HashMap();
/*  75 */       extras.put("challenge_count", Integer.valueOf(challengeCount));
/*  76 */       extras.put("buy_count", Integer.valueOf(buyCount));
/*     */       
/*  78 */       onFailed(1, extras);
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     int max = SPetArenaConst.getInstance().MAX_BUY_COUNT;
/*  84 */     if ((max > 0) && (buyCount >= max))
/*     */     {
/*  86 */       Map<String, Object> extras = new HashMap();
/*  87 */       extras.put("challenge_count", Integer.valueOf(challengeCount));
/*  88 */       extras.put("buy_count", Integer.valueOf(buyCount));
/*     */       
/*  90 */       onFailed(-4, extras);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     int price = buyCount * SPetArenaConst.getInstance().YUANBAO_PRICE_ADD_NUM + SPetArenaConst.getInstance().FIRST_BUY_YUANBAO_PRICE;
/*     */     
/*  96 */     TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.PET_ARENA_BUY_COUNT_COST);
/*  97 */     if (!PetArenaManager.cost(userid, this.roleid, SPetArenaConst.getInstance().MONEY_TYPE, price, tLogArg))
/*     */     {
/*  99 */       onFailed(-3);
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     int newBuyCount = buyCount + 1;
/* 104 */     xPetArenaInfo.setBuy_count(newBuyCount);
/*     */     
/* 106 */     PetArenaManager.addTLog(this.roleid, "PetArenaBuyCountForServer", new Object[] { Integer.valueOf(newBuyCount), Integer.valueOf(price) });
/*     */     
/* 108 */     SBuyChallengeCountSuccess rsp = new SBuyChallengeCountSuccess();
/* 109 */     rsp.buy_count = newBuyCount;
/* 110 */     rsp.challenge_count = challengeCount;
/* 111 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/* 113 */     GameServer.logger().info(String.format("[petarena]PCBuyChallengeCount.processImp@buy success|roleid=%d|price=%d|buy_count=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(price), Integer.valueOf(newBuyCount) }));
/*     */     
/*     */ 
/* 116 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 121 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 126 */     SBuyChallengeCountFailed rsp = new SBuyChallengeCountFailed();
/* 127 */     rsp.retcode = retcode;
/* 128 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 130 */     StringBuilder logBuilder = new StringBuilder();
/* 131 */     logBuilder.append("[petarena]PCBuyChallengeCount.onFailed@buy failed");
/* 132 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 133 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 135 */     if (extraParams != null)
/*     */     {
/* 137 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 139 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 143 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PCBuyChallengeCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */