/*     */ package mzm.gsp.cookiecake;
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
/*     */ public class SCreateItemSuccess
/*     */   extends __SCreateItemSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623875;
/*     */   public int activity_id;
/*     */   public int create_item_id;
/*     */   public int create_num;
/*     */   public int action_type;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12623875;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCreateItemSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SCreateItemSuccess(int _activity_id_, int _create_item_id_, int _create_num_, int _action_type_)
/*     */   {
/*  39 */     this.activity_id = _activity_id_;
/*  40 */     this.create_item_id = _create_item_id_;
/*  41 */     this.create_num = _create_num_;
/*  42 */     this.action_type = _action_type_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.activity_id);
/*  51 */     _os_.marshal(this.create_item_id);
/*  52 */     _os_.marshal(this.create_num);
/*  53 */     _os_.marshal(this.action_type);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.activity_id = _os_.unmarshal_int();
/*  59 */     this.create_item_id = _os_.unmarshal_int();
/*  60 */     this.create_num = _os_.unmarshal_int();
/*  61 */     this.action_type = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SCreateItemSuccess)) {
/*  71 */       SCreateItemSuccess _o_ = (SCreateItemSuccess)_o1_;
/*  72 */       if (this.activity_id != _o_.activity_id) return false;
/*  73 */       if (this.create_item_id != _o_.create_item_id) return false;
/*  74 */       if (this.create_num != _o_.create_num) return false;
/*  75 */       if (this.action_type != _o_.action_type) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.activity_id;
/*  84 */     _h_ += this.create_item_id;
/*  85 */     _h_ += this.create_num;
/*  86 */     _h_ += this.action_type;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.activity_id).append(",");
/*  94 */     _sb_.append(this.create_item_id).append(",");
/*  95 */     _sb_.append(this.create_num).append(",");
/*  96 */     _sb_.append(this.action_type).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SCreateItemSuccess _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.activity_id - _o_.activity_id;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.create_item_id - _o_.create_item_id;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.create_num - _o_.create_num;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.action_type - _o_.action_type;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cookiecake\SCreateItemSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */