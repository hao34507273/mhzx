/*    */ package mzm.gsp.chinesevalentine.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.chinesevalentine.SChineseValentineGameInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ChineseValentineGame;
/*    */ import xbean.ChineseValentineRound;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2chinesevalentine;
/*    */ 
/*    */ public class ChineseValentineNewGame extends LogicProcedure
/*    */ {
/*    */   private final List<Long> roleIdList;
/*    */   private final int activityId;
/*    */   
/*    */   public ChineseValentineNewGame(List<Long> roleIdList, int activityId)
/*    */   {
/* 24 */     this.roleIdList = roleIdList;
/* 25 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     lock(Basic.getTable(), this.roleIdList);
/*    */     
/*    */ 
/* 34 */     ChineseValentineGame xChineseValentineGame = xbean.Pod.newChineseValentineGame();
/* 35 */     long gameId = xtable.Chinesevalentine.insert(xChineseValentineGame).longValue();
/*    */     
/* 37 */     for (Iterator i$ = this.roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 38 */       Role2chinesevalentine.insert(Long.valueOf(roleId), Long.valueOf(gameId));
/*    */       
/*    */ 
/* 41 */       ChineseValentineManager.tLogChineseValentineNewGame(gameId, roleId);
/*    */       
/* 43 */       GameServer.logger().info(String.format("[chinesevalentine]ChineseValentineNewGame.processImp@newgame|gameid=%d|roleidlist=%s|roleid=%d", new Object[] { Long.valueOf(gameId), this.roleIdList.toString(), Long.valueOf(roleId) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 51 */     long nowTimeInMillons = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 53 */     xChineseValentineGame.getRoleidlist().addAll(this.roleIdList);
/* 54 */     xChineseValentineGame.setStarttime(nowTimeInMillons);
/* 55 */     xChineseValentineGame.setRightcount(0);
/* 56 */     xChineseValentineGame.setWrongcount(0);
/*    */     
/* 58 */     SChineseValentineGameInfo protocol = new SChineseValentineGameInfo();
/* 59 */     protocol.roleidlist.addAll(xChineseValentineGame.getRoleidlist());
/* 60 */     protocol.rightcount = xChineseValentineGame.getRightcount();
/* 61 */     protocol.wrongcount = xChineseValentineGame.getWrongcount();
/* 62 */     protocol.roundnumber = xChineseValentineGame.getRoundinfo().getRoundnumber();
/* 63 */     OnlineManager.getInstance().sendMulti(protocol, this.roleIdList);
/*    */     
/*    */ 
/* 66 */     ChineseValentineManager.startPrepare(gameId);
/*    */     
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\main\ChineseValentineNewGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */