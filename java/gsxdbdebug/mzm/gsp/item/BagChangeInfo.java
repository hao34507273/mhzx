/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class BagChangeInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int bagid;
/*    */   public HashSet<Integer> removed;
/*    */   public HashMap<Integer, ItemInfo> changed;
/*    */   
/*    */   public BagChangeInfo()
/*    */   {
/* 16 */     this.removed = new HashSet();
/* 17 */     this.changed = new HashMap();
/*    */   }
/*    */   
/*    */   public BagChangeInfo(int _bagid_, HashSet<Integer> _removed_, HashMap<Integer, ItemInfo> _changed_) {
/* 21 */     this.bagid = _bagid_;
/* 22 */     this.removed = _removed_;
/* 23 */     this.changed = _changed_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     for (Map.Entry<Integer, ItemInfo> _e_ : this.changed.entrySet()) {
/* 28 */       if (!((ItemInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.bagid);
/* 35 */     _os_.compact_uint32(this.removed.size());
/* 36 */     for (Integer _v_ : this.removed) {
/* 37 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 39 */     _os_.compact_uint32(this.changed.size());
/* 40 */     for (Map.Entry<Integer, ItemInfo> _e_ : this.changed.entrySet()) {
/* 41 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 42 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*    */     }
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 48 */     this.bagid = _os_.unmarshal_int();
/* 49 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 51 */       int _v_ = _os_.unmarshal_int();
/* 52 */       this.removed.add(Integer.valueOf(_v_));
/*    */     }
/* 54 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 56 */       int _k_ = _os_.unmarshal_int();
/* 57 */       ItemInfo _v_ = new ItemInfo();
/* 58 */       _v_.unmarshal(_os_);
/* 59 */       this.changed.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof BagChangeInfo)) {
/* 67 */       BagChangeInfo _o_ = (BagChangeInfo)_o1_;
/* 68 */       if (this.bagid != _o_.bagid) return false;
/* 69 */       if (!this.removed.equals(_o_.removed)) return false;
/* 70 */       if (!this.changed.equals(_o_.changed)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.bagid;
/* 79 */     _h_ += this.removed.hashCode();
/* 80 */     _h_ += this.changed.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.bagid).append(",");
/* 88 */     _sb_.append(this.removed).append(",");
/* 89 */     _sb_.append(this.changed).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\BagChangeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */