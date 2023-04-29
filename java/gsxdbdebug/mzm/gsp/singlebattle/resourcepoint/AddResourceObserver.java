/*     */ package mzm.gsp.singlebattle.resourcepoint;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.singlebattle.buff.SingleBattleBuffInterface;
/*     */ import mzm.gsp.singlebattle.confbean.SResourcePointCfg;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleGlobalInfo;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ResourcePoint;
/*     */ import xbean.RoleResourcePointInfo;
/*     */ import xtable.Resource_points;
/*     */ 
/*     */ public class AddResourceObserver
/*     */   extends Observer
/*     */ {
/*     */   private final long battleid;
/*     */   
/*     */   public AddResourceObserver(long intervalSeconds, long battleid)
/*     */   {
/*  25 */     super(intervalSeconds);
/*  26 */     this.battleid = battleid;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  32 */     new PAddResource(this.battleid).execute();
/*  33 */     return true;
/*     */   }
/*     */   
/*     */   class PAddResource extends LogicProcedure
/*     */   {
/*     */     private final long battleid;
/*     */     
/*     */     PAddResource(long battleid)
/*     */     {
/*  42 */       this.battleid = battleid;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  49 */       SingleBattleGlobalInfo globalInfo = SingleBattleInterface.getSingleBattleGlobalInfo(this.battleid, true);
/*  50 */       if (globalInfo == null)
/*     */       {
/*     */ 
/*  53 */         return false;
/*     */       }
/*  55 */       int cfgid = globalInfo.getPlayCfgId(3);
/*  56 */       if (cfgid <= 0)
/*     */       {
/*     */ 
/*  59 */         return false;
/*     */       }
/*  61 */       SResourcePointCfg cfg = SResourcePointCfg.get(cfgid);
/*  62 */       if (cfg == null)
/*     */       {
/*     */ 
/*  65 */         return false;
/*     */       }
/*  67 */       ResourcePoint xResourcePoint = Resource_points.get(Long.valueOf(this.battleid));
/*  68 */       if (xResourcePoint == null)
/*     */       {
/*     */ 
/*  71 */         return false;
/*     */       }
/*  73 */       Map<Integer, Integer> campId2AddValue = new HashMap();
/*  74 */       for (Map.Entry<Long, RoleResourcePointInfo> entry : xResourcePoint.getRole_resource_point_infos().entrySet())
/*     */       {
/*  76 */         long roleid = ((Long)entry.getKey()).longValue();
/*  77 */         RoleResourcePointInfo xRoleResourcePointInfo = (RoleResourcePointInfo)entry.getValue();
/*  78 */         int addValue = !xRoleResourcePointInfo.getIs_in_field() ? 0 : xRoleResourcePointInfo.getResource_point() * cfg.resource_coeffcient * SingleBattleBuffInterface.getResourceMultiple(roleid);
/*     */         
/*  80 */         if (addValue > 0)
/*     */         {
/*     */ 
/*     */ 
/*  84 */           int campid = globalInfo.getRoleCampId(roleid);
/*  85 */           if (campid >= 0)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*  90 */             campId2AddValue.put(Integer.valueOf(campid), Integer.valueOf(campId2AddValue.containsKey(Integer.valueOf(campid)) ? addValue + ((Integer)campId2AddValue.get(Integer.valueOf(campid))).intValue() : addValue));
/*     */             
/*  92 */             xRoleResourcePointInfo.setAdd_resource_sum(xRoleResourcePointInfo.getAdd_resource_sum() + addValue);
/*     */           } } }
/*  94 */       SingleBattleInterface.addCampSource(this.battleid, campId2AddValue);
/*  95 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/*  97 */         GameServer.logger().debug(String.format("[resourcepoint]AddResourceObserver.PAddResource.processImp@add resource success|add_value=%s", new Object[] { campId2AddValue.toString() }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 102 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\resourcepoint\AddResourceObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */