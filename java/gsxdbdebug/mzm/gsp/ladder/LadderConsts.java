/*     */ package mzm.gsp.ladder;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class LadderConsts implements Marshal
/*     */ {
/*     */   public GetLadderRankRangeContext _getladderrankrangecontext;
/*     */   public GetLadderRankRange_ClientReq _getladderrankrange_clientreq;
/*     */   public GetLadderRankRange_SendRankAward _getladderrankrange_sendrankaward;
/*     */   public GetLadderRoleRankContext _getladderrolerankcontext;
/*     */   public GetLadderRoleRank_SelfReq _getladderrolerank_selfreq;
/*     */   public ReportLadderRankInfoContext _reportladderrankinfocontext;
/*     */   public RemoveLadderRankInfoContext _removeladderrankinfocontext;
/*     */   public CleanLadderRankContext _cleanladderrankcontext;
/*     */   public LadderErrorCode _laddererrorcode;
/*     */   
/*     */   public LadderConsts()
/*     */   {
/*  20 */     this._getladderrankrangecontext = new GetLadderRankRangeContext();
/*  21 */     this._getladderrankrange_clientreq = new GetLadderRankRange_ClientReq();
/*  22 */     this._getladderrankrange_sendrankaward = new GetLadderRankRange_SendRankAward();
/*  23 */     this._getladderrolerankcontext = new GetLadderRoleRankContext();
/*  24 */     this._getladderrolerank_selfreq = new GetLadderRoleRank_SelfReq();
/*  25 */     this._reportladderrankinfocontext = new ReportLadderRankInfoContext();
/*  26 */     this._removeladderrankinfocontext = new RemoveLadderRankInfoContext();
/*  27 */     this._cleanladderrankcontext = new CleanLadderRankContext();
/*  28 */     this._laddererrorcode = new LadderErrorCode();
/*     */   }
/*     */   
/*     */   public LadderConsts(GetLadderRankRangeContext __getladderrankrangecontext_, GetLadderRankRange_ClientReq __getladderrankrange_clientreq_, GetLadderRankRange_SendRankAward __getladderrankrange_sendrankaward_, GetLadderRoleRankContext __getladderrolerankcontext_, GetLadderRoleRank_SelfReq __getladderrolerank_selfreq_, ReportLadderRankInfoContext __reportladderrankinfocontext_, RemoveLadderRankInfoContext __removeladderrankinfocontext_, CleanLadderRankContext __cleanladderrankcontext_, LadderErrorCode __laddererrorcode_) {
/*  32 */     this._getladderrankrangecontext = __getladderrankrangecontext_;
/*  33 */     this._getladderrankrange_clientreq = __getladderrankrange_clientreq_;
/*  34 */     this._getladderrankrange_sendrankaward = __getladderrankrange_sendrankaward_;
/*  35 */     this._getladderrolerankcontext = __getladderrolerankcontext_;
/*  36 */     this._getladderrolerank_selfreq = __getladderrolerank_selfreq_;
/*  37 */     this._reportladderrankinfocontext = __reportladderrankinfocontext_;
/*  38 */     this._removeladderrankinfocontext = __removeladderrankinfocontext_;
/*  39 */     this._cleanladderrankcontext = __cleanladderrankcontext_;
/*  40 */     this._laddererrorcode = __laddererrorcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     if (!this._getladderrankrangecontext._validator_()) return false;
/*  45 */     if (!this._getladderrankrange_clientreq._validator_()) return false;
/*  46 */     if (!this._getladderrankrange_sendrankaward._validator_()) return false;
/*  47 */     if (!this._getladderrolerankcontext._validator_()) return false;
/*  48 */     if (!this._getladderrolerank_selfreq._validator_()) return false;
/*  49 */     if (!this._reportladderrankinfocontext._validator_()) return false;
/*  50 */     if (!this._removeladderrankinfocontext._validator_()) return false;
/*  51 */     if (!this._cleanladderrankcontext._validator_()) return false;
/*  52 */     if (!this._laddererrorcode._validator_()) return false;
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this._getladderrankrangecontext);
/*  58 */     _os_.marshal(this._getladderrankrange_clientreq);
/*  59 */     _os_.marshal(this._getladderrankrange_sendrankaward);
/*  60 */     _os_.marshal(this._getladderrolerankcontext);
/*  61 */     _os_.marshal(this._getladderrolerank_selfreq);
/*  62 */     _os_.marshal(this._reportladderrankinfocontext);
/*  63 */     _os_.marshal(this._removeladderrankinfocontext);
/*  64 */     _os_.marshal(this._cleanladderrankcontext);
/*  65 */     _os_.marshal(this._laddererrorcode);
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  70 */     this._getladderrankrangecontext.unmarshal(_os_);
/*  71 */     this._getladderrankrange_clientreq.unmarshal(_os_);
/*  72 */     this._getladderrankrange_sendrankaward.unmarshal(_os_);
/*  73 */     this._getladderrolerankcontext.unmarshal(_os_);
/*  74 */     this._getladderrolerank_selfreq.unmarshal(_os_);
/*  75 */     this._reportladderrankinfocontext.unmarshal(_os_);
/*  76 */     this._removeladderrankinfocontext.unmarshal(_os_);
/*  77 */     this._cleanladderrankcontext.unmarshal(_os_);
/*  78 */     this._laddererrorcode.unmarshal(_os_);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof LadderConsts)) {
/*  85 */       LadderConsts _o_ = (LadderConsts)_o1_;
/*  86 */       if (!this._getladderrankrangecontext.equals(_o_._getladderrankrangecontext)) return false;
/*  87 */       if (!this._getladderrankrange_clientreq.equals(_o_._getladderrankrange_clientreq)) return false;
/*  88 */       if (!this._getladderrankrange_sendrankaward.equals(_o_._getladderrankrange_sendrankaward)) return false;
/*  89 */       if (!this._getladderrolerankcontext.equals(_o_._getladderrolerankcontext)) return false;
/*  90 */       if (!this._getladderrolerank_selfreq.equals(_o_._getladderrolerank_selfreq)) return false;
/*  91 */       if (!this._reportladderrankinfocontext.equals(_o_._reportladderrankinfocontext)) return false;
/*  92 */       if (!this._removeladderrankinfocontext.equals(_o_._removeladderrankinfocontext)) return false;
/*  93 */       if (!this._cleanladderrankcontext.equals(_o_._cleanladderrankcontext)) return false;
/*  94 */       if (!this._laddererrorcode.equals(_o_._laddererrorcode)) return false;
/*  95 */       return true;
/*     */     }
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 101 */     int _h_ = 0;
/* 102 */     _h_ += this._getladderrankrangecontext.hashCode();
/* 103 */     _h_ += this._getladderrankrange_clientreq.hashCode();
/* 104 */     _h_ += this._getladderrankrange_sendrankaward.hashCode();
/* 105 */     _h_ += this._getladderrolerankcontext.hashCode();
/* 106 */     _h_ += this._getladderrolerank_selfreq.hashCode();
/* 107 */     _h_ += this._reportladderrankinfocontext.hashCode();
/* 108 */     _h_ += this._removeladderrankinfocontext.hashCode();
/* 109 */     _h_ += this._cleanladderrankcontext.hashCode();
/* 110 */     _h_ += this._laddererrorcode.hashCode();
/* 111 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 115 */     StringBuilder _sb_ = new StringBuilder();
/* 116 */     _sb_.append("(");
/* 117 */     _sb_.append(this._getladderrankrangecontext).append(",");
/* 118 */     _sb_.append(this._getladderrankrange_clientreq).append(",");
/* 119 */     _sb_.append(this._getladderrankrange_sendrankaward).append(",");
/* 120 */     _sb_.append(this._getladderrolerankcontext).append(",");
/* 121 */     _sb_.append(this._getladderrolerank_selfreq).append(",");
/* 122 */     _sb_.append(this._reportladderrankinfocontext).append(",");
/* 123 */     _sb_.append(this._removeladderrankinfocontext).append(",");
/* 124 */     _sb_.append(this._cleanladderrankcontext).append(",");
/* 125 */     _sb_.append(this._laddererrorcode).append(",");
/* 126 */     _sb_.append(")");
/* 127 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\LadderConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */