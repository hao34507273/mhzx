/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.fight.SSyncRecordEnterFight;
/*    */ import mzm.gsp.fight.SSyncRecordFightEnd;
/*    */ import mzm.gsp.fight.SSyncRecordRoundPlay;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.FightRecordInfo;
/*    */ 
/*    */ public class PCGetRecordReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long recordid;
/*    */   
/*    */   public PCGetRecordReq(long roleid, long recordid)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.recordid = recordid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     FightRecordInfo xFightRecordInfo = xtable.Fightreord.get(Long.valueOf(this.recordid));
/* 25 */     if (xFightRecordInfo == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     int size = 0;
/*    */     
/* 32 */     SSyncRecordEnterFight enterFight = new SSyncRecordEnterFight();
/* 33 */     enterFight.recordid = this.recordid;
/* 34 */     enterFight.enter_fight_content.replace(xFightRecordInfo.getEnter_fightCopy());
/* 35 */     OnlineManager.getInstance().send(this.roleid, enterFight);
/*    */     
/* 37 */     size += enterFight.enter_fight_content.size();
/*    */     
/*    */ 
/*    */ 
/* 41 */     int round = 1;
/* 42 */     for (byte[] roundPlayBytes : xFightRecordInfo.getRounds())
/*    */     {
/* 44 */       SSyncRecordRoundPlay roundPlay = new SSyncRecordRoundPlay();
/* 45 */       roundPlay.recordid = this.recordid;
/* 46 */       roundPlay.round = (round++);
/* 47 */       roundPlay.round_play_content.replace(roundPlayBytes);
/* 48 */       OnlineManager.getInstance().send(this.roleid, roundPlay);
/*    */       
/* 50 */       size += roundPlay.round_play_content.size();
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 55 */     SSyncRecordFightEnd fightEnd = new SSyncRecordFightEnd();
/* 56 */     fightEnd.recordid = this.recordid;
/* 57 */     fightEnd.fight_end_content.replace(xFightRecordInfo.getFight_endCopy());
/* 58 */     size += fightEnd.fight_end_content.size();
/* 59 */     OnlineManager.getInstance().send(this.roleid, fightEnd);
/*    */     
/*    */ 
/* 62 */     if (mzm.gsp.GameServer.logger().isDebugEnabled())
/*    */     {
/* 64 */       mzm.gsp.GameServer.logger().debug(String.format("[fight]PCGetRecordReq.processImp@statis record size|size=%d", new Object[] { Integer.valueOf(size) }));
/*    */     }
/*    */     
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PCGetRecordReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */