/*    */ package mzm.gsp.map.main.scene.darkmonsterhandle;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.map.main.MapCfgManager;
/*    */ import mzm.gsp.map.main.proto.MapPrototype;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TaskMeetMonsterHandle
/*    */   implements MeetDarkMonsterHandle
/*    */ {
/*    */   private final int mapId;
/*    */   
/*    */   public TaskMeetMonsterHandle(int mapId)
/*    */   {
/* 20 */     this.mapId = mapId;
/*    */   }
/*    */   
/*    */ 
/*    */   public int handle(long roleId, MeetDarkMonsterHandle.MeetDarkMonsterHandleContext context)
/*    */   {
/* 26 */     MapPrototype cfg = MapCfgManager.getInstance().getMapProtoById(this.mapId);
/* 27 */     if (cfg == null)
/*    */     {
/* 29 */       return 0;
/*    */     }
/*    */     
/* 32 */     Map<Integer, Integer> taskFightMap = cfg.getTaskIdToFightIdMap();
/* 33 */     Iterator<Integer> taskIdit = taskFightMap.keySet().iterator();
/* 34 */     while (taskIdit.hasNext())
/*    */     {
/* 36 */       Integer taskId = (Integer)taskIdit.next();
/* 37 */       if (TaskInterface.unVisiableMonsterTaskBattle(roleId, taskId.intValue()))
/*    */       {
/* 39 */         context.reason = FightReason.TASK_DARK_MONSTER_FIGHT;
/* 40 */         return ((Integer)taskFightMap.get(taskId)).intValue();
/*    */       }
/*    */     }
/*    */     
/* 44 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\darkmonsterhandle\TaskMeetMonsterHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */