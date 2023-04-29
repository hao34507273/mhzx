/*    */ package mzm.gsp.map.main.scene.darkmonsterhandle;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.LinkedBlockingDeque;
/*    */ import mzm.gsp.map.main.MapCfgManager;
/*    */ import mzm.gsp.map.main.proto.MapPrototype;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.monster.confbean.SDoublePointDarknessMonster;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MeetMonsterManager
/*    */ {
/* 17 */   private LinkedBlockingDeque<MeetDarkMonsterHandle> handleDeque = new LinkedBlockingDeque();
/*    */   
/*    */   public MeetMonsterManager(Scene scene)
/*    */   {
/* 21 */     int mapId = scene.getCfgId();
/*    */     
/* 23 */     MapPrototype mapCfg = MapCfgManager.getInstance().getMapProtoById(mapId);
/*    */     
/*    */ 
/* 26 */     if (mapCfg.getDarkMonsterTableId() > 0)
/*    */     {
/* 28 */       addBefore(new DefaultMapHandle(scene.getCfgId(), mapCfg.getDarkMonsterTableId()));
/*    */     }
/*    */     
/*    */ 
/* 32 */     if (!mapCfg.getTaskIdToFightIdMap().isEmpty())
/*    */     {
/* 34 */       addBefore(new TaskMeetMonsterHandle(mapId));
/*    */     }
/*    */     
/* 37 */     for (SDoublePointDarknessMonster dp : SDoublePointDarknessMonster.getAll().values())
/*    */     {
/* 39 */       if (dp.mapId == mapId)
/*    */       {
/* 41 */         addBefore(new DoublePointMeetMonsterHandle(dp.darkNessMonsterId));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void addBefore(MeetDarkMonsterHandle handle)
/*    */   {
/* 48 */     if (this.handleDeque != null)
/*    */     {
/* 50 */       this.handleDeque.addFirst(handle);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addLast(MeetDarkMonsterHandle handle)
/*    */   {
/* 56 */     if (this.handleDeque != null)
/*    */     {
/* 58 */       this.handleDeque.addLast(handle);
/*    */     }
/*    */   }
/*    */   
/*    */   public void removeHandle(MeetDarkMonsterHandle handle)
/*    */   {
/* 64 */     if (this.handleDeque != null)
/*    */     {
/* 66 */       this.handleDeque.remove(handle);
/*    */     }
/*    */   }
/*    */   
/*    */   public int meetMonsterHandle(long roleId, MeetDarkMonsterHandle.MeetDarkMonsterHandleContext context)
/*    */   {
/* 72 */     if (this.handleDeque == null)
/*    */     {
/* 74 */       return 0;
/*    */     }
/*    */     
/* 77 */     Iterator<MeetDarkMonsterHandle> handleIterator = this.handleDeque.iterator();
/* 78 */     while (handleIterator.hasNext())
/*    */     {
/* 80 */       MeetDarkMonsterHandle handle = (MeetDarkMonsterHandle)handleIterator.next();
/* 81 */       int fightId = handle.handle(roleId, context);
/* 82 */       if (fightId > 0)
/*    */       {
/* 84 */         return fightId;
/*    */       }
/*    */     }
/*    */     
/* 88 */     return 0;
/*    */   }
/*    */   
/*    */   public void release()
/*    */   {
/* 93 */     this.handleDeque.clear();
/* 94 */     this.handleDeque = null;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\darkmonsterhandle\MeetMonsterManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */