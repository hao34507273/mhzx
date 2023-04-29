/*    */ package mzm.gsp.singlebattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class CampFinalInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int totalsource;
/*    */   public HashMap<Long, RoleFinalInfo> rolefinalinfos;
/*    */   
/*    */   public CampFinalInfo()
/*    */   {
/* 13 */     this.rolefinalinfos = new HashMap();
/*    */   }
/*    */   
/*    */   public CampFinalInfo(int _totalsource_, HashMap<Long, RoleFinalInfo> _rolefinalinfos_) {
/* 17 */     this.totalsource = _totalsource_;
/* 18 */     this.rolefinalinfos = _rolefinalinfos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     for (java.util.Map.Entry<Long, RoleFinalInfo> _e_ : this.rolefinalinfos.entrySet()) {
/* 23 */       if (!((RoleFinalInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.totalsource);
/* 30 */     _os_.compact_uint32(this.rolefinalinfos.size());
/* 31 */     for (java.util.Map.Entry<Long, RoleFinalInfo> _e_ : this.rolefinalinfos.entrySet()) {
/* 32 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 33 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*    */     }
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 39 */     this.totalsource = _os_.unmarshal_int();
/* 40 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 42 */       long _k_ = _os_.unmarshal_long();
/* 43 */       RoleFinalInfo _v_ = new RoleFinalInfo();
/* 44 */       _v_.unmarshal(_os_);
/* 45 */       this.rolefinalinfos.put(Long.valueOf(_k_), _v_);
/*    */     }
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof CampFinalInfo)) {
/* 53 */       CampFinalInfo _o_ = (CampFinalInfo)_o1_;
/* 54 */       if (this.totalsource != _o_.totalsource) return false;
/* 55 */       if (!this.rolefinalinfos.equals(_o_.rolefinalinfos)) return false;
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     _h_ += this.totalsource;
/* 64 */     _h_ += this.rolefinalinfos.hashCode();
/* 65 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append(this.totalsource).append(",");
/* 72 */     _sb_.append(this.rolefinalinfos).append(",");
/* 73 */     _sb_.append(")");
/* 74 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\CampFinalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */