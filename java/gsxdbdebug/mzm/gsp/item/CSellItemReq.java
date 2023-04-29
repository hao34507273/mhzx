/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.item.main.PCSellItemReq;
/*     */ 
/*     */ 
/*     */ public class CSellItemReq
/*     */   extends __CSellItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584758;
/*     */   public int bagid;
/*     */   public long uuid;
/*     */   public int num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     Role.addRoleProcedure(roleId, new PCSellItemReq(this.uuid, this.bagid, roleId, this.num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  28 */     return 12584758;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CSellItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CSellItemReq(int _bagid_, long _uuid_, int _num_)
/*     */   {
/*  39 */     this.bagid = _bagid_;
/*  40 */     this.uuid = _uuid_;
/*  41 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.bagid);
/*  50 */     _os_.marshal(this.uuid);
/*  51 */     _os_.marshal(this.num);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.bagid = _os_.unmarshal_int();
/*  57 */     this.uuid = _os_.unmarshal_long();
/*  58 */     this.num = _os_.unmarshal_int();
/*  59 */     if (!_validator_()) {
/*  60 */       throw new VerifyError("validator failed");
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  66 */     if (_o1_ == this) return true;
/*  67 */     if ((_o1_ instanceof CSellItemReq)) {
/*  68 */       CSellItemReq _o_ = (CSellItemReq)_o1_;
/*  69 */       if (this.bagid != _o_.bagid) return false;
/*  70 */       if (this.uuid != _o_.uuid) return false;
/*  71 */       if (this.num != _o_.num) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.bagid;
/*  80 */     _h_ += (int)this.uuid;
/*  81 */     _h_ += this.num;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.bagid).append(",");
/*  89 */     _sb_.append(this.uuid).append(",");
/*  90 */     _sb_.append(this.num).append(",");
/*  91 */     _sb_.append(")");
/*  92 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CSellItemReq _o_) {
/*  96 */     if (_o_ == this) return 0;
/*  97 */     int _c_ = 0;
/*  98 */     _c_ = this.bagid - _o_.bagid;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.num - _o_.num;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CSellItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */