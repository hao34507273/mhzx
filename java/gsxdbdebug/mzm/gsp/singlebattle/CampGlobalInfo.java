/*    */ package mzm.gsp.singlebattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class CampGlobalInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public CampInfo campinfo;
/*    */   public HashMap<Long, RoleTotalInfo> roleinfos;
/*    */   
/*    */   public CampGlobalInfo()
/*    */   {
/* 13 */     this.campinfo = new CampInfo();
/* 14 */     this.roleinfos = new HashMap();
/*    */   }
/*    */   
/*    */   public CampGlobalInfo(CampInfo _campinfo_, HashMap<Long, RoleTotalInfo> _roleinfos_) {
/* 18 */     this.campinfo = _campinfo_;
/* 19 */     this.roleinfos = _roleinfos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     if (!this.campinfo._validator_()) return false;
/* 24 */     for (java.util.Map.Entry<Long, RoleTotalInfo> _e_ : this.roleinfos.entrySet()) {
/* 25 */       if (!((RoleTotalInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.campinfo);
/* 32 */     _os_.compact_uint32(this.roleinfos.size());
/* 33 */     for (java.util.Map.Entry<Long, RoleTotalInfo> _e_ : this.roleinfos.entrySet()) {
/* 34 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 35 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*    */     }
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     this.campinfo.unmarshal(_os_);
/* 42 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 44 */       long _k_ = _os_.unmarshal_long();
/* 45 */       RoleTotalInfo _v_ = new RoleTotalInfo();
/* 46 */       _v_.unmarshal(_os_);
/* 47 */       this.roleinfos.put(Long.valueOf(_k_), _v_);
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof CampGlobalInfo)) {
/* 55 */       CampGlobalInfo _o_ = (CampGlobalInfo)_o1_;
/* 56 */       if (!this.campinfo.equals(_o_.campinfo)) return false;
/* 57 */       if (!this.roleinfos.equals(_o_.roleinfos)) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.campinfo.hashCode();
/* 66 */     _h_ += this.roleinfos.hashCode();
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.campinfo).append(",");
/* 74 */     _sb_.append(this.roleinfos).append(",");
/* 75 */     _sb_.append(")");
/* 76 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\CampGlobalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */