/*    */ package mzm.gsp.activity;
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
/*    */ public class SSyncLegendTimeReward
/*    */   extends __SSyncLegendTimeReward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587544;
/*    */   public int itemid;
/*    */   public int itemnum;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12587544;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncLegendTimeReward() {}
/*    */   
/*    */ 
/*    */   public SSyncLegendTimeReward(int _itemid_, int _itemnum_)
/*    */   {
/* 37 */     this.itemid = _itemid_;
/* 38 */     this.itemnum = _itemnum_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.itemid);
/* 47 */     _os_.marshal(this.itemnum);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.itemid = _os_.unmarshal_int();
/* 53 */     this.itemnum = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSyncLegendTimeReward)) {
/* 63 */       SSyncLegendTimeReward _o_ = (SSyncLegendTimeReward)_o1_;
/* 64 */       if (this.itemid != _o_.itemid) return false;
/* 65 */       if (this.itemnum != _o_.itemnum) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.itemid;
/* 74 */     _h_ += this.itemnum;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.itemid).append(",");
/* 82 */     _sb_.append(this.itemnum).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncLegendTimeReward _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.itemid - _o_.itemid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.itemnum - _o_.itemnum;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SSyncLegendTimeReward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */