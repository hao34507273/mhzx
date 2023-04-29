/*    */ package mzm.gsp.map.main.scene.darkmonsterhandle;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.SDigongGuaYeConst;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.guaji.main.GuajiInterface;
/*    */ import mzm.gsp.guaji.main.SwitchType;
/*    */ import mzm.gsp.map.main.MapObjectManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DoublePointMeetMonsterHandle
/*    */   implements MeetDarkMonsterHandle
/*    */ {
/*    */   private final int doublePointDarkMonsterId;
/*    */   
/*    */   public DoublePointMeetMonsterHandle(int doublePointDarkMonsterId)
/*    */   {
/* 20 */     this.doublePointDarkMonsterId = doublePointDarkMonsterId;
/*    */   }
/*    */   
/*    */ 
/*    */   public int handle(long roleId, MeetDarkMonsterHandle.MeetDarkMonsterHandleContext context)
/*    */   {
/* 26 */     int monsterFightId = MapObjectManager.getInstance().getDarkMonsterFightId(this.doublePointDarkMonsterId);
/* 27 */     if (monsterFightId < 0)
/*    */     {
/* 29 */       return 0;
/*    */     }
/*    */     
/* 32 */     TLogArg tLogArg = new TLogArg(LogReason.MAP_DOUBLE_POINT_DARK_MONSTER_FIGHT, monsterFightId);
/* 33 */     if (GuajiInterface.costDoublePoint(roleId, SwitchType.GuaJi, SDigongGuaYeConst.getInstance().EVERYFIGHT_COST_DOUBLEPOINT, tLogArg))
/*    */     {
/*    */ 
/* 36 */       context.doublePointRoleId = roleId;
/* 37 */       context.reason = FightReason.DOUBLE_POINT_DARK_MONSTER_FIGHT;
/* 38 */       return monsterFightId;
/*    */     }
/*    */     
/* 41 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\darkmonsterhandle\DoublePointMeetMonsterHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */