/*     */ package mzm.gsp.worldgoal;
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
/*     */ public class SGetActivityScheduleSuccess
/*     */   extends __SGetActivityScheduleSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594434;
/*     */   public int activity_cfg_id;
/*     */   public int current_section_id;
/*     */   public int current_section_point;
/*     */   public int timestamp;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594434;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetActivityScheduleSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetActivityScheduleSuccess(int _activity_cfg_id_, int _current_section_id_, int _current_section_point_, int _timestamp_)
/*     */   {
/*  39 */     this.activity_cfg_id = _activity_cfg_id_;
/*  40 */     this.current_section_id = _current_section_id_;
/*  41 */     this.current_section_point = _current_section_point_;
/*  42 */     this.timestamp = _timestamp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.activity_cfg_id);
/*  51 */     _os_.marshal(this.current_section_id);
/*  52 */     _os_.marshal(this.current_section_point);
/*  53 */     _os_.marshal(this.timestamp);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  59 */     this.current_section_id = _os_.unmarshal_int();
/*  60 */     this.current_section_point = _os_.unmarshal_int();
/*  61 */     this.timestamp = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SGetActivityScheduleSuccess)) {
/*  71 */       SGetActivityScheduleSuccess _o_ = (SGetActivityScheduleSuccess)_o1_;
/*  72 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  73 */       if (this.current_section_id != _o_.current_section_id) return false;
/*  74 */       if (this.current_section_point != _o_.current_section_point) return false;
/*  75 */       if (this.timestamp != _o_.timestamp) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.activity_cfg_id;
/*  84 */     _h_ += this.current_section_id;
/*  85 */     _h_ += this.current_section_point;
/*  86 */     _h_ += this.timestamp;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.activity_cfg_id).append(",");
/*  94 */     _sb_.append(this.current_section_id).append(",");
/*  95 */     _sb_.append(this.current_section_point).append(",");
/*  96 */     _sb_.append(this.timestamp).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetActivityScheduleSuccess _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.current_section_id - _o_.current_section_id;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.current_section_point - _o_.current_section_point;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.timestamp - _o_.timestamp;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\SGetActivityScheduleSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */