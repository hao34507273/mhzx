/*     */ package mzm.gsp.fabao;
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
/*     */ public class SChoiceRankSkillRes
/*     */   extends __SChoiceRankSkillRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596002;
/*     */   public int equiped;
/*     */   public long fabaouuid;
/*     */   public int rank;
/*     */   public int skillid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596002;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SChoiceRankSkillRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SChoiceRankSkillRes(int _equiped_, long _fabaouuid_, int _rank_, int _skillid_)
/*     */   {
/*  39 */     this.equiped = _equiped_;
/*  40 */     this.fabaouuid = _fabaouuid_;
/*  41 */     this.rank = _rank_;
/*  42 */     this.skillid = _skillid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.equiped);
/*  51 */     _os_.marshal(this.fabaouuid);
/*  52 */     _os_.marshal(this.rank);
/*  53 */     _os_.marshal(this.skillid);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.equiped = _os_.unmarshal_int();
/*  59 */     this.fabaouuid = _os_.unmarshal_long();
/*  60 */     this.rank = _os_.unmarshal_int();
/*  61 */     this.skillid = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SChoiceRankSkillRes)) {
/*  71 */       SChoiceRankSkillRes _o_ = (SChoiceRankSkillRes)_o1_;
/*  72 */       if (this.equiped != _o_.equiped) return false;
/*  73 */       if (this.fabaouuid != _o_.fabaouuid) return false;
/*  74 */       if (this.rank != _o_.rank) return false;
/*  75 */       if (this.skillid != _o_.skillid) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.equiped;
/*  84 */     _h_ += (int)this.fabaouuid;
/*  85 */     _h_ += this.rank;
/*  86 */     _h_ += this.skillid;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.equiped).append(",");
/*  94 */     _sb_.append(this.fabaouuid).append(",");
/*  95 */     _sb_.append(this.rank).append(",");
/*  96 */     _sb_.append(this.skillid).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SChoiceRankSkillRes _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.equiped - _o_.equiped;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = Long.signum(this.fabaouuid - _o_.fabaouuid);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.rank - _o_.rank;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.skillid - _o_.skillid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\SChoiceRankSkillRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */