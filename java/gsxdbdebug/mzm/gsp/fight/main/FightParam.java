/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.pubdata.ModelInfo;
/*    */ 
/*    */ 
/*    */ public class FightParam
/*    */ {
/* 12 */   private Map<Integer, List<Integer>> monsterid2BuffidMap = new HashMap();
/*    */   
/* 14 */   List<RoleRowModleInfo> pveRoleRowModleInfos = new ArrayList(2);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addMonsterBuff(int monsterCfgid, List<Integer> buffids)
/*    */   {
/* 25 */     this.monsterid2BuffidMap.put(Integer.valueOf(monsterCfgid), buffids);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Integer> getMonsterBuffid(int monsterCfgid)
/*    */   {
/* 36 */     return (List)this.monsterid2BuffidMap.get(Integer.valueOf(monsterCfgid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addPVERoleRowModelInfo(long roleid, ModelInfo modelInfo)
/*    */   {
/* 50 */     RoleRowModleInfo roleRowModleInfo = new RoleRowModleInfo(roleid, modelInfo);
/* 51 */     this.pveRoleRowModleInfos.add(roleRowModleInfo);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */