/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.children.fashion.PCRenewalFashionReq;
/*     */ 
/*     */ 
/*     */ public class CRenewalFashionReq
/*     */   extends __CRenewalFashionReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609436;
/*     */   public int bagid;
/*     */   public int grid;
/*     */   public int fashioncfgid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCRenewalFashionReq(roleId, this.bagid, this.grid, this.fashioncfgid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12609436;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CRenewalFashionReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CRenewalFashionReq(int _bagid_, int _grid_, int _fashioncfgid_)
/*     */   {
/*  44 */     this.bagid = _bagid_;
/*  45 */     this.grid = _grid_;
/*  46 */     this.fashioncfgid = _fashioncfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.bagid);
/*  55 */     _os_.marshal(this.grid);
/*  56 */     _os_.marshal(this.fashioncfgid);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.bagid = _os_.unmarshal_int();
/*  62 */     this.grid = _os_.unmarshal_int();
/*  63 */     this.fashioncfgid = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CRenewalFashionReq)) {
/*  73 */       CRenewalFashionReq _o_ = (CRenewalFashionReq)_o1_;
/*  74 */       if (this.bagid != _o_.bagid) return false;
/*  75 */       if (this.grid != _o_.grid) return false;
/*  76 */       if (this.fashioncfgid != _o_.fashioncfgid) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.bagid;
/*  85 */     _h_ += this.grid;
/*  86 */     _h_ += this.fashioncfgid;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.bagid).append(",");
/*  94 */     _sb_.append(this.grid).append(",");
/*  95 */     _sb_.append(this.fashioncfgid).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CRenewalFashionReq _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.bagid - _o_.bagid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.grid - _o_.grid;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.fashioncfgid - _o_.fashioncfgid;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CRenewalFashionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */