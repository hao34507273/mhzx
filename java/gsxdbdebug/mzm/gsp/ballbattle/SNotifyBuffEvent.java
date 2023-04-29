/*     */ package mzm.gsp.ballbattle;
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
/*     */ public class SNotifyBuffEvent
/*     */   extends __SNotifyBuffEvent__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12629249;
/*     */   public long role_id;
/*     */   public int buff_type;
/*     */   public int position_x;
/*     */   public int position_y;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12629249;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SNotifyBuffEvent() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SNotifyBuffEvent(long _role_id_, int _buff_type_, int _position_x_, int _position_y_)
/*     */   {
/*  39 */     this.role_id = _role_id_;
/*  40 */     this.buff_type = _buff_type_;
/*  41 */     this.position_x = _position_x_;
/*  42 */     this.position_y = _position_y_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.role_id);
/*  51 */     _os_.marshal(this.buff_type);
/*  52 */     _os_.marshal(this.position_x);
/*  53 */     _os_.marshal(this.position_y);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.role_id = _os_.unmarshal_long();
/*  59 */     this.buff_type = _os_.unmarshal_int();
/*  60 */     this.position_x = _os_.unmarshal_int();
/*  61 */     this.position_y = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SNotifyBuffEvent)) {
/*  71 */       SNotifyBuffEvent _o_ = (SNotifyBuffEvent)_o1_;
/*  72 */       if (this.role_id != _o_.role_id) return false;
/*  73 */       if (this.buff_type != _o_.buff_type) return false;
/*  74 */       if (this.position_x != _o_.position_x) return false;
/*  75 */       if (this.position_y != _o_.position_y) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.role_id;
/*  84 */     _h_ += this.buff_type;
/*  85 */     _h_ += this.position_x;
/*  86 */     _h_ += this.position_y;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.role_id).append(",");
/*  94 */     _sb_.append(this.buff_type).append(",");
/*  95 */     _sb_.append(this.position_x).append(",");
/*  96 */     _sb_.append(this.position_y).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SNotifyBuffEvent _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.role_id - _o_.role_id);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.buff_type - _o_.buff_type;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.position_x - _o_.position_x;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.position_y - _o_.position_y;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\SNotifyBuffEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */