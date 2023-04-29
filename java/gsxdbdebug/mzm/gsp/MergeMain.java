/*     */ package mzm.gsp;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import mzm.gsp.achievement.main.AchievementModule;
/*     */ import mzm.gsp.activity.main.ActivityMergeModule;
/*     */ import mzm.gsp.addiction.main.AddictionModule;
/*     */ import mzm.gsp.arena.main.ArenaMergeModule;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameMergeModule;
/*     */ import mzm.gsp.award.main.AwardMerge;
/*     */ import mzm.gsp.backgame.main.BackGameModule;
/*     */ import mzm.gsp.backgameactivity.main.BackGameActivityModule;
/*     */ import mzm.gsp.badge.main.BadageMerge;
/*     */ import mzm.gsp.bandstand.main.BandstandModule;
/*     */ import mzm.gsp.blacklist.main.BlacklistMergeModule;
/*     */ import mzm.gsp.bless.main.BlessModule;
/*     */ import mzm.gsp.breakegg.main.BreakEggModule;
/*     */ import mzm.gsp.buff.main.BuffMerge;
/*     */ import mzm.gsp.cake.main.CakeModule;
/*     */ import mzm.gsp.cat.main.CatModule;
/*     */ import mzm.gsp.changemodelcard.main.ChangeModelCardModule;
/*     */ import mzm.gsp.chat.main.ChatMerge;
/*     */ import mzm.gsp.chatbubble.main.ChatBubbleMerge;
/*     */ import mzm.gsp.children.main.ChildrenModule;
/*     */ import mzm.gsp.circletask.main.CircleMerge;
/*     */ import mzm.gsp.compensate.main.CompensateModule;
/*     */ import mzm.gsp.competition.main.CompetitionMergeModule;
/*     */ import mzm.gsp.countdown.main.CountDownMergeModule;
/*     */ import mzm.gsp.coupledaily.main.CoupleDailyModule;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnMergeModule;
/*     */ import mzm.gsp.crossbattle.point.CrossBattlePointMergeModule;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteMergeModule;
/*     */ import mzm.gsp.drawcarnival.main.DrawCarnivalMergeModule;
/*     */ import mzm.gsp.fabaolingqi.main.FabaoArtifactMergeModule;
/*     */ import mzm.gsp.factionpve.main.FactionPVEMergeModule;
/*     */ import mzm.gsp.factiontask.main.GangTaskMerge;
/*     */ import mzm.gsp.fashiondress.main.FashionDressModule;
/*     */ import mzm.gsp.feisheng.main.FeiShengMergeModule;
/*     */ import mzm.gsp.festival.main.FestivalMergeModule;
/*     */ import mzm.gsp.fight.main.FightModule;
/*     */ import mzm.gsp.floor.main.FloorMerge;
/*     */ import mzm.gsp.flowerparade.main.FlowerParadeModule;
/*     */ import mzm.gsp.foolsday.main.FoolsDayMergeModule;
/*     */ import mzm.gsp.friendscircle.main.FriendsCircleModule;
/*     */ import mzm.gsp.gang.main.GangMergeModule;
/*     */ import mzm.gsp.gangskill.main.GangSkillMerger;
/*     */ import mzm.gsp.genius.main.GeniusModule;
/*     */ import mzm.gsp.gift.main.GiftMergeModule;
/*     */ import mzm.gsp.gratefuldelivery.main.GratefulDeliveryMergeModule;
/*     */ import mzm.gsp.grc.main.GrcModule;
/*     */ import mzm.gsp.group.main.GroupModule;
/*     */ import mzm.gsp.grow.main.GrowMerge;
/*     */ import mzm.gsp.guaji.main.DoublePointMerger;
/*     */ import mzm.gsp.homeland.main.HomeMerger;
/*     */ import mzm.gsp.homeland.mysteryvisitor.MysteryVisitorMergeModule;
/*     */ import mzm.gsp.huanhun.main.HunMerge;
/*     */ import mzm.gsp.hula.main.HulaMerge;
/*     */ import mzm.gsp.husong.main.HuSongMergeModule;
/*     */ import mzm.gsp.instance.main.InstanceMergeModule;
/*     */ import mzm.gsp.item.main.ExchangeUseItemMergemodule;
/*     */ import mzm.gsp.item.main.FlowerPointMerger;
/*     */ import mzm.gsp.item.main.ItemMerger;
/*     */ import mzm.gsp.jiuxiao.main.JiuXiaoMergeModule;
/*     */ import mzm.gsp.ladder.main.LadderMergeModule;
/*     */ import mzm.gsp.legoushangcheng.main.LeGouShangChengMerge;
/*     */ import mzm.gsp.loginaward.main.LoginAwardModule;
/*     */ import mzm.gsp.lonngboatrace.main.LonngBoatRaceMerge;
/*     */ import mzm.gsp.luckybag.main.LuckyBagModule;
/*     */ import mzm.gsp.magicmark.main.MagicMarkMergeModule;
/*     */ import mzm.gsp.makeup.main.MakeUpModule;
/*     */ import mzm.gsp.market.main.MarketMerger;
/*     */ import mzm.gsp.marriage.main.MarriageMergeModule;
/*     */ import mzm.gsp.massexp.main.MassExpModule;
/*     */ import mzm.gsp.masswedding.main.MassWeddingMergeModule;
/*     */ import mzm.gsp.menpaistar.main.MenPaiStarModule;
/*     */ import mzm.gsp.mibao.main.MiBaoModule;
/*     */ import mzm.gsp.mondayfree.main.MondayFreeMergeModule;
/*     */ import mzm.gsp.monster.main.MonsterModule;
/*     */ import mzm.gsp.mounts.main.MountsModule;
/*     */ import mzm.gsp.mourn.main.MournModule;
/*     */ import mzm.gsp.multioccupation.main.MultiOccupMergeModule;
/*     */ import mzm.gsp.mysteryshop.main.MysteryShopMerger;
/*     */ import mzm.gsp.online.main.OnlineMergeModule;
/*     */ import mzm.gsp.paraselene.main.ParaseleneMerger;
/*     */ import mzm.gsp.pet.main.PetFightMergeModule;
/*     */ import mzm.gsp.pet.main.PetMerge;
/*     */ import mzm.gsp.pet.main.PetYaoliRankMerge;
/*     */ import mzm.gsp.petarena.main.PetArenaModule;
/*     */ import mzm.gsp.petmark.main.PetMarkModule;
/*     */ import mzm.gsp.pk.main.PKMergeModule;
/*     */ import mzm.gsp.prison.main.PrisonMerge;
/*     */ import mzm.gsp.qingfu.main.QingfuModule;
/*     */ import mzm.gsp.qingyuan.main.QingYuanModule;
/*     */ import mzm.gsp.qingyunzhi.main.QingMerge;
/*     */ import mzm.gsp.qmhw.main.QMHWMergeModule;
/*     */ import mzm.gsp.question.main.KejuMerger;
/*     */ import mzm.gsp.questionvoice.main.QuestionVoiceModule;
/*     */ import mzm.gsp.resourcecheck.main.ResourceMerger;
/*     */ import mzm.gsp.roledye.main.RoleDyeMergeModule;
/*     */ import mzm.gsp.scochallenge.main.ScoChallengeMerger;
/*     */ import mzm.gsp.seasontask.main.SeasontaskMerge;
/*     */ import mzm.gsp.server.main.ServerLevelMerger;
/*     */ import mzm.gsp.shanghui.main.ShanghuiMerge;
/*     */ import mzm.gsp.signaward.main.SignMerger;
/*     */ import mzm.gsp.singletask.main.SingleTaskMerge;
/*     */ import mzm.gsp.skill.main.SkillBagMerge;
/*     */ import mzm.gsp.storywall.main.StoryWallMergeModule;
/*     */ import mzm.gsp.superequipment.jewel.main.SuperEquipmentJewelMerge;
/*     */ import mzm.gsp.systemsetting.main.SystemSettingMerger;
/*     */ import mzm.gsp.team.main.TeamMerge;
/*     */ import mzm.gsp.timeflow.main.TimeFlowModule;
/*     */ import mzm.gsp.title.main.TitleMerge;
/*     */ import mzm.gsp.treasurehunt.main.TreasureHuntModule;
/*     */ import mzm.gsp.util.UuidMergeModule;
/*     */ import mzm.gsp.visiblemonsterfight.main.VisibleMonsterFightModule;
/*     */ import mzm.gsp.visiblemonsterfight.main.robber.GangRobberMergeModule;
/*     */ import mzm.gsp.wanted.main.WantedMerge;
/*     */ import mzm.gsp.wing.main2.WingMerge;
/*     */ import mzm.gsp.worldgoal.main.WorldGoalMergeModule;
/*     */ import mzm.gsp.worship.main.WorshipMerge;
/*     */ import mzm.gsp.xiaohuikuaipao.main.XiaoHuiKuaiPaoMerge;
/*     */ import mzm.gsp.xiulian.main.XiulianSkillMerge;
/*     */ import mzm.gsp.zhenyao.main.ZhenyaoMerger;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import xdb.Table;
/*     */ import xdb.Xdb;
/*     */ import xdb.XdbConf;
/*     */ 
/*     */ public class MergeMain
/*     */ {
/*     */   public static final char NAME_SPLIT = '_';
/* 142 */   private static Set<String> dbTables = new HashSet();
/*     */   
/* 144 */   private static List<MergeModule> modules = new java.util.ArrayList();
/*     */   
/* 146 */   private static Map<String, MergeModule> table2Module = new java.util.HashMap();
/*     */   
/*     */   private static Logger logger;
/*     */   
/*     */   private static int zoneid;
/*     */   
/*     */   private static int viceZoneid;
/* 153 */   private static boolean isDebug = false;
/*     */   
/*     */   private static void usage() {
/* 156 */     System.err.println("Usage: java <gamedata location> <xdb.xml> <zoneid> <vice zoneid>");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void initLogger()
/*     */   {
/* 164 */     System.out.println("configuring log4j with log4j.merge.xml");
/* 165 */     org.apache.log4j.xml.DOMConfigurator.configure("log4j.merge.xml");
/* 166 */     logger = Logger.getLogger("root");
/*     */     
/* 168 */     GameServer.initLogger(logger);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean parseXdbXml(String xdbXml)
/*     */   {
/*     */     try
/*     */     {
/* 179 */       Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xdbXml);
/* 180 */       Element root = doc.getDocumentElement();
/*     */       
/* 182 */       NodeList childnodes = root.getChildNodes();
/* 183 */       for (int i = 0; i < childnodes.getLength(); i++) {
/* 184 */         Node node = childnodes.item(i);
/* 185 */         if (1 == node.getNodeType())
/*     */         {
/*     */ 
/*     */ 
/* 189 */           Element e = (Element)node;
/* 190 */           String nodename = e.getNodeName();
/* 191 */           if (nodename.equals("table"))
/*     */           {
/* 193 */             String persistence = e.getAttribute("persistence");
/* 194 */             if (!persistence.toLowerCase().equals("memory")) {
/* 195 */               String tableName = e.getAttribute("name");
/* 196 */               dbTables.add(tableName);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 201 */     } catch (Exception e) { GameServer.logger().error("MergeMain.parseXdbXml@parse error", e);
/* 202 */       return false;
/*     */     }
/* 204 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean checkNotRegisteredTables()
/*     */   {
/* 214 */     Set<String> registeredTables = table2Module.keySet();
/*     */     
/* 216 */     boolean ret = true;
/* 217 */     for (String name : dbTables) {
/* 218 */       if (!registeredTables.contains(name)) {
/* 219 */         formatLogError("MergeMain.checkNotRegisteredTables@not registered table|table=%s", new Object[] { name });
/* 220 */         ret = false;
/*     */       }
/*     */     }
/*     */     
/* 224 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean merge()
/*     */   {
/*     */     try
/*     */     {
/* 235 */       Iterator<MergeModule> iter = modules.iterator();
/* 236 */       while (iter.hasNext()) {
/* 237 */         MergeModule module = (MergeModule)iter.next();
/* 238 */         formatLogInfo("MergeMain.merge@handling module|class=%s", new Object[] { module.getClass().getName() });
/* 239 */         if (!module.handleMerge()) {
/* 240 */           formatLogError("MergeMain.merge@module merge error|class=%s", new Object[] { module.getClass().getName() });
/* 241 */           return false;
/*     */         }
/* 243 */         formatLogInfo("MergeMain.merge@module merge done|class=%s", new Object[] { module.getClass().getName() });
/*     */       }
/*     */     } catch (Exception e) {
/* 246 */       logger.error("MergeMain.merge@merge error", e);
/* 247 */       return false;
/*     */     }
/*     */     
/* 250 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean stopXdb()
/*     */   {
/*     */     try {
/* 256 */       formatLogInfo("MergeMain.stopXdb@stopping xdb", new Object[0]);
/* 257 */       Xdb.getInstance().stop();
/*     */     } catch (Exception e) {
/* 259 */       formatLogError("MergeMain.stopXdb@stop xdb error", e, new Object[0]);
/* 260 */       return false;
/*     */     }
/* 262 */     formatLogInfo("MergeMain.stopXdb@stop xdb success", new Object[0]);
/* 263 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 269 */     if (args.length != 4) {
/* 270 */       usage();
/* 271 */       System.exit(1);
/*     */     }
/*     */     
/* 274 */     String gamedataDir = args[0];
/* 275 */     String xdbXml = args[1];
/*     */     try
/*     */     {
/* 278 */       zoneid = Integer.parseInt(args[2]);
/* 279 */       viceZoneid = Integer.parseInt(args[3]);
/*     */     } catch (Exception e) {
/* 281 */       e.printStackTrace();
/* 282 */       usage();
/* 283 */       System.exit(1);
/*     */     }
/*     */     
/*     */ 
/* 287 */     initLogger();
/*     */     
/* 289 */     if (System.getProperty("com.zulong.mhzx.merge.debug") != null) {
/* 290 */       logger.info("merge debug mode");
/* 291 */       isDebug = true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 296 */     if (!parseXdbXml(xdbXml)) {
/* 297 */       usage();
/* 298 */       System.exit(1);
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 303 */       logger.info("MergeMain.main@start xdb ...");
/* 304 */       Xdb.getInstance().setConf(new XdbConf(xdbXml));
/* 305 */       Xdb.getInstance().start();
/*     */     } catch (Exception e) {
/* 307 */       logger.error("MergeMain.main@start xdb error", e);
/* 308 */       System.exit(1);
/*     */     }
/*     */     
/*     */ 
/* 312 */     registerMergeModules();
/*     */     
/*     */ 
/* 315 */     boolean retRegister = checkNotRegisteredTables();
/* 316 */     if (!retRegister) {
/* 317 */       logger.error("MergeMain.main@merge failed, not all db tables registered!!!!!");
/* 318 */       if (!isDebug) {
/* 319 */         System.exit(1);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 324 */     GameServer.initTlog();
/*     */     
/*     */     try
/*     */     {
/* 328 */       if (!GameServer.initGameData(gamedataDir)) {
/* 329 */         logger.error("MergeMain.main@load game data failed!!!!!!");
/* 330 */         usage();
/* 331 */         System.exit(1);
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 335 */       logger.error("MergeMain.main@load game data error!!!!!!", e);
/* 336 */       System.exit(1);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 342 */     if (!merge()) {
/* 343 */       logger.error("MergeMain.main@merge failed!!!!!!");
/* 344 */       System.exit(1);
/*     */     }
/*     */     
/*     */ 
/* 348 */     if (!stopXdb()) {
/* 349 */       formatLogInfo("MergeMain.main@stop xdb failed!!!!!", new Object[0]);
/* 350 */       System.exit(1);
/*     */     }
/*     */     
/* 353 */     logger.info("MergeMain.main@merge succeed");
/*     */   }
/*     */   
/*     */ 
/*     */   public static void formatLogInfo(String format, Object... args)
/*     */   {
/* 359 */     String msg = String.format(format, args);
/* 360 */     logger.info(msg);
/*     */   }
/*     */   
/*     */   public static void formatLogWarn(String format, Object... args) {
/* 364 */     String msg = String.format(format, args);
/* 365 */     logger.warn(msg);
/*     */   }
/*     */   
/*     */   public static void formatLogError(String format, Object... args) {
/* 369 */     String msg = String.format(format, args);
/* 370 */     logger.error(msg);
/*     */   }
/*     */   
/*     */   public static void formatLogError(String format, Throwable e, Object... args) {
/* 374 */     String msg = String.format(format, args);
/* 375 */     logger.error(msg, e);
/*     */   }
/*     */   
/*     */   public static Logger logger() {
/* 379 */     return logger;
/*     */   }
/*     */   
/*     */   public static long getMainZoneid() {
/* 383 */     return zoneid;
/*     */   }
/*     */   
/*     */   public static long getViceZoneid() {
/* 387 */     return viceZoneid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String nextNameByDuplicated(String name)
/*     */   {
/* 428 */     if (name == null) {
/* 429 */       return null;
/*     */     }
/* 431 */     StringBuilder sb = new StringBuilder();
/* 432 */     int number = -1;
/* 433 */     boolean bSplited = false;
/* 434 */     for (int i = 0; i < name.length(); i++) {
/* 435 */       char c = name.charAt(i);
/* 436 */       if (c == '_') {
/* 437 */         if (bSplited) {
/* 438 */           if (number >= 0) {
/* 439 */             sb.append(number);
/* 440 */             number = -1;
/*     */           }
/*     */         }
/*     */         else {
/* 444 */           bSplited = true;
/*     */         }
/* 446 */         sb.append(c);
/*     */       }
/* 448 */       else if ((c >= '0') && (c <= '9')) {
/* 449 */         if (bSplited) {
/* 450 */           if (number < 0) {
/* 451 */             number = c - '0';
/*     */           }
/*     */           else {
/* 454 */             number = 10 * number + (c - '0');
/*     */           }
/*     */         }
/*     */         else {
/* 458 */           sb.append(c);
/*     */         }
/*     */       }
/*     */       else {
/* 462 */         if (bSplited) {
/* 463 */           bSplited = false;
/*     */         }
/* 465 */         if (number >= 0) {
/* 466 */           sb.append(number);
/* 467 */           number = -1;
/*     */         }
/* 469 */         sb.append(c);
/*     */       }
/*     */     }
/*     */     
/* 473 */     if (bSplited) {
/* 474 */       if (number >= 0) {
/* 475 */         sb.append(number + 1);
/*     */       }
/*     */       else {
/* 478 */         sb.append(1);
/*     */       }
/*     */     }
/*     */     else {
/* 482 */       sb.append('_');
/* 483 */       sb.append(1);
/*     */     }
/*     */     
/* 486 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void registerMergeModule(MergeModule module)
/*     */   {
/* 496 */     if (module == null) {
/* 497 */       formatLogError("MergeMain.registerMergeModule@register null", new Object[0]);
/* 498 */       return;
/*     */     }
/*     */     
/* 501 */     if (modules.contains(module)) {
/* 502 */       formatLogError("MergeMain.registerMergeModule@duplicated register module|module=%s", new Object[] { module });
/* 503 */       System.exit(1);
/*     */     }
/* 505 */     modules.add(module);
/*     */     
/* 507 */     List<Table> tables = module.getHandleTables();
/* 508 */     if (tables == null) {
/* 509 */       formatLogError("MergeMain.registerMergeModule@tables null|module=%s", new Object[] { module });
/* 510 */       System.exit(1);
/*     */     }
/* 512 */     Iterator<Table> iter = tables.iterator();
/* 513 */     while (iter.hasNext()) {
/* 514 */       Table xTable = (Table)iter.next();
/* 515 */       String name = xTable.getName();
/*     */       
/* 517 */       if (!dbTables.contains(name)) {
/* 518 */         formatLogError("MergeMain.registerMergeModule@invalid table, not db table|table=%s", new Object[] { name });
/* 519 */         System.exit(1);
/*     */       }
/*     */       
/* 522 */       MergeModule old = (MergeModule)table2Module.put(name, module);
/*     */       
/* 524 */       if (old != null) {
/* 525 */         formatLogError("MergeMain.registerMergeModule@duplicated handled table|table=%s|module1=%s|module2=%s", new Object[] { name, old, module });
/*     */         
/* 527 */         System.exit(1);
/*     */       }
/* 529 */       table2Module.put(name, module);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void registerMergeModules()
/*     */   {
/* 541 */     registerMergeModule(new mzm.gsp.mergecompensation.main.MergeCompensationMergeModule());
/*     */     
/* 543 */     registerMergeModule(new GameServerInfoMergeModule());
/*     */     
/* 545 */     registerMergeModule(new QingfuModule());
/*     */     
/* 547 */     registerMergeModule(new CompensateModule());
/*     */     
/* 549 */     registerMergeModule(new mzm.gsp.map.main.MapModule());
/*     */     
/* 551 */     registerMergeModule(new GrcModule());
/*     */     
/* 553 */     registerMergeModule(new MonsterModule());
/*     */     
/* 555 */     registerMergeModule(new mzm.gsp.online.main.OnlineModule());
/*     */     
/* 557 */     registerMergeModule(new FightModule());
/*     */     
/* 559 */     registerMergeModule(new TimeFlowModule());
/*     */     
/* 561 */     registerMergeModule(new CompetitionMergeModule());
/* 562 */     registerMergeModule(new ArenaMergeModule());
/* 563 */     registerMergeModule(new mzm.gsp.menpaipvp.main.MenpaiPVPMergeModule());
/* 564 */     registerMergeModule(new BlacklistMergeModule());
/* 565 */     registerMergeModule(new GangMergeModule());
/* 566 */     registerMergeModule(new UuidMergeModule());
/*     */     
/* 568 */     registerMergeModule(new mzm.gsp.exchange.main.ExchangeModule());
/*     */     
/* 570 */     registerMergeModule(new mzm.gsp.gangrace.main.GangRaceMergeModule());
/* 571 */     registerMergeModule(new RoleDyeMergeModule());
/* 572 */     registerMergeModule(new mzm.gsp.sworn.main.SwornMergeModule());
/* 573 */     registerMergeModule(new StoryWallMergeModule());
/*     */     
/* 575 */     registerMergeModule(new mzm.gsp.awardpool.main.AwardPoolMerger());
/* 576 */     registerMergeModule(new mzm.gsp.baitan.main.BaitanMerger());
/* 577 */     registerMergeModule(new mzm.gsp.bigboss.main.BigbossMerger());
/* 578 */     registerMergeModule(new DoublePointMerger());
/* 579 */     registerMergeModule(new FlowerPointMerger());
/* 580 */     registerMergeModule(new mzm.gsp.guide.main.GuideMerger());
/* 581 */     registerMergeModule(new GangSkillMerger());
/* 582 */     registerMergeModule(new ItemMerger());
/* 583 */     registerMergeModule(new mzm.gsp.jingji.main.JingjiMerger());
/* 584 */     registerMergeModule(new KejuMerger());
/* 585 */     registerMergeModule(new mzm.gsp.mall.main.MallMerger());
/* 586 */     registerMergeModule(new MarketMerger());
/* 587 */     registerMergeModule(new ParaseleneMerger());
/* 588 */     registerMergeModule(new mzm.gsp.question.main.QuestionMerger());
/* 589 */     registerMergeModule(new ScoChallengeMerger());
/* 590 */     registerMergeModule(new ServerLevelMerger());
/* 591 */     registerMergeModule(new mzm.gsp.shimen.main.ShimenMerger());
/* 592 */     registerMergeModule(new SignMerger());
/* 593 */     registerMergeModule(new SystemSettingMerger());
/* 594 */     registerMergeModule(new mzm.gsp.yuanbao.main.YuanbaoMerger());
/* 595 */     registerMergeModule(new mzm.gsp.zhenfa.main.ZhenfaMerger());
/* 596 */     registerMergeModule(new ZhenyaoMerger());
/* 597 */     registerMergeModule(new ResourceMerger());
/*     */     
/* 599 */     registerMergeModule(new mzm.gsp.shitu.main.ShiTuModule());
/* 600 */     registerMergeModule(new MiBaoModule());
/* 601 */     registerMergeModule(new AchievementModule());
/* 602 */     registerMergeModule(new FashionDressModule());
/* 603 */     registerMergeModule(new CoupleDailyModule());
/* 604 */     registerMergeModule(new BackGameModule());
/* 605 */     registerMergeModule(new QingYuanModule());
/* 606 */     registerMergeModule(new MountsModule());
/* 607 */     registerMergeModule(new mzm.gsp.luckystar.main.LuckyStarModule());
/* 608 */     registerMergeModule(new VisibleMonsterFightModule());
/* 609 */     registerMergeModule(new ChildrenModule());
/* 610 */     registerMergeModule(new mzm.gsp.crossbattle.knockout.KnockOutMergeModule());
/* 611 */     registerMergeModule(new FriendsCircleModule());
/* 612 */     registerMergeModule(new mzm.gsp.aircraft.main.AircraftModule());
/* 613 */     registerMergeModule(new TreasureHuntModule());
/*     */     
/* 615 */     registerMergeModule(new mzm.gsp.role.main.RoleMerge());
/* 616 */     registerMergeModule(new mzm.gsp.partner.main.PartnerMerge());
/* 617 */     registerMergeModule(new AwardMerge());
/* 618 */     registerMergeModule(new mzm.gsp.bounty.main.BountyMerge());
/* 619 */     registerMergeModule(new HunMerge());
/* 620 */     registerMergeModule(new BadageMerge());
/* 621 */     registerMergeModule(new mzm.gsp.chivalry.main.ChivalryMerge());
/* 622 */     registerMergeModule(new GrowMerge());
/* 623 */     registerMergeModule(new CircleMerge());
/* 624 */     registerMergeModule(new ChatMerge());
/* 625 */     registerMergeModule(new GangTaskMerge());
/* 626 */     registerMergeModule(new QingMerge());
/* 627 */     registerMergeModule(new SeasontaskMerge());
/* 628 */     registerMergeModule(new WingMerge());
/* 629 */     registerMergeModule(new mzm.gsp.task.main.TaskMerge());
/* 630 */     registerMergeModule(new TeamMerge());
/* 631 */     registerMergeModule(new TitleMerge());
/* 632 */     registerMergeModule(new SingleTaskMerge());
/* 633 */     registerMergeModule(new WorshipMerge());
/* 634 */     registerMergeModule(new MournModule());
/* 635 */     registerMergeModule(new mzm.gsp.corps.main.CorpsMerge());
/* 636 */     registerMergeModule(new FloorMerge());
/* 637 */     registerMergeModule(new mzm.gsp.firework.main.FireworkModule());
/* 638 */     registerMergeModule(new CakeModule());
/* 639 */     registerMergeModule(new MakeUpModule());
/*     */     
/* 641 */     registerMergeModule(new BuffMerge());
/* 642 */     registerMergeModule(new mzm.gsp.lifeskill.main.LifeSkillMerge());
/* 643 */     registerMergeModule(new PetMerge());
/* 644 */     registerMergeModule(new PetArenaModule());
/* 645 */     registerMergeModule(new ShanghuiMerge());
/* 646 */     registerMergeModule(new SkillBagMerge());
/* 647 */     registerMergeModule(new XiulianSkillMerge());
/* 648 */     registerMergeModule(new PetYaoliRankMerge());
/* 649 */     registerMergeModule(new mzm.gsp.chatgift.main.ChatGiftMerge());
/*     */     
/* 651 */     registerMergeModule(new mzm.gsp.personal.main.PersonalModule());
/* 652 */     registerMergeModule(new mzm.gsp.idip.main.IdipModule());
/*     */     
/* 654 */     registerMergeModule(new MarriageMergeModule());
/* 655 */     registerMergeModule(new mzm.gsp.friend.main.FriendMergeModule());
/* 656 */     registerMergeModule(new OnlineMergeModule());
/* 657 */     registerMergeModule(new mzm.gsp.fight.main.FightMergeModule());
/* 658 */     registerMergeModule(new mzm.gsp.mail.main.MailMergeModule());
/* 659 */     registerMergeModule(new HuSongMergeModule());
/* 660 */     registerMergeModule(new InstanceMergeModule());
/* 661 */     registerMergeModule(new JiuXiaoMergeModule());
/* 662 */     registerMergeModule(new mzm.gsp.question.main.QuestionMergeModule());
/* 663 */     registerMergeModule(new GangRobberMergeModule());
/* 664 */     registerMergeModule(new FestivalMergeModule());
/* 665 */     registerMergeModule(new QMHWMergeModule());
/* 666 */     registerMergeModule(new mzm.gsp.active.main.ActiveMergeModule());
/* 667 */     registerMergeModule(new mzm.gsp.fabao.main.FabaoMergeModule());
/* 668 */     registerMergeModule(new MassWeddingMergeModule());
/* 669 */     registerMergeModule(new mzm.gsp.npc.main.NpcMergeModule());
/* 670 */     registerMergeModule(new LadderMergeModule());
/* 671 */     registerMergeModule(new MagicMarkMergeModule());
/* 672 */     registerMergeModule(new GiftMergeModule());
/*     */     
/* 674 */     registerMergeModule(new LonngBoatRaceMerge());
/* 675 */     registerMergeModule(new mzm.gsp.superequipment.wushi.main.WuShiMerge());
/* 676 */     registerMergeModule(new WantedMerge());
/* 677 */     registerMergeModule(new PrisonMerge());
/* 678 */     registerMergeModule(new SuperEquipmentJewelMerge());
/* 679 */     registerMergeModule(new LeGouShangChengMerge());
/* 680 */     registerMergeModule(new ChatBubbleMerge());
/* 681 */     registerMergeModule(new XiaoHuiKuaiPaoMerge());
/* 682 */     registerMergeModule(new mzm.gsp.activitypointexchange.main.ActivityPointExchangeMerge());
/* 683 */     registerMergeModule(new mzm.gsp.auction.main.AuctionMerge());
/* 684 */     registerMergeModule(new DrawCarnivalMergeModule());
/*     */     
/* 686 */     registerMergeModule(new mzm.gsp.chess.main.ChessModule());
/* 687 */     registerMergeModule(new LoginAwardModule());
/* 688 */     registerMergeModule(new CatModule());
/* 689 */     registerMergeModule(new GroupModule());
/* 690 */     registerMergeModule(new WorldGoalMergeModule());
/* 691 */     registerMergeModule(new HomeMerger());
/* 692 */     registerMergeModule(new CountDownMergeModule());
/* 693 */     registerMergeModule(new MultiOccupMergeModule());
/* 694 */     registerMergeModule(new MassExpModule());
/* 695 */     registerMergeModule(new mzm.gsp.hula.main.HulaRankMergeModule());
/* 696 */     registerMergeModule(new HulaMerge());
/* 697 */     registerMergeModule(new mzm.gsp.interactivetask.main.InteractiveTaskMerger());
/* 698 */     registerMergeModule(new mzm.gsp.constellation.main.ConstellationMergeModule());
/* 699 */     registerMergeModule(new mzm.gsp.planttree.main.PlantTreeMergeModule());
/* 700 */     registerMergeModule(new FoolsDayMergeModule());
/* 701 */     registerMergeModule(new FeiShengMergeModule());
/* 702 */     registerMergeModule(new MenPaiStarModule());
/* 703 */     registerMergeModule(new GeniusModule());
/* 704 */     registerMergeModule(new mzm.gsp.avatar.main.AvatarMergeModule());
/* 705 */     registerMergeModule(new AvatarFrameMergeModule());
/* 706 */     registerMergeModule(new LuckyBagModule());
/* 707 */     registerMergeModule(new BlessModule());
/* 708 */     registerMergeModule(new MysteryShopMerger());
/* 709 */     registerMergeModule(new mzm.gsp.exploit.main.ExploitModule());
/* 710 */     registerMergeModule(new FactionPVEMergeModule());
/* 711 */     registerMergeModule(new mzm.gsp.axe.main.AxeMergeModule());
/* 712 */     registerMergeModule(new GratefulDeliveryMergeModule());
/* 713 */     registerMergeModule(new mzm.gsp.zoo.main.ZooModule());
/* 714 */     registerMergeModule(new MysteryVisitorMergeModule());
/* 715 */     registerMergeModule(new CrossBattleOwnMergeModule());
/* 716 */     registerMergeModule(new mzm.gsp.crossbattle.bet.CrossBattleRoundRobinBetMergeModule());
/* 717 */     registerMergeModule(new FabaoArtifactMergeModule());
/* 718 */     registerMergeModule(new mzm.gsp.crossbattle.bet.CrossBattleKnockoutBetMergeModule());
/* 719 */     registerMergeModule(new CrossBattlePointMergeModule());
/* 720 */     registerMergeModule(new mzm.gsp.crossfield.main.CrossFieldMergeModule());
/* 721 */     registerMergeModule(new ExchangeUseItemMergemodule());
/* 722 */     registerMergeModule(new PKMergeModule());
/* 723 */     registerMergeModule(new CrossCompeteMergeModule());
/* 724 */     registerMergeModule(new BackGameActivityModule());
/* 725 */     registerMergeModule(new AddictionModule());
/* 726 */     registerMergeModule(new mzm.gsp.superequipment.main.SuperEquipmentMergeModule());
/* 727 */     registerMergeModule(new QuestionVoiceModule());
/* 728 */     registerMergeModule(new mzm.gsp.partneryuanshen.main.PartnerYuanshenMergeModule());
/* 729 */     registerMergeModule(new mzm.gsp.chinesevalentine.main.ChineseValentineModule());
/* 730 */     registerMergeModule(new FlowerParadeModule());
/* 731 */     registerMergeModule(new mzm.gsp.crossbattle.bet.CrossBattleBetRankMergeModule());
/* 732 */     registerMergeModule(new mzm.gsp.birthdaypray.main.WorldCounterMergeModule());
/* 733 */     registerMergeModule(new BreakEggModule());
/* 734 */     registerMergeModule(new ChangeModelCardModule());
/* 735 */     registerMergeModule(new mzm.gsp.groupshopping.main.GroupShoppingMergeModule());
/* 736 */     registerMergeModule(new mzm.gsp.indiana.main.IndianaMergeModule());
/* 737 */     registerMergeModule(new MondayFreeMergeModule());
/* 738 */     registerMergeModule(new mzm.gsp.alllotto.main.AllLottoMergeModule());
/* 739 */     registerMergeModule(new mzm.gsp.activitycompensate.main.ActivityCompensateMergeModule());
/* 740 */     registerMergeModule(new BandstandModule());
/* 741 */     registerMergeModule(new PetFightMergeModule());
/* 742 */     registerMergeModule(new PetMarkModule());
/* 743 */     registerMergeModule(new mzm.gsp.christmasstocking.main.ChristmasStockingModule());
/*     */     
/* 745 */     registerMergeModule(new ActivityMergeModule());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\MergeMain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */