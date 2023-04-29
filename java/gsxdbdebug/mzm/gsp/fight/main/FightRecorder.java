/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.fight.SEnterFightBrd;
/*     */ import mzm.gsp.fight.SFightEndBrd;
/*     */ import mzm.gsp.fight.SRoundPlayBrd;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.util.AtomicRangeInteger;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FightRecordInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Fightreord;
/*     */ 
/*     */ public class FightRecorder
/*     */ {
/*  22 */   private static final AtomicRangeInteger autoIncrement = new AtomicRangeInteger(0, 524288);
/*     */   
/*     */   private SEnterFightBrd enterFightBrd;
/*     */   private SFightEndBrd fightEndBrd;
/*  26 */   private List<SRoundPlayBrd> roundPlayBrds = new LinkedList();
/*     */   
/*  28 */   private long recordid = -1L;
/*     */   
/*  30 */   private int round = 0;
/*     */   
/*     */   public FightRecorder()
/*     */   {
/*  34 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  36 */       this.recordid = (DateTimeUtils.getCurrTimeInMillis() / 1000L << 32 & 0xFFFFFFFF00000000 | GameServerInfoManager.getLocalId() << 20 | autoIncrement.getAndIncrement());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   void setEnterFightBrd(SEnterFightBrd enterFightBrd)
/*     */   {
/*  43 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  45 */       Octets startData = enterFightBrd.marshal(new OctetsStream());
/*  46 */       asyncReportFightRecord(1, startData);
/*     */       
/*  48 */       return;
/*     */     }
/*     */     
/*  51 */     this.enterFightBrd = enterFightBrd;
/*     */   }
/*     */   
/*     */   void setFightEndBrd(SFightEndBrd fightEndBrd)
/*     */   {
/*  56 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  58 */       Octets endData = fightEndBrd.marshal(new OctetsStream());
/*  59 */       asyncReportFightRecord(2, endData, this.round);
/*     */       
/*  61 */       return;
/*     */     }
/*     */     
/*  64 */     this.fightEndBrd = fightEndBrd;
/*     */   }
/*     */   
/*     */   void addRoundPlayBrd(SRoundPlayBrd roundPlayBrd)
/*     */   {
/*  69 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  71 */       Octets roundData = roundPlayBrd.marshal(new OctetsStream());
/*  72 */       asyncReportFightRecord(3, roundData, ++this.round);
/*     */       
/*  74 */       return;
/*     */     }
/*     */     
/*  77 */     this.roundPlayBrds.add(roundPlayBrd);
/*     */   }
/*     */   
/*     */   void asyncReportFightRecord(int dataType, Octets data)
/*     */   {
/*  82 */     asyncReportFightRecord(dataType, data, 0);
/*     */   }
/*     */   
/*     */   void asyncReportFightRecord(int dataType, Octets data, int round)
/*     */   {
/*  87 */     OctetsStream context = new OctetsStream();
/*  88 */     context.marshal(round);
/*  89 */     context.marshal(1);
/*  90 */     if (!GrcInterface.asyncReportFightRecord(this.recordid, dataType, data, context))
/*     */     {
/*  92 */       AsyncReportFightRecordInfo info = new AsyncReportFightRecordInfo(this.recordid, dataType, data, context);
/*  93 */       new AsyncReportFightRecordObserver(info);
/*     */     }
/*     */   }
/*     */   
/*     */   long getRecordid()
/*     */   {
/*  99 */     return this.recordid;
/*     */   }
/*     */   
/*     */   void insertRecord()
/*     */   {
/* 104 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/* 106 */       return;
/*     */     }
/*     */     
/* 109 */     if ((this.enterFightBrd == null) || (this.fightEndBrd == null) || (this.roundPlayBrds.isEmpty()))
/*     */     {
/* 111 */       clean();
/*     */       
/* 113 */       return;
/*     */     }
/*     */     
/* 116 */     FightRecordInfo xFightRecordInfo = Pod.newFightRecordInfo();
/* 117 */     xFightRecordInfo.setEnter_fight(this.enterFightBrd);
/* 118 */     xFightRecordInfo.setFight_end(this.fightEndBrd);
/*     */     
/* 120 */     OctetsStream os = new OctetsStream();
/* 121 */     for (SRoundPlayBrd roundPlayBrd : this.roundPlayBrds)
/*     */     {
/* 123 */       os.clear();
/* 124 */       byte[] roundPlayBytes = os.marshal(roundPlayBrd).getBytes();
/* 125 */       xFightRecordInfo.getRounds().add(roundPlayBytes);
/*     */     }
/*     */     
/* 128 */     this.recordid = Fightreord.insert(xFightRecordInfo).longValue();
/* 129 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 131 */       GameServer.logger().debug(String.format("[fight]FightRecorder.insertRecord@dump fight record id|recordid=%d", new Object[] { Long.valueOf(this.recordid) }));
/*     */     }
/*     */     
/*     */ 
/* 135 */     clean();
/*     */   }
/*     */   
/*     */   private void clean()
/*     */   {
/* 140 */     this.enterFightBrd = null;
/* 141 */     this.fightEndBrd = null;
/* 142 */     this.roundPlayBrds.clear();
/* 143 */     this.roundPlayBrds = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */