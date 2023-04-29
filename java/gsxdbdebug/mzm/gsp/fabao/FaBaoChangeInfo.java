/*    */ package mzm.gsp.fabao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.item.ItemInfo;
/*    */ 
/*    */ public class FaBaoChangeInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public HashSet<Integer> removed;
/*    */   public HashMap<Integer, ItemInfo> changed;
/*    */   
/*    */   public FaBaoChangeInfo()
/*    */   {
/* 15 */     this.removed = new HashSet();
/* 16 */     this.changed = new HashMap();
/*    */   }
/*    */   
/*    */   public FaBaoChangeInfo(HashSet<Integer> _removed_, HashMap<Integer, ItemInfo> _changed_) {
/* 20 */     this.removed = _removed_;
/* 21 */     this.changed = _changed_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     for (java.util.Map.Entry<Integer, ItemInfo> _e_ : this.changed.entrySet()) {
/* 26 */       if (!((ItemInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.compact_uint32(this.removed.size());
/* 33 */     for (Integer _v_ : this.removed) {
/* 34 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 36 */     _os_.compact_uint32(this.changed.size());
/* 37 */     for (java.util.Map.Entry<Integer, ItemInfo> _e_ : this.changed.entrySet()) {
/* 38 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 39 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*    */     }
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 45 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 47 */       int _v_ = _os_.unmarshal_int();
/* 48 */       this.removed.add(Integer.valueOf(_v_));
/*    */     }
/* 50 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 52 */       int _k_ = _os_.unmarshal_int();
/* 53 */       ItemInfo _v_ = new ItemInfo();
/* 54 */       _v_.unmarshal(_os_);
/* 55 */       this.changed.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof FaBaoChangeInfo)) {
/* 63 */       FaBaoChangeInfo _o_ = (FaBaoChangeInfo)_o1_;
/* 64 */       if (!this.removed.equals(_o_.removed)) return false;
/* 65 */       if (!this.changed.equals(_o_.changed)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.removed.hashCode();
/* 74 */     _h_ += this.changed.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.removed).append(",");
/* 82 */     _sb_.append(this.changed).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\FaBaoChangeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */