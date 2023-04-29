/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.map.main.scene.darkmonsterhandle.MeetDarkMonsterHandle.MeetDarkMonsterHandleContext;
/*    */ import mzm.gsp.map.main.scene.darkmonsterhandle.MeetMonsterManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PTryStartDrakMonsterPVEFight
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final MeetMonsterManager meetMonsterManager;
/*    */   private final MapDarkMonsterFightContext context;
/*    */   
/*    */   public PTryStartDrakMonsterPVEFight(long roleid, MeetMonsterManager meetMonsterManager, MapDarkMonsterFightContext context)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.meetMonsterManager = meetMonsterManager;
/* 19 */     this.context = context;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     MeetDarkMonsterHandle.MeetDarkMonsterHandleContext handleContext = new MeetDarkMonsterHandle.MeetDarkMonsterHandleContext();
/* 26 */     if (this.meetMonsterManager == null)
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     int fightId = this.meetMonsterManager.meetMonsterHandle(this.roleid, handleContext);
/* 31 */     if (fightId <= 0)
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     if (handleContext.doublePointRoleId > -1L)
/*    */     {
/* 38 */       this.context.putExtra(MapFightContext.EXTRADATA_TYPE.USE_DOUBLEPOINT, 1);
/* 39 */       this.context.putExtra(MapFightContext.EXTRADATA_TYPE.USE_DOUBPLEPOINT_ROLEID_HIGH, (int)(handleContext.doublePointRoleId >> 32));
/*    */       
/* 41 */       this.context.putExtra(MapFightContext.EXTRADATA_TYPE.USE_DOUBPLEPOINT_ROLEID_LOW, (int)handleContext.doublePointRoleId);
/*    */     }
/*    */     
/*    */ 
/* 45 */     FightInterface.startPVEFight(this.roleid, fightId, this.context, handleContext.reason);
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PTryStartDrakMonsterPVEFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */