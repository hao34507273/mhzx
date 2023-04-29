/*     */ package mzm.gsp.role;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.Role;
/*     */ 
/*     */ public class CAutoAssignPrefReq extends __CAutoAssignPrefReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585987;
/*     */   public static final int PROP_SYS_1 = 0;
/*     */   public static final int PROP_SYS_2 = 1;
/*     */   public static final int PROP_SYS_3 = 2;
/*     */   public int propsys;
/*     */   public HashMap<Integer, Integer> assignpropmap;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new mzm.gsp.role.main.PAutoAssignPrefReq(roleId, this.propsys, this.assignpropmap));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12585987;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CAutoAssignPrefReq()
/*     */   {
/*  42 */     this.assignpropmap = new HashMap();
/*     */   }
/*     */   
/*     */   public CAutoAssignPrefReq(int _propsys_, HashMap<Integer, Integer> _assignpropmap_) {
/*  46 */     this.propsys = _propsys_;
/*  47 */     this.assignpropmap = _assignpropmap_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.propsys);
/*  56 */     _os_.compact_uint32(this.assignpropmap.size());
/*  57 */     for (Map.Entry<Integer, Integer> _e_ : this.assignpropmap.entrySet()) {
/*  58 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  59 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  65 */     this.propsys = _os_.unmarshal_int();
/*  66 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  68 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  70 */       int _v_ = _os_.unmarshal_int();
/*  71 */       this.assignpropmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof CAutoAssignPrefReq)) {
/*  82 */       CAutoAssignPrefReq _o_ = (CAutoAssignPrefReq)_o1_;
/*  83 */       if (this.propsys != _o_.propsys) return false;
/*  84 */       if (!this.assignpropmap.equals(_o_.assignpropmap)) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.propsys;
/*  93 */     _h_ += this.assignpropmap.hashCode();
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.propsys).append(",");
/* 101 */     _sb_.append(this.assignpropmap).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\CAutoAssignPrefReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */