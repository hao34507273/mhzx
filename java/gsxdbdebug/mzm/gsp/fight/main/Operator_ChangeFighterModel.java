/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.Play;
/*    */ import mzm.gsp.fight.PlayChangeModel;
/*    */ import mzm.gsp.fight.confbean.SFightConsts;
/*    */ import mzm.gsp.monster.main.MonsterInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ class Operator_ChangeFighterModel extends FighterAIOperator
/*    */ {
/*    */   private int fid;
/*    */   private int monsterid;
/*    */   
/*    */   Operator_ChangeFighterModel(int fid, int monsterid)
/*    */   {
/* 18 */     super(false);
/* 19 */     this.monsterid = monsterid;
/* 20 */     this.fid = fid;
/*    */   }
/*    */   
/*    */   public void excute(Fight fight)
/*    */   {
/* 25 */     Fighter fighter = fight.getFighter(this.fid);
/* 26 */     if ((fighter == null) || (fighter.isDead()) || (fighter.isFakeDead())) {
/* 27 */       return;
/*    */     }
/* 29 */     ExcuteCmdResult excuteCmdResult = new ExcuteCmdResult();
/* 30 */     if (!MonsterInterface.isMonsterCfgExist(this.monsterid)) {
/* 31 */       GameServer.logger().error("AI传递的怪物id不存在!!!");
/* 32 */       return;
/*    */     }
/* 34 */     Play play = new Play();
/* 35 */     play.play_type = 10;
/* 36 */     PlayChangeModel playChangeModel = new PlayChangeModel();
/* 37 */     playChangeModel.fighterid = fighter.fighterid;
/* 38 */     MonsterInterface.fillModelInfo(this.monsterid, playChangeModel.model);
/* 39 */     play.content = playChangeModel.marshal(new OctetsStream());
/* 40 */     excuteCmdResult.addPlay(play, false);
/* 41 */     excuteCmdResult.addPlay(play, true);
/* 42 */     if (fight.isRecordEnable()) {
/* 43 */       excuteCmdResult.addPlay(play);
/*    */     }
/* 45 */     excuteCmdResult.addPlayTime(SFightConsts.getInstance().CHANGE_MODEL_ACTION_TIME);
/* 46 */     fight.addCmdResult(excuteCmdResult);
/*    */     
/* 48 */     fighter.changeModel(this.monsterid);
/*    */     
/* 50 */     fight.addActionCount();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Operator_ChangeFighterModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */