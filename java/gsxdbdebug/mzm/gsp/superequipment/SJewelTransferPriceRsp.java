/*    */ package mzm.gsp.superequipment;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
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
/*    */ public class SJewelTransferPriceRsp
/*    */   extends __SJewelTransferPriceRsp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618782;
/*    */   public HashMap<Integer, Float> jewelcfgid2price;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12618782;
/*    */   }
/*    */   
/*    */ 
/*    */   public SJewelTransferPriceRsp()
/*    */   {
/* 33 */     this.jewelcfgid2price = new HashMap();
/*    */   }
/*    */   
/*    */   public SJewelTransferPriceRsp(HashMap<Integer, Float> _jewelcfgid2price_) {
/* 37 */     this.jewelcfgid2price = _jewelcfgid2price_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.jewelcfgid2price.size());
/* 46 */     for (Map.Entry<Integer, Float> _e_ : this.jewelcfgid2price.entrySet()) {
/* 47 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 48 */       _os_.marshal(((Float)_e_.getValue()).floatValue());
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 56 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 58 */       float _v_ = _os_.unmarshal_float();
/* 59 */       this.jewelcfgid2price.put(Integer.valueOf(_k_), Float.valueOf(_v_));
/*    */     }
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SJewelTransferPriceRsp)) {
/* 70 */       SJewelTransferPriceRsp _o_ = (SJewelTransferPriceRsp)_o1_;
/* 71 */       if (!this.jewelcfgid2price.equals(_o_.jewelcfgid2price)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.jewelcfgid2price.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.jewelcfgid2price).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\SJewelTransferPriceRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */