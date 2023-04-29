/*     */ package mzm.gsp.singlebattle.grab;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.singlebattle.confbean.SPositionInfoCfg;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleGrabData;
/*     */ import xbean.GrabPositionData;
/*     */ import xtable.Grabposition;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class SynGrabSourceObserver
/*     */   extends Observer
/*     */ {
/*     */   private final long _battleId;
/*     */   
/*     */   public SynGrabSourceObserver(long battleId, int second)
/*     */   {
/*  27 */     super(second);
/*  28 */     this._battleId = battleId;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  34 */     new PSynPositionSource(this).execute();
/*  35 */     return true;
/*     */   }
/*     */   
/*     */   private class PSynPositionSource extends LogicProcedure
/*     */   {
/*     */     private SynGrabSourceObserver observer;
/*     */     
/*     */     PSynPositionSource(SynGrabSourceObserver observer)
/*     */     {
/*  44 */       this.observer = observer;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  51 */       int stage = SingleBattleInterface.getStage(SynGrabSourceObserver.this._battleId, false);
/*     */       
/*  53 */       if ((stage == -1) || (stage == 4) || (stage == 3))
/*     */       {
/*  55 */         this.observer.stopTimer();
/*  56 */         return false;
/*     */       }
/*  58 */       if (stage == 1)
/*     */       {
/*     */ 
/*  61 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  65 */       BattleGrabData xBattleGrabData = Grabposition.select(Long.valueOf(SynGrabSourceObserver.this._battleId));
/*  66 */       if (xBattleGrabData == null)
/*     */       {
/*  68 */         GameServer.logger().error(String.format("[grab]PSynPositionSource.processImp@ no grab position data! |battleId=%d", new Object[] { Long.valueOf(SynGrabSourceObserver.this._battleId) }));
/*     */         
/*  70 */         return false;
/*     */       }
/*     */       
/*  73 */       Map<Integer, Integer> campId2source = new HashMap();
/*     */       
/*  75 */       for (Map.Entry<Integer, GrabPositionData> entry : xBattleGrabData.getPositiondatas().entrySet())
/*     */       {
/*  77 */         int positionId = ((Integer)entry.getKey()).intValue();
/*  78 */         GrabPositionData xPositionData = (GrabPositionData)entry.getValue();
/*     */         
/*  80 */         int campId = xPositionData.getCampid();
/*  81 */         if (campId > 0)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  86 */           SPositionInfoCfg positionInfoCfg = SPositionInfoCfg.get(positionId);
/*  87 */           if (positionInfoCfg == null)
/*     */           {
/*  89 */             GameServer.logger().error(String.format("[grab]PSynPositionSource.processImp@ positionInfoCfg is null! |battleId=%d|positionId=%d", new Object[] { Long.valueOf(SynGrabSourceObserver.this._battleId), Integer.valueOf(positionId) }));
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/*  95 */             int addSource = (int)(positionInfoCfg.sourceAddValue * SynGrabSourceObserver.this.getIntervalSeconds());
/*  96 */             addSource(campId2source, campId, addSource);
/*     */           }
/*     */         } }
/*  99 */       for (Map.Entry<Integer, Integer> entry : campId2source.entrySet())
/*     */       {
/* 101 */         SingleBattleInterface.addCampSource(SynGrabSourceObserver.this._battleId, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/*     */       }
/*     */       
/* 104 */       return true;
/*     */     }
/*     */     
/*     */     private void addSource(Map<Integer, Integer> campId2source, int campId, int addSource)
/*     */     {
/* 109 */       if ((campId <= 0) || (addSource <= 0))
/*     */       {
/* 111 */         return;
/*     */       }
/* 113 */       Integer orgValue = (Integer)campId2source.get(Integer.valueOf(campId));
/* 114 */       if (orgValue == null)
/*     */       {
/* 116 */         orgValue = Integer.valueOf(0);
/*     */       }
/* 118 */       campId2source.put(Integer.valueOf(campId), Integer.valueOf(orgValue.intValue() + addSource));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\grab\SynGrabSourceObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */