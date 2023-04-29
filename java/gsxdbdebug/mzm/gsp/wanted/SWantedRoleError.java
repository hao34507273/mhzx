/*     */ package mzm.gsp.wanted;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SWantedRoleError extends __SWantedRoleError__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12620299;
/*     */   public static final int ROLE_IN_MAP = 1;
/*     */   public static final int ROLE_IN_FIGHT = 2;
/*     */   public static final int MONEY_NOT_ENOUGH = 3;
/*     */   public static final int WANTED_COUNT_MAX = 4;
/*     */   public static final int ROLE_OFFLINE = 5;
/*     */   public static final int ROLE_CAN_NOT_BE_WANTED = 6;
/*     */   public static final int ROLE_IS_HONGMING = 7;
/*     */   public static final int ROLE_LEVEL_LOW = 8;
/*     */   public static final int ROLE_STATUS_CAN_NOT_BE_WANTED = 9;
/*     */   public int errorcode;
/*     */   public Octets rolename;
/*     */   public ArrayList<Octets> params;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12620299;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SWantedRoleError()
/*     */   {
/*  45 */     this.rolename = new Octets();
/*  46 */     this.params = new ArrayList();
/*     */   }
/*     */   
/*     */   public SWantedRoleError(int _errorcode_, Octets _rolename_, ArrayList<Octets> _params_) {
/*  50 */     this.errorcode = _errorcode_;
/*  51 */     this.rolename = _rolename_;
/*  52 */     this.params = _params_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.marshal(this.errorcode);
/*  61 */     _os_.marshal(this.rolename);
/*  62 */     _os_.compact_uint32(this.params.size());
/*  63 */     for (Octets _v_ : this.params) {
/*  64 */       _os_.marshal(_v_);
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  70 */     this.errorcode = _os_.unmarshal_int();
/*  71 */     this.rolename = _os_.unmarshal_Octets();
/*  72 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  74 */       Octets _v_ = _os_.unmarshal_Octets();
/*  75 */       this.params.add(_v_);
/*     */     }
/*  77 */     if (!_validator_()) {
/*  78 */       throw new VerifyError("validator failed");
/*     */     }
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  84 */     if (_o1_ == this) return true;
/*  85 */     if ((_o1_ instanceof SWantedRoleError)) {
/*  86 */       SWantedRoleError _o_ = (SWantedRoleError)_o1_;
/*  87 */       if (this.errorcode != _o_.errorcode) return false;
/*  88 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  89 */       if (!this.params.equals(_o_.params)) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += this.errorcode;
/*  98 */     _h_ += this.rolename.hashCode();
/*  99 */     _h_ += this.params.hashCode();
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append(this.errorcode).append(",");
/* 107 */     _sb_.append("B").append(this.rolename.size()).append(",");
/* 108 */     _sb_.append(this.params).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\SWantedRoleError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */