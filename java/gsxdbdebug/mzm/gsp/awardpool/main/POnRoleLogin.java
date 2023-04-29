/*     */ package mzm.gsp.awardpool.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.awardpool.confbean.SPreciousDropCfg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.IdCounter;
/*     */ import xbean.ItemSubid2Count;
/*     */ 
/*     */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  14 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  16 */     ItemSubid2Count xItemSubid2Count = xtable.Role2itemsubid.get((Long)this.arg);
/*  17 */     if (xItemSubid2Count == null)
/*     */     {
/*  19 */       xItemSubid2Count = xbean.Pod.newItemSubid2Count();
/*  20 */       xtable.Role2itemsubid.insert((Long)this.arg, xItemSubid2Count);
/*     */     }
/*  22 */     for (Iterator i$ = xItemSubid2Count.getItemsubid2count().keySet().iterator(); i$.hasNext();) { int itemSubId = ((Integer)i$.next()).intValue();
/*     */       
/*  24 */       int preciousCfgId = AwardPoolManager.getPreciousCfgId(itemSubId);
/*     */       
/*  26 */       SPreciousDropCfg peCfg = SPreciousDropCfg.get(preciousCfgId);
/*  27 */       if (peCfg != null)
/*     */       {
/*     */ 
/*     */ 
/*  31 */         if (peCfg.roleClearTypeEnum2 == 1)
/*     */         {
/*  33 */           IdCounter xIdCounter = (IdCounter)xItemSubid2Count.getItemsubid2count().get(Integer.valueOf(itemSubId));
/*  34 */           if ((xIdCounter != null) && 
/*     */           
/*     */ 
/*     */ 
/*  38 */             (xIdCounter.getHistorydropcount() >= peCfg.roleMaxDropCount1))
/*     */           {
/*     */ 
/*     */ 
/*  42 */             if (!DateTimeUtils.isInSameDay(xIdCounter.getModifytime(), now))
/*     */             {
/*  44 */               xIdCounter.setDropcount(0);
/*  45 */               xIdCounter.setUnhitcount(0);
/*  46 */               xIdCounter.setModifytime(now);
/*     */               
/*  48 */               String logstr = String.format("[awardpool]POnRoleLogin.processImp@init role day itemSubid count|roleid=%d|itemSubId=%d", new Object[] { this.arg, Integer.valueOf(itemSubId) });
/*     */               
/*     */ 
/*  51 */               AwardPoolManager.logger.info(logstr);
/*     */             }
/*     */           }
/*     */         }
/*  55 */         else if (peCfg.roleClearTypeEnum2 == 2)
/*     */         {
/*  57 */           IdCounter xIdCounter = (IdCounter)xItemSubid2Count.getItemsubid2count().get(Integer.valueOf(itemSubId));
/*  58 */           if ((xIdCounter != null) && 
/*     */           
/*     */ 
/*     */ 
/*  62 */             (xIdCounter.getHistorydropcount() >= peCfg.roleMaxDropCount1))
/*     */           {
/*     */ 
/*     */ 
/*  66 */             if (!DateTimeUtils.isInSameWeek(xIdCounter.getModifytime(), now))
/*     */             {
/*  68 */               xIdCounter.setDropcount(0);
/*  69 */               xIdCounter.setUnhitcount(0);
/*  70 */               xIdCounter.setModifytime(now);
/*     */               
/*  72 */               String logstr = String.format("[awardpool]POnRoleLogin.processImp@@init role week itemSubid count|roleid=%d|itemSubId=%d", new Object[] { this.arg, Integer.valueOf(itemSubId) });
/*     */               
/*     */ 
/*  75 */               AwardPoolManager.logger.info(logstr);
/*     */             }
/*     */           }
/*  78 */         } else if (peCfg.roleClearTypeEnum2 == 3)
/*     */         {
/*  80 */           IdCounter xIdCounter = (IdCounter)xItemSubid2Count.getItemsubid2count().get(Integer.valueOf(itemSubId));
/*  81 */           if ((xIdCounter != null) && 
/*     */           
/*     */ 
/*     */ 
/*  85 */             (xIdCounter.getHistorydropcount() >= peCfg.roleMaxDropCount1))
/*     */           {
/*     */ 
/*     */ 
/*  89 */             if (!DateTimeUtils.isInSameMonth(xIdCounter.getModifytime(), now))
/*     */             {
/*  91 */               xIdCounter.setDropcount(0);
/*  92 */               xIdCounter.setUnhitcount(0);
/*  93 */               xIdCounter.setModifytime(now);
/*     */               
/*  95 */               String logstr = String.format("[awardpool]POnRoleLogin.processImp@init role month itemSubid count|roleid=%d|itemSubId=%d", new Object[] { this.arg, Integer.valueOf(itemSubId) });
/*     */               
/*     */ 
/*     */ 
/*  99 */               AwardPoolManager.logger.info(logstr);
/*     */             } }
/*     */         }
/*     */       }
/*     */     }
/* 104 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */