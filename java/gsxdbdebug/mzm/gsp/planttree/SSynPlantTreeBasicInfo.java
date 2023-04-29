/*     */ package mzm.gsp.planttree;
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
/*     */ public class SSynPlantTreeBasicInfo
/*     */   extends __SSynPlantTreeBasicInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12611597;
/*     */   public long owner_id;
/*     */   public int activity_cfg_id;
/*     */   public int current_section_id;
/*     */   public int current_section_point;
/*     */   public int special_state_index;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12611597;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynPlantTreeBasicInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynPlantTreeBasicInfo(long _owner_id_, int _activity_cfg_id_, int _current_section_id_, int _current_section_point_, int _special_state_index_)
/*     */   {
/*  40 */     this.owner_id = _owner_id_;
/*  41 */     this.activity_cfg_id = _activity_cfg_id_;
/*  42 */     this.current_section_id = _current_section_id_;
/*  43 */     this.current_section_point = _current_section_point_;
/*  44 */     this.special_state_index = _special_state_index_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.owner_id);
/*  53 */     _os_.marshal(this.activity_cfg_id);
/*  54 */     _os_.marshal(this.current_section_id);
/*  55 */     _os_.marshal(this.current_section_point);
/*  56 */     _os_.marshal(this.special_state_index);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.owner_id = _os_.unmarshal_long();
/*  62 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  63 */     this.current_section_id = _os_.unmarshal_int();
/*  64 */     this.current_section_point = _os_.unmarshal_int();
/*  65 */     this.special_state_index = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SSynPlantTreeBasicInfo)) {
/*  75 */       SSynPlantTreeBasicInfo _o_ = (SSynPlantTreeBasicInfo)_o1_;
/*  76 */       if (this.owner_id != _o_.owner_id) return false;
/*  77 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  78 */       if (this.current_section_id != _o_.current_section_id) return false;
/*  79 */       if (this.current_section_point != _o_.current_section_point) return false;
/*  80 */       if (this.special_state_index != _o_.special_state_index) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += (int)this.owner_id;
/*  89 */     _h_ += this.activity_cfg_id;
/*  90 */     _h_ += this.current_section_id;
/*  91 */     _h_ += this.current_section_point;
/*  92 */     _h_ += this.special_state_index;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.owner_id).append(",");
/* 100 */     _sb_.append(this.activity_cfg_id).append(",");
/* 101 */     _sb_.append(this.current_section_id).append(",");
/* 102 */     _sb_.append(this.current_section_point).append(",");
/* 103 */     _sb_.append(this.special_state_index).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynPlantTreeBasicInfo _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = Long.signum(this.owner_id - _o_.owner_id);
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.current_section_id - _o_.current_section_id;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.current_section_point - _o_.current_section_point;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.special_state_index - _o_.special_state_index;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\SSynPlantTreeBasicInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */