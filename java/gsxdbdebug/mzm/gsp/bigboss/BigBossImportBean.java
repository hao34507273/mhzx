/*     */ package mzm.gsp.bigboss;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class BigBossImportBean implements Marshal
/*     */ {
/*     */   public BigBossErrorCode _bigbosserrorcode;
/*     */   public GetBigBossRemoteRankContext _getbigbossremoterankcontext;
/*     */   public GetBigBossRemoteRank_ClientReq _getbigbossremoterank_clientreq;
/*     */   public GetRoleBigBossRemoteRankContext _getrolebigbossremoterankcontext;
/*     */   public GetRoleBigBossRemoteRank_ClientReq _getrolebigbossremoterank_clientreq;
/*     */   public ReportRoleBigBossRemoteRankInfoContext _reportrolebigbossremoterankinfocontext;
/*     */   public RemoveRoleBigBossRemoteRankInfoContext _removerolebigbossremoterankinfocontext;
/*     */   
/*     */   public BigBossImportBean()
/*     */   {
/*  18 */     this._bigbosserrorcode = new BigBossErrorCode();
/*  19 */     this._getbigbossremoterankcontext = new GetBigBossRemoteRankContext();
/*  20 */     this._getbigbossremoterank_clientreq = new GetBigBossRemoteRank_ClientReq();
/*  21 */     this._getrolebigbossremoterankcontext = new GetRoleBigBossRemoteRankContext();
/*  22 */     this._getrolebigbossremoterank_clientreq = new GetRoleBigBossRemoteRank_ClientReq();
/*  23 */     this._reportrolebigbossremoterankinfocontext = new ReportRoleBigBossRemoteRankInfoContext();
/*  24 */     this._removerolebigbossremoterankinfocontext = new RemoveRoleBigBossRemoteRankInfoContext();
/*     */   }
/*     */   
/*     */   public BigBossImportBean(BigBossErrorCode __bigbosserrorcode_, GetBigBossRemoteRankContext __getbigbossremoterankcontext_, GetBigBossRemoteRank_ClientReq __getbigbossremoterank_clientreq_, GetRoleBigBossRemoteRankContext __getrolebigbossremoterankcontext_, GetRoleBigBossRemoteRank_ClientReq __getrolebigbossremoterank_clientreq_, ReportRoleBigBossRemoteRankInfoContext __reportrolebigbossremoterankinfocontext_, RemoveRoleBigBossRemoteRankInfoContext __removerolebigbossremoterankinfocontext_) {
/*  28 */     this._bigbosserrorcode = __bigbosserrorcode_;
/*  29 */     this._getbigbossremoterankcontext = __getbigbossremoterankcontext_;
/*  30 */     this._getbigbossremoterank_clientreq = __getbigbossremoterank_clientreq_;
/*  31 */     this._getrolebigbossremoterankcontext = __getrolebigbossremoterankcontext_;
/*  32 */     this._getrolebigbossremoterank_clientreq = __getrolebigbossremoterank_clientreq_;
/*  33 */     this._reportrolebigbossremoterankinfocontext = __reportrolebigbossremoterankinfocontext_;
/*  34 */     this._removerolebigbossremoterankinfocontext = __removerolebigbossremoterankinfocontext_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  38 */     if (!this._bigbosserrorcode._validator_()) return false;
/*  39 */     if (!this._getbigbossremoterankcontext._validator_()) return false;
/*  40 */     if (!this._getbigbossremoterank_clientreq._validator_()) return false;
/*  41 */     if (!this._getrolebigbossremoterankcontext._validator_()) return false;
/*  42 */     if (!this._getrolebigbossremoterank_clientreq._validator_()) return false;
/*  43 */     if (!this._reportrolebigbossremoterankinfocontext._validator_()) return false;
/*  44 */     if (!this._removerolebigbossremoterankinfocontext._validator_()) return false;
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this._bigbosserrorcode);
/*  50 */     _os_.marshal(this._getbigbossremoterankcontext);
/*  51 */     _os_.marshal(this._getbigbossremoterank_clientreq);
/*  52 */     _os_.marshal(this._getrolebigbossremoterankcontext);
/*  53 */     _os_.marshal(this._getrolebigbossremoterank_clientreq);
/*  54 */     _os_.marshal(this._reportrolebigbossremoterankinfocontext);
/*  55 */     _os_.marshal(this._removerolebigbossremoterankinfocontext);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  60 */     this._bigbosserrorcode.unmarshal(_os_);
/*  61 */     this._getbigbossremoterankcontext.unmarshal(_os_);
/*  62 */     this._getbigbossremoterank_clientreq.unmarshal(_os_);
/*  63 */     this._getrolebigbossremoterankcontext.unmarshal(_os_);
/*  64 */     this._getrolebigbossremoterank_clientreq.unmarshal(_os_);
/*  65 */     this._reportrolebigbossremoterankinfocontext.unmarshal(_os_);
/*  66 */     this._removerolebigbossremoterankinfocontext.unmarshal(_os_);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof BigBossImportBean)) {
/*  73 */       BigBossImportBean _o_ = (BigBossImportBean)_o1_;
/*  74 */       if (!this._bigbosserrorcode.equals(_o_._bigbosserrorcode)) return false;
/*  75 */       if (!this._getbigbossremoterankcontext.equals(_o_._getbigbossremoterankcontext)) return false;
/*  76 */       if (!this._getbigbossremoterank_clientreq.equals(_o_._getbigbossremoterank_clientreq)) return false;
/*  77 */       if (!this._getrolebigbossremoterankcontext.equals(_o_._getrolebigbossremoterankcontext)) return false;
/*  78 */       if (!this._getrolebigbossremoterank_clientreq.equals(_o_._getrolebigbossremoterank_clientreq)) return false;
/*  79 */       if (!this._reportrolebigbossremoterankinfocontext.equals(_o_._reportrolebigbossremoterankinfocontext)) return false;
/*  80 */       if (!this._removerolebigbossremoterankinfocontext.equals(_o_._removerolebigbossremoterankinfocontext)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this._bigbosserrorcode.hashCode();
/*  89 */     _h_ += this._getbigbossremoterankcontext.hashCode();
/*  90 */     _h_ += this._getbigbossremoterank_clientreq.hashCode();
/*  91 */     _h_ += this._getrolebigbossremoterankcontext.hashCode();
/*  92 */     _h_ += this._getrolebigbossremoterank_clientreq.hashCode();
/*  93 */     _h_ += this._reportrolebigbossremoterankinfocontext.hashCode();
/*  94 */     _h_ += this._removerolebigbossremoterankinfocontext.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this._bigbosserrorcode).append(",");
/* 102 */     _sb_.append(this._getbigbossremoterankcontext).append(",");
/* 103 */     _sb_.append(this._getbigbossremoterank_clientreq).append(",");
/* 104 */     _sb_.append(this._getrolebigbossremoterankcontext).append(",");
/* 105 */     _sb_.append(this._getrolebigbossremoterank_clientreq).append(",");
/* 106 */     _sb_.append(this._reportrolebigbossremoterankinfocontext).append(",");
/* 107 */     _sb_.append(this._removerolebigbossremoterankinfocontext).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\BigBossImportBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */