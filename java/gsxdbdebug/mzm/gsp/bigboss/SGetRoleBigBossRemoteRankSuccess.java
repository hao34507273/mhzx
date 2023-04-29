/*     */ package mzm.gsp.bigboss;
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
/*     */ 
/*     */ public class SGetRoleBigBossRemoteRankSuccess
/*     */   extends __SGetRoleBigBossRemoteRankSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12598031;
/*     */   public int occupation;
/*     */   public int damage_point;
/*     */   public int rank;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12598031;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetRoleBigBossRemoteRankSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetRoleBigBossRemoteRankSuccess(int _occupation_, int _damage_point_, int _rank_)
/*     */   {
/*  38 */     this.occupation = _occupation_;
/*  39 */     this.damage_point = _damage_point_;
/*  40 */     this.rank = _rank_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.occupation);
/*  49 */     _os_.marshal(this.damage_point);
/*  50 */     _os_.marshal(this.rank);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.occupation = _os_.unmarshal_int();
/*  56 */     this.damage_point = _os_.unmarshal_int();
/*  57 */     this.rank = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SGetRoleBigBossRemoteRankSuccess)) {
/*  67 */       SGetRoleBigBossRemoteRankSuccess _o_ = (SGetRoleBigBossRemoteRankSuccess)_o1_;
/*  68 */       if (this.occupation != _o_.occupation) return false;
/*  69 */       if (this.damage_point != _o_.damage_point) return false;
/*  70 */       if (this.rank != _o_.rank) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.occupation;
/*  79 */     _h_ += this.damage_point;
/*  80 */     _h_ += this.rank;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.occupation).append(",");
/*  88 */     _sb_.append(this.damage_point).append(",");
/*  89 */     _sb_.append(this.rank).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetRoleBigBossRemoteRankSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.occupation - _o_.occupation;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.damage_point - _o_.damage_point;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.rank - _o_.rank;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\SGetRoleBigBossRemoteRankSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */