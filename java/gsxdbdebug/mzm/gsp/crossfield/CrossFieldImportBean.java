/*     */ package mzm.gsp.crossfield;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class CrossFieldImportBean implements Marshal
/*     */ {
/*     */   public CrossFieldErrorCode _crossfielderrorcode;
/*     */   public CrossFieldMatchProcess _crossbattlematchprocess;
/*     */   public CrossFieldResult _crossbattleresult;
/*     */   public GetCrossFieldRankContext _getcrossfieldrankcontext;
/*     */   public GetCrossFieldRank_ClientReq _getcrossfieldrank_clientreq;
/*     */   public GetRoleCrossFieldRankContext _getrolecrossfieldrankcontext;
/*     */   public GetRoleCrossFieldRank_ClientReq _getrolecrossfieldrank_clientreq;
/*     */   public ReportRoleCrossFieldRankInfoContext _reportrolecrossfieldrankinfocontext;
/*     */   
/*     */   public CrossFieldImportBean()
/*     */   {
/*  19 */     this._crossfielderrorcode = new CrossFieldErrorCode();
/*  20 */     this._crossbattlematchprocess = new CrossFieldMatchProcess();
/*  21 */     this._crossbattleresult = new CrossFieldResult();
/*  22 */     this._getcrossfieldrankcontext = new GetCrossFieldRankContext();
/*  23 */     this._getcrossfieldrank_clientreq = new GetCrossFieldRank_ClientReq();
/*  24 */     this._getrolecrossfieldrankcontext = new GetRoleCrossFieldRankContext();
/*  25 */     this._getrolecrossfieldrank_clientreq = new GetRoleCrossFieldRank_ClientReq();
/*  26 */     this._reportrolecrossfieldrankinfocontext = new ReportRoleCrossFieldRankInfoContext();
/*     */   }
/*     */   
/*     */   public CrossFieldImportBean(CrossFieldErrorCode __crossfielderrorcode_, CrossFieldMatchProcess __crossbattlematchprocess_, CrossFieldResult __crossbattleresult_, GetCrossFieldRankContext __getcrossfieldrankcontext_, GetCrossFieldRank_ClientReq __getcrossfieldrank_clientreq_, GetRoleCrossFieldRankContext __getrolecrossfieldrankcontext_, GetRoleCrossFieldRank_ClientReq __getrolecrossfieldrank_clientreq_, ReportRoleCrossFieldRankInfoContext __reportrolecrossfieldrankinfocontext_) {
/*  30 */     this._crossfielderrorcode = __crossfielderrorcode_;
/*  31 */     this._crossbattlematchprocess = __crossbattlematchprocess_;
/*  32 */     this._crossbattleresult = __crossbattleresult_;
/*  33 */     this._getcrossfieldrankcontext = __getcrossfieldrankcontext_;
/*  34 */     this._getcrossfieldrank_clientreq = __getcrossfieldrank_clientreq_;
/*  35 */     this._getrolecrossfieldrankcontext = __getrolecrossfieldrankcontext_;
/*  36 */     this._getrolecrossfieldrank_clientreq = __getrolecrossfieldrank_clientreq_;
/*  37 */     this._reportrolecrossfieldrankinfocontext = __reportrolecrossfieldrankinfocontext_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  41 */     if (!this._crossfielderrorcode._validator_()) return false;
/*  42 */     if (!this._crossbattlematchprocess._validator_()) return false;
/*  43 */     if (!this._crossbattleresult._validator_()) return false;
/*  44 */     if (!this._getcrossfieldrankcontext._validator_()) return false;
/*  45 */     if (!this._getcrossfieldrank_clientreq._validator_()) return false;
/*  46 */     if (!this._getrolecrossfieldrankcontext._validator_()) return false;
/*  47 */     if (!this._getrolecrossfieldrank_clientreq._validator_()) return false;
/*  48 */     if (!this._reportrolecrossfieldrankinfocontext._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this._crossfielderrorcode);
/*  54 */     _os_.marshal(this._crossbattlematchprocess);
/*  55 */     _os_.marshal(this._crossbattleresult);
/*  56 */     _os_.marshal(this._getcrossfieldrankcontext);
/*  57 */     _os_.marshal(this._getcrossfieldrank_clientreq);
/*  58 */     _os_.marshal(this._getrolecrossfieldrankcontext);
/*  59 */     _os_.marshal(this._getrolecrossfieldrank_clientreq);
/*  60 */     _os_.marshal(this._reportrolecrossfieldrankinfocontext);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  65 */     this._crossfielderrorcode.unmarshal(_os_);
/*  66 */     this._crossbattlematchprocess.unmarshal(_os_);
/*  67 */     this._crossbattleresult.unmarshal(_os_);
/*  68 */     this._getcrossfieldrankcontext.unmarshal(_os_);
/*  69 */     this._getcrossfieldrank_clientreq.unmarshal(_os_);
/*  70 */     this._getrolecrossfieldrankcontext.unmarshal(_os_);
/*  71 */     this._getrolecrossfieldrank_clientreq.unmarshal(_os_);
/*  72 */     this._reportrolecrossfieldrankinfocontext.unmarshal(_os_);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof CrossFieldImportBean)) {
/*  79 */       CrossFieldImportBean _o_ = (CrossFieldImportBean)_o1_;
/*  80 */       if (!this._crossfielderrorcode.equals(_o_._crossfielderrorcode)) return false;
/*  81 */       if (!this._crossbattlematchprocess.equals(_o_._crossbattlematchprocess)) return false;
/*  82 */       if (!this._crossbattleresult.equals(_o_._crossbattleresult)) return false;
/*  83 */       if (!this._getcrossfieldrankcontext.equals(_o_._getcrossfieldrankcontext)) return false;
/*  84 */       if (!this._getcrossfieldrank_clientreq.equals(_o_._getcrossfieldrank_clientreq)) return false;
/*  85 */       if (!this._getrolecrossfieldrankcontext.equals(_o_._getrolecrossfieldrankcontext)) return false;
/*  86 */       if (!this._getrolecrossfieldrank_clientreq.equals(_o_._getrolecrossfieldrank_clientreq)) return false;
/*  87 */       if (!this._reportrolecrossfieldrankinfocontext.equals(_o_._reportrolecrossfieldrankinfocontext)) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += this._crossfielderrorcode.hashCode();
/*  96 */     _h_ += this._crossbattlematchprocess.hashCode();
/*  97 */     _h_ += this._crossbattleresult.hashCode();
/*  98 */     _h_ += this._getcrossfieldrankcontext.hashCode();
/*  99 */     _h_ += this._getcrossfieldrank_clientreq.hashCode();
/* 100 */     _h_ += this._getrolecrossfieldrankcontext.hashCode();
/* 101 */     _h_ += this._getrolecrossfieldrank_clientreq.hashCode();
/* 102 */     _h_ += this._reportrolecrossfieldrankinfocontext.hashCode();
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this._crossfielderrorcode).append(",");
/* 110 */     _sb_.append(this._crossbattlematchprocess).append(",");
/* 111 */     _sb_.append(this._crossbattleresult).append(",");
/* 112 */     _sb_.append(this._getcrossfieldrankcontext).append(",");
/* 113 */     _sb_.append(this._getcrossfieldrank_clientreq).append(",");
/* 114 */     _sb_.append(this._getrolecrossfieldrankcontext).append(",");
/* 115 */     _sb_.append(this._getrolecrossfieldrank_clientreq).append(",");
/* 116 */     _sb_.append(this._reportrolecrossfieldrankinfocontext).append(",");
/* 117 */     _sb_.append(")");
/* 118 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\CrossFieldImportBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */