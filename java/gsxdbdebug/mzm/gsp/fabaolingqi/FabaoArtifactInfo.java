/*    */ package mzm.gsp.fabaolingqi;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class FabaoArtifactInfo implements Marshal
/*    */ {
/*    */   public int expire_time;
/*    */   public int level;
/*    */   public int upgrade_exp;
/*    */   public HashMap<Integer, Integer> properties;
/*    */   
/*    */   public FabaoArtifactInfo()
/*    */   {
/* 17 */     this.properties = new HashMap();
/*    */   }
/*    */   
/*    */   public FabaoArtifactInfo(int _expire_time_, int _level_, int _upgrade_exp_, HashMap<Integer, Integer> _properties_) {
/* 21 */     this.expire_time = _expire_time_;
/* 22 */     this.level = _level_;
/* 23 */     this.upgrade_exp = _upgrade_exp_;
/* 24 */     this.properties = _properties_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.expire_time);
/* 33 */     _os_.marshal(this.level);
/* 34 */     _os_.marshal(this.upgrade_exp);
/* 35 */     _os_.compact_uint32(this.properties.size());
/* 36 */     for (Map.Entry<Integer, Integer> _e_ : this.properties.entrySet()) {
/* 37 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 38 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 44 */     this.expire_time = _os_.unmarshal_int();
/* 45 */     this.level = _os_.unmarshal_int();
/* 46 */     this.upgrade_exp = _os_.unmarshal_int();
/* 47 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 49 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 51 */       int _v_ = _os_.unmarshal_int();
/* 52 */       this.properties.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof FabaoArtifactInfo)) {
/* 60 */       FabaoArtifactInfo _o_ = (FabaoArtifactInfo)_o1_;
/* 61 */       if (this.expire_time != _o_.expire_time) return false;
/* 62 */       if (this.level != _o_.level) return false;
/* 63 */       if (this.upgrade_exp != _o_.upgrade_exp) return false;
/* 64 */       if (!this.properties.equals(_o_.properties)) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.expire_time;
/* 73 */     _h_ += this.level;
/* 74 */     _h_ += this.upgrade_exp;
/* 75 */     _h_ += this.properties.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.expire_time).append(",");
/* 83 */     _sb_.append(this.level).append(",");
/* 84 */     _sb_.append(this.upgrade_exp).append(",");
/* 85 */     _sb_.append(this.properties).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\FabaoArtifactInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */