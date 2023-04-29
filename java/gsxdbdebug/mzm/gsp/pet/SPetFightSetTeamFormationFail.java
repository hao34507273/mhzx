/*     */ package mzm.gsp.pet;
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
/*     */ public class SPetFightSetTeamFormationFail
/*     */   extends __SPetFightSetTeamFormationFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590697;
/*     */   public static final int FORMATION_NOT_AVAILABLE = 1;
/*     */   public int reason;
/*     */   public int team;
/*     */   public int formation_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590697;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPetFightSetTeamFormationFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPetFightSetTeamFormationFail(int _reason_, int _team_, int _formation_id_)
/*     */   {
/*  40 */     this.reason = _reason_;
/*  41 */     this.team = _team_;
/*  42 */     this.formation_id = _formation_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.reason);
/*  51 */     _os_.marshal(this.team);
/*  52 */     _os_.marshal(this.formation_id);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.reason = _os_.unmarshal_int();
/*  58 */     this.team = _os_.unmarshal_int();
/*  59 */     this.formation_id = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SPetFightSetTeamFormationFail)) {
/*  69 */       SPetFightSetTeamFormationFail _o_ = (SPetFightSetTeamFormationFail)_o1_;
/*  70 */       if (this.reason != _o_.reason) return false;
/*  71 */       if (this.team != _o_.team) return false;
/*  72 */       if (this.formation_id != _o_.formation_id) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.reason;
/*  81 */     _h_ += this.team;
/*  82 */     _h_ += this.formation_id;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.reason).append(",");
/*  90 */     _sb_.append(this.team).append(",");
/*  91 */     _sb_.append(this.formation_id).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPetFightSetTeamFormationFail _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.reason - _o_.reason;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.team - _o_.team;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.formation_id - _o_.formation_id;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SPetFightSetTeamFormationFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */