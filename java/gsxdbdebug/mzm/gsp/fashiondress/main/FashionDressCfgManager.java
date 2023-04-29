/*    */ package mzm.gsp.fashiondress.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.fashiondress.confbean.ExtraInfo;
/*    */ import mzm.gsp.fashiondress.confbean.SThemeFashionDressPropCfg;
/*    */ import mzm.gsp.fashiondress.confbean.STimeLimitedThemeFashionDressCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FashionDressCfgManager
/*    */ {
/* 16 */   private static List<Integer> allThemeFashionDressBuffCfgid = new ArrayList();
/* 17 */   private static List<Integer> allTimeLimitedThemeFashionDressBuffCfgid = new ArrayList();
/*    */   
/*    */   static void init()
/*    */   {
/* 21 */     for (SThemeFashionDressPropCfg cfg : SThemeFashionDressPropCfg.getAll().values())
/*    */     {
/* 23 */       for (ExtraInfo extraInfo : cfg.extra_infos.values())
/*    */       {
/* 25 */         for (i$ = extraInfo.buff_list.iterator(); i$.hasNext();) { int buffCfgid = ((Integer)i$.next()).intValue();
/*    */           
/* 27 */           if (!allThemeFashionDressBuffCfgid.contains(Integer.valueOf(buffCfgid)))
/*    */           {
/* 29 */             allThemeFashionDressBuffCfgid.add(Integer.valueOf(buffCfgid)); }
/*    */         }
/*    */       }
/*    */     }
/*    */     Iterator i$;
/* 34 */     for (STimeLimitedThemeFashionDressCfg cfg : STimeLimitedThemeFashionDressCfg.getAll().values())
/*    */     {
/* 36 */       if (!allTimeLimitedThemeFashionDressBuffCfgid.contains(Integer.valueOf(cfg.buff_cfg_id)))
/*    */       {
/* 38 */         allTimeLimitedThemeFashionDressBuffCfgid.add(Integer.valueOf(cfg.buff_cfg_id));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   static List<Integer> getAllThemeFashionDressBuffCfgid()
/*    */   {
/* 45 */     return allThemeFashionDressBuffCfgid;
/*    */   }
/*    */   
/*    */   static List<Integer> getAllTimeLimitedThemeFashionDressBuffCfgid()
/*    */   {
/* 50 */     return allTimeLimitedThemeFashionDressBuffCfgid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\FashionDressCfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */