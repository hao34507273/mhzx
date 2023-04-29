/*     */ package mzm.gsp.singlebattle;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynTotalPositionInfo
/*     */   extends __SSynTotalPositionInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12621585;
/*     */   public HashMap<Integer, PositionData> positioninfos;
/*     */   public HashMap<Long, RoleGrabPositionData> rolegrabinfo;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12621585;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynTotalPositionInfo()
/*     */   {
/*  34 */     this.positioninfos = new HashMap();
/*  35 */     this.rolegrabinfo = new HashMap();
/*     */   }
/*     */   
/*     */   public SSynTotalPositionInfo(HashMap<Integer, PositionData> _positioninfos_, HashMap<Long, RoleGrabPositionData> _rolegrabinfo_) {
/*  39 */     this.positioninfos = _positioninfos_;
/*  40 */     this.rolegrabinfo = _rolegrabinfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     for (Map.Entry<Integer, PositionData> _e_ : this.positioninfos.entrySet()) {
/*  45 */       if (!((PositionData)_e_.getValue())._validator_()) return false;
/*     */     }
/*  47 */     for (Map.Entry<Long, RoleGrabPositionData> _e_ : this.rolegrabinfo.entrySet()) {
/*  48 */       if (!((RoleGrabPositionData)_e_.getValue())._validator_()) return false;
/*     */     }
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.compact_uint32(this.positioninfos.size());
/*  55 */     for (Map.Entry<Integer, PositionData> _e_ : this.positioninfos.entrySet()) {
/*  56 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  57 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  59 */     _os_.compact_uint32(this.rolegrabinfo.size());
/*  60 */     for (Map.Entry<Long, RoleGrabPositionData> _e_ : this.rolegrabinfo.entrySet()) {
/*  61 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  62 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  70 */       int _k_ = _os_.unmarshal_int();
/*  71 */       PositionData _v_ = new PositionData();
/*  72 */       _v_.unmarshal(_os_);
/*  73 */       this.positioninfos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  75 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  77 */       long _k_ = _os_.unmarshal_long();
/*  78 */       RoleGrabPositionData _v_ = new RoleGrabPositionData();
/*  79 */       _v_.unmarshal(_os_);
/*  80 */       this.rolegrabinfo.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  82 */     if (!_validator_()) {
/*  83 */       throw new VerifyError("validator failed");
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  89 */     if (_o1_ == this) return true;
/*  90 */     if ((_o1_ instanceof SSynTotalPositionInfo)) {
/*  91 */       SSynTotalPositionInfo _o_ = (SSynTotalPositionInfo)_o1_;
/*  92 */       if (!this.positioninfos.equals(_o_.positioninfos)) return false;
/*  93 */       if (!this.rolegrabinfo.equals(_o_.rolegrabinfo)) return false;
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 100 */     int _h_ = 0;
/* 101 */     _h_ += this.positioninfos.hashCode();
/* 102 */     _h_ += this.rolegrabinfo.hashCode();
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.positioninfos).append(",");
/* 110 */     _sb_.append(this.rolegrabinfo).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\SSynTotalPositionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */