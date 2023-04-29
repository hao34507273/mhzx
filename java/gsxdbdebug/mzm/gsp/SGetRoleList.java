/*     */ package mzm.gsp;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetRoleList
/*     */   extends __SGetRoleList__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590089;
/*     */   public ArrayList<RoleInfo> roles;
/*     */   public HashMap<Long, ModelInfo> rolemodels;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590089;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetRoleList()
/*     */   {
/*  34 */     this.roles = new ArrayList();
/*  35 */     this.rolemodels = new HashMap();
/*     */   }
/*     */   
/*     */   public SGetRoleList(ArrayList<RoleInfo> _roles_, HashMap<Long, ModelInfo> _rolemodels_) {
/*  39 */     this.roles = _roles_;
/*  40 */     this.rolemodels = _rolemodels_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     for (RoleInfo _v_ : this.roles)
/*  45 */       if (!_v_._validator_()) return false;
/*  46 */     for (Map.Entry<Long, ModelInfo> _e_ : this.rolemodels.entrySet()) {
/*  47 */       if (!((ModelInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.compact_uint32(this.roles.size());
/*  54 */     for (RoleInfo _v_ : this.roles) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     _os_.compact_uint32(this.rolemodels.size());
/*  58 */     for (Map.Entry<Long, ModelInfo> _e_ : this.rolemodels.entrySet()) {
/*  59 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  60 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  67 */       RoleInfo _v_ = new RoleInfo();
/*  68 */       _v_.unmarshal(_os_);
/*  69 */       this.roles.add(_v_);
/*     */     }
/*  71 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  73 */       long _k_ = _os_.unmarshal_long();
/*  74 */       ModelInfo _v_ = new ModelInfo();
/*  75 */       _v_.unmarshal(_os_);
/*  76 */       this.rolemodels.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  78 */     if (!_validator_()) {
/*  79 */       throw new VerifyError("validator failed");
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  85 */     if (_o1_ == this) return true;
/*  86 */     if ((_o1_ instanceof SGetRoleList)) {
/*  87 */       SGetRoleList _o_ = (SGetRoleList)_o1_;
/*  88 */       if (!this.roles.equals(_o_.roles)) return false;
/*  89 */       if (!this.rolemodels.equals(_o_.rolemodels)) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += this.roles.hashCode();
/*  98 */     _h_ += this.rolemodels.hashCode();
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.roles).append(",");
/* 106 */     _sb_.append(this.rolemodels).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\SGetRoleList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */