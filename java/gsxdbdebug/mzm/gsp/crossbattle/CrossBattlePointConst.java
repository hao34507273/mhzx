/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class CrossBattlePointConst implements Marshal
/*     */ {
/*     */   public CrossBattlePointRet _crossbattlepointret;
/*     */   public GetCorpsZoneReq _getcorpszonereq;
/*     */   public GetCorpsZoneContext _getcorpszonecontext;
/*     */   public ReportCorpsPointRaceReq _reportcorpspointracereq;
/*     */   public CorpsPointRaceData _corpspointracedata;
/*     */   public GetZonePointRaceContext _getzonepointracecontext;
/*     */   public GetPointRaceDataReq _getpointracedatareq;
/*     */   public GetPointRaceResultReq _getpointraceresultreq;
/*     */   public RemovePointRaceContext _removepointracecontext;
/*     */   public RemovePointRaceReq _removepointracereq;
/*     */   
/*     */   public CrossBattlePointConst()
/*     */   {
/*  21 */     this._crossbattlepointret = new CrossBattlePointRet();
/*  22 */     this._getcorpszonereq = new GetCorpsZoneReq();
/*  23 */     this._getcorpszonecontext = new GetCorpsZoneContext();
/*  24 */     this._reportcorpspointracereq = new ReportCorpsPointRaceReq();
/*  25 */     this._corpspointracedata = new CorpsPointRaceData();
/*  26 */     this._getzonepointracecontext = new GetZonePointRaceContext();
/*  27 */     this._getpointracedatareq = new GetPointRaceDataReq();
/*  28 */     this._getpointraceresultreq = new GetPointRaceResultReq();
/*  29 */     this._removepointracecontext = new RemovePointRaceContext();
/*  30 */     this._removepointracereq = new RemovePointRaceReq();
/*     */   }
/*     */   
/*     */   public CrossBattlePointConst(CrossBattlePointRet __crossbattlepointret_, GetCorpsZoneReq __getcorpszonereq_, GetCorpsZoneContext __getcorpszonecontext_, ReportCorpsPointRaceReq __reportcorpspointracereq_, CorpsPointRaceData __corpspointracedata_, GetZonePointRaceContext __getzonepointracecontext_, GetPointRaceDataReq __getpointracedatareq_, GetPointRaceResultReq __getpointraceresultreq_, RemovePointRaceContext __removepointracecontext_, RemovePointRaceReq __removepointracereq_) {
/*  34 */     this._crossbattlepointret = __crossbattlepointret_;
/*  35 */     this._getcorpszonereq = __getcorpszonereq_;
/*  36 */     this._getcorpszonecontext = __getcorpszonecontext_;
/*  37 */     this._reportcorpspointracereq = __reportcorpspointracereq_;
/*  38 */     this._corpspointracedata = __corpspointracedata_;
/*  39 */     this._getzonepointracecontext = __getzonepointracecontext_;
/*  40 */     this._getpointracedatareq = __getpointracedatareq_;
/*  41 */     this._getpointraceresultreq = __getpointraceresultreq_;
/*  42 */     this._removepointracecontext = __removepointracecontext_;
/*  43 */     this._removepointracereq = __removepointracereq_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     if (!this._crossbattlepointret._validator_()) return false;
/*  48 */     if (!this._getcorpszonereq._validator_()) return false;
/*  49 */     if (!this._getcorpszonecontext._validator_()) return false;
/*  50 */     if (!this._reportcorpspointracereq._validator_()) return false;
/*  51 */     if (!this._corpspointracedata._validator_()) return false;
/*  52 */     if (!this._getzonepointracecontext._validator_()) return false;
/*  53 */     if (!this._getpointracedatareq._validator_()) return false;
/*  54 */     if (!this._getpointraceresultreq._validator_()) return false;
/*  55 */     if (!this._removepointracecontext._validator_()) return false;
/*  56 */     if (!this._removepointracereq._validator_()) return false;
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  61 */     _os_.marshal(this._crossbattlepointret);
/*  62 */     _os_.marshal(this._getcorpszonereq);
/*  63 */     _os_.marshal(this._getcorpszonecontext);
/*  64 */     _os_.marshal(this._reportcorpspointracereq);
/*  65 */     _os_.marshal(this._corpspointracedata);
/*  66 */     _os_.marshal(this._getzonepointracecontext);
/*  67 */     _os_.marshal(this._getpointracedatareq);
/*  68 */     _os_.marshal(this._getpointraceresultreq);
/*  69 */     _os_.marshal(this._removepointracecontext);
/*  70 */     _os_.marshal(this._removepointracereq);
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  75 */     this._crossbattlepointret.unmarshal(_os_);
/*  76 */     this._getcorpszonereq.unmarshal(_os_);
/*  77 */     this._getcorpszonecontext.unmarshal(_os_);
/*  78 */     this._reportcorpspointracereq.unmarshal(_os_);
/*  79 */     this._corpspointracedata.unmarshal(_os_);
/*  80 */     this._getzonepointracecontext.unmarshal(_os_);
/*  81 */     this._getpointracedatareq.unmarshal(_os_);
/*  82 */     this._getpointraceresultreq.unmarshal(_os_);
/*  83 */     this._removepointracecontext.unmarshal(_os_);
/*  84 */     this._removepointracereq.unmarshal(_os_);
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  89 */     if (_o1_ == this) return true;
/*  90 */     if ((_o1_ instanceof CrossBattlePointConst)) {
/*  91 */       CrossBattlePointConst _o_ = (CrossBattlePointConst)_o1_;
/*  92 */       if (!this._crossbattlepointret.equals(_o_._crossbattlepointret)) return false;
/*  93 */       if (!this._getcorpszonereq.equals(_o_._getcorpszonereq)) return false;
/*  94 */       if (!this._getcorpszonecontext.equals(_o_._getcorpszonecontext)) return false;
/*  95 */       if (!this._reportcorpspointracereq.equals(_o_._reportcorpspointracereq)) return false;
/*  96 */       if (!this._corpspointracedata.equals(_o_._corpspointracedata)) return false;
/*  97 */       if (!this._getzonepointracecontext.equals(_o_._getzonepointracecontext)) return false;
/*  98 */       if (!this._getpointracedatareq.equals(_o_._getpointracedatareq)) return false;
/*  99 */       if (!this._getpointraceresultreq.equals(_o_._getpointraceresultreq)) return false;
/* 100 */       if (!this._removepointracecontext.equals(_o_._removepointracecontext)) return false;
/* 101 */       if (!this._removepointracereq.equals(_o_._removepointracereq)) return false;
/* 102 */       return true;
/*     */     }
/* 104 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 108 */     int _h_ = 0;
/* 109 */     _h_ += this._crossbattlepointret.hashCode();
/* 110 */     _h_ += this._getcorpszonereq.hashCode();
/* 111 */     _h_ += this._getcorpszonecontext.hashCode();
/* 112 */     _h_ += this._reportcorpspointracereq.hashCode();
/* 113 */     _h_ += this._corpspointracedata.hashCode();
/* 114 */     _h_ += this._getzonepointracecontext.hashCode();
/* 115 */     _h_ += this._getpointracedatareq.hashCode();
/* 116 */     _h_ += this._getpointraceresultreq.hashCode();
/* 117 */     _h_ += this._removepointracecontext.hashCode();
/* 118 */     _h_ += this._removepointracereq.hashCode();
/* 119 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 123 */     StringBuilder _sb_ = new StringBuilder();
/* 124 */     _sb_.append("(");
/* 125 */     _sb_.append(this._crossbattlepointret).append(",");
/* 126 */     _sb_.append(this._getcorpszonereq).append(",");
/* 127 */     _sb_.append(this._getcorpszonecontext).append(",");
/* 128 */     _sb_.append(this._reportcorpspointracereq).append(",");
/* 129 */     _sb_.append(this._corpspointracedata).append(",");
/* 130 */     _sb_.append(this._getzonepointracecontext).append(",");
/* 131 */     _sb_.append(this._getpointracedatareq).append(",");
/* 132 */     _sb_.append(this._getpointraceresultreq).append(",");
/* 133 */     _sb_.append(this._removepointracecontext).append(",");
/* 134 */     _sb_.append(this._removepointracereq).append(",");
/* 135 */     _sb_.append(")");
/* 136 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CrossBattlePointConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */