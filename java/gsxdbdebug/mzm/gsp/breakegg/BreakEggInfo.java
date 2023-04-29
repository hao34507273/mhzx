/*    */ package mzm.gsp.breakegg;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class BreakEggInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public long role_id;
/*    */   public String role_name;
/*    */   public HashMap<Integer, Integer> itemid2num;
/*    */   
/*    */   public BreakEggInfo()
/*    */   {
/* 14 */     this.role_name = "";
/* 15 */     this.itemid2num = new HashMap();
/*    */   }
/*    */   
/*    */   public BreakEggInfo(long _role_id_, String _role_name_, HashMap<Integer, Integer> _itemid2num_) {
/* 19 */     this.role_id = _role_id_;
/* 20 */     this.role_name = _role_name_;
/* 21 */     this.itemid2num = _itemid2num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.role_id);
/* 30 */     _os_.marshal(this.role_name, "UTF-16LE");
/* 31 */     _os_.compact_uint32(this.itemid2num.size());
/* 32 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.itemid2num.entrySet()) {
/* 33 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 34 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 40 */     this.role_id = _os_.unmarshal_long();
/* 41 */     this.role_name = _os_.unmarshal_String("UTF-16LE");
/* 42 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 44 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 46 */       int _v_ = _os_.unmarshal_int();
/* 47 */       this.itemid2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof BreakEggInfo)) {
/* 55 */       BreakEggInfo _o_ = (BreakEggInfo)_o1_;
/* 56 */       if (this.role_id != _o_.role_id) return false;
/* 57 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 58 */       if (!this.itemid2num.equals(_o_.itemid2num)) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += (int)this.role_id;
/* 67 */     _h_ += this.role_name.hashCode();
/* 68 */     _h_ += this.itemid2num.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.role_id).append(",");
/* 76 */     _sb_.append("T").append(this.role_name.length()).append(",");
/* 77 */     _sb_.append(this.itemid2num).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\BreakEggInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */