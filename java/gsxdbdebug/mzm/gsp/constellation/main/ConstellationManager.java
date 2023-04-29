/*     */ package mzm.gsp.constellation.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.constellation.SChooseCardNormalRes;
/*     */ import mzm.gsp.constellation.SConstellationCardsBrd;
/*     */ import mzm.gsp.constellation.SConstellationNormalResult;
/*     */ import mzm.gsp.constellation.SConstellationRes;
/*     */ import mzm.gsp.constellation.SStageBrd;
/*     */ import mzm.gsp.constellation.SSyncConstellationCards;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleConstellation;
/*     */ import xtable.Role2constellation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ConstellationManager
/*     */ {
/*     */   static final int WAN = 10000;
/*     */   static Logger logger;
/*     */   
/*     */   static void init() {}
/*     */   
/*     */   private static void initLogger()
/*     */   {
/*  34 */     logger = Logger.getLogger("constellation");
/*     */   }
/*     */   
/*     */   static void logWarn(String formatStr, Object... args) {
/*  38 */     logger.warn(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logError(String formatStr, Object... args) {
/*  42 */     logger.error(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logInfo(String formatStr, Object... args) {
/*  46 */     logger.info(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logDebug(String formatStr, Object... args) {
/*  50 */     logger.debug(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void sendNormalResult(long roleid, int result)
/*     */   {
/*  55 */     SConstellationNormalResult p = new SConstellationNormalResult();
/*  56 */     p.result = result;
/*  57 */     OnlineManager.getInstance().sendAtOnce(roleid, p);
/*     */   }
/*     */   
/*     */   static xbean.Constellation getXConstellationIfNotExist() {
/*  61 */     long key = GameServerInfoManager.getLocalId();
/*     */     
/*  63 */     xbean.Constellation xConstellation = xtable.Constellation.get(Long.valueOf(key));
/*  64 */     if (xConstellation == null) {
/*  65 */       xConstellation = Pod.newConstellation();
/*  66 */       xtable.Constellation.insert(Long.valueOf(key), xConstellation);
/*     */     }
/*     */     
/*  69 */     return xConstellation;
/*     */   }
/*     */   
/*     */   static xbean.Constellation getXConstellation(boolean remainLock) {
/*  73 */     long key = GameServerInfoManager.getLocalId();
/*  74 */     xbean.Constellation xConstellation = null;
/*  75 */     if (remainLock) {
/*  76 */       xConstellation = xtable.Constellation.get(Long.valueOf(key));
/*     */     }
/*     */     else {
/*  79 */       xConstellation = xtable.Constellation.select(Long.valueOf(key));
/*     */     }
/*  81 */     return xConstellation;
/*     */   }
/*     */   
/*     */   static void initXConstellation(xbean.Constellation xConstellation) {
/*  85 */     xConstellation.getCards().clear();
/*  86 */     xConstellation.setIndex(0);
/*     */     
/*  88 */     List<Integer> constellations = ConstellationConfigManager.getConstellations();
/*  89 */     for (Iterator i$ = constellations.iterator(); i$.hasNext();) { int constellation = ((Integer)i$.next()).intValue();
/*  90 */       List<Integer> stars = ConstellationConfigManager.getRandomCardStars();
/*  91 */       xbean.ConstellationCards xCards = Pod.newConstellationCards();
/*  92 */       xCards.setConstellation(constellation);
/*  93 */       xCards.getStars().addAll(stars);
/*  94 */       int fortune = ConstellationConfigManager.randomFortune(constellation);
/*  95 */       xCards.setFortune(fortune);
/*     */       
/*  97 */       xConstellation.getCards().add(xCards);
/*     */       
/*  99 */       logInfo("Constellation.initXConstellation@cards|constellation=%d|stars=%s", new Object[] { Integer.valueOf(constellation), stars });
/*     */     }
/*     */   }
/*     */   
/*     */   static void broadcastConstellationCards(xbean.Constellation xConstellation)
/*     */   {
/* 105 */     SConstellationCardsBrd brd = getConstellationCardsBrd(xConstellation);
/* 106 */     if (brd != null) {
/* 107 */       OnlineManager.getInstance().sendAll(brd);
/*     */     }
/*     */   }
/*     */   
/*     */   static void sendConstellationCards(long roleid, xbean.Constellation xConstellation) {
/* 112 */     SConstellationCardsBrd brd = getConstellationCardsBrd(xConstellation);
/* 113 */     if (brd != null) {
/* 114 */       OnlineManager.getInstance().send(roleid, brd);
/*     */     }
/*     */   }
/*     */   
/*     */   private static SConstellationCardsBrd getConstellationCardsBrd(xbean.Constellation xConstellation) {
/* 119 */     int index = xConstellation.getIndex();
/* 120 */     if ((index < 0) || (index >= xConstellation.getCards().size())) {
/* 121 */       return null;
/*     */     }
/* 123 */     xbean.ConstellationCards xCards = (xbean.ConstellationCards)xConstellation.getCards().get(index);
/* 124 */     return getConstellationCardsBrd(xCards);
/*     */   }
/*     */   
/*     */   static void fillConstellationCardsBean(xbean.ConstellationCards xCards, mzm.gsp.constellation.ConstellationCards cardsBean)
/*     */   {
/* 129 */     cardsBean.constellation = xCards.getConstellation();
/* 130 */     cardsBean.stars.addAll(xCards.getStars());
/* 131 */     cardsBean.fortune = xCards.getFortune();
/*     */   }
/*     */   
/*     */   private static SConstellationCardsBrd getConstellationCardsBrd(xbean.ConstellationCards xCards) {
/* 135 */     SConstellationCardsBrd brd = new SConstellationCardsBrd();
/* 136 */     fillConstellationCardsBean(xCards, brd.cards);
/* 137 */     return brd;
/*     */   }
/*     */   
/*     */   static void syncConstellationCards(xbean.Constellation xConstellation, long roleid, RoleConstellation xRoleConstellation)
/*     */   {
/* 142 */     int constellationIndex = xConstellation.getIndex();
/* 143 */     if ((constellationIndex < 0) || (constellationIndex >= xConstellation.getCards().size()))
/*     */     {
/* 145 */       return;
/*     */     }
/* 147 */     xbean.ConstellationCards xCards = (xbean.ConstellationCards)xConstellation.getCards().get(constellationIndex);
/* 148 */     SSyncConstellationCards sync = new SSyncConstellationCards();
/* 149 */     fillConstellationCardsBean(xCards, sync.cards);
/* 150 */     Integer chooseIndex = (Integer)xRoleConstellation.getAward_constellations().get(Integer.valueOf(xCards.getConstellation()));
/* 151 */     if (chooseIndex == null) {
/* 152 */       sync.choose_index = -1;
/*     */     }
/*     */     else {
/* 155 */       sync.choose_index = chooseIndex.intValue();
/*     */     }
/* 157 */     OnlineManager.getInstance().send(roleid, sync);
/*     */   }
/*     */   
/*     */   static RoleConstellation getXRoleConstellationIfNotExist(long roleid)
/*     */   {
/* 162 */     RoleConstellation xRoleConstellation = Role2constellation.get(Long.valueOf(roleid));
/* 163 */     if (xRoleConstellation == null) {
/* 164 */       xRoleConstellation = Pod.newRoleConstellation();
/* 165 */       Role2constellation.insert(Long.valueOf(roleid), xRoleConstellation);
/*     */       
/* 167 */       xRoleConstellation.setConstellation(-1);
/* 168 */       xRoleConstellation.setSet_times(0);
/* 169 */       xRoleConstellation.getAward_constellations().clear();
/*     */     }
/* 171 */     return xRoleConstellation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isCardConstellationValid(xbean.Constellation xConstellation, int constellation)
/*     */   {
/* 182 */     int curIndex = xConstellation.getIndex();
/* 183 */     if (curIndex >= xConstellation.getCards().size()) {
/* 184 */       curIndex = xConstellation.getCards().size() - 1;
/*     */     }
/* 186 */     for (int i = curIndex; i >= 0; i--) {
/* 187 */       xbean.ConstellationCards xCards = (xbean.ConstellationCards)xConstellation.getCards().get(i);
/* 188 */       if (xCards.getConstellation() == constellation) {
/* 189 */         return true;
/*     */       }
/*     */     }
/* 192 */     return false;
/*     */   }
/*     */   
/*     */   static int getStar(xbean.Constellation xConstellation, int constellation, int cardIndex)
/*     */   {
/* 197 */     int star = -1;
/* 198 */     int curIndex = xConstellation.getIndex();
/* 199 */     if (curIndex >= xConstellation.getCards().size()) {
/* 200 */       curIndex = xConstellation.getCards().size() - 1;
/*     */     }
/* 202 */     for (int i = curIndex; i >= 0; i--) {
/* 203 */       xbean.ConstellationCards xCards = (xbean.ConstellationCards)xConstellation.getCards().get(i);
/* 204 */       if (xCards.getConstellation() == constellation) {
/* 205 */         if ((cardIndex >= xCards.getStars().size()) || (cardIndex < 0)) {
/* 206 */           return -1;
/*     */         }
/* 208 */         return ((Integer)xCards.getStars().get(cardIndex)).intValue();
/*     */       }
/*     */     }
/* 211 */     return star;
/*     */   }
/*     */   
/*     */   static void sendChooseCardNormalRes(long roleid, AwardModel awardModel, int constellation, int index)
/*     */   {
/* 216 */     SChooseCardNormalRes res = new SChooseCardNormalRes();
/* 217 */     res.constellation = constellation;
/* 218 */     res.index = index;
/* 219 */     res.award = AwardInterface.getAwardBean(awardModel);
/*     */     
/* 221 */     OnlineManager.getInstance().send(roleid, res);
/*     */   }
/*     */   
/*     */   static void sendConstellationRes(long roleid, RoleConstellation xRoleConstellation) {
/* 225 */     SConstellationRes res = new SConstellationRes();
/* 226 */     res.constellation = xRoleConstellation.getConstellation();
/* 227 */     res.set_times = xRoleConstellation.getSet_times();
/* 228 */     res.sum_exp = xRoleConstellation.getSum_exp();
/*     */     
/* 230 */     OnlineManager.getInstance().send(roleid, res);
/*     */   }
/*     */   
/*     */   static void sendStageBrd(long roleid, int stage, long endMillis) {
/* 234 */     SStageBrd brd = new SStageBrd();
/* 235 */     brd.stage = stage;
/* 236 */     brd.end_millis = endMillis;
/* 237 */     OnlineManager.getInstance().send(roleid, brd);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\main\ConstellationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */