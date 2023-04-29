/*     */ package mzm.gsp.interactivetask;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.interactivetask.main.PSendInviteStartTaskReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CSendInviteStartTaskReq
/*     */   extends __CSendInviteStartTaskReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12610320;
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
/*  25 */     Role.addRoleProcedure(roleid, new PSendInviteStartTaskReq(roleid, this.typeid, this.graphid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12610320;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CSendInviteStartTaskReq() {}
/*     */   
/*     */ 
/*     */   public CSendInviteStartTaskReq(int _typeid_, int _graphid_)
/*     */   {
/*  43 */     this.typeid = _typeid_;
/*  44 */     this.graphid = _graphid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.typeid);
/*  53 */     _os_.marshal(this.graphid);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.typeid = _os_.unmarshal_int();
/*  59 */     this.graphid = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CSendInviteStartTaskReq)) {
/*  69 */       CSendInviteStartTaskReq _o_ = (CSendInviteStartTaskReq)_o1_;
/*  70 */       if (this.typeid != _o_.typeid) return false;
/*  71 */       if (this.graphid != _o_.graphid) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.typeid;
/*  80 */     _h_ += this.graphid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.typeid).append(",");
/*  88 */     _sb_.append(this.graphid).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CSendInviteStartTaskReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.typeid - _o_.typeid;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.graphid - _o_.graphid;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\CSendInviteStartTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */