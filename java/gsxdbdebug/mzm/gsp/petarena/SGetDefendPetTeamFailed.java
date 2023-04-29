/*     */ package mzm.gsp.petarena;
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
/*     */ public class SGetDefendPetTeamFailed
/*     */   extends __SGetDefendPetTeamFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628244;
/*     */   public static final int ERROR_LEVEL = -1;
/*     */   public static final int ERROR_RANK_CHANGED = -2;
/*     */   public static final int ERROR_OPPONENT_CHANGED = -3;
/*     */   public long target_roleid;
/*     */   public int rank;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12628244;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetDefendPetTeamFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetDefendPetTeamFailed(long _target_roleid_, int _rank_, int _retcode_)
/*     */   {
/*  42 */     this.target_roleid = _target_roleid_;
/*  43 */     this.rank = _rank_;
/*  44 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.target_roleid);
/*  53 */     _os_.marshal(this.rank);
/*  54 */     _os_.marshal(this.retcode);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.target_roleid = _os_.unmarshal_long();
/*  60 */     this.rank = _os_.unmarshal_int();
/*  61 */     this.retcode = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SGetDefendPetTeamFailed)) {
/*  71 */       SGetDefendPetTeamFailed _o_ = (SGetDefendPetTeamFailed)_o1_;
/*  72 */       if (this.target_roleid != _o_.target_roleid) return false;
/*  73 */       if (this.rank != _o_.rank) return false;
/*  74 */       if (this.retcode != _o_.retcode) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += (int)this.target_roleid;
/*  83 */     _h_ += this.rank;
/*  84 */     _h_ += this.retcode;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.target_roleid).append(",");
/*  92 */     _sb_.append(this.rank).append(",");
/*  93 */     _sb_.append(this.retcode).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetDefendPetTeamFailed _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = Long.signum(this.target_roleid - _o_.target_roleid);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.rank - _o_.rank;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.retcode - _o_.retcode;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\SGetDefendPetTeamFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */