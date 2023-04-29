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
/*     */ public class SBetInSelectionSuccess
/*     */   extends __SBetInSelectionSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617042;
/*     */   public int activity_cfg_id;
/*     */   public int fight_zone_id;
/*     */   public int selection_stage;
/*     */   public int fight_index;
/*     */   public long target_corps_id;
/*     */   public int sortid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617042;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBetInSelectionSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBetInSelectionSuccess(int _activity_cfg_id_, int _fight_zone_id_, int _selection_stage_, int _fight_index_, long _target_corps_id_, int _sortid_)
/*     */   {
/*  41 */     this.activity_cfg_id = _activity_cfg_id_;
/*  42 */     this.fight_zone_id = _fight_zone_id_;
/*  43 */     this.selection_stage = _selection_stage_;
/*  44 */     this.fight_index = _fight_index_;
/*  45 */     this.target_corps_id = _target_corps_id_;
/*  46 */     this.sortid = _sortid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.activity_cfg_id);
/*  55 */     _os_.marshal(this.fight_zone_id);
/*  56 */     _os_.marshal(this.selection_stage);
/*  57 */     _os_.marshal(this.fight_index);
/*  58 */     _os_.marshal(this.target_corps_id);
/*  59 */     _os_.marshal(this.sortid);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  65 */     this.fight_zone_id = _os_.unmarshal_int();
/*  66 */     this.selection_stage = _os_.unmarshal_int();
/*  67 */     this.fight_index = _os_.unmarshal_int();
/*  68 */     this.target_corps_id = _os_.unmarshal_long();
/*  69 */     this.sortid = _os_.unmarshal_int();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SBetInSelectionSuccess)) {
/*  79 */       SBetInSelectionSuccess _o_ = (SBetInSelectionSuccess)_o1_;
/*  80 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  81 */       if (this.fight_zone_id != _o_.fight_zone_id) return false;
/*  82 */       if (this.selection_stage != _o_.selection_stage) return false;
/*  83 */       if (this.fight_index != _o_.fight_index) return false;
/*  84 */       if (this.target_corps_id != _o_.target_corps_id) return false;
/*  85 */       if (this.sortid != _o_.sortid) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.activity_cfg_id;
/*  94 */     _h_ += this.fight_zone_id;
/*  95 */     _h_ += this.selection_stage;
/*  96 */     _h_ += this.fight_index;
/*  97 */     _h_ += (int)this.target_corps_id;
/*  98 */     _h_ += this.sortid;
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.activity_cfg_id).append(",");
/* 106 */     _sb_.append(this.fight_zone_id).append(",");
/* 107 */     _sb_.append(this.selection_stage).append(",");
/* 108 */     _sb_.append(this.fight_index).append(",");
/* 109 */     _sb_.append(this.target_corps_id).append(",");
/* 110 */     _sb_.append(this.sortid).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBetInSelectionSuccess _o_) {
/* 116 */     if (_o_ == this) return 0;
/* 117 */     int _c_ = 0;
/* 118 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = this.fight_zone_id - _o_.fight_zone_id;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.selection_stage - _o_.selection_stage;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.fight_index - _o_.fight_index;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = Long.signum(this.target_corps_id - _o_.target_corps_id);
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     _c_ = this.sortid - _o_.sortid;
/* 129 */     if (0 != _c_) return _c_;
/* 130 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SBetInSelectionSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */