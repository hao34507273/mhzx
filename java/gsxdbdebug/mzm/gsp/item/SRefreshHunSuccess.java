/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SRefreshHunSuccess
/*     */   extends __SRefreshHunSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584815;
/*     */   public int bagid;
/*     */   public long uuid;
/*     */   public HashMap<Integer, TempExtraProInfo> extrprops;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584815;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SRefreshHunSuccess()
/*     */   {
/*  33 */     this.extrprops = new HashMap();
/*     */   }
/*     */   
/*     */   public SRefreshHunSuccess(int _bagid_, long _uuid_, HashMap<Integer, TempExtraProInfo> _extrprops_) {
/*  37 */     this.bagid = _bagid_;
/*  38 */     this.uuid = _uuid_;
/*  39 */     this.extrprops = _extrprops_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  43 */     for (Map.Entry<Integer, TempExtraProInfo> _e_ : this.extrprops.entrySet()) {
/*  44 */       if (!((TempExtraProInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.bagid);
/*  51 */     _os_.marshal(this.uuid);
/*  52 */     _os_.compact_uint32(this.extrprops.size());
/*  53 */     for (Map.Entry<Integer, TempExtraProInfo> _e_ : this.extrprops.entrySet()) {
/*  54 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  55 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.bagid = _os_.unmarshal_int();
/*  62 */     this.uuid = _os_.unmarshal_long();
/*  63 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  65 */       int _k_ = _os_.unmarshal_int();
/*  66 */       TempExtraProInfo _v_ = new TempExtraProInfo();
/*  67 */       _v_.unmarshal(_os_);
/*  68 */       this.extrprops.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SRefreshHunSuccess)) {
/*  79 */       SRefreshHunSuccess _o_ = (SRefreshHunSuccess)_o1_;
/*  80 */       if (this.bagid != _o_.bagid) return false;
/*  81 */       if (this.uuid != _o_.uuid) return false;
/*  82 */       if (!this.extrprops.equals(_o_.extrprops)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.bagid;
/*  91 */     _h_ += (int)this.uuid;
/*  92 */     _h_ += this.extrprops.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.bagid).append(",");
/* 100 */     _sb_.append(this.uuid).append(",");
/* 101 */     _sb_.append(this.extrprops).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SRefreshHunSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */