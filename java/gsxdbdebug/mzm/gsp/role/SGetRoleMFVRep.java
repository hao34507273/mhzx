/*     */ package mzm.gsp.role;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetRoleMFVRep
/*     */   extends __SGetRoleMFVRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12586032;
/*     */   public ArrayList<Long> roleids;
/*     */   public HashMap<Long, Integer> rolemfvinfo;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12586032;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetRoleMFVRep()
/*     */   {
/*  34 */     this.roleids = new ArrayList();
/*  35 */     this.rolemfvinfo = new HashMap();
/*     */   }
/*     */   
/*     */   public SGetRoleMFVRep(ArrayList<Long> _roleids_, HashMap<Long, Integer> _rolemfvinfo_) {
/*  39 */     this.roleids = _roleids_;
/*  40 */     this.rolemfvinfo = _rolemfvinfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.compact_uint32(this.roleids.size());
/*  49 */     for (Long _v_ : this.roleids) {
/*  50 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  52 */     _os_.compact_uint32(this.rolemfvinfo.size());
/*  53 */     for (Map.Entry<Long, Integer> _e_ : this.rolemfvinfo.entrySet()) {
/*  54 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  55 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  63 */       long _v_ = _os_.unmarshal_long();
/*  64 */       this.roleids.add(Long.valueOf(_v_));
/*     */     }
/*  66 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  68 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  70 */       int _v_ = _os_.unmarshal_int();
/*  71 */       this.rolemfvinfo.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof SGetRoleMFVRep)) {
/*  82 */       SGetRoleMFVRep _o_ = (SGetRoleMFVRep)_o1_;
/*  83 */       if (!this.roleids.equals(_o_.roleids)) return false;
/*  84 */       if (!this.rolemfvinfo.equals(_o_.rolemfvinfo)) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.roleids.hashCode();
/*  93 */     _h_ += this.rolemfvinfo.hashCode();
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.roleids).append(",");
/* 101 */     _sb_.append(this.rolemfvinfo).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\SGetRoleMFVRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */