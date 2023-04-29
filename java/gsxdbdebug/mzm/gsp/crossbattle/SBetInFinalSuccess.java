/*     */ package mzm.gsp.crossbattle;
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
/*     */ public class SBetInFinalSuccess
/*     */   extends __SBetInFinalSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617075;
/*     */   public int activity_cfg_id;
/*     */   public int stage;
/*     */   public int fight_index;
/*     */   public long target_corps_id;
/*     */   public int sortid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617075;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBetInFinalSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBetInFinalSuccess(int _activity_cfg_id_, int _stage_, int _fight_index_, long _target_corps_id_, int _sortid_)
/*     */   {
/*  40 */     this.activity_cfg_id = _activity_cfg_id_;
/*  41 */     this.stage = _stage_;
/*  42 */     this.fight_index = _fight_index_;
/*  43 */     this.target_corps_id = _target_corps_id_;
/*  44 */     this.sortid = _sortid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activity_cfg_id);
/*  53 */     _os_.marshal(this.stage);
/*  54 */     _os_.marshal(this.fight_index);
/*  55 */     _os_.marshal(this.target_corps_id);
/*  56 */     _os_.marshal(this.sortid);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  62 */     this.stage = _os_.unmarshal_int();
/*  63 */     this.fight_index = _os_.unmarshal_int();
/*  64 */     this.target_corps_id = _os_.unmarshal_long();
/*  65 */     this.sortid = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SBetInFinalSuccess)) {
/*  75 */       SBetInFinalSuccess _o_ = (SBetInFinalSuccess)_o1_;
/*  76 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  77 */       if (this.stage != _o_.stage) return false;
/*  78 */       if (this.fight_index != _o_.fight_index) return false;
/*  79 */       if (this.target_corps_id != _o_.target_corps_id) return false;
/*  80 */       if (this.sortid != _o_.sortid) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.activity_cfg_id;
/*  89 */     _h_ += this.stage;
/*  90 */     _h_ += this.fight_index;
/*  91 */     _h_ += (int)this.target_corps_id;
/*  92 */     _h_ += this.sortid;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.activity_cfg_id).append(",");
/* 100 */     _sb_.append(this.stage).append(",");
/* 101 */     _sb_.append(this.fight_index).append(",");
/* 102 */     _sb_.append(this.target_corps_id).append(",");
/* 103 */     _sb_.append(this.sortid).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBetInFinalSuccess _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.stage - _o_.stage;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.fight_index - _o_.fight_index;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = Long.signum(this.target_corps_id - _o_.target_corps_id);
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.sortid - _o_.sortid;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SBetInFinalSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */