/*    */ package mzm.gsp.item;
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
/*    */ public class SResUseFumoItem
/*    */   extends __SResUseFumoItem__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584762;
/*    */   public EquipFumoInfo equipfumoinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584762;
/*    */   }
/*    */   
/*    */ 
/*    */   public SResUseFumoItem()
/*    */   {
/* 31 */     this.equipfumoinfo = new EquipFumoInfo();
/*    */   }
/*    */   
/*    */   public SResUseFumoItem(EquipFumoInfo _equipfumoinfo_) {
/* 35 */     this.equipfumoinfo = _equipfumoinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     if (!this.equipfumoinfo._validator_()) return false;
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.equipfumoinfo);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.equipfumoinfo.unmarshal(_os_);
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof SResUseFumoItem)) {
/* 59 */       SResUseFumoItem _o_ = (SResUseFumoItem)_o1_;
/* 60 */       if (!this.equipfumoinfo.equals(_o_.equipfumoinfo)) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.equipfumoinfo.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.equipfumoinfo).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SResUseFumoItem _o_) {
/* 81 */     if (_o_ == this) return 0;
/* 82 */     int _c_ = 0;
/* 83 */     _c_ = this.equipfumoinfo.compareTo(_o_.equipfumoinfo);
/* 84 */     if (0 != _c_) return _c_;
/* 85 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SResUseFumoItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */