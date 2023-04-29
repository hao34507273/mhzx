/*     */ package mzm.gsp.crosscompete;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncFactionPlayerScoreBrd
/*     */   extends __SSyncFactionPlayerScoreBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616711;
/*     */   public long factionid1;
/*     */   public int player_score1;
/*     */   public long factionid2;
/*     */   public int player_score2;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12616711;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncFactionPlayerScoreBrd() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncFactionPlayerScoreBrd(long _factionid1_, int _player_score1_, long _factionid2_, int _player_score2_)
/*     */   {
/*  39 */     this.factionid1 = _factionid1_;
/*  40 */     this.player_score1 = _player_score1_;
/*  41 */     this.factionid2 = _factionid2_;
/*  42 */     this.player_score2 = _player_score2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.factionid1);
/*  51 */     _os_.marshal(this.player_score1);
/*  52 */     _os_.marshal(this.factionid2);
/*  53 */     _os_.marshal(this.player_score2);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.factionid1 = _os_.unmarshal_long();
/*  59 */     this.player_score1 = _os_.unmarshal_int();
/*  60 */     this.factionid2 = _os_.unmarshal_long();
/*  61 */     this.player_score2 = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SSyncFactionPlayerScoreBrd)) {
/*  71 */       SSyncFactionPlayerScoreBrd _o_ = (SSyncFactionPlayerScoreBrd)_o1_;
/*  72 */       if (this.factionid1 != _o_.factionid1) return false;
/*  73 */       if (this.player_score1 != _o_.player_score1) return false;
/*  74 */       if (this.factionid2 != _o_.factionid2) return false;
/*  75 */       if (this.player_score2 != _o_.player_score2) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.factionid1;
/*  84 */     _h_ += this.player_score1;
/*  85 */     _h_ += (int)this.factionid2;
/*  86 */     _h_ += this.player_score2;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.factionid1).append(",");
/*  94 */     _sb_.append(this.player_score1).append(",");
/*  95 */     _sb_.append(this.factionid2).append(",");
/*  96 */     _sb_.append(this.player_score2).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncFactionPlayerScoreBrd _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.factionid1 - _o_.factionid1);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.player_score1 - _o_.player_score1;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = Long.signum(this.factionid2 - _o_.factionid2);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.player_score2 - _o_.player_score2;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\SSyncFactionPlayerScoreBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */