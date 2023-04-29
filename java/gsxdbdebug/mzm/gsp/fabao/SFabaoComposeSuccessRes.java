/*    */ package mzm.gsp.fabao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.item.ItemInfo;
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
/*    */ public class SFabaoComposeSuccessRes
/*    */   extends __SFabaoComposeSuccessRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596023;
/*    */   public int key;
/*    */   public ItemInfo eqpinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12596023;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SFabaoComposeSuccessRes()
/*    */   {
/* 34 */     this.eqpinfo = new ItemInfo();
/*    */   }
/*    */   
/*    */   public SFabaoComposeSuccessRes(int _key_, ItemInfo _eqpinfo_) {
/* 38 */     this.key = _key_;
/* 39 */     this.eqpinfo = _eqpinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.eqpinfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.key);
/* 49 */     _os_.marshal(this.eqpinfo);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.key = _os_.unmarshal_int();
/* 55 */     this.eqpinfo.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SFabaoComposeSuccessRes)) {
/* 65 */       SFabaoComposeSuccessRes _o_ = (SFabaoComposeSuccessRes)_o1_;
/* 66 */       if (this.key != _o_.key) return false;
/* 67 */       if (!this.eqpinfo.equals(_o_.eqpinfo)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.key;
/* 76 */     _h_ += this.eqpinfo.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.key).append(",");
/* 84 */     _sb_.append(this.eqpinfo).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\SFabaoComposeSuccessRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */