/*    */ package mzm.gsp.petmark;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class LotteryPetMarkItemInfo
/*    */   implements Marshal, Comparable<LotteryPetMarkItemInfo>
/*    */ {
/*    */   public int item_cfg_id;
/*    */   public int count;
/*    */   
/*    */   public LotteryPetMarkItemInfo() {}
/*    */   
/*    */   public LotteryPetMarkItemInfo(int _item_cfg_id_, int _count_)
/*    */   {
/* 18 */     this.item_cfg_id = _item_cfg_id_;
/* 19 */     this.count = _count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.item_cfg_id);
/* 28 */     _os_.marshal(this.count);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.item_cfg_id = _os_.unmarshal_int();
/* 34 */     this.count = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof LotteryPetMarkItemInfo)) {
/* 41 */       LotteryPetMarkItemInfo _o_ = (LotteryPetMarkItemInfo)_o1_;
/* 42 */       if (this.item_cfg_id != _o_.item_cfg_id) return false;
/* 43 */       if (this.count != _o_.count) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.item_cfg_id;
/* 52 */     _h_ += this.count;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.item_cfg_id).append(",");
/* 60 */     _sb_.append(this.count).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(LotteryPetMarkItemInfo _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.item_cfg_id - _o_.item_cfg_id;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.count - _o_.count;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\LotteryPetMarkItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */