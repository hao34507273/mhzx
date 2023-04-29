/*     */ package mzm.gsp.interactivetask;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.interactivetask.main.PSendStartTaskReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CSendStartTaskReq
/*     */   extends __CSendStartTaskReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12610319;
/*     */   public int result;
/*     */   public int typeid;
/*     */   public int graphid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if (roleid < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleid, new PSendStartTaskReq(roleid, this.typeid, this.graphid, this.result));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12610319;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CSendStartTaskReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CSendStartTaskReq(int _result_, int _typeid_, int _graphid_)
/*     */   {
/*  44 */     this.result = _result_;
/*  45 */     this.typeid = _typeid_;
/*  46 */     this.graphid = _graphid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.result);
/*  55 */     _os_.marshal(this.typeid);
/*  56 */     _os_.marshal(this.graphid);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.result = _os_.unmarshal_int();
/*  62 */     this.typeid = _os_.unmarshal_int();
/*  63 */     this.graphid = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CSendStartTaskReq)) {
/*  73 */       CSendStartTaskReq _o_ = (CSendStartTaskReq)_o1_;
/*  74 */       if (this.result != _o_.result) return false;
/*  75 */       if (this.typeid != _o_.typeid) return false;
/*  76 */       if (this.graphid != _o_.graphid) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.result;
/*  85 */     _h_ += this.typeid;
/*  86 */     _h_ += this.graphid;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.result).append(",");
/*  94 */     _sb_.append(this.typeid).append(",");
/*  95 */     _sb_.append(this.graphid).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CSendStartTaskReq _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.result - _o_.result;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.typeid - _o_.typeid;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.graphid - _o_.graphid;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\CSendStartTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */