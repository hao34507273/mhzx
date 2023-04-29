/*    */ package mzm.gsp.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemSwitchInfo
/*    */   implements Marshal, Comparable<ItemSwitchInfo>
/*    */ {
/*    */   public static final int WING = 1;
/*    */   public static final int MAGIC_MARK = 2;
/*    */   public static final int FASHION = 3;
/*    */   public static final int MOUNTS = 4;
/*    */   public static final int CHANGE_MODEL_CARD = 5;
/*    */   public static final int AIRCRAFT = 6;
/*    */   public static final int MIN_TYPE_ID = 1;
/*    */   public static final int MAX_TYPE_ID = 6;
/*    */   public int item_type;
/*    */   public int cfgid;
/*    */   public byte isopen;
/*    */   
/*    */   public ItemSwitchInfo() {}
/*    */   
/*    */   public ItemSwitchInfo(int _item_type_, int _cfgid_, byte _isopen_)
/*    */   {
/* 28 */     this.item_type = _item_type_;
/* 29 */     this.cfgid = _cfgid_;
/* 30 */     this.isopen = _isopen_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 38 */     _os_.marshal(this.item_type);
/* 39 */     _os_.marshal(this.cfgid);
/* 40 */     _os_.marshal(this.isopen);
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 45 */     this.item_type = _os_.unmarshal_int();
/* 46 */     this.cfgid = _os_.unmarshal_int();
/* 47 */     this.isopen = _os_.unmarshal_byte();
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 52 */     if (_o1_ == this) return true;
/* 53 */     if ((_o1_ instanceof ItemSwitchInfo)) {
/* 54 */       ItemSwitchInfo _o_ = (ItemSwitchInfo)_o1_;
/* 55 */       if (this.item_type != _o_.item_type) return false;
/* 56 */       if (this.cfgid != _o_.cfgid) return false;
/* 57 */       if (this.isopen != _o_.isopen) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.item_type;
/* 66 */     _h_ += this.cfgid;
/* 67 */     _h_ += this.isopen;
/* 68 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuilder _sb_ = new StringBuilder();
/* 73 */     _sb_.append("(");
/* 74 */     _sb_.append(this.item_type).append(",");
/* 75 */     _sb_.append(this.cfgid).append(",");
/* 76 */     _sb_.append(this.isopen).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ItemSwitchInfo _o_) {
/* 82 */     if (_o_ == this) return 0;
/* 83 */     int _c_ = 0;
/* 84 */     _c_ = this.item_type - _o_.item_type;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = this.cfgid - _o_.cfgid;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     _c_ = this.isopen - _o_.isopen;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\ItemSwitchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */