/*    */ package mzm.gsp.open.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class OpenChange extends mzm.event.BasicEvent<OpenChangeComplexArg>
/*    */ {
/*  7 */   private static EventManager<OpenChangeComplexArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<OpenChangeComplexArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.huanhun.main.POnOpenChange());
/* 16 */     manager.register(new mzm.gsp.bounty.main.POnOpenChange());
/* 17 */     manager.register(new mzm.gsp.shimen.main.POnShimenSwitchChange());
/* 18 */     manager.register(new mzm.gsp.baotu.main.POnBaotuSwitchChange());
/* 19 */     manager.register(new mzm.gsp.zhenyao.main.POnZhenyaoSwitchChange());
/* 20 */     manager.register(new mzm.gsp.scochallenge.main.POnScoSwitchChange());
/* 21 */     manager.register(new mzm.gsp.qingyunzhi.main.POnQingSwitchChange());
/* 22 */     manager.register(new mzm.gsp.tmpactivity.main.POnTmpSwitchChange());
/* 23 */     manager.register(new mzm.gsp.factiontask.main.POnFactiontaskChange());
/* 24 */     manager.register(new mzm.gsp.seasontask.main.POnSeasonSingleChange());
/* 25 */     manager.register(new mzm.gsp.seasontask.main.POnSeasonMultiChange());
/* 26 */     manager.register(new mzm.gsp.grow.daytarget.POnDayTargetChange());
/* 27 */     manager.register(new mzm.gsp.worldgoal.main.ROnOpenChange());
/* 28 */     manager.register(new mzm.gsp.luckybag.main.ROnOpenChange());
/* 29 */     manager.register(new mzm.gsp.massexp.main.ROnOpenChange());
/* 30 */     manager.register(new mzm.gsp.addiction.main.ROnOpenChange());
/* 31 */     manager.register(new mzm.gsp.visiblemonsterfight.main.ROnOpenChange());
/* 32 */     manager.register(new mzm.gsp.hula.main.POnHulaSwitchChange());
/* 33 */     manager.register(new mzm.gsp.competition.main.ROnOpenChange());
/* 34 */     manager.register(new mzm.gsp.planttree.main.POnOpenChange());
/* 35 */     manager.register(new mzm.gsp.moneytree.main.POnOpenChange());
/* 36 */     manager.register(new mzm.gsp.memorycompetition.romanticdance.ROnOpenChange());
/* 37 */     manager.register(new mzm.gsp.singletask.main.ROnOpenChange());
/* 38 */     manager.register(new mzm.gsp.feisheng.main.POnOpenChange());
/* 39 */     manager.register(new mzm.gsp.genius.main.ROnOpenChange());
/* 40 */     manager.register(new mzm.gsp.market.main.POnSupplySwitchChanged());
/* 41 */     manager.register(new mzm.gsp.bless.main.ROnOpenChange());
/* 42 */     manager.register(new mzm.gsp.exploit.main.ROnOpenChange());
/* 43 */     manager.register(new mzm.gsp.homeland.mysteryvisitor.POnOpenChange());
/* 44 */     manager.register(new mzm.gsp.npcreward.main.ROnOpenChange());
/* 45 */     manager.register(new mzm.gsp.drawandguess.main.POnOpenChange());
/* 46 */     manager.register(new mzm.gsp.gratefuldelivery.main.POnOpenChange());
/* 47 */     manager.register(new mzm.gsp.lonngboatrace.main.POnOpenChange());
/* 48 */     manager.register(new mzm.gsp.crossbattle.bet.POnOpenChange());
/* 49 */     manager.register(new mzm.gsp.fabaolingqi.main.ROnOpenChange());
/* 50 */     manager.register(new mzm.gsp.chess.main.ROnOpenChange());
/* 51 */     manager.register(new mzm.gsp.wanted.main.POnOpenChange());
/* 52 */     manager.register(new mzm.gsp.crossfield.main.POnOpenChange());
/* 53 */     manager.register(new mzm.gsp.questionvoice.main.ROnOpenChange());
/* 54 */     manager.register(new mzm.gsp.map.main.ROnOpenChangeForGoldStatue());
/* 55 */     manager.register(new mzm.gsp.achievement.main.POnOpenChange());
/* 56 */     manager.register(new mzm.gsp.flowerparade.main.POnOpenChange());
/* 57 */     manager.register(new mzm.gsp.fashiondress.main.ROnOpenChange());
/* 58 */     manager.register(new mzm.gsp.friendscircle.main.ROnOpenChange());
/* 59 */     manager.register(new mzm.gsp.luckystar.main.ROnOpenChange());
/* 60 */     manager.register(new mzm.gsp.treasurehunt.main.ROnOpenChange());
/* 61 */     manager.register(new mzm.gsp.crossbattle.knockout.ROnOpenChange());
/* 62 */     manager.register(new mzm.gsp.multicommontask.main.ROnOpenChange());
/* 63 */     manager.register(new mzm.gsp.xiaohuikuaipao.main.POnOpenChange());
/* 64 */     manager.register(new mzm.gsp.ladder.main.ROnOpenChange());
/* 65 */     manager.register(new mzm.gsp.groupshopping.main.ROnOpenChange());
/* 66 */     manager.register(new mzm.gsp.firework.main.POnOpenChange());
/* 67 */     manager.register(new mzm.gsp.makeup.main.POnOpenChange());
/* 68 */     manager.register(new mzm.gsp.indiana.main.ROnOpenChange());
/* 69 */     manager.register(new mzm.gsp.lifeskillactivity.main.ROnOpenChange());
/* 70 */     manager.register(new mzm.gsp.alllotto.main.ROnOpenChange());
/* 71 */     manager.register(new mzm.gsp.auction.main.POnOpenChange());
/* 72 */     manager.register(new mzm.gsp.activitycompensate.main.POpenChange());
/* 73 */     manager.register(new mzm.gsp.bandstand.main.POnOpenChange());
/* 74 */     manager.register(new mzm.gsp.mysteryshop.main.POnOpenChange());
/* 75 */     manager.register(new mzm.gsp.christmasstocking.main.POnOpenChange());
/* 76 */     manager.register(new mzm.gsp.ballbattle.main.ROnOpenChange());
/* 77 */     manager.register(new mzm.gsp.drawcarnival.main.POnOpenChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\open\event\OpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */