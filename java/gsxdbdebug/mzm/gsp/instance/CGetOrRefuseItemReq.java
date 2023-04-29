/*     */ package mzm.gsp.instance;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.instance.main.PCGetOrRefuseItem;
/*     */ 
/*     */ public class CGetOrRefuseItemReq
/*     */   extends __CGetOrRefuseItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12591372;
/*     */   public static final int GET = 0;
/*     */   public static final int REFUSE = 1;
/*     */   public long awarduuid;
/*     */   public int itemid;
/*     */   public int operation;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PCGetOrRefuseItem(roleid, this.awarduuid, this.itemid, this.operation));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12591372;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CGetOrRefuseItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CGetOrRefuseItemReq(long _awarduuid_, int _itemid_, int _operation_)
/*     */   {
/*  43 */     this.awarduuid = _awarduuid_;
/*  44 */     this.itemid = _itemid_;
/*  45 */     this.operation = _operation_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.awarduuid);
/*  54 */     _os_.marshal(this.itemid);
/*  55 */     _os_.marshal(this.operation);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.awarduuid = _os_.unmarshal_long();
/*  61 */     this.itemid = _os_.unmarshal_int();
/*  62 */     this.operation = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CGetOrRefuseItemReq)) {
/*  72 */       CGetOrRefuseItemReq _o_ = (CGetOrRefuseItemReq)_o1_;
/*  73 */       if (this.awarduuid != _o_.awarduuid) return false;
/*  74 */       if (this.itemid != _o_.itemid) return false;
/*  75 */       if (this.operation != _o_.operation) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.awarduuid;
/*  84 */     _h_ += this.itemid;
/*  85 */     _h_ += this.operation;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.awarduuid).append(",");
/*  93 */     _sb_.append(this.itemid).append(",");
/*  94 */     _sb_.append(this.operation).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetOrRefuseItemReq _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.awarduuid - _o_.awarduuid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.itemid - _o_.itemid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.operation - _o_.operation;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\CGetOrRefuseItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */