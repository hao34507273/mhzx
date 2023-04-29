/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class CrossBattleBetImportBean implements Marshal
/*     */ {
/*     */   public GetCrossBattleBetRankContext _getcrossbattlebetrankcontext;
/*     */   public GetCrossBattleBetRank_ClientReq _getcrossbattlebetrank_clientreq;
/*     */   public GetRoleCrossBattleBetRankContext _getrolecrossbattlebetrankcontext;
/*     */   public GetRoleCrossBattleBetRank_ClientReq _getrolecrossbattlebetrank_clientreq;
/*     */   public ReportRoleCrossBattleBetRankInfoContext _reportrolecrossbattlebetrankinfocontext;
/*     */   public RemoveRoleCrossBattleBetRankInfoContext _removerolecrossbattlebetrankinfocontext;
/*     */   
/*     */   public CrossBattleBetImportBean()
/*     */   {
/*  17 */     this._getcrossbattlebetrankcontext = new GetCrossBattleBetRankContext();
/*  18 */     this._getcrossbattlebetrank_clientreq = new GetCrossBattleBetRank_ClientReq();
/*  19 */     this._getrolecrossbattlebetrankcontext = new GetRoleCrossBattleBetRankContext();
/*  20 */     this._getrolecrossbattlebetrank_clientreq = new GetRoleCrossBattleBetRank_ClientReq();
/*  21 */     this._reportrolecrossbattlebetrankinfocontext = new ReportRoleCrossBattleBetRankInfoContext();
/*  22 */     this._removerolecrossbattlebetrankinfocontext = new RemoveRoleCrossBattleBetRankInfoContext();
/*     */   }
/*     */   
/*     */   public CrossBattleBetImportBean(GetCrossBattleBetRankContext __getcrossbattlebetrankcontext_, GetCrossBattleBetRank_ClientReq __getcrossbattlebetrank_clientreq_, GetRoleCrossBattleBetRankContext __getrolecrossbattlebetrankcontext_, GetRoleCrossBattleBetRank_ClientReq __getrolecrossbattlebetrank_clientreq_, ReportRoleCrossBattleBetRankInfoContext __reportrolecrossbattlebetrankinfocontext_, RemoveRoleCrossBattleBetRankInfoContext __removerolecrossbattlebetrankinfocontext_) {
/*  26 */     this._getcrossbattlebetrankcontext = __getcrossbattlebetrankcontext_;
/*  27 */     this._getcrossbattlebetrank_clientreq = __getcrossbattlebetrank_clientreq_;
/*  28 */     this._getrolecrossbattlebetrankcontext = __getrolecrossbattlebetrankcontext_;
/*  29 */     this._getrolecrossbattlebetrank_clientreq = __getrolecrossbattlebetrank_clientreq_;
/*  30 */     this._reportrolecrossbattlebetrankinfocontext = __reportrolecrossbattlebetrankinfocontext_;
/*  31 */     this._removerolecrossbattlebetrankinfocontext = __removerolecrossbattlebetrankinfocontext_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  35 */     if (!this._getcrossbattlebetrankcontext._validator_()) return false;
/*  36 */     if (!this._getcrossbattlebetrank_clientreq._validator_()) return false;
/*  37 */     if (!this._getrolecrossbattlebetrankcontext._validator_()) return false;
/*  38 */     if (!this._getrolecrossbattlebetrank_clientreq._validator_()) return false;
/*  39 */     if (!this._reportrolecrossbattlebetrankinfocontext._validator_()) return false;
/*  40 */     if (!this._removerolecrossbattlebetrankinfocontext._validator_()) return false;
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  45 */     _os_.marshal(this._getcrossbattlebetrankcontext);
/*  46 */     _os_.marshal(this._getcrossbattlebetrank_clientreq);
/*  47 */     _os_.marshal(this._getrolecrossbattlebetrankcontext);
/*  48 */     _os_.marshal(this._getrolecrossbattlebetrank_clientreq);
/*  49 */     _os_.marshal(this._reportrolecrossbattlebetrankinfocontext);
/*  50 */     _os_.marshal(this._removerolecrossbattlebetrankinfocontext);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  55 */     this._getcrossbattlebetrankcontext.unmarshal(_os_);
/*  56 */     this._getcrossbattlebetrank_clientreq.unmarshal(_os_);
/*  57 */     this._getrolecrossbattlebetrankcontext.unmarshal(_os_);
/*  58 */     this._getrolecrossbattlebetrank_clientreq.unmarshal(_os_);
/*  59 */     this._reportrolecrossbattlebetrankinfocontext.unmarshal(_os_);
/*  60 */     this._removerolecrossbattlebetrankinfocontext.unmarshal(_os_);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof CrossBattleBetImportBean)) {
/*  67 */       CrossBattleBetImportBean _o_ = (CrossBattleBetImportBean)_o1_;
/*  68 */       if (!this._getcrossbattlebetrankcontext.equals(_o_._getcrossbattlebetrankcontext)) return false;
/*  69 */       if (!this._getcrossbattlebetrank_clientreq.equals(_o_._getcrossbattlebetrank_clientreq)) return false;
/*  70 */       if (!this._getrolecrossbattlebetrankcontext.equals(_o_._getrolecrossbattlebetrankcontext)) return false;
/*  71 */       if (!this._getrolecrossbattlebetrank_clientreq.equals(_o_._getrolecrossbattlebetrank_clientreq)) return false;
/*  72 */       if (!this._reportrolecrossbattlebetrankinfocontext.equals(_o_._reportrolecrossbattlebetrankinfocontext)) return false;
/*  73 */       if (!this._removerolecrossbattlebetrankinfocontext.equals(_o_._removerolecrossbattlebetrankinfocontext)) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this._getcrossbattlebetrankcontext.hashCode();
/*  82 */     _h_ += this._getcrossbattlebetrank_clientreq.hashCode();
/*  83 */     _h_ += this._getrolecrossbattlebetrankcontext.hashCode();
/*  84 */     _h_ += this._getrolecrossbattlebetrank_clientreq.hashCode();
/*  85 */     _h_ += this._reportrolecrossbattlebetrankinfocontext.hashCode();
/*  86 */     _h_ += this._removerolecrossbattlebetrankinfocontext.hashCode();
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this._getcrossbattlebetrankcontext).append(",");
/*  94 */     _sb_.append(this._getcrossbattlebetrank_clientreq).append(",");
/*  95 */     _sb_.append(this._getrolecrossbattlebetrankcontext).append(",");
/*  96 */     _sb_.append(this._getrolecrossbattlebetrank_clientreq).append(",");
/*  97 */     _sb_.append(this._reportrolecrossbattlebetrankinfocontext).append(",");
/*  98 */     _sb_.append(this._removerolecrossbattlebetrankinfocontext).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CrossBattleBetImportBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */