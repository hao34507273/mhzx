/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class InfluenceOther implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public HashMap<Integer, FighterStatus> othermap;
/*    */   
/*    */   public InfluenceOther()
/*    */   {
/* 12 */     this.othermap = new HashMap();
/*    */   }
/*    */   
/*    */   public InfluenceOther(HashMap<Integer, FighterStatus> _othermap_) {
/* 16 */     this.othermap = _othermap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 20 */     for (java.util.Map.Entry<Integer, FighterStatus> _e_ : this.othermap.entrySet()) {
/* 21 */       if (!((FighterStatus)_e_.getValue())._validator_()) return false;
/*    */     }
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.compact_uint32(this.othermap.size());
/* 28 */     for (java.util.Map.Entry<Integer, FighterStatus> _e_ : this.othermap.entrySet()) {
/* 29 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 30 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*    */     }
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 36 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 38 */       int _k_ = _os_.unmarshal_int();
/* 39 */       FighterStatus _v_ = new FighterStatus();
/* 40 */       _v_.unmarshal(_os_);
/* 41 */       this.othermap.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof InfluenceOther)) {
/* 49 */       InfluenceOther _o_ = (InfluenceOther)_o1_;
/* 50 */       if (!this.othermap.equals(_o_.othermap)) return false;
/* 51 */       return true;
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 57 */     int _h_ = 0;
/* 58 */     _h_ += this.othermap.hashCode();
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.othermap).append(",");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\InfluenceOther.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */