/*    */ package mzm.gsp.awardpool.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.awardpool.confbean.SPreciousDropCfg;
/*    */ import xbean.IdCounter;
/*    */ 
/*    */ class InitRoleAwardPoolPrecious extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int clearType;
/*    */   
/*    */   public InitRoleAwardPoolPrecious(long roleid, int clearType)
/*    */   {
/* 14 */     this.roleid = roleid;
/*    */     
/* 16 */     this.clearType = clearType;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     xbean.ItemSubid2Count xItemSubid2Count = xtable.Role2itemsubid.get(Long.valueOf(this.roleid));
/* 23 */     if (xItemSubid2Count == null)
/*    */     {
/* 25 */       xItemSubid2Count = xbean.Pod.newItemSubid2Count();
/* 26 */       xtable.Role2itemsubid.insert(Long.valueOf(this.roleid), xItemSubid2Count);
/*    */     }
/* 28 */     for (Iterator i$ = xItemSubid2Count.getItemsubid2count().keySet().iterator(); i$.hasNext();) { int itemSubId = ((Integer)i$.next()).intValue();
/*    */       
/* 30 */       int preciousCfgId = AwardPoolManager.getPreciousCfgId(itemSubId);
/*    */       
/* 32 */       SPreciousDropCfg peCfg = SPreciousDropCfg.get(preciousCfgId);
/* 33 */       if (peCfg != null)
/*    */       {
/*    */ 
/*    */ 
/* 37 */         if (peCfg.roleClearTypeEnum2 == this.clearType)
/*    */         {
/* 39 */           IdCounter xIdCounter = (IdCounter)xItemSubid2Count.getItemsubid2count().get(Integer.valueOf(itemSubId));
/* 40 */           if ((xIdCounter != null) && (xIdCounter.getHistorydropcount() >= peCfg.roleMaxDropCount1))
/*    */           {
/* 42 */             xIdCounter.setDropcount(0);
/* 43 */             xIdCounter.setUnhitcount(0);
/* 44 */             xIdCounter.setModifytime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*    */             
/* 46 */             String logstr = String.format("[awardpool]InitRoleAwardPoolPrecious.processImp@Day observer time out,init role itemSubid count|roleid=%d|itemSubId=%d|clearType=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(itemSubId), Integer.valueOf(this.clearType) });
/*    */             
/*    */ 
/* 49 */             AwardPoolManager.logger.info(logstr);
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\InitRoleAwardPoolPrecious.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */