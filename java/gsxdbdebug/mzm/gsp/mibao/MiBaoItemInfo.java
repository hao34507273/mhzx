/*    */ package mzm.gsp.mibao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class MiBaoItemInfo implements Marshal, Comparable<MiBaoItemInfo>
/*    */ {
/*    */   public int itemid;
/*    */   public int itemnum;
/*    */   
/*    */   public MiBaoItemInfo() {}
/*    */   
/*    */   public MiBaoItemInfo(int _itemid_, int _itemnum_)
/*    */   {
/* 16 */     this.itemid = _itemid_;
/* 17 */     this.itemnum = _itemnum_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.itemid);
/* 26 */     _os_.marshal(this.itemnum);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.itemid = _os_.unmarshal_int();
/* 32 */     this.itemnum = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof MiBaoItemInfo)) {
/* 39 */       MiBaoItemInfo _o_ = (MiBaoItemInfo)_o1_;
/* 40 */       if (this.itemid != _o_.itemid) return false;
/* 41 */       if (this.itemnum != _o_.itemnum) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.itemid;
/* 50 */     _h_ += this.itemnum;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.itemid).append(",");
/* 58 */     _sb_.append(this.itemnum).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(MiBaoItemInfo _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.itemid - _o_.itemid;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.itemnum - _o_.itemnum;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\MiBaoItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */