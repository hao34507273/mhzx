/*    */ package mzm.gsp.visiblemonsterfight.event;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class ShengXiaoMonsterArg
/*    */ {
/*  7 */   public List<Long> roleIds = new java.util.ArrayList();
/*    */   public final int monsterCfgId;
/*    */   public final boolean isMonsterDead;
/*    */   
/*    */   public ShengXiaoMonsterArg(List<Long> roleids, int monsterCfgid, boolean isMonsterDead) {
/* 12 */     this.roleIds.addAll(roleids);
/* 13 */     this.monsterCfgId = monsterCfgid;
/* 14 */     this.isMonsterDead = isMonsterDead;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\event\ShengXiaoMonsterArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */