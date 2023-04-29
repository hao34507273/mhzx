/*    */ package mzm.gsp.qingfu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynGiftActivityAwardRes
/*    */   extends __SSynGiftActivityAwardRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588828;
/*    */   public int activity_id;
/*    */   public GiftBagId2Count gift_bag_id_2_remain_count;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588828;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynGiftActivityAwardRes()
/*    */   {
/* 34 */     this.gift_bag_id_2_remain_count = new GiftBagId2Count();
/*    */   }
/*    */   
/*    */   public SSynGiftActivityAwardRes(int _activity_id_, GiftBagId2Count _gift_bag_id_2_remain_count_) {
/* 38 */     this.activity_id = _activity_id_;
/* 39 */     this.gift_bag_id_2_remain_count = _gift_bag_id_2_remain_count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.gift_bag_id_2_remain_count._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.activity_id);
/* 49 */     _os_.marshal(this.gift_bag_id_2_remain_count);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.activity_id = _os_.unmarshal_int();
/* 55 */     this.gift_bag_id_2_remain_count.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSynGiftActivityAwardRes)) {
/* 65 */       SSynGiftActivityAwardRes _o_ = (SSynGiftActivityAwardRes)_o1_;
/* 66 */       if (this.activity_id != _o_.activity_id) return false;
/* 67 */       if (!this.gift_bag_id_2_remain_count.equals(_o_.gift_bag_id_2_remain_count)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.activity_id;
/* 76 */     _h_ += this.gift_bag_id_2_remain_count.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.activity_id).append(",");
/* 84 */     _sb_.append(this.gift_bag_id_2_remain_count).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\SSynGiftActivityAwardRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */