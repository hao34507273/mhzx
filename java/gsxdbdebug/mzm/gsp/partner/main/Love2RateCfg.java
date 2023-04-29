/*     */ package mzm.gsp.partner.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.partner.confbean.SPartnerLoveCfg;
/*     */ import mzm.gsp.partner.confbean.STLove2Rate;
/*     */ 
/*     */ public class Love2RateCfg
/*     */ {
/*     */   private int sPartnerLoveCfgId;
/*     */   
/*     */   public Love2RateCfg(int sPartnerLoveCfgId)
/*     */   {
/*  20 */     this.sPartnerLoveCfgId = sPartnerLoveCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   STLove2Rate getSTLove2Rate()
/*     */   {
/*  30 */     return STLove2Rate.get(this.sPartnerLoveCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Map<Integer, Integer> getLove2rate()
/*     */   {
/*  40 */     return new HashMap(getSTLove2Rate().love2rate);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getsPartnerLoveCfgId()
/*     */   {
/*  50 */     return this.sPartnerLoveCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPartnerLoveCfg getSPartnerLoveCfg()
/*     */   {
/*  60 */     return SPartnerLoveCfg.get(getsPartnerLoveCfgId());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Integer> ranLoveIds(int seed, int needNum)
/*     */   {
/*  74 */     if ((needNum <= 0) || (seed <= 0))
/*     */     {
/*  76 */       return new ArrayList();
/*     */     }
/*  78 */     Map<Integer, Integer> love2rateTmp = getLove2rate();
/*  79 */     List<Integer> loveIds = new ArrayList();
/*  80 */     for (int i = 0; i < needNum; i++)
/*     */     {
/*  82 */       int loveId = ranOneLoveId(seed, love2rateTmp);
/*  83 */       if (loveId < 0)
/*     */       {
/*  85 */         GameServer.logger().error(String.format("[partner]Love2RateCfg.ranLoveIds@ can not ran one loveId!|sPartnerLoveCfgId=%d", new Object[] { Integer.valueOf(this.sPartnerLoveCfgId) }));
/*     */         
/*     */ 
/*  88 */         return new ArrayList();
/*     */       }
/*  90 */       seed -= ((Integer)love2rateTmp.get(Integer.valueOf(loveId))).intValue();
/*  91 */       loveIds.add(Integer.valueOf(loveId));
/*  92 */       love2rateTmp.remove(Integer.valueOf(loveId));
/*     */     }
/*  94 */     return loveIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int ranOneLoveId(int seed, Map<Integer, Integer> loveId2rate)
/*     */   {
/* 106 */     if ((loveId2rate == null) || (loveId2rate.size() == 0) || (seed <= 0))
/*     */     {
/* 108 */       return -1;
/*     */     }
/* 110 */     Random random = xdb.Xdb.random();
/* 111 */     int ran = random.nextInt(seed);
/* 112 */     int sum = 0;
/* 113 */     Iterator<Map.Entry<Integer, Integer>> itLove = loveId2rate.entrySet().iterator();
/* 114 */     while (itLove.hasNext())
/*     */     {
/* 116 */       Map.Entry<Integer, Integer> entry = (Map.Entry)itLove.next();
/* 117 */       sum += ((Integer)entry.getValue()).intValue();
/* 118 */       if (sum > ran)
/*     */       {
/*     */ 
/*     */ 
/* 122 */         return ((Integer)entry.getKey()).intValue(); }
/*     */     }
/* 124 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\Love2RateCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */