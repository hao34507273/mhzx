/*     */ package mzm.gsp.personal;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.personal.main.PCSearchAdverts;
/*     */ 
/*     */ 
/*     */ public class CSearchAdverts
/*     */   extends __CSearchAdverts__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12603664;
/*     */   public int adverttype;
/*     */   public int page;
/*     */   public int refresh;
/*     */   public ConditionInfo condition;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 1L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCSearchAdverts(roleId, this.adverttype, this.page, this.refresh, this.condition));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12603664;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CSearchAdverts()
/*     */   {
/*  41 */     this.condition = new ConditionInfo();
/*     */   }
/*     */   
/*     */   public CSearchAdverts(int _adverttype_, int _page_, int _refresh_, ConditionInfo _condition_) {
/*  45 */     this.adverttype = _adverttype_;
/*  46 */     this.page = _page_;
/*  47 */     this.refresh = _refresh_;
/*  48 */     this.condition = _condition_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     if (!this.condition._validator_()) return false;
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.adverttype);
/*  58 */     _os_.marshal(this.page);
/*  59 */     _os_.marshal(this.refresh);
/*  60 */     _os_.marshal(this.condition);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.adverttype = _os_.unmarshal_int();
/*  66 */     this.page = _os_.unmarshal_int();
/*  67 */     this.refresh = _os_.unmarshal_int();
/*  68 */     this.condition.unmarshal(_os_);
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof CSearchAdverts)) {
/*  78 */       CSearchAdverts _o_ = (CSearchAdverts)_o1_;
/*  79 */       if (this.adverttype != _o_.adverttype) return false;
/*  80 */       if (this.page != _o_.page) return false;
/*  81 */       if (this.refresh != _o_.refresh) return false;
/*  82 */       if (!this.condition.equals(_o_.condition)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.adverttype;
/*  91 */     _h_ += this.page;
/*  92 */     _h_ += this.refresh;
/*  93 */     _h_ += this.condition.hashCode();
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.adverttype).append(",");
/* 101 */     _sb_.append(this.page).append(",");
/* 102 */     _sb_.append(this.refresh).append(",");
/* 103 */     _sb_.append(this.condition).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CSearchAdverts _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = this.adverttype - _o_.adverttype;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.page - _o_.page;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.refresh - _o_.refresh;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.condition.compareTo(_o_.condition);
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\CSearchAdverts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */