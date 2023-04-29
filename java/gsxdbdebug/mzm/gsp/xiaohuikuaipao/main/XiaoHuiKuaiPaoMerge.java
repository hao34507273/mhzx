/*    */ package mzm.gsp.xiaohuikuaipao.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoActivityCfg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.XiaoHuiKuaiPaoGlobalInfo;
/*    */ import xtable.Activityid2xiaohuikuaipaoglobalinfo;
/*    */ 
/*    */ public class XiaoHuiKuaiPaoMerge implements mzm.gsp.MergeModule
/*    */ {
/* 17 */   private static final Logger LOGGER = Logger.getLogger(XiaoHuiKuaiPaoMerge.class);
/*    */   
/*    */ 
/*    */   public List<xdb.Table> getHandleTables()
/*    */   {
/* 22 */     List<xdb.Table> list = new java.util.ArrayList();
/* 23 */     list.add(xtable.Role2xiaohuikuaipaoactivityinfo.getTable());
/* 24 */     list.add(Activityid2xiaohuikuaipaoglobalinfo.getTable());
/* 25 */     list.add(xtable.Role2xiaohuikuaipaopointinfo.getTable());
/* 26 */     return list;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 32 */     if (!new GlobalInfoMerge().call())
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   class GlobalInfoMerge extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     GlobalInfoMerge() {}
/*    */     
/*    */     protected boolean processImp() throws Exception {
/* 45 */       long mainZoneId = MergeMain.getMainZoneid();
/* 46 */       long viceZoneId = MergeMain.getViceZoneid();
/*    */       
/* 48 */       Set<Long> mainKeySet = new HashSet();
/* 49 */       Set<Long> viceKeySet = new HashSet();
/*    */       
/* 51 */       for (Iterator i$ = XiaoHuiKuaiPaoActivityCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*    */         
/* 53 */         mainKeySet.add(Long.valueOf(GameServerInfoManager.toGlobalId(activityId, mainZoneId)));
/* 54 */         viceKeySet.add(Long.valueOf(GameServerInfoManager.toGlobalId(activityId, viceZoneId)));
/*    */       }
/*    */       
/* 57 */       Set<Long> totalKeySet = new HashSet(mainKeySet.size() + viceKeySet.size());
/* 58 */       totalKeySet.addAll(mainKeySet);
/* 59 */       totalKeySet.addAll(viceKeySet);
/*    */       
/* 61 */       lock(Activityid2xiaohuikuaipaoglobalinfo.getTable(), totalKeySet);
/*    */       
/*    */ 
/*    */ 
/* 65 */       for (Iterator i$ = XiaoHuiKuaiPaoActivityCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*    */         
/* 67 */         long viceKey = GameServerInfoManager.toGlobalId(activityId, viceZoneId);
/* 68 */         XiaoHuiKuaiPaoGlobalInfo xViceGlobalInfo = Activityid2xiaohuikuaipaoglobalinfo.get(Long.valueOf(viceKey));
/* 69 */         if (xViceGlobalInfo != null)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 74 */           long mainKey = GameServerInfoManager.toGlobalId(activityId, mainZoneId);
/* 75 */           XiaoHuiKuaiPaoGlobalInfo xMainGlobalInfo = Activityid2xiaohuikuaipaoglobalinfo.get(Long.valueOf(mainKey));
/* 76 */           if (xMainGlobalInfo == null)
/*    */           {
/* 78 */             xMainGlobalInfo = xbean.Pod.newXiaoHuiKuaiPaoGlobalInfo();
/* 79 */             Activityid2xiaohuikuaipaoglobalinfo.insert(Long.valueOf(mainKey), xMainGlobalInfo);
/* 80 */             xMainGlobalInfo.setIsautodraw(xViceGlobalInfo.getIsautodraw());
/*    */           }
/*    */           
/* 83 */           XiaoHuiKuaiPaoMerge.LOGGER.info(String.format("[xiaohuikuaipao]XiaoHuiKuaiPaoMerge.GlobalInfoMerge.processImp:merge info|activityId[%d]|mainZoneId[%d]|mainAutoDraw[%b]|viceZoneId[%d]|viceAutoDraw[%b]", new Object[] { Integer.valueOf(activityId), Long.valueOf(mainZoneId), Boolean.valueOf(xMainGlobalInfo.getIsautodraw()), Long.valueOf(viceZoneId), Boolean.valueOf(xViceGlobalInfo.getIsautodraw()) }));
/*    */           
/*    */ 
/*    */ 
/* 87 */           if (xMainGlobalInfo.getIsautodraw() != xViceGlobalInfo.getIsautodraw())
/*    */           {
/* 89 */             xMainGlobalInfo.setIsautodraw(false);
/*    */           }
/*    */         }
/*    */       }
/* 93 */       for (Iterator i$ = viceKeySet.iterator(); i$.hasNext();) { long vKey = ((Long)i$.next()).longValue();
/*    */         
/* 95 */         Activityid2xiaohuikuaipaoglobalinfo.remove(Long.valueOf(vKey));
/*    */       }
/* 97 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\XiaoHuiKuaiPaoMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */