/*     */ package mzm.gsp.children;
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
/*     */ public class SChildrenEquipRandomRes
/*     */   extends __SChildrenEquipRandomRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609425;
/*     */   public long childrenid;
/*     */   public int pos;
/*     */   public int originalproptype;
/*     */   public int nowproptype;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609425;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SChildrenEquipRandomRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SChildrenEquipRandomRes(long _childrenid_, int _pos_, int _originalproptype_, int _nowproptype_)
/*     */   {
/*  39 */     this.childrenid = _childrenid_;
/*  40 */     this.pos = _pos_;
/*  41 */     this.originalproptype = _originalproptype_;
/*  42 */     this.nowproptype = _nowproptype_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.childrenid);
/*  51 */     _os_.marshal(this.pos);
/*  52 */     _os_.marshal(this.originalproptype);
/*  53 */     _os_.marshal(this.nowproptype);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.childrenid = _os_.unmarshal_long();
/*  59 */     this.pos = _os_.unmarshal_int();
/*  60 */     this.originalproptype = _os_.unmarshal_int();
/*  61 */     this.nowproptype = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SChildrenEquipRandomRes)) {
/*  71 */       SChildrenEquipRandomRes _o_ = (SChildrenEquipRandomRes)_o1_;
/*  72 */       if (this.childrenid != _o_.childrenid) return false;
/*  73 */       if (this.pos != _o_.pos) return false;
/*  74 */       if (this.originalproptype != _o_.originalproptype) return false;
/*  75 */       if (this.nowproptype != _o_.nowproptype) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.childrenid;
/*  84 */     _h_ += this.pos;
/*  85 */     _h_ += this.originalproptype;
/*  86 */     _h_ += this.nowproptype;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.childrenid).append(",");
/*  94 */     _sb_.append(this.pos).append(",");
/*  95 */     _sb_.append(this.originalproptype).append(",");
/*  96 */     _sb_.append(this.nowproptype).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SChildrenEquipRandomRes _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.pos - _o_.pos;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.originalproptype - _o_.originalproptype;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.nowproptype - _o_.nowproptype;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SChildrenEquipRandomRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */