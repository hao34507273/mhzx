/*    */ package mzm.gsp.singlebattle.buff;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.singlebattle.main.BattleTaskOneByOne;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.SingleBattleBuff;
/*    */ import xbean.ZoneInfo;
/*    */ import xtable.Single_battle_buffs;
/*    */ 
/*    */ public class RegisterZoneEventCallBack implements mzm.gsp.map.main.MapCallback<Integer>
/*    */ {
/*    */   private final long battleid;
/*    */   private final int sortid;
/*    */   
/*    */   public RegisterZoneEventCallBack(long battleid, int sortid)
/*    */   {
/* 19 */     this.battleid = battleid;
/* 20 */     this.sortid = sortid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 26 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onResult(Integer result)
/*    */   {
/* 32 */     BattleTaskOneByOne.getInstance().addLogicProcedure(Long.valueOf(this.battleid), new PRegisterZoneEventCallBack(this.battleid, this.sortid, result.intValue()));
/*    */     
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   class PRegisterZoneEventCallBack extends LogicProcedure
/*    */   {
/*    */     private final long battleid;
/*    */     private final int sortid;
/*    */     private final int result;
/*    */     
/*    */     public PRegisterZoneEventCallBack(long battleid, int sortid, int result)
/*    */     {
/* 45 */       this.battleid = battleid;
/* 46 */       this.sortid = sortid;
/* 47 */       this.result = result;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 53 */       SingleBattleBuff xSingleBattleBuff = Single_battle_buffs.get(Long.valueOf(this.battleid));
/* 54 */       if (xSingleBattleBuff == null)
/*    */       {
/*    */ 
/* 57 */         return false;
/*    */       }
/* 59 */       ZoneInfo xZoneInfo = (ZoneInfo)xSingleBattleBuff.getZone_infos().get(Integer.valueOf(this.sortid));
/* 60 */       if (xZoneInfo == null)
/*    */       {
/*    */ 
/* 63 */         return false;
/*    */       }
/* 65 */       xZoneInfo.setEventid(this.result);
/* 66 */       GameServer.logger().info(String.format("[singlebattle]RegisterZoneEventCallBack.PRegisterZoneEventCallBack.processImp@set event id success|battle_id=%d|sort_id=%d|event_id=%d", new Object[] { Long.valueOf(this.battleid), Integer.valueOf(this.sortid), Integer.valueOf(this.result) }));
/*    */       
/*    */ 
/*    */ 
/* 70 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\buff\RegisterZoneEventCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */