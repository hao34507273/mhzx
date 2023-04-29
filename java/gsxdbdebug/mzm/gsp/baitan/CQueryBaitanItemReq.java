/*     */ package mzm.gsp.baitan;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.baitan.main.PQueryBaitanItemReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CQueryBaitanItemReq
/*     */   extends __CQueryBaitanItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584991;
/*     */   public int pageindex;
/*     */   public int param;
/*     */   public int subtype;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PQueryBaitanItemReq(roleId, this.pageindex, this.subtype, this.param));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12584991;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CQueryBaitanItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CQueryBaitanItemReq(int _pageindex_, int _param_, int _subtype_)
/*     */   {
/*  44 */     this.pageindex = _pageindex_;
/*  45 */     this.param = _param_;
/*  46 */     this.subtype = _subtype_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.pageindex);
/*  55 */     _os_.marshal(this.param);
/*  56 */     _os_.marshal(this.subtype);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.pageindex = _os_.unmarshal_int();
/*  62 */     this.param = _os_.unmarshal_int();
/*  63 */     this.subtype = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CQueryBaitanItemReq)) {
/*  73 */       CQueryBaitanItemReq _o_ = (CQueryBaitanItemReq)_o1_;
/*  74 */       if (this.pageindex != _o_.pageindex) return false;
/*  75 */       if (this.param != _o_.param) return false;
/*  76 */       if (this.subtype != _o_.subtype) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.pageindex;
/*  85 */     _h_ += this.param;
/*  86 */     _h_ += this.subtype;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.pageindex).append(",");
/*  94 */     _sb_.append(this.param).append(",");
/*  95 */     _sb_.append(this.subtype).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CQueryBaitanItemReq _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.pageindex - _o_.pageindex;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.param - _o_.param;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.subtype - _o_.subtype;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\CQueryBaitanItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */