/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.award.AwardBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SUseGiftBagItemRes
/*    */   extends __SUseGiftBagItemRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584763;
/*    */   public int itemid;
/*    */   public int usednum;
/*    */   public AwardBean awardbean;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584763;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUseGiftBagItemRes()
/*    */   {
/* 33 */     this.awardbean = new AwardBean();
/*    */   }
/*    */   
/*    */   public SUseGiftBagItemRes(int _itemid_, int _usednum_, AwardBean _awardbean_) {
/* 37 */     this.itemid = _itemid_;
/* 38 */     this.usednum = _usednum_;
/* 39 */     this.awardbean = _awardbean_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.awardbean._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.itemid);
/* 49 */     _os_.marshal(this.usednum);
/* 50 */     _os_.marshal(this.awardbean);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.itemid = _os_.unmarshal_int();
/* 56 */     this.usednum = _os_.unmarshal_int();
/* 57 */     this.awardbean.unmarshal(_os_);
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SUseGiftBagItemRes)) {
/* 67 */       SUseGiftBagItemRes _o_ = (SUseGiftBagItemRes)_o1_;
/* 68 */       if (this.itemid != _o_.itemid) return false;
/* 69 */       if (this.usednum != _o_.usednum) return false;
/* 70 */       if (!this.awardbean.equals(_o_.awardbean)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.itemid;
/* 79 */     _h_ += this.usednum;
/* 80 */     _h_ += this.awardbean.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.itemid).append(",");
/* 88 */     _sb_.append(this.usednum).append(",");
/* 89 */     _sb_.append(this.awardbean).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SUseGiftBagItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */