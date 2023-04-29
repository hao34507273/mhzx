/*    */ package mzm.gsp.fabao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class LongJingChangeInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public HashMap<Integer, mzm.gsp.item.ItemInfo> changed;
/*    */   public java.util.HashSet<Integer> rempositions;
/*    */   
/*    */   public LongJingChangeInfo()
/*    */   {
/* 13 */     this.changed = new HashMap();
/* 14 */     this.rempositions = new java.util.HashSet();
/*    */   }
/*    */   
/*    */   public LongJingChangeInfo(HashMap<Integer, mzm.gsp.item.ItemInfo> _changed_, java.util.HashSet<Integer> _rempositions_) {
/* 18 */     this.changed = _changed_;
/* 19 */     this.rempositions = _rempositions_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     for (java.util.Map.Entry<Integer, mzm.gsp.item.ItemInfo> _e_ : this.changed.entrySet()) {
/* 24 */       if (!((mzm.gsp.item.ItemInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.compact_uint32(this.changed.size());
/* 31 */     for (java.util.Map.Entry<Integer, mzm.gsp.item.ItemInfo> _e_ : this.changed.entrySet()) {
/* 32 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 33 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*    */     }
/* 35 */     _os_.compact_uint32(this.rempositions.size());
/* 36 */     for (Integer _v_ : this.rempositions) {
/* 37 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 43 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 45 */       int _k_ = _os_.unmarshal_int();
/* 46 */       mzm.gsp.item.ItemInfo _v_ = new mzm.gsp.item.ItemInfo();
/* 47 */       _v_.unmarshal(_os_);
/* 48 */       this.changed.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 50 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 52 */       int _v_ = _os_.unmarshal_int();
/* 53 */       this.rempositions.add(Integer.valueOf(_v_));
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof LongJingChangeInfo)) {
/* 61 */       LongJingChangeInfo _o_ = (LongJingChangeInfo)_o1_;
/* 62 */       if (!this.changed.equals(_o_.changed)) return false;
/* 63 */       if (!this.rempositions.equals(_o_.rempositions)) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.changed.hashCode();
/* 72 */     _h_ += this.rempositions.hashCode();
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.changed).append(",");
/* 80 */     _sb_.append(this.rempositions).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\LongJingChangeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */