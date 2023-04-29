/*     */ package gnet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PassportGetRoleListRep
/*     */   extends __PassportGetRoleListRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 215;
/*     */   public int xid;
/*     */   public int retcode;
/*     */   public ArrayList<RoleSimpleInfo> rolelist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 215;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public PassportGetRoleListRep()
/*     */   {
/*  33 */     this.retcode = 0;
/*  34 */     this.rolelist = new ArrayList();
/*     */   }
/*     */   
/*     */   public PassportGetRoleListRep(int _xid_, int _retcode_, ArrayList<RoleSimpleInfo> _rolelist_) {
/*  38 */     this.xid = _xid_;
/*  39 */     this.retcode = _retcode_;
/*  40 */     this.rolelist = _rolelist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     for (RoleSimpleInfo _v_ : this.rolelist)
/*  45 */       if (!_v_._validator_()) return false;
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.xid);
/*  51 */     _os_.marshal(this.retcode);
/*  52 */     _os_.compact_uint32(this.rolelist.size());
/*  53 */     for (RoleSimpleInfo _v_ : this.rolelist) {
/*  54 */       _os_.marshal(_v_);
/*     */     }
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.xid = _os_.unmarshal_int();
/*  61 */     this.retcode = _os_.unmarshal_int();
/*  62 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  63 */       RoleSimpleInfo _v_ = new RoleSimpleInfo();
/*  64 */       _v_.unmarshal(_os_);
/*  65 */       this.rolelist.add(_v_);
/*     */     }
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof PassportGetRoleListRep)) {
/*  76 */       PassportGetRoleListRep _o_ = (PassportGetRoleListRep)_o1_;
/*  77 */       if (this.xid != _o_.xid) return false;
/*  78 */       if (this.retcode != _o_.retcode) return false;
/*  79 */       if (!this.rolelist.equals(_o_.rolelist)) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.xid;
/*  88 */     _h_ += this.retcode;
/*  89 */     _h_ += this.rolelist.hashCode();
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.xid).append(",");
/*  97 */     _sb_.append(this.retcode).append(",");
/*  98 */     _sb_.append(this.rolelist).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\PassportGetRoleListRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */