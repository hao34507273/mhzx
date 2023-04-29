/*     */ package mzm.gsp.pk;
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
/*     */ public class SUseRevengeItemSuccess
/*     */   extends __SUseRevengeItemSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12619793;
/*     */   public int map_id;
/*     */   public int pos_x;
/*     */   public int pos_y;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12619793;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseRevengeItemSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseRevengeItemSuccess(int _map_id_, int _pos_x_, int _pos_y_)
/*     */   {
/*  38 */     this.map_id = _map_id_;
/*  39 */     this.pos_x = _pos_x_;
/*  40 */     this.pos_y = _pos_y_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.map_id);
/*  49 */     _os_.marshal(this.pos_x);
/*  50 */     _os_.marshal(this.pos_y);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.map_id = _os_.unmarshal_int();
/*  56 */     this.pos_x = _os_.unmarshal_int();
/*  57 */     this.pos_y = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SUseRevengeItemSuccess)) {
/*  67 */       SUseRevengeItemSuccess _o_ = (SUseRevengeItemSuccess)_o1_;
/*  68 */       if (this.map_id != _o_.map_id) return false;
/*  69 */       if (this.pos_x != _o_.pos_x) return false;
/*  70 */       if (this.pos_y != _o_.pos_y) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.map_id;
/*  79 */     _h_ += this.pos_x;
/*  80 */     _h_ += this.pos_y;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.map_id).append(",");
/*  88 */     _sb_.append(this.pos_x).append(",");
/*  89 */     _sb_.append(this.pos_y).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUseRevengeItemSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.map_id - _o_.map_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.pos_x - _o_.pos_x;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.pos_y - _o_.pos_y;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\SUseRevengeItemSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */