/*     */ package mzm.gsp.indiana;
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
/*     */ public class SAttendIndianaSuccess
/*     */   extends __SAttendIndianaSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628994;
/*     */   public int activity_cfg_id;
/*     */   public int turn;
/*     */   public int sortid;
/*     */   public int number;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12628994;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAttendIndianaSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SAttendIndianaSuccess(int _activity_cfg_id_, int _turn_, int _sortid_, int _number_)
/*     */   {
/*  39 */     this.activity_cfg_id = _activity_cfg_id_;
/*  40 */     this.turn = _turn_;
/*  41 */     this.sortid = _sortid_;
/*  42 */     this.number = _number_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.activity_cfg_id);
/*  51 */     _os_.marshal(this.turn);
/*  52 */     _os_.marshal(this.sortid);
/*  53 */     _os_.marshal(this.number);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  59 */     this.turn = _os_.unmarshal_int();
/*  60 */     this.sortid = _os_.unmarshal_int();
/*  61 */     this.number = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SAttendIndianaSuccess)) {
/*  71 */       SAttendIndianaSuccess _o_ = (SAttendIndianaSuccess)_o1_;
/*  72 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  73 */       if (this.turn != _o_.turn) return false;
/*  74 */       if (this.sortid != _o_.sortid) return false;
/*  75 */       if (this.number != _o_.number) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.activity_cfg_id;
/*  84 */     _h_ += this.turn;
/*  85 */     _h_ += this.sortid;
/*  86 */     _h_ += this.number;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.activity_cfg_id).append(",");
/*  94 */     _sb_.append(this.turn).append(",");
/*  95 */     _sb_.append(this.sortid).append(",");
/*  96 */     _sb_.append(this.number).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAttendIndianaSuccess _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.turn - _o_.turn;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.sortid - _o_.sortid;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.number - _o_.number;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\SAttendIndianaSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */