/*     */ package mzm.gsp.mounts;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.mounts.main.PCCostItemAddScore;
/*     */ 
/*     */ 
/*     */ public class CCostItemAddScore
/*     */   extends __CCostItemAddScore__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606242;
/*     */   public long add_score_mounts_id;
/*     */   public int item_id;
/*     */   public int item_type;
/*     */   public int is_use_all;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCCostItemAddScore(roleId, this.add_score_mounts_id, this.item_id, this.item_type, this.is_use_all));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12606242;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CCostItemAddScore() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CCostItemAddScore(long _add_score_mounts_id_, int _item_id_, int _item_type_, int _is_use_all_)
/*     */   {
/*  45 */     this.add_score_mounts_id = _add_score_mounts_id_;
/*  46 */     this.item_id = _item_id_;
/*  47 */     this.item_type = _item_type_;
/*  48 */     this.is_use_all = _is_use_all_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.add_score_mounts_id);
/*  57 */     _os_.marshal(this.item_id);
/*  58 */     _os_.marshal(this.item_type);
/*  59 */     _os_.marshal(this.is_use_all);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.add_score_mounts_id = _os_.unmarshal_long();
/*  65 */     this.item_id = _os_.unmarshal_int();
/*  66 */     this.item_type = _os_.unmarshal_int();
/*  67 */     this.is_use_all = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CCostItemAddScore)) {
/*  77 */       CCostItemAddScore _o_ = (CCostItemAddScore)_o1_;
/*  78 */       if (this.add_score_mounts_id != _o_.add_score_mounts_id) return false;
/*  79 */       if (this.item_id != _o_.item_id) return false;
/*  80 */       if (this.item_type != _o_.item_type) return false;
/*  81 */       if (this.is_use_all != _o_.is_use_all) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += (int)this.add_score_mounts_id;
/*  90 */     _h_ += this.item_id;
/*  91 */     _h_ += this.item_type;
/*  92 */     _h_ += this.is_use_all;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.add_score_mounts_id).append(",");
/* 100 */     _sb_.append(this.item_id).append(",");
/* 101 */     _sb_.append(this.item_type).append(",");
/* 102 */     _sb_.append(this.is_use_all).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CCostItemAddScore _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = Long.signum(this.add_score_mounts_id - _o_.add_score_mounts_id);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.item_id - _o_.item_id;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.item_type - _o_.item_type;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = this.is_use_all - _o_.is_use_all;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\CCostItemAddScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */