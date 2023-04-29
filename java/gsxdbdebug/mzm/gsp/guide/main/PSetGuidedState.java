/*     */ package mzm.gsp.guide.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.guide.confbean.GuideCfgConsts;
/*     */ import mzm.gsp.guide.confbean.SGuide;
/*     */ import mzm.gsp.guide.confbean.SGuideEffect;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PSetGuidedState
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final int guideid;
/*     */   private final long roleid;
/*     */   private final int param;
/*     */   
/*     */   public PSetGuidedState(long roleid, int guideid, int param)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.guideid = guideid;
/*  32 */     this.param = param;
/*     */   }
/*     */   
/*     */   public PSetGuidedState(long roleid, int guideid)
/*     */   {
/*  37 */     this(roleid, guideid, 0);
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!GuideManager.isRoleStateCanGuide(this.roleid, false))
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     String logs = String.format("[guide]PSetGuidedState.processImp@receive guide |roleid=%d|guideid=%d|param=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.guideid), Integer.valueOf(this.param) });
/*     */     
/*  50 */     GuideManager.logger.info(logs);
/*     */     
/*  52 */     SGuide guide = SGuide.get(this.guideid);
/*  53 */     if (guide == null)
/*     */     {
/*  55 */       String logstr = String.format("[guide]PSetGuidedState.processImp@guide id not exsit|roleid=%d|guideid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.guideid) });
/*     */       
/*  57 */       GuideManager.logger.error(logstr);
/*  58 */       return false;
/*     */     }
/*  60 */     boolean ret = GuideManager.setGuidedState(this.roleid, this.guideid, this.param);
/*  61 */     if (!ret)
/*     */     {
/*  63 */       String logstr = String.format("[guide]PSetGuidedState.processImp@guide fail,already guided|roleid=%d|guideid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.guideid) });
/*     */       
/*  65 */       GuideManager.logger.warn(logstr);
/*     */       
/*  67 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  71 */     if (this.guideid == GuideCfgConsts.getInstance().NEWER_OR_OLDER_GUIDEID)
/*     */     {
/*     */ 
/*  74 */       if ((this.param != 0) && (this.param != 1))
/*     */       {
/*  76 */         String logstr = String.format("[guide]PSetGuidedState.processImp@newer guide survey  param is wrong|roleid=%d|guideid=%d|param=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.guideid), Integer.valueOf(this.param) });
/*     */         
/*     */ 
/*  79 */         GuideManager.logger.error(logstr);
/*  80 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  87 */       GuideManager.synIsNewOrOld(this.roleid, this.param);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  92 */       boolean isNew = GuideManager.isNewer(this.roleid);
/*  93 */       int guideEffectid = 0;
/*  94 */       if (isNew)
/*     */       {
/*  96 */         guideEffectid = guide.effect;
/*     */       }
/*     */       else
/*     */       {
/* 100 */         guideEffectid = guide.olderEffect;
/*     */       }
/* 102 */       if (guideEffectid > 0)
/*     */       {
/* 104 */         SGuideEffect guideEffect = SGuideEffect.get(guideEffectid);
/* 105 */         switch (guideEffect.guidetype)
/*     */         {
/*     */ 
/*     */         case 6: 
/*     */         case 9: 
/* 110 */           if ((!guideEffect.effectParamList.contains(Integer.valueOf(this.param))) || (!PetInterface.isPetCfgExist(this.param)))
/*     */           {
/* 112 */             String logstr = String.format("[guide]PSetGuidedState.processImp@guide param is wrong|roleid=%d|guideid=%d|param=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.guideid), Integer.valueOf(this.param) });
/*     */             
/*     */ 
/* 115 */             GuideManager.logger.error(logstr);
/* 116 */             return false;
/*     */           }
/*     */           
/* 119 */           long petuuid = PetInterface.addPet(this.roleid, this.param);
/* 120 */           PetInterface.setAutoAddPoint(this.roleid, petuuid);
/* 121 */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 129 */     startPostGuide();
/* 130 */     String logstr = String.format("[guide]PSetGuidedState.processImp@guideed success |roleid=%d|guideid=%d|param=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.guideid), Integer.valueOf(this.param) });
/*     */     
/* 132 */     GuideManager.logger.info(logstr);
/*     */     
/* 134 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void startPostGuide()
/*     */   {
/* 142 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 148 */         Set<Integer> postGuideids = GuideManager.getGuideIdsByGuideid(PSetGuidedState.this.guideid);
/* 149 */         if ((postGuideids == null) || (postGuideids.isEmpty()))
/*     */         {
/* 151 */           return false;
/*     */         }
/* 153 */         List<Integer> toremove = new ArrayList();
/* 154 */         for (Iterator i$ = postGuideids.iterator(); i$.hasNext();) { int pgid = ((Integer)i$.next()).intValue();
/*     */           
/* 156 */           if (GuideManager.isGuided(PSetGuidedState.this.roleid, pgid))
/*     */           {
/* 158 */             toremove.add(Integer.valueOf(pgid));
/*     */           }
/*     */           else {
/* 161 */             GuideManager.setUnGuidedState(PSetGuidedState.this.roleid, pgid);
/*     */           }
/*     */         }
/* 164 */         postGuideids.removeAll(toremove);
/* 165 */         if (postGuideids.size() > 0)
/*     */         {
/* 167 */           GuideManager.sendCanGuideids(PSetGuidedState.this.roleid, postGuideids);
/* 168 */           String logstr = String.format("[guide]PSetGuidedState.startPostGuide@send can guideid success roleid=%d|prevguideid=%d|guideids=%s", new Object[] { Long.valueOf(PSetGuidedState.this.roleid), Integer.valueOf(PSetGuidedState.this.guideid), postGuideids.toString() });
/*     */           
/*     */ 
/* 171 */           GuideManager.logger.info(logstr);
/*     */         }
/* 173 */         return true;
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\PSetGuidedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */