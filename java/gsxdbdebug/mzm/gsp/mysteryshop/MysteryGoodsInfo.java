/*    */ package mzm.gsp.mysteryshop;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class MysteryGoodsInfo implements Marshal, Comparable<MysteryGoodsInfo>
/*    */ {
/*    */   public int goods_id;
/*    */   public int sale;
/*    */   public int count;
/*    */   
/*    */   public MysteryGoodsInfo() {}
/*    */   
/*    */   public MysteryGoodsInfo(int _goods_id_, int _sale_, int _count_)
/*    */   {
/* 17 */     this.goods_id = _goods_id_;
/* 18 */     this.sale = _sale_;
/* 19 */     this.count = _count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.goods_id);
/* 28 */     _os_.marshal(this.sale);
/* 29 */     _os_.marshal(this.count);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.goods_id = _os_.unmarshal_int();
/* 35 */     this.sale = _os_.unmarshal_int();
/* 36 */     this.count = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof MysteryGoodsInfo)) {
/* 43 */       MysteryGoodsInfo _o_ = (MysteryGoodsInfo)_o1_;
/* 44 */       if (this.goods_id != _o_.goods_id) return false;
/* 45 */       if (this.sale != _o_.sale) return false;
/* 46 */       if (this.count != _o_.count) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.goods_id;
/* 55 */     _h_ += this.sale;
/* 56 */     _h_ += this.count;
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.goods_id).append(",");
/* 64 */     _sb_.append(this.sale).append(",");
/* 65 */     _sb_.append(this.count).append(",");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(MysteryGoodsInfo _o_) {
/* 71 */     if (_o_ == this) return 0;
/* 72 */     int _c_ = 0;
/* 73 */     _c_ = this.goods_id - _o_.goods_id;
/* 74 */     if (0 != _c_) return _c_;
/* 75 */     _c_ = this.sale - _o_.sale;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.count - _o_.count;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\MysteryGoodsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */